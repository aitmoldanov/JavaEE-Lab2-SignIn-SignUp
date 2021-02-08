package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignInServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String login = request.getParameter("email");
        String password = request.getParameter("password");

        if (login.equals("assem@mail.ru") && password.equals("admin")){
            out.println("<h1>Welcome, " + login + "</h1><br>");
            out.println("<h2>Your password: " + password + "</h2><br>");
            out.println("Go to <a href='main.jsp'>Main page</a>");
        }else{
            out.println("<h2>Incorrect! Try again or register.</h1><br>");
            out.println("Go to <a href='main.jsp'>Main page</a>");
//            request.getRequestDispatcher("/main.jsp").forward(request, response);
        }
        out.close();
    }
}
