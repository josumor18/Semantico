package analizador_Sintactico;

import java.util.ArrayList;

public class Traductor {
	private String ensamblador;
	private String segVariables = "Variables Segment\n";
	
	public Traductor() {
		super();
	}
	
	public void cargarVariables(ArrayList<String> vars){
		for(String s:vars){
			segVariables+= "\t" + s + "\n";
		}
	}
	
}
