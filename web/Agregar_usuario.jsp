<%-- 
    Document   : Agergar_usuario
    Created on : 21/11/2013, 06:03:39 PM
    Author     : AFBL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar o modificar usuario</title>
    </head>
    <body>
        <h1>Agregar o modificar usuario</h1>
        <form action="Agregar_usuario">
            Ingrese el número de documento:
            <input type="text" name="doc" value="" /></br>
            Ingrese el nombre:
            <input type="text" name="nombre" value="" /></br>
            Ingrese el primer apellido:
            <input type="text" name="apellido1" value="" /></br>
            Ingrese el segundo apellido:
            <input type="text" name="apellido2" value="" /></br>
            Ingrese la fecha de nacimiento:
            <input type="date" name="fecha" value="" /></br>
            Ingrese la direccion:
            <input type="text" name="direccion" value="" /></br>
            Ingrese el numero de telefono:
            <input type="text" name="telefono" value="" /></br>
            Ingrese el correo:
            <input type="text" name="correo" value="" /></br>
            <input type="submit" value="Aceptar" />
            <a href="index.html" target="_self">
                <input type="button" value="Volver"/></a><br>
                
        </form>
    </body>
</html>
