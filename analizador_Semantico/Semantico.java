package analizador_Semantico;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.Stack;


public class Semantico {

	private ArrayList<Simbolo> tablaG = new ArrayList<Simbolo>();
	private ArrayList<String> errores = new ArrayList<String>();
	Stack<Registro_Semantico> pilaSemantica = new Stack<Registro_Semantico>();
        
	public static Semantico _Instancia;
	
	public static Semantico getInstance(){   // singleton xD
		if (_Instancia == null){
			_Instancia = new Semantico();
		}
		return _Instancia;
	}
	
	private Semantico(){
		
	}
	
	public void prepararAnalisis(){
		tablaG.clear();
		errores.clear();
	}
	
	public void addSimbolo(Simbolo new_Simbolo, int linea){
		Boolean existe = false;
		for(Simbolo s:tablaG){
			if(s.getNombre().equals(new_Simbolo.getNombre())){
				if(s.getTipo().equals(new_Simbolo.getTipo())){
					if(s.getValor().equals("") && !new_Simbolo.getValor().equals("")){
						s.setValor(new_Simbolo.getValor());
					}
				}else{
					System.out.println("Error. Se redefine una variable con diferente ripo. Linea: " + linea);
					errores.add("Error. Se redefine una variable con diferente ripo. Linea: " + linea);
				}
				existe = true;
			}
		}
		if(!existe){
			tablaG.add(new_Simbolo);
		}
		
	}
	
	public void addTablaToSimbolo(ArrayList<Simbolo> tablaFuncion){
		for(Simbolo s:tablaFuncion){
			tablaG.get(tablaG.size()-1).addSimboloToTabla(s);
		}
	}
    /*
    public static void printTablaG(){        
        for(Simbolo s: tablaG){
            System.out.println(s.getId() +" " + s.getNombre() + " " + s.getTipo());
        }
    }
    */
    public boolean verificarLocal(Simbolo sim, ArrayList<Simbolo> tLocales){
		for(Simbolo s:tLocales){
			if(s.getNombre().equals(sim.getNombre())){
				return true;
			}
		}
		
		return false;
    }
    
    public ArrayList<Simbolo> verificarLocales(ArrayList<Simbolo> tablaLocales, ArrayList<Integer> lineas){
    	ArrayList<Simbolo> tLocales = new ArrayList<Simbolo>();
    	int i = 0;
    	for(Simbolo s:tablaLocales){
    		if(verificarLocal(s, tLocales)){
    			System.out.println("Error. Ya existe la variable local '" + s.getNombre() + ". Linea: " + lineas.get(i));
    			errores.add("Error. Ya existe la variable local '" + s.getNombre() + "'. Linea: " + lineas.get(i));
    		}else{
    			tLocales.add(s);
    		}
    		i++;
    	}
    	
    	return tLocales;
    }
    
    public void printTablaSimbolos(){
    	System.out.println("Tabla de simbolos:");
    	
    	for(Simbolo s:tablaG){
                String imp2 = "";
    		String imp = s.getTipo() + " " + s.getNombre();
    		if(s.getId() == Identificador.Variable){
    			imp+= "= " + s.getValor();
    		}
    		System.out.println(imp);
    		for(Simbolo sh:s.getTablaG()){
                        imp2 += "\t" + sh.getTipo() + " " + sh.getNombre();
    			
                        if(sh.getId() == Identificador.Variable){
                               imp2 += "= " + sh.getValor();
                        }
                        System.out.println(imp2);
                        imp2 = "";
    		}
    	}
    }
    
    public void guardarOperador(String token){
        RS_Operador rso = new RS_Operador();
        rso.setValor(token);
        pilaSemantica.push(rso);
    }
    
    public void evaluadorBinario(){
    	RS_DO rsdo1 = (RS_DO) pilaSemantica.pop();
    	RS_Operador rsop = (RS_Operador) pilaSemantica.pop();
    	RS_DO rsdo2 = (RS_DO) pilaSemantica.pop();
    	
    	//Chequeo de tipos
    	if(rsdo1.getTipo() == rsdo2.getTipo()){
    		//Generar codigo completo
    		//Crear RS_DO
    		RS_DO rsdo = new RS_DO();
    		rsdo.setTipo(RS_tipo.direccion);
    		rsdo.setValor(rsdo1.getValor());
    		pilaSemantica.push(rsdo);
    	}else{
    		System.out.println("Error. Asignacion de tipos distintos. Linea: HAY QUE PONER LINEA");
    		//Hacer el push a la pila...:
    		//errores.push("Error. Asignacion de tipos distintos. Linea: HAY QUE PONER LINEA");
    	}
    }
}