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
                out.println("Olá, " + usuario.getLogin());

            %>


            <p>O sistema Hermes envia SMS (Short Message Service) de maneira organizada é eficaz para determinados receptores, assim foi desenvolvido, para solucionar a falha da comunicação imediata, com isso iremos utilizar o SMS, pois é direto e rápido, como sabemos hoje o numero de linhas telefônicas celulares ultrapassaram o numero de habitante no Brasil, e a tendência é aumentar esse numero.

                Diferente dos outros meios de comunicação, o SMS ele pode ser lido ou visto a qualquer instante, sem interferir uma atividade.</p>

            <p>Para isso iremos usar o nosso sistema Hermes onde há uma organização estruturada por banco de dados, uma ótima interface gráfica, de fácil utilização.</p>

            Sistema como esse ainda é raro, mas está em constante evolução, e assim queremos implantar no SENAI Maracanã. 

            <%@ include file="pages_xhtml/menurodape.xhtml"%><br /></div></center>
    <div id="rodape" ><%@ include file="pages_xhtml/rodape.xhtml"%></div>
</body>
</html>
