package analizador_Semantico;

import java.util.ArrayList;
import java.util.Stack;

public class Traductor {
	private String ensamblador;
	private String segVariables = ".data\n";
	private String codSegment = "\n\n.code\n\t\n";
	private String local = "";
	private String globales = "";
	private boolean[] regUsados = new boolean[2];
	private Stack<String> funciones = new Stack<String>();
	
	public Traductor() {
		super();
	}
	
	public void clear(){
		ensamblador = "";
		segVariables = ".data\n";
		codSegment = "\n\n.code\n\t\n";
		local = "";
		globales = "";
		regUsados = new boolean[2];
		funciones = new Stack<String>();
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
			}else{
				cargarVariables(s.getTablaG());
			}
		}
	}
	
	public void addGlobalAsig(Stack<Registro_Semantico> tokens){
		codSegment+= "\n";
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
					colocarVar(tokens.get(i+1).getValor());
					tokens.remove(i+1);
					//codSegment+="\n\tadd " + getRegUsado() + ",";
					//codSegment+= getRegUsado();
					codSegment+="\n\tadd ax,bx";
					liberarRegistro("ax");
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("-")){
					colocarVar(tokens.get(i+1).getValor());
					tokens.remove(i+1);
					//codSegment+="\n\tsub " + getRegUsado() + ",";
					//codSegment+= getRegUsado();
					codSegment+="\n\tsub ax,bx";
					liberarRegistro("ax");
					getRegistroLibre();
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("*")){
					colocarVar(tokens.get(i+1).getValor());
					tokens.remove(i+1);
					//codSegment+="\n\tmul " + getRegUsado() + ",";
					//codSegment+= getRegUsado();
					codSegment+="\n\tmul ax,bx";
					liberarRegistro("ax");
					getRegistroLibre();
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("/")){
					colocarVar(tokens.get(i+1).getValor());
					tokens.remove(i+1);
					//codSegment+="\n\tdiv " + getRegUsado() + ",";
					//codSegment+= getRegUsado();
					codSegment+="\n\tdiv ax,bx";
					liberarRegistro("ax");
					getRegistroLibre();
				}
			}
		}
		asigVar(var);
	}
	
	public void addLocalAsig(Stack<Registro_Semantico> tokens){
		local+= "\n";
		String var = tokens.get(0).getValor();
		tokens.remove(0);
		tokens.remove(0);
		for(int i = 0; i < tokens.size(); i++){
			if((tokens.get(i)) instanceof RS_DO){
				if(((RS_DO)tokens.get(i)).getTipo() == RS_tipo.direccion){
					colocarVarL(tokens.get(i).getValor());
				}else{
					colocarLitL(tokens.get(i).getValor());
				}
			}else if((tokens.get(i)) instanceof RS_Operador){
				if(((RS_Operador)tokens.get(i)).getValor().equals("=")){
					local+="\n\t\tmov " + var + "," + getRegUsado();
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("++")){
					colocarVar(tokens.get(i+1).getValor());
					//codSegment+="\n\tadd " + getRegUsado() + ",";
					//codSegment+= getRegUsado();
					local+="\n\t\tinc ax";
					local+="\n\t\tmov " + tokens.get(i+1).getValor() + ",ax";
					tokens.remove(i+1);
					liberarRegistro("ax");
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("--")){
					colocarVar(tokens.get(i+1).getValor());
					//codSegment+="\n\tadd " + getRegUsado() + ",";
					//codSegment+= getRegUsado();
					local+="\n\t\tdec ax";
					local+="\n\t\tmov " + tokens.get(i+1).getValor() + ",ax";
					tokens.remove(i+1);
					liberarRegistro("ax");
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("+")){
					colocarVarL(tokens.get(i+1).getValor());
					tokens.remove(i+1);
					//local+="\n\tadd " + getRegUsado() + ",";
					//local+= getRegUsado();
					local+="\n\t\tadd ax,bx";
					liberarRegistro("ax");
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("-")){
					colocarVarL(tokens.get(i+1).getValor());
					tokens.remove(i+1);
					//local+="\n\tsub " + getRegUsado() + ",";
					//local+= getRegUsado();
					local+="\n\t\tsub ax,bx";
					liberarRegistro("ax");
					getRegistroLibre();
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("*")){
					colocarVarL(tokens.get(i+1).getValor());
					tokens.remove(i+1);
					//local+="\n\tmul " + getRegUsado() + ",";
					//local+= getRegUsado();
					local+="\n\t\tmul ax,bx";
					liberarRegistro("ax");
					getRegistroLibre();
				}else if(((RS_Operador)tokens.get(i)).getValor().equals("/")){
					colocarVarL(tokens.get(i+1).getValor());
					tokens.remove(i+1);
					//local+="\n\tdiv " + getRegUsado() + ",";
					//local+= getRegUsado();
					local+="\n\t\tdiv ax,bx";
					liberarRegistro("ax");
					getRegistroLibre();
				}
			}
		}
		asigVarL(var);
	}
	
	public void tradFunciones(String idFunc){
		funciones.push(idFunc);
		codSegment+="\n\n\t" + idFunc + " Proc\n" + local;
	}
	
	private void asigVar(String var){
		codSegment+="\n\tmov " + var + ",ax";// + 
		getRegUsado(); 
	}
	
	private void colocarVar(String var){
		String regVacio = getRegistroLibre();
		codSegment+= "\n\tmov " + regVacio + "," + var;
	}
	
	private void colocarLit(String var){
		String regVacio = getRegistroLibre();
		codSegment+= "\n\tmov " + regVacio + "," + var;
	}
	
	private void asigVarL(String var){
		local+="\n\t\tmov " + var + ",ax";// + 
		getRegUsado(); 
	}
	
	private void colocarVarL(String var){
		String regVacio = getRegistroLibre();
		local+= "\n\t\tmov " + regVacio + "," + var;
	}
	
	private void colocarLitL(String var){
		String regVacio = getRegistroLibre();
		local+= "\n\t\tmov " + regVacio + "," + var;
	}
	
	private String getRegistroLibre(){
		if(!regUsados[0]){
			regUsados[0] = true;
			return "ax";
		}else if(!regUsados[1]){
			regUsados[1] = true;
			return "bx";
		}/*else if(!regUsados[2]){
			regUsados[2] = true;
			return "cx";
		}*/
		regUsados[1] = true;
		return "bx";
	}
	
	private String getRegUsado(){
		if(regUsados[0]){
			regUsados[0] = false;
			return "ax";
		}else if(regUsados[1]){
			regUsados[1] = false;
			return "bx";
		}/*else if(regUsados[2]){
			regUsados[2] = false;
			return "cx";
		}*/
		regUsados[1] = false;
		return "bx";
	}
	
	private void liberarRegistro(int r){
		regUsados[r] = false;
	}
	
	private void liberarRegistro(String r){
		if(r.equals("ax")){
			regUsados[0] = true;
		}else if(r.equals("bx")){
			regUsados[1] = true;
		}else if(r.equals("cx")){
			regUsados[2] = true;
		}else if(r.equals("ax")){
			regUsados[3] = true;
		}
	}
	
	public String getEnsamblador(){
		ensamblador = segVariables + codSegment;
		return ensamblador;
	}
}
