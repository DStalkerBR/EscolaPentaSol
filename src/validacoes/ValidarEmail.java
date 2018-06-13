package validacoes;

//Classe ValidarEmail
public class ValidarEmail {

    private static String ePadrao;

    public static boolean validarEmail(String email){
      	if (!email.isEmpty()){
        	 ePadrao = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
       		 java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePadrao);
        	java.util.regex.Matcher m = p.matcher(email);
        	return m.matches();
        }
      	return false;
    }
}
