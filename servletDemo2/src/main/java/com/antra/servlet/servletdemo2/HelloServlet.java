package com.antra.servlet.servletdemo2;

import java.io.*;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/hi")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<strong>Welcome!</strong>");
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            String name = dbOperation(id);
            resp.getWriter().write("<strong>" + name + "!</strong>");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String dbOperation(int id) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sep_training", "sep_user", "aabbccdd");
        Statement statement = connection.createStatement();

        PreparedStatement ps = connection.prepareStatement("select * from menu where id = ?");
        ps.setInt(1, id);
        ResultSet rs1 = ps.executeQuery();
        String name = "";
        while (rs1.next()) {
            name = rs1.getString(2);
            System.out.println(name);
        }
        return name;
    }
}
