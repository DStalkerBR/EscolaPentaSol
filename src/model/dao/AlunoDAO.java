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
        String insert_sql = "INSERT INTO aluno (cpf, nome, email, endereco, celular, nascimento, instrumento, aulas, presencas, datacad) VALUES(?,?,?,?,?,?,?,?,?)";
        String update_sql = "UPDATE aluno SET cpf = ?, nome = ?, email = ?, endereco = ?, celular = ?, nascimento = ?, instrumento = ?, aulas = ?,  datacad = ? WHERE id = ?";
        try {

            if (aluno.getId() == 0) {
                stmt = con.prepareStatement(insert_sql);
            } else {
                stmt = con.prepareStatement(update_sql);
                stmt.setShort(10, aluno.getId());
            }
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

            Timestamp dataCadastroStamp = new Timestamp(aluno.getDataCadastro().getTime());
            stmt.setTimestamp(9, dataCadastroStamp);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void delete (short idAluno){
        Connection con = ConnectionFactory.getConnection();
        String sql = "DELETE FROM aluno WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setShort(1, idAluno);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario de id " + String.valueOf(idAluno) + " deletado com sucesso!");            
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
                Aluno aluno = map(rs);
                alunos.add(aluno);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return alunos;

    }
    
    public List<Aluno> listar(short idAula) {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Aluno> alunos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM aluno");
            rs = stmt.executeQuery();

            while (rs.next()) {   
                String aulas = rs.getString("aulas");
                Aluno aluno;
                if (aulas.indexOf(idAula) >= 0) {                     
                    aluno = map(rs);
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

    public Aluno find(short idAluno) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aluno aluno = null;
        String sql = "SELECT * FROM aluno WHERE id = ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setShort(1, idAluno);
            rs = stmt.executeQuery();

            if (rs.next()) {
                aluno = map(rs);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return aluno;

    }

    private Aluno map(ResultSet rs) throws SQLException {
        Aluno aluno = new Aluno();
        aluno.setId(Short.parseShort(rs.getString("id")));
        aluno.setCpf(rs.getString("cpf"));
        aluno.setNome(rs.getString("nome"));
        aluno.setEmail(rs.getString("email"));
        aluno.setDataNascimento(rs.getString("nascimento"));
        aluno.setPossuiInstrumento(rs.getBoolean("instrumento"));
        List<String> idAulas = Arrays.asList(rs.getString("aulas").split(","));
        aluno.setIdAula(idAulas.stream().map(s -> Short.parseShort(s)).collect(Collectors.toList()));
        Date dataCadastro = new Date(rs.getTimestamp("datacad").getTime());
        aluno.setDataCadastro(dataCadastro);
        return aluno;
    }
}
