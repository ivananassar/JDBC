package org.example;

import java.sql.*;



public class SqlConnection {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        //String jdbcUrl = "jdbc:sqlserver://MIS03-L:1434;databaseName=SPORTS";
        //String jdbcUrl = "jdbc:sqlserver://MIS03-L\\SQL Server (MSSQLSERVER);databaseName=SPORTS;user=MIS03-L/Administrator;password=;";

        //String jdbcUrl = "jdbc:sqlserver://MIS03-L:1434;databaseName=SPORTS;user=MIS03-L/Administrator;password=;";
        String jdbcUrl = "jdbc:sqlserver://MIS03-L;databaseName=SPORTS;integratedSecurity=true;";

        //String username = "MIS03-L/Administrator";
        //String password = "";

        try {
            // Load the JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish a connection
            Connection connection = DriverManager.getConnection(jdbcUrl);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery( "SELECT * FROM Emplois" );
            while (rs.next()) {
                String tE = rs.getString("typeEmplois");
                int min = rs.getInt("salaireMIN");
                int max = rs.getInt("salaireMAX");
                System.out.println( tE + " ont entre" + min + "et " + max + " $." );
            }
            rs.close();
            st.close();
            connection.close();
            // Do something with the connection (e.g., execute SQL queries)

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}