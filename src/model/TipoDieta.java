package model;

public class TipoDieta {
    private static long serial = 0;
    private long id;
    private String nome;
    private double carboidrato;
    private double proteina;
    private double gordura;

    public TipoDieta(){
        this.id = ++TipoDieta.serial;
    }

    public static void setSerial(long serial) {
        TipoDieta.serial = serial;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCarboidrato(double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public void setProteina(double proteina) {
        this.proteina = proteina;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
    }

    public static long getSerial() {
        return serial;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getCarboidrato() {
        return carboidrato;
    }

    public double getProteina() {
        return proteina;
    }

    public double getGordura() {
        return gordura;
    }

    @Override
    public String toString() {
        return "id=" + id +
                "\nnome='" + nome + '\'' +
                "\ncarboidrato=" + carboidrato +
                "\nproteina=" + proteina +
                "\ngordura=" + gordura;
    }
}
