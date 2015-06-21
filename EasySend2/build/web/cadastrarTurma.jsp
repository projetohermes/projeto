<%-- 
    Document   : cadastrarTurma
    Created on : 11/03/2012, 01:59:52
    Author     : Tiago Ferreira
--%>

<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>EasySend | Sistema de Controle Escolar</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <script src="javascript/javascript.js" type="text/javascript"></script>
        <script src="javascript/jquery.js" type="text/javascript"></script>
    </head>
    <body>
    <center><div id="topofundo"><%@ include file="pages_xhtml/titulo.xhtml"%></div></center>
        <div id="formulario2"><%@ include file="pages_xhtml/menu.xhtml"%>

        <% String mensagem = request.getParameter("mensagem");%>

        
        <h2>Cadastrar Turma</h2>

        <form name="cadastrarTurma "action="EasySendServlet?tarefa=cadastrarTurma" method="POST" ><br />
            Nome:<br /> 
            <input type="text" name="nome" size="45" ><br />
            Curso<br />
            <select name="cursos">
                    <option value="0">Escolha um Curso</option>
                <c:forEach var="curso" items ="${cursos}">
                    <option value="${curso.idCurso}">${curso.nome}</option>
                </c:forEach>
            </select><br />
            Turno<br />
            <select name="turnos">
                    <option value="0">Escolha um Turno</option>
                <c:forEach var="turno" items ="${turnos}">
                    <option value="${turno.idTurno}">${turno.nome}</option>
                </c:forEach>
            </select><br />
            <br /><br />
            <center><a href="javascript:history.back(1)"><input type="button" value="Voltar" class="botao"></a><input type="submit" value="Salvar" class="botao">
            <% if (mensagem != null) {
                    out.println(mensagem);
                }
            %></center><br />
        </form>
    </body>
    <footer>
        <%@ include file="pages_xhtml/menurodape.xhtml"%><br /></div>
        <%@ include file="pages_xhtml/rodape.xhtml"%>
    </footer>
</html>