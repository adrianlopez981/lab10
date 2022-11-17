<%--
  Created by IntelliJ IDEA.
  User: Angie
  Date: 17/11/2022
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>

<html lang="es">

<head>

    <meta charset="utf-8">

    <title> Crear Cliente</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta name="author" content="Videojuegos & Desarrollo">
    <meta name="description" content="Muestra de un formulario de acceso en HTML y CSS">
    <meta name="keywords" content="Formulario Acceso, Formulario de LogIn">

    <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Overpass&display=swap" rel="stylesheet">

    <!-- Link hacia el archivo de estilos css -->
    <link rel="stylesheet" href="css/login2.css">

    <style type="text/css">

    </style>

    <script type="text/javascript">

    </script>

</head>

<body>

<div id="contenedor">
    <div id="central">
        <div id="login">
            <div class="titulo">
                Crear Cliente
            </div>

            <form id="loginform">
                <input type="text" name="usuario" placeholder="Nro. de Documento" required>

                <input type="password" placeholder="Contraseña" name="password" required>

                <button type="submit" title="Ingresar" name="Ingresar">Crear</button>
            </form>

        </div>
    </div>
</div>

</body>
</html>
