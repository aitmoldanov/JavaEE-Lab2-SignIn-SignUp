package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/signIn")
public class SignInServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String login = request.getParameter("email");
        String password = request.getParameter("password");

        if (login.equals("abzal@gmail.com") && password.equals("password")){
            HttpSession session = request.getSession();
            session.setAttribute("email", "aitmolda");
            Cookie user = new Cookie("email", login);
            response.addCookie(user);
            response.sendRedirect("welcomeBack.jsp");
        }else{
            out.println("<h2>Incorrect! Try again or register.</h1><br>");
            out.println("Go to <a href='mainPage.jsp'>Main page</a>");

        }
        out.close();
    }
}
