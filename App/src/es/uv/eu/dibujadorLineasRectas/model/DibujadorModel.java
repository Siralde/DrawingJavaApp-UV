package es.uv.eu.dibujadorLineasRectas.model;

import java.awt.Color;
import java.util.ArrayList;

public class DibujadorModel {

       ArrayList<Linea> lineas;
       int numeroLineas;
       /*
        * Aqui se guardaran los valores de la ventana configuracion
        */
        int grosorDefecto;
        Color color1Defecto; // Aqui se guardara el color 1 o e
        Color color2Defecto;
        int degradadoDefecto; // 1 o 0 dependiendo si el usuario quiere o no degradado
        /*
        * Aqui se guardaran los valores de la ventana scketcher
        */
        int grosorTemporal;
        Color color1Temporal; 
        Color color2Temporal;
        int degradadoTemporal; // 1 o 0 dependiendo si el usuario quiere o no degradado
    
    public DibujadorModel() {
        numeroLineas = 0;
        lineas = new ArrayList<Linea>();
        setDefectos();
        setTemporales();
    }
    
    /*
    * Iguala los argumentos de la ventana configuracion a valores iniciales
    */
    public void setDefectos(){
        grosorDefecto = 20;
        color1Defecto = Color.CYAN; 
        color2Defecto = Color.MAGENTA;
        degradadoDefecto = 1;
    }
    /*
    * Iguala los argumentos de la ventana sketcher a los de la ventana configuracion
    */
    public void setTemporales(){
        grosorTemporal = grosorDefecto;
        color1Temporal = color1Defecto;
        color2Temporal = color2Defecto;
        degradadoTemporal = degradadoDefecto;
    }
    
    public void setGrosorDefecto(int nuevoGrosor){
        grosorDefecto = nuevoGrosor;
    }
    
    public void setColor1Defecto(Color nuevoColor){
        color1Defecto = nuevoColor;
    }
    
    public void setColor2Defecto(Color nuevoColor){
        color2Defecto = nuevoColor;
    }
    
    public void setDegradadoDefecto(int valor){
        degradadoDefecto = valor;
    }

    
    public void setGrosorTemporal(int nuevoGrosor){
        grosorTemporal = nuevoGrosor;
    }
    
    public void setColor1Temporal(Color nuevoColor){
        color1Temporal = nuevoColor;
    }
    
    public void setColor2Temporal(Color nuevoColor){
        color2Temporal = nuevoColor;
    }
    
    public void setDegradadoTemporal(int valor){
        degradadoTemporal = valor;
    }
    
    public int getGrosorDefecto(){
        return grosorDefecto;
    }
    
    public Color getColor1Defecto(){
        return color1Defecto;
    }
    
    public Color getColor2Defecto(){
        return color2Defecto;
    }
    
    public int getDegradadoDefecto(){
        return degradadoDefecto;
    }

    
    public int getGrosorTemporal(){
        return grosorTemporal;
    }
    
    public Color getColor1Temporal(){
        return color1Temporal;
    }
    
    public Color getColor2Temporal(){
        return color2Temporal;
    }
    
    public int getDegradadoTemporal(){
        return degradadoTemporal;
    }
    
    public int getNumLineas(){
        return numeroLineas;
    }
    
    public void nuevaLinea(int xOrigen, int XFinal, int yOrigen, int yFinal){
        numeroLineas++;
        Linea nuevaLinea = new Linea();
        
        nuevaLinea.setColor1(color1Temporal);
        nuevaLinea.setColor2(color2Temporal);
        nuevaLinea.setCoordenadaXOrigen(xOrigen);
        nuevaLinea.setCoordenadaXFinal(XFinal);
        nuevaLinea.setCoordenadaYOrigen(yOrigen);
        nuevaLinea.setCoordenadaYFinal(yFinal);
        nuevaLinea.setGrosor(grosorTemporal);
        lineas.add(nuevaLinea);
    }

    public ArrayList<Linea> getLineas() {
        return lineas;
    }
    
    public void borrarLineas(){
        lineas.clear();
        numeroLineas = 0;
    }
    
    public class Linea{
        int coordenadaXOrigen, coordenadaXFinal, coordenadaYOrigen, coordenadaYFinal, grosor;
        Color color1, color2;
        
        Linea(){
            coordenadaXOrigen = 0;
            coordenadaXFinal = 0;
            coordenadaYOrigen = 0;
            coordenadaYFinal = 0;
            grosor = 0;
            color1 = Color.WHITE;
            color2 = Color.WHITE;
        }
        
        public void setCoordenadaXOrigen(int x){
            coordenadaXOrigen = x;
        }
        
        public void setCoordenadaXFinal(int x){
            coordenadaXFinal = x;
        }
        
        public void setCoordenadaYOrigen(int y){
            coordenadaYOrigen = y;
        }
        
        public void setCoordenadaYFinal(int y){
            coordenadaYFinal = y;
        }
        
        public void setGrosor(int nuevoGrosor){
            grosor = nuevoGrosor;
        }
        
        public void setColor1(Color color){
            color1 = color;
        }
        
        public void setColor2(Color color){
            color2 = color;
        }
        
        public int getCoordenadaXOrigen(){
            return coordenadaXOrigen;
        }
        
        public int getCoordenadaXFinal(){
            return coordenadaXFinal;
        }
        
        public int getCoordenadaYOrigen(){
            return coordenadaYOrigen;
        }
        
        public int getCoordenadaYFinal(){
            return coordenadaYFinal;
        }
        
        public int getGrosor(){
            return grosor;
        }
        
        public Color getColor1(){
            return color1;
        }
        
        public Color getColor2(){
            return color2;
        }
    }
}
