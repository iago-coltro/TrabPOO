package model;

import java.time.LocalDate;

public class Post {
    private static long serial = -1;
    private long id;
    private Pessoa pessoa;
    private String conteudo;
    private LocalDate dtCriacao;
    private LocalDate dtModificacao;

    public Post(){
        this.id = ++Post.serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public LocalDate getDtModificacao() {
        return dtModificacao;
    }

    public void setDtModificacao(LocalDate dtModificacao) {
        this.dtModificacao = dtModificacao;
    }

    @Override
    public String toString() {
        return "\nUsuário: @" + pessoa.getNome() +
                "\nID: " + id +
                "\nTexto: " + conteudo +
                "\nDtCriacao: " + dtCriacao +
                "\nDtModificacao: " + dtModificacao;
    }
}
