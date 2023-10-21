package model;

import java.time.LocalDate;

public class Post {
    private static long serial = 0;
    private long id;
    private Pessoa pessoa;
    private String conteudo;
    private LocalDate dtCriacao;
    private LocalDate dtModificacao;

    public Post(){
        this.id = ++Post.serial;
    }
}
