package model.dao;

import connection.ConnectionFactory;
import model.bean.Usuario;
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

//Class Usuario DAO
public class UsuarioDAO {

    public void create(Usuario usuario) {
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuario (cpf,nome,email, dataNascimento, possuiInstrumento, aulas) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, usuario.getCpf());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getDataNascimento());
            stmt.setBoolean(5, usuario.getPossuiInstrumento());
            StringJoiner listaAulas = new StringJoiner(",");
            
            for(Integer idAula: usuario.getIdAula()){ 
       		listaAulas.add(idAula.toString());
            } 			
            
            stmt.setString(6, listaAulas.toString());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println("Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Usuario> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();

                usuario.setId(Integer.parseInt(rs.getString("id")));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setDataNascimento(rs.getString("dataNascimento"));
                usuario.setPossuiInstrumento(rs.getBoolean("possuiInstrumento"));
              	List<String> idAulas = Arrays.asList(rs.getString("aulas").split(","));
                usuario.setIdAula(idAulas.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList()));
              	
                usuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return usuarios;

    }
}