/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author iagol
 */
public class Alimento {
    private static long serial = -1;
    private long id;
    private String nome;
    private double carboidrato;
    private double gordura;
    private double proteina;
    private double calorias;
    private double porcao;
    private LocalDate dtCriacao;
    private LocalDate dtModificacao;

    public Alimento(){
        this.id = ++Alimento.serial;
    }

    public static void setSerial(long serial) {
        Alimento.serial = serial;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCarboidrato(double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public void setPorcao(double porcao) {
        this.porcao = porcao;
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

    public String getNome() {
        return nome;
    }

    public double getCarboidrato() {
        return carboidrato;
    }

    public double getGordura() {
        return gordura;
    }

    public double getProteina() {
        return proteina;
    }

    public double getCalorias() {
        return calorias;
    }

    public double getPorcao() {
        return porcao;
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public LocalDate getDtModificacao() {
        return dtModificacao;
    }

    public double calcularCalorias() {
        return 4 * carboidrato + 4 * proteina + 9 * gordura;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                "\nNome: " + nome +
                "\nCarboidratos: " + carboidrato + "g" +
                "\nProteínas: " + proteina + "g" +
                "\nGorduras: " + gordura + "g" +
                "\nCalorias: " + calcularCalorias() +
                "\nPorção: " + porcao +
                "\nData de Criação: " + dtCriacao +
                "\nData de Modificação: " + dtModificacao;
    }

