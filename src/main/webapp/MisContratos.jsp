<%@ page import="com.example.lab10.Beans.Clientes" %>
<%@ page import="com.example.lab10.Beans.Contratos" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Angie
  Date: 17/11/2022
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    ArrayList<Contratos> listaContratos = (ArrayList <Contratos>) request.getAttribute("ListaContratos");

%>
<html>
<head>
    <title>Mis Contratos</title>
</head>
<body>
<table class="table table-dark table-hover">
    <thead>
    <tr>
        <th scope="col" class="text-center">Nro. de Contrato</th>
        <th scope="col" class="text-center">Divisa</th>
        <th scope="col" class="text-center">Estado</th>
        <th scope="col" class="text-center">Meses en ese estado</th>
    </tr>
    </thead>
    <tbody>
    <% int i = 1;
        for (Contratos contratos : listaContratos) { %>
    <tr>
        <td class="text-center" scope="row"> <%=contratos.getNroDeContrato()%></td>
        <td class="text-center"> <%=contratos.getDivisa()%></td>
        <td class="text-center"><%=contratos.getEstado()%></td>
        <td class="text-center"><%=contratos.getMesesEnEseEstado()%></td>
    </tr>
    <% i++;
    }
    %>
    </tbody>
</table>

</body>
</html>
