package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pessoa;

public class PessoaDAO {

    static Connection conexao = null;

    public static void inserir(String nome, String email, String telefone, Date dataNascimento) {
        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "insert into pessoa (nome, email, telefone, dataNascimento) values (?,?,?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setString(1, nome);
                ps.setString(2, email);
                ps.setString(3, telefone);
                ps.setDate(4, dataNascimento);

                ps.executeUpdate();
                ps.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("PessoaDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }

    public static int buscarMaiorId() {

        int maiorId = 0;

        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                Statement ps = conexao.createStatement();

                ResultSet rs = ps.executeQuery("select max(idpessoa) from pessoa");

                while (rs.next()) {
                    maiorId = rs.getInt(1);
                }

                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("PessoaDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return maiorId;
    }

    public static List<Pessoa> listarAlunos() {

        List<Pessoa> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select pessoa.idpessoa, pessoa.nome, aluno.idpessoa from pessoa, aluno where pessoa.idpessoa = aluno.idpessoa";
                Statement s = conexao.createStatement();

                ResultSet rs = s.executeQuery(sql);

                lista = new ArrayList<Pessoa>();

                while (rs.next()) {
                    lista.add(new Pessoa(
                            rs.getInt("idpessoa"),
                            rs.getString("nome")));

                }
                s.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {

            Logger.getLogger("PessoaDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }

    public static List<Pessoa> listarAlunosTurmas(int idTurma) {

        List<Pessoa> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select pessoa.idpessoa, pessoa.nome, aluno.idpessoa, "
                        + "turma_aluno.turma_idturma from pessoa, aluno, turma_aluno "
                        + "where pessoa.idpessoa = aluno.idpessoa and "
                        + "turma_aluno.aluno_matricula = aluno.matricula and turma_aluno.turma_idturma = ?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, idTurma);

                ResultSet rs = ps.executeQuery();

                lista = new ArrayList<Pessoa>();

                while (rs.next()) {
                    lista.add(new Pessoa(
                            rs.getInt("idpessoa"),
                            rs.getString("nome")));
                }

                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("PessoaDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }

    public static String buscarTelefone(int pessoa) {
        String telefone = null;

        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                PreparedStatement ps = conexao.prepareStatement("select telefone from pessoa "
                        + "where idpessoa = ?");

                ps.setInt(1, pessoa);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    telefone = rs.getString("telefone");
                }
                rs.close();
                ps.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("PessoaDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return telefone;
    }

    public static List<Pessoa> listarFuncionarios(int idSetor) {

        List<Pessoa> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select pessoa.idpessoa, pessoa.nome, funcionario.idpessoa, "
                        + "funcionario.setor from pessoa, funcionario "
                        + "where pessoa.idpessoa = funcionario.idpessoa and funcionario.setor = ?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, idSetor);

                ResultSet rs = ps.executeQuery();

                lista = new ArrayList<Pessoa>();

                while (rs.next()) {
                    lista.add(new Pessoa(
                            rs.getInt("idpessoa"),
                            rs.getString("nome")));
                }

                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("PessoaDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }

    public static void excluirPessoa(int idPessoa) {

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "delete from pessoa where idpessoa = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, idPessoa);

                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }

    public static void excluirSMSPessoa(int idPessoa) {

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "delete from sms_pessoa where pessoa_idpessoa = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, idPessoa);

                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }

    public static void atualizar(String nome, String celular, String email, int idPessoa) {

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "update pessoa set nome = ?, telefone = ?, email = ? where idpessoa = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setString(1, nome);
                ps.setString(2, celular);
                ps.setString(3, email);
                ps.setInt(4, idPessoa);

                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }
}
