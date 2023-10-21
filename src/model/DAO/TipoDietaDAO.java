package model.DAO;

import model.Alimento;
import model.Pessoa;
import model.TipoDieta;

public class TipoDietaDAO {
    TipoDieta tipodieta[] = new TipoDieta[4];

    public TipoDietaDAO(){
        TipoDieta tp1 = new TipoDieta();
        tp1.setNome("Equilibrada");
        tp1.setCarboidrato(40);
        tp1.setProteina(30);
        tp1.setGordura(30);
        this.adicionaTpDieta(tp1);

        TipoDieta tp2 = new TipoDieta();
        tp2.setNome("Low Carb");
        tp2.setCarboidrato(30);
        tp2.setProteina(50);
        tp2.setGordura(20);
        this.adicionaTpDieta(tp2);

        TipoDieta tp3 = new TipoDieta();
        tp3.setNome("Cetogenica");
        tp3.setCarboidrato(15);
        tp3.setProteina(15);
        tp3.setGordura(70);
        this.adicionaTpDieta(tp3);

        /*
        TipoDieta tp4 = new TipoDieta();
        tp4.setNome("Atleta");
        tp4.setCarboidrato(restante);
        tp4.setProteina(2*peso);
        tp4.setGordura(0,8*peso);
        this.adicionaTpDieta(tp4);
         */
    }
    public boolean adicionaTpDieta(TipoDieta td) {
        int proxPosicaoLivreTpDieta = this.proxPosicaoLivreTpDieta();
        if (proxPosicaoLivreTpDieta != -1) {
            tipodieta[proxPosicaoLivreTpDieta] = td;
            return true;
        } else {
            return false;
        }
    }

    public int proxPosicaoLivreTpDieta() {
        for (int i = 0; i < tipodieta.length; i++) {
            if (tipodieta[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void mostraTipoDieta(){
        for (TipoDieta td : tipodieta){
            if(td != null){
                System.out.println("\n" + td.toString());
            }
        }

    }

    public void mostraNomeTipoDieta(){
        for (TipoDieta td : tipodieta){
            if(td != null){
                System.out.println(td.getNome());
            }
        }

    }
    public TipoDieta buscaPorNome(String nome) {
        for (TipoDieta tp : tipodieta) {
            if (tp != null && tp.getNome().equalsIgnoreCase(nome)){
                return tp;
            }
        }
        return null;
    }
}
