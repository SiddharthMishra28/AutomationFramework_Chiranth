package com.zapskiller.automation.testcases;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConsole {
    public static void main(String[] args) {
        try {
            Server server = Server.createWebServer("-webAllowOthers", "-webPort", "8000").start();
            Server.createTcpServer("-tcpAllowOthers", "-tcpPort", "9092").start();
            String jdbcUrl = "jdbc:h2:mem:testdb";
            Connection connection = DriverManager.getConnection(jdbcUrl, "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
