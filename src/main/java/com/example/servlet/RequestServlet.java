package com.example.servlet;

import com.example.model.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/requestAccess")
public class RequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = ((User) session.getAttribute("user")).getId();

        String softwareId = request.getParameter("softwareId");
        String accessType = request.getParameter("accessType");
        String reason = request.getParameter("reason");

        Request accessRequest = new Request(userId, Integer.parseInt(softwareId), accessType, reason);
        accessRequest.save();  // Assumes method to store request in DB

        response.sendRedirect("requestAccess.jsp?success=1");
    }
}
