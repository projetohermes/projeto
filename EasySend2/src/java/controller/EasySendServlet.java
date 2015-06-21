package controller;

import dao.*;
import externo.Conn;
import externo.EnvioPlaca;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

public class EasySendServlet extends HttpServlet {

    private static final String LOGIN = "login";
    private static final String CADASTRAR_ALUNO = "cadastrarAluno";
    private static final String BUSCAR_TURMAS = "buscarTurmas";
    private static final String BUSCAR_SETORES = "buscarSetores";
    private static final String CADASTRAR_FUNCIONARIO = "cadastrarFuncionario";
    private static final String CADASTRAR_TURMA = "cadastrarTurma";
    private static final String BUSCAR_CURSOS_TURMAS = "buscarCursosTurnos";
    private static final String BUSCAR_TIPOS = "buscarTipos";
    private static final String CADASTRAR_CURSO = "cadastrarCurso";
    private static final String CADASTRAR_SETOR = "cadastrarSetor";
    private static final String BUSCAR_ALUNOS = "buscarAlunos";
    private static final String BUSCAR_ALUNOS_TURMAS = "buscarAlunosTurmas";
    private static final String ENVIAR_SMS_ALUNO = "enviarSMSAluno";
    private static final String BUSCAR_REPRESENTANTES = "buscarRepresentantes";
    private static final String ENVIAR_SMS_REPRESENTANTE = "enviarSMSRepresentante";
    private static final String ENVIAR_SMS_BOLSISTA = "enviarSMSBolsista";
    private static final String BUSCAR_BOLSISTAS = "buscarBolsistas";
    private static final String BUSCAR_TURMA_CURSO_TURNO = "buscarTurmaCursoTurno";
    private static final String ENVIAR_SMS_TURMA = "enviarSMSTurma";
    private static final String ENVIAR_SMS_FUNCIONARIO = "enviarSMSFuncionario";
    private static final String BUSCAR_FUNCIONARIOS = "buscarFuncionarios";
    private static final String BUSCAR_CURSOS = "buscarCursos";
    private static final String ENVIAR_SMS_CURSO = "enviarSMSCurso";
    private static final String ENVIAR_SMS_SETOR = "enviarSMSSetor";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String tarefa = request.getParameter("tarefa");

            if (tarefa.equals(LOGIN)) {
                validarLogin(request, response);
            } else if (tarefa.equals(CADASTRAR_ALUNO)) {
                cadastrarAluno(request, response);
            } else if (tarefa.equals(BUSCAR_TURMAS)) {
                buscarTurmas(request, response);
            } else if (tarefa.equals(BUSCAR_SETORES)) {
                buscarSetores(request, response);
            } else if (tarefa.equals(CADASTRAR_FUNCIONARIO)) {
                cadastrarFuncionario(request, response);
            } else if (tarefa.equals(CADASTRAR_TURMA)) {
                cadastrarTurma(request, response);
            } else if (tarefa.equals(BUSCAR_CURSOS_TURMAS)) {
                buscarCursosTurnos(request, response);
            } else if (tarefa.equals(BUSCAR_TIPOS)) {
                buscarTipos(request, response);
            } else if (tarefa.equals(CADASTRAR_CURSO)) {
                cadastrarCurso(request, response);
            } else if (tarefa.equals(CADASTRAR_SETOR)) {
                cadastrarSetor(request, response);
            } else if (tarefa.equals(BUSCAR_ALUNOS)) {
                buscarAlunos(request, response);
            } else if (tarefa.equals(BUSCAR_ALUNOS_TURMAS)) {
                buscarAlunosTurmas(request, response);
            } else if (tarefa.equals(ENVIAR_SMS_ALUNO)) {
                enviarSMSAluno(request, response);
            } else if (tarefa.equals(BUSCAR_REPRESENTANTES)) {
                buscarRepresentantes(request, response);
            } else if (tarefa.equals(ENVIAR_SMS_REPRESENTANTE)) {
                enviarSMSRepresentante(request, response);
            } else if (tarefa.equals(ENVIAR_SMS_BOLSISTA)) {
                enviarSMSBolsista(request, response);
            } else if (tarefa.equals(BUSCAR_BOLSISTAS)) {
                buscarBolsistas(request, response);
            } else if (tarefa.equals(BUSCAR_TURMA_CURSO_TURNO)) {
                buscarTurmaCursoTurno(request, response);
            } else if (tarefa.equals(ENVIAR_SMS_TURMA)) {
                enviarSMSTurma(request, response);
            } else if (tarefa.equals(ENVIAR_SMS_FUNCIONARIO)) {
                enviarSMSFuncionario(request, response);
            } else if (tarefa.equals(BUSCAR_FUNCIONARIOS)) {
                buscarFuncionarios(request, response);
            } else if (tarefa.equals(BUSCAR_CURSOS)) {
                buscarCursos(request, response);
            } else if (tarefa.equals(ENVIAR_SMS_CURSO)) {
                enviarSMSCurso(request, response);
            } else if (tarefa.equals(ENVIAR_SMS_SETOR)) {
                enviarSMSSetor(request, response);
            }

        } finally {
            out.close();
        }
    }

    protected void validarLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=iso-8859-1");
        PrintWriter out = response.getWriter();

        Usuario usuario = new Usuario();

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        usuario = UsuarioDAO.buscarPorLoginSenha(login, senha);

        if (usuario == null) {
            response.sendRedirect("index.jsp?mensagem=*login ou senha invalidos!");
        } else {
            request.setAttribute("usuario", usuario);
            // Redireciona
            RequestDispatcher rd = request.getRequestDispatcher("/menuPrincipal.jsp");
            rd.forward(request, response);
        }
    }

    protected void cadastrarAluno(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, Exception {
        PrintWriter out = response.getWriter();

        Pessoa pessoa = new Pessoa();
        Aluno aluno = new Aluno();

        String nome = request.getParameter("nome");
        String telefone = request.getParameter("celular");
        telefone = telefone.replaceAll("-", "");
        String email = request.getParameter("email");
        String dataString = request.getParameter("dataNascimento");
        String matriculaString = request.getParameter("matricula");
        int idTurma = Integer.parseInt(request.getParameter("turmas"));
        boolean bolsista = Boolean.parseBoolean(request.getParameter("bolsista"));
        boolean representante = Boolean.parseBoolean(request.getParameter("representante"));

        if (bolsista != true) {
            bolsista = false;
        }

        if (representante != true) {
            representante = false;
        }

        if (nome == "" || telefone == "" || email == "" || dataString == "" || matriculaString == "") {

            response.sendRedirect("EasySendServlet?tarefa=buscarTurmas&mensagem=*O cadastro nao foi efetuado. Por favor tente novamente!&page=/cadastrarAluno.jsp");

        } else {

            int matricula = Integer.parseInt(matriculaString);

            int id = AlunoDAO.buscarAlunoPorMatricula(matricula);

            //if (matricula != -1) {

              //  response.sendRedirect("EasySendServlet?tarefa=buscarTurmas&mensagem=*O cadastro nao foi efetuado. Ja existe aluno cadastrado com essa matricula!&page=/cadastrarAluno.jsp");

            //} else {

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date dataNascimento = new java.sql.Date(format.parse(dataString).getTime());

                PessoaDAO.inserir(nome, email, telefone, dataNascimento);

                int idPessoa = PessoaDAO.buscarMaiorId();

                AlunoDAO.inserir(matricula, idPessoa, bolsista, representante);

                AlunoDAO.inserirAlunoTurma(matricula, idTurma);

                //Redirecionamento
                RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarTurmas&mensagem=*Cadastro efetuado com sucesso.&page=/cadastrarAluno.jsp");
                rd.forward(request, response);
            }
       // }
    }

    protected void cadastrarFuncionario(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, Exception {
        PrintWriter out = response.getWriter();

        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();

        String nome = request.getParameter("nome");
        String telefone = request.getParameter("celular");
        String email = request.getParameter("email");
        String dataString = request.getParameter("dataNascimento");
        String matriculaString = request.getParameter("matricula");
        int idSetor = Integer.parseInt(request.getParameter("setores"));

        if (nome == "" || telefone == "" || email == "" || dataString == "" || matriculaString == "" || idSetor == 0) {

            response.sendRedirect("EasySendServlet?tarefa=buscarSetores&mensagem=*O cadastro nao foi efetuado. Por favor tente novamente!&page=/cadastrarFuncionario.jsp");

        } else {

            int matricula = Integer.parseInt(matriculaString);

            if (matricula != 0) {

                response.sendRedirect("EasySendServlet?tarefa=buscarTurmas&mensagem=*O cadastro nao foi efetuado. Ja existe funcionario cadastrado com essa matricula!&page=/cadastrarFuncionario.jsp");

            } else {

                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                java.sql.Date dataNascimento = new java.sql.Date(format.parse(dataString).getTime());

                PessoaDAO.inserir(nome, email, telefone, dataNascimento);

                int idPessoa = PessoaDAO.buscarMaiorId();

                FuncionarioDAO.inserir(matricula, idPessoa, idSetor);

                //Redirecionamento
                RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarSetores&mensagem=*Cadastro efetuado com sucesso.&page=/cadastrarFuncionario.jsp");
                rd.forward(request, response);
            }
        }
    }

    protected void cadastrarTurma(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, Exception {
        PrintWriter out = response.getWriter();

        Turma turma = new Turma();

        String nome = request.getParameter("nome");
        int idSetor = Integer.parseInt(request.getParameter("cursos"));
        int idTurno = Integer.parseInt(request.getParameter("turnos"));

        if (nome == "" || idSetor == 0 || idTurno == 0) {

            response.sendRedirect("EasySendServlet?tarefa=buscarCursosTurnos&mensagem=*O cadastro nao foi efetuado. Por favor tente novamente!");

        } else {

            TurmaDAO.inserir(nome, idSetor, idTurno);

            //Redirecionamento
            RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarCursosTurnos&mensagem=*Cadastro efetuado com sucesso.");
            rd.forward(request, response);
        }
    }

    protected void cadastrarCurso(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, Exception {
        PrintWriter out = response.getWriter();

        Curso curso = new Curso();

        String nome = request.getParameter("nome");
        int idTipoCurso = Integer.parseInt(request.getParameter("tipos"));

        if (nome == "" || idTipoCurso == 0) {

            response.sendRedirect("EasySendServlet?tarefa=buscarTipos&mensagem=*O cadastro nao foi efetuado. Por favor tente novamente!");

        } else {

            CursoDAO.inserir(nome, idTipoCurso);

            //Redirecionamento
            RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarTipos&mensagem=*Cadastro efetuado com sucesso.");
            rd.forward(request, response);
        }
    }

    protected void cadastrarSetor(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException, Exception {
        PrintWriter out = response.getWriter();

        Setor setor = new Setor();

        String nome = request.getParameter("nome");

        if (nome == "") {

            response.sendRedirect("cadastrarSetor.jsp?mensagem=*O cadastro nao foi efetuado. Por favor tente novamente!");

        } else {

            SetorDAO.inserir(nome);

            //Redirecionamento
            RequestDispatcher rd = request.getRequestDispatcher("cadastrarSetor.jsp?mensagem=*Cadastro efetuado com sucesso.");
            rd.forward(request, response);
        }
    }

    protected void buscarTurmas(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String page = request.getParameter("page");

        // Fazendo as devidas buscas no banco de dados
        request.setAttribute("turmas", TurmaDAO.listarTurmas());
        //request.setAttribute("cursos", CursoDAO.listarCursos());
        //request.setAttribute("turnos", TurnoDAO.listarTurnos());

        // Redireciona        
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    protected void buscarSetores(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String page = request.getParameter("page");

        // Fazendo as devidas buscas no banco de dados
        request.setAttribute("setores", SetorDAO.listarSetores());

        // Redireciona        
        RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
    }

    protected void buscarCursosTurnos(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Fazendo as devidas buscas no banco de dados
        request.setAttribute("cursos", CursoDAO.listarCursos());
        request.setAttribute("turnos", TurnoDAO.listarTurnos());

        // Redireciona        
        RequestDispatcher rd = request.getRequestDispatcher("/cadastrarTurma.jsp");
        rd.forward(request, response);
    }

    protected void buscarTipos(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Fazendo as devidas buscas no banco de dados
        request.setAttribute("tipos", TipoCursoDAO.listarTiposCursos());

        // Redireciona        
        RequestDispatcher rd = request.getRequestDispatcher("/cadastrarCurso.jsp");
        rd.forward(request, response);
    }

    protected void buscarTurnos(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        request.setAttribute("turnos", TurnoDAO.listarTurnos());

        RequestDispatcher rd = request.getRequestDispatcher("/cadastrarAluno.jsp");
        rd.forward(request, response);

    }

    protected void buscarAlunos(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        request.setAttribute("alunos", PessoaDAO.listarAlunos());

        RequestDispatcher rd = request.getRequestDispatcher("/enviarSMS.jsp");
        rd.forward(request, response);

    }

    protected void buscarAlunosTurmas(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int idTurma = Integer.parseInt(request.getParameter("turmas"));

        if (idTurma == 0) {

            response.sendRedirect("EasySendServlet?tarefa=buscarTurmas&page=/enviarSMSAluno.jsp&mensagem=*Escolha um turma!");

        } else {

            request.setAttribute("alunos", PessoaDAO.listarAlunosTurmas(idTurma));

            RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarTurmas&page=/enviarSMSAluno.jsp");
            rd.forward(request, response);
        }
    }

    protected void enviarSMSAluno(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException, ParseException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] alunos = request.getParameterValues("alunos");
        String login = request.getParameter("usuario");
        String mensagem = request.getParameter("mensagem");

        if (alunos == null) {

            response.sendRedirect("EasySendServlet?tarefa=buscarTurmas&page=/enviarSMSAluno.jsp&mensagem=*Escolha no minimo 1 aluno");

        } else if (mensagem.isEmpty()) {

            response.sendRedirect("EasySendServlet?tarefa=buscarTurmas&page=/enviarSMSAluno.jsp&mensagem=*Mensagem invalida");

        } else {

            String data = Utilidades.getData();
            String hora = Utilidades.getHora();

            int matricula = UsuarioDAO.buscarMatricula(login);
            SMSDAO.inserir(matricula, mensagem, data, hora);
            int idSMS = SMSDAO.buscarMaiorId();

            //Conn n = EnvioPlaca.conexao01();
            //String msg2 = EnvioPlaca.conexao02();

            for (int i = 0; i <= alunos.length - 1; i++) {

                int aluno = Integer.parseInt(alunos[i]);

                String telefone = PessoaDAO.buscarTelefone(aluno);

                EnvioPlaca.enviarMensagem(telefone, mensagem);
                
                SMSDAO.gravarSMS(idSMS, aluno);
                
                Thread.sleep(2500);

            }

            RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarTurmas&page=/enviarSMSAluno.jsp&mensagem=*Mensagem enviada com sucesso!");
            rd.forward(request, response);
        }
    }

    protected void enviarSMSFuncionario(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] funcionarios = request.getParameterValues("funcionarios");
        String login = request.getParameter("usuario");
        String mensagem = request.getParameter("mensagem");

        if (funcionarios == null) {

            response.sendRedirect("EasySendServlet?tarefa=buscarSetores&page=/enviarSMSFuncionario.jsp&mensagem=*Escolha no minimo 1 funcionario");

        } else if (mensagem.isEmpty()) {

            response.sendRedirect("EasySendServlet?tarefa=buscarSetores&page=/enviarSMSFuncionario.jsp&mensagem=*Mensagem invalida");

        } else {

            String data = Utilidades.getData();
            String hora = Utilidades.getHora();

            int matricula = UsuarioDAO.buscarMatricula(login);
            SMSDAO.inserir(matricula, mensagem, data, hora);
            int idSMS = SMSDAO.buscarMaiorId();

            //Conn n = EnvioPlaca.conexao01();
            //String msg2 = EnvioPlaca.conexao02();

            for (int i = 0; i <= funcionarios.length - 1; i++) {

                int funcionario = Integer.parseInt(funcionarios[i]);

                String telefone = PessoaDAO.buscarTelefone(funcionario);

                //EnvioPlaca.enviarSMSPlaca(telefone, mensagem, n, msg2);
                SMSDAO.gravarSMS(idSMS, funcionario);

            }

            RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarSetores&page=/enviarSMSFuncionario.jsp&mensagem=*Mensagem enviada com sucesso!");
            rd.forward(request, response);
        }
    }

    protected void buscarRepresentantes(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        request.setAttribute("representantes", AlunoDAO.listarRepresentantes());

        RequestDispatcher rd = request.getRequestDispatcher("/enviarSMSRepresentante.jsp");
        rd.forward(request, response);

    }

    protected void buscarBolsistas(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        request.setAttribute("bolsistas", AlunoDAO.listarBolsistas());

        RequestDispatcher rd = request.getRequestDispatcher("/enviarSMSBolsista.jsp");
        rd.forward(request, response);

    }

    protected void buscarTurmaCursoTurno(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        request.setAttribute("turmas", TurmaDAO.listarTurmaCursoTurno());

        RequestDispatcher rd = request.getRequestDispatcher("/enviarSMSTurma.jsp");
        rd.forward(request, response);

    }

    protected void enviarSMSRepresentante(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException, ParseException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] representantes = request.getParameterValues("representantes");
        String login = request.getParameter("usuario");
        String mensagem = request.getParameter("mensagem");

        if (representantes == null) {

            response.sendRedirect("EasySendServlet?tarefa=buscarRepresentantes&mensagem=*Escolha no minimo 1 aluno");

        } else if (mensagem.isEmpty()) {

            response.sendRedirect("EasySendServlet?tarefa=buscarRepresentantes&mensagem=*Mensagem invalida");

        } else {

            String data = Utilidades.getData();
            String hora = Utilidades.getHora();

            int matricula = UsuarioDAO.buscarMatricula(login);
            SMSDAO.inserir(matricula, mensagem, data, hora);
            int idSMS = SMSDAO.buscarMaiorId();

            //Conn n = new Conn();
            //String msg2 = EnvioPlaca.conexao02();

            for (int i = 0; i <= representantes.length - 1; i++) {

                int representante = Integer.parseInt(representantes[i]);

                String telefone = PessoaDAO.buscarTelefone(representante);

                EnvioPlaca.enviarMensagem(telefone, mensagem);
                
                SMSDAO.gravarSMS(idSMS, representante);
                
                Thread.sleep(2500);

            }

            RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarRepresentantes&mensagem=*Mensagem enviada com sucesso!");
            rd.forward(request, response);
        }
    }

    protected void enviarSMSBolsista(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException, ParseException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] bolsistas = request.getParameterValues("bolsistas");
        String login = request.getParameter("usuario");
        String mensagem = request.getParameter("mensagem");

        if (bolsistas == null) {

            response.sendRedirect("EasySendServlet?tarefa=buscarBolsistas&mensagem=*Escolha no minimo 1 aluno");

        } else if (mensagem.isEmpty()) {

            response.sendRedirect("EasySendServlet?tarefa=buscarBolsistas&mensagem=*Mensagem invalida");

        } else {

            String data = Utilidades.getData();
            String hora = Utilidades.getHora();

            int matricula = UsuarioDAO.buscarMatricula(login);
            SMSDAO.inserir(matricula, mensagem, data, hora);
            int idSMS = SMSDAO.buscarMaiorId();

            //Conn n = EnvioPlaca.conexao01();
            //String msg2 = EnvioPlaca.conexao02();

            for (int i = 0; i <= bolsistas.length - 1; i++) {

                int bolsista = Integer.parseInt(bolsistas[i]);
                String telefone = PessoaDAO.buscarTelefone(bolsista);

                EnvioPlaca.enviarMensagem(telefone, mensagem);
                
                SMSDAO.gravarSMS(idSMS, bolsista);
                
                Thread.sleep(2500);

            }

            RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarBolsistas&mensagem=*Mensagem enviada com sucesso!");
            rd.forward(request, response);
        }
    }

    protected void enviarSMSTurma(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException, ParseException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] turmas = request.getParameterValues("turmas");
        String login = request.getParameter("usuario");
        String mensagem = request.getParameter("mensagem");

        if (turmas == null) {

            response.sendRedirect("EasySendServlet?tarefa=buscarTurmaCursoTurno&mensagem=*Escolha no minimo 1 turma");

        } else if (mensagem.isEmpty()) {

            response.sendRedirect("EasySendServlet?tarefa=buscarTurmaCursoTurno&mensagem=*Mensagem invalida");

        } else {

            String data = Utilidades.getData();
            String hora = Utilidades.getHora();

            int matricula = UsuarioDAO.buscarMatricula(login);
            SMSDAO.inserir(matricula, mensagem, data, hora);
            int idSMS = SMSDAO.buscarMaiorId();

            //Conn n = EnvioPlaca.conexao01();
            //String msg2 = EnvioPlaca.conexao02();

            for (int i = 0; i <= turmas.length - 1; i++) {

                int turma = Integer.parseInt(turmas[i]);

                List<Integer> idAlunos = new ArrayList<Integer>();

                idAlunos = TurmaDAO.listarAlunosId(turma);

                if (idAlunos.size() == 0) {

                    response.sendRedirect("EasySendServlet?tarefa=buscarTurmaCursoTurno&mensagem=*Nao ha alunos nessa turma");


                } else {

                    for (int j = 0; j <= idAlunos.size() - 1; j++) {

                        String telefone = PessoaDAO.buscarTelefone(idAlunos.get(j));

                        EnvioPlaca.enviarMensagem(telefone, mensagem);
                        
                        SMSDAO.gravarSMS(idSMS, idAlunos.get(j));
                        
                        Thread.sleep(2500);
                    }
                }
            }

            RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarTurmaCursoTurno&mensagem=*Mensagem enviada com sucesso!");
            rd.forward(request, response);
        }
    }

    protected void buscarFuncionarios(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int idSetor = Integer.parseInt(request.getParameter("setores"));

        if (idSetor == 0) {

            response.sendRedirect("EasySendServlet?tarefa=buscarSetores&page=/enviarSMSFuncionario.jsp&mensagem=*Escolha um setor!");

        } else {

            request.setAttribute("funcionarios", PessoaDAO.listarFuncionarios(idSetor));

            RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarSetores&page=/enviarSMSFuncionario.jsp");
            rd.forward(request, response);
        }
    }

    protected void enviarSMSCurso(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException, ParseException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] cursos = request.getParameterValues("cursos");
        String login = request.getParameter("usuario");
        String mensagem = request.getParameter("mensagem");

        if (cursos == null) {

            response.sendRedirect("EasySendServlet?tarefa=buscarCursos&mensagem=*Escolha no minimo 1 curso");

        } else if (mensagem.isEmpty()) {

            response.sendRedirect("EasySendServlet?tarefa=buscarCursos&mensagem=*Mensagem invalida");

        } else {

            String data = Utilidades.getData();
            String hora = Utilidades.getHora();

            int matricula = UsuarioDAO.buscarMatricula(login);
            SMSDAO.inserir(matricula, mensagem, data, hora);
            int idSMS = SMSDAO.buscarMaiorId();

            //Conn n = EnvioPlaca.conexao01();
            //String msg2 = EnvioPlaca.conexao02();

            for (int i = 0; i <= cursos.length - 1; i++) {

                int curso = Integer.parseInt(cursos[i]);

                List<Integer> idAlunos = new ArrayList<Integer>();

                idAlunos = CursoDAO.listarAlunosId(curso);

                if (idAlunos.size() == 0) {

                    response.sendRedirect("EasySendServlet?tarefa=buscarCursos&mensagem=*Nao ha alunos nesse curso");


                } else {

                    for (int j = 0; j <= idAlunos.size() - 1; j++) {

                        String telefone = PessoaDAO.buscarTelefone(idAlunos.get(j));

                        EnvioPlaca.enviarMensagem(telefone, mensagem);
                        
                        SMSDAO.gravarSMS(idSMS, idAlunos.get(j));
                        
                        Thread.sleep(2500);
                    }
                }
            }

            RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarCursos&mensagem=*Mensagem enviada com sucesso!");
            rd.forward(request, response);
        }
    }

    protected void enviarSMSSetor(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException, ParseException, InterruptedException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] setores = request.getParameterValues("setores");
        String login = request.getParameter("usuario");
        String mensagem = request.getParameter("mensagem");

        if (setores == null) {

            response.sendRedirect("EasySendServlet?tarefa=buscarSetores&page=/enviarSMSSetor.jsp&mensagem=*Escolha no minimo 1 curso");

        } else if (mensagem.isEmpty()) {

            response.sendRedirect("EasySendServlet?tarefa=buscarSetores&page=/enviarSMSSetor.jsp&mensagem=*Mensagem invalida");

        } else {

            String data = Utilidades.getData();
            String hora = Utilidades.getHora();

            int matricula = UsuarioDAO.buscarMatricula(login);
            SMSDAO.inserir(matricula, mensagem, data, hora);
            int idSMS = SMSDAO.buscarMaiorId();

            //Conn n = EnvioPlaca.conexao01();
            //String msg2 = EnvioPlaca.conexao02();

            for (int i = 0; i <= setores.length - 1; i++) {

                int setor = Integer.parseInt(setores[i]);

                List<Integer> idFuncionarios = new ArrayList<Integer>();

                idFuncionarios = SetorDAO.listarFuncionariosId(setor);

                if (idFuncionarios.size() == 0) {

                    response.sendRedirect("EasySendServlet?tarefa=buscarSetores&page=/enviarSMSSetor.jsp&mensagem=*Nao ha alunos nesse curso");


                } else {

                    for (int j = 0; j <= idFuncionarios.size() - 1; j++) {

                        String telefone = PessoaDAO.buscarTelefone(idFuncionarios.get(j));

                        EnvioPlaca.enviarMensagem(telefone, mensagem);
                        
                        SMSDAO.gravarSMS(idSMS, idFuncionarios.get(j));
                        
                        Thread.sleep(2500);
                        
                    }
                }
            }

            RequestDispatcher rd = request.getRequestDispatcher("EasySendServlet?tarefa=buscarSetores&page=/enviarSMSSetor.jsp&mensagem=*Mensagem enviada com sucesso!");
            rd.forward(request, response);
        }
    }

    protected void buscarCursos(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        request.setAttribute("cursos", CursoDAO.listarCursosTiposCursos());

        RequestDispatcher rd = request.getRequestDispatcher("/enviarSMSCurso.jsp");
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
        try {
            processRequest(request, response);












        } catch (Exception ex) {
            Logger.getLogger(EasySendServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);












        } catch (Exception ex) {
            Logger.getLogger(EasySendServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
