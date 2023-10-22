package model.DAO;

import model.Pessoa;

public class SeguidorDAO {
    Seguidor seguidores[] = new Seguidor[10];
    public SeguidorDAO(PessoaDAO pessoa, PostDAO posts) {

        /*
        Seguidor s1 = new Seguidor();
        s1.setPessoa(pessoa.buscaPorNome("iago"));
        s1.setSeguidores(pessoa.buscaPorNome("diego"));
        adicionaSeguidor(s1);
         */

        Seguidor s2 = new Seguidor();
        s2.setPessoa(pessoa.buscaPorNome("diego"));
        s2.setSeguidores(pessoa.buscaPorNome("iago"));
        adicionaSeguidor(s2);

    }
    private int proximoSeguidorLivre(){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i] == null){
                return i;
            }
        }
        return -1;
    }

    public boolean adicionaSeguidor(Seguidor s){
        int proximoSeguidorLivre = proximoSeguidorLivre();
        if(proximoSeguidorLivre != -1){
            seguidores[proximoSeguidorLivre] = s;
            return true;
        } else {
            return false;
        }
    }

    public Pessoa buscaSeguidorPessoa(Pessoa p) {
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i] != null && seguidores[i].getPessoa().getId() == p.getId()){
                return seguidores[i].getSeguidores();
            }
        }
        return null;

    }

    public void mostraSeguidoresPessoa(Pessoa p){
        for (int i = 0; i < seguidores.length; i++) {
            if (seguidores[i] != null) {
                if (seguidores[i].getPessoa().getNome().equals(p.getNome())) {
                    System.out.print(seguidores[i].toString());
                }
            }
        }
    }

    public boolean removeSeguidor(long id){
        for (int i = 0; i < seguidores.length; i++) {
            if(seguidores[i].getId() == id){
                seguidores[i] = null;
                return true;
            }
        }
        return false;
    }


}
