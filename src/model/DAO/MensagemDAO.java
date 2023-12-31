package model.DAO;

import model.Mensagem;
import model.Pessoa;

public class MensagemDAO {
    Mensagem mensagens[] = new Mensagem[10];

    public MensagemDAO(PessoaDAO p1) {
        Mensagem m1 = new Mensagem();
        m1.setConteudo("Opaa,blz?");
        m1.setpOrigem(p1.buscaPorNome("iago"));
        m1.setpDestino(p1.buscaPorNome("diego"));
        criaMensagem(m1);

        Mensagem m2 = new Mensagem();
        m2.setConteudo("Joia!");
        m2.setpOrigem(p1.buscaPorNome("diego"));
        m2.setpDestino(p1.buscaPorNome("iago"));
        criaMensagem(m2);
    }

    private int proximMensagemLivre() {
        for (int i = 0; i < mensagens.length; i++) {
            if (mensagens[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean criaMensagem(Mensagem a) {
        int proximMensagemLivre = proximMensagemLivre();
        if (proximMensagemLivre != -1) {
            mensagens[proximMensagemLivre] = a;
            return true;
        } else {
            return false;
        }
    }

    public void mostraMensagemEnviada(Pessoa p){
        for (int i = 0; i < mensagens.length; i++) {
            if(mensagens[i] != null && mensagens[i].getpOrigem().getId() == p.getId()){
                System.out.println(mensagens[i]);
            }
        }
    }

    public void mostraMensagemRecebida(Pessoa p){
        for (int i = 0; i < mensagens.length; i++) {
            if(mensagens[i] != null && mensagens[i].getpDestino().getId() == p.getId()){
                System.out.println(mensagens[i]);
            }
        }
    }

    public void mostraTodasMensagens() {
        for (int i = 0; i < mensagens.length; i++) {
            if (mensagens[i] != null) {
                System.out.println(mensagens[i]);
            }

        }
    }

    public boolean removeMensagens(long id) {
        for (int i = 0; i < mensagens.length; i++) {
            if (mensagens[i].getId() == id) {
                mensagens[i] = null;
                return true;
            }
        }
        return false;
    }

}
