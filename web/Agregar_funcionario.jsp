<%-- 
    Document   : Agregar_usuario
    Created on : 19/11/2013, 08:20:23 AM
    Author     : 201
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar funcionario</title>
    </head>
    <body>
        <form action="Agregar_funcionario">
        <h1>Agregar o actualizar funcionario</h1></br>
        Ingrese el número de documento:
        <input type="text" name="doc" value="" /></br>
        Ingrese los nombres:
        <input type="text" name="nombres" value="" /></br>
        Ingrese el primer apellido:
        <input type="text" name="apellido1" value="" /></br>
        Ingrese el segundo apellido
        <input type="text" name="apellido2" value="" /></br>
        Ingrese la clave:
        <input type="text" name="clave" value="" /></br>
        <input type="submit" value="Aceptar" />
        <a href="index.html" target="_self">
                <input type="button" value="Volver"/></a><br>
        </form>
    </body>
</html>
