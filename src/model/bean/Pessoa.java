package model.bean;

//Classe Pessoa
public class Pessoa {
    private String nome;
    private String dataNascimento;
    private String endereco;
    private String cpf;
    private String celular;
    private String email;
  
    //Construtores
    public Pessoa() {

    }

    public Pessoa(String nome, String dataNascimento, String endereco, String cpf, String celular, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.cpf = cpf;
        this.celular = celular;
        this.email = email;
    }

        //Getter e Setter para Nome
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Getter e Setter para DataNascimento - Com Validação
    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    //Getter e Setter para Endereco
    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    //Getter e Setter para Email - Com Validação
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Getter e Setter para CPF
    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    
}
