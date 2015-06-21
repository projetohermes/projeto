<%-- 
    Document   : editarCurso
    Created on : 23/04/2012, 19:36:58
    Author     : Tiago Ferreira
--%>
<%@page import="model.DetalhesFuncionarios"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Easy Send | Sistema de Controle Escolar</title>
        <link rel="stylesheet" type="text/css" href="css/estilo/css">
        <script src="javascript/javascript.js" type="text/javascript"></script>
        <script src="jquery/javascript.js" type="text/javascript"></script>
    </head>
    <body>
        <%@include file="pages_xhtml/titulo.xhtml" %>
        <%@include file="pages_xhtml/menu.xhtml" %>

        <h2>Editar Funcion&aacute;rio</h2>

        <%
            String data = (String) request.getAttribute("data");
            String mensagem = request.getParameter("mensagem");
            DetalhesFuncionarios detalhes = (DetalhesFuncionarios) request.getAttribute("funcionarios");
        %>

        <form action="ManutencaoServlet?tarefa=atualizarFuncionario" method="POST">

            <label for="matricula">Matr&iacute;cula: </label><br />
            <input type="text" id="matricula" name="matricula" readonly="readonly" value="<%=detalhes.getMatricula()%>" size="11" /><br /><br />

            <label for="nome">Nome: </label><br />
            <input type="text" id="nome" name="nome" value="<%=detalhes.getNome()%>" size="45"><br /><br />

            <label for="email">E-mail: </label><br />
            <input type="email" id="email" name="email" value="<%=detalhes.getTelefone()%>" size="45"><br /><br />
            
            <label for="celular">Telefone: </label><br />
            <input type="tel" id="celular" name="celular" value="<%=detalhes.getEmail()%>" size="9" maxlength="9" onkeypress="formatar_mascara(this, '####-####')"><br /><br />

            <label for="dataNascimento">Data de Nascimento</label><br />
            <input type="date" id="dataNascimento" name="dataNascimento" readonly="readonly" value="<%=data%>" size="10" maxlength="10" onkeypress="formatar_mascara(this, '##/##/####')"><br /><br />

            <label for="setor">Setor: </label><br />
            <select id="setor" name="setor">
                <option value="#">Escolha um setor</option>
                <c:forEach var="setor" items="${setores}">
                    <option value="${setor.idSetor}">${setor.nome}</option>
                </c:forEach><br /><br />
            </select><br /><br />
            
            <input type="submit" value="Atualizar"><br />
            
        </form>

        <% if (mensagem != null) {
                out.println(mensagem);
            }
        %>

        <br /><br />
        
    </body>
    <footer>
        <%@ include file="pages_xhtml/menurodape.xhtml"%><br />
        <%@ include file="pages_xhtml/rodape.xhtml"%>
    </footer>
</html>
