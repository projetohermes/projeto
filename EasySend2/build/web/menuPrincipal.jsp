<%-- 
    Document   : menuPrincipal
    Created on : 07/03/2012, 20:09:26
    Author     : Tiago Ferreira
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>EasySend | Sistema de Controle Escolar</title>
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>
    <body>

    <center><div id="topofundo"><%@ include file="pages_xhtml/titulo.xhtml"%></div>
            <div id="formulario2"><%@ include file="pages_xhtml/menu.xhtml"%>

            <%

                Usuario usuario = (Usuario) request.getAttribute("usuario");
                out.println("Ol�, " + usuario.getLogin());

            %>


            <p>O sistema Hermes envia SMS (Short Message Service) de maneira organizada � eficaz para determinados receptores, assim foi desenvolvido, para solucionar a falha da comunica��o imediata, com isso iremos utilizar o SMS, pois � direto e r�pido, como sabemos hoje o numero de linhas telef�nicas celulares ultrapassaram o numero de habitante no Brasil, e a tend�ncia � aumentar esse numero.

                Diferente dos outros meios de comunica��o, o SMS ele pode ser lido ou visto a qualquer instante, sem interferir uma atividade.</p>

            <p>Para isso iremos usar o nosso sistema Hermes onde h� uma organiza��o estruturada por banco de dados, uma �tima interface gr�fica, de f�cil utiliza��o.</p>

            Sistema como esse ainda � raro, mas est� em constante evolu��o, e assim queremos implantar no SENAI Maracan�. 

            <%@ include file="pages_xhtml/menurodape.xhtml"%><br /></div></center>
    <div id="rodape" ><%@ include file="pages_xhtml/rodape.xhtml"%></div>
</body>
</html>
