package model;

import java.time.LocalDate;

public class Dieta {
    private static long serial = -1;
    private long id;
    private Pessoa pessoa;
    private AvaliacaoFisica avaliacaoFisica;
    private TipoDieta tipoDieta;
    private int objetivo;
    private double calorias;
    private int nroRefeicoes;
    private LocalDate dtCriacao;
    private LocalDate dtModificacao;
    private double proteina;
    private double carboidrato;
    private double gordura;

    public Dieta(){
        this.id = ++Dieta.serial;
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

    public AvaliacaoFisica getAvaliacaoFisica() {
        return avaliacaoFisica;
    }

    public void setAvaliacaoFisica(AvaliacaoFisica avaliacaoFisica) {
        this.avaliacaoFisica = avaliacaoFisica;
    }

    public TipoDieta getTipoDieta() {
        return tipoDieta;
    }

    public void setTipoDieta(TipoDieta tipoDieta) {
        this.tipoDieta = tipoDieta;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias() {
        this.calorias = avaliacaoFisica.getTmb() + this.objetivo;
    }

    public int getNroRefeicoes() {
        return nroRefeicoes;
    }

    public void setNroRefeicoes(int nroRefeicoes) {
        this.nroRefeicoes = nroRefeicoes;
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

    public void setObjetivo(int objetivo) {
        switch (objetivo){
            case 1:
                this.objetivo = -500;
                break;

            case 2:
                this.objetivo = 500;
                break;

            case 3:
                this.objetivo = 0;
                break;
        }
    }

    public int getObjetivo() {
        return objetivo;
    }

    public void macros(double calorias, TipoDieta td){
        this.proteina = (calorias * (td.getProteina()/100))/4;
        this.carboidrato = (calorias * (td.getCarboidrato()/100))/4;
        this.gordura = (calorias * (td.getGordura()/100))/9;
    }

    @Override
    public String toString() {
        return "\n\nResumo de sua dieta" +
                "\nID: " + id +
                "\nTipo de Dieta: " + tipoDieta.getNome() +
                "\nCalorias Totais: " + String.format("%.2f", this.calorias) +
                "\nProteinas: " + String.format("%.2f", this.proteina) + "g" +
                "\nCarboidratos: " + String.format("%.2f", this.carboidrato) + "g"+
                "\nGorduras: " + String.format("%.2f", this.gordura) + "g"+
                "\nNº Refeicoes: " + nroRefeicoes +
                "\ndtCriacao: " + dtCriacao +
                "\ndtModificacao: " + dtModificacao;
    }
}
