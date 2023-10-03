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
public class Alimento {
    int id;
    int carboidrato;
    int gordura;
    int proteina;
    int calorias;
    int porcao;
    String tipoUsuario;
    LocalDateTime dtCriacao;
    LocalDateTime dtModificacao;

    public int getId() {
        return id;
    }

    public int getCarboidrato() {
        return carboidrato;
    }

    public int getGordura() {
        return gordura;
    }

    public int getProteina() {
        return proteina;
    }

    public int getCalorias() {
        return calorias;
    }

    public int getPorcao() {
        return porcao;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public LocalDateTime getDtCriacao() {
        return dtCriacao;
    }

    public LocalDateTime getDtModificacao() {
        return dtModificacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCarboidrato(int carboidrato) {
        this.carboidrato = carboidrato;
    }

    public void setGordura(int gordura) {
        this.gordura = gordura;
    }

    public void setProteina(int proteina) {
        this.proteina = proteina;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setDtCriacao(LocalDateTime dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public void setDtModificacao(LocalDateTime dtModificacao) {
        this.dtModificacao = dtModificacao;
    }
    
    
}
