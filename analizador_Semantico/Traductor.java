package analizador_Semantico;

import java.util.ArrayList;
import java.util.Stack;

public class Traductor {
	private String ensamblador;
	private String segVariables = "Datos Segment\n";
	private String codSegment = "Codigo Segment\n\tAssume CS:Codigo, DS:Datos\n";
	private String globales = "";
	private boolean[] regUsados = new boolean[4];
	private int tipoOp = 0;
	
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
		segVariables+= "Datos EndS";
	}
	
	public void addGlobalAsig(Stack<Registro_Semantico> tokens){
		codSegment+= "\n\n";
		String var = tokens.get(0).getValor();
		tokens.remove(0);
		tokens.remove(0);
		for(int i = 0; i < tokens.size(); i++){
			if((tokens.get(i)) instanceof RS_DO){
				if(((RS_DO)tokens.get(i)).getTipo() == RS_tipo.direccion){
					colocarVar(tokens.get(i).getValor());
				}else{
					colocarLit(tokens.get(i).getValor());
				}
			}else if((tokens.get(i)) instanceof RS_Operador){
				if(((RS_Operador)tokens.get(i)).getValor().equals("=")){
					codSegment+="\n\tmov " + var + "," + getRegUsado();
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("+")){
					
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("-")){
					
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("*")){
					
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("/")){
					
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("%")){
					
				}
			}
		}
		asigVar(var);
	}
	
	private void asigVar(String var){
		codSegment+="\n\tmov " + var + "," + getRegUsado(); 
	}
	
	private void colocarVar(String var){
		String regVacio = getRegistroLibre();
		codSegment+= "\n\tmov " + regVacio + "," + var;
	}
	
	private void colocarLit(String var){
		String regVacio = getRegistroLibre();
		codSegment+= "\n\tmov " + regVacio + "," + var;
	}
	
	private String getRegistroLibre(){
		if(!regUsados[0]){
			regUsados[0] = true;
			return "ax";
		}else if(!regUsados[1]){
			regUsados[1] = true;
			return "bx";
		}else if(!regUsados[2]){
			regUsados[2] = true;
			return "cx";
		}
		regUsados[3] = true;
		return "dx";
	}
	
	private String getRegUsado(){
		if(regUsados[0]){
			regUsados[0] = false;
			return "ax";
		}else if(regUsados[1]){
			regUsados[1] = false;
			return "bx";
		}else if(regUsados[2]){
			regUsados[2] = false;
			return "cx";
		}
		regUsados[3] = false;
		return "dx";
	}
	
	private void liberarRegistro(int r){
		regUsados[r] = false;
	}
}
