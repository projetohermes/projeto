package controller;

import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.ListaDeAlunos;

public class ManutencaoServlet extends HttpServlet {

    private static final String BUSCAR_ALUNO_EDICAO = "buscarAlunosEdicao";
    private static final String BUSCAR_TURMA_EDICAO = "buscarTurmasEdicao";
    private static final String BUSCAR_FUNCIONARIO_EDICAO = "buscarFuncionariosEdicao";
    private static final String BUSCAR_CURSO_EDICAO = "buscarCursosEdicao";
    private static final String EXCLUIR_ALUNO = "excluirAluno";
    private static final String EDITAR_ALUNO = "editarAluno";
    private static final String EDITAR_TURMA = "editarTurma";
    private static final String EDITAR_CURSO = "editarCurso";
    private static final String EDITAR_FUNCIONARIO = "editarFuncionario";
    private static final String ATUALIZAR_TURMA = "atualizarTurma";
    private static final String ATUALIZAR_ALUNO = "atualizarAluno";
    private static final String ATUALIZAR_FUNCIONARIO = "atualizarFuncionario";
    private static final String ATUALIZAR_CURSO = "atualizarCurso";
    private static final String EXCLUIR_ALUNO_TURMA = "excluirAlunoTurma";
    private static final String EXCLUIR_TURMA = "excluirTurma";
    private static final String EXCLUIR_FUNCIONARIO = "excluirFuncionario";
    private static final String EXCLUIR_CURSO = "excluirCurso";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String tarefa = request.getParameter("tarefa");

            if (tarefa.equals(BUSCAR_ALUNO_EDICAO)) {
                buscarAlunosEdicao(request, response);
            } else if (tarefa.equals(EXCLUIR_ALUNO)) {
                excluirAluno(request, response);
            } else if (tarefa.equals(EDITAR_ALUNO)) {
                editarAluno(request, response);
            } else if (tarefa.equals(ATUALIZAR_ALUNO)) {
                atualizarAluno(request, response);
            } else if (tarefa.equals(EXCLUIR_ALUNO_TURMA)) {
                excluirAlunoTurma(request, response);
            } else if (tarefa.equals(BUSCAR_TURMA_EDICAO)) {
                buscarTurmasEdicao(request, response);
            } else if (tarefa.equals(EDITAR_TURMA)) {
                editarTurma(request, response);
            } else if (tarefa.equals(ATUALIZAR_TURMA)) {
                atualizarTurma(request, response);
            } else if (tarefa.equals(EXCLUIR_TURMA)) {
                excluirTurma(request, response);
            } else if (tarefa.equals(BUSCAR_FUNCIONARIO_EDICAO)) {
                buscarFuncionariosEdicao(request, response);
            } else if (tarefa.equals(BUSCAR_CURSO_EDICAO)) {
                buscarCursosEdicao(request, response);
            } else if (tarefa.equals(EDITAR_CURSO)) {
                editarCurso(request, response);
            } else if (tarefa.equals(EDITAR_FUNCIONARIO)) {
                editarFuncionario(request, response);
            } else if (tarefa.equals(ATUALIZAR_FUNCIONARIO)) {
                atualizarFuncionario(request, response);
            } else if (tarefa.equals(ATUALIZAR_CURSO)) {
                atualizarCurso(request, response);
            } else if (tarefa.equals(EXCLUIR_FUNCIONARIO)) {
                excluirFuncionario(request, response);
            } else if (tarefa.equals(EXCLUIR_CURSO)) {
                //excluirCurso(request, response);
            }

        } finally {
            out.close();
        }
    }

    protected void buscarAlunosEdicao(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            String tipo = request.getParameter("tipoDeBusca");
            String dado = request.getParameter("dado");

            if (dado == "") {

                response.sendRedirect("manutencaoAluno.jsp?mensagem=*Campo de busca vazio!");

            } else {

                if (tipo.equals("#")) {

                    response.sendRedirect("manutencaoAluno.jsp?mensagem=*Escolha um tipo de busca!");

                } else {

                    if (tipo.equals("matricula")) {

                        request.setAttribute("alunos", AlunoDAO.listarAlunosEdicaoMatricula(Integer.parseInt(dado)));

                    } else if (tipo.equals("nome")) {

                        request.setAttribute("alunos", AlunoDAO.listarAlunosEdicaoNome(dado));

                    } else if (tipo.equals("turma")) {

                        request.setAttribute("alunos", AlunoDAO.listarAlunosEdicaoTurma(Integer.parseInt(dado)));
                    }

                    RequestDispatcher rd = request.getRequestDispatcher("manutencaoAluno.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (Exception erro) {

            response.sendRedirect("manutencaoAluno.jsp?mensagem=*Erro na busca");
        }
    }

    protected void buscarTurmasEdicao(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            String dado = request.getParameter("dado");

            if (dado == "") {

                response.sendRedirect("manutencaoTurma.jsp?mensagem=*Campo de busca vazio!");

            } else {

                request.setAttribute("turmas", TurmaDAO.listarTurmaCursoTurno_PorTurma(dado));

                RequestDispatcher rd = request.getRequestDispatcher("manutencaoTurma.jsp");
                rd.forward(request, response);
            }

        } catch (Exception erro) {

            response.sendRedirect("manutencaoTurma.jsp?mensagem=*Erro na busca");
        }
    }

    protected void excluirAluno(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int matricula = Integer.parseInt(request.getParameter("matricula"));

        if (JOptionPane.showConfirmDialog(null, "Gostaria de excluir o aluno de matricula " + matricula + " ?") == 0) {

            AlunoDAO.excluirTurmaAlunoTotal(matricula);
            int idPessoa = AlunoDAO.buscarAlunoPorMatricula(matricula);
            PessoaDAO.excluirSMSPessoa(idPessoa);
            AlunoDAO.excluirAluno(matricula);
            PessoaDAO.excluirPessoa(idPessoa);

            response.sendRedirect("manutencaoAluno.jsp?mensagem=*Aluno excluido com sucesso");

        } else {

            response.sendRedirect("manutencaoAluno.jsp");
        }
    }

    protected void editarAluno(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int matricula = Integer.parseInt(request.getParameter("matricula"));

        Date dataNascimento = AlunoDAO.listarDataNascimentoAluno(matricula);
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy"); //Formatando o estilo da data
        String dataFormato = dataFormatada.format(dataNascimento);

        request.setAttribute("data", dataFormato);
        request.setAttribute("alunos", AlunoDAO.listarDetalhesAlunos(matricula));
        request.setAttribute("cursos", AlunoDAO.listarCursosAluno(matricula));
        request.setAttribute("turmas", TurmaDAO.listarTurmas());

        RequestDispatcher rd = request.getRequestDispatcher("editarAluno.jsp");
        rd.forward(request, response);
    }

    protected void atualizarAluno(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int matricula = Integer.parseInt(request.getParameter("matricula"));
        String nome = request.getParameter("nome");
        String celular = request.getParameter("celular");
        String email = request.getParameter("email");
        boolean bolsista = Boolean.parseBoolean("bolsista");
        boolean representante = Boolean.parseBoolean("representante");

        if (nome == "" || celular == "" || email == "") {

            response.sendRedirect("ManutencaoServlet?tarefa=editarAluno&mensagem=*A atualizacao nao foi efetuada. Por favor tente novamente!");

        } else {

            int idPessoa = AlunoDAO.buscarAlunoPorMatricula(matricula);
            AlunoDAO.atualizar(bolsista, representante, idPessoa);
            PessoaDAO.atualizar(nome, celular, email, idPessoa);

            RequestDispatcher rd = request.getRequestDispatcher("ManutencaoServlet?tarefa=editarAluno&mensagem=*Atualizacao efetuada com sucesso.");
            rd.forward(request, response);
        }
    }

    protected void excluirAlunoTurma(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int matricula = Integer.parseInt(request.getParameter("matricula"));
        String turma = request.getParameter("turma");

        int idTurma = TurmaDAO.buscarId(turma);
        AlunoDAO.excluirTurmaAluno(matricula, idTurma);

        RequestDispatcher rd = request.getRequestDispatcher("ManutencaoServlet?tarefa=editarAluno&mensagem=*Excluído com sucesso.");
        rd.forward(request, response);

    }

    protected void editarTurma(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("nome");

        request.setAttribute("turma", nome);
        request.setAttribute("cursos", CursoDAO.listarCursos());
        request.setAttribute("turnos", TurnoDAO.listarTurnos());

        RequestDispatcher rd = request.getRequestDispatcher("editarTurma.jsp");
        rd.forward(request, response);
    }

    protected void atualizarTurma(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("nome");
        int idCurso = Integer.parseInt(request.getParameter("curso"));
        int idTurno = Integer.parseInt(request.getParameter("turno"));

        if (nome == "") {

            response.sendRedirect("ManutencaoServlet?tarefa=editarTurma&mensagem=*Falha na atualizacao.");
        } else {

            int idTurma = TurmaDAO.buscarId(nome);
            TurmaDAO.atualizar(nome, idCurso, idTurno, idTurma);
        }

        RequestDispatcher rd = request.getRequestDispatcher("ManutencaoServlet?tarefa=editarTurma&mensagem=*Atualizacao efetuada com sucesso.");
        rd.forward(request, response);
    }

    protected void excluirTurma(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int matricula = Integer.parseInt(request.getParameter("matricula"));

        if (JOptionPane.showConfirmDialog(null, "Gostaria de excluir o aluno de matricula " + matricula + " ?") == 0) {

            AlunoDAO.excluirTurmaAlunoTotal(matricula);
            int idPessoa = AlunoDAO.buscarAlunoPorMatricula(matricula);
            PessoaDAO.excluirSMSPessoa(idPessoa);
            AlunoDAO.excluirAluno(matricula);
            PessoaDAO.excluirPessoa(idPessoa);

            response.sendRedirect("manutencaoAluno.jsp?mensagem=*Aluno excluido com sucesso");

        } else {

            response.sendRedirect("manutencaoAluno.jsp");
        }
    }

    protected void buscarFuncionariosEdicao(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            String tipo = request.getParameter("tipoDeBusca");
            String dado = request.getParameter("dado");

            if (dado == "") {

                response.sendRedirect("manutencaoFuncionario.jsp?mensagem=*Campo de busca vazio!");

            } else {

                if (tipo.equals("#")) {

                    response.sendRedirect("manutencaoFuncionario.jsp?mensagem=*Escolha um tipo de busca!");

                } else {

                    if (tipo.equals("matricula")) {

                        request.setAttribute("funcionarios", FuncionarioDAO.listarFuncionariosEdicaoMatricula(Integer.parseInt(dado)));

                    } else if (tipo.equals("nome")) {

                        request.setAttribute("funcionarios", FuncionarioDAO.listarFuncionariosEdicaoNome(dado));

                    } else if (tipo.equals("setor")) {

                        request.setAttribute("funcionarios", FuncionarioDAO.listarFuncionariosEdicaoSetor(dado));
                    }

                    RequestDispatcher rd = request.getRequestDispatcher("manutencaoFuncionario.jsp");
                    rd.forward(request, response);
                }
            }
        } catch (Exception erro) {

            response.sendRedirect("manutencaoFuncionario.jsp?mensagem=*Erro na busca");
        }
    }

    protected void buscarSetoresEdicao(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            String dado = request.getParameter("dado");

            if (dado == "") {

                response.sendRedirect("manutencaoSetor.jsp?mensagem=*Campo de busca vazio!");

            } else {

                request.setAttribute("setores", SetorDAO.listarSetoresPorNome(dado));

                RequestDispatcher rd = request.getRequestDispatcher("manutencaoSetor.jsp");
                rd.forward(request, response);
            }

        } catch (Exception erro) {

            response.sendRedirect("manutencaoSetor.jsp?mensagem=*Erro na busca");
        }
    }

    protected void buscarCursosEdicao(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {

            String dado = request.getParameter("dado");
            String tipo = request.getParameter("tipoDeBusca");

            if (dado == "") {

                response.sendRedirect("manutencaoCurso.jsp?mensagem=*Campo de busca vazio!");

            } else if (tipo.equals("#")) {

                response.sendRedirect("manutencaoCurso.jsp?mensagem=*Escolha um tipo de busca");

            } else if (tipo.equals("nome")) {

                request.setAttribute("cursos", CursoDAO.listarCursosPorNome(dado));

            } else if (tipo.equals("tipo")) {

                request.setAttribute("cursos", CursoDAO.listarCursosPorTipo(dado));
            }

            RequestDispatcher rd = request.getRequestDispatcher("manutencaoCurso.jsp");
            rd.forward(request, response);

        } catch (Exception erro) {

            response.sendRedirect("manutencaoCurso.jsp?mensagem=*Erro na busca");
        }
    }

    protected void editarFuncionario(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        int matricula = Integer.parseInt(request.getParameter("matricula"));

        Date dataNascimento = FuncionarioDAO.listarDataNascimentoFuncionario(matricula);
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy"); //Formatando o estilo da data
        String dataFormato = dataFormatada.format(dataNascimento);

        request.setAttribute("funcionarios", FuncionarioDAO.listarDetalhesFuncionarios(matricula));
        request.setAttribute("setores", SetorDAO.listarSetores());
        request.setAttribute("data", dataFormato);

        RequestDispatcher rd = request.getRequestDispatcher("editarFuncionario.jsp");

        rd.forward(request, response);

    }

    protected void atualizarFuncionario(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {


            int matricula = Integer.parseInt(request.getParameter("matricula"));
            String nome = request.getParameter("nome");
            String celular = request.getParameter("celular");
            String email = request.getParameter("email");
            int idSetor = Integer.parseInt(request.getParameter("setor"));

            if (nome == "" || celular == "" || email == "") {

                response.sendRedirect("ManutencaoServlet?tarefa=editarFuncionario&mensagem=*A atualizacao nao foi efetuada. Por favor tente novamente!");

            } else {

                int idPessoa = FuncionarioDAO.buscarFuncionarioPorMatricula(matricula);
                FuncionarioDAO.atualizar(idSetor, idPessoa);
                PessoaDAO.atualizar(nome, celular, email, idPessoa);

                RequestDispatcher rd = request.getRequestDispatcher("ManutencaoServlet?tarefa=editarFuncionario&mensagem=*Atualizacao efetuada com sucesso.");
                rd.forward(request, response);
            }
        } catch (Exception e) {

            out.println("Erro na atualização");
        }
    }

    protected void excluirFuncionario(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int matricula = Integer.parseInt(request.getParameter("matricula"));

        if (JOptionPane.showConfirmDialog(null, "Gostaria de excluir o funcionario de matricula " + matricula + " ?") == 0) {

            int idPessoa = FuncionarioDAO.buscarFuncionarioPorMatricula(matricula);
            PessoaDAO.excluirSMSPessoa(idPessoa);
            FuncionarioDAO.excluir(matricula);
            PessoaDAO.excluirPessoa(idPessoa);

            response.sendRedirect("manutencaoFuncionario.jsp?mensagem=*Funcionario excluido com sucesso");

        } else {

            response.sendRedirect("manutencaoFuncionario.jsp");
        }
    }

    protected void editarCurso(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nome = request.getParameter("nome");
        int idCurso = CursoDAO.buscarId(nome);
        
        request.setAttribute("id", idCurso);
        request.setAttribute("curso", nome);
        request.setAttribute("tipos", TipoCursoDAO.listarTiposCursos());

        RequestDispatcher rd = request.getRequestDispatcher("editarCurso.jsp");
        rd.forward(request, response);
    }

    protected void atualizarCurso(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int idCurso = Integer.parseInt(request.getParameter("id"));
        String curso = request.getParameter("curso");
        int idTipo = Integer.parseInt(request.getParameter("tipo"));

        if (curso == "") {

            response.sendRedirect("ManutencaoServlet?tarefa=editarCurso&mensagem=*Falha na atualizacao.");
        } else {

            CursoDAO.atualizar(curso, idTipo, idCurso);
        }

        RequestDispatcher rd = request.getRequestDispatcher("ManutencaoServlet?tarefa=editarCurso&mensagem=*Atualizacao efetuada com sucesso.");
        rd.forward(request, response);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
