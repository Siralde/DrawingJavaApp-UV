package es.uv.eu.dibujadorLineasRectas.app;

import es.uv.eu.dibujadorLineasRectas.controller.DibujadorController;
import es.uv.eu.dibujadorLineasRectas.model.DibujadorModel;
import es.uv.eu.dibujadorLineasRectas.view.DibujadorView;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author diaz
 */
public class Dibujador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();     
        DibujadorModel model = new DibujadorModel();
        DibujadorView view = new DibujadorView(screenSize.width, screenSize.height, model);
        DibujadorController controlador = new DibujadorController(view, model);
    }
}
