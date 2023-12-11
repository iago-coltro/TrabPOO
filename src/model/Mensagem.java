package model;

import java.time.LocalDate;

public class Mensagem {
    private static long serial = -1;
    private long id;
    private Pessoa pOrigem;
    private Pessoa pDestino;
    private String conteudo;
    private LocalDate dtCriacao;
    private LocalDate dtModificacao;

    public Mensagem(){
        this.id = ++Mensagem.serial;
    }

    public static void setSerial(long serial) {
        Mensagem.serial = serial;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setpOrigem(Pessoa pOrigem) {
        this.pOrigem = pOrigem;
    }

    public void setpDestino(Pessoa pDestino) {
        this.pDestino = pDestino;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public void setDtModificacao(LocalDate dtModificacao) {
        this.dtModificacao = dtModificacao;
    }

    public static long getSerial() {
        return serial;
    }

    public long getId() {
        return id;
    }

    public Pessoa getpOrigem() {
        return pOrigem;
    }

    public Pessoa getpDestino() {
        return pDestino;
    }

    public String getConteudo() {
        return conteudo;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public LocalDate getDtModificacao() {
        return dtModificacao;
    }

    @Override
    public String toString() {
        return "\nId: " + pOrigem.getId() +
                "\nDe: " + pOrigem.getNome() +
                "\nPara: " + pDestino.getNome() +
                "\n\"" + conteudo + "\"";
    }
}
