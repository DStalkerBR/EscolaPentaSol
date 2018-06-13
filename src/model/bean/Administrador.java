package model.bean;

public class Administrador extends Usuario {

    private short id;
    private String tipoAdm;

    public Administrador() {
    }
    
    public Administrador(String login, String senha,String nome, String dataNascimento, String endereco, String celular, String email, String cpf, String tipoAdm) {
        super(login, senha, nome, dataNascimento, endereco, celular, email, cpf);
        this.tipoAdm = tipoAdm;
    }

    public short getId() {
        return this.id;
    }

    public void setIdAdm(short id) {
        this.id = id;
    }

    public String getTipoAdm() {
        return this.tipoAdm;
    }

    public void setTipoAdm(String tipoAdm) {
        this.tipoAdm = tipoAdm;
    }
}