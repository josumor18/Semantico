package analizador_Semantico;

import java.util.ArrayList;

public class Simbolo {
	private String tipo;
	private Identificador id;
	private String nombre;
	private String valor;
    private ArrayList<Simbolo> tablaG = new ArrayList<Simbolo>();
	
	public Simbolo(String tipo, Identificador id, String nombre, String valor) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.nombre = nombre;
		this.valor = valor;
		System.out.println(tipo + " " + nombre + "= " + valor);
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

	public ArrayList<Simbolo> getTablaG() {
		return tablaG;
	}

	public void setTablaG(ArrayList<Simbolo> tablaG) {
		this.tablaG = tablaG;
	}
	
	public void addSimboloToTabla(Simbolo nSimbolo){
		tablaG.add(nSimbolo);
	}
}
