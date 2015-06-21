package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Setor;

public class SetorDAO {

    static Connection conexao = null;

    public static List<Setor> listarSetores() {

        List<Setor> lista = null;

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from setor";
                Statement s = conexao.createStatement();

                ResultSet rs = s.executeQuery(sql);

                lista = new ArrayList<Setor>();

                while (rs.next()) {
                    lista.add(new Setor(rs.getInt("idsetor"),
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

    public static void inserir(String nome) {
        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "insert into setor (nome) values (?)";
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setString(1, nome);

                ps.executeUpdate();
                ps.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("SetorDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }

    public static List<Integer> listarFuncionariosId(int idCurso) {

        List<Integer> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select pessoa.idpessoa, funcionario.idpessoa, funcionario.setor, setor.idsetor "
                        + "from pessoa, funcionario, setor where pessoa.idpessoa = funcionario.idpessoa and setor.idsetor = ? and funcionario.setor = setor.idsetor";

                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, idCurso);

                ResultSet rs = ps.executeQuery();

                lista = new ArrayList<Integer>();

                while (rs.next()) {
                    lista.add(new Integer(
                            rs.getInt("idpessoa")));
                }

                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }
    
    public static List<Setor> listarSetoresPorNome(String nome) {

        List<Setor> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select nome from setor where nome = ?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, nome);

                ResultSet rs = ps.executeQuery();

                lista = new ArrayList<Setor>();

                while (rs.next()) {
                    lista.add(new Setor(
                            rs.getString("nome")));
                }

                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }
}