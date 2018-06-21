package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.ListaPresenca;

/**
 *
 * @author jhon_
 */
public class ListaPresencaDAO {
   
    public void inserir(ListaPresenca presenca) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String insert_sql = "INSERT INTO presenca (idAluno, idAula, presente, data) VALUES(?,?,?,?)";
        String update_sql = "UPDATE presenca SET idAluno = ?, idAula = ?, presente = ?, data = ? WHERE id = ?";
        try { 
            if (presenca.getId() == 0)
                stmt = con.prepareStatement(insert_sql);
            else {
                stmt = con.prepareStatement(update_sql);
                stmt.setShort(5, presenca.getId());
            }
                      
            stmt.setShort(1, presenca.getIdAluno());
            stmt.setShort(2, presenca.getIdAula());
            stmt.setBoolean(3, presenca.isPresente());
            stmt.setDate(4, new Date (presenca.getData().getTime()));           
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void inserir(List<ListaPresenca> presencas) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO presenca (idAluno, idAula, presente, data) VALUES(?,?,?,?)";
        try { 
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            Iterator<ListaPresenca> it = presencas.iterator();
            while (it.hasNext()){
                ListaPresenca presenca = it.next();
                stmt.setShort(1, presenca.getIdAluno());
                stmt.setShort(2, presenca.getIdAula());
                stmt.setBoolean(3, presenca.isPresente());
                stmt.setDate(4, new Date (presenca.getData().getTime()));
                stmt.addBatch();
            }
            int[] numUpdates = stmt.executeBatch();
            for (int i = 0; i < numUpdates.length; i++) {
                if (numUpdates[i] == -2) {
                    System.out.println("Execution " + i
                            + ": unknown number of rows updated");
                } else {
                    System.out.println("Execution " + i
                            + "successful: " + numUpdates[i] + " rows updated");
                }
            }
            con.commit();
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    
    
    public List<ListaPresenca> listar() {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ListaPresenca> presencas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM presenca");
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                ListaPresenca presenca = map(rs);
                presencas.add(presenca);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ListaPresencaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return presencas;        
    }
    
    public int count(short idAluno, short idAula) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            stmt = con.prepareStatement("SELECT * FROM presenca WHERE idAluno = ? AND idAula = ? AND presente = ?");
            stmt.setShort(1, idAluno);
            stmt.setShort(2, idAula);
            stmt.setBoolean(3, true);
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                count++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ListaPresencaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return count;        
    }
    
    public List<ListaPresenca> listar(short idAluno, short idAula) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ListaPresenca> presencas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM presenca WHERE idAluno = ? AND idAula = ?");
            stmt.setShort(1, idAluno);
            stmt.setShort(2, idAula);
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                ListaPresenca presenca = map(rs);
                presencas.add(presenca);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ListaPresencaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return presencas;        
    }
    
    private ListaPresenca map(ResultSet rs) throws SQLException {
        ListaPresenca presenca = new ListaPresenca();
        presenca.setId(rs.getShort("id"));
        presenca.setIdAluno(rs.getShort("idAluno"));
        presenca.setIdAula(rs.getShort("idAula"));
        presenca.setPresente(rs.getBoolean("idAula"));
        presenca.setData(rs.getDate("idAula"));
        return presenca;
    }
}

