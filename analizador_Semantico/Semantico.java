package analizador_Semantico;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;

public class Semantico {

	static ArrayList<Simbolo> tablaG = new ArrayList<Simbolo>();
	public Semantico(){
		
	}
	
	public void addSimbolo(Simbolo new_Simbolo){
		Boolean existe = false;
		for(Simbolo s:tablaG){
			if(s.getNombre().equals(new_Simbolo.getNombre())){
				if(s.getTipo().equals(new_Simbolo.getTipo())){
					if(s.getValor().equals("") && !new_Simbolo.getValor().equals("")){
						s.setValor(new_Simbolo.getValor());
					}
					existe = true;
				}else{
					System.out.println("AQUI HAY UN ERROR DE REDEFINICION CON TIPO DIFERENTE");
				}
			}
		}
		if(!existe){
			tablaG.add(new_Simbolo);
		}
		
	}
	
	public void addTablaToSimbolo(ArrayList<Simbolo> tablaFuncion){
		tablaG.get(tablaG.size()-1).setTablaG(tablaFuncion);
	}
        
    public static void printTablaG(){        
        for(Simbolo s: tablaG){
            System.out.println(s.getId() +" " + s.getNombre() + " " + s.getTipo());
        }
    }
    
    public boolean verificarLocal(Simbolo sim, ArrayList<Simbolo> tLocales){
		for(Simbolo s:tLocales){
			if(s.getNombre().equals(sim.getNombre())){
				return true;
			}
		}
		
		return false;
    }
    
    public ArrayList<Simbolo> verificarLocales(ArrayList<Simbolo> tablaLocales){
    	ArrayList<Simbolo> tLocales = new ArrayList<Simbolo>();
    	
    	for(Simbolo s:tablaLocales){
    		if(verificarLocal(s, tLocales)){
    			System.out.println("ERROR. YA EXISTE LA VARIABLE LOCAL: " + s.getNombre());
    		}else{
    			tLocales.add(s);
    		}
    	}
    	
    	return tLocales;
    }
    
    public void printTablaSimbolos(){
    	for(Simbolo s:tablaG){
    		System.out.println(s.getNombre());
    		for(Simbolo sh:s.getTablaG()){
    			System.out.println("\t" + sh.getNombre());
    		}
    	}
    }
}
