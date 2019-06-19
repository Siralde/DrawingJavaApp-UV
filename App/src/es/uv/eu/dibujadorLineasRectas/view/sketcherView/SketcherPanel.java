package es.uv.eu.dibujadorLineasRectas.view.sketcherView;

import es.uv.eu.dibujadorLineasRectas.model.DibujadorModel;
import es.uv.eu.dibujadorLineasRectas.model.DibujadorModel.Linea;
import java.awt.BasicStroke;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class SketcherPanel extends JPanel {
    
    private DibujadorModel model;
    private int xOrigen, xFinal, yOrigen, yFinal, contadorClicks;
    private GradientPaint gradient;
   
    public SketcherPanel(DibujadorModel modelo){
        contadorClicks = 0;
        this.model = modelo;
        this.setBackground(Color.white);
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
       
        ArrayList<Linea> lineas = model.getLineas();
       
        for (Linea linea :lineas) 
        {
            this.gradient = new GradientPaint(0,0,linea.getColor1(), 175, 175, linea.getColor2(),true);
            g2d.setPaint(gradient);
            g2d.setStroke(new BasicStroke(linea.getGrosor()));
            g2d.draw(new Line2D.Double(linea.getCoordenadaXOrigen(), linea.getCoordenadaYOrigen(), linea.getCoordenadaXFinal(), linea.getCoordenadaYFinal()));
        }
        
    }

    public void setMyMouseListener(MouseListener myMouseListener) {
        this.addMouseListener(myMouseListener);
    }

    public Boolean pintarLinea(int x, int y) {
        contadorClicks = contadorClicks + 1;
        if((contadorClicks % 2) == 0)
        {
            xFinal = x;
            yFinal = y;
            System.out.println("XFinal: " + xFinal+ ", YFinal: " + yFinal);

                model.nuevaLinea(xOrigen, xFinal, yOrigen, yFinal);
         
            this.repaint(); 
            return true;
        }
        else
        {
            xOrigen = x;
            yOrigen = y;
            System.out.println("XOrigen: " + xOrigen+ ", YOrigen: " + yOrigen);
            return false;
        } 
    }
}
