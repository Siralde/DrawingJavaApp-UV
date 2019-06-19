package es.uv.eu.dibujadorLineasRectas.view.sketcherView;

import es.uv.eu.dibujadorLineasRectas.view.StatusPanel;
import es.uv.eu.dibujadorLineasRectas.model.DibujadorModel;
import es.uv.eu.dibujadorLineasRectas.view.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.event.ChangeListener;

public class SketcherView extends JFrame{
    
    private JMenuBar menu;
    private DibujadorModel model;
    private SketcherPanel sketcherPanel;
    private SelectPanel selectPanel;
    private GrosorPanel grosorPanel;
    private StatusPanel statusPanel;
    private boolean degradado;
    
    public SketcherView(JMenuBar menu, int altura, int ancho, DibujadorModel modelo, int GrosorInicial){
        this.degradado = true;
        this.model = modelo;
        this.menu = menu;
        this.setLayout(new BorderLayout());
        this.setSize(altura, ancho);
        this.sketcherPanel = new SketcherPanel(model);
        this.selectPanel = new SelectPanel(true);
        this.grosorPanel = new GrosorPanel(GrosorInicial);
        this.statusPanel = new StatusPanel(true);
       
        this.setJMenuBar(menu);
        this.add(statusPanel, BorderLayout.NORTH);
        this.add(selectPanel, BorderLayout.WEST);
        this.add(grosorPanel, BorderLayout.SOUTH);
        this.add(sketcherPanel, BorderLayout.CENTER);
    }

    public void setMyMouseListener(MouseListener myMouseListener) {
        sketcherPanel.setMyMouseListener(myMouseListener);
    }

    public Boolean pintarLinea(int x, int y) {
        return sketcherPanel.pintarLinea(x, y);
    }

    public void setGrosor(int nuevoGrosor) {
        statusPanel.setGrosor(nuevoGrosor);
        grosorPanel.setGrosor(nuevoGrosor);
        model.setGrosorTemporal(nuevoGrosor);
    }

    public void setMyChangeListener(ChangeListener myChangeListener) {
        grosorPanel.setMyChangeListener(myChangeListener);
    }

    public void setMyActionListener(ActionListener myActionListener) {
        selectPanel.setMyActionListener(myActionListener);
    }

    public void setColor1(Color background) {
        statusPanel.setColor1(background);
        model.setColor1Temporal(background);
        if(degradado == false)
        {
            model.setColor2Temporal(background);
        }
    }

    public void setColor2(Color background) {
        statusPanel.setColor2(background);
        model.setColor2Temporal(background);
    }

    public void setNumLineas(int numLineas) {
        statusPanel.setNumLineas(numLineas);
    }

    public void showDegradado(Color c2) {
        selectPanel.showDegradado();
        statusPanel.showDegradado();
        degradado = true;
        Color c1 = statusPanel.getColor1();
        setColor1(c1);
        setColor2(c2);
    }

    public void showNoDegradado() {
        selectPanel.showNoDegradado();
        statusPanel.showNoDegradado();
        degradado = false;
        Color c1 = statusPanel.getColor1();
        setColor1(c1);
    }

    public void refrescar() {
        sketcherPanel.repaint();
    }

    public void setDegradado(boolean degradado) {
        this.degradado = degradado;
    }
}
