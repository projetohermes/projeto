<%-- 
    Document   : enviarSMS
    Created on : 12/03/2012, 01:25:55
    Author     : Tiago Ferreira
--%>

<%@page import="model.Usuario"%>
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
    <body>
        <center><div id="topofundo"><%@ include file="pages_xhtml/titulo.xhtml"%></div></center>
        <div id="formulario2"><%@ include file="pages_xhtml/menu.xhtml"%>

        
        <h2>Enviar SMS para Alunos</h2>

        <%
            String mensagem = request.getParameter("mensagem");
        %>

        <form action="EasySendServlet?tarefa=buscarAlunosTurmas&page=/enviarSMSAluno.jsp" method="POST">

            <label for="turmas">Turma:</label><br />
            <select id="turmas" name="turmas">
                <option value="0">Escolha uma Turma</option>
                <c:forEach var="turma" items ="${turmas}">
                    <option value="${turma.idTurma}">${turma.nome}</option>
                </c:forEach>
            </select>               <input type="submit" class="botao" value="Buscar">
            <br />
            <div class="erro"><% if (mensagem != null) {
                    out.println(mensagem);
                }
                       %></div>
        </form>

        <form action="EasySendServlet?tarefa=enviarSMSAluno" method="POST">

            <label for="alunos">Alunos: </label><br /><br />
            <c:forEach var="aluno" items ="${alunos}">            
                ${aluno.nome}<input type="checkbox" id="alunos" name="alunos" value="${aluno.idPessoa}"> <br />
            </c:forEach>

            <br />
            <label for="usuario">Usuário: </label>
            <input type="text" name="usuario" id="usuario" readonly="readonly" value="tiago"><br /><br />

            <label for="mensagem">Mensagem: </label><br />
            <textarea id="mensagem" name="mensagem" id="mensagem" cols="40" rows="10" size="150"></textarea><br /><br />
            <center><a href="javascript:history.back(1)"><input type="button" value="Voltar" class="botao"></a><input type="submit" class="botao" value="Enviar"></center><br />

        </form>

    </body>
    <footer>
        <%@ include file="pages_xhtml/menurodape.xhtml"%><br /></div>
        <%@ include file="pages_xhtml/rodape.xhtml"%>
    </footer>
</html>
