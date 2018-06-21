package model.bean;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.dao.ListaPresencaDAO;

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
    
    public void inserir (List<ListaPresenca> presencas){
        ListaPresencaDAO presencaDao = new ListaPresencaDAO();
        presencaDao.inserir(presencas);
    }    
    
    public int checarPresenca (short idAluno, short idAula){
        ListaPresencaDAO presencaDao = new ListaPresencaDAO();
        return presencaDao.count(idAluno, idAula);
    }    
    
    @Override
    public String toString(){
        Format formatterDate = new SimpleDateFormat("dd-MM-yyyy");
        return "Id: '" + String.valueOf(this.id ) + "', idAluno: '" + String.valueOf(this.idAluno ) + "', idAula: '" + String.valueOf(this.idAula ) +  
                "', Presente: '" + this.presente +  "', Data: '" + formatterDate.format(this.data) +  "'";
    }   
    
}