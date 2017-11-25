package analizador_Semantico;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;


public class Semantico {

	private ArrayList<Simbolo> tablaG = new ArrayList<Simbolo>();
	
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
	}
	
	public void addSimbolo(Simbolo new_Simbolo){
		Boolean existe = false;
		for(Simbolo s:tablaG){
			if(s.getNombre().equals(new_Simbolo.getNombre())){
				if(s.getTipo().equals(new_Simbolo.getTipo())){
					if(s.getValor().equals("") && !new_Simbolo.getValor().equals("")){
						s.setValor(new_Simbolo.getValor());
					}
				}else{
					System.out.println("AQUI HAY UN ERROR DE REDEFINICION CON TIPO DIFERENTE");
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
    	System.out.println("Nuevo despliegue::::::::::::::::::::::");
    	
    	for(Simbolo s:tablaG){
    		String imp = s.getNombre();
    		if(s.getId() == Identificador.Variable){
    			imp+= ": " + s.getValor();
    		}
    		System.out.println(imp);
    		for(Simbolo sh:s.getTablaG()){
    			System.out.println("\t" + sh.getNombre());
    		}
    	}
    }
}
