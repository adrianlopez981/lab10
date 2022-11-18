package com.example.lab10.Servlets;

import com.example.lab10.Beans.Clientes;
import com.example.lab10.Beans.Credentials;
import com.example.lab10.Daos.ClienteDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
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

    }
}
