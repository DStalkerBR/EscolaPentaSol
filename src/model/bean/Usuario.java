package model.bean;

import escolapentasol.Pessoa;
import java.util.List;

//Classe Aluno
/*
 * Atributos: id, numeroMatricula, idAula, temInstrumento
 * */

 /*
 * Funcionario(PROFESSOR) vai está relacionado com uma AULA, e o Usuario(ALUNO) vai está relacionado com uma AULA
 * */
public class Usuario extends Pessoa {

    private int id;
    private List<Integer> idAula;
    private String matricula;
    private boolean possuiInstrumento;

    public Usuario() {
        super();
    }

    public Usuario(String nome, String dataNascimento, String endereco, String email, String cpf, boolean possuiInstrumento) {
        super(nome, dataNascimento, endereco, email, cpf);
        this.possuiInstrumento = possuiInstrumento;
        //Para fazer: Sugestão -> Matricula similar à uesc, onde os 5 primeiros digitos são relacioandos ao semestre (ex: 2017.2) e os 3 digitos finais ao id atual (Necessário verificar o bando de dados pelo ultimo id adicional)
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAulaAt(int indice) {
        return this.idAula.get(indice);
    }

    public void addIdAula(int idAula) {
        this.idAula.add(idAula);
    }

    public List<Integer> getIdAula() {
        return this.idAula;
    }

    public void setIdAula(List<Integer> aulas) {
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

}
