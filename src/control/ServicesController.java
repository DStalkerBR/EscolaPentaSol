package control;

import services.ValidarCPF;
import services.Criptografia;
import services.ValidarEmail;
import services.AutenticacaoData;

public class ServicesController {
  private AutenticacaoData autenticaData;
  private AutenticacaoData autenticaNascimento;
  
  public boolean validarCPF(String cpf){
    return ValidarCPF.isCPF(cpf);
  }
  
  public String encriptarSenha(String senha){
    return Criptografia.encriptar(senha);
  }
  
  public boolean validarData(String data){
    autenticaData = new AutenticacaoData();
    return autenticaData.validaData(data);
  }  
 
   public boolean validarNascimento(String data){
    autenticaNascimento = new AutenticacaoData();
    return autenticaNascimento.validarNascimento(data);
  }
  
  public boolean validaEmail(String email){
    return ValidarEmail.validarEmail(email);
  }
}
