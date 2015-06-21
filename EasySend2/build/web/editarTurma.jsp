<%-- 
    Document   : editarTurma
    Created on : 16/04/2012, 12:00:26
    Author     : Tiago Ferreira
--%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="model.ListaDeTurma_Curso_Turno"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Easy Send | Sistema de Controle Escolar</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <script src="javascript/javascript.js" type="text/javascript"></script>
        <script src="javascript/jquery.js" type="text/javascript"></script>
    </head>
    <body>
        <%@ include file="pages_xhtml/titulo.xhtml"%>
        <%@ include file="pages_xhtml/menu.xhtml"%>

        <br />

        <!--
        
        <div id="caminho">
            <a href="EasySendServlet?tarefa=login&login=tiago&senha=tiago">In&iacute;cio</a> > Manuten&ccedil;&atilde;o > <a href="manutencaoAluno.jsp">Aluno</a>
        </div>
        
        -->

        <h2>Manuten&ccedil;&atilde;o Turma</h2>

        <%
            String mensagem = request.getParameter("mensagem");
            String turma = (String) request.getAttribute("turma");
        %>

        <form action="ManutencaoServlet?tarefa=atualizarTurma" method="POST">

            <label for="turma">Turma: </label>&nbsp;<input type="text" readonly="readonly" id="turma" value="<%=turma%>"><br /><br />

            <label for="curso">Cursos: </label>
            <select id="curso" name="curso">
                <c:forEach var="curso" items="${cursos}">
                    <option value="${curso.idCurso}">${curso.nome}</option>
                </c:forEach>                
            </select>
            <br /><br />

            <label for="turno">Turnos: </label>
            <select id="turno" name="turno">
                <c:forEach var="turno" items="${turnos}">
                    <option value="${turno.idTurno}">${turno.nome}</option>
                </c:forEach>                
            </select><br /><br />

            <input type="submit" id="botao" value="Atualizar">

            <% if (mensagem != null) {
                    out.println(mensagem);
                }
            %>

        </form>

        <div id="voltar"><a href="EasySendServlet?tarefa=login&login=tiago&senha=tiago">Voltar</a>

    </body>
    <footer>
        <%@ include file="pages_xhtml/menurodape.xhtml"%><br />
        <%@ include file="pages_xhtml/rodape.xhtml"%>
    </footer>
</html>
