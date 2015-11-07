package _17_db;

import java.sql.*;
import java.util.Scanner;

/**
 * create database Family;
 * create table family (id integer auto_increment, name varchar(255), birthyear integer, height integer, weight integer, primary key (id));
 */
public class DB {

    private static Connection connection;

    static {
        System.out.println("Initializing DB connection");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Family", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                System.out.println("shutting down DB connection");
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        fillTable();
        printTable();
    }

    private static void fillTable() {
        System.out.println("Input persons in format NAME YEAR HEIGHT WEIGHT (empty input for finish)");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into family values (0, ?, ?, ?, ?);");
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                if (line.equals("")) {
                    break;
                }

                preparedStatement.setString(1, line.split(" ")[0]);
                preparedStatement.setInt(2, Integer.valueOf(line.split(" ")[1]));
                preparedStatement.setInt(3, Integer.valueOf(line.split(" ")[2]));
                preparedStatement.setInt(4, Integer.valueOf(line.split(" ")[3]));

                preparedStatement.executeUpdate();
            }

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printTable() {
        try {
            Statement statement = connection.createStatement();
            queryAndPrint(statement, "select * from family");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void queryAndPrint(Statement statement, String query) {
        try {
            ResultSet rs = statement.executeQuery(query);
            print(rs);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void print(ResultSet rs) throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        int columns = metaData.getColumnCount();

        while (rs.next()) {   /// process result
            for (int i = 1; i <= columns; i++) {
                System.out.print(rs.getString(i) + " ");
            }
            System.out.println();
        }
    }
}
