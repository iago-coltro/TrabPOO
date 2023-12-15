package model.DAO;

import model.Alimento;
import model.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlimentoDAO {

    private PreparedStatement createPreparedStatement(Connection con, long id) throws SQLException {
        String sql = "select * from alimento where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
    }

    public Alimento buscaAlimentoPorId(long code) {
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement ps = createPreparedStatement(connection, code);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Alimento alimento = new Alimento();
                alimento.setId(rs.getLong("id"));
                alimento.setNome(rs.getString("nome"));
                alimento.setCarboidrato(Double.parseDouble(rs.getString("carboidratos")));
                alimento.setProteina(Double.parseDouble(rs.getString("proteinas")));
                alimento.setGordura(Double.parseDouble(rs.getString("gorduras")));
                alimento.setCalorias(Double.parseDouble(rs.getString("calorias")));
                alimento.setPorcao(Double.parseDouble(rs.getString("porcao")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                alimento.setDtCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                alimento.setDtModificacao(dataMod);

                return alimento;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Alimento> buscaTodosAlimentos() {
        String sql = "select * from alimento";
        try (Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            List<Alimento> alimentos = new ArrayList<>();
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                // criando o objeto
                Alimento alimento = new Alimento();
                alimento.setId(rs.getLong("id"));
                alimento.setNome(rs.getString("nome"));
                alimento.setCarboidrato(Double.parseDouble(rs.getString("carboidratos")));
                alimento.setProteina(Double.parseDouble(rs.getString("proteinas")));
                alimento.setGordura(Double.parseDouble(rs.getString("gorduras")));
                alimento.setCalorias(Double.parseDouble(rs.getString("calorias")));
                alimento.setPorcao(Double.parseDouble(rs.getString("porcao")));

                java.sql.Date currentDate = rs.getDate("dataCriacao");
                LocalDate dataCriacao = currentDate.toLocalDate();
                alimento.setDtCriacao(dataCriacao);

                java.sql.Date currentDateMod = rs.getDate("dataAtualizacao");
                LocalDate dataMod = currentDateMod.toLocalDate();
                alimento.setDtModificacao(dataMod);

                alimentos.add(alimento);
            }
            rs.close();
            stmt.close();
            return alimentos;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*Alimento [] alimentos = new Alimento[20];
    public AlimentoDAO(){

        Alimento a1 = new Alimento();
        a1.setNome("Arroz");
        a1.setCarboidrato(25.8);
        a1.setProteina(2.6);
        a1.setGordura(1.0);
        a1.setPorcao(100);
        a1.setDtCriacao(LocalDate.now());
        a1.setDtModificacao(LocalDate.now());
        this.adicionaAlimento(a1);

        Alimento a2 = new Alimento();
        a2.setNome("Feijão");
        a2.setCarboidrato(13.6);
        a2.setProteina(4.8);
        a2.setGordura(0.5);
        a2.setPorcao(100);
        a2.setDtCriacao(LocalDate.now());
        a2.setDtModificacao(LocalDate.now());
        this.adicionaAlimento(a2);

        Alimento a3 = new Alimento();
        a3.setNome("Frango");
        a3.setCarboidrato(0.0);
        a3.setProteina(28.0);
        a3.setGordura(7.5);
        a3.setPorcao(100);
        a3.setDtCriacao(LocalDate.now());
        a3.setDtModificacao(LocalDate.now());
        this.adicionaAlimento(a3);

        Alimento a4 = new Alimento();
        a4.setNome("Ovo");
        a4.setCarboidrato(0.6);
        a4.setProteina(13.3);
        a4.setGordura(9.5);
        a4.setPorcao(100);
        a4.setDtCriacao(LocalDate.now());
        a4.setDtModificacao(LocalDate.now());
        this.adicionaAlimento(a4);

        Alimento a5 = new Alimento();
        a5.setNome("Pão");
        a5.setCarboidrato(49.9);
        a5.setProteina(9.4);
        a5.setGordura(3.7);
        a5.setPorcao(100);
        a5.setDtCriacao(LocalDate.now());
        a5.setDtModificacao(LocalDate.now());
        this.adicionaAlimento(a5);

        Alimento a6 = new Alimento();
        a6.setNome("Banana");
        a6.setCarboidrato(26.0);
        a6.setProteina(1.3);
        a6.setGordura(0.1);
        a6.setPorcao(100);
        a6.setDtCriacao(LocalDate.now());
        a6.setDtModificacao(LocalDate.now());
        this.adicionaAlimento(a6);

        Alimento a7 = new Alimento();
        a7.setNome("Aveia");
        a7.setCarboidrato(66.6);
        a7.setProteina(13.9);
        a7.setGordura(8.5);
        a7.setPorcao(100);
        a7.setDtCriacao(LocalDate.now());
        a7.setDtModificacao(LocalDate.now());
        this.adicionaAlimento(a7);
    }

    public boolean adicionaAlimento(Alimento a) {
        int proxPosicaoLivreAlimentos = this.proxPosicaoLivreAlimentos();
        if (proxPosicaoLivreAlimentos != -1) {
            alimentos[proxPosicaoLivreAlimentos] = a;
            return true;
        } else {
            return false;
        }
    }

    public int proxPosicaoLivreAlimentos() {
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void mostraAlimentos(){
        for (Alimento a : alimentos){
            if(a != null){
                System.out.println("\n" + a.toString());
            }
        }

    }

    public void mostraNomeAlimentos(){
        for (Alimento a : alimentos){
            if(a != null){
                System.out.println("id: "+ a.getId() + " Nome: " + a.getNome());
            }
        }

    }

    public boolean removeAlimentosID(long id) {
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i].getId() == id) {
                alimentos[i] = null;
                return true;
            }
        }
        return false;
    }

    public Alimento BuscaAlimentoID(long id){
        for (int i = 0; i < alimentos.length; i++) {
            if(alimentos[i] != null && alimentos[i].getId() == id){
                return alimentos[i];
            }

        }
        return null;*/
}
