/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi;

import java.util.ArrayList;
/**
 *
 * @author antonio
 */
public class TarjetaGrafica {
    String nombre;
    Caracteristicas caracteristicas;
    double valoracion;
    
    public void TarjetaGrafica() {
    	String nombre = "";
    	caracteristicas = new Caracteristicas();
    	valoracion = 0.0;
    }
	
	public void setNombre(String n) {
		this.nombre = n;
	}
	
	public void setCaracteristicas(Caracteristicas n) {
		this.caracteristicas = n;
	}
	
	public void setValoracion(double n) {
		this.valoracion = n;
	}
	
	public String getNombre() {
		return this.nombre ;
	}
	
	public Caracteristicas getcaracteristicas() {
		return this.caracteristicas;
	}
	
	public double getValoracion() {
		return valoracion;
	}
	
	public void Empty() {
		this.nombre = "";
		this.valoracion = 0;
		this.caracteristicas = null;
	}

	
}