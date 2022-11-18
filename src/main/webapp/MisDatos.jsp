<%@ page import="com.example.lab10.Beans.Clientes" %><%--
  Created by IntelliJ IDEA.
  User: Angie
  Date: 17/11/2022
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Clientes clientes = (Clientes) request.getAttribute("mostrar");
%>
<html>
<head>
    <title>Mis Datos</title>
</head>
<body>
<div class="ibox-body">
    <form method="post" action="<%=request.getContextPath()%>/ServletClient?accion=buscar&id=<%= clientes.getNumeroDocumento()%>">
        <div class="row g-2">
            <% if(session.getAttribute("infotodo")!= null) {%>
            <div class="alert alert-danger" role="alert">
                <%=session.getAttribute("infotodo")%>
            </div>
            <%session.removeAttribute("infotodo");%>
            <%}%>
        </div>
        <div class="row g-2">
            <div class="col-md">
                <div class="form-floating" style="margin-bottom: 5px;">
                    <input type="text" class="form-control" id="floatingInputGrid1" placeholder="Nombre" aria-label="Disabled input example" disabled readonly>
                    <label for="floatingInputGrid1">Nombre: <%=clientes.getNombreCliente()%></label>
                </div>
            </div>
            <div class="col-md">
                <div class="form-floating" style="margin-bottom: 5px;">
                    <input type="text" class="form-control" id="floatingInputGrid2" placeholder="Edad" aria-label="Disabled input example" disabled readonly>
                    <label for="floatingInputGrid2"> Edad: <%=clientes.getEdad()%></label>
                </div>
            </div>
        </div>
        <div class="row g-2">
            <div class="col-md">
                <div class="form-floating" style="margin-bottom: 5px;">
                    <input type="text" class="form-control" id="floatingInputGrid3" placeholder="TipoDePersona" aria-label="Disabled input example" disabled readonly>
                    <label for="floatingInputGrid3">Tipo de Persona: <%=clientes.getTipoCliente()%></label>
                </div>
            </div>
            <div class="col-md">
                <div class="form-floating" style="margin-bottom: 5px;">
                    <input type="text" class="form-control" id="floatingInputGrid4" placeholder="NroDeDocumento" aria-label="Disabled input example" disabled readonly>
                    <label for="floatingInputGrid4">Nro de Documento: <%=clientes.getNumeroDocumento()%></label>
                </div>
            </div>
        </div>

        </div>
</body>
</html>
