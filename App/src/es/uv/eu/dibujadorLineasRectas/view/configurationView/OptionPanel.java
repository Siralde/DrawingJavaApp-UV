package es.uv.eu.dibujadorLineasRectas.view.configurationView;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class OptionPanel extends JPanel{
    
    JButton siguiente;
    
    public OptionPanel(){
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        this.setBorder(border);
        siguiente = new JButton("Siguiente");
        
        siguiente.setBackground(Color.green);
        siguiente.setOpaque(true);
        siguiente.setBorderPainted(false);

        add(siguiente);
    }
    
    public void setMyActionListener(ActionListener myActionListener){
        siguiente.addActionListener(myActionListener);
    }
}
