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
    JComboBox codigos;
    JComboBox disponible;
    JTextArea resultado;
    JButton consulta;
    private PreparedStatement ps;
    private final String sql = "select * from product where product_code=?";

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
            String codigo = (String) codigos.getSelectedItem();
            String dispon = (String) disponible.getSelectedItem();
            if (codigo.equals("Todos") && dispon.equals("Todos")) {
                
                /**
                 * video 208 
                 * 
                 * 
                 * 
                 */
            }
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                resultado.append(rs.getString(1));
                resultado.append(", ");
                resultado.append(rs.getString(2));
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
