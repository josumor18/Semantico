/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador_Lexico;

import java.util.ArrayList;

public class TokenImprimir {
    private Token token;
    private String lexeme;
    private ArrayList<Integer> lineas = new ArrayList<Integer>();

    public TokenImprimir(Token token, String lexeme) {
        this.token = token;
        this.lexeme = lexeme;
    }

    public TokenImprimir() {
    }

    
    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public ArrayList<Integer> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<Integer> lineas) {
        this.lineas = lineas;
    }
    
    public void addLinea(int Linea){
        lineas.add(Linea);
    }
    

}
