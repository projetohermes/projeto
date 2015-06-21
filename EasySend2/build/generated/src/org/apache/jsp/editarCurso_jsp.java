package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class editarCurso_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(2);
    _jspx_dependants.add("/pages_xhtml/titulo.xhtml");
    _jspx_dependants.add("/pages_xhtml/menu.xhtml");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n");
      out.write("        <title>Easy Send | Sistema de Controle Escolar</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilo/css\">\n");
      out.write("        <script src=\"javascript/javascript.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"jquery/javascript.js\" type=\"text/javascript\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" >\r\n");
      out.write("    <head>\r\n");
      out.write("        <title></title>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>EasySend ®</h1>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <title></title>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" />\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"menu\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"EasySendServlet?tarefa=login&login=tiago&senha=tiago\">Início</a></li>\r\n");
      out.write("                <li>Cadastrar</li>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"EasySendServlet?tarefa=buscarTurmas&page=/cadastrarAluno.jsp\">Aluno</a></li>\r\n");
      out.write("                    <li><a href=\"EasySendServlet?tarefa=buscarCursosTurnos\">Turma</a></li>\r\n");
      out.write("                    <li><a href=\"EasySendServlet?tarefa=buscarSetores&page=/cadastrarFuncionario.jsp\">Funcion&aacute;rio</a></li>\r\n");
      out.write("                    <li><a href=\"EasySendServlet?tarefa=buscarTipos\">Curso</a></li>\r\n");
      out.write("                    <li><a href=\"cadastrarSetor.jsp\">Setor</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <li>Manuten&ccedil;&atilde;o</li>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"manutencaoAluno.jsp\">Aluno</a></li>\r\n");
      out.write("                    <li><a href=\"manutencaoTurma.jsp\">Turma</a></li>\r\n");
      out.write("                    <li><a href=\"manutencaoFuncionario.jsp\">Funcionario</a></li>\r\n");
      out.write("                    <li><a href=\"manutencaoCurso.jsp\">Curso</a></li>\r\n");
      out.write("                    <li><a href=\"manutencaoSetor.jsp\">Setor</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                <li>SMS</li>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"EasySendServlet?tarefa=buscarTurmas&page=/enviarSMSAluno.jsp\">Aluno</a></li>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li><a href=\"EasySendServlet?tarefa=buscarRepresentantes\">Representantes</a></li>\r\n");
      out.write("                        <li><a href=\"EasySendServlet?tarefa=buscarBolsistas\">Bolsistas</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                    <li><a href=\"EasySendServlet?tarefa=buscarTurmaCursoTurno\">Turma</a></li>\r\n");
      out.write("                    <li><a href=\"EasySendServlet?tarefa=buscarSetores&page=enviarSMSFuncionario.jsp\">Funcion&aacute;rio</a></li>\r\n");
      out.write("                    <li><a href=\"EasySendServlet?tarefa=buscarCursos\">Curso</a></li>\r\n");
      out.write("                    <li><a href=\"EasySendServlet?tarefa=buscarSetores&page=/enviarSMSSetor.jsp\">Setor</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <li><a href=\"#\">Relat&oacute;rio</a></li>\r\n");
      out.write("                <li>Sobre</li>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"#\">Equipe</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Sistema</a></li>\r\n");
      out.write("                    <li><a href=\"#\">FAQ</a></li>\r\n");
      out.write("                    <li><a href=\"#\">Contato</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
