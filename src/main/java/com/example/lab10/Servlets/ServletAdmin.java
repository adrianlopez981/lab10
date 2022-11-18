package com.example.lab10.Servlets;

import com.example.lab10.Beans.Clientes;
import com.example.lab10.Beans.Credentials;
import com.example.lab10.Daos.ClienteDao;
import com.example.lab10.Daos.DatosDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ServletAdmin", value = "/ServletAdmin")
public class ServletAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;

        ClienteDao clienteDao = new ClienteDao();
        ArrayList<Clientes> lista = clienteDao.listarClientesNoCredentials();




        switch (action) {
            case "Inicio":
                Credentials user = (Credentials) request.getSession().getAttribute("userlogged");
                if (user != null) {
                    request.setAttribute("listaNoCredentials",lista);
                    requestDispatcher = request.getRequestDispatcher("Administrador.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    requestDispatcher = request.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(request, response);
                }
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        DatosDao datosDao = new DatosDao();

        switch (action) {

            case "guardar":
                String codigo_str = request.getParameter("codigo_elegir");

                String contrasena = request.getParameter("password");


                try {

                    datosDao.createCredentialCliente(codigo_str,contrasena);


                    response.sendRedirect(request.getContextPath() + "/ServletAdmin?action=Inicio");

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }


                break;


        }
    }
}
