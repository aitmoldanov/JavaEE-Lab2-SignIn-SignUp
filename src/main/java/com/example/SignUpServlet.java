package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String login = request.getParameter("email");
    String password = request.getParameter("password");
    String repeatPassword = request.getParameter("secondPassword");

    if (password.equals(repeatPassword)){
        out.println("<h2>Your login: " + login + "</h2><br>");
        out.println("<h2>Your password: " + password + "</h2><br>");
        out.println("Go to <a href='mainPage.jsp'>Main page</a>");
    }else{
        out.println("<h2>Wrong credentials! Try again...</h1>");
        out.println("Go to <a href='mainPage.jsp'>Main page</a>");
    }
    out.close();
}
}
