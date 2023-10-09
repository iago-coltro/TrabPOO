package controller;

import model.Pessoa;
import model.DAO.PessoaDAO;
import model.Util;
import view.GUI;

import java.util.Scanner;

public class LoginController {
    GUI gui = new GUI();
    Scanner scanner = new Scanner(System.in);
    PessoaDAO pessoadao = new PessoaDAO();
    Util util = new Util();

    public LoginController() {

        int opcaoUsuario = 10;

        while (opcaoUsuario != 3) {
            opcaoUsuario = gui.menuLogar();
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

                        gui.loopPrograma();
                    } else {
                        System.out.println("Login Inválido. Tente novamente");
                    }
                    break;

                case 1:
                    System.out.println("\n===== CADASTRAR =====\n");
                    Pessoa temp = gui.criaPessoa();
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

        new LoginController();
    }
}
