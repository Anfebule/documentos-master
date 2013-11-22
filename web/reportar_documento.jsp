<%-- 
    Document   : reportar_documento
    Created on : 21/11/2013, 02:23:30 AM
    Author     : AFBL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reportar documento</title>
    </head>
    <body>
        
        <h1>Reportar Documento extraviado</h1>
        <form action="reportar_documento">
        Ingrese el numero de denuncia:
        <input type="text" name="denuncia" value="" /></br>
        Ingrese el tipo de documento:
        <select name="tipo_doc">
            <option>Cédula de ciudadanía</option>
            <option>Cédula de extranjería</option>
            <option>Tarjeta de identidad</option>
            <option>Pasaporte</option>
        </select></br>
        Ingrese el numero de documento:
        <input type="text" name="doc" value="" /></br>
        Ingrese el numero de documento del usuario que denuncia:
        <input type="text" name="doc_usu_denuncia" value="" /></br>
        Ingrese el numero de documento del funcionario:
        <input type="text" name="doc_funcionario" value="" /><br>
        Fecha de pérdida:
        <input type="date" name="fecha_perdida" value="" /><br>
        Hora de perdida:
        <input type="hour" name="hora_perdida" value="" /><br>
        <input type="submit" value="Aceptar" />
        <a href="index.html" target="_self">
                <input type="button" value="Volver"/></a><br>
        </form>
    </body>
</html>
