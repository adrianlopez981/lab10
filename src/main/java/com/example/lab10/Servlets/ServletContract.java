package com.example.lab10.Servlets;

import com.example.lab10.Daos.ContratoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletContract", value = "/ServletContract")
public class ServletContract extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("accion") == null?"listar":request.getParameter("accion");
        ContratoDao contratoDao = new ContratoDao();
        jakarta.servlet.RequestDispatcher view;


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
