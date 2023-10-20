package controller;

import model.*;
import model.DAO.AlimentoDAO;
import model.DAO.AvaliacaoFisicaDAO;
import model.DAO.TipoDietaDAO;
import model.DAO.PessoaDAO;
import view.GUI;

import java.util.Scanner;

public class LoginController {
    GUI gui = new GUI();
    Scanner scanner = new Scanner(System.in);
    PessoaDAO pessoadao = new PessoaDAO();
    AlimentoDAO alimentodao = new AlimentoDAO();
    TipoDietaDAO tipodietadao = new TipoDietaDAO();
    AvaliacaoFisicaDAO avaliacaofisicadao = new AvaliacaoFisicaDAO(pessoadao);
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
                    Util.setUsuarioLogado(pessoadao.buscaUsuarioLogin(login, senha));
                    if (Util.getUsuarioLogado() != null) {
                        System.out.println("\nLogin realizado com sucesso");
                        //Util.setUsuarioLogado(logada);
                        //System.out.println("ID pessoa logada eh: " + pessoa.getId());

                        this.loopPrograma();
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

    public void menuAlimentos() {

        int opcaoAlimentos = 10;

        while (opcaoAlimentos != 3) {
            opcaoAlimentos = gui.menuOpcAlimentos();
            switch (opcaoAlimentos) {
                case 0:
                    alimentodao.mostraAlimentos();
                    break;

                case 1:
                    Alimento alimentotemp = gui.criaAlimento();
                    alimentodao.adicionaAlimento(alimentotemp);
                    if (alimentodao.adicionaAlimento(alimentotemp)) {
                        System.out.println("Alimento adicionada!");
                    } else {
                        System.out.println("Erro ao adicionar alimento");
                    }
                    break;
                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }
        }
    }

    public void opcAvaliacaoFisica() {

        int opcAvaliacaoFisica = 9;

        while (opcAvaliacaoFisica != 3) {
            opcAvaliacaoFisica = gui.menuAvaliacaoFisica();

            switch (opcAvaliacaoFisica) {

                case 0:
                    AvaliacaoFisica avaliacaotemp = gui.criaAvaliacaoFisica();
                    avaliacaofisicadao.adicionaAvaliacao(avaliacaotemp);
                    if (avaliacaofisicadao.adicionaAvaliacao(avaliacaotemp)) {
                        System.out.println("Avaliação adicionada!");
                    } else {
                        System.out.println("Erro ao adicionar avaliação");
                    }
                    break;

                case 1:
                    avaliacaofisicadao.mostraAvaliacoes();
                    break;

                default:
                    System.out.println("escolha uma opcao valida");
                    break;
            }
        }
    }

    public void menuTpDieta() {

        int opcTpDieta = 10;

        while (opcTpDieta != 3) {
            opcTpDieta = gui.menuTpDieta();
            switch (opcTpDieta) {
                case 0:
                    tipodietadao.mostraTipoDieta();;
                    break;

                case 1:
                    /*
                     TipoDieta tpDietatemp = gui.();
                    tipodietadao.mostraTipoDieta(alimentotemp);
                    if (tipodietadao.mostraTipoDieta(alimentotemp);) {
                        System.out.println("Alimento adicionada!");
                    } else {
                        System.out.println("Erro ao adicionar alimento");
                    }
                     */

                    break;
                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }
        }
    }

    public static void main(String[] args) {

        new LoginController();
    }

    public void loopPrograma () {
        int opcaoUsuario = 10;

        while (opcaoUsuario != 9) {
            opcaoUsuario = gui.menu();
            switch (opcaoUsuario) {
                case 0:
                    this.opcAvaliacaoFisica();
                    break;

                case 1:
                    this.menuAlimentos();
                    break;

                case 2:
                    this.menuTpDieta();
                    break;

                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }

        }
    }
}
