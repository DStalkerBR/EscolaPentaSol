package escolapentasol;

//Classe Pessoa
public class Pessoa {

    private String nome;
    private String dataNascimento;
    private String endereco;
    private String email;
    private String cpf;

    public Pessoa() {

    }

    public Pessoa(String nome, String dataNascimento, String endereco, String email, String cpf) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.cpf = cpf;
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

}
