package es.uv.eu.dibujadorLineasRectas.view;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatusNoDegradado extends JPanel{
    
    private JLabel numLinea;
    private JLabel grosorLinea;
    private JLabel color1;
    private Color c1;
    private JTextField indiceNumeroLinea;
    private JTextField indiceGrosorLinea;
    private JTextField indiceC1;
    private JTextField indiceC2;
    
    public StatusNoDegradado(boolean mostrarNLineas){

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        c1 = Color.CYAN;
        numLinea = new JLabel("Num Lineas");
        indiceNumeroLinea = new JTextField(3);
        grosorLinea = new JLabel("Grosor de la Linea");
        indiceGrosorLinea = new JTextField(3);
        color1 = new JLabel("Color 1");
        indiceC1 = new JTextField(3);

        indiceGrosorLinea.setText(""+20);
        indiceC1.setBackground(c1);
        indiceNumeroLinea.setText("0");


        add(Box.createRigidArea(new Dimension(50, 5)));
        add(grosorLinea);
        add(indiceGrosorLinea);
        add(Box.createRigidArea(new Dimension(200, 5)));
        add(color1);
        add(indiceC1);
        add(Box.createRigidArea(new Dimension(200, 5)));
        if(mostrarNLineas == true)
        {
            add(numLinea);
            add(indiceNumeroLinea);
            add(Box.createRigidArea(new Dimension(50, 5)));
        }
    }
    
    public void setColor1(Color background) {
        c1 = background;
        indiceC1.setBackground(c1);
    }
    
    public Color getColor1() {
        return c1;
    }

    public void setGrosor(int fps) {
        indiceGrosorLinea.setText(""+fps);
    }
    
    public void setNumLineas(int numLineas) {
        indiceNumeroLinea.setText(""+numLineas);
    }
}

