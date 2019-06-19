package es.uv.eu.dibujadorLineasRectas.view;

import es.uv.eu.dibujadorLineasRectas.model.DibujadorModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.event.ChangeListener;

import es.uv.eu.dibujadorLineasRectas.view.sketcherView.SketcherView;
import es.uv.eu.dibujadorLineasRectas.view.configurationView.ConfigurationView;
import es.uv.eu.dibujadorLineasRectas.view.AuthorView.AuthorView;

public class DibujadorView{
    
    private DibujadorMenuBar menuConfig, menuSketch, menuAuthor;
    private SketcherView sketchFrame;
    private ConfigurationView configFrame;
    private AuthorView authorFrame;
    private DibujadorModel model;
    private int GrosorInicial = 20;
    private int ventana; // 0 = Configuracion, 1 = Sketcher, 2 = Author
    private boolean degradado;
    private Color c2Defecto;
    private Color c2Temporal;
    
    public DibujadorView(int altura, int ancho, DibujadorModel modelo){
        this.degradado = true;
        this.model = modelo;
        menuConfig = new DibujadorMenuBar();
        menuSketch = new DibujadorMenuBar();
        menuAuthor = new DibujadorMenuBar();
        configFrame = new ConfigurationView(menuConfig, altura, ancho, modelo, GrosorInicial);
        sketchFrame = new SketcherView(menuSketch, altura, ancho, modelo, GrosorInicial);
        authorFrame = new AuthorView(menuAuthor, altura, ancho, modelo);    
        c2Defecto = model.getColor2Defecto();
        c2Temporal = model.getColor2Temporal();
        setVentanaConfiguracion();    
    }

    public void setMyMouseListener(MouseListener myMouseListener) {
        sketchFrame.setMyMouseListener(myMouseListener);
    }
    
    public void setMyChangeListener(ChangeListener myChangeListener) {
        configFrame.setMyChangeListener(myChangeListener);
        sketchFrame.setMyChangeListener(myChangeListener);
    }

    public void setMyActionListener(ActionListener myActionListener) {
        menuConfig.setMyActionListener(myActionListener);
        menuSketch.setMyActionListener(myActionListener);
        menuAuthor.setMyActionListener(myActionListener);
        configFrame.setMyActionListener(myActionListener);
        sketchFrame.setMyActionListener(myActionListener);   
    }

    public Boolean pintarLinea(int x, int y) {
        return sketchFrame.pintarLinea(x, y);
    }
    
    public void setDegradadoSketcher(){
        sketchFrame.setDegradado(configFrame.getDegradado());
    }
    
    public void setNumLineas(int numLineas) {
        sketchFrame.setNumLineas(numLineas);
    }

    public void setGrosor(int nuevoGrosor) {
        if(ventana == 0)
        {
            configFrame.setGrosor(nuevoGrosor);
            sketchFrame.setGrosor(nuevoGrosor);
        }
        else if(ventana == 1)
            sketchFrame.setGrosor(nuevoGrosor);
    }

    public void setColor1(Color background) {
        if(ventana == 0)
        {
            configFrame.setColor1(background);
            sketchFrame.setColor1(background);
        }
        else if(ventana == 1)
            sketchFrame.setColor1(background);
    }

    public void setColor2(Color background) {
        if(ventana == 0)
        {
            c2Defecto = background;
            configFrame.setColor2(background);
            sketchFrame.setColor2(background);
        }
        else if(ventana == 1)
        {
            c2Temporal = background;
            sketchFrame.setColor2(background);   
        }
    }

    public void setVentanaConfiguracion() {
        configFrame.setVisible(true);
        sketchFrame.setVisible(false);
        authorFrame.setVisible(false);
        ventana = 0;
    }

    public void setVentanaSketcher() {
        model.setTemporales();
        configFrame.setVisible(false);
        sketchFrame.setVisible(true);
        authorFrame.setVisible(false);
        ventana = 1;
    }

    public void setVentanaAutor() {
        configFrame.setVisible(false);
        sketchFrame.setVisible(false);
        authorFrame.setVisible(true);
        ventana = 2;
    }

    public void showDegradado() {
        degradado = true;
        model.setColor2Defecto(c2Defecto);
        model.setColor2Temporal(c2Temporal);
        if(ventana == 0)
        {
            configFrame.showDegradado(c2Defecto);
            sketchFrame.showDegradado(c2Defecto);
        }
        else if(ventana == 1)
        {
            sketchFrame.showDegradado(c2Temporal);
        }
            
    }

    public void showNoDegradado() {
        c2Defecto = model.getColor2Defecto();
        c2Temporal = model.getColor2Temporal();
        degradado = false;
        if(ventana == 0)
        {
            configFrame.showNoDegradado();
            sketchFrame.showNoDegradado();
        }
        else if(ventana == 1)   
            sketchFrame.showNoDegradado();
    }

    public void resetTemporales() {
        model.setTemporales();
        setColor1(model.getColor1Temporal());
        setColor2(model.getColor2Temporal());
        setGrosor(model.getGrosorTemporal());
    }

    public void borrarLineas() {
        model.borrarLineas();
        sketchFrame.refrescar();
        setNumLineas(0);
    }
}
