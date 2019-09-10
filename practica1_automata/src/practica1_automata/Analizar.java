/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_automata;

import java.util.ArrayList;

/**
 *
 * @author marti
 */
public class Analizar {
    private ArrayList<String> arrError;
    private ArrayList<String> arrLexema;
    private ArrayList<String> arrToken;
    
    private int indice;
    private int estado;
    private String lexema;
    private String dato;
    private String finalText = "";
    int pos = 0;
    
    public Analizar(String dato) {
        indice = 0;
        estado = 0;
        lexema = "";
        arrError = new ArrayList<>();
        arrLexema = new ArrayList<>();
        arrToken = new ArrayList<>();
        this.dato = dato;
    }
    
    public void analizar(){
        String todoTexto = dato;
        String textoLimpio = "";
    
        for (int i = 0; i < todoTexto.length(); i++) {
            char letra = todoTexto.charAt(i);
            switch(letra){
                case '\r':
                case '\t':
                case '\n':
                case '\b':
                case '\f':
                    break;
                default:
                    textoLimpio = textoLimpio + letra;
            }  
        }
        
        for(indice = 0; indice < textoLimpio.length(); indice++) {
            char letra = textoLimpio.charAt(indice);
            int codigoascii = letra;
            switch(estado) {
                case 0:
                    if(codigoascii == 43 || codigoascii == 45) {
                        estado = 1;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                    }else if(codigoascii >= 48 && codigoascii <= 57) {
                        estado = 0;
                        lexema = "" + letra;
                        arrLexema.add(lexema);
                    }
                    else {
                        System.err.println("error lexema " + lexema);
                        estado = 0;
                        lexema = ""+ letra;
                        arrError.add(lexema);
                    }
                break;
            case 1:
                if(codigoascii >= 48 && codigoascii <= 57) {
                    estado = 1;
                    lexema = "" + letra;
                    arrLexema.add(lexema);
                }else{
                    if(codigoascii == 46){
                        estado = 3;
                        indice --;   
                    }else{
                        arrError.add(String.valueOf(letra));
                    }
                }
             break;
             case 2:
                 if(codigoascii >= 48 && codigoascii <= 57) {
                    estado = 2;
                    lexema = "" + letra;
                    arrLexema.add(lexema);
                 }else {
                    if (arrLexema.get(indice-1).equals(".")) {
                        arrError.add(String.valueOf(letra));
                    }else {
                        arrLexema.add(lexema);
                        lexema = "";
                        estado = 0;
                    }
                 }
             break;
             case 3:
                 if (textoLimpio.endsWith(".")) {
                    arrError.add(String.valueOf(letra));
                 }
                 else if(codigoascii == 46){
                    estado = 4;
                    lexema = "" + letra;
                    arrLexema.add(lexema);
                 }
             break;
             case 4:
                if(codigoascii >= 48 && codigoascii <= 57) {
                    estado = 4;
                    lexema = "" + letra;
                    arrLexema.add(lexema);
                }else {
                    arrError.add(lexema);
                    estado = 4;
                }  
            break;
             case 5:
                if(codigoascii>=348 && codigoascii >=57) {
                    estado = 4;
                    lexema = lexema + letra;
                }else{
                    arrLexema.add(lexema);
                    lexema = "";
                }
            break;
            }
        }
        System.out.println("Carateres correctos: " + arrLexema);
        System.out.println("Caracteres errones:" + arrError);
        if(!arrError.isEmpty()){
            System.out.println("la cadena es incorrecta");
        }else{
            System.out.println("la cadena es correcta");
        }
    }   
}
