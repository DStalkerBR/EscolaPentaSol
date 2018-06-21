/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
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
        String insert_sql = "INSERT INTO aula (tipo, dia, horainicio, horafim, dataInicio, dataFim, instrumento, idprofessor, qtdaula) VALUES(?,?,?,?,?,?,?)";
        String update_sql = "UPDATE aula SET tipo = ?, dia = ?, horainicio = ?, horafim = ?, dataInicio = ?, dataFim = ?, instrumento = ?, idprofessor = ?, qtdaula = ? WHERE id = ?";
        try {
            if (aula.getId() == 0)
                stmt = con.prepareStatement(insert_sql);
            else {
                stmt = con.prepareStatement(update_sql);
                stmt.setShort(10, aula.getId());
            }
                      
            stmt.setString(1, aula.getTipoAula());
            stmt.setString(2, aula.getDiaSemana()); 
            stmt.setTime(3, new Time(aula.getHoraInicio().getTime()));
            stmt.setTime(4, new Time(aula.getHoraFim().getTime()));
            stmt.setDate(5, new Date(aula.getDataInicio().getTime()));
            stmt.setDate(6, new Date(aula.getDataFim().getTime()));
            stmt.setString(7, aula.getInstrumentoNecessario());
            stmt.setShort(8, (short) aula.getIdProfessor());
            stmt.setShort(9, (short) aula.getQtdAula());
           
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void delete (short idAula){
        Connection con = ConnectionFactory.getConnection();
        String sql = "DELETE FROM aula WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setShort(1, idAula);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Aula de id " + String.valueOf(idAula) + " deletada com sucesso!");            
        } catch (SQLException ex) {
            Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            ConnectionFactory.closeConnection(con, stmt);
        }        
    }
    
    public Aula find(short idAula) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aula aula = null;
        String sql = "SELECT * FROM aula WHERE id = ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setShort(1, idAula);
            rs = stmt.executeQuery();

            if (rs.next()) {
                aula = map(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return aula;

    }
    public List<Aula> listar() {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aula> aulas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM aula");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Aula aula = map(rs);
                aulas.add(aula);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return aulas;
        
    }
    
    public List<Aula> listar(short idProf) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aula> aulas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM aula WHERE idprofessor = ?");
            stmt.setShort(1, idProf);
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Aula aula = map(rs);
                aulas.add(aula);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AulaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return aulas;
        
    }
    
    private Aula map(ResultSet rs) throws SQLException {
        Aula aula = new Aula();
        aula.setId(rs.getShort("id"));
        aula.setTipoAula(rs.getString("tipo"));
        aula.setHoraInicio(rs.getTime("horainicio"));
        aula.setHoraFim(rs.getTime("horafim"));
        aula.setDataInicio(rs.getTime("dataInicio"));
        aula.setDataFim(rs.getTime("dataFim"));
        aula.setInstrumentoNecessario(rs.getString("instrumento"));
        aula.setIdProfessor(rs.getShort("idprofessor"));
        aula.setQtdAula(rs.getShort("qtdaula"));
        return aula;
    }
}

