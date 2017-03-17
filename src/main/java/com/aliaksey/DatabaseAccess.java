package com.aliaksey;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet()
public class DatabaseAccess extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/spp_hotels_db?","root","admin");
            Statement statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from room_type");
            out.println("<table border=\"1\">");
            while(resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getInt("room_type_id") + "</td>");
                out.println("<td>" + resultSet.getString("room_name") + "</td>");
                out.println("<td>" + resultSet.getInt("blocks_count") + "</td>");
                out.println("<td>" + resultSet.getInt("beds_count") + "</td>");
                out.println("<td>" + resultSet.getDouble("cost_per_day") + "</td>");
                out.println("<td>" + resultSet.getString("additional_inf") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            connect.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(out != null)
            out.close();
        }

    }
}
