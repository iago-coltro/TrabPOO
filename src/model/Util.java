/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

/**
 *
 * @author iagol
 */
public class Util {
    private static Pessoa pessoaLogada = null;


    public static Pessoa getUsuarioLogado() {
        return pessoaLogada;
    }

    public static void setUsuarioLogado(Pessoa pessoaLogada) {
        Util.pessoaLogada = pessoaLogada;
    }

}
