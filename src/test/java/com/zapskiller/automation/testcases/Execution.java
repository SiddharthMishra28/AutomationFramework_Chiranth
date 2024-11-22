package com.zapskiller.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class Execution {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:h2:tcp://localhost:9092/" + System.getProperty("user.dir") + "/data/db";
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, "sa", "");
            String query = "SELECT \n" +
                    "  page.*,\n" +
                    "  app.name AS application_name,\n" +
                    "  app.description AS application_description\n" +
                    "FROM \n" +
                    "  page\n" +
                    "  JOIN application app ON page.application_id = app.id\n" +
                    "WHERE \n" +
                    "  page.application_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "1");
//            statement.setString(2, "QA");
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String element = rs.getString("element");
                    String locator_type = rs.getString("locator_type");
                    String locator_text = rs.getString("locator_text");
                    String element_description = rs.getString("element_description");
                    dbRowParser(locator_type, locator_text);
                    System.out.println("ID: " + id);
                    System.out.println("element: " + element);
                    System.out.println("locator_type: " + locator_type);
                    System.out.println("locator_text: " + locator_text);
                    System.out.println("Element Description: " + element_description);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebElement dbRowParser(String locator_type, String locator_text) {
        WebDriver driver = new ChromeDriver();
        switch (locator_type) {
            case "XPATH":
                return driver.findElement(By.xpath(locator_text));

            case "ID":
                return driver.findElement(By.id(locator_text));
        }
        return null;
    }
}
