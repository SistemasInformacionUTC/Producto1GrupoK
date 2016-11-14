package models;

import play.*;

import javax.persistence.*;

@Entity
public class MicroProcesador {
	public String id;
	public String nombre;
	public String num_transistores;
	public String memoria;
	public String descripcion;
	public int valor1;
	public int valor2;

	
	public MicroProcesador( String id, String nombre,String num_transistores,String memoria, String descripcion, int valor1, int valor2) {
		super();
	
		this.id = id;
		this.nombre =  nombre;
		this.num_transistores = num_transistores;
		this.memoria =memoria;
		this.descripcion=descripcion;
		this.valor1 = valor1;
		this.valor2 = valor2;
	
	}
}