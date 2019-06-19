package es.uv.eu.dibujadorLineasRectas.view.configurationView;

import es.uv.eu.dibujadorLineasRectas.model.DibujadorModel;
import es.uv.eu.dibujadorLineasRectas.view.GrosorPanel;
import es.uv.eu.dibujadorLineasRectas.view.SelectPanel;
import es.uv.eu.dibujadorLineasRectas.view.StatusPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

public class ConfigurationPanel extends JPanel{

    private DibujadorModel model;
    private GrosorPanel grosorPanel;
    private SelectPanel selectPanel;
    private StatusPanel statusPanel;

    public ConfigurationPanel(DibujadorModel modelo, int GrosorInicial){
        this.model = modelo;
        this.setLayout(new BorderLayout());
        
        statusPanel = new StatusPanel(false);
        selectPanel = new SelectPanel(false);
        grosorPanel = new GrosorPanel(GrosorInicial);

        add(statusPanel, BorderLayout.NORTH);
        add(selectPanel, BorderLayout.CENTER);
        add(grosorPanel, BorderLayout.SOUTH);
    }

    public void setMyActionListener(ActionListener myActionListener) {
        selectPanel.setMyActionListener(myActionListener);
    }

    public void setMyChangeListener(ChangeListener myChangeListener) {
        grosorPanel.setMyChangeListener(myChangeListener);
    }

    public void setColor1(Color background) {
        statusPanel.setColor1(background);
    }

    public void setColor2(Color background) {
        statusPanel.setColor2(background);
    }

    public void setGrosor(int nuevoGrosor) {
        statusPanel.setGrosor(nuevoGrosor);
    }
    
    public void showDegradado(){
        statusPanel.showDegradado();
        selectPanel.showDegradado();
    }
    
    public void showNoDegradado(){
        statusPanel.showNoDegradado();
        selectPanel.showNoDegradado();
    }

    public Color getColor1() {
        return statusPanel.getColor1();
    }

    public Color getColor2() {
        return statusPanel.getColor2();
    }
}
