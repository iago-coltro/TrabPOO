package model.DAO;

import model.Pessoa;
import model.Post;

import java.time.LocalDate;

public class PostDAO {
    Post posts[] = new Post[20];

    public PostDAO(PessoaDAO p1) {
        Post post1 = new Post();
        post1.setConteudo ("Esse é meu primeiro Post");
        post1.setPessoa(p1.buscaPorNome("iago"));
        post1.setDtCriacao(LocalDate.now());
        post1.setDtModificacao(LocalDate.now());
        adicionaPost(post1);

        Post post2 = new Post();
        post2.setConteudo ("Trabalho de POO");
        post2.setPessoa(p1.buscaPorNome("diego"));
        post2.setDtCriacao(LocalDate.now());
        post2.setDtModificacao(LocalDate.now());
        adicionaPost(post2);

    }
    private int proximoPostLivre() {
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean adicionaPost(Post j) {
        int proximoPostLivre = proximoPostLivre();
        if (proximoPostLivre != -1) {
            posts[proximoPostLivre] = j;
            return true;
        } else {
            return false;
        }
    }

    public String pegaPostPessoa(Pessoa p) {
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] != null && posts[i].getPessoa().getNome().equals(p.getNome())) {
                return posts[i].getConteudo();
            }
        }
        return null;
    }

    public void mostraTodosPostPessoa(Pessoa p) {
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] != null && posts[i].getPessoa().getNome().equals(p.getNome())) {
                System.out.println(posts[i]);
            }
        }
    }

    public boolean removePost(long id, Pessoa p) {
        for (int i = 0; i < posts.length; i++) {
            if (posts[i] != null && posts[i].getId() == id && posts[i].getPessoa().getId() == p.getId()) {
                posts[i] = null;
                return true;
            }
        }
        return false;
    }
}
