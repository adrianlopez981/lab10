
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.example.lab10.Beans.Clientes"%>
<%@ page import="com.example.lab10.Beans.Credentials"%>
<jsp:useBean id="listaNoCredentials" scope="request" type="java.util.ArrayList<com.example.lab10.Beans.Clientes>"/>
<jsp:useBean id="userlogged" type="com.example.lab10.Beans.Credentials" scope="session"/>

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

            <form action="<%=request.getContextPath()%>/ServletAdmin?action=guardar" method="post">
<%--                <input type="text" name="usuario" placeholder="Nro. de Documento" required>--%>


                <div class="input-group mb-3">
                    <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" id="codigo_elegir" name="codigo_elegir" required>
                        <option selected>Elegir...</option>
                        <%
                            for( Clientes c: listaNoCredentials){%>

                        <option value="<%=c.getNumeroDocumento()%>"><%=c.getNumeroDocumento()%></option>
                        <%}%>
                    </select>
                </div>





                <div class="col-auto">
                    <input type="text" id="inputpassword" placeholder="Contraseña" class="form-control"
                           aria-describedby="passwordHelpInline" name="password" required>
                </div>




                <div class="d-flex justify-content-center">

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1"
                         aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-footer">
                                    <div class="d-flex justify-content-center">
                                        <button type="submit" class="btn btn-primary">
                                            Confirmar
                                            >
                                        </button>
                                        <br>
                                        <a class="btn btn-primary"
                                           href="<%=request.getContextPath()%>/ServletAdmin?action=Inicio"
                                           role="button"
                                           style="margin-left: 0rem; background-color:#D12C22 ; border: none;">
                                            Cancelar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
