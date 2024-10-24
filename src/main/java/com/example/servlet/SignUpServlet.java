package com.example.servlet;

import com.example.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new User(username, password, "Employee");
        boolean success = user.save();  // Assumes a method to save user to DB

        if (success) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("signup.jsp?error=failed");
        }
    }
}
