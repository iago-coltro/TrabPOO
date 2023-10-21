package model.DAO;

import model.Refeicoes;

import java.time.LocalDate;

public class RefeicoesDAO {
    Refeicoes refeicoes[] = new Refeicoes[6];
    public RefeicoesDAO(TipoDietaDAO td){
        Refeicoes rf1 = new Refeicoes();
        rf1.setNomeRefeicao("Cafe da manha");
        rf1.setCarboidrato(60);
        rf1.setGordura(45);
        rf1.setProteina(45);
        rf1.setCalorias();
        rf1.setDtCriacao(LocalDate.now());
        rf1.setDtModificacao(LocalDate.now());
        criaRefeicao(rf1);

        Refeicoes rf2 = new Refeicoes();
        rf2.setNomeRefeicao("Almoço");
        rf2.setCarboidrato(60);
        rf2.setGordura(45);
        rf2.setProteina(45);
        rf2.setCalorias();
        rf2.setDtCriacao(LocalDate.now());
        rf2.setDtModificacao(LocalDate.now());
        criaRefeicao(rf2);

        Refeicoes rf3 = new Refeicoes();
        rf3.setNomeRefeicao("Lanche da Tarde");
        rf3.setCarboidrato(60);
        rf3.setGordura(45);
        rf3.setProteina(45);
        rf3.setCalorias();
        rf3.setDtCriacao(LocalDate.now());
        rf3.setDtModificacao(LocalDate.now());
        criaRefeicao(rf3);

        Refeicoes rf4 = new Refeicoes();
        rf4.setNomeRefeicao("Janta");
        rf4.setCarboidrato(60);
        rf4.setGordura(45);
        rf4.setProteina(45);
        rf4.setCalorias();
        rf4.setDtCriacao(LocalDate.now());
        rf4.setDtModificacao(LocalDate.now());
        criaRefeicao(rf4);

    }
    private int proximaRefeicaoLivre() {
        for (int i = 0; i < refeicoes.length; i++) {
            if (refeicoes[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean criaRefeicao(Refeicoes rf) {
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
                System.out.println(refeicoes[i]);
            }

        }
    }
}
