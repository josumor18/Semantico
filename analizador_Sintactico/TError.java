
package analizador_Sintactico;


public class TError {
    String lexema,tipo,descripcion;
    int linea,columna;
    
    public TError(String le, int li, int co, String t,String de){
        lexema = le;
        linea = li;
        columna = co;
        tipo = t;
        descripcion = de;
    }
    
}
