<%-- 
    Document   : Documento_encontrado
    Created on : 21/11/2013, 04:10:07 AM
    Author     : AFBL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportar documento encontrado</title>
    </head>
    <body>
        <h1>Reportar documento encontrado</h1>
        <form action="Documento_encontrado">
        Ingrese el tipo de documento
        <select name="tipo_doc">
            <option>Cédula de ciudadanía</option>
            <option>Cédula de extranjería</option>
            <option>Tarjeta de identidad</option>
            <option>Pasaporte</option>
        </select>
        Ingrese el numero de documento:
        <input type="text" name="doc" value="" />
        Ingrese el numero de documento de la persona que reporta el documento:
        <input type="text" name="doc_usu_rep" value="" />
        <input type="submit" value="Aceptar" />
        <a href="index.html" target="_self">
                <input type="button" value="Volver"/></a><br>
        </form>
    </body>
</html>
