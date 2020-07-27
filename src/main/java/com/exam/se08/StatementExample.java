package com.exam.se08;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

@Log4j2
public class StatementExample {
    public static void main(String[] args) throws SQLException, IOException {

        log.error("Error message");

        Properties dbProperties = new Properties();
        dbProperties.load(StatementExample.class.getResourceAsStream("db.properties"));

        try (Connection connection = DriverManager.getConnection(dbProperties.getProperty("instance"), dbProperties)) {
            try (Statement statement = connection.createStatement()) {
                int numberInsertedRows = statement.executeUpdate("INSERT INTO UNIVERSITY.STUDENTS(ID, LAST_NAME, FIRST_NAME, GROUP_ID) VALUES (0, 'Ivan', 'Ivanov', 1303)");
                System.out.println(numberInsertedRows);
                try (ResultSet rs = statement.executeQuery("SELECT * FROM UNIVERSITY.GROUPS")) {
                        while (rs.next()) {
                            int id = rs.getInt("ID");
                            int departmentId = rs.getInt("DEPARTAMENT_ID");
                            String trainingProgram = rs.getString("TRAINING_PROGRAM");
                            System.out.println(id + " " + departmentId + " " + trainingProgram);
                        }
                    }

                try (ResultSet rs = statement.executeQuery("SELECT * FROM UNIVERSITY.STUDENTS")) {
                    while (rs.next()) {
                        int id = rs.getInt("ID");
                        String last_name = rs.getString("LAST_NAME");
                        String first_name = rs.getString("FIRST_NAME");
                        int group_id = rs.getInt("GROUP_ID");
                        System.out.println(id + " " + last_name + " " + first_name + " " + group_id);
                    }
                }

            }
        }
    }
}
