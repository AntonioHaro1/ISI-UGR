/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author antonio
 */
public class Ebay {
	
	ArrayList<Precios> precios;
	
	public Ebay() {
		precios = new ArrayList<Precios>();
	}
	
    public ArrayList<Precios> EbayBusqueda(String url) throws MalformedURLException, IOException, NoSuchFieldException{
        //arraylist con todas las tarjetas y sus url
        
        try{
        	/*
        	BufferedReader reader = new BufferedReader(new FileReader("data/urlebay.txt"));
            
                
                
            while ( (dominio = reader.readLine()) != null){
            	if (dominio.substring(0, dominio.indexOf(' ')-1) == tg.getNombre()) {
	                dominio = dominio.substring(dominio.indexOf(' ')+1, dominio.length());
	                System.out.println(dominio);
            	}
            }
            System.out.println(dominio);
            reader.close();*/
        	
           Document doc = Jsoup.connect(url).get();
         
           Elements contenido1 = doc.body().select("span.s-item__price");
           Elements contenido2 = doc.body().select("h3.s-item__title");
           // Get all links 
           Elements links = doc.body().select("a.s-item__link").after("href");
                     
          
           
        //Usado
         ArrayList<String> contenido4 = new ArrayList();
         
        for(int i=1; i <= 5;i++){
            
            String html2 = links.get(i).attr("href");
            Document doc2 = Jsoup.connect(html2).get();
            Elements contenido3 = doc2.body().select("div.d-item-condition-text").select("span.ux-textspans");
            
            if(contenido3.text() != null){
                contenido4.add(i-1, contenido3.text());
            }
        }
        
        
        
        for (int i = 1; i <= 5; i++){     
        	Precios aux = new Precios();
            aux.setPrecio(contenido1.get(i).text());
            aux.setNombre(contenido2.get(i).text());
            aux.setURL(links.get(i).attr("href"));
            aux.setUsado(contenido4.get(i-1));
            aux.setTienda("Ebay");
            
            this.precios.add(aux);
        }        
        return this.precios;
        } catch(IOException e)
        {
            System.out.println(e);
            return null;
        }
    }
}