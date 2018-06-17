/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Instrumento;

/**
 *
 * @author jhon_
 */
public class InstrumentoDAO {
   
    public void inserir(Instrumento instrumento) {
        
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;
        
        String insert_sql = "INSERT INTO instrumento (nome, descricao, quantidade) VALUES(?,?,?)";
        String update_sql = "UPDATE instrumento SET nome = ?, descricao = ?, quantidade = ? WHERE id = ?";
        try {
            if (instrumento.getId() == 0)
                stmt = con.prepareStatement(insert_sql);
            else {
                stmt = con.prepareStatement(update_sql);
                stmt.setShort(4, instrumento.getId());
            }
            
            stmt.setString(1,instrumento.getNome());
            stmt.setString(2, instrumento.getDescricao()); 
            stmt.setInt(3, instrumento.getQtdInstrumentos());
           
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void delete (short idInstrumento){
        Connection con = ConnectionFactory.getConnection();
        String sql = "DELETE FROM instrumento WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setShort(1, idInstrumento);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Instrumento de id " + String.valueOf(idInstrumento) + " deletado com sucesso!");            
        } catch (SQLException ex) {
            Logger.getLogger(InstrumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }        
    }
    
    public Instrumento find(short idInstrumento) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Instrumento instrumento = null;
        String sql = "SELECT * FROM instrumento WHERE id = ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setShort(1, idInstrumento);
            rs = stmt.executeQuery();

            if (rs.next()) {
                instrumento = map(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return instrumento;
    }
    
    public List<Instrumento> listar() {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Instrumento> instrumentos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM instrumento");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
           
                Instrumento instrumento = map(rs);
                instrumentos.add(instrumento);               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InstrumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return instrumentos;
        
    }
    
    private Instrumento map(ResultSet rs) throws SQLException {
        Instrumento instrumento = new Instrumento();
        instrumento.setNome(rs.getString("nome"));
        instrumento.setDescricao(rs.getString("descricao"));
        instrumento.setQtdInstrumentos(rs.getInt("quantidade"));
        return instrumento;
    }
}

