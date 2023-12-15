/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import model.ConnectionFactory;
import model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author iagol
 */
public class PessoaDAO {

    //Pessoa[] pessoas = new Pessoa[5];

        private PreparedStatement criaConsulta(Connection con, String login, String senha) throws SQLException {
            String sql = "select * from pessoa where login = ? and senha = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            return ps;
        }


        public Pessoa buscaLogin(String login, String senha) {
            try (Connection connection = new ConnectionFactory().getConnection();
                 PreparedStatement ps = criaConsulta(connection, login, senha);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Pessoa elemento = new Pessoa();
                    elemento.setId(rs.getInt("id_pessoa"));
                    elemento.setNome(rs.getString("nome"));
                    elemento.setSexo(rs.getString("sexo"));
                    elemento.setLogin(rs.getString("login"));
                    elemento.setSenha(rs.getString("senha"));

                    java.sql.Date currentDateNasc = rs.getDate("dt_nascimento");
                    LocalDate dataNasc = currentDateNasc.toLocalDate();
                    elemento.setDtNascimento(String.valueOf(dataNasc));

                    java.sql.Date currentDateCria = rs.getDate("createDate");
                    LocalDate dataCria = currentDateCria.toLocalDate();
                    elemento.setDtCriacao(dataCria);

                    java.sql.Date currentDateMod = rs.getDate("modifyDate");
                    LocalDate dataMod = currentDateMod.toLocalDate();
                    elemento.setDtModificacao(dataMod);

                    return elemento;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return null;
        }

        //testar para ver se deu ceto
        public List<Pessoa> buscaTodos() {
            String sql = "select * from pessoa";
            try (Connection connection = new ConnectionFactory().getConnection();
                 PreparedStatement stmt = connection.prepareStatement(sql)) {
                List<Pessoa> pessoas = new ArrayList<>();
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    // criando o objeto
                    Pessoa elemento = new Pessoa();
                    elemento.setId(rs.getInt("id_pessoa"));
                    elemento.setNome(rs.getString("nome"));
                    elemento.setSexo(rs.getString("sexo"));
                    elemento.setLogin(rs.getString("login"));
                    elemento.setSenha(rs.getString("senha"));

                    java.sql.Date currentDateNasc = rs.getDate("dt_nascimento");
                    LocalDate dataNasc = currentDateNasc.toLocalDate();
                    elemento.setDtNascimento(String.valueOf(dataNasc));

                    java.sql.Date currentDateCria = rs.getDate("createDate");
                    LocalDate dataCria = currentDateCria.toLocalDate();
                    elemento.setDtCriacao(dataCria);

                    java.sql.Date currentDateMod = rs.getDate("modifyDate");
                    LocalDate dataMod = currentDateMod.toLocalDate();
                    elemento.setDtModificacao(dataMod);

                    pessoas.add(elemento);
                }
                rs.close();
                stmt.close();
                return pessoas;
            }catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        private static PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
            String sql = "select * from pessoa where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            return ps;
        }

        public static Pessoa buscaPorID(long code) {
            try (Connection connection = new ConnectionFactory().getConnection();
                 PreparedStatement ps = createPreparedStatement(connection, code);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Pessoa elemento = new Pessoa();
                    elemento.setId(rs.getInt("id_pessoa"));
                    elemento.setNome(rs.getString("nome"));
                    elemento.setSexo(rs.getString("sexo"));
                    elemento.setLogin(rs.getString("login"));
                    elemento.setSenha(rs.getString("senha"));

                    java.sql.Date dataNasc = rs.getDate("dt_nascimento");
                    LocalDate dataCriacaoDate = dataNasc.toLocalDate();
                    elemento.setDtNascimento(String.valueOf(dataCriacaoDate));

                    java.sql.Date currentDate = rs.getDate("createDate");
                    LocalDate dataCriacao = currentDate.toLocalDate();
                    elemento.setDtCriacao(dataCriacao);

                    java.sql.Date currentDateMod = rs.getDate("modifyDate");
                    LocalDate dataMod = currentDateMod.toLocalDate();
                    elemento.setDtModificacao(dataMod);

                    return elemento;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
    }
        /*Pessoa p1 = new Pessoa();
        p1.setNome("iago");
        p1.setSexo("masculino");
        p1.setDtNascimento("18/10/2001");
        p1.setLogin("teste");
        p1.setSenha("123");
        this.adiciona(p1);


        Pessoa p2 = new Pessoa();
        p2.setNome("diego");
        p2.setSexo("masculino");
        p1.setDtNascimento("06/04/2000");
        p2.setLogin("teste2");
        p2.setSenha("123");
        this.adiciona(p2);

    }    
   
    public boolean adiciona(Pessoa p) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            pessoas[proximaPosicaoLivre] = p;
            return true;
        } else {
            return false;
        }
     }
     
       public int proximaPosicaoLivre() {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] == null) {
                return i;
            }
        }    
        return -1;
    }
       
    public Pessoa buscaUsuarioLogin(String login, String senha) {
        for (Pessoa p : pessoas) {
            if (p != null && p.getLogin().equals(login) && p.getSenha().equals(senha)) {
                return p;
            }
        }
        return null;
    }

    public Pessoa buscaPorNome(String nome) {
        for (Pessoa p : pessoas) {
            if (p != null && p.getNome().equalsIgnoreCase(nome)){
                return p;
            }
        }
        return null;
    }
    public void mostraPessoa(Pessoa p) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                if (!pessoas[i].getNome().equals(p.getNome())){
                    System.out.println(pessoas[i].toString());
                }
            }
        }
    }

         */

