package _18_db_with_reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * create database Students;
 * create table student (id varchar(255), name varchar(255), stip varchar(255));
*/
public class DBManager {

    private static Connection connection;

    static {
        System.out.println("Initializing DB connection");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/Students", "root", "root");
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

    public static <T> T get(Class<T> clazz, String id) {

        String tableName = clazz.getSimpleName().toLowerCase();

        try {
            PreparedStatement st = connection.prepareStatement("select * from "
                    + tableName + " where id = ?");

            st.setInt(1, Integer.valueOf(id));

            ResultSet rs = st.executeQuery();

            T t = load(rs, clazz);

            return t;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static <T> T load(ResultSet rs, Class<T> clazz) throws SQLException {

        rs.next();

        try {
            T t = clazz.newInstance();


            ResultSetMetaData metaData = rs.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String name = metaData.getColumnName(i);
                char[] charArray = name.toCharArray();
                charArray[0] = name.toUpperCase().charAt(0);
                String setterName = "set" + new String(charArray);
                Method setter = clazz.getMethod(setterName, String.class);
                setter.invoke(t, rs.getString(i));
            }

            return t;

        } catch (InstantiationException | IllegalAccessException
                | NoSuchMethodException | SecurityException
                | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Student get(int id) {
        System.out.println("get");

        try {
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery("select * from student where id = "
                    + id);

            Student student = getStudent(rs);

            return student;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Student getStudent(ResultSet rs) throws SQLException {
        Student st = new Student();
        if (!rs.next()) {
            return null;
        }
        st.id = rs.getString(1);
        st.name = rs.getString(2);
        st.stip = rs.getString(3);
        return st;
    }

    public static <T> void save(Class<T> clazz, T t) {

        String tableName = clazz.getSimpleName().toLowerCase();
        ArrayList<String> fields = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        try {
            for (Method method : clazz.getDeclaredMethods()) {
                String methodName = method.getName();
                if (methodName.startsWith("get")) {
                    fields.add(methodName.replace("get", ""));
                    values.add((String) method.invoke(t, null));
                }
            }

            insert(fields, values, tableName);

        } catch (InvocationTargetException | IllegalAccessException | SecurityException | IllegalArgumentException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insert(ArrayList<String> fields, ArrayList<String> values, String tableName) throws SQLException {

        String sql = "insert into " + tableName + " (";
        for (int i = 0; i < fields.size() - 1; i++)
            sql += fields.get(i) + ",";
        sql += fields.get(fields.size() - 1) + ")";

        sql += " values (";
        for (int i = 0; i < values.size() - 1; i++)
            sql += "'" + values.get(i) + "',";
        sql += "'" + values.get(values.size() - 1) + "')";

        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
        statement.close();
    }
}