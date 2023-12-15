package controller;

import model.*;
import model.DAO.*;
import view.GUI;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LoginController{
    GUI gui = new GUI();
    Scanner scanner = new Scanner(System.in);
    PessoaDAO pessoadao = new PessoaDAO();
    MensagemDAO mensagemdao = new MensagemDAO(pessoadao);
    AlimentoDAO alimentodao = new AlimentoDAO();
    TipoDietaDAO tipodietadao = new TipoDietaDAO();
    AvaliacaoFisicaDAO avaliacaofisicadao = new AvaliacaoFisicaDAO(pessoadao);
    DietaDAO dietadao = new DietaDAO();
    Dieta dieta = new Dieta();
    Util util = new Util();
    RefeicoesDAO refeicoesdao = new RefeicoesDAO();
    PostDAO postdao = new PostDAO(pessoadao);
    SeguidorDAO seguidordao = new SeguidorDAO(pessoadao, postdao);
    Seguidor seguidor = new Seguidor();
    AlimentoRefeicaoDAO alimentorefeicaodao = new AlimentoRefeicaoDAO(refeicoesdao, alimentodao, pessoadao);

    // irá pegar a lista de pessoas
    public LoginController() {
    /*
    List<Pessoa> usuarios = pessoadao.buscaTodos();

    for(Pessoa usuario:usuarios) {
        System.out.println(usuario.toString());
    }

     */
        int opcaoUsuario = 10;

        while (opcaoUsuario != 9) {
            opcaoUsuario = gui.menuLogar();
            switch (opcaoUsuario) {
                case 0:
                    System.out.println("\n===== ENTRAR =====\n");
                    System.out.println("Login: ");
                    String login = scanner.nextLine();
                    System.out.println("Senha:");
                    String senha = scanner.nextLine();
                    Util.setUsuarioLogado(pessoadao.buscaLogin(login, senha));
                    if (Util.getUsuarioLogado() != null) {
                        System.out.println("\nLogin realizado com sucesso");
                        System.out.println("\n\n====== OLÁ " + Util.getUsuarioLogado().getNome().toUpperCase() + " ======");
                        gui.feed(postdao, seguidordao);
                        this.loopPrograma();
                    } else {
                        System.out.println("Login Inválido. Tente novamente");
                    }
                    break;

                case 1:
                    System.out.println("\n===== CADASTRAR =====\n");
                    /*Pessoa temp = gui.criaPessoa();
                    if (pessoadao.adiciona(temp)) {
                        System.out.println("Usuario criado!");
                    } else {
                        System.out.println("Erro ao criar usuário");
                    }
                    break;

                     */
            }
        }
        System.out.println("Saindo...");
    }

    public void opcPost() {

        int opcaoPost = 10;

        while (opcaoPost != 9) {
            opcaoPost = gui.menuPost();
            switch (opcaoPost){
                case 0:
                    Post postTemp = gui.criaPost();
                    postdao.adicionaPost(postTemp);
                    System.out.println("Post criado!");
                    postdao.mostraTodosPostPessoa(util.getUsuarioLogado());
                    break;

                case 1:
                    System.out.println("Insira o id de um post para ser removido: ");
                    long id = Integer.parseInt(scanner.nextLine());
                    if (!postdao.removePost(id, Util.getUsuarioLogado())) {
                        System.out.println("Post nao encontrado");
                    }else {
                        System.out.println("Post removido!");
                        postdao.mostraTodosPostPessoa(util.getUsuarioLogado());
                    }
                    break;

                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }
        }
    }
    public void opcSeguidor() {

        int opcaoSeguidor = 10;

        while (opcaoSeguidor != 9) {
            opcaoSeguidor = gui.menuSeguidores();
            switch (opcaoSeguidor){
                case 0:
                    pessoadao.mostraPessoa(util.getUsuarioLogado());
                    Seguidor seguidorTemp = gui.addSeguidor();
                    seguidordao.adicionaSeguidor(seguidorTemp);
                    System.out.println("\nAgora você segue: ");
                    seguidordao.mostraSeguidoresPessoa(util.getUsuarioLogado());
                    gui.feed(postdao, seguidordao);
                    break;

                case 1:
                    pessoadao.mostraPessoa(util.getUsuarioLogado());
                    System.out.println("\nInsira o id do seguidor que irá ser removido: ");
                    long id = Integer.parseInt(scanner.nextLine());
                    if (!seguidordao.removeSeguidor(id)){
                        System.out.println("\nSeguidor nao encontrado");
                    }else {
                        System.out.println("\nDeixou de seguir!");
                        seguidordao.mostraSeguidoresPessoa(util.getUsuarioLogado());
                    }
                    break;

                case 2:
                    seguidordao.mostraSeguidoresPessoa(util.getUsuarioLogado());
                    break;

                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }
        }
    }

    public void opcMensagem() {

        int opcaoMensagem = 10;

        while (opcaoMensagem != 9) {
            opcaoMensagem = gui.menuMensagem();
            switch (opcaoMensagem){
                case 0:
                    System.out.println("Destinatario: ");
                    String nome = scanner.nextLine();
                    System.out.println("Mensagem: ");
                    String conteudo = scanner.nextLine();
                    if (!util.getUsuarioLogado().getNome().equalsIgnoreCase(nome)) {
                        Mensagem m = new Mensagem();
                        m.setpOrigem(util.getUsuarioLogado());
                        m.setpDestino(pessoadao.buscaPorNome(nome));
                        m.setConteudo(conteudo);
                        mensagemdao.criaMensagem(m);
                    } else {
                        System.out.println("Nao e possivel enviar mensagem para voce mesmo.");
                    }

                case 1:
                    System.out.println("Mensagens enviadas: ");
                    mensagemdao.mostraMensagemEnviada(util.getUsuarioLogado());
                    break;

                case 2:
                    System.out.println("Mensagens recebidas: ");
                    mensagemdao.mostraMensagemRecebida(util.getUsuarioLogado());
                    break;

                case 3:
                    System.out.println("Todas Mensagens enviadas: ");
                    mensagemdao.mostraTodasMensagens();
                break;

                case 4:
                    mensagemdao.mostraMensagemEnviada(util.getUsuarioLogado());
                    System.out.println("\nInsira o id da mensagem que será removida: ");
                    long id = Integer.parseInt(scanner.nextLine());
                    if (!mensagemdao.removeMensagens(id)){
                        System.out.println("\nMensagem nao encontrada");
                    }else {
                        System.out.println("\nMensagem removida!");
                        mensagemdao.mostraMensagemEnviada(util.getUsuarioLogado());
                    }
                    break;

                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }
        }
    }

    public void menuAlimentos() {

        int opcaoAlimentos = 10;

        while (opcaoAlimentos != 9) {
            opcaoAlimentos = gui.menuOpcAlimentos();
            switch (opcaoAlimentos) {
                case 0:
                    alimentodao.mostraAlimentos();
                    break;

                case 1:
                    Alimento alimentotemp = gui.criaAlimento();
                    alimentodao.adicionaAlimento(alimentotemp);
                    System.out.println("\nAlimento Adicionado!");
                    alimentodao.mostraAlimentos();
                    break;

                case 2:
                    System.out.println("\nInsira o id do alimento que irá ser removida: ");
                    long id = Integer.parseInt(scanner.nextLine());
                    if (!alimentodao.removeAlimentosID(id)){
                        System.out.println("\nAlimento não encontrado");
                    }else {
                        System.out.println("\nAlimento removido!");
                        alimentodao.mostraAlimentos();
                    }
                    break;
                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }
        }
    }

    public void opcAvaliacaoFisica() {

        int opcAvaliacaoFisica = 10;

        while (opcAvaliacaoFisica != 9) {
            opcAvaliacaoFisica = gui.menuAvaliacaoFisica();

            switch (opcAvaliacaoFisica) {

                case 0:
                    AvaliacaoFisica avaliacaotemp = gui.criaAvaliacaoFisica();
                    avaliacaofisicadao.adicionaAvaliacao(avaliacaotemp);
                    System.out.println("Avaliação adicionada!");
                    break;

                case 1:
                    avaliacaofisicadao.buscaUltimaAvaliacao();
                    break;

                case 2:
                    AvaliacaoFisica minhaAvaliacao = avaliacaofisicadao.buscaUltimaAvaliacao(util.getUsuarioLogado());
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

        while (opcTpDieta != 9) {
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

    public void opcAlimentoRefeicao() {

        int opcAlimentoRef = 10;

        while (opcAlimentoRef != 9) {
            opcAlimentoRef = gui.menuAlimentoRefeicao();

            switch (opcAlimentoRef) {

                case 0:
                    AlimentoRefeicao novoAlimentoRefeicao = new AlimentoRefeicao();
                    novoAlimentoRefeicao.setPessoa(util.getUsuarioLogado());
                    System.out.println("\n-- Alimentos Cadastrados: --\n");
                    alimentodao.mostraNomeAlimentos();
                    System.out.println("\nDigite o ID do alimento que deseja adicionar: ");
                    novoAlimentoRefeicao.setAlimento(alimentodao.BuscaAlimentoID(Integer.parseInt(scanner.nextLine())));
                    System.out.println("\n-- Refeições Cadastradas: --\n");
                    refeicoesdao.mostraNomeRefeicao();
                    System.out.println("\nDigite o ID da refeição que deseja adicionar: ");
                    novoAlimentoRefeicao.setRefeicao(refeicoesdao.buscaPorId(Integer.parseInt(scanner.nextLine())));
                    novoAlimentoRefeicao.setDtCriacao(LocalDate.now());
                    novoAlimentoRefeicao.setDtModificacao(LocalDate.now());
                    alimentorefeicaodao.criaAlimentoRefeicao(novoAlimentoRefeicao);
                    System.out.println("Alimento Refeição adicionado!");
                    break;

                case 1:
                    System.out.println("\n-- Alimentos Refeição cadastrados --\n");
                    alimentorefeicaodao.mostraAlimentoRefeicao(util.getUsuarioLogado());
                    System.out.println("Insira o id do Alimento Refeição que irá ser removido: ");
                    long id = Integer.parseInt(scanner.nextLine());
                    if (!alimentorefeicaodao.removeAlimentoRefeicao(id)){
                        System.out.println("Alimento Refeição nao encontrado");
                    }else {
                        System.out.println("\nAlimento Refeição removido!\n");
                        alimentorefeicaodao.mostraAlimentoRefeicao(util.getUsuarioLogado());
                    }
                    break;


                default:
                    System.out.println("escolha uma opcao valida");
                    break;
            }
        }
    }


    public void menuRefeicao() {

        int opcaoRefeicao = 10;

        while (opcaoRefeicao != 9) {
            opcaoRefeicao = gui.menuRefeicao();
            switch (opcaoRefeicao) {
                case 0:
                    refeicoesdao.mostraRefeicao();
                    break;

                case 1:
                    Refeicoes refeicaotemp = gui.criaRefeicao();
                    refeicoesdao.AdicionaRefeicao(refeicaotemp);
                    System.out.println("Refeição adicionada!");
                    refeicoesdao.mostraRefeicao();
                    break;

                case 2:
                    System.out.println("Insira o id da refeição que irá ser removida: ");
                    long id = Integer.parseInt(scanner.nextLine());
                    if (!refeicoesdao.removeRefeicaoID(id)){
                        System.out.println("Refeição nao encontrada");
                    }else {
                        System.out.println("Refeição removida!");
                        refeicoesdao.mostraRefeicao();
                    }
                    break;

                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }
        }
    }

    public static void main(String[] args) throws SQLException {

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
                    if (avaliacaofisicadao.minhaAvaliacao(util.getUsuarioLogado()) != null){
                        Dieta dietaTemp = gui.criaDieta();
                        dietadao.criaDieta(dietaTemp);
                        System.out.println("\nDieta adicionada!");
                        dietadao.mostraDieta();
                        gui.exibeRefeicoesCompleta(alimentorefeicaodao.buscaTodosPorPessoa(util.getUsuarioLogado()));
                        this.opcAlimentoRefeicao();
                        //this.menuRefeicao();
                    } else {
                     System.out.println("\n --- Você ainda não tem avaliação fisica cadastrada ---");
                    }

                    break;

                case 3:
                      postdao.mostraTodosPostPessoa(util.getUsuarioLogado());
                    break;

                case 4:
                    this.opcPost();
                    break;
                case 5:
                    this.opcSeguidor();
                    break;
                case 6:
                    this.opcMensagem();
                    break;

                default:
                    System.out.println("escola uma opcao valida");
                    break;
            }

        }
    }
}
