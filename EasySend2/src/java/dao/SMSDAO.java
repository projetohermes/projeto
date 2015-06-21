package dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SMSDAO {

    static Connection conexao = null;

    public static void inserir(int matricula, String mensagem, String data, String hora) {
        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "insert into sms (usuario, mensagem, data, hora) values (?,?,?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, matricula);
                ps.setString(2, mensagem);
                ps.setString(3, data);
                ps.setString(4, hora);

                ps.executeUpdate();
                ps.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("SMSDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }

    public static int buscarMaiorId() {

        int maiorId = 0;

        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                Statement ps = conexao.createStatement();

                ResultSet rs = ps.executeQuery("select max(idsms) from sms");

                while (rs.next()) {
                    maiorId = rs.getInt(1);
                }

                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("SMSDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return maiorId;
    }
    
    public static void gravarSMS(int idSMS, int aluno) {
        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "insert into sms_pessoa (sms_idsms, pessoa_idpessoa) values (?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, idSMS);
                ps.setInt(2, aluno);

                ps.executeUpdate();
                ps.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("SMSDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }
}
