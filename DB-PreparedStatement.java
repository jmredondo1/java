package basedatos;

import java.sql.*;

public class BaseDatos {

    /**
     *
     * IMPORTANTE: Añadir el driver de DERBY a las librerías del proyecto
     * C:\Program Files\Java\jdk1.7.0_21\db\lib\derbyclient.jar
     *
     * Sintaxis de la conexión:
     * Connection connection = DriverManager.getConnection(driver + db[, user, pass]);
     *	
     */
    public static void main(String[] args) {

        String driver = "jdbc:derby://localhost:1527/";
        String db = "PRUEBA";
        String user = "";
        String pass = "";

        try {
//            
            Connection connection = DriverManager.getConnection(driver + db);
//            Statement statement = connection.createStatement();
//            String insert = "INSERT INTO PERSONAS "
//                    + "(id, nombre, saldo, fecha) "
//                    + "VALUES "
//                    + "(5,'nombre-5',500.5,'2016-12-05')";
//            statement.executeUpdate(insert);

            //ResultSet resultSet = statement.executeQuery("select * from PERSONAS");
            PreparedStatement statement = connection.prepareStatement("select * from PERSONAS where saldo=? and fecha =?");
            statement.setString(1, "500.5");
            statement.setString(2, "2016-12-05");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("-->\t"
                        + resultSet.getString("id") + "\t"
                        + resultSet.getString("nombre") + "\t"
                        + resultSet.getString("saldo") + "\t"
                        + resultSet.getString("fecha")
                );
            }

        } catch (SQLException ex) {
            ex.getMessage();
        }

    }

}
