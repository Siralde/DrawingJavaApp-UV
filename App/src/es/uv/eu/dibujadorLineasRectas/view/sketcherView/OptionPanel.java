package es.uv.eu.dibujadorLineasRectas.view.sketcherView;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class OptionPanel extends JPanel{
    
    private JButton restablecer;
    private JButton borrarTodo;
    
    public OptionPanel(){
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        this.setBorder(border);
        restablecer = new JButton("Restablecer por Defecto");
        borrarTodo = new JButton("Borrar Lineas");
        
        restablecer.setBackground(Color.green);
        restablecer.setOpaque(true);
        restablecer.setBorderPainted(false);
        borrarTodo.setBackground(Color.red);
        borrarTodo.setOpaque(true);
        borrarTodo.setBorderPainted(false);
        add(restablecer);
        add(borrarTodo);
    }
    
    public void setMyActionListener(ActionListener myActionListener){
        restablecer.addActionListener(myActionListener);
        borrarTodo.addActionListener(myActionListener);
    }
}
