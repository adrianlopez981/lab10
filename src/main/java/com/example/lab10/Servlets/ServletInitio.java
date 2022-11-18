package com.example.lab10.Servlets;


import com.example.lab10.Beans.Clientes;
import com.example.lab10.Beans.Credentials;
import com.example.lab10.Daos.ClienteDao;
import com.example.lab10.Daos.DatosDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;



@WebServlet(name = "ServletInitio", urlPatterns = {"","/ServletInitio"})
public class ServletInitio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");
        RequestDispatcher requestDispatcher;
        if (action == null) {
            RequestDispatcher view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
        } else {


            switch (action) {
                case "LogIn":
                    Credentials user = (Credentials) request.getSession().getAttribute("userlogged");

                    if (user != null && user.getNumeroDocumento() != null) {
                        response.sendRedirect(request.getContextPath());
                    } else {
                        requestDispatcher = request.getRequestDispatcher("index.jsp");
                        requestDispatcher.forward(request, response);
                    }
                    break;
                case "logout":
                    HttpSession session = request.getSession();
                    session.invalidate();
                    response.sendRedirect(request.getContextPath() + "/ServletInitio");
                    break;

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DatosDao daoDatos = new DatosDao();
        ClienteDao daoCliente = new ClienteDao();

        String codigo = request.getParameter("codigo");
        String password  = request.getParameter("password");
        Credentials credenciales = daoDatos.buscarUsuario(codigo,password);


        /*Clientes cliente = daoCliente.buscarCliente(Integer.parseInt(credenciales.getNumeroDocumento()));
        System.out.println(cliente.getNumeroDocumento());*/


        if(credenciales !=null){
            HttpSession session = request.getSession();
            session.setAttribute("userlogged",credenciales);


            if (credenciales.getTipoUsuario()==2){

                ArrayList<Clientes> lista = daoCliente.listarClientesNoCredentials();

                response.sendRedirect("ServletAdmin?action=Inicio");
                session.setAttribute("listaNoCredentials",lista);
            }else if (credenciales.getTipoUsuario()==1){
                response.sendRedirect("ServletCliente?action=");
            }
        }else{
            response.sendRedirect(request.getContextPath() + "ServletInitio?action=LogIn&error");
        }
    }
}
