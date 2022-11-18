package com.example.lab10.Servlets;

import com.example.lab10.Beans.Clientes;
import com.example.lab10.Beans.Credentials;
import com.example.lab10.Daos.ClienteDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletClient", value = "/ServletClient")
public class ServletClient extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion")==null?"listar":request.getParameter("accion");
        RequestDispatcher view;
        ClienteDao clienteDao = new ClienteDao();
        ArrayList<Clientes> lista = clienteDao.listarClientesNoCredentials();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Cliente.jsp");
        requestDispatcher.forward(request, response);

        switch (accion) {
            case "Inicio":
                Credentials user = (Credentials) request.getSession().getAttribute("userlogged");
                if (user != null) {
                    request.setAttribute("listaNoCredentials",lista);
                    requestDispatcher = request.getRequestDispatcher("Cliente.jsp");
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
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        ClienteDao clientedao = new ClienteDao();
        RequestDispatcher view;

        switch(accion){
            case("buscar"):
                String buscar = request.getParameter("nrodocumento");
                int id = Integer.parseInt(buscar);
                Clientes lista = clientedao.buscarCliente(id);
                request.setAttribute("ListaClientes",lista);
                view = request.getRequestDispatcher("/buscarCliente.jsp");
                view.forward(request,response);
                break;

        }

    }
}
