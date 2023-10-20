package model.DAO;

import model.Alimento;
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
}
