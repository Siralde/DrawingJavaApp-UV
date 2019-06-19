package es.uv.eu.dibujadorLineasRectas.view.configurationView;

import es.uv.eu.dibujadorLineasRectas.model.DibujadorModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.event.ChangeListener;
import javax.swing.JLabel;

public class ConfigurationView extends JFrame{
    
    private DibujadorModel model;
    private JMenuBar menu;
    private ConfigurationPanel panelDegradado;
    private OptionPanel optionPanel;
    private boolean degradado;
    
    public ConfigurationView(JMenuBar menu, int altura, int ancho, DibujadorModel modelo, int GrosorInicial){
        this.degradado = true;
        this.model = modelo;
        this.menu = menu;
        this.setSize(altura, ancho);
        this.setLayout(new BorderLayout());
        this.setJMenuBar(menu);
        
        panelDegradado = new ConfigurationPanel(model, GrosorInicial);
        optionPanel = new OptionPanel();
        this.add(new JLabel("Configuracion"), BorderLayout.CENTER);
        
        add(panelDegradado, BorderLayout.CENTER);
        showDegradado(Color.MAGENTA);
        add(optionPanel, BorderLayout.SOUTH);
    }

    public void setMyActionListener(ActionListener myActionListener) {
        panelDegradado.setMyActionListener(myActionListener);
        optionPanel.setMyActionListener(myActionListener);
    }

    public void setMyChangeListener(ChangeListener myChangeListener) {
        panelDegradado.setMyChangeListener(myChangeListener);
    }

    public void setColor1(Color background) {
        model.setColor1Defecto(background);
        panelDegradado.setColor1(background);
        if(degradado == false)
        {
            model.setColor2Defecto(background);
        }
    }
    
    public void setColor2(Color background) {
        model.setColor2Defecto(background);
        panelDegradado.setColor2(background);
    }

    public void setGrosor(int nuevoGrosor) {
        model.setGrosorDefecto(nuevoGrosor);
        panelDegradado.setGrosor(nuevoGrosor);
    }

    public void showDegradado(Color c2) {
        panelDegradado.showDegradado();
        degradado = true;
        Color c1 = panelDegradado.getColor1();
        setColor1(c1);
        setColor2(c2);
    }

    public void showNoDegradado() {
        panelDegradado.showNoDegradado();
        degradado = false;
        Color c1 = panelDegradado.getColor1();
        setColor1(c1);
        setColor2(c1);
    }
    
    public boolean getDegradado(){
        return degradado;
    }
}
