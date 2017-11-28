package analizador_Lexico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;

public class AnalizadorLexico {

	public AnalizadorLexico() {
		// TODO Auto-generated constructor stub
	}
        static ArrayList<java_cup.runtime.Symbol> tokensCorrectos = new ArrayList<java_cup.runtime.Symbol>();
	public static String ejecutarAnalisis(String nombre_archivo) throws IOException {
                
		//nombre_archivo = "C:/Users/Josu�/Documents/Programas Java/Analizador l�xico/archivo.c";
		File arch = new File(nombre_archivo);
                tokensCorrectos.clear();
		// para archivo con los tokens
		//FileWriter fichero = null;
		//PrintWriter pw = null;
		String resultado = "";
		try {

			//fichero = new FileWriter(nombre_archivo + " - Tokens.txt");
			//pw = new PrintWriter(fichero);
			// El archivo est� en la ra�z del proyecto...

			Reader reader = new BufferedReader(new FileReader(nombre_archivo));
			Lexer lexer = new Lexer(reader);
			ArrayList<java_cup.runtime.Symbol> tokensError = new ArrayList<java_cup.runtime.Symbol>();
			ArrayList<String> lexemeCorrecto = new ArrayList<String>();
			ArrayList<Integer> lineaCorrecto = new ArrayList<Integer>();
			ArrayList<String> lexemeError = new ArrayList<String>();
			ArrayList<Integer> lineaError = new ArrayList<Integer>();
			while (true) {
				java_cup.runtime.Symbol token = lexer.next_token();
				if (token.sym == 0) {
					break;
				}

				switch (token.sym) {                                    

				case 1:
					tokensError.add(token);
					lexemeError.add(lexer.lexeme);
					lineaError.add(lexer.linea);
					break;
				default:
                                    tokensCorrectos.add(token);
					lexemeCorrecto.add(lexer.lexeme);
					lineaCorrecto.add(lexer.linea);
                                        //System.out.println(token.sym +"   "+token.value);
					// System.out.println("TOKEN: " + token + " " + lexer.lexeme
					// + "\tLínea: " + lexer.linea);
				}
			}

			int largo_error_mas_largo = 0;
			int diferencia_largos = 0;
			String espacios_diferencia = "";
			for (String le : lexemeError) {
				if (le.length() > largo_error_mas_largo) {
					largo_error_mas_largo = le.length();
				}
			}
			/*
			pw.println("Analisis lexico del archivo " + nombre_archivo);
			java.util.Date fecha = new Date();
			pw.println("Realizado el dia y hora " + fecha);
			pw.println();
			pw.println();
			pw.println("Lista de errores encontrados: ");
			*/
			resultado = "Lista de errores lexicos encontrados: ";
			if (!tokensError.isEmpty()) {
				for (int i = 0; i < tokensError.size(); i++) {
					diferencia_largos = largo_error_mas_largo
							- lexemeError.get(i).length();
					while (diferencia_largos > 0) {
						espacios_diferencia = espacios_diferencia + " ";
						diferencia_largos--;
					}
					/*
					pw.println("TOKEN: " + tokensError.get(i) + " "
							+ lexemeError.get(i) + espacios_diferencia
							+ "\tLinea: " + lineaError.get(i));
					espacios_diferencia = "";
					*/
					resultado = resultado + "\n\tTOKEN: " + tokensError.get(i) + " "
					+ lexemeError.get(i) + espacios_diferencia
					+ "\tLinea: " + lineaError.get(i);
					espacios_diferencia = "";
				}
			} else {
				//pw.println("No hay errores");
				resultado = "No hay errores lexicos";
			}
			/*
			pw.println();
			pw.println("");
			pw.println("");
			pw.println("");
			pw.println("Lista de Tokens encontrados: ");
			pw.println();
			pw.print("Tipo de Token        ");
			*/


		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el archivo " + nombre_archivo);//e.printStackTrace();

		}
		return resultado;
	}
}
