package trabajoisi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Amazon {
	
	String tarjeta;
	ArrayList<Precios> precios;
	
	public Amazon() {
		precios = new ArrayList<Precios>();
	}
	
	public Amazon(String producto) {
        this.tarjeta = producto.replaceAll("\s+","+");
        this.precios = new ArrayList<>();
    }
	
	public ArrayList<Precios> AmazonBusqueda() {
		String urlString = "https://api.rainforestapi.com/request?api_key=B2DA4884812143B1B06A45B79EDA516E&type=search&amazon_domain=amazon.es&search_term=";
		urlString = urlString + tarjeta + "&category_id=937935031";
		try {
			URL url = new URL(urlString);
			HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
			
			conexion.setRequestMethod("GET");
			conexion.setConnectTimeout(5000);
			conexion.setReadTimeout(5000);
			
			int status = conexion.getResponseCode();
			System.out.println("Codigo conexion: " + status);
			
			if (status == 200) {
				BufferedReader reader;
				String line;
				StringBuffer responseContent = new StringBuffer();
				
				reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
				
				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
				
				JSONObject json = new JSONObject(responseContent.toString());
				
				JSONArray productos = json.getJSONArray("search_results");
				
				for(int i = 0; i < productos.length(); i++) {
					JSONObject obj = productos.getJSONObject(i);
					String nombre = obj.getString("title");
					String urllink = obj.getString("link");
					

					if (obj.has("price")) {
						obj = obj.getJSONObject("price");
						String precioTarjeta = obj.getString("raw");
						
						
						int primerNumero = 100;
				        for (int j = 0; j <= 9; j++){
				            int jAux = j+48;
				            char c = (char)jAux;
				            int primerNumeroAux = precioTarjeta.indexOf(c);
				            if (primerNumeroAux < primerNumero && primerNumeroAux != -1){
				                primerNumero = primerNumeroAux;
				            }
				        
				        }
						precioTarjeta = precioTarjeta.substring(primerNumero, precioTarjeta.length());
						
						System.out.println(precioTarjeta);
						
						Precios aux = new Precios();
						aux.setNombre(nombre);
						aux.setPrecio(precioTarjeta);
						aux.setURL(urllink);
						aux.setUsado("Desconocido");
						aux.setTienda("Amazon");
						
						this.precios.add(aux);
					}
				}
			}
			return this.precios;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}