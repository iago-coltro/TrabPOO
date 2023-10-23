package model.DAO;

import model.AvaliacaoFisica;
import model.Dieta;
import model.Pessoa;
import model.Refeicoes;

import java.time.LocalDate;

public class RefeicoesDAO {
    Refeicoes refeicoes[] = new Refeicoes[6];
    public RefeicoesDAO(){
        Refeicoes rf1 = new Refeicoes();
        rf1.setNomeRefeicao("Cafe da manha");
        rf1.setCarboidrato(56.34);
        rf1.setGordura(18.78);
        rf1.setProteina(42.25);
        rf1.setCalorias();
        rf1.setDtCriacao(LocalDate.now());
        rf1.setDtModificacao(LocalDate.now());
        AdicionaRefeicao(rf1);

        Refeicoes rf2 = new Refeicoes();
        rf2.setNomeRefeicao("Almoço");
        rf2.setCarboidrato(56.34);
        rf2.setGordura(18.78);
        rf2.setProteina(42.25);
        rf2.setCalorias();
        rf2.setDtCriacao(LocalDate.now());
        rf2.setDtModificacao(LocalDate.now());
        AdicionaRefeicao(rf2);

        Refeicoes rf3 = new Refeicoes();
        rf3.setNomeRefeicao("Lanche da Tarde");
        rf3.setCarboidrato(56.34);
        rf3.setGordura(18.78);
        rf3.setProteina(42.25);
        rf3.setCalorias();
        rf3.setDtCriacao(LocalDate.now());
        rf3.setDtModificacao(LocalDate.now());
        AdicionaRefeicao(rf3);

        Refeicoes rf4 = new Refeicoes();
        rf4.setNomeRefeicao("Janta");
        rf4.setCarboidrato(56.34);
        rf4.setGordura(18.78);
        rf4.setProteina(42.25);
        rf4.setCalorias();
        rf4.setDtCriacao(LocalDate.now());
        rf4.setDtModificacao(LocalDate.now());
        AdicionaRefeicao(rf4);

    }
    private int proximaRefeicaoLivre() {
        for (int i = 0; i < refeicoes.length; i++) {
            if (refeicoes[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean AdicionaRefeicao(Refeicoes rf) {
        int proximaRefeicaoLivre = proximaRefeicaoLivre();
        if (proximaRefeicaoLivre != -1) {
            refeicoes[proximaRefeicaoLivre] = rf;
            return true;
        } else {
            return false;
        }
    }

    public void mostraRefeicao() {
        for (int i = 0; i < refeicoes.length; i++) {
            if (refeicoes[i] != null) {
                System.out.println(refeicoes[i].toString());
            }

        }
    }

    public void mostraNomeRefeicao() {
        for (int i = 0; i < refeicoes.length; i++) {
            if (refeicoes[i] != null) {
                System.out.println("Id: " + refeicoes[i].getId() + " Nome: " + refeicoes[i].getNomeRefeicao());
            }
        }
    }

    public Refeicoes minhasRefeicoes(Dieta d){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i] != null && refeicoes[i].getD() == (d)){
                return refeicoes[i];
            }
        }
        return null;
    }

    public boolean removeRefeicaoID(long id) {
        for (int i = 0; i < refeicoes.length; i++) {
            if (refeicoes[i].getId() == id) {
                refeicoes[i] = null;
                return true;
            }
        }
        return false;
    }

    public Refeicoes buscaPorId(long id){
        for (int i = 0; i < refeicoes.length; i++) {
            if(refeicoes[i] != null && refeicoes[i].getId() == id)
                return refeicoes[i];
        }
        return null;
    }
}
