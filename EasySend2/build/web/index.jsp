
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>EasySend | Sistema de Controle Escolar</title>
        <link rel="stylesheet" type="text/css" href="css/estilo.css">
    </head>
    <body>
    <center><%@ include file="pages_xhtml/titulo.xhtml"%></center>

    <center><div id="formulario">

            <% String mensagem = request.getParameter("mensagem");%>

            <form name="login" action="EasySendServlet?tarefa=login" method="POST">
                
                <div id="login-box-name" style="margin-top:20px;">Usuário: </div><div id="login-box-field" style="margin-top:20px;"><input type="text" class="form-login" id="login" name="login" title="Digite seu usuário" value="" size="30" maxlength="2048" /></div>
<div id="login-box-name">Senha:</div><div id="login-box-field"><input type="password" id="senha" name ="senha" size="20" class="form-login" title="Digite sua senha" value="" size="30" maxlength="2048" /></div>
<br />
                <br />
                <p>
                 
                    <input type="submit" value="Logar no sistema" class="botao"><br /></p>
                <div class="erro"><% if (mensagem != null) {
                        out.println(mensagem);
                    }
                           %></div>
            </form>
        </div></center>
    </body>
    <footer>
        <%@ include file="pages_xhtml/rodape.xhtml"%>
    </footer>
</html>
