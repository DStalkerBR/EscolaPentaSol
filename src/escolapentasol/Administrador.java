package escolapentasol;

//Classe Administrador
public class Administrador extends Pessoa {

    private int id;
    private String login;
    private String senha;

    public Administrador(String nome, String dataNascimento, String endereco, String email, String cpf) {
        super(nome, dataNascimento, endereco, email, cpf);
        //Verificar no banco de dados o ultimo id adicionado e adicionar mais 1 ao id tual 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
