/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author iagol
 */
public class Pessoa {
    private static long serial = 0;
    long id;
    String nome;
    String sexo;
    String dtNascimento;
    String login;
    String senha;
    String tipoUsuario;
    LocalDateTime dtCriacao;
    LocalDateTime dtModificacao;    

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
    
}