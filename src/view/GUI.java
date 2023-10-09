/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import model.AvaliacaoFisica;
import model.Pessoa;

import java.util.Scanner;

public class GUI {

    Scanner scanner = new Scanner(System.in);

    public int menu() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n=====================================");
        builder.append("SEJA BEM VINDO AO GERADOR DE DIETAS\n\n");
        builder.append("\n=====================================");
        builder.append("\n0 - Avaliacao fisica");
        builder.append("\n1 - Tipo de dieta");
        //builder.append("\n2 - Excluir um pessoa");
        //builder.append("\n9 - Para sair do programa\n");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuLogar() {

        StringBuilder builder = new StringBuilder("");

        builder.append("SEJA BEM VINDO AO MEU PROGRAMA\n\n");
        builder.append("\n0 - Logar");
        builder.append("\n1 - Cadastrar ");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public Pessoa criaPessoa() {
        Pessoa p1 = new Pessoa();
        System.out.println("Nome:");
        p1.setNome(scanner.nextLine());
        System.out.println("Sexo:");
        p1.setSexo(scanner.nextLine());
        System.out.println("Data de nascimento (dd/mm/yyyy):");
        p1.setDtNascimento(scanner.nextLine());
        System.out.println("Login:");
        p1.setLogin(scanner.nextLine());
        System.out.println("Senha:");
        p1.setSenha(scanner.nextLine());
        return p1;
    }

    public void menuAvaliacaoFisica() {

        StringBuilder builder = new StringBuilder("");
        AvaliacaoFisica novaAvaliacao = new AvaliacaoFisica();

        System.out.println("NOVA AVALIAÇÃO FISICA\n\n");
        System.out.println("Digite seu peso em quilos: ");
        novaAvaliacao.setPeso(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite sua altura em centimetros: ");
        novaAvaliacao.setAltura(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite sua idade: ");
        novaAvaliacao.setIdade(Integer.parseInt(scanner.nextLine()));
        System.out.println("Digite a medida de seu pescoço em centimetros: ");
        novaAvaliacao.setPescoco(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite a medida da sua cintura em centimetros: ");
        novaAvaliacao.setCintura(Double.parseDouble(scanner.nextLine()));


        System.out.print(builder.toString());
    }

    public void loopPrograma() {
        int opcaoUsuario = 10;

        while (opcaoUsuario != 9) {
            opcaoUsuario = this.menu();
            switch (opcaoUsuario) {
                case 0:

                    System.out.println("\n===== AVALIACAO FISICA =====\n");
                    this.menuAvaliacaoFisica();
                    
                    break;

                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }

        }
    }

}
