/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view;

import model.AvaliacaoFisica;
import model.DAO.AvaliacaoFisicaDAO;
import model.Pessoa;

import java.util.Scanner;

public class GUI {

    Scanner scanner = new Scanner(System.in);

    public int menu() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\n=====================================\n");
        builder.append("SEJA BEM VINDO AO GERADOR DE DIETAS");
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
        builder.append("\n=====================================");
        builder.append("\nSEJA BEM VINDO AO MEU PROGRAMA");
        builder.append("\n=====================================");
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

    public void menuAvaliacaoFisica() {

        StringBuilder builder = new StringBuilder("");
        AvaliacaoFisica novaAvaliacao = new AvaliacaoFisica();
        AvaliacaoFisicaDAO novaAvaliacaodao = new AvaliacaoFisicaDAO();

            System.out.println("NOVA AVALIAÇÃO FISICA\n");
            System.out.println("Digite seu peso (Kg): ");
            novaAvaliacao.setPeso(Double.parseDouble(scanner.nextLine()));
            System.out.println("Digite sua altura (Cm): ");
            novaAvaliacao.setAltura(Double.parseDouble(scanner.nextLine()));
            System.out.println("Digite sua idade: (Anos)");
            novaAvaliacao.setIdade(Integer.parseInt(scanner.nextLine()));
            System.out.println("Digite a medida de seu pescoço (Cm): ");
            novaAvaliacao.setPescoco(Double.parseDouble(scanner.nextLine()));
            System.out.println("Digite a medida da sua cintura (Cm): ");
            novaAvaliacao.setCintura(Double.parseDouble(scanner.nextLine()));
            System.out.println("Digite a medida do seu quadril (Cm): ");
            novaAvaliacao.setQuadril(Double.parseDouble(scanner.nextLine()));
            System.out.println("\n*** Insira o seu fator de atividade ***");
            System.out.println("1.2 - sedentário (pouco ou nenhum exercício)");
            System.out.println("1.375 - levemente ativo (exercício leve 1 a 3 dias por semana)");
            System.out.println("1.55 - moderadamente ativo (exercício moderado 6 a 7 dias por semana)");
            System.out.println("1.725 - muito ativo (exercício intenso todos os dias ou exercício duas vezes ao dia)");
            System.out.println("1.9 - extra ativo (exercício muito difícil, treinamento ou trabalho físico)");
            novaAvaliacao.setTxAtividade(Double.parseDouble(scanner.nextLine()));

        boolean comparaSexo = novaAvaliacao.getPessoa().getSexo().equals("masculino");

        if (comparaSexo)
        {
            double imc = novaAvaliacaodao.imc(novaAvaliacao.getPeso(), novaAvaliacao.getAltura());
            System.out.printf("\nIMC: %.2f", imc);

            double tmb = novaAvaliacaodao.tmbHomem(novaAvaliacao.getPeso(), novaAvaliacao.getAltura(), novaAvaliacao.getIdade());
            System.out.printf("\nTaxa Metabolica Basal: %.2f Kcal", tmb);

            double gastoCal = novaAvaliacaodao.gastoCalDiario(tmb, novaAvaliacao.getTxAtividade());
            System.out.printf("\nGasto Calorico Diario: %.2f Kcal", gastoCal);

            double bodyFatHomem = novaAvaliacaodao.bfHomem(novaAvaliacao.getCintura(), novaAvaliacao.getPescoco(), novaAvaliacao.getAltura());
            System.out.printf("\nPercentual de gordura: %.2f%%", bodyFatHomem);

            double qtdMassaGorda = novaAvaliacaodao.massaGorda(novaAvaliacao.getPeso(), bodyFatHomem);
            System.out.printf("\nMassa Gorda: %.2f Kg", qtdMassaGorda);

            double qtdMassaMagra = novaAvaliacaodao.massaMagra(novaAvaliacao.getPeso(), qtdMassaGorda);
            System.out.printf("\nMassa Magra: %.2f Kg\n", qtdMassaMagra);

        } else {

            double imc = novaAvaliacaodao.imc(novaAvaliacao.getPeso(), novaAvaliacao.getAltura());
            System.out.printf("\nIMC: %.2f", imc);

            double tmb = novaAvaliacaodao.tmbMulher(novaAvaliacao.getPeso(), novaAvaliacao.getAltura(), novaAvaliacao.getIdade());
            System.out.printf("\nTaxa Metabolica Basal: %.2f Kcal", tmb);

            double gastoCal = novaAvaliacaodao.gastoCalDiario(tmb, novaAvaliacao.getTxAtividade());
            System.out.printf("\nGasto Calorico Diario: %.2f Kcal", gastoCal);

            double bodyFatMulher = novaAvaliacaodao.bfMulher(novaAvaliacao.getCintura(), novaAvaliacao.getQuadril(), novaAvaliacao.getPescoco(), novaAvaliacao.getAltura(), novaAvaliacao.getPeso());
            System.out.printf("\nPercentual de gordura: %.2f%%", bodyFatMulher);

            double qtdMassaGorda = novaAvaliacaodao.massaGorda(novaAvaliacao.getPeso(), bodyFatMulher);
            System.out.printf("\nMassa Gorda: %.2f Kg", qtdMassaGorda);

            double qtdMassaMagra = novaAvaliacaodao.massaMagra(novaAvaliacao.getPeso(), bodyFatMulher);
            System.out.printf("\nMassa Magra: %.2f Kg\n", qtdMassaMagra);

        }

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
