<%-- 
    Document   : cadastrarSetor
    Created on : 12/03/2012, 00:29:36
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

        
        <h2>Cadastrar Setor</h2>

        <form name="cadastrarSetor "action="EasySendServlet?tarefa=cadastrarSetor" method="POST" ><br />
            Nome:<br /> 
            <input type="text" name="nome" size="45" ><br />
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