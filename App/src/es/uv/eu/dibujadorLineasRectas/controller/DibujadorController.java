package es.uv.eu.dibujadorLineasRectas.controller;

import es.uv.eu.dibujadorLineasRectas.model.DibujadorModel;
import es.uv.eu.dibujadorLineasRectas.view.DibujadorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DibujadorController {
    
    DibujadorView view;
    DibujadorModel model;
    
    public DibujadorController(DibujadorView view, DibujadorModel model){
        this.view = view;
        this.model = model;
        
        MyActionListener myActionListener = new MyActionListener();
        MyMouseListener myMouseListener = new MyMouseListener();
        MyChangeListener myChangeListener = new MyChangeListener();
        
        view.setMyActionListener(myActionListener);
        view.setMyMouseListener(myMouseListener);
        view.setMyChangeListener(myChangeListener);
    }
    
    public class MyActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event) {

            JButton botonColores;
            
            switch(event.getActionCommand()){
                case "Salir":
                    System.exit(0);
                break;
                case "Ventana Configuracion":
                    view.setVentanaConfiguracion();
                break;
                case "Ventana Sketcher":
                case "Siguiente":
                    view.setVentanaSketcher();
                break;
                case "Ventana Autor":
                    view.setVentanaAutor();
                break;
                case "Degradado":  
                    view.showDegradado();
                break;
                case "No Degradado":
                    view.showNoDegradado();
                break;
                case "Restablecer por Defecto":
                    view.resetTemporales();
                break;
                case "Borrar Lineas":
                    view.borrarLineas();
                break;
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                case "9":
                case "10":
                case "11":
                case "12":
                    botonColores = (JButton) event.getSource();
                    view.setColor1(botonColores.getBackground());
                break;
                case "13":
                case "14":
                case "15":
                case "16":
                case "17":
                case "18":
                case "19":
                case "20":
                case "21":
                case "22":
                case "23":
                case "24":
                case "25":
                    botonColores = (JButton) event.getSource();
                    view.setColor2(botonColores.getBackground());
                break;
            }
        } 
    }
    
    public class MyMouseListener extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            
            int x = e.getX();
            int y = e.getY();
            
            switch(e.getButton()){
                case 1:
                    if(view.pintarLinea(x, y))
                        view.setNumLineas(model.getNumLineas());
                break;
                case 3:
                    int grosor = model.getGrosorTemporal();
                    if(grosor < 96)
                        view.setGrosor(grosor + 5);
                    else
                        view.setGrosor(100);
                break;
                    
            }
        }   
    }
    
    public class MyChangeListener implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider) e.getSource();
            int fps = (int)source.getValue();
            view.setGrosor(fps);
        }
    }
}
