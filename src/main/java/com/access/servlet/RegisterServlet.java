package com.access.servlet;

import com.access.util.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);

            int rows = stmt.executeUpdate();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            if (rows > 0) {
                out.println("<h3>Registration Successful!</h3>");
            } else {
                out.println("<h3>Failed to Register.</h3>");
            }
        } catch (Exception e) {
            throw new ServletException("Database error: " + e.getMessage());
        }
    }
}
