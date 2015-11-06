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
        ArrayList<String> values = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("describe " + tableName);
            while (resultSet.next()) {
                String columnName = resultSet.getString(1);
                char[] charArray = columnName.toCharArray();
                charArray[0] = columnName.toUpperCase().charAt(0);
                String getterName = "get" + new String(charArray);
                Method getter = clazz.getMethod(getterName, null);
                String value = (String) getter.invoke(t, null);
                values.add(value);
            }
            statement.close();
            resultSet.close();

            insert(values, tableName);

        } catch (NoSuchMethodException | IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insert(ArrayList<String> values, String tableName) throws SQLException {

        String sql = "insert into " + tableName + " values (";
        for (int i = 0; i < values.size() - 1; i++)
            sql += "?,";
        sql += "?);";

        PreparedStatement prepareStatement = connection.prepareStatement(sql);

        for (int index = 0; index < values.size(); index++)
            prepareStatement.setString(index + 1, values.get(index));

        prepareStatement.executeUpdate();
        prepareStatement.close();
    }
}