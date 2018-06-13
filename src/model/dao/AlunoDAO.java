package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import model.bean.Aluno;

//Class Usuario DAO
public class AlunoDAO {
    
    public void inserir(Aluno aluno) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO aluno (cpf, nome, email, endereco, celular, nascimento, instrumento, aulas, presencas, datacad) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getEmail());
            
            stmt.setString(4, aluno.getEndereco());
            stmt.setString(5, aluno.getCelular());
            
            stmt.setString(6, aluno.getDataNascimento());
            stmt.setBoolean(7, aluno.getPossuiInstrumento());
            
            StringJoiner listaAulas = new StringJoiner(",");
            List<Short> idAulas = new ArrayList<>(aluno.getIdAula());
            idAulas.forEach((idAula) -> {
                listaAulas.add(idAula.toString());
            });            
            
            stmt.setString(8, listaAulas.toString());
            
            StringJoiner stringPresencas = new StringJoiner(",");
            List<Integer> listaPresencas = new ArrayList<Integer>(aluno.getListasPresenca());
            listaPresencas.forEach((listaPresenca) -> {
                listaAulas.add(listaPresenca.toString());
            });            
            
            stmt.setString(9, stringPresencas.toString());
            Timestamp dataCadastroStamp = new Timestamp(aluno.getDataCadastro().getTime());
            stmt.setTimestamp(10, dataCadastroStamp);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public List<Aluno> listar() {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM aluno");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Aluno aluno = new Aluno();
                aluno.setId(Short.parseShort(rs.getString("id")));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNome(rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setDataNascimento(rs.getString("nascimento"));
                aluno.setPossuiInstrumento(rs.getBoolean("instrumento"));
                List<String> idAulas = Arrays.asList(rs.getString("aulas").split(","));                
                aluno.setIdAula(idAulas.stream().map(s -> Short.parseShort(s)).collect(Collectors.toList()));
                List<String> listaPresencas = Arrays.asList(rs.getString("presencas").split(","));                
                aluno.setListasPresenca(idAulas.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList()));
                Date dataCadastro = new Date(rs.getTimestamp("datacad").getTime());
                aluno.setDataCadastro(dataCadastro);
                
                alunos.add(aluno);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return alunos;
        
    }
    
        public List<Aluno> procurarAlunos(short idAula) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Aluno> alunos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM aluno");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                if (rs.getString("aulas").contains(String.valueOf(idAula))){
                    Aluno aluno = new Aluno();
                    aluno.setId(Short.parseShort(rs.getString("id")));
                    aluno.setCpf(rs.getString("cpf"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setEmail(rs.getString("email"));
                    aluno.setDataNascimento(rs.getString("nascimento"));
                    aluno.setPossuiInstrumento(rs.getBoolean("instrumento"));
                    List<String> idAulas = Arrays.asList(rs.getString("aulas").split(","));
                    aluno.setIdAula(idAulas.stream().map(s -> Short.parseShort(s)).collect(Collectors.toList()));
                    List<String> listaPresencas = Arrays.asList(rs.getString("presencas").split(","));
                    aluno.setListasPresenca(listaPresencas.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList()));
                    Date dataCadastro = new Date(rs.getTimestamp("datacad").getTime());
                    aluno.setDataCadastro(dataCadastro);

                    alunos.add(aluno);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return alunos;
        
    }
}

