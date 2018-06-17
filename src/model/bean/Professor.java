package model.bean;

import java.util.ArrayList;
import java.util.List;

//Classe Professor 
public class Professor extends Usuario {

    private short id;
    private List<Short> idAula;
    private List<Short> especializacoes;

    public Professor() {
        super();
    }

    public Professor(String login, String senha,String nome, String dataNascimento, String endereco, 
            String email, String cpf, String celular, List<Short> especializacao, List<Short> aulas) {
        super(login, senha, nome, dataNascimento, endereco, cpf, celular, email);
        this.especializacoes = new ArrayList<>(especializacao);
        this.idAula = aulas;
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

    public List<Short> getEspecializacoes() {
        return especializacoes;
    }

    public void setEspecializacoes(List<Short> especializacoes) {
        this.especializacoes = especializacoes;
    }

}
