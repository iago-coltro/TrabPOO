/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import java.util.Scanner;
import model.AvaliacaoFisica;
import model.Pessoa;
import model.PessoaDAO;
import model.Util;

/**
 *
 * @author iagol
 */
public class Main {

    Scanner scanner = new Scanner(System.in);
    PessoaDAO pessoadao = new PessoaDAO();
    Util util = new Util();

    public Main() {

        int opcaoUsuario = 10;

        while (opcaoUsuario != 3) {
            opcaoUsuario = this.menuLogar();
            switch (opcaoUsuario) {
                case 0:
                    System.out.println("\n===== ENTRAR =====\n");
                    System.out.println("Login: ");
                    String login = scanner.nextLine();
                    System.out.println("Senha:");
                    String senha = scanner.nextLine();
                    Pessoa logada = pessoadao.buscaUsuarioLogin(login, senha);
                    if (logada != null) {
                        System.out.println("Login realizado com sucesso\n");
                        //Util.setUsuarioLogado(logada);
                        //System.out.println("ID pessoa logada eh: " + pessoa.getId());

                        loopPrograma();
                    } else {
                        System.out.println("Login Inválido. Tente novamente");
                    }
                    break;

                case 1:
                    System.out.println("\n===== CADASTRAR =====\n");
                    Pessoa temp = this.criaPessoa();
                    if (pessoadao.adiciona(temp)) {
                        System.out.println("Usuario criado!");
                    } else {
                        System.out.println("Erro ao criar usuário");
                    }

                    break;
            }
        }
        System.out.println("Saindo...");
    }

    public static void main(String[] args) {
        new Main();
    }

    private int menu() {

        StringBuilder builder = new StringBuilder("");

        builder.append("SEJA BEM VINDO AO GERADOR DE DIETAS\n\n");
        builder.append("\n0 - Avaliacao fisica");
        builder.append("\n1 - Tipo de dieta");
        //builder.append("\n2 - Excluir um pessoa");
        //builder.append("\n9 - Para sair do programa\n");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    private int menuLogar() {

        StringBuilder builder = new StringBuilder("");

        builder.append("SEJA BEM VINDO AO MEU PROGRAMA\n\n");
        builder.append("\n0 - Logar");
        builder.append("\n1 - Cadastrar ");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    private void loopPrograma() {
        int opcaoUsuario = 10;

        while (opcaoUsuario != 9) {
            opcaoUsuario = this.menu();
            switch (opcaoUsuario) {
                case 0:

                    System.out.println("\n===== AVALIACAO FISICA =====\n");
                    
                    
                    break;

                case 1:
                    System.out.println("1 - Listar pessoas");
                    break;

                case 2:
                    System.out.println("2 - Excluir um pessoa");

                    break;

                case 3:
                    System.out.println("alterar o nome");
                    break;
                case 4:
                    System.out.println("buscar salários > 5000");
                case 9:
                    System.out.println("sair");
                    break;
                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }

        }
    }

    private Pessoa criaPessoa() {
        Pessoa p1 = new Pessoa();
        System.out.println("Nome:");
        p1.setNome(scanner.nextLine());
        System.out.println("Login:");
        p1.setLogin(scanner.nextLine());
        System.out.println("Senha:");
        p1.setSenha(scanner.nextLine());
        return p1;
    }
    
    private AvaliacaoFisica AdicionaDados(){
        
    }
}
