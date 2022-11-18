package com.example.lab10.Servlets;

import com.example.lab10.Beans.Clientes;
import com.example.lab10.Daos.ClienteDao;
import com.sun.security.ntlm.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletClient", value = "/ServletClient")
public class ServletClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion")==null?"listar":request.getParameter("accion");
        RequestDispatcher view;
        ClienteDao cliente = new ClienteDao();

        switch(accion){
            case("buscar"):
                String buscar = request.getParameter("nrodocumento");
                int id = Integer.parseInt(buscar);
                Clientes lista = cliente.buscarCliente(id);
                request.setAttribute("ListaClientes",lista);
                view = request.getRequestDispatcher("/menuHeroes.jsp");
                view.forward(request,response);
                break;
        }








    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
