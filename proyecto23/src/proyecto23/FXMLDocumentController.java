/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto23;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.shape.Circle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 *
 * @author marti
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button analizar;

    @FXML
    private TextArea cadena;
    @FXML
    public Circle q0;
    @FXML
    public Circle q1;
    @FXML
    public Circle q2;
    @FXML
    public Circle q3;
    @FXML
    public Circle q4;
    @FXML
    public Circle q5;
    @FXML
    public Circle q6;
    @FXML
    public Circle q7;
    @FXML
    public Circle q8;
    @FXML
    public Circle q9;
    @FXML
    public Circle q10;
    @FXML
    public Circle q11;
    @FXML
    public Circle q12;
    @FXML
    public Circle q13;
    @FXML
    public Circle q14;
    @FXML
    public Circle q15;
    @FXML
    public Circle q16;
    @FXML
    public Circle q17;
    @FXML
    public Circle q18;
    @FXML
    public Circle q19;
    @FXML
    public Circle q20;
    @FXML
    public Circle q21;
    @FXML
    public Circle q22;
    @FXML
    public Circle q23;
    @FXML
    public Circle q24;
    @FXML
    public Circle q25;
    @FXML
    public Circle q26;
    @FXML
    public Circle q27;
    @FXML
    public Circle q28;
    @FXML
    public Circle q29;
    @FXML
    public Circle q30;
    @FXML
    public Circle q31;
    @FXML
    public Circle q33;
    @FXML
    public Circle q34;
    @FXML
    public Circle q35;

    @FXML
    private AnchorPane panel;

    ArrayList<Circle> cadena2;
    ArrayList<FillTransition> arrtrans;
    ArrayList<String> arrError;
    ArrayList<String> arrLexema;
    ArrayList<String> arrToken;
    FillTransition fl;
    FillTransition f2;
    int indice;
    int estado;
    String lexema;
    String nombre;

    @FXML
    private void jButton1ActionPerformed(ActionEvent event) throws InterruptedException {
        analizar();
        try {
            colores();
        } catch (Exception e) {
            q0.setFill(Color.BLUE);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        inicializar();

    }

    private void inicializar() {
        indice = 0;
        estado = 0;
        lexema = "";
        nombre = "";
        cadena2 = new ArrayList<>();
        arrError = new ArrayList<>();
        arrLexema = new ArrayList<>();
        arrToken = new ArrayList<>();
        arrtrans = new ArrayList<>();
        fl = new FillTransition();

    }

    public void analizar() throws InterruptedException {
        String todoTexto = cadena.getText() + "";
        String textoLinpio = "";
        for (int i = 0; i < todoTexto.length(); i++) {
            char letra = todoTexto.charAt(i);
            switch (letra) {
                case '\r':
                case '\t':
                case '\n':
                case '\b':
                case '\f':
                    break;
                default:
                    textoLinpio = textoLinpio + letra;
            }

        }
        System.err.println(textoLinpio);
        for (indice = 0; indice < textoLinpio.length(); indice++) {
            char letra = textoLinpio.charAt(indice);
            int codigoascii = letra;
            switch (estado) {
                case 0:
                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 1;
                        lexema = "" + letra;
                    } else if (letra == ' ') {
                        estado = 2;
                        cadena2.add(q2);

                    } else {
                        System.err.println("error lexema " + lexema);
                        estado = 0;
                        arrError.add(lexema);
                    }
                    break;
                case 1:
                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 1;
                        lexema = lexema + letra;
                    } else {
                        if (lexema.equals("int") || lexema.equals("String")
                                || lexema.equals("double") || lexema.equals("float")
                                || lexema.equals("char")) {
                            arrLexema.add(lexema);
                            lexema = "";
                            estado = 0;
                            indice--;
                            arrToken.add("q1");
                            cadena2.add(q1);

                        } else if (lexema.equals("void")) {
                            arrLexema.add(lexema);
                            lexema = "";
                            estado = 16;
                            indice--;
                            cadena2.add(q22);

                        } else {
                            arrError.add(lexema + " no es una palabra valida \n");
                            lexema = "";
                            estado = 27;
                        }
                    }
                    break;
                case 2:
                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 2;
                        lexema = "" + letra;
                        nombre = nombre + letra;
                        arrLexema.add(lexema);
                        arrToken.add("q1");
                        cadena2.add(q3);

                    } else {
                        if (nombre.equals("int") || nombre.equals("String")
                                || nombre.equals("double") || lexema.equals("char")
                                || nombre.equals("float") || nombre.equals("void")) {
                            arrError.add("no puedes poner una palabra reservada de nombre ");
                            lexema = "";
                            estado = 27;
                            indice--;
                        } else {
                            indice--;
                            estado = 3;
                        }
                    }
                    break;

                case 3:
                    if (codigoascii == 40) {
                        estado = 4;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        lexema = "";
                        cadena2.add(q4);

                    } else {
                        lexema = lexema + letra;
                        arrError.add(lexema);
                        lexema = "";
                        estado = 27;
                    }
                    break;
                case 4:

                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 4;
                        lexema = lexema + letra;
                    } else {
                        if (lexema.equals("int") || lexema.equals("String")
                                || lexema.equals("double") || lexema.equals("float") || lexema.equals("char")) {
                            arrLexema.add(lexema);
                            lexema = "";
                            estado = 5;
                            indice--;
                            cadena2.add(q6);
                        } else if (arrLexema.get(arrLexema.size() - 1).equals(",")) {
                            arrError.add(lexema);
                            lexema = "";
                            estado = 0;
                        } else if (lexema.equals("")) {
                            arrLexema.add(lexema);
                            lexema = "";
                            estado = 7;
                            indice--;
                        } else {
                            arrError.add(lexema);
                            lexema = "";
                            estado = 27;
                        }
                    }
                    break;
                case 5:
                    if (letra == ' ') {
                        estado = 6;
                        cadena2.add(q7);
                    }
                    break;
                case 6:
                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 6;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        cadena2.add(q8);
                    } else if (codigoascii == 44) {
                        estado = 7;
                        indice--;

                    } else if (codigoascii == 41) {
                        estado = 7;
                        indice--;

                    } else {
                        lexema = "";
                        estado = 0;
                    }
                    break;
                case 7:
                    if (codigoascii == 44) {
                        estado = 4;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        cadena2.add(q9);
                        lexema = "";

                    } else if (codigoascii == 41) {
                        estado = 8;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        cadena2.add(q5);
                        lexema = "";
                    } else {
                        lexema = lexema + letra;
                        arrError.add(lexema);
                        estado = 27;
                    }
                    break;
                case 8:
                    if (codigoascii == 123) {
                        estado = 9;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        lexema = "";
                        cadena2.add(q10);

                    } else {
                        lexema = lexema + letra;
                        arrError.add(lexema);
                        estado = 27;
                    }
                    break;
                case 9:
                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 9;
                        lexema = lexema + letra;
                    } else {
                        if (lexema.equals("instrucciones")) {
                            estado = 10;
                            arrLexema.add(lexema);
                            lexema = "";
                            indice--;
                            cadena2.add(q11);
                        } else if (lexema.equals("return")) {
                            arrLexema.add(lexema);
                            lexema = "";
                            estado = 12;
                            indice--;
                            cadena2.add(q18);
                        } else {
                            arrError.add("no tiene return");
                            estado = 27;
                        }
                    }
                    break;
                case 10:
                    if (codigoascii == 59) {
                        estado = 11;
                        arrLexema.add(lexema);
                        cadena2.add(q12);
                    } else {
                        lexema = lexema + letra;
                        arrError.add("le falta punto y coma ");
                        estado = 27;
                    }
                    break;
                case 11:
                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 11;
                        lexema = lexema + letra;
                    } else {
                        if (lexema.equals("return")) {
                            arrLexema.add(lexema);
                            lexema = "";
                            indice--;
                            estado = 12;
                            cadena2.add(q13);
                        } else {
                            arrError.add("no tiene return");
                            estado = 27;
                        }
                    }
                    break;
                case 12:
                    if (letra == ' ') {
                        estado = 13;
                        cadena2.add(q14);
                    } else {
                        lexema = lexema + letra;
                        arrError.add("le falta un espacio ");
                        estado = 27;
                    }
                    break;
                case 13:
                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 13;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        cadena2.add(q15);
                    } else {
                        if (lexema == null) {
                            estado = 0;
                            arrError.add("el return no puede estar vacio ");
                        }
                        estado = 14;
                        lexema = "";
                        indice--;
                    }

                    break;
                case 14:
                    if (codigoascii == 59) {
                        estado = 15;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        cadena2.add(q16);
                    } else {
                        lexema = lexema + letra;
                        arrError.add("le falta punto y coma ");
                        estado = 27;

                    }
                    break;
                case 15:
                    if (codigoascii == 125) {
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        lexema = "";
                        cadena2.add(q17);
                    } else {
                        lexema = letra + "";
                        arrError.add(lexema);
                    }
                    break;
                case 16:
                    if (letra == ' ') {
                        estado = 17;
                        cadena2.add(q23);

                    }
                    break;
                case 17:
                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 17;
                        lexema = "" + letra;
                        nombre = nombre + letra;
                        arrLexema.add(lexema);
                        cadena2.add(q24);
                    } else {
                        if (nombre.equals("int") || nombre.equals("String")
                                || nombre.equals("double") || lexema.equals("char")
                                || nombre.equals("float") || nombre.equals("void")) {
                            arrError.add("no puedes poner una palabra reservada de nombre ");
                            lexema = "";
                            estado = 27;
                        } else {
                            indice--;
                            estado = 18;
                        }
                    }
                    break;

                case 18:
                    if (codigoascii == 40) {
                        estado = 19;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        lexema = "";
                        cadena2.add(q25);

                    } else {
                        lexema = lexema + letra;
                        arrError.add(lexema);
                        lexema = "";
                        estado = 27;
                    }
                    break;
                case 19:
                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 19;
                        lexema = lexema + letra;
                    } else {
                        if (lexema.equals("int") || lexema.equals("String")
                                || lexema.equals("double") || lexema.equals("float")
                                || lexema.equals("char")) {
                            arrLexema.add(lexema);
                            lexema = "";
                            estado = 20;
                            indice--;
                            cadena2.add(q27);

                        } else if (arrLexema.get(arrLexema.size() - 1).equals(",")) {
                            arrError.add(lexema);
                            lexema = "";
                            estado = 0;
                        } else if (lexema.equals("")) {
                            arrLexema.add(lexema);
                            lexema = "";
                            estado = 22;
                            indice--;
                        } else {
                            arrError.add(lexema);
                            lexema = "";
                            estado = 27;
                        }
                    }
                    break;
                case 20:
                    if (letra == ' ') {
                        estado = 21;
                        cadena2.add(q28);

                    }
                    break;
                case 21:
                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 21;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        cadena2.add(q29);

                    } else if (codigoascii == 44) {
                        estado = 22;
                        indice--;

                    } else if (codigoascii == 41) {
                        estado = 22;
                        indice--;
                    } else {
                        lexema = "";
                        estado = 0;
                    }
                    break;
                case 22:
                    if (codigoascii == 44) {
                        estado = 19;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        lexema = "";
                        cadena2.add(q30);

                    } else if (codigoascii == 41) {
                        estado = 23;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        lexema = "";
                        cadena2.add(q26);
                    } else {
                        lexema = lexema + letra;
                        arrError.add(lexema);
                        estado = 27;
                    }
                    break;
                case 23:
                    if (codigoascii == 123) {
                        estado = 24;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        lexema = "";
                        cadena2.add(q31);

                    } else {
                        lexema = lexema + letra;
                        arrError.add(lexema);
                        estado = 27;
                    }
                    break;
                case 24:
                    if ((codigoascii >= 65 && codigoascii <= 90)
                            || (codigoascii >= 97 && codigoascii <= 122)) {
                        estado = 24;
                        lexema = lexema + letra;
                    } else {
                        if (lexema.equals("instrucciones")) {
                            estado = 25;
                            arrLexema.add(lexema);
                            lexema = "";
                            indice--;
                            cadena2.add(q33);
                        } else {
                            arrError.add("no tiene instrucciones");
                            estado = 27;
                        }
                    }
                    break;
                case 25:
                    if (codigoascii == 59) {
                        estado = 26;
                        arrLexema.add(lexema);
                        cadena2.add(q34);
                    } else {
                        lexema = lexema + letra;
                        arrError.add("le falta punto y coma ");
                        estado = 27;
                    }
                    break;
                case 26:
                    if (codigoascii == 125) {
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                        lexema = "";
                        cadena2.add(q35);
                    } else {
                        lexema = letra + "";
                        arrError.add(lexema);
                        estado = 27;
                    }
                    break;
                case 27:
                    estado = 27;
                    break;
            }

        }
        if (arrLexema.isEmpty()) {
            System.out.println("cadena invalida");
        } else {
            if (arrLexema.get(arrLexema.size() - 1).equals("}")) {
            } else {
                System.out.println("le falta cerrar");
                arrError.add("le falta cerrar");
            }
            if (!arrError.isEmpty()) {
                System.out.println("cadena incorrecta");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error");
                alert.setHeaderText("cadena incorrecta");
                alert.showAndWait();
                lexico();
                error();
            } else {
                System.out.println("cadena correcta");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("lo lograste :)");
                alert.setHeaderText("cadena correcta");
                alert.showAndWait();
                lexico();
                error();
            }
        }
        todoTexto = "";
        textoLinpio = "";
        estado = 0;
        nombre = "";
        arrLexema.clear();
        arrError.clear();
        color();
    }

    int j = 0;

    public void color() {
        try {

            SequentialTransition sq = new SequentialTransition();
            for (Circle cadena21 : cadena2) {
                FillTransition f2 = new FillTransition(javafx.util.Duration.seconds(1), cadena21, Color.BLUE, Color.RED);
                sq.getChildren().add(f2);
            }
            sq.play();
            arrToken.clear();

            cadena2.clear();

        } catch (Exception E) {

        }

    }

    private void lexico() {
        System.out.println(arrLexema);
        System.out.println(arrToken);

    }

    public void colores() {
        q0.setFill(Color.BLUE);
        q1.setFill(Color.BLUE);
        q2.setFill(Color.BLUE);
        q3.setFill(Color.BLUE);
        q4.setFill(Color.BLUE);
        q5.setFill(Color.BLUE);
        q6.setFill(Color.BLUE);
        q7.setFill(Color.BLUE);
        q8.setFill(Color.BLUE);
        q9.setFill(Color.BLUE);
        q10.setFill(Color.BLUE);
        q11.setFill(Color.BLUE);
        q12.setFill(Color.BLUE);
        q13.setFill(Color.BLUE);
        q14.setFill(Color.BLUE);
        q15.setFill(Color.BLUE);
        q16.setFill(Color.BLUE);
        q17.setFill(Color.BLUE);
        q18.setFill(Color.BLUE);
        q22.setFill(Color.BLUE);
        q23.setFill(Color.BLUE);
        q24.setFill(Color.BLUE);
        q25.setFill(Color.BLUE);
        q26.setFill(Color.BLUE);
        q27.setFill(Color.BLUE);
        q28.setFill(Color.BLUE);
        q29.setFill(Color.BLUE);
        q30.setFill(Color.BLUE);
        q31.setFill(Color.BLUE);
        q33.setFill(Color.BLUE);
        q34.setFill(Color.BLUE);
        q35.setFill(Color.BLUE);
    }

    private void error() {
        System.out.println(arrError);
    }

}
