package com.example.servlet;

import com.example.model.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/approveRequest")
public class ApprovalServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String action = request.getParameter("action");

        Request accessRequest = Request.findById(requestId);  // Load request from DB
        if (action.equals("approve")) {
            accessRequest.setStatus("Approved");
        } else {
            accessRequest.setStatus("Rejected");
        }
        accessRequest.update();  // Update request status in DB

        response.sendRedirect("pendingRequests.jsp");
    }
}
