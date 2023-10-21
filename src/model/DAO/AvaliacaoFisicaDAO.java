/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.DAO;

import model.Alimento;
import model.AvaliacaoFisica;
import model.Pessoa;

/**
 *
 * @author iagol
 */
public class AvaliacaoFisicaDAO {
    AvaliacaoFisica[] avaliacoes = new AvaliacaoFisica[10];


    public AvaliacaoFisicaDAO(PessoaDAO pessoadao){
    AvaliacaoFisica af1 = new AvaliacaoFisica();
    af1.setPessoa(pessoadao.buscaPorNome("iago"));
    af1.setPeso(73);
    af1.setAltura(172);
    af1.setIdade(22);
    af1.setPescoco(30);
    af1.setQuadril(70);
    af1.setCintura(68);
    af1.setRotina(3);
    af1.calcBF();
    af1.calcIMC();
    af1.calcTMB();
    adicionaAvaliacao(af1);
    }

    public boolean adicionaAvaliacao(AvaliacaoFisica af) {
        int proxPosicaoLivreAvFisica = this.proxPosicaoLivreAvFisica();
        if (proxPosicaoLivreAvFisica != -1) {
            avaliacoes[proxPosicaoLivreAvFisica] = af;
            return true;
        } else {
            return false;
        }
    }

    public int proxPosicaoLivreAvFisica() {
        for (int i = 0; i < avaliacoes.length; i++) {
            if (avaliacoes[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void mostraAvaliacoes(){
        for (AvaliacaoFisica af : avaliacoes){
            if(af != null){
                System.out.println("\n" + af.toString());
            }
        }

    }

    public AvaliacaoFisica minhaAvaliacao(Pessoa p){
        for (int i = 0; i < avaliacoes.length; i++) {
            if(avaliacoes[i] != null && avaliacoes[i].getPessoa().getId() == (p.getId())){
                return avaliacoes[i];
            }
        }
        return null;
    }



/*
public double calculaIMC(double peso, double altura){
        double imc  = peso/(altura * altura);
        return imc;
    }

    public double tmbHomem(double peso, double altura, int idade)
    {
        //Calculo da taxa metabolica basal com base na formula de Harris-Benedict(para adultos)
        double vlTmb = 66 + (13.7 * peso) + (5 * altura) - (6.8 * idade);
        return vlTmb;
    }

    public double tmbMulher(double peso, double altura, int idade)
    {
        //Calculo da taxa metabolica basal com base na formula de Harris-Benedict(para adultos)
        double vlTmb = 655 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade);
        return vlTmb;
    }

    public double gastoCalDiario(double tmb, double fatorAtividade){
        double gasto = tmb * fatorAtividade;
        return gasto;
    }
    public double imc(double peso, double altura){
        double vlImc = peso / ((altura/100) * (altura/100));
        return vlImc;
    }

    public double bfHomem(double cintura, double pescoco, double altura) {
        //495 / (1.0324 - 0.19077 * Math.log10(cintura - pescoco) + 0.15456 * Math.log10(altura)) - 450;
        double vlBfH = 495 / (1.0324 - 0.19077 * Math.log10(cintura - pescoco) + 0.15456 * Math.log10(altura)) - 450;
        return vlBfH;
    }

    public double bfMulher(double cintura,  double quadril, double pescoco, double altura, double peso) {
        //163.205 - (97.684 * Math.log10(cintura + quadril - pescoco)) - (78.387 * Math.log10(altura)) + (4.369 * Math.log10(peso));
        double vlBfM = 163.205 / (97.684 * Math.log10(cintura + quadril - pescoco)) - (78.378 * Math.log10(altura)) + (4.369 * Math.log10(peso));
        return vlBfM;
    }

    public double massaGorda(double peso, double bf){
        double mGorda = peso * bf / 100;
        return mGorda;
    }

    public double massaMagra(double peso, double massaGorda){
        double mMagra = peso - massaGorda;
        return mMagra;
    }
*/


}
