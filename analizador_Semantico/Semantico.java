package analizador_Semantico;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;
import java.util.Stack;


public class Semantico {

	private ArrayList<Simbolo> tablaG = new ArrayList<Simbolo>();
	private ArrayList<String> errores = new ArrayList<String>();
	Stack<Registro_Semantico> pilaSemantica = new Stack<Registro_Semantico>();
	private Traductor traductor = new Traductor();
        
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
		traductor.clear();
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
	
	public void delSimbolo(String nom, int lin){
		for(int i = 0; i < tablaG.size(); i++){
			if(tablaG.get(i).getNombre().equals(nom)){
				tablaG.remove(i);
				break;
			}
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
    
    public String printTablaSimbolos(){
    	String tS = "Tabla de simbolos:\n";
    	System.out.println("Tabla de simbolos:");
    	
    	for(Simbolo s:tablaG){
                String imp2 = "";
    		String imp = s.getTipo() + " " + s.getNombre();
    		tS+= imp + "\n";
    		System.out.println(imp);
    		for(Simbolo sh:s.getTablaG()){
                        imp2 += "\t" + sh.getTipo() + " " + sh.getNombre();
                        tS+= imp2 + "\n";
                        System.out.println(imp2);
                        imp2 = "";
    		}
    	}
    	return tS;
    }
    
    public void guardarOperador(String token){
        RS_Operador rso = new RS_Operador();
        rso.setValor(token);
        pilaSemantica.push(rso);
    }

    public void guardarId(String token){
        RS_DO rsdo = new RS_DO();
        rsdo.setTipo(RS_tipo.direccion);
        rsdo.setValor(token);
        pilaSemantica.push(rsdo);
    }
    
    public void guardarLiteral(String token){
        RS_DO rsdo = new RS_DO();
        rsdo.setTipo(RS_tipo.literal);
        rsdo.setValor(token);
        pilaSemantica.push(rsdo);
    }
    
    public void printPilaSemantica(){
        System.out.println("");
        System.out.println("");
    	System.out.println("Pila Semantica:");
    	int i = 0;
    	for(Registro_Semantico rs : pilaSemantica){
            System.out.println(i + "   " +rs.getValor());
            i++;
        }
    }
    
    
    public void agregar_a_pilaSemantica(Registro_Semantico s){
        pilaSemantica.push(s);
        /*
        if(!  (s.getValor().equals("+") || s.getValor().equals("-") || s.getValor().equals("*") 
                            || s.getValor().equals("/") || s.getValor().equals("++") 
                            || s.getValor().equals("--")|| s.getValor().equals("="))  ){
            
            
        }
        */
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
    
    public void tradDeclaracionGlobal(int linea){
    	ArrayList<String> tokAux = new ArrayList<String>();
    	Stack<String> tokens = new Stack<String>();
    	int indexTS = -1;
    	for(int i = 0; i < tablaG.size(); i++){
    		if(pilaSemantica.get(0).getValor().equals(tablaG.get(i).getNombre())){
    			indexTS = i;
    			break;
    		}
    	}
    	boolean error = false;
    	if(indexTS != -1){
    		for(int i = 0; i < pilaSemantica.size(); i++){
    			if((pilaSemantica.get(i))instanceof RS_DO){
	        		if(((RS_DO)pilaSemantica.get(i)).getTipo() == RS_tipo.direccion){
	        			int indexO = existeEnTS(pilaSemantica.get(i).getValor());
	        			if(indexO >= 0){
	        				if(tablaG.get(indexO).getTipo().equals(tablaG.get(indexTS).getTipo())){
	        					tokAux.add(pilaSemantica.get(i).getValor());
	        				}else{
	        					errores.add("Error. Asignacion de tipos distintos. Linea: " + linea);
	        					error = true;
	        					break;
	        				}
	        			}
	        		}else{
	        			tokAux.add(pilaSemantica.get(i).getValor());
	        		} 
    			}else{
        			tokAux.add(pilaSemantica.get(i).getValor());
        		} 
        	}
    			
        	
    		if(!error){
    			if(pilaSemantica.size() > 1){
    				traductor.addGlobalAsig(pilaSemantica);
    			}
            	
    		}
        	
    	}else{
    		errores.add("Error. La variable '" + pilaSemantica.get(0).getValor() + "' no existe en la Tabla de Simbolos. Linea: " + linea);
    	}

    	pilaSemantica.clear();
    }
    
    public int existeEnTS(String var){
    	for(int i = 0; i < tablaG.size(); i++){
    		if(var.equals(tablaG.get(i).getNombre())){
    			return i;
    		}
    	}
    	return -1;
    }
    
    public void tradDeclaracionFuncion(String nombre, int linea){
    	traductor.tradFunciones(nombre);
    }
    
    public void tradDeclaracionLocal(int linea){
    	ArrayList<String> tokAux = new ArrayList<String>();
    	Stack<String> tokens = new Stack<String>();
    	int indexTS = -1;
    	for(int i = 0; i < tablaG.size(); i++){
    		if(pilaSemantica.get(0).getValor().equals(tablaG.get(i).getNombre())){
    			indexTS = i;
    			break;
    		}
    	}
    	boolean error = false;
    	if(indexTS != -1){
    		for(int i = 0; i < pilaSemantica.size(); i++){
    			if((pilaSemantica.get(i))instanceof RS_DO){
	        		if(((RS_DO)pilaSemantica.get(i)).getTipo() == RS_tipo.direccion){
	        			int indexO = existeEnTS(pilaSemantica.get(i).getValor());
	        			if(indexO >= 0){
	        				if(tablaG.get(indexO).getTipo().equals(tablaG.get(indexTS).getTipo())){
	        					tokAux.add(pilaSemantica.get(i).getValor());
	        				}else{
	        					errores.add("Error. Asignacion de tipos distintos. Linea: " + linea);
	        					error = true;
	        					break;
	        				}
	        			}
	        		}else{
	        			tokAux.add(pilaSemantica.get(i).getValor());
	        		} 
    			}else{
        			tokAux.add(pilaSemantica.get(i).getValor());
        		} 
        	}
    			
        	
    		if(!error){
    			if(pilaSemantica.size() > 1){
    				traductor.addLocalAsig(pilaSemantica);
    			}
            	
    		}
        	
    	}else{
    		errores.add("Error. La variable '" + pilaSemantica.get(0).getValor() + "' no existe en la Tabla de Simbolos. Linea: " + linea);

    		
    	}

    	pilaSemantica.clear();
    }
    
    public void tradAsigLocal(ArrayList<Simbolo> tablaT, int linea){
    	ArrayList<String> tokAux = new ArrayList<String>();
    	Stack<String> tokens = new Stack<String>();
    	int indexTS = -1;
    	for(int i = 0; i < tablaT.size(); i++){
    		if(pilaSemantica.get(0).getValor().equals(tablaT.get(i).getNombre())){
    			indexTS = i;
    			break;
    		}
    	}
    	boolean error = false;
    	if(indexTS != -1){
    		for(int i = 0; i < pilaSemantica.size(); i++){
    			if((pilaSemantica.get(i))instanceof RS_DO){
	        		if(((RS_DO)pilaSemantica.get(i)).getTipo() == RS_tipo.direccion){
	        			int indexO = existeEnTSF(pilaSemantica.get(i).getValor(), tablaT);
	        			if(indexO >= 0){
	        				if(tablaT.get(indexO).getTipo().equals(tablaT.get(indexTS).getTipo())){
	        					tokAux.add(pilaSemantica.get(i).getValor());
	        				}else{
	        					errores.add("Error. Asignacion de tipos distintos. Linea: " + linea);
	        					error = true;
	        					break;
	        				}
	        			}
	        		}else{
	        			tokAux.add(pilaSemantica.get(i).getValor());
	        		} 
    			}else{
        			tokAux.add(pilaSemantica.get(i).getValor());
        		} 
        	}
    			
        	
    		if(!error){
    			if(pilaSemantica.size() > 1){
    				traductor.addLocalAsig(pilaSemantica);
    			}
            	
    		}
        	
    	}else{
    		indexTS = -1;
        	for(int i = 0; i < tablaG.size(); i++){
        		if(pilaSemantica.get(0).getValor().equals(tablaG.get(i).getNombre())){
        			indexTS = i;
        			break;
        		}
        	}
        	
        	if(indexTS != -1){
        		for(int i = 0; i < pilaSemantica.size(); i++){
        			if((pilaSemantica.get(i))instanceof RS_DO){
    	        		if(((RS_DO)pilaSemantica.get(i)).getTipo() == RS_tipo.direccion){
    	        			int indexO = existeEnTS(pilaSemantica.get(i).getValor());
    	        			if(indexO >= 0){
    	        				if(tablaG.get(indexO).getTipo().equals(tablaG.get(indexTS).getTipo())){
    	        					tokAux.add(pilaSemantica.get(i).getValor());
    	        				}else{
    	        					errores.add("Error. Asignacion de tipos distintos. Linea: " + linea);
    	        					error = true;
    	        					break;
    	        				}
    	        			}
    	        		}else{
    	        			tokAux.add(pilaSemantica.get(i).getValor());
    	        		} 
        			}else{
            			tokAux.add(pilaSemantica.get(i).getValor());
            		} 
            	}
        			
            	
        		if(!error){
        			if(pilaSemantica.size() > 1){
        				traductor.addLocalAsig(pilaSemantica);
        			}
                	
        		}
            	
        	}else{
        		errores.add("Error. La variable '" + pilaSemantica.get(0).getValor() + "' no existe en la Tabla de Simbolos. Linea: " + linea);
        	}
    		
    	}

    	pilaSemantica.clear();
    }
    
    public int existeEnTSF(String var, ArrayList<Simbolo> tablaT){
    	for(int i = 0; i < tablaT.size(); i++){
    		if(var.equals(tablaT.get(i).getNombre())){
    			return i;
    		}
    	}
    	return -1;
    }
    
    public boolean estaDefinidoGlobales(String id){
        for (Simbolo s : tablaG){
            if(s.getNombre().equals(id)){
                return true;
            }
        }
        return false;
    }
    
    public void addError(String error){
        errores.add(error);
    }
    
    public String printErrores(){
    	String err = "\n\n LISTA DE ERRORES SEMANTICOS:\n";
        System.out.println("\n\n LISTA DE ERRORES: ");
        for(String s : errores){
        	err+= "\t" + s + "\n"; 
            System.out.println("\t" + s);
        }
        return err;
    }
    
    public void genEnsamblador(String ruta){
    	traductor.cargarVariables(tablaG);
    	System.out.println(traductor.getEnsamblador());
    	String[] vr = ruta.split("\\\\");
    	int s = vr.length;
    	String[] n = (vr[s-1]).split("\\.");
    	traductor.generarArchivo(n[0]);
    }
    
    public Stack<Registro_Semantico> invertirPila(Stack<Registro_Semantico> pila){
        Stack<Registro_Semantico> res  = new Stack<>();
        while(!pila.isEmpty()){
            res.push(pila.pop());
        }
        return res;
    }
    
    public boolean es_signo_asignacion(String s){
        if(s.equals("=") || s.equals("-=") || s.equals("+=") || s.equals("*=") || s.equals("/=")){
            return true;
        }
        return false;
    }
}
