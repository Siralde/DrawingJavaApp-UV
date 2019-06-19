package es.uv.eu.dibujadorLineasRectas.view;

import es.uv.eu.dibujadorLineasRectas.view.sketcherView.OptionPanel;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class SelectPanel extends JPanel{
    
    private OptionPanel optionPanel;
    private DegradadoPanel degradadoPanel;
    private ColorPanel colorPanel1;
    private ColorPanel colorPanel2;
    
    public SelectPanel(boolean showOptionPanel){
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        this.setBorder(border);
        
        degradadoPanel = new DegradadoPanel();
        optionPanel = new OptionPanel();
        colorPanel1 = new ColorPanel("Color 1:", 0);
        colorPanel2 = new ColorPanel("Color 2:", 13);
    
        add(degradadoPanel);
        if(showOptionPanel == true)
        {
            add(optionPanel);
        }
        add(colorPanel1);
        add(colorPanel2);      
        showDegradado();
    }

    public void showDegradado(){
        colorPanel2.setVisible(true);
        colorPanel1.setText("Color 1:");
        degradadoPanel.showDegradado();
    }
    
    public void showNoDegradado(){
        colorPanel2.setVisible(false);
        colorPanel1.setText("Color:");
        degradadoPanel.showNoDegradado();
    }
    
    public void setMyActionListener(ActionListener myActionListener) {
        degradadoPanel.setMyActionListener(myActionListener);
        optionPanel.setMyActionListener(myActionListener);
        colorPanel1.setMyActionListener(myActionListener);
        colorPanel2.setMyActionListener(myActionListener);
    }
}
