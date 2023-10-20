/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import model.Pessoa;

/**
 *
 * @author iagol
 */
public class PessoaDAO {

    Pessoa[] pessoas = new Pessoa[5];

    public PessoaDAO() {
        Pessoa p1 = new Pessoa();
        p1.setNome("iago");
        p1.setSexo("masculino");
        p1.setDtNascimento("18/10/2001");
        p1.setLogin("teste");
        p1.setSenha("123");
        p1.setId(1);
        this.adiciona(p1);

        /*
        Pessoa p2 = new Pessoa();
        p2.setNome("maria");
        p1.setSexo("feminino");
        p1.setDtNascimento("06/04/2000");
        p2.setLogin("teste2");
        p2.setSenha("123");
        p2.setId(2);
        this.adiciona(p2);
        */

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


}
