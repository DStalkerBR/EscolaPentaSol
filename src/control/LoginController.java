package control;

import model.bean.Administrador;
import model.bean.Professor;
import model.bean.Usuario;
import services.Criptografia;
import services.Sessao;

public class LoginController {
  public static Object fazerLogin(String login, String senha){
    Usuario usuario = new Usuario();
    return usuario.login(login, Criptografia.encriptar(senha));
  }
  
   public static void main (String argv[]){
       /*Object generic;
       Administrador admin;
       Professor prof;
        if ((generic = LoginController.fazerLogin("prof", "123")) instanceof Administrador){
            admin = (Administrador) generic;
            Sessao sessao = Sessao.getInstance();
            sessao.setAdmin(admin);
            System.out.println(sessao.getAdmin().toString());
        } else if (generic instanceof Professor){
            prof = (Professor) generic;
            Sessao sessao = Sessao.getInstance();
            sessao.setProf(prof);
            System.out.println(sessao.getProf().toString());
            
        }      */        
   }
}


