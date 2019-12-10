/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto23;

import java.util.ArrayList;
import javafx.application.Platform;

/**
 *
 * @author marti
 */
public class color implements Runnable {
    ArrayList<String> datos;
    FXMLDocumentController fx = new FXMLDocumentController();
    int j=0;
    public color(ArrayList<String> datos) {
    this.datos = datos;
    }
    protected void color() {
        Platform.runLater(() -> {
            System.err.println("hola");
            if(datos.get(j).equals("q0")||datos.get(j).equals("q1")){
                fx.q0.setFill(javafx.scene.paint.Color.RED);
                j++;
            }
        });
    }
        protected void color2() {
        Platform.runLater(() -> {
            if(datos.get(j).equals("q0")||datos.get(j).equals("q1")){
                fx.q0.setFill(javafx.scene.paint.Color.BLUE);
            j++;
            }
        });
    }
    @Override
    public void run() {
                    try {
                color();
                Thread.sleep(50);
                color2();
                    }
            catch(InterruptedException e) {
                System.out.println("interrupt");
            }
    }
    
}
