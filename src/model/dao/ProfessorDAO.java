package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import model.bean.Professor;

//Class Usuario DAO
public class ProfessorDAO {
    
    public void inserir(Professor prof) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO professor (login, senha, cpf, nome, email, endereco, celular, nascimento, aulas, especializacao) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, prof.getLogin());
            stmt.setString(2, prof.getSenha());
            stmt.setString(3, prof.getCpf());
            stmt.setString(4, prof.getNome());
            stmt.setString(5, prof.getEmail());            
            stmt.setString(6, prof.getEndereco());
            stmt.setString(7, prof.getCelular());            
            stmt.setString(8, prof.getDataNascimento());
  
            
            StringJoiner stringAulas = new StringJoiner(",");
            List<Short> idAulas = new ArrayList<>(prof.getIdAula());
            idAulas.forEach((idAula) -> {
                stringAulas.add(idAula.toString());
            });            
            
            stmt.setString(9, stringAulas.toString());
            
            StringJoiner stringEspecializacoes = new StringJoiner(",");
            List<Short> listaEspecializacoes = new ArrayList<Short>(prof.getEspecializacoes());
            listaEspecializacoes.forEach((especializacao) -> {
                stringAulas.add(especializacao.toString());
            });            
            
            stmt.setString(10, stringEspecializacoes.toString());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Professor> listar() {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Professor> profs = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM professor");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
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
                
                profs.add(prof);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return profs;
        
    }
    
}
