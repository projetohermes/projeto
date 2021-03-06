
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Turno;


public class TurnoDAO {
    
    static Connection conexao = null;
    
    public static List<Turno> listarTurnos() {

        List<Turno> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from turno";
                Statement s = conexao.createStatement();
                
                ResultSet rs = s.executeQuery(sql);
                        
                lista = new ArrayList<Turno>();

                while (rs.next()) {
                    lista.add(new Turno(rs.getInt("idTurno"),
                            rs.getString("nome")));

                }
                s.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {

            Logger.getLogger("TurnoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }
    
}
