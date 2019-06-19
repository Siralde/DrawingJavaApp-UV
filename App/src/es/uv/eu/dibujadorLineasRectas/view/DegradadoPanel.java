package es.uv.eu.dibujadorLineasRectas.view;

import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class DegradadoPanel extends JPanel{

    private ButtonGroup grupo;
    private JRadioButton on, off;
    
    public DegradadoPanel() {
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        this.setBorder(border);
        grupo = new ButtonGroup();
        on = new JRadioButton("Degradado");
        off = new JRadioButton("No Degradado");
        
        grupo.add(on);
        grupo.add(off);
        on.setSelected(true);
        
        add(on);
        add(off);
    }
 
    public void setMyActionListener(ActionListener myActionListener){
        on.addActionListener(myActionListener);
        off.addActionListener(myActionListener);
    }

    public void showNoDegradado() {
        off.setSelected(true);
    }

    public void showDegradado() {
        on.setSelected(true);
    }
}
