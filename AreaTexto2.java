// �REA DE TEXTO CONTROLANDO SALTOS Y SCROLL
package textarea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class TextArea {

    public static void main(String[] args) {
        // Esto es para poner la apariencia de la ventana como la del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("ERROR Look&Feel: " + ex);
        }
        Frame f = new Frame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

}

class Frame extends JFrame {

    private JPanel panelBotones; // Panel para los botones
    private JScrollPane panelScroll; // Panel para el �rea de texto con scroll
    private JButton btnInsertar, btnSalto;
    private JTextArea areaTexto;

    public Frame() {
        setTitle("TextArea");
        setBounds(500, 300, 500, 350);
        setLayout(new BorderLayout());

        // Bot�n INSERTAR. Inserta un texto en el �rea
        // En lugar de crear una clase, instanciarla y asignarla al bot�n, creamos una clase an�nima y lo hacemos todo en el mismo sitio
        btnInsertar = new JButton("Insertar");
        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.append("Nuevo texto Nuevo texto Nuevo texto Nuevo texto");
            }
        });
        // Bot�n SALTO
        btnSalto = new JButton("Salto l�nea");
        btnSalto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean saltar = !areaTexto.getLineWrap();
                areaTexto.setLineWrap(saltar);
//                
//                if (saltar) {
//                    btnSalto.setText("Quitar saltos");
//                } else {
//                    btnSalto.setText("Poner saltos");
//                }
                // Alternativa con operador ternario
                btnSalto.setText(saltar ? "Quitar saltos" : "Poner saltos");

            }

        });

        // A�adimos los botones al panel de los botones
        panelBotones = new JPanel();
        panelBotones.add(btnInsertar);
        panelBotones.add(btnSalto);
        // Lo a�adimos al marco y lo ponemos abajo
        add(panelBotones, BorderLayout.SOUTH);

        // Creamos el area de texto y lo a�adimos al panel con scroll
        areaTexto = new JTextArea(8, 20);
        panelScroll = new JScrollPane(areaTexto);
        //panelScroll.add(areaTexto);

        // A�adimos el �rea con scroll a la zona central del marco
        add(panelScroll, BorderLayout.CENTER);
    }

}
