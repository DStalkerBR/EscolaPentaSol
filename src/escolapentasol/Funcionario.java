package escolapentasol;

import java.util.ArrayList;
import java.util.List;

//Classe Funcionario 
public class Funcionario extends Pessoa {

    private int idFuncionario;
    private List<Integer> idAula;
    private List<Integer> especializacao;

    public Funcionario() {
        super();
    }

    public Funcionario(String nome, String dataNascimento, String endereco, String email, String cpf) {
        super(nome, dataNascimento, endereco, email, cpf);
        this.especializacao = new ArrayList<Integer>(especializacao);
    }

    public Funcionario(String nome, String dataNascimento, String endereco, String email, String cpf, List<Integer> especializacao, List<Integer> aulas) {
        super(nome, dataNascimento, endereco, email, cpf);
        this.especializacao = new ArrayList<Integer>(especializacao);
        this.idAula = aulas;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public List<Integer> getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(List<Integer> especializacao) {
        this.especializacao = especializacao;
    }

}
