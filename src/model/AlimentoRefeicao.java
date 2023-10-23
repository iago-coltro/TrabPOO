package model;

import java.time.LocalDate;

public class AlimentoRefeicao {
    private static long serial = -1;
    private long id;
    private Pessoa pessoa;
    private Refeicoes refeicao;
    private Alimento alimento;
    private double porcao;
    private double prot;
    private double gord;
    private double carb;
    private double cal;
    private LocalDate dtCriacao;
    private LocalDate dtModificacao;
    public AlimentoRefeicao(){
        this.id = ++AlimentoRefeicao.serial;
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

    public Refeicoes getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicoes refeicao) {
        this.refeicao = refeicao;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public double getPorcao() {
        return porcao;
    }

    public void setPorcao(double porcao) {
        this.porcao = porcao;
    }

    public double getProt() {
        return prot;
    }

    public void setProt(double prot) {
        this.prot = prot;
    }

    public double getGord() {
        return gord;
    }

    public void setGord(double gord) {
        this.gord = gord;
    }

    public double getCarb() {
        return carb;
    }

    public void setCarb(double carb) {
        this.carb = carb;
    }

    public double getCal() {
        return cal;
    }

    public void setCal(double cal) {
        this.cal = cal;
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
/*
@Override
    public String toString() {
        return  "\nRefeicao: " + refeicao.getNomeRefeicao() +
                "\nAlimento: " + alimento.getNome() +
                "\nPorção: " + alimento.getPorcao() +
                "\nProteina: " + alimento.getProteina() +
                "\nGordura: " + alimento.getGordura() +
                "\nCarboidrato: " + alimento.getCarboidrato() +
                "\nCalorias: " + cal;
    }
 */

}
