/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import model.Alimento;
import model.AvaliacaoFisica;
import model.DAO.AlimentoDAO;
import model.DAO.AvaliacaoFisicaDAO;
import model.Pessoa;
import model.Util;

import java.time.LocalDate;
import java.util.Scanner;

public class GUI {

    Scanner scanner = new Scanner(System.in);
    Util util = new Util();

    public int menuLogar() {

        StringBuilder builder = new StringBuilder("");
        builder.append("\n=====================================");
        builder.append("\nSEJA BEM VINDO AO MEU PROGRAMA");
        builder.append("\n=====================================");
        builder.append("\n0 - Logar");
        builder.append("\n1 - Cadastrar ");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menu() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n=====================================\n");
        builder.append("SEJA BEM VINDO AO GERADOR DE DIETAS");
        builder.append("\n=====================================");
        builder.append("\n0 - Menu Avaliação fisica");
        builder.append("\n1 - Menu Alimentos");
        builder.append("\n2 - Tipo de dieta");
        //builder.append("\n9 - Para sair do programa\n");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAvaliacaoFisica() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n===== AVALIAÇÃO FISICA =====\n");
        builder.append("\n0 - Adicionar Avaliação Fisica");
        builder.append("\n1 - Mostrar Avaliações Fisicas");
        //builder.append("\n9 - Para sair do programa\n");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuOpcAlimentos() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n=====================================\n");
        builder.append("MENU ALIMENTOS");
        builder.append("\n=====================================");
        builder.append("\n0 - Mostrar alimentos cadastrados");
        builder.append("\n1 - Adicionar alimentos");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuTpDieta() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n===== TIPO DE DIETA =====\n");
        builder.append("\n0 - Mostrar Tipos de Dietas");
        builder.append("\n1 - Adicionar Tipo de Dieta");
        //builder.append("\n9 - Para sair do programa\n");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    public Pessoa criaPessoa() {
        Pessoa p1 = new Pessoa();
        System.out.println("Nome:");
        p1.setNome(scanner.nextLine());
        System.out.println("Sexo (masculino ou feminino):");
        p1.setSexo(scanner.nextLine());
        System.out.println("Data de nascimento (dd/mm/yyyy):");
        p1.setDtNascimento(scanner.nextLine());
        System.out.println("Login:");
        p1.setLogin(scanner.nextLine());
        System.out.println("Senha:");
        p1.setSenha(scanner.nextLine());
        return p1;
    }
    public Alimento criaAlimento() {
    Alimento a1 = new Alimento();
    System.out.println("Nome:");
    a1.setNome(scanner.nextLine());
    System.out.println("Carboidratos:");
    a1.setCarboidrato(Double.parseDouble(scanner.nextLine()));
    System.out.println("Proteinas:");
    a1.setProteina(Double.parseDouble(scanner.nextLine()));
    System.out.println("Gorduras:");
    a1.setGordura(Double.parseDouble(scanner.nextLine()));
    System.out.println("Porção(g):");
    a1.setPorcao(Double.parseDouble(scanner.nextLine()));
    a1.setDtCriacao(LocalDate.now());
    a1.setDtModificacao(LocalDate.now());
    return a1;
    }

    public AvaliacaoFisica criaAvaliacaoFisica() {
        AvaliacaoFisica af1 = new AvaliacaoFisica();
        System.out.println("Insira sua idade: ");
        af1.setIdade(Integer.parseInt(scanner.nextLine()));;
        System.out.println("Insira sua altura em cm: ");
        af1.setAltura(Double.parseDouble(scanner.nextLine()));
        System.out.println("Insira seu peso em kg: ");
        af1.setPeso(Double.parseDouble(scanner.nextLine()));
        System.out.println("Insira sua circunferencia de pesoco em cm: ");
        af1.setPescoco(Double.parseDouble(scanner.nextLine()));
        System.out.println("Insira sua circunferencia de quadril em cm: ");
        af1.setQuadril(Double.parseDouble(scanner.nextLine()));
        System.out.println("Insira sua circunferencia de cintura em cm: ");
        af1.setCintura(Double.parseDouble(scanner.nextLine()));
        System.out.print("""
                           Escolha um estilo de rotina abaixo
                           1: sedentario (pouco ou nenhum exercicio)
                           2: levemente ativo (exercicio leve 1 a 3 dias por semana)
                           3: moderadamente ativo (exercicio moderado 6 a 7 dias por semana)
                           4: muito ativo (exercicio intenso todos os dias ou exercicio duas vezes ao dia)
                           5: extra ativo (exercicio muito dificil, treinamento ou trabalho fisico)
                           R: """);
        af1.setRotina(Integer.parseInt(scanner.nextLine()));
        af1.calcIMC();
        af1.calcTMB();
        af1.calcBF();
        return af1;
    }


}
