package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

public class AlunoDAO {

    static Connection conexao = null;

    public static void inserir(int matricula, int idPessoa, boolean bolsista, boolean representante) {
        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "insert into aluno (matricula, idpessoa, bolsista, representante) values (?,?,?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, matricula);
                ps.setInt(2, idPessoa);
                ps.setBoolean(3, bolsista);
                ps.setBoolean(4, representante);

                ps.executeUpdate();
                ps.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("AlunoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }

    public static void inserirAlunoTurma(int matricula, int idTurma) {
        try {
            conexao = ConexaoMySQL.abrirConexao();
            PreparedStatement ps = conexao.prepareStatement("insert into turma_aluno (aluno_matricula, turma_idturma) values(?,?)");

            ps.setInt(1, matricula);
            ps.setInt(2, idTurma);

            ps.executeUpdate();
            ps.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger("AlunoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }

    public static int buscarMatricula(int idPessoa) {

        int id = 0;

        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "select matricula from aluno where idpessoa = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, idPessoa);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    id = rs.getInt(1);
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

    public static List<ListaDeRepresentantes> listarRepresentantes() {

        List<ListaDeRepresentantes> lista = null;

        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from aluno_representantes_view";
                Statement s = conexao.createStatement();

                ResultSet rs = s.executeQuery(sql);

                lista = new ArrayList<ListaDeRepresentantes>();

                while (rs.next()) {
                    lista.add(new ListaDeRepresentantes(
                            rs.getInt("idpessoa"),
                            rs.getString("nome"),
                            rs.getString("curso"),
                            rs.getString("turma")));
                }
                s.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {

            Logger.getLogger("AlunoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }

    public static List<ListaDeBolsistas> listarBolsistas() {

        List<ListaDeBolsistas> lista = null;

        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from aluno_bolsistas_view";
                Statement s = conexao.createStatement();

                ResultSet rs = s.executeQuery(sql);

                lista = new ArrayList<ListaDeBolsistas>();

                while (rs.next()) {
                    lista.add(new ListaDeBolsistas(
                            rs.getInt("idpessoa"),
                            rs.getString("nome"),
                            rs.getString("curso"),
                            rs.getString("turma")));
                }
                s.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {

            Logger.getLogger("AlunoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }

    public static int buscarAlunoPorMatricula(int matricula) {

        int id = -1;

        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "select idpessoa from aluno where matricula = ?";
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

    public static List<ListaDeAlunos> listarAlunosEdicaoMatricula(int matricula) {

        List<ListaDeAlunos> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from aluno_turma_curso_view where matriculaaluno = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, matricula);

                ResultSet rs = ps.executeQuery();

                lista = new ArrayList<ListaDeAlunos>();

                while (rs.next()) {
                    lista.add(new ListaDeAlunos(
                            rs.getInt("matriculaaluno"),
                            rs.getString("nomealuno"),
                            rs.getString("turmaaluno"),
                            rs.getString("cursoaluno")));
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

    public static List<ListaDeAlunos> listarAlunosEdicaoNome(String nome) {

        List<ListaDeAlunos> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from aluno_turma_curso_view where nomealuno = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, nome);

                ResultSet rs = ps.executeQuery();

                lista = new ArrayList<ListaDeAlunos>();

                while (rs.next()) {
                    lista.add(new ListaDeAlunos(
                            rs.getInt("matriculaaluno"),
                            rs.getString("nomealuno"),
                            rs.getString("turmaaluno"),
                            rs.getString("cursoaluno")));
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

    public static List<ListaDeAlunos> listarAlunosEdicaoTurma(int turma) {

        List<ListaDeAlunos> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from aluno_turma_curso_view where turmaaluno = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, turma);

                ResultSet rs = ps.executeQuery();

                lista = new ArrayList<ListaDeAlunos>();

                while (rs.next()) {
                    lista.add(new ListaDeAlunos(
                            rs.getInt("matriculaaluno"),
                            rs.getString("nomealuno"),
                            rs.getString("turmaaluno"),
                            rs.getString("cursoaluno")));
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

    public static void excluirAluno(int matricula) {

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "delete from aluno where matricula = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, matricula);

                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }

    public static void excluirTurmaAluno(int matricula, int idTurma) {

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "delete from turma_aluno where aluno_matricula = ? and turma_idturma = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, matricula);
                ps.setInt(2, idTurma);

                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }
    
    public static void excluirTurmaAlunoTotal(int matricula) {

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "delete from turma_aluno where aluno_matricula = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setInt(1, matricula);

                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }

    public static DetalhesAlunos listarDetalhesAlunos(int matricula) {

        DetalhesAlunos detalhes = null;

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from detalhes_alunos_view where matricula = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, matricula);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    detalhes = new DetalhesAlunos(
                            rs.getInt("matricula"),
                            rs.getString("nome"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getDate("dataNascimento"),
                            rs.getBoolean("bolsista"),
                            rs.getBoolean("representante"));
                }

                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return detalhes;
    }

    public static Date listarDataNascimentoAluno(int matricula) {

        Date dataNascimento = null;

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select dataNascimento from detalhes_alunos_view where matricula = ?";

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
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return dataNascimento;
    }

    public static void atualizar(boolean bolsista, boolean representante, int idPessoa) {

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "update aluno set bolsista = ?, representante = ? where idpessoa = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setBoolean(1, bolsista);
                ps.setBoolean(2, representante);
                ps.setInt(3, idPessoa);

                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }

    public static List<CursosAlunos> listarCursosAluno(int matricula){
        
        List<CursosAlunos> cursos = null;

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select turmaaluno, cursoaluno, turno from aluno_turma_curso_view where matriculaaluno = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, matricula);

                ResultSet rs = ps.executeQuery();
                
                cursos = new ArrayList<CursosAlunos>();

                while (rs.next()) {
                    cursos.add(new CursosAlunos(
                            rs.getString("turmaaluno"),
                            rs.getString("cursoaluno"),
                            rs.getString("turno")));
                }

                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("AlunoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return cursos;
    }
    
    
}