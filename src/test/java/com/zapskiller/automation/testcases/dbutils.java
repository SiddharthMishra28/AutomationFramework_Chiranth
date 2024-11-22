package com.zapskiller.automation.testcases;

import java.sql.*;

public class dbutils {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:h2:tcp://localhost:9092/" + System.getProperty("user.dir") + "/data/db";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "sa", "");
            String query = "SELECT \n" +
                    "  c.*,\n" +
                    "  a.name AS application_name,\n" +
                    "  a.description AS application_description\n" +
                    "FROM \n" +
                    "  config c\n" +
                    "  JOIN application a ON c.application_id = a.id\n" +
                    "WHERE \n" +
                    "  a.id = ? AND c.ENVIRONMENT = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "1");
            statement.setString(2, "QA");
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String key = rs.getString("key");
                    String value = rs.getString("value");
                    String applicationNameResult = rs.getString("application_name");
                    String applicationDescription = rs.getString("application_description");

                    System.out.println("ID: " + id);
                    System.out.println("Key: " + key);
                    System.out.println("Value: " + value);
                    System.out.println("Application Name: " + applicationNameResult);
                    System.out.println("Application Description: " + applicationDescription);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

