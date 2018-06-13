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
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Aula;
import model.bean.Instrumento;

/**
 *
 * @author jhon_
 */
public class InstrumentoDAO {
   
    public void inserir(Instrumento instrumento) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        try {
            
            stmt = con.prepareStatement("INSERT INTO instrumento (nome, descricao, quantidade)"
                    + "VALUES(?,?,?)");
            
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
    
    public List<Instrumento> listar() {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Instrumento> instrumentos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM aluno");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
           
                Instrumento instrumento = new Instrumento();
                instrumento.setNome(rs.getString("nome"));
                instrumento.setDescricao(rs.getString("descricao"));
                instrumento.setQtdInstrumentos(rs.getInt("quantidade"));
                instrumentos.add(instrumento);               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(InstrumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return instrumentos;
        
    }
}

