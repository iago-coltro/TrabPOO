/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import model.ConnectionFactory;
import model.Alimento;
import model.AvaliacaoFisica;
import model.Pessoa;

import java.sql.*;
import java.time.LocalDate;

/**
 *
 * @author iagol
 */

public class AvaliacaoFisicaDAO {

    public AvaliacaoFisicaDAO(PessoaDAO pessoadao) {
    }

    public long adicionaAvaliacao(AvaliacaoFisica af) {
        String sql = "insert into avaliacao_fisica(peso, altura, idade, pescoco, cintura, tx_atividade, quadril, tmb, imc,  bf, createDate, modifyDate, pessoa_idpessoa) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, String.valueOf(af.getPeso()));
            stmt.setString(2, String.valueOf(af.getAltura()));
            stmt.setString(3, String.valueOf(af.getIdade()));
            stmt.setString(4, String.valueOf(af.getPescoco()));
            stmt.setString(5, String.valueOf(af.getCintura()));
            stmt.setString(6, String.valueOf(af.getTxAtividade()));
            stmt.setString(7, String.valueOf(af.getQuadril()));
            stmt.setString(8, String.valueOf(af.getTmb()));
            stmt.setString(9, String.valueOf(af.getImc()));
            stmt.setString(10, String.valueOf(af.getBf()));
            stmt.setString(11, String.valueOf(af.getDtCriacao()));
            stmt.setString(12, String.valueOf(af.getDtModificacao()));
            stmt.setString(13, String.valueOf(af.getPessoa().getId()));
            stmt.execute();

            //retorna o id do objeto inserido
            ResultSet rs=stmt.getGeneratedKeys();
            int retorno=0;
            if(rs.next()){
                retorno = rs.getInt(1);
            }
            System.out.println("O id inserido foi: " + retorno);
            System.out.println("Gravado!");
            return retorno;
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível inserir a avaliação física!" + e);
        }
    }

    private PreparedStatement createPreparedStatementLast(Connection con, long id) throws SQLException {
        String sql = "select * from avaliacaofisica where id = ? order by id desc limit 1";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    public AvaliacaoFisica buscaUltimaAvaliacao(long idUsuario) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatementLast(connection, idUsuario);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
                avaliacaoFisica.setId((int) rs.getLong("id_avaliacao"));
                long pessoaId = Long.parseLong(rs.getString("pessoa_idpessoa"));
                avaliacaoFisica.setPessoa(PessoaDAO.buscaPorID(pessoaId));
                avaliacaoFisica.setTxAtividade(Double.parseDouble(rs.getString("tx_atividade")));
                avaliacaoFisica.setPeso(Double.parseDouble(rs.getString("peso")));
                avaliacaoFisica.setAltura(Double.parseDouble(rs.getString("altura")));
                avaliacaoFisica.setIdade(Integer.parseInt(rs.getString("idade")));
                avaliacaoFisica.setPescoco(Integer.parseInt(rs.getString("pescoco")));
                avaliacaoFisica.setCintura(Integer.parseInt(rs.getString("cintura")));
                avaliacaoFisica.setQuadril(Integer.parseInt(rs.getString("quadril")));
                avaliacaoFisica.setImc(Double.parseDouble(rs.getString("imc")));
                avaliacaoFisica.setTmb(Double.parseDouble(rs.getString("tmb")));
                avaliacaoFisica.setBf(Double.parseDouble(rs.getString("bof")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                avaliacaoFisica.setDtCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataModificacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                avaliacaoFisica.setDtModificacao(dataMod);

                return avaliacaoFisica;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a última avaliação física!" + e);
        }
        return null;
    }

    /*AvaliacaoFisica[] avaliacoes = new AvaliacaoFisica[10];

    public AvaliacaoFisicaDAO(PessoaDAO pessoadao){
    AvaliacaoFisica af1 = new AvaliacaoFisica();
    af1.setPessoa(pessoadao.buscaPorID(1));
    af1.setPeso(73);
    af1.setAltura(172);
    af1.setIdade(22);
    af1.setPescoco(30);
    af1.setQuadril(70);
    af1.setCintura(68);
    af1.setRotina(3);
    af1.calcBF();
    af1.calcIMC();
    af1.calcTMB();
    adicionaAvaliacao(af1);

    AvaliacaoFisica af2 = new AvaliacaoFisica();
    af2.setPessoa(pessoadao.buscaPorNome("diego"));
    af2.setPeso(68);
    af2.setAltura(168);
    af2.setIdade(22);
    af2.setPescoco(25);
    af2.setQuadril(68);
    af2.setCintura(66);
    af2.setRotina(2);
    af2.calcBF();
    af2.calcIMC();
    af2.calcTMB();
    adicionaAvaliacao(af2);
    }

    public boolean adicionaAvaliacao(AvaliacaoFisica af) {
        int proxPosicaoLivreAvFisica = this.proxPosicaoLivreAvFisica();
        if (proxPosicaoLivreAvFisica != -1) {
            avaliacoes[proxPosicaoLivreAvFisica] = af;
            return true;
        } else {
            return false;
        }
    }

    public int proxPosicaoLivreAvFisica() {
        for (int i = 0; i < avaliacoes.length; i++) {
            if (avaliacoes[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void mostraAvaliacoes(){
        for (AvaliacaoFisica af : avaliacoes){
            if(af != null){
                System.out.println("\n" + af.toString());
            }
        }

    }

    public AvaliacaoFisica minhaAvaliacao(Pessoa p){
        for (int i = 0; i < avaliacoes.length; i++) {
            if(avaliacoes[i] != null && avaliacoes[i].getPessoa().getNome().equals(p.getNome())){
                return avaliacoes[i];
            }
        }
        return null;
    }*/

}
