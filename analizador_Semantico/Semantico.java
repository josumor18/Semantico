package analizador_Semantico;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;


public class Semantico {

	private ArrayList<Simbolo> tablaG = new ArrayList<Simbolo>();
	private ArrayList<String> errores = new ArrayList<String>();
	
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
}
