/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador_Lexico;


import analizador_Semantico.Semantico;
import analizador_Sintactico.Sintactico;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


/**
 *
 * @author Diego Armando
 */
public class PruebaMain {
    
        public static void main(String[] args) throws FileNotFoundException, IOException
    {
         String a = AnalizadorLexico.ejecutarAnalisis("C:\\Users\\Diego Armando\\Documents\\U\\segundo semestre 2017\\Compiladores e Interpretes\\progra 3 - Semantico\\prueba1.c");
            
        Lexer lexico = new Lexer(new BufferedReader(new FileReader("C:\\Users\\Diego Armando\\Documents\\U\\segundo semestre 2017\\Compiladores e Interpretes\\progra 3 - Semantico\\prueba1.c")));
         Sintactico sintactico = new Sintactico(lexico);
         System.out.println("- " + a);
	a+= "\n\n----------------------------------------------------------------------";
	System.out.println("\n----------------------------------------------------------------------");
        a+= "\nRESULTADO ANALISIS SINTACTICO\n";
	System.out.println("RESULTADO ANALISIS SINTACTICO\n");
	a+= "\n- Lista de errores sintacticos encontrados:";
	System.out.println("- Lista de errores sintacticos encontrados:");
	a+= "\nRESULTADO ANALISIS SINTACTICO\n";
	System.out.println("RESULTADO ANALISIS SINTACTICO\n");
	a+= "\n- Lista de errores sintacticos encontrados:";
	System.out.println("- Lista de errores sintacticos encontrados:");
	try {
             Semantico.getInstance().prepararAnalisis();
	     sintactico.parse();
	     a+= sintactico.resultado;
	     System.out.println(sintactico.resultado);
	     System.out.println("\n____________________________________________________________________________________________________________________________________________\n");
             
	} catch (Exception e) {
	}
        Semantico.getInstance().printTablaSimbolos();
        System.out.println("\n\n\n");
        Semantico.getInstance().printPilaSemantica();
    } 
}
