package es.uv.eu.dibujadorLineasRectas.view.AuthorView;

import es.uv.eu.dibujadorLineasRectas.model.DibujadorModel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class AuthorView extends JFrame{
    
    private DibujadorModel model;
    private JMenuBar menu;
    private final String nombreAutor = " Creador: Aldemaro Gonzalez";
    private PanelAuthor panelAuthor;
     
    public AuthorView (JMenuBar menu, int altura, int ancho, DibujadorModel modelo){
        this.model = modelo;
        this.menu = menu;
        this.setSize(altura, ancho);
        this.setLayout(new BorderLayout());
        this.setJMenuBar(menu);
        
        panelAuthor = new PanelAuthor();
        
        this.add(panelAuthor, BorderLayout.CENTER);
    }
    
    private class PanelAuthor extends JPanel{
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            Font font = new Font("Courier", Font.BOLD, 72);
            g.setFont(font);
            g.drawString(nombreAutor, 50, 100);
        }
    }
}
