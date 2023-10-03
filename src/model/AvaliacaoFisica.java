/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author iagol
 */
public class AvaliacaoFisica {
    long id;
    Pessoa pessoa;
    double peso;
    double altura;
    int idade;
    double pescoco;
    double cintura;
    double quadril;

    public long getId() {
        return id;
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public int getIdade() {
        return idade;
    }

    public double getPescoco() {
        return pescoco;
    }

    public double getCintura() {
        return cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }
    
    
}

