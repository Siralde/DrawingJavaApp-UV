package es.uv.eu.dibujadorLineasRectas.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class StatusPanel extends JPanel{

    private StatusDegradado panelDegradado;
    private StatusNoDegradado panelSinDegradado;
    
    public StatusPanel(boolean mostrarNLineas){  
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        this.setBorder(border);
        
        panelDegradado = new StatusDegradado(mostrarNLineas);
        panelSinDegradado = new StatusNoDegradado(mostrarNLineas);
        
        add(panelDegradado);
        add(panelSinDegradado);

        showDegradado();
    }

    public void setColor1(Color background) {
        panelDegradado.setColor1(background);
        panelSinDegradado.setColor1(background);
    }

    public void setColor2(Color background) {
        panelDegradado.setColor2(background);
    }
    
    public Color getColor1() {
        return panelDegradado.getColor1();
    }

    public Color getColor2() {
        return panelDegradado.getColor2();
    }

    public void setGrosor(int fps) {
        panelDegradado.setGrosor(fps);
        panelSinDegradado.setGrosor(fps);
    }
    
    public void setNumLineas(int numLineas) {
        panelDegradado.setNumLineas(numLineas);
        panelSinDegradado.setNumLineas(numLineas);
    }

    public void showDegradado() {
        panelDegradado.setVisible(true);
        panelSinDegradado.setVisible(false);
    }

    public void showNoDegradado() {
        panelDegradado.setVisible(false);
        panelSinDegradado.setVisible(true);
    }   
}
