
package trabajoisi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.jsoup.Jsoup;
import java.util.Iterator;
import java.util.Scanner;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Farmacos {

    public Farmacos() {
    }

    public static ArrayList<String> buscarFarmaco() throws IOException {

        String url1 = "https://www.pharmabuy.es/nuxe-expert-flu%C3%ADdo-antimanchas-pieles-normales-spf20-50ml-11146.html";
        String url2 = "https://www.pharmabuy.es/venorutox-piernas-ligeras-20sobres-polvo-11121.html";
        ArrayList<String> result = new ArrayList();
        String nombre, descripcion, precio, vendedor, codigo, laboratorio;

        Response response = null;
        try {
            response = Jsoup.connect(url2)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .timeout(12000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }

        // Compruebo si me da un 200 que significa que la conexion se ha establecido
        // bien
        if (response.statusCode() == 200) {

            Document doc = Jsoup.connect(url2).get();

            // Saco el nombre
            Elements contenido1 = doc.body().select("h1");
            nombre = contenido1.text();

            // Saco la descripcion
            Elements contenido2 = doc.body().select("div.rte");
            descripcion = contenido2.text();

            // Para sacar el precio de un script primero saco el script como elements y lo
            // convierto en un string
            // luego busco el precio que viene despues de la variable con nombre
            // productPrice y consigo el precio
            boolean precioEncontrado = false;

            String lineaPrecio = "";

            Elements scriptElements = doc.getElementsByTag("script");
            String content = scriptElements.toString();

            Scanner scanner = new Scanner(content);

            while (scanner.hasNextLine() && !precioEncontrado) {

                String line = scanner.nextLine();

                if (line.contains("var productPrice = ")) {
                    precioEncontrado = true;
                    lineaPrecio = line;
                }
            }
            scanner.close();
            String[] palabras = lineaPrecio.split(" ");
            precio = palabras[3];
            precio = precio.substring(1, precio.length() - 2);

            // Saco el vendedor
            Elements contenido4 = doc.body().select("div.payment-icon").select("img");
            vendedor = contenido4.toString();
            vendedor = vendedor.substring(118, 127);

            // fecha de hoy
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MMMMMMMMM/yyyy HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());

            // Saco el id del producto(codigo)
            Elements contenido6 = doc.body().select("p.hidden").select("input");
            codigo = contenido6.get(1).attr("value");

            // Saco el laboratorio
            Elements contenido5 = doc.body().select("span.hidecol");
            laboratorio = contenido5.text();

            result.add("laboratorio = " + laboratorio);
            result.add("nombre = " + nombre);
            result.add("descripcion = " + descripcion);
            result.add("precio = " + precio);
            result.add("vendedor = " + vendedor);
            result.add("id_producto = " + codigo);
            result.add(formatter.format(date));
            result.add("Url oferta = " + url2);

        } else {
            System.err.println("El status es incorrecto");
        }

        return result;

    }

    public static void main(String[] args) throws IOException {
        ArrayList result = buscarFarmaco();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }

}