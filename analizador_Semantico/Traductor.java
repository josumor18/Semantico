package analizador_Semantico;

import java.util.ArrayList;

public class Traductor {
	private String ensamblador;
	private String segVariables = "Variables Segment\n";
	
	public Traductor() {
		super();
	}
	
	public void cargarVariables(ArrayList<Simbolo> vars){
		for(Simbolo s:vars){
			if(s.getId() == Identificador.Variable){
				String tipo;
				switch(s.getTipo()){
				case "char":
					tipo = "db";
					break;
				case "int":
					tipo = "dd";
					break;
				case "long":
					tipo = "dq";
					break;
				case "short":
					tipo = "dw";
					break;
				default:
					tipo = "dq";
					break;
				}
				segVariables+= "\t" + s.getNombre() + "\t" + tipo + "\n";
			}
		}
		segVariables+= "Variables EndS";
	}
	
	
}
