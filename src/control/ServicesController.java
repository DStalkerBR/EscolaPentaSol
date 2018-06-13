package control;

public class ServicesController {
  private ValidarCPF validacaoCPF;
  private Criptografia criptografia;
  private AutenticacaoData autenticaData;
  private AutenticacaoData autenticaNascimento;
  private ValidarEmail validarEmail;
  
  public boolean validarCPF(String cpf){
    validacaoCPF = new ValidarCPF();
    return validacaoCPF.isCPF(cpf);
  }
  
  public String encriptarSenha(String senha){
    criptografia = new Criptografia();
    return criptografia.encriptar(senha);
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
    validarEmail = new ValidarEmail();
    return validarEmail.validarEmail(email);
  }
}