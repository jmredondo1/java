package basedatosejemplo;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BaseDatosMain {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.getMessage();
        }
        Frame frame = new Frame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

}

class Frame extends JFrame {

    private Connection conn;
    private JComboBox codigos;
    private JComboBox disponible;
    private JTextArea resultado;
    private JButton consulta;
    private PreparedStatement ps;
    private final String sql_todos = "select * from product";
    private final String sql_product_code = "select * from product where product_code=?";
    private final String sql_available = "select * from product where available=?";
    private final String sql_available_and_product_code = "select * from product where product_code=? and available=?";

    public Frame() {
        setTitle("Consulta BBDD");
        setBounds(500, 300, 400, 400);
        setLayout(new BorderLayout());

        JPanel menu = new JPanel();
        menu.setLayout(new FlowLayout());

        codigos = new JComboBox();
        codigos.setEditable(false);
        codigos.addItem("Todos");

        disponible = new JComboBox();
        disponible.setEditable(false);
        disponible.addItem("Todos");

        resultado = new JTextArea(4, 50);
        resultado.setEditable(false);
        add(resultado);

        menu.add(codigos);
        menu.add(disponible);

        add(menu, BorderLayout.NORTH);
        add(resultado, BorderLayout.CENTER);

        consulta = new JButton("Consulta");
        consulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutaConsulta();
            }
        });
        add(consulta, BorderLayout.SOUTH);

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/productos", "app", "app");
            Statement statement = conn.createStatement();
            // CARGA PRIMER COMBO
            String consulta1 = "select DISTINCT product_code from product";
            ResultSet rs = statement.executeQuery(consulta1);
            while (rs.next()) {
                codigos.addItem(rs.getString(1));

            }
            rs.close();
            // CARGA SEGUNDO COMBO
            String consulta2 = "select DISTINCT AVAILABLE from product";
            rs = statement.executeQuery(consulta2);
            while (rs.next()) {
                disponible.addItem(rs.getString(1));
            }
            rs.close();

        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    private void ejecutaConsulta() {
        ResultSet rs = null;
        try {
            resultado.setText("");
            String product_code = (String) codigos.getSelectedItem();
            String available = (String) disponible.getSelectedItem();

            if (!product_code.equals("Todos") && available.equals("Todos")) {
                ps = conn.prepareStatement(sql_product_code);
                ps.setString(1, product_code);

            } else if (product_code.equals("Todos") && !available.equals("Todos")) {
                ps = conn.prepareStatement(sql_available);
                ps.setString(1, product_code);

            } else if (product_code.equals("Todos") && available.equals("Todos")) {
                ps = conn.prepareStatement(sql_todos);

            } else {
                ps = conn.prepareStatement(sql_available_and_product_code);
                ps.setString(1, product_code);
                ps.setString(2, available);

            }
            rs = ps.executeQuery();

            while (rs.next()) {
                
                resultado.append(rs.getString(8));
                resultado.append(", ");
                resultado.append(rs.getString(7));
                resultado.append(", ");
                resultado.append(rs.getString(3));
                resultado.append(", ");
                resultado.append(rs.getString(4));
                resultado.append("\n");

            }
            rs.close();
        } catch (Exception e) {
            e.getMessage();
        }

    }

}