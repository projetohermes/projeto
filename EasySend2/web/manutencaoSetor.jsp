<%-- 
    Document   : manutencaoSetor
    Created on : 22/04/2012, 01:36:38
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
            <a href="EasySendServlet?tarefa=login&login=tiago&senha=tiago">In&iacute;cio</a> > Manuten&ccedil;&atilde;o > <a href="manutencaoSetor.jsp">Setor</a>
        </div>

        <%
            String mensagem = request.getParameter("mensagem");
        %>

        <h2>Manuten&ccedil;&atilde;o Setor</h2>
       <form action="ManutencaoServlet?tarefa=buscarSetoresEdicao" method="POST">        

            <label for="dado">Informe o setor a ser editado: </label>

            <input type="text" id="dado" name="dado" size="45" > 

            <input type="submit" id="botao">

        </form>

        <% if (mensagem != null) {
                out.println(mensagem);
            }
        %>

        <br /><br />

        <table border="1">
            <thead>
                <tr>
                    <th>Setor</th>
                    <th>Op&ccedil;&atilde;o Editar</th>
                    <th>Op&ccedil;&atilde;o Excluir</th>
                </tr>
            </thead>
            <tbody>
                    <tr>
                        <c:forEach var="setor" items="${setores}">
                        <td name="setor">${setor.nome}</td>
                        <td><a href="ManutencaoServlet?tarefa=editarTurma&nome=${setor.nome}">Editar</a></td>
                        <td><a href="ManutencaoServlet?tarefa=excluirTurma&nome=${setor.nome}">Excluir</a></td>
                        </c:forEach>
                    </tr>
            </tbody>
        </table>

        <br /><br />

        <div id="voltar"><a href="EasySendServlet?tarefa=login&login=tiago&senha=tiago">Voltar</a>
        </div>

        <br /><br />
    </body>
    <footer>
        <%@ include file="pages_xhtml/menurodape.xhtml"%><br />
        <%@ include file="pages_xhtml/rodape.xhtml"%>
    </footer>
</html>
