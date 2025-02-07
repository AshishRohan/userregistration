package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Connection conn = null;
        PreparedStatement pst = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsbuddy", "root", "Stranger#8");

            // Check if username or email already exists
            pst = conn.prepareStatement("SELECT * FROM users WHERE username=? OR email=?");
            pst.setString(1, username);
            pst.setString(2, email);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                response.getWriter().write("User already exists");
            } else {
                // Insert new user
                pst = conn.prepareStatement("INSERT INTO users (username, email, password) VALUES (?, ?, ?)");
                pst.setString(1, username);
                pst.setString(2, email);
                pst.setString(3, password);
                int rows = pst.executeUpdate();

                if (rows > 0) {
                    response.getWriter().write("Registration successful");
                } else {
                    response.getWriter().write("Error occurred");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("Error: " + e.getMessage());
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
