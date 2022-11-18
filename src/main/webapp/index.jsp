<!-- Define que el documento esta bajo el estandar de HTML 5 -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.example.lab10.Beans.Clientes"%>





<!doctype html>

<!-- Representa la raíz de un documento HTML o XHTML. Todos los demás elementos deben ser descendientes de este elemento. -->
<html lang="es">

    <head>

        <meta charset="utf-8">

        <title> Inicio de Sesión </title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <meta name="author" content="Videojuegos & Desarrollo">
        <meta name="description" content="Muestra de un formulario de acceso en HTML y CSS">
        <meta name="keywords" content="Formulario Acceso, Formulario de LogIn">

        <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Overpass&display=swap" rel="stylesheet">

        <!-- Link hacia el archivo de estilos css -->
        <link rel="stylesheet" href="css/login.css">

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
                        ¡Bienvenido al Banco del Perú!
                    </div>

                    <form id="loginform" method="post" class="form-signin" action="<%=request.getContextPath()%>/ServletInitio">

                        <input type="text"  id="codigo" name="codigo" placeholder="codigo" required >

                        <input type="password" placeholder="password" name="password" required>

                        <button type="submit" title="Ingresar" name="Ingresar">Login</button>


                        <% if (request.getParameter("error") != null) {%>
                        <div class="text-danger mb-2">Hubo un Error en su Codigo o Contraseña , Vuelva a Ingresar</div>
                        <% } %>
                    </form>



                    <div class="pie-form">
                        <a href="#">¿Perdiste tu contraseña?</a>
                        <a href="#">¿No tienes Cuenta? Registrate</a>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>