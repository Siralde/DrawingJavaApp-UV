package es.uv.eu.dibujadorLineasRectas.view;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeListener;

public class GrosorPanel extends JPanel{

    private JLabel etiqueta;
    private JSlider radioCirculo;
    
    public GrosorPanel(int GrosorInicial){
        this.setLayout(new BorderLayout());
        
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        this.setBorder(border);
        
        etiqueta = new JLabel("Grosor del Circulo:");
        radioCirculo = new JSlider(0, 100);
        radioCirculo.setMinorTickSpacing(5);
        radioCirculo.setMajorTickSpacing(10);
        radioCirculo.setPaintTicks(true);
        radioCirculo.setPaintLabels(true);
        radioCirculo.setFont(new Font("Sans", Font.BOLD, 10));
        radioCirculo.setValue(GrosorInicial);
        
        
        this.add(etiqueta, BorderLayout.NORTH);
        this.add(radioCirculo, BorderLayout.CENTER);

    }

    public void setMyChangeListener(ChangeListener myChangeListener) {
        radioCirculo.addChangeListener(myChangeListener);
    }

    public void setGrosor(int nuevoGrosor) {
        radioCirculo.setValue(nuevoGrosor);
    }
}
