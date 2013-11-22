<%-- 
    Document   : BuscarDocumento
    Created on : 18/11/2013, 06:36:18 PM
    Author     : AFBL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Documento</title>
    </head>
    <body>
        <h1>Buscar Documento</h1>
        <form action="Buscar_documento">
            
            Ingrese el número de documento
            <input type="text" name="doc" value="" /><br>
            <input type="submit" value="Aceptar" />
            <a href="index.html" target="_self">
                <input type="button" value="Volver"/></a><br>
        </form>
    </body>
</html>
