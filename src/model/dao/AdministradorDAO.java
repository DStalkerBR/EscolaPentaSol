package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Administrador;

//Class Usuario DAO
public class AdministradorDAO {
    
    public void inserir(Administrador admin) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO administrador (login, senha, cpf, nome, email, endereco, celular, nascimento, tipo)"
                    + "VALUES(?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, admin.getLogin());
            stmt.setString(2, admin.getSenha());
            stmt.setString(3, admin.getCpf());
            stmt.setString(4, admin.getNome());
            stmt.setString(5, admin.getEmail());
            stmt.setString(6, admin.getEndereco());
            stmt.setString(7, admin.getCelular());            
            stmt.setString(8,admin.getDataNascimento());
            stmt.setString(9,admin.getTipoAdm());
                     
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Administrador> listar() {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Administrador> admins = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM administrador");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
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
               
                admins.add(admin);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return admins;
        
    }
    
        
}

