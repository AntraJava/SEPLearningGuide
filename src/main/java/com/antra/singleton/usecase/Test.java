package com.antra.singleton.usecase;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.*;

public class Test {
    // Menu - id , name
    // dish - id, name, category, menu_id    (many to one), price
    // ingredient - id, name
    // dish_ingredient_association - id, dish_id, ingredient_id
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sep_training", "sep_user", "aabbccdd");
        Statement statement = connection.createStatement();
        String p = "3 or 1=1";
        ResultSet rs = statement.executeQuery("select * from dish where id = " + p);
        while (rs.next()) {
            String name = rs.getString(2);
            String c = rs.getString(3);
            float price = rs.getFloat("price");
            System.out.println(name + " - " + c + " - " + price);
        }
        System.out.println("/////");
        PreparedStatement ps = connection.prepareStatement("select * from dish where id = ?");
        ps.setInt(1, 3);
        ResultSet rs1 = ps.executeQuery();
        while (rs1.next()) {
            String name = rs1.getString(2);
            String c = rs1.getString(3);
            float price = rs1.getFloat("price");
            System.out.println(name + " - " + c + " - " + price);
        }
    }
}

