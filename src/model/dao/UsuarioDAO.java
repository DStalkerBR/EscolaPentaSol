package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

//Class Administrador DAO 
public class UsuarioDAO {
    
   public boolean checarLogin(String login, String senha) {
       if (checarLoginAdm (login, senha))
           return true;
       return checarLoginProfessor(login,senha);
   }
   
 
  private boolean checarLoginAdm(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM administrador WHERE login = ? and senha = ?");
            stmt.setString(1, login); 
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            return rs.next(); 

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        } 

        return false;

    }
  
    private boolean checarLoginProfessor(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM professor WHERE login = ? and senha = ?");
            stmt.setString(1, login); 
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            return rs.next(); 

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        } 

        return false;

    }
  
}
