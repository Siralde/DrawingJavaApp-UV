package es.uv.eu.dibujadorLineasRectas.view;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DibujadorMenuBar extends JMenuBar {
    private JMenu navegacion;
    private JMenuItem ventanaConfiguracion, ventanaSketcher, ventanaAutor, salir;
    
    public DibujadorMenuBar(){
        navegacion = new JMenu("Navegacion");
        ventanaConfiguracion = new JMenuItem("Ventana Configuracion");
        ventanaSketcher = new JMenuItem("Ventana Sketcher");
        ventanaAutor = new JMenuItem("Ventana Autor");
        salir = new JMenuItem("Salir");
        
        navegacion.add(ventanaConfiguracion);
        navegacion.add(ventanaSketcher);
        navegacion.add(ventanaAutor);
        navegacion.add(salir);
        this.add(navegacion);
    }

    public void setMyActionListener(ActionListener myActionListener) {
        salir.addActionListener(myActionListener);
        ventanaConfiguracion.addActionListener(myActionListener);
        ventanaAutor.addActionListener(myActionListener);
        ventanaSketcher.addActionListener(myActionListener);
    }
}