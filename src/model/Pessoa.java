/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author iagol
 */
public class Pessoa {
    private static long serial = -1;
    private long id;
    private String nome;
    private String sexo;
    private LocalDate dtNascimento;
    private String login;
    private String senha;
    private String tipoUsuario;

    private LocalDate dtCriacao;


    private LocalDate dtModificacao;

    public Pessoa(){
        this.id = ++Pessoa.serial;
    }
public String getNome(){
    return nome;
}

public void setNome(String nome){
    this.nome = nome;
}

 public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setDtNascimento(String dtNascimento) {
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataNascimento = LocalDate.parse(dtNascimento, formatoEntrada);
        String dataNascimentoFormatada = dataNascimento.format(formatoSaida);

        this.dtNascimento = LocalDate.parse(dtNascimento);
    }

    public LocalDate getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(LocalDate dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public LocalDate getDtModificacao() {
        return dtModificacao;
    }

    public void setDtModificacao(LocalDate dtModificacao) {
        this.dtModificacao = dtModificacao;
    }

    @Override
    public String toString() {
        return "\nPessoa{" +
                "Id: " + id +
                ", Nome: '" + nome + "'}";
    }
}