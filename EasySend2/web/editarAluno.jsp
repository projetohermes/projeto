<%-- 
    Document   : editarAluno
    Created on : 06/04/2012, 03:43:23
    Author     : Tiago Ferreira
--%>
<%@page import="model.DetalhesAlunos"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Easy Send | Sistema de Controle Escolar</title>
        <!-- <link href="imagem/favicon.ico" type="image/x-icon" rel="shortcut icon"> -->
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
        <script src="javascript/javascript.js" type="text/javascript"></script>
        <script src="javascript/jquery.js" type="text/javascript"></script>
    </head>
    <body>
        <center><div id="topofundo"><%@ include file="pages_xhtml/titulo.xhtml"%></div></center>
        <div id="formulario2"><%@ include file="pages_xhtml/menu.xhtml"%>

        <h2>Editar Aluno</h2>

        <%
            String data = (String) request.getAttribute("data");
            String mensagem = request.getParameter("mensagem");
            DetalhesAlunos detalhes = (DetalhesAlunos) request.getAttribute("alunos");
        %>

        <form action="ManutencaoServlet?tarefa=atualizarAluno" method="POST">

            <label for="matricula">Matr&iacute;cula: </label><br />
            <input id="matricula" name="matricula" type="text" readonly="readonly" value="<%=detalhes.getMatricula()%>" size="11" /><br /><br />

            <label for="nome">Nome: </label><br />
            <input id="nome" name="nome" type="text" value="<%=detalhes.getNome()%>" size="45"><br /><br />

            <label for="celular">Telefone Celular: </label><br />
            <input id="celular" name="celular" type="tel" value="<%=detalhes.getTelefone()%>" size="12" maxlength="12" onkeypress="formatar_mascara(this, '##)####-####')"><br /><br />

            <label for="email">E-mail: </label><br />
            <input id="email" name="email" type="email" value="<%=detalhes.getEmail()%>" size="45"><br /><br />

            <label for="dataNascimento">Data de Nascimento: </label><br />
            <input id="dataNascimento" name="dataNascimento" readonly="readonly" type="date" value="<%=data%>" size="10" maxlength="10" onkeypress="formatar_mascara(this, '##/##/####')"><br /><br />

            <label for="bolsista">Bolsista: </label>- Original:
            <%if (detalhes.isBolsista() == true) {
                    out.println("Sim");
                } else {
                    out.println("Não");
                }%>
            <br />
            <select id="bolsista" name="bolsista">

                <option value="true">Sim</option>
                <option value="false">N&atilde;o</option>

            </select><br /><br />

            <label for="representante">Representante: </label>- Original: 
            <%if (detalhes.isRepresentante() == true) {
                    out.println("Sim");
                } else {
                    out.println("Não");
                }%>
            <br />

            <select id="representante" name="representante">

                <option value="true">Sim</option>
                <option value="false">N&atilde;o</option>

            </select><br /><br />

            <label for="tabela">Turmas em que est&aacute; matriculado: </label>
            <table border="1" id="tabela">
                <thead>
                    <tr>
                        <th>Turma</th>
                        <th>Curso</th>
                        <th>Turno</th>
                       <!-- <th>Op&ccedil;&atilde;o Excluir</th> -->
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="curso" items ="${cursos}"> 
                        <tr>
                            <td>${curso.turma}</td>
                            <td>${curso.curso}</td>
                            <td>${curso.turno}</td>
                         <!--   <td><a href="ManutencaoServlet?tarefa=excluirAlunoTurma&matricula=<%=detalhes.getMatricula()%>&turma=${curso.turma}">Excluir</td> -->
                        </tr>
                    </c:forEach> 
                </tbody>
            </table><br />

            <center><a href="javascript:history.back(1)"><input type="button" value="Voltar" class="botao"></a><input type="submit" value="Atualizar" class="botao">

        </form><br /><br />

        <!--
        <form action="ManutencaoServlet?tarefa=adicionarTurma" method="POST">
            <label for="turmas">Turmas Dispon&iacute;veis: </label>
            <select name="turmas" id="turmas">
                <option value="#">Escolha uma Turma: </option>
                <c:forEach var="turma" items ="${turmas}"> 
                    <option value="${turma.idTurma}">${turma.nome}</option>
                </c:forEach> 
            </select><br />
            <input type="submit" id="botao" value="Adicionar Turma">           
        </form> --> <br /><br />

        <% if (mensagem != null) {
                out.println(mensagem);
            }
        %></center><br />

    </body>
    <footer>
        <%@ include file="pages_xhtml/menurodape.xhtml"%><br /></div>
        <%@ include file="pages_xhtml/rodape.xhtml"%>
    </footer>
</html>
