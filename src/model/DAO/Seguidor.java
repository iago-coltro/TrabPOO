package model.DAO;

import model.Pessoa;

public class Seguidor {
    private static long serial;
    private long id;
    private Pessoa pessoa;
    //private Pessoa[] seguidores = new Pessoa[10];
    private Pessoa seguidores;
    private String createDate;
    private String modifyDate;

    public Seguidor(){
        this.id = ++Seguidor.serial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pessoa getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(Pessoa seguidores) {
        this.seguidores = seguidores;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "@" + seguidores.getNome();
    }
}
