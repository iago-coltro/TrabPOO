package model.DAO;

import model.Dieta;
import model.TipoDieta;
import model.Pessoa;

public class DietaDAO {
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
}
