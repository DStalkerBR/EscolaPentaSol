package validacoes;

//Classe Criptografia
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class Criptografia {

    public static String encriptar(String senha) {

        MessageDigest algorithm = null;

        try {
            algorithm = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

        byte messageDigest[] = null;

        try {
            messageDigest = algorithm.digest(senha.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        StringBuilder hexString = new StringBuilder();
        for(byte b : messageDigest){
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String senha_criptografada = hexString.toString();
        return senha_criptografada;

    }   
}