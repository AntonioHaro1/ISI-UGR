 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabajoisi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author antonio
 */
public class VersusComparador {
    
	private TarjetaGrafica tarjeta;
	
	public VersusComparador(TarjetaGrafica tarjeta){
		this.tarjeta = tarjeta;
	}
	
	
    public Caracteristicas CaracteristicasBusqueda(String nombre) throws MalformedURLException, IOException, NoSuchFieldException{
        Caracteristicas c1 = new Caracteristicas();
        String general = "";
        String especifico = "";
        String dominio = "";
        
        
        try{
        	/*BufferedReader reader = new BufferedReader(new FileReader("data/urlvscomparador.txt"));
            
            general = reader.readLine();
            general = general.substring(general.indexOf(' ')+1, general.length());
                
                
            while ( (especifico = reader.readLine()) != null){
            	if (especifico.substring(0, especifico.indexOf(' ')) == nombre) {
	                especifico = especifico.substring(especifico.indexOf(' ')+1, especifico.length());
	                dominio = general + especifico;
	         
            	}
            }
            
            //dominio = "https://versus.com/en/nvidia-geforce-rtx-3090-ti";
          
            reader.close();
                */
        	String html = nombre;
            
           Document doc = Jsoup.connect(nombre).get();
         
           Elements contenidoVal = doc.body().select("span.pointsText");
           String valoracion = contenidoVal.text();
           valoracion = valoracion.substring(0, valoracion.indexOf('p'));
           double valoracionDouble = Double.parseDouble(valoracion);
           
           tarjeta.setValoracion(valoracionDouble);
           
            //Todas las caracteristicas obtenidas
            Elements contenido1 = doc.body().select("p.Number__number___Mp4lk");
            
            c1.setVelocidadGPU(contenido1.eachText().get(0));
         
            
            c1.setGPUTurbo(contenido1.eachText().get(1));
            
            c1.setMemoriaEfectiva(contenido1.eachText().get(9));
       
            
            c1.setMemoriaAnchoBanda(contenido1.eachText().get(10));
                               
            c1.setVram(contenido1.eachText().get(11));
            
            
            c1.setGDDR(contenido1.eachText().get(13));
           
            
            c1.setPuertosHDMI(contenido1.eachText().get(19));
            
            
            c1.setPuertosSalida(contenido1.eachText().get(21));
          
            
            c1.setTDP(contenido1.eachText().get(24));
          
            
            c1.setPCIE(contenido1.eachText().get(27));
        
            
            c1.setAnchura(contenido1.eachText().get(29));
          
            
            c1.setAltura(contenido1.eachText().get(30));
         
            
         //   tarjeta.setCaracteristicas(c1);
            
            return c1;
        
        } catch(IOException e)
        {
            System.out.println(e);
            return null;
        }
    }
}
