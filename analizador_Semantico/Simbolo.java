package analizador_Semantico;

import java.util.ArrayList;

public class Simbolo {
	private String tipo;
	private Identificador id;
	private String nombre;
	private String valor;
	private int cantParametros;
    private ArrayList<Simbolo> tablaG = new ArrayList<Simbolo>();
	
	//Constructor para cuando es variable
    public Simbolo(String tipo, Identificador id, String nombre, String valor) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.valor = valor;
		//System.out.println(tipo + " " + nombre + "= " + valor);
	}
	
    //Constructor para cuando es función
	public Simbolo(String tipo, Identificador id, String nombre, int cantParametros) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.valor = null;
		this.cantParametros = cantParametros;
		//System.out.println(tipo + " " + nombre + "= " + valor);
	}

	public Identificador getId() {
		return id;
	}

	public void setId(Identificador id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getCantParametros() {
		return cantParametros;
	}

	public void setCantParametros(int cantParametros) {
		this.cantParametros = cantParametros;
	}

	public ArrayList<Simbolo> getTablaG() {
		return tablaG;
	}

	public void setTablaG(ArrayList<Simbolo> tablaG) {
		this.tablaG = tablaG;
	}
	
	public void addSimboloToTabla(Simbolo nSimbolo){
		tablaG.add(nSimbolo);
	}
	
	public void optimizarValor(){
		ArrayList<String> valorSplited = new ArrayList<String>();
		String[] separador = {")","*","/","%","+","-"};
		String[] valsPar = valor.split("(");
		for(String s:valsPar){
			if(!s.isEmpty()){
				valorSplited.add(s);
				valorSplited.add("(");
			}
		}
		
		for(String sep:separador){
			for(int i = 0; i < valorSplited.size(); i++){
				String[] aux = valorSplited.get(i).split(sep);
				if(aux.length > 1){
					valorSplited.remove(i);
					int i_aux = 0;
					for(String sA:aux){
						if(!sA.isEmpty()){
							valorSplited.add(i+i_aux, sA);
							valorSplited.add(sep);
							i_aux+= 2;
						}
					}
				}
			}
		}
	}
}