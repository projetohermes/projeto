package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Curso;
import model.Curso_TipoCurso;

public class CursoDAO {

    static Connection conexao = null;

    public static List<Curso> listarCursos() {

        List<Curso> lista = null;

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from curso order by nome asc";
                Statement s = conexao.createStatement();
                ResultSet rs = s.executeQuery(sql);

                lista = new ArrayList<Curso>();

                while (rs.next()) {
                    lista.add(new Curso(rs.getInt("idCurso"),
                            rs.getString("nome")));
                }
                s.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {

            Logger.getLogger("CursoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }

    public static void inserir(String nome, int idTipoCurso) {
        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "insert into curso (nome, tipoturno) values (?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setString(1, nome);
                ps.setInt(2, idTipoCurso);

                ps.executeUpdate();
                ps.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("CursoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }

    public static List<Curso> listarCursosTiposCursos() {

        List<Curso> lista = null;

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from curso_tipocurso_view";
                Statement s = conexao.createStatement();
                ResultSet rs = s.executeQuery(sql);

                lista = new ArrayList<Curso>();

                while (rs.next()) {
                    lista.add(new Curso(rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("tipocurso")));
                }
                s.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {

            Logger.getLogger("CursoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }
    
    public static List<Integer> listarAlunosId(int idCurso) {

        List<Integer> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select pessoa.idpessoa, pessoa.nome, aluno.idpessoa, aluno.matricula, turma.idturma,turma.curso, "
                        + "turma_aluno.aluno_matricula, turma_aluno.turma_idturma, curso.idcurso, curso.nome from pessoa, aluno, "
                        + "turma, curso, turma_aluno where pessoa.idpessoa = aluno.idpessoa and "
                        + "aluno.matricula = turma_aluno.aluno_matricula and turma.idturma = "
                        + "turma_aluno.turma_idturma and curso.idcurso = ? and turma.curso = curso.idcurso;";
                
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
    
    public static List<Curso_TipoCurso> listarCursosPorNome(String nome) {

        List<Curso_TipoCurso> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select nome, tipocurso from curso_tipocurso_view where nome = ?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, nome);

                ResultSet rs = ps.executeQuery();

                lista = new ArrayList<Curso_TipoCurso>();

                while (rs.next()) {
                    lista.add(new Curso_TipoCurso(
                            rs.getString("nome"),
                            rs.getString("tipocurso")));
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
    
    public static List<Curso_TipoCurso> listarCursosPorTipo(String tipo) {

        List<Curso_TipoCurso> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select nome, tipocurso from curso_tipocurso_view where tipocurso = ?";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, tipo);

                ResultSet rs = ps.executeQuery();

                lista = new ArrayList<Curso_TipoCurso>();

                while (rs.next()) {
                    lista.add(new Curso_TipoCurso(
                            rs.getString("nome"),
                            rs.getString("tipocurso")));
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
    
    public static void atualizar(String nome, int tipo, int idCurso) {

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "update curso set nome = ?, tipoturno = ? where idcurso = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setString(1, nome);
                ps.setInt(2, tipo);
                ps.setInt(3, idCurso);

                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }
  
    public static int buscarId(String nome) {

        int id = 0;

        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "select idcurso from curso where nome = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, nome);

                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    id = rs.getInt(1);
                }

                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("CursoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return id;
    }
    
}
