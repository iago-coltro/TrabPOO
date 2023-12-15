package model.DAO;

import model.ConnectionFactory;
import model.Dieta;
import model.TipoDieta;
import model.Pessoa;

import java.sql.*;
import java.time.LocalDate;

public class DietaDAO {

    public long insereDieta(Dieta d) {
        String sql = "insert into dieta(pessoa, avaliacaoFisica, tipoDieta, objetivo, calorias) values (?,?,?,?,?)";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, String.valueOf(d.getPessoa().getId()));
            stmt.setString(2, String.valueOf(d.getAvaliacaoFisica().getId()));
            stmt.setString(3, String.valueOf(d.getTipoDieta().getId()));
            stmt.setString(4, d.getObjetivo());
            stmt.setString(5, String.valueOf(d.getCalorias()));
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
            throw new RuntimeException(e);
        }
    }

    private PreparedStatement createPreparedStatementLast(Connection con, long id) throws SQLException {
        String sql = "select * from dieta where id = ? order by id desc limit 1";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    public Dieta buscaUltimaDieta(long idUsuario) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatementLast(connection, idUsuario);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Dieta dieta = new Dieta();
                dieta.setId(rs.getLong("id"));
                long pessoaId = Long.parseLong(rs.getString("pessoa"));
                dieta.setPessoa(pessoaDAO.buscaPorID(pessoaId));
                dieta.setAvaliacaoFisica(avaliacaoFisicaDAO.buscaAvaliacao(Long.parseLong(rs.getString("avaliacaoFisica"))));
                dieta.setTipoDieta(tipoDietaDAO.buscaTipoDietaPorId(Long.parseLong(rs.getString("tipoDieta"))));
                dieta.setObjetivo(rs.getString("objetivo"));
                dieta.setCalorias(Double.parseDouble(rs.getString("calorias")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                dieta.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                dieta.setDataModificacao(dataMod);

                return dieta;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a última dieta!" + e);
        }
        return null;
    }

    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from dieta where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }
    public Dieta buscaDietaPorId(long idDieta) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatement(connection, idDieta);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Dieta dieta = new Dieta();
                dieta.setId(rs.getLong("id"));
                long pessoaId = Long.parseLong(rs.getString("pessoa"));
                dieta.setPessoa(pessoaDAO.buscaPorID(pessoaId));
                dieta.setAvaliacaoFisica(avaliacaoFisicaDAO.buscaAvaliacao(Long.parseLong(rs.getString("avaliacaoFisica"))));
                dieta.setTipoDieta(tipoDietaDAO.buscaTipoDietaPorId(Long.parseLong(rs.getString("tipoDieta"))));
                dieta.setObjetivo(rs.getString("objetivo"));
                dieta.setCalorias(Double.parseDouble(rs.getString("calorias")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                dieta.setDataCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                dieta.setDataModificacao(dataMod);

                return dieta;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar a última avaliação física!" + e);
        }
        return null;
    }
    /*
    Dieta dietas[] = new Dieta[6];

    private int proximaDietaLivre() {
        for (int i = 0; i < dietas.length; i++) {
            if (dietas[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean criaDieta(Dieta d) {
        int proximaDietaLivre = proximaDietaLivre();
        if (proximaDietaLivre != -1) {
            dietas[proximaDietaLivre] = d;
            return true;
        } else {
            return false;
        }
    }

    public void mostraDieta() {
        for (int i = 0; i < dietas.length; i++) {
            if (dietas[i] != null) {
                System.out.println(dietas[i].toString());
            }

        }
    }
    public Dieta buscaDietaId(long id){
        for (int i = 0; i < dietas.length; i++) {
            if(dietas[i] != null && dietas[i].getId() == id)
                return dietas[i];
        }
        return null;
    }

     */
}
