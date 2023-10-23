/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import model.*;
import model.DAO.*;

import java.time.LocalDate;
import java.util.Scanner;

public class GUI {

    Scanner scanner = new Scanner(System.in);
    Util util = new Util();
    PessoaDAO pessoadao = new PessoaDAO();
    AvaliacaoFisicaDAO avaliacaofisicadao = new AvaliacaoFisicaDAO(pessoadao);
    TipoDietaDAO tipodietadao = new TipoDietaDAO();
    PostDAO postdao = new PostDAO(pessoadao);
    SeguidorDAO seguidordao = new SeguidorDAO(pessoadao, postdao);
    //AlimentoDAO alimentodao = new AlimentoDAO();
    //RefeicoesDAO refeicaodao = new RefeicoesDAO();

    public int menuLogar() {

        StringBuilder builder = new StringBuilder("");
        builder.append("\n=====================================");
        builder.append("\nSEJA BEM VINDO AO MEU PROGRAMA");
        builder.append("\n=====================================");
        builder.append("\n0 - Logar");
        builder.append("\n1 - Cadastrar ");
        builder.append("\n9 - Sair");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menu() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n=====================================\n");
        builder.append("           MENU PRINCIPAL           ");
        builder.append("\n=====================================");
        builder.append("\n0 - Menu Avaliação fisica");
        builder.append("\n1 - Menu Alimentos");
        builder.append("\n2 - Iniciar Dieta");
        builder.append("\n3 - Meus Posts");
        builder.append("\n4 - Gerenciar Posts");
        builder.append("\n5 - Gerenciar seguidores");
        builder.append("\n9 - Sair");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    public void feed(PostDAO posts, SeguidorDAO seguidores) {
        Pessoa logado = seguidores.buscaSeguidorPessoa(Util.getUsuarioLogado());
        System.out.println("\n\n====== TIMELINE ======");
        if (logado != null) {

            posts.mostraTodosPostPessoa(logado);

        } else {
            System.out.println("\n\n====== SEM POSTS DE SEGUIDORES ======");
        }
    }

    public int menuPost() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n===== POSTS =====\n");
        builder.append("\n0 - Adicionar Post");
        builder.append("\n1 - Remover Post");
        builder.append("\n9 - Sair\n");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }
    public int menuSeguidores() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n\n===== SEGUIDORES =====\n");
        builder.append("\n0 - Adicionar seguidor");
        builder.append("\n1 - Deixar de seguir");
        builder.append("\n2 - Mostrar seguidores");
        builder.append("\n9 - Sair\n");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuAvaliacaoFisica() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n===== AVALIAÇÃO FISICA =====\n");
        builder.append("\n0 - Adicionar Avaliação Fisica");
        builder.append("\n1 - Mostrar Todas Avaliações Fisicas");
        builder.append("\n2 - Mostrar Minhas Avaliações Fisicas");
        builder.append("\n9 - Sair");
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
        builder.append("\n2 - Remover alimentos");
        builder.append("\n9 - Sair");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuTpDieta() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n===== TIPO DE DIETA =====\n");
        builder.append("\n0 - Mostrar Tipos de Dietas");
        builder.append("\n1 - Adicionar Tipo de Dieta");
        builder.append("\n9 - Sair");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public int menuRefeicao() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n===== REFEIÇÕES =====\n");
        builder.append("\n0 - Mostrar Minhas Refeições");
        builder.append("\n1 - Adicionar Refeições");
        builder.append("\n2 - Remover Refeições");
        builder.append("\n9 - Sair");
        builder.append("\nQual sua opção ? R: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scanner.nextLine());
    }

    public void exibeRefeicoesCompleta(AlimentoRefeicao[] alimentoRef) {
        if (alimentoRef.length != 0) {
            long id = 0;

            for (int i = 0; i < alimentoRef.length; i++) {
                if (alimentoRef[i] != null) {
                    if (alimentoRef[i].getRefeicao().getId() == id) {
                        System.out.println("\n==== REFEIÇÃO ====");
                        System.out.println("\n" + alimentoRef[i].getRefeicao());
                        for (int j = 0; j < alimentoRef.length; j++) {
                            if (alimentoRef[j] != null && alimentoRef[j].getRefeicao().getId() == id) {
                                System.out.println("\n-- Alimentos:");
                                System.out.println(alimentoRef[j].getAlimento());
                            }
                        }
                        id++;
                    }
                }
            }
        } else {
            System.out.println("Nenhuma refeicao cadastrada");
        }

    }

    public int menuAlimentoRefeicao() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n===== ALIMENTO REFEIÇÃO =====\n");
        builder.append("\n0 - Adicionar Alimento Refeição");
        builder.append("\n1 - Remover Alimento Refeição");
        builder.append("\n9 - Sair");
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
    public Post criaPost() {
        Post post1 = new Post();
        post1.setPessoa(util.getUsuarioLogado());
        System.out.println("Conteúdo do post: ");
        post1.setConteudo(scanner.nextLine());
        post1.setDtCriacao(LocalDate.now());
        post1.setDtModificacao(LocalDate.now());
        return post1;
    }

    public Seguidor addSeguidor() {
        Seguidor s1 = new Seguidor();
        s1.setPessoa(pessoadao.buscaPorNome(util.getUsuarioLogado().getNome()));
        System.out.println("\nDigite o nome da pessoa que deseja seguir ?");
        s1.setSeguidores(pessoadao.buscaPorNome(scanner.nextLine()));
        return s1;
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
    af1.setPessoa(util.getUsuarioLogado());
    af1.calcIMC();
    af1.calcTMB();
    af1.calcBF();
    return af1;
    }

    public Dieta criaDieta() {
    Dieta d1 = new Dieta();
    d1.setPessoa(util.getUsuarioLogado());
    System.out.print("""
                       \nQual o seu objetivo ?
                       1: Perder Peso
                       2: Ganhar Peso
                       3: Manter Peso                      
                       R: """);
    d1.setObjetivo(Integer.parseInt(scanner.nextLine()));
    System.out.println("Quantas refeições você deseja fazer ?");
    d1.setNroRefeicoes(Integer.parseInt(scanner.nextLine()));
    d1.setAvaliacaoFisica(avaliacaofisicadao.minhaAvaliacao(d1.getPessoa()));
    d1.setCalorias();
    TipoDieta escolhaDieta = null;
    while (escolhaDieta == null){
        System.out.println("===== Tipos de dietas cadastradas =====\n");
        tipodietadao.mostraNomeTipoDieta();
        System.out.println("\n--Digite o tipo de dieta que deseja--");
        escolhaDieta = tipodietadao.buscaPorNome(scanner.nextLine());
        if (escolhaDieta != null){
            d1.setTipoDieta(escolhaDieta);
        }else {
            System.out.println("Escolha uma dieta cadastrada!\n");
        }
    };
    d1.macros(d1.getCalorias(),d1.getTipoDieta());
    d1.setDtCriacao(LocalDate.now());
    d1.setDtModificacao(LocalDate.now());
    return d1;
    }

    public Refeicoes criaRefeicao(){
        Refeicoes novaRefeicao = new Refeicoes();
        System.out.println("Digite o nome da nova refeição: ");
        novaRefeicao.setNomeRefeicao(scanner.nextLine());
        System.out.println("Digite a quantidade de Proteina: ");
        novaRefeicao.setProteina(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite a quantidade de Carboidrato: ");
        novaRefeicao.setCarboidrato(Double.parseDouble(scanner.nextLine()));
        System.out.println("Digite a quantidade de Gordura: ");
        novaRefeicao.setGordura(Double.parseDouble(scanner.nextLine()));
        novaRefeicao.setDtCriacao(LocalDate.now());
        novaRefeicao.setDtModificacao(LocalDate.now());
        return novaRefeicao;
    }
    /*
    public AlimentoRefeicao criaAlimentoRefeicao(){
        AlimentoRefeicao novoAlimentoRefeicao = new AlimentoRefeicao();
        novoAlimentoRefeicao.setPessoa(util.getUsuarioLogado());
        //alimentodao.mostraNomeAlimentos();
        System.out.println("\nDigite o ID do alimento que deseja adicionar: ");
        //novoAlimentoRefeicao.setAlimento(alimentodao.BuscaAlimentoID(Integer.parseInt(scanner.nextLine())));
        //refeicaodao.mostraNomeRefeicao();
        System.out.println("\nDigite o ID da refeição que deseja adicionar: ");
        //novoAlimentoRefeicao.setRefeicao(refeicaodao.buscaPorId(Integer.parseInt(scanner.nextLine())));
        novoAlimentoRefeicao.setDtCriacao(LocalDate.now());
        novoAlimentoRefeicao.setDtModificacao(LocalDate.now());
        return novoAlimentoRefeicao;
    }
     */

}
