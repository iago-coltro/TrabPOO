package model;

import java.time.LocalDate;

public class Refeicoes {
    private static long serial = -1;
    private long id;
    private Dieta d;
    private double proteina;
    private double carboidrato;
    private double gordura;
    private double calorias;
    private String nomeRefeicao;
    private LocalDate dtCriacao;
    private LocalDate dtModificacao;
    public Refeicoes(){
        this.id = ++Refeicoes.serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dieta getD() {
        return d;
    }

    public void setD(Dieta d) {
        this.d = d;
    }

    public double getProteina() {
        return proteina;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias() {
        this.calorias = (4*this.carboidrato)+(4*this.proteina)+(9*this.gordura);
    }

    public String getNomeRefeicao() {
        return nomeRefeicao;
    }

    public void setNomeRefeicao(String nomeRefeicao) {
        this.nomeRefeicao = nomeRefeicao;
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
        return "\nID: " + id +
                "\nNome da Refeicao: " + nomeRefeicao +
                "\nDieta: " + d +
                "\nProteina: " + proteina +
                "\nCarboidrato: " + carboidrato +
                "\nGordura: " + gordura +
                "\nCalorias: " + calorias +
                "\nDtCriacao=" + dtCriacao +
                "\nDtModificacao=" + dtModificacao;
    }
}
