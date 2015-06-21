
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;


public class UsuarioDAO {
    
    static Connection conexao = null;
    
    public static Usuario buscarPorLoginSenha(String login, String senha) {
       Usuario usuario = null;
        
        try {
            conexao = ConexaoMySQL.abrirConexao();
            if(conexao != null){
            PreparedStatement ps = conexao.prepareStatement("select login, senha from usuario where login = ? and senha = ?");
            
            ps.setString(1, login);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                usuario = new Usuario(
                rs.getString(1),
                rs.getString(1)
                );
            }
            rs.close();
            ps.close();
            conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
        
        return usuario;
    }
    
        public static int buscarMatricula(String login) {
            int matricula = 0;
        
        try {
            conexao = ConexaoMySQL.abrirConexao();
            if(conexao != null){
            PreparedStatement ps = conexao.prepareStatement("select matricula from usuario where login = ?");
            
            ps.setString(1, login);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                matricula = rs.getInt(1);
            }
            rs.close();
            ps.close();
            conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
        
        return matricula;
    }
    
}
