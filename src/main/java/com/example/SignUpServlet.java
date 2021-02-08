package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SignUpServlet extends HttpServlet {public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws  IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String userName = request.getParameter("name");
    String login = request.getParameter("email");
    String password = request.getParameter("password");
    String repeatPassword = request.getParameter("repeatPassword");

    if (password.equals(repeatPassword)){
        out.println("<h2>Welcome, " + userName + "</h2><br>");
        out.println("<h2>Your login: " + login + "</h2><br>");
        out.println("<h2>Your password: " + password + "</h2><br>");
    }else{
        out.println("<h2>Wrong credentials! Try again...</h1>");
        out.println("Go to <a href='main.jsp'>Main page</a>");
    }
    out.close();

}
}
