package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DetalhesFuncionarios;
import model.Funcionario_Setor;

public class FuncionarioDAO {
    
    static Connection conexao = null;
    
    public static void inserir(int matricula, int idPessoa, int setor) {
        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "insert into funcionario (matricula, idpessoa, setor) values (?,?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                ps.setInt(1, matricula);
                ps.setInt(2, idPessoa);
                ps.setInt(3, setor);
                
                ps.executeUpdate();
                ps.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("FuncionarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }
    
    public static int buscarFuncionarioPorMatricula(int matricula) {
        
        int id = 0;
        
        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "select idpessoa from funcionario where matricula = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, matricula);
                
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    id = rs.getInt("idpessoa");
                }
                
                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("AlunoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
        
        return id;
    }
    
    public static List<Funcionario_Setor> listarFuncionariosEdicaoMatricula(int matricula) {
        
        List<Funcionario_Setor> lista = null;
        try {
            
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                
                String sql = "select * from funcionario_setor_view where matricula = ?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, matricula);
                
                ResultSet rs = ps.executeQuery();
                
                lista = new ArrayList<Funcionario_Setor>();
                
                while (rs.next()) {
                    lista.add(new Funcionario_Setor(
                            rs.getInt("matricula"),
                            rs.getString("nome"),
                            rs.getString("setor_nome")));
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
    
    public static List<Funcionario_Setor> listarFuncionariosEdicaoNome(String nome) {
        
        List<Funcionario_Setor> lista = null;
        try {
            
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                
                String sql = "select * from funcionario_setor_view where nome = ?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, nome);
                
                ResultSet rs = ps.executeQuery();
                
                lista = new ArrayList<Funcionario_Setor>();
                
                while (rs.next()) {
                    lista.add(new Funcionario_Setor(
                            rs.getInt("matricula"),
                            rs.getString("nome"),
                            rs.getString("setor_nome")));
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
    
    public static List<Funcionario_Setor> listarFuncionariosEdicaoSetor(String setor) {
        
        List<Funcionario_Setor> lista = null;
        try {
            
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                
                String sql = "select * from funcionario_setor_view where setor_nome = ?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, setor);
                
                ResultSet rs = ps.executeQuery();
                
                lista = new ArrayList<Funcionario_Setor>();
                
                while (rs.next()) {
                    lista.add(new Funcionario_Setor(
                            rs.getInt("matricula"),
                            rs.getString("nome"),
                            rs.getString("setor_nome")));
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
    
    public static DetalhesFuncionarios listarDetalhesFuncionarios(int matricula) {
        
        DetalhesFuncionarios detalhes = null;
        
        try {
            
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "select * from detalhes_funcionario_view where matricula = ?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                
                ps.setInt(1, matricula);
                
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    
                    detalhes = new DetalhesFuncionarios(
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getDate("dataNascimento"),
                            rs.getInt("matricula"),
                            rs.getString("nomesetor"));
                }
                
                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("FuncionarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
        return detalhes;
    }
    
    public static Date listarDataNascimentoFuncionario(int matricula) {

        Date dataNascimento = null;

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select dataNascimento from detalhes_funcionario_view where matricula = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, matricula);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    dataNascimento = rs.getDate("dataNascimento");
                }

                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("FuncionarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return dataNascimento;
    }
    
    public static void atualizar(int idSetor, int idPessoa) {

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "update funcionario set setor = ? where idpessoa = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, idSetor);
                ps.setInt(2, idPessoa);

                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger("FincionarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }
    
    public static void excluir(int matricula) {

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "delete from funcionario where matricula = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, matricula);

                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger("FuncionarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }
}
