package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.bean.Administrador;
import model.bean.Professor;

//Class Administrador DAO 
public class UsuarioDAO {
    
   public Object checarLogin(String login, String senha) {
       Administrador admin;
       if ((admin = (Administrador)checarLoginAdm (login, senha)) != null)
           return admin;
       return checarLoginProfessor(login,senha);
   }
   
 
  private Object checarLoginAdm(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM administrador WHERE login = ? and senha = ?");
            stmt.setString(1, login); 
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()){ 
                Administrador admin = new Administrador();
                admin.setIdAdm(rs.getShort("id"));
                admin.setLogin(rs.getString("login"));
                admin.setCpf(rs.getString("cpf"));
                admin.setNome(rs.getString("nome"));
                admin.setEmail(rs.getString("email"));
                admin.setEndereco(rs.getString("endereco"));
                admin.setCelular(rs.getString("celular"));
                admin.setDataNascimento(rs.getString("nascimento"));
                admin.setTipoAdm(rs.getString("tipo"));
                return admin;
            }
                

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        } 

        return null;

    }
  
    private Object checarLoginProfessor(String login, String senha) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM professor WHERE login = ? and senha = ?");
            stmt.setString(1, login); 
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()){
                Professor prof = new Professor();
                prof.setId(rs.getShort("id"));
                prof.setLogin(rs.getString("login"));
                prof.setCpf(rs.getString("cpf"));
                prof.setNome(rs.getString("nome"));
                prof.setEmail(rs.getString("email"));
                prof.setEndereco(rs.getString("endereco"));
                prof.setCelular(rs.getString("celular"));
                prof.setDataNascimento(rs.getString("nascimento"));
                List<String> idAulas = Arrays.asList(rs.getString("aulas").split(","));                
                prof.setIdAula(idAulas.stream().map(s -> Short.parseShort(s)).collect(Collectors.toList()));
                List<String> especializacoes = Arrays.asList(rs.getString("presencas").split(","));                
                prof.setEspecializacoes(especializacoes.stream().map(s -> Short.parseShort(s)).collect(Collectors.toList()));
                return prof;
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        } 

        return null;

    }
  
}
