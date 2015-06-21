<%-- 
    Document   : cadastrarAluno
    Created on : 07/03/2012, 20:11:33
    Author     : Tiago Ferreira
--%>

<%@page import="model.Turno"%>
<%@page import="model.Turma"%>
<%@page import="java.util.List"%>
<%@page import="model.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>EasySend | Sistema de Controle Escolar</title>
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <script src="javascript/javascript.js" type="text/javascript"></script>
        <script src="javascript/jquery.js" type="text/javascript"></script>
    </head>
    
    <body>
    <center><div id="topofundo"><%@ include file="pages_xhtml/titulo.xhtml"%></div></center>
        <div id="formulario2"><%@ include file="pages_xhtml/menu.xhtml"%>

        <% String mensagem = request.getParameter("mensagem");%>

        
        <h2>Cadastrar Aluno</h2>

        <form name="cadastrarAluno "action="EasySendServlet?tarefa=cadastrarAluno" method="POST" >
            <label for="nome">Nome: </label><br /> 
            <input type="text" id="nome" name="nome" size="45" ><br />
            
            <label for="email">Email: </label><br />
            <input type="email" id="email" name="email" size="45" ><br />
            
            <label for="celular">Telefone Celular: </label><br />
            <input type="tel" id="celular" name="celular" size="12" maxlength="12" onkeypress="formatar_mascara(this, '##)####-####')"><br />
            
            <label for="dataNascimento">Data de Nascimento: </label><br />
            <input type="date" id="dataNascimento" name="dataNascimento" maxlength="10" size="10" onkeypress="formatar_mascara(this, '##/##/####')"><br />
            
            <label for="matricula">Matrícula: </label><br />
            <input type="text" id="matricula" name="matricula" size="11"><br /><br />
            
            <label for="bolsista">Bolsista: </label>&nbsp&nbsp<input type="checkbox" id="bolsista" name="bolsista" value="true" />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
            <label for="representante">Representante de Turma: </label>&nbsp&nbsp<input type="checkbox" id="representante" name="representante" value="true" /><br /><br />
            
          <!--  
            Curso:<br />
            <select name="cursos" onchange="paginaAjax('turnosAjax.jsp?tipo=curso&curso=' + this.value, 'turno')">
                <option value="0">Escolha um Curso</option>
                <c:forEach var="curso" items ="${cursos}">
                    <option value="${curso.idCurso}">${curso.nome}</option>
                </c:forEach>
            </select><br />
            
            
            <div id="turno"> <!-- Div Turno
            Turno:<br />
            <select name="turnos" disabled="true"> 
                    <option value="0">Escolha um Turno</option>
                <c:forEach var="turno" items ="${turnos}">
                    <option value="${turno.idTurno}">${turno.nome}</option>
                </c:forEach>
            </select><br />
            </div> Fim Div Turno -->
            
          <label for="turmas">Turma: </label><br />
            <select id="turmas" name="turmas">
                <option value="0">Escolha uma Turma</option>
                <c:forEach var="turma" items ="${turmas}">
                    <option value="${turma.idTurma}">${turma.nome}</option>
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
