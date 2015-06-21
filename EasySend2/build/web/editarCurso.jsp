<%-- 
    Document   : editarCurso
    Created on : 24/04/2012, 08:24:24
    Author     : Tiago Ferreira
--%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

        <h2>Manuten&ccedil;&atilde;o Curso</h2>

        <%
            String mensagem = request.getParameter("mensagem");
            String curso = (String) request.getAttribute("curso");
            int id = (Integer) request.getAttribute("id");
        %>

        <form action="ManutencaoServlet?tarefa=atualizarCurso" method="POST">

            <input type="hidden" name="id" value="<%= id %>">
            
            <label for="curso">Curso: </label>&nbsp;<input type="text" id="curso" name="curso" value="<%=curso%>"><br /><br />

            <label for="curso">Tipos de Curso: </label>
            <select id="tipo" name="tipo">
                <c:forEach var="tipo" items="${tipos}">
                    <option value="${tipo.idTipoCurso}">${tipo.nome}</option>
                </c:forEach>                
            </select>
            
            <input type="submit" value="Atualizar" id="botao">
            
            <br /><br />

        </form>

        <% if (mensagem != null) {
                out.println(mensagem);
            }
        %>

        <div id="voltar"><a href="EasySendServlet?tarefa=login&login=tiago&senha=tiago">Voltar</a><br />

    </body>
    <footer>
        <%@ include file="pages_xhtml/menurodape.xhtml"%><br />
        <%@ include file="pages_xhtml/rodape.xhtml"%>
    </footer>
</html>
