/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author antonio
 */
public class VSversus {
	
	Precios precios;
	
	public VSversus() {
		precios = new Precios();
	}
    
    public Precios VsBusqueda(String url) throws MalformedURLException, IOException, NoSuchFieldException{
        
        try{
        	
           /*BufferedReader reader = new BufferedReader(new FileReader("data/urlvsvs.txt"));
            
           general = reader.readLine();
           general = general.substring(general.indexOf(' ')+1, general.length());
           System.out.println(general);
                
                
           while ( (especifico = reader.readLine()) != null){
            	if (especifico.substring(0, especifico.indexOf(' ')) == tg.getNombre()) {
	                especifico = especifico.substring(especifico.indexOf(' ')+1, especifico.length());
	                dominio = general + especifico;
	                System.out.println(dominio);
            	}
           }
           System.out.println(dominio);
           reader.close();
           */ 
           
           
           Document doc = Jsoup.connect(url).get();
	         
	       //Precio
	       Elements contenido1 = doc.body().select("span.price");
	       Elements contenido2 = doc.body().select("h1");
	       
	       String precio = contenido1.text();
	       String nombre = contenido2.text();
	       
           
           precios = new Precios(precio, url, nombre, "Nuevo", "VersusGamers");
           
           return this.precios;
      
        } catch(IOException e)
        {
            System.out.println(e);
            return null;
        }
    }
}

