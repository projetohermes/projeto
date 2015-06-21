<%-- 
    Document   : enviarSMSTurma
    Created on : 28/03/2012, 00:56:36
    Author     : Tiago Ferreira
--%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Easy Send - Sistema de Controle Escolar</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <script src="javascript/javascript.js" type="text/javascript"></script>
        <script src="javascript/jquery.js" type="text/javascript"></script>
    </head>
    <body>
        <center><div id="topofundo"><%@ include file="pages_xhtml/titulo.xhtml"%></div></center>
        <div id="formulario2"><%@ include file="pages_xhtml/menu.xhtml"%>

        <br />
        <h2>Enviar SMS para Turmas</h2>

        <%
            String mensagem = request.getParameter("mensagem");
        %>
        
        <form action="EasySendServlet?tarefa=enviarSMSTurma" method="POST">
            <label for="turmas">Turmas: </label><br /><br />
            <c:forEach var="turma" items ="${turmas}">            
                Turma: ${turma.nome}  - Curso: ${turma.curso} - Turno: ${turma.turno}<input type="checkbox" name="turmas" value="${turma.id}"> <br />
            </c:forEach>

            <br />
            <label for="usuario">Usuário: </label>
            <input type="text" name="usuario" readonly="readonly" value="tiago"><br /><br />

            <label for="mensagem">Mensagem: </label><br />
            <textarea id="mensagem" name="mensagem" id="mensagem" cols="40" rows="10" size="150"></textarea><br /><br />
           <center><a href="javascript:history.back(1)"><input type="button" value="Voltar" class="botao"></a><input type="submit" value="Enviar" class="botao">

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
