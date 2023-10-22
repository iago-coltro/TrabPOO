/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author iagol
 */
public class AvaliacaoFisica {
    private static long serial = -1;
    private long id;
    private Pessoa pessoa;
    private double peso;
    private double altura;
    private int idade;
    private double pescoco;
    private double cintura;
    private double quadril;
    private double txAtividade;
    private double bf;
    private double imc;
    private double tmb;
    private double massMagra;
    private double massGorda;

    public AvaliacaoFisica(){
        this.id = ++AvaliacaoFisica.serial;
        this.pessoa = Util.getUsuarioLogado();
    }

    public void setRotina(int rotina) {
        switch(rotina){
            case 1:
                this.txAtividade = 1.2;
                break;
            case 2:
                this.txAtividade = 1.375;
                break;
            case 3:
                this.txAtividade = 1.55;
                break;
            case 4:
                this.txAtividade = 1.725;
                break;
            case 5:
                this.txAtividade = 1.9;
                break;
            default:
                this.txAtividade = 1.375;
                break;
        }

    }
    public void calcBF(){
        if(this.pessoa.getSexo().equalsIgnoreCase("masculino")){
            this.bf = 495 / (1.0324 - 0.19077 * Math.log10(cintura - pescoco) + 0.15456 * Math.log10(altura)) - 450;
        }else{
            this.bf = 163.205 - (97.684 * Math.log10(cintura + quadril - pescoco)) - (78.387 * Math.log10(altura)) + (4.369 * Math.log10(peso));
        }
        this.massMagra = this.peso*(1-(this.bf/100));
        this.massGorda = this.peso*(this.bf/100);
    }

    public void calcIMC(){
        this.imc = this.peso/((this.altura/100)*(this.altura/100));
    }
    public void calcTMB(){
        if(this.pessoa.getSexo().equalsIgnoreCase("masculino")){
            this.tmb = this.txAtividade*(66+((13.7*this.peso)+(5*this.altura)-(6.8*this.idade)));
        }else{
            this.tmb = this.txAtividade*(655+((9.6*this.peso)+(1.8*this.altura)-(4.7*this.idade)));
        }
    }

    public double getTmb() {
        return tmb;
    }

    public long getId()
    {
        return id;
    }
    
    public Pessoa getPessoa() {

        return pessoa;
    }

    public double getPeso() {

        return peso;
    }

    public double getAltura() {

        return altura;
    }

    public int getIdade(){

    return idade;

    }

    public double getPescoco() {

    return pescoco;
    }

    public double getCintura() {
        return cintura;
    }

    public double getQuadril() {
        return quadril;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPescoco(double pescoco) {
        this.pescoco = pescoco;
    }

    public void setCintura(double cintura) {
        this.cintura = cintura;
    }

    public void setQuadril(double quadril) {
        this.quadril = quadril;
    }

    public double getTxAtividade() {
        return txAtividade;
    }

    public void setTxAtividade(double txAtividade) {
        this.txAtividade = txAtividade;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nPessoa: " + pessoa.getNome() +
                "\nPeso: " + peso +
                "\nAltura: " + altura +
                "\nIdade: " + idade +
                "\nPescoco: " + pescoco +
                "\nCintura: " + cintura +
                "\nQuadril: " + quadril +
                "\nTxAtividade: " + txAtividade +
                "\nIMC: " + imc +
                "\nTaxa Metabolica Basal: " + tmb +
                "\nMassa Gorda: " + massGorda +
                "\nMassa Magra: " + massMagra +
                "\nPercentual de Gordura: " + bf;
    }
}

