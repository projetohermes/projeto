
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexaoMySQL {
    
    public static Connection abrirConexao(){
        
        Connection conexao = null;
        
        String driver = "com.mysql.jdbc.Driver";
        
        try{
            Class.forName(driver);
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/easysendbd",
                    "root",
                    "1qaz2wsx"); 
            
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "SQLException: " + ex.getMessage());
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Exception: " + e.getMessage());
        }
        
        return conexao;
    }
}
