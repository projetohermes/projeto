package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ListaDeTurma_Curso_Turno;
import model.Turma;

public class TurmaDAO {

    static Connection conexao = null;
    
        public static void inserir(String nome, int idCurso, int idTurno) {
        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "insert into turma (nome, curso, turno) values (?,?,?)";
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setString(1, nome);
                ps.setInt(2, idCurso);
                ps.setInt(3, idTurno);
                
                ps.executeUpdate();
                ps.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("TurmaDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }
        
    public static List<Turma> listarTurmas() {

        List<Turma> lista = null;

        try{
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from turma";
                Statement s = conexao.createStatement();

                ResultSet rs = s.executeQuery(sql);

                lista = new ArrayList<Turma>();
                
                while (rs.next()) {
                    lista.add(new Turma(
                            rs.getInt("idTurma"),
                            rs.getString("nome")));
                }
                s.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {

            Logger.getLogger("TurmaDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }

    public static int buscarId(String nome) {

        int id = 0;

        try {
            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {
                String sql = "select idturma from turma where nome = ?";
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
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return id;
    }
    
    public static List<ListaDeTurma_Curso_Turno> listarTurmaCursoTurno() {

        List<ListaDeTurma_Curso_Turno> lista = null;

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select * from turma_curso_turno_view";
                Statement s = conexao.createStatement();
                ResultSet rs = s.executeQuery(sql);
                
                lista = new ArrayList<ListaDeTurma_Curso_Turno>();

                while (rs.next()) {
                    lista.add(new ListaDeTurma_Curso_Turno(
                            rs.getInt("idTurma"),
                            rs.getString("turma"),
                            rs.getString("curso"),
                            rs.getString("turno")));
                }
                s.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {

            Logger.getLogger("Turma_Turno_CursoDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return lista;
    }
    
    public static List<Integer> listarAlunosId(int idTurma) {

        List<Integer> lista = null;
        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select pessoa.idpessoa, aluno.idpessoa, aluno.matricula, turma_aluno.aluno_matricula, turma_aluno.turma_idturma from pessoa, aluno, turma_aluno where pessoa.idpessoa = aluno.idpessoa and turma_aluno.aluno_matricula = aluno.matricula and turma_aluno.turma_idturma = ?";
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setInt(1, idTurma);

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
    
    public static List<ListaDeTurma_Curso_Turno> listarTurmaCursoTurno_PorTurma(String turma) {

        List<ListaDeTurma_Curso_Turno> turmas = null;

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "select turma, turno, curso from turma_curso_turno_view where turma = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.setString(1, turma);

                ResultSet rs = ps.executeQuery();
                
                turmas = new ArrayList<ListaDeTurma_Curso_Turno>();

                while (rs.next()) {
                    turmas.add(new ListaDeTurma_Curso_Turno(
                             rs.getString("turma"),
                             rs.getString("turno"),
                             rs.getString("curso")));
                }

                ps.close();
                rs.close();
                conexao.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger("UsuarioDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }

        return turmas;
    }
    
    public static void atualizar(String nome, int curso, int turno, int idTurma) {

        try {

            conexao = ConexaoMySQL.abrirConexao();
            if (conexao != null) {

                String sql = "update turma set nome = ?, curso = ?, turno = ? where idturma = ?";

                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setString(1, nome);
                ps.setInt(2, curso);
                ps.setInt(3, turno);
                ps.setInt(4, idTurma);

                ps.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger("TurmaDAO").log(Level.SEVERE, "SQLException: {0}", ex.getMessage());
        }
    }
}
