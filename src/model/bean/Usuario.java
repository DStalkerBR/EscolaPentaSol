package model.bean;

//Classe Usuario

import model.dao.UsuarioDAO;

public class Usuario extends Pessoa {

    protected String login;
    protected String senha;

    public Usuario(){
       super();
    }
    
    public Usuario(String login, String senha, String nome, String dataNascimento, String endereco, String cpf, String celular, String email) {
        super(nome, dataNascimento, endereco, cpf, celular, email); 
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
  
  public Object login (String login, String senha){
      UsuarioDAO userDao = new UsuarioDAO(); 
      return userDao.checarLogin(login, senha);
  }
  
}
