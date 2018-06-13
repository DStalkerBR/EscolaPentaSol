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

/**
 *
 * @author jhon_
 */
public class AulaDAO {
   
    public void inserir(Aula aula) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        try {
            
            stmt = con.prepareStatement("INSERT INTO aula (tipo, dia, horainicio, horafim, instrumento, idprofessor, qtdaula) "
                    + "VALUES(?,?,?,?,?,?,?)");
                      
            stmt.setString(1, aula.getTipoAula());
            stmt.setString(2, aula.getDiaSemana()); 
            stmt.setTime(3, new Time(aula.getHoraInicio().getTime()));
            stmt.setTime(4, new Time(aula.getHoraFim().getTime()));
            stmt.setString(5, aula.getInstrumentoNecessario());
            stmt.setShort(6, (short) aula.getIdProfessor());
            stmt.setShort(7, (short) aula.getQtdAula());
           
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Aula> listar() {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aula> aulas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM aluno");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Aula aula = new Aula();
                aula.setId(rs.getShort("id"));
                aula.setTipoAula(rs.getString("tipo"));
                aula.setHoraInicio(rs.getTime("horainicio"));
                aula.setHoraFim(rs.getTime("horafim"));
                aula.setInstrumentoNecessario(rs.getString("instrumento"));
                aula.setIdProfessor(rs.getShort("idprofessor"));
                aula.setQtdAula(rs.getShort("qtdaula"));
                aulas.add(aula);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return aulas;
        
    }
}

