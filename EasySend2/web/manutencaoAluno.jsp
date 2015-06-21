<%-- 
    Document   : manutencaoAluno
    Created on : 04/04/2012, 21:33:52
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
            <a href="EasySendServlet?tarefa=login&login=tiago&senha=tiago">In&iacute;cio</a> > Manuten&ccedil;&atilde;o > <a href="manutencaoAluno.jsp">Aluno</a>
        </div>

        <h2>Manuten&ccedil;&atilde;o Aluno</h2>

        <%
            String mensagem = request.getParameter("mensagem");
        %>

        <form action="ManutencaoServlet?tarefa=buscarAlunosEdicao" method="POST">        

            <select name="tipoDeBusca">
                <option value="#">Escolha o Tipo de Busca</option>
                <option value="matricula">Matr&iacute;cula</option>
                <option value="nome">Nome</option>
                <option value="turma">Turma</option>
            </select>

            <input type="text" name="dado" size="45" > 

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
                    <th>Matr&iacute;cula</th>
                    <th>Nome</th>
                    <th>Turma</th>
                    <th>Curso</th>
                    <th>Op&ccedil;&atilde;o Editar</th>
                    <th>Op&ccedil;&atilde;o Excluir</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="aluno" items ="${alunos}">
                    <tr>
                        <td name="matricula">${aluno.matricula}</td>
                        <td>${aluno.nome}</td>
                        <td>${aluno.turma}</td>
                        <td>${aluno.curso}</td>
                        <td><a href="ManutencaoServlet?tarefa=editarAluno&matricula=${aluno.matricula}">Editar</a></td>
                        <td><a href="ManutencaoServlet?tarefa=excluirAluno&matricula=${aluno.matricula}">Excluir</a></td>
                    </tr>
                </c:forEach>
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
