package com.example.servlet;

import com.example.model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = User.authenticate(username, password);  // Assumes a static method for authentication

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            switch (user.getRole()) {
                case "Employee":
                    response.sendRedirect("requestAccess.jsp");
                    break;
                case "Manager":
                    response.sendRedirect("pendingRequests.jsp");
                    break;
                case "Admin":
                    response.sendRedirect("createSoftware.jsp");
                    break;
            }
        } else {
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}
