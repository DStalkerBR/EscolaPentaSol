package model.bean;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//Classe Aluno
/*
 * Atributos: id, numeroMatricula, idAula, temInstrumento
 * */

 /*
 * Funcionario(PROFESSOR) vai está relacionado com uma AULA, e o Usuario(ALUNO) vai está relacionado com uma AULA
 * */
public class Aluno extends Pessoa {

    private short id;
    private Date dataCadastro;
    private List<Short> idAula;
    private String matricula;
    private boolean possuiInstrumento;

    public Aluno() {
        super();
    }

    public Aluno(String nome, String dataNascimento, String endereco, String celular,
            String email, String cpf, boolean possuiInstrumento, Date dataCadastro, List<Short> idAula) {
        super(nome, dataNascimento, endereco, celular, email, cpf);
        this.possuiInstrumento = possuiInstrumento;
        this.idAula = new ArrayList<>(idAula);
        this.dataCadastro = dataCadastro;
        //Para fazer: Sugestão -> Matricula similar à uesc, onde os 5 primeiros digitos são relacioandos ao semestre (ex: 2017.2) e os 3 digitos finais ao id atual (Necessário verificar o bando de dados pelo ultimo id adicional)
    }

    public short getId() {
        return this.id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public List<Short> getIdAula() {
        return this.idAula;
    }

    public void setIdAula(List<Short> aulas) {
        this.idAula = aulas;
    }

    public String getNumeroMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean getPossuiInstrumento() {
        return this.possuiInstrumento;
    }

    public void setPossuiInstrumento(boolean possuiInstrumento) {
        this.possuiInstrumento = possuiInstrumento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    @Override
    public String toString(){
        Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return "Id: '" + String.valueOf(this.id ) + "', Data Cadastro: '" + formatter.format(this.dataCadastro) + "', Nome: '" + this.nome +  
                "', Data de Nascimento: '" + this.dataNascimento +  "', Endereço: '" + this.endereco +  "', Celular: '" + this.celular + 
                "', E-mail: '" + this.email +   "', CPF: '" + this.cpf + "', Possui Instrumento: '" + this.possuiInstrumento 
                + "', idAulas '" + this.idAula.toString() + "', Matricula: '" + this.matricula + "'";
    }
   
}
