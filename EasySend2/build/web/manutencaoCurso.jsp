<%-- 
    Document   : manutencaoCurso
    Created on : 23/04/2012, 11:29:42
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

        <div id="caminho">
            <a href="EasySendServlet?tarefa=login&login=tiago&senha=tiago">In&iacute;cio</a> > Manuten&ccedil;&atilde;o > <a href="manutencaoCurso.jsp">Curso</a>
        </div>

        <%
            String mensagem = request.getParameter("mensagem");
        %>

        <h2>Manuten&ccedil;&atilde;o Curso</h2>

        <form action="ManutencaoServlet?tarefa=buscarCursosEdicao" method="POST">

            <select name="tipoDeBusca">
                <option value="#">Escolha uma opção</option>
                <option value="nome">Nome do Curso</option>
                <option value="tipo">Tipo de Curso</option>

                <input type="text" name="dado" size="45">

                <input type="submit" value="Buscar" id="botao">

            </select>

        </form><br /><br />

        <% if (mensagem != null) {
                out.println(mensagem);
            }
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>Curso</th>
                    <th>Tipo do Curso</th>
                    <th>Op&ccedil;&atilde;o Editar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="curso" items="${cursos}">
                <tr>
                    <td>${curso.curso}</td>
                    <td>${curso.tipoCurso}</td>
                    <td><a href="ManutencaoServlet?tarefa=editarCurso&nome=${curso.curso}">Editar</a></td>
                </tr>
                </c:forEach>
            </tbody>
        </table><br /><br />


    </body>
    <footer>
        <%@ include file="pages_xhtml/menurodape.xhtml"%><br />
        <%@ include file="pages_xhtml/rodape.xhtml"%>
    </footer>
</html>
