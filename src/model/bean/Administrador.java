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

    public void setId(short id) {
        this.id = id;
    }

    public String getTipoAdm() {
        return this.tipoAdm;
    }

    public void setTipoAdm(String tipoAdm) {
        this.tipoAdm = tipoAdm;
    }
    
    @Override
    public String toString(){
        return "Login: '" + String.valueOf(this.id ) + "', Login: '" + this.login + "', Nome: '" + this.nome +  
                "', Data de Nascimento: '" + this.dataNascimento +  "', Endereço: '" + this.endereco +  "', Celular: '" + this.celular + 
                "', E-mail: '" + this.email +   "', CPF: '" + this.cpf + "', tipo Adm: '" + this.tipoAdm + "'";
    }
}