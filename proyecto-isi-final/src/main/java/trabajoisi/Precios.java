/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi;

/**
 *
 * @author antonio
 */
public class Precios {
    String precio;
    String url;
    String nombre;
    String usado;
    String tienda;
    
    public Precios() {
    	precio = "";
    	url = "";
    	nombre = "";
    	usado = "";
    	tienda = "";
    }
    
    public Precios(String precio, String url, String nombre, String usado, String tienda) {
    	this.precio = precio;
    	this.url = url;
    	this.nombre = nombre;
    	this.usado = usado;
    	this.tienda = tienda;
    }
    
    
    
    public void setUsado(String n){
        this.usado = n;
    }
    
	public void setURL(String n) {
		this.url = n;
	}
	
	public void setPrecio(String p) {
		this.precio = p;
	} 
	
	public void setNombre(String p) {
		this.nombre = p;
	}
        
	public String getURL() {
		return(this.url);
	}
	
	public String getPrecio() {
		return(this.precio);
	}
	
	public String getNombre() {
		return(this.nombre);
	}
        
    public String getUsado(){
            return(this.usado);
    }
          
    public void setTienda(String p) {
		this.tienda = p;
	}
        
	public String getTienda() {
		return(this.tienda);
	}
    
}
