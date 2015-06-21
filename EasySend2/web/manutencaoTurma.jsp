<%-- 
    Document   : manutencaoTurma
    Created on : 16/04/2012, 03:15:41
    Author     : Tiago Ferreira
--%>
<%@page import="model.ListaDeTurma_Curso_Turno"%>
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
            <a href="EasySendServlet?tarefa=login&login=tiago&senha=tiago">In&iacute;cio</a> > Manuten&ccedil;&atilde;o > <a href="manutencaoTurma.jsp">Turma</a>
        </div>

        <%
            String mensagem = request.getParameter("mensagem");
            //ListaDeTurma_Curso_Turno turmas = (ListaDeTurma_Curso_Turno) request.getAttribute("turmas");
        %>

        <h2>Manuten&ccedil;&atilde;o Turma</h2>

        <form action="ManutencaoServlet?tarefa=buscarTurmasEdicao" method="POST">        

            <label for="dado">Informe a turma a ser editada: </label>

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
                    <th>Turma</th>
                    <th>Curso</th>
                    <th>Turno</th>
                    <th>Op&ccedil;&atilde;o Editar</th>
                    <th>Op&ccedil;&atilde;o Excluir</th>
                </tr>
            </thead>
            <tbody>
                    <tr>
                        <c:forEach var="turma" items="${turmas}">
                        <td name="turma">${turma.nome}</td>
                        <td>${turma.curso}</td>
                        <td>${turma.turno}</td>
                        <td><a href="ManutencaoServlet?tarefa=editarTurma&nome=${turma.nome}">Editar</a></td>
                        <td><a href="ManutencaoServlet?tarefa=excluirTurma&nome=${turma.nome}">Excluir</a></td>
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
