package model.bean;

import java.util.Date;

public class ListaPresenca {
    private short id;
    private short idAluno;
    private short idAula;
    private boolean presente;
    private Date data;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public short getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(short idAluno) {
        this.idAluno = idAluno;
    }

    public short getIdAula() {
        return idAula;
    }

    public void setIdAula(short idAula) {
        this.idAula = idAula;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}