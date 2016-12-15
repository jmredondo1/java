package basedatos;

import java.sql.*;

public class BaseDatos {

    /**
     *
     * IMPORTANTE: Añadir el driver de DERBY a las librerías del proyecto
     * C:\Program Files\Java\jdk1.7.0_21\db\lib\derbyclient.jar
     *
     */
    public static void main(String[] args) {

        String driver = "jdbc:derby://localhost:1527/";
        String db = "sample";
        String user = "app";
        String pass = "app";

        try {
            Connection connection = DriverManager.getConnection(driver + db, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

    }

}
