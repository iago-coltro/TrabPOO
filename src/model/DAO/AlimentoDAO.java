package model.DAO;

import model.Alimento;

import java.time.LocalDate;

public class AlimentoDAO {

    Alimento [] alimentos = new Alimento[20];

    public AlimentoDAO(){

        Alimento a1 = new Alimento();
        a1.setNome("Arroz");
        a1.setCarboidrato(45.0);
        a1.setProteina(2.0);
        a1.setGordura(0.5);
        a1.setPorcao(100);
        a1.setDtCriacao(LocalDate.now());
        a1.setDtModificacao(LocalDate.now());
        this.adicionaAlimento(a1);

        Alimento a2 = new Alimento();
        a2.setNome("Feijão");
        a2.setCarboidrato(20.0);
        a2.setProteina(5.0);
        a2.setGordura(0.6);
        a2.setPorcao(100);
        a2.setDtCriacao(LocalDate.now());
        a2.setDtModificacao(LocalDate.now());
        this.adicionaAlimento(a2);

        Alimento a3 = new Alimento();
        a3.setNome("Frango");
        a3.setCarboidrato(0.0);
        a3.setProteina(25.0);
        a3.setGordura(0.5);
        a3.setPorcao(100);
        a3.setDtCriacao(LocalDate.now());
        a3.setDtModificacao(LocalDate.now());
        this.adicionaAlimento(a3);

        Alimento a4 = new Alimento();
        a4.setNome("Ovo");
        a4.setCarboidrato(1.0);
        a4.setProteina(6.0);
        a4.setGordura(5.0);
        a4.setPorcao(100);
        a4.setDtCriacao(LocalDate.now());
        a4.setDtModificacao(LocalDate.now());
        this.adicionaAlimento(a4);
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

    public boolean removeAlimentosID(long id) {
        for (int i = 0; i < alimentos.length; i++) {
            if (alimentos[i].getId() == id) {
                alimentos[i] = null;
                return true;
            }
        }
        return false;
    }
}
