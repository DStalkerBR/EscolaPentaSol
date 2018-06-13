package control;

import model.bean.Usuario;
import validacoes.Criptografia;

public class LoginController {
  public static boolean fazerLogin(String login, String senha){
    Usuario usuario = new Usuario();
    return usuario.login(login, Criptografia.encriptar(senha));
  }
  
   public static void main (String argv[]){
        /*if (LoginController.fazerLogin("ad", "123", "administrador"))
            System.out.println("sucesso");
        */
   }
}


