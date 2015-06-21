
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TipoCurso;


public class TipoCursoDAO {
    
    static Connection conexao = null;
    
        public static List<TipoCurso> listarTiposCursos() {

        List<TipoCurso> lista = null;

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from tipocurso";
                Statement s = conexao.createStatement();

                ResultSet rs = s.executeQuery(sql);

                lista = new ArrayList<TipoCurso>();

                while (rs.next()) {
                    lista.add(new TipoCurso(rs.getInt("idtipoturno"),
                            rs.getString("nome")));
                }
                s.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {

            Logger.getLogger("SetorDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }
    
}
