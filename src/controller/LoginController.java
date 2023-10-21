package controller;

import model.*;
import model.DAO.*;
import view.GUI;

import java.util.Scanner;

public class LoginController {
    GUI gui = new GUI();
    Scanner scanner = new Scanner(System.in);
    PessoaDAO pessoadao = new PessoaDAO();
    AlimentoDAO alimentodao = new AlimentoDAO();
    TipoDietaDAO tipodietadao = new TipoDietaDAO();
    AvaliacaoFisicaDAO avaliacaofisicadao = new AvaliacaoFisicaDAO(pessoadao);
    DietaDAO dietadao = new DietaDAO();
    Dieta dieta = new Dieta();
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
    /*
    public void menuStartDieta() {

        int opcaoStartDieta = 10;

        while (opcaoStartDieta != 3) {
            opcaoStartDieta = gui.menuObjetivo();
            switch (opcaoStartDieta) {
                case 0:
                    System.out.println("GANHAR PESO");
                    break;

                case 1:
                    System.out.println("PERDER PESO");
                    break;

                case 2:
                    System.out.println("MANTER PESO");
                    break;
                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }
        }
    }
     */

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

                case 2:
                    AvaliacaoFisica minhaAvaliacao = avaliacaofisicadao.minhaAvaliacao(util.getUsuarioLogado());
                    if (minhaAvaliacao != null){
                        System.out.println("\n" + minhaAvaliacao);
                    }
                    else {
                        System.out.println("\nVocê não tem avaliação física cadastrada");
                    }
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
                /*
                case 2:
                    this.menuTpDieta();
                    break;
                 */

                case 2:
                    //gui.criaDieta();
                    Dieta dietaTemp = gui.criaDieta();
                    dietadao.criaDieta(dietaTemp);
                    if (dietadao.criaDieta(dietaTemp)) {
                        dietadao.mostraDieta();
                        System.out.println("\nDieta adicionada!");
                    } else {
                        System.out.println("\nErro ao adicionar Dieta");
                    }
                    break;

                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }

        }
    }
}
