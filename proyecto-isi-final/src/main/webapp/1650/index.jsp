<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="trabajoisi.*"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <link rel="stylesheet" type="text/css" href="../style.css" />
    <title>ProyectoISI</title>
</head>

<body>
    <div class="Cabecera">
        <div class="Imagen">
            <img src="../imgs/1650.jpg" alt="Tarjetas gráficas" width=440px height=255px>
            <h2>NVIDIA GEFORCE GTX 1650</h2>
        </div>
        
         <ul class="Caracteristicas">
        <%
        
        	TarjetaGrafica tg = new TarjetaGrafica();
        	tg.setNombre("1650");
        	
        	VersusComparador vs = new VersusComparador(tg);
        	
        	tg.setCaracteristicas(vs.CaracteristicasBusqueda("https://versus.com/en/nvidia-geforce-gtx-1650"));
           	
        	out.println("<h2><br>Caracteristicas: </br></h2>");
        	out.println("<h3>Velocidad GPU: "+ tg.getcaracteristicas().getVelocidadGPU() + "</h3>");
        	out.println("<li>GPU Turbo: "+ tg.getcaracteristicas().getGPUTurbo() + "</li>");
        	out.println("<li>Memoria Efectiva: "+ tg.getcaracteristicas().getMemoriaEfectiva() + "</li>");
        	out.println("<li>Memoria de Ancho de Banda: "+ tg.getcaracteristicas().getMemoriaAnchoBanda() + "</li>");
        	out.println("<li>VRAM: "+ tg.getcaracteristicas().getVram() + "</li>");
        	out.println("<li>GDDR: "+ tg.getcaracteristicas().getGDDR() + "</li>");
        	out.println("<li>Puertos HDMI "+ tg.getcaracteristicas().getPuertosHDMI() + "</li>");
        	out.println("<li>Tiene : " + tg.getcaracteristicas().getPuertosSalida() + " puertos de salida</li>");
        	out.println("<li>TDP: " + tg.getcaracteristicas().getTDP() + "</li>");
        	out.println("<li>PCIE: " + tg.getcaracteristicas().getPCIE() + "</li>");
        	out.println("<li>Anchura: " + tg.getcaracteristicas().getAnchura() + "</li>");
        	out.println("<li>Altura: " + tg.getcaracteristicas().getAltura() + "</li>");
        	%>    	
    </ul>
    </div>

    <div class="Precio">
        <div>
            <img src="../imgs/amazon.jpg" alt="Logo Amazon" width=100px height=100px>
            <h2>Precio Amazon</h2>
            <%
            	Amazon amazon = new Amazon("nvidia gtx 1650");
            	ArrayList<Precios> preciosAmazon = new ArrayList<Precios>();
            	
            	preciosAmazon = amazon.AmazonBusqueda();
            	
            	for (int i = 0;  i < 5; i++){
            		out.println("<h3><a href=" + preciosAmazon.get(i).getURL() + ">" + preciosAmazon.get(i).getNombre() + "</a>" + "<br>Precio: " + preciosAmazon.get(i).getPrecio() + " EUR<br>Estado: " + preciosAmazon.get(i).getUsado() + "</h3>");
            		out.println("<br><br>");
            	}
            %>
            
            
        </div>
        
        <div>
            <img src="../imgs/ebay.jpg" alt="Logo Ebay" width=100px height=100px>
            <h2>Precio Ebay</h2>
            <%
            	Ebay ebay = new Ebay();
            	ArrayList<Precios> preciosEbay = new ArrayList<Precios>();
            	
            	preciosEbay = ebay.EbayBusqueda("https://www.ebay.es/sch/i.html?_nkw=gtx+1650&_sop=12");
            	
            	for (int i = 0;  i < preciosEbay.size(); i++){
            		out.println("<h3><a href=" + preciosEbay.get(i).getURL() + ">" + preciosEbay.get(i).getNombre() + "</a>" + "<br>Precio: " + preciosEbay.get(i).getPrecio() + "<br>Estado: " + preciosEbay.get(i).getUsado() + "</h3>");
            		out.println("<br><br>");
            	}
            %>
            
        </div>

        <div>
            <img src="../imgs/Versus-Gamers.jpg" alt="Logo Ebay" width=100px height=100px>
            <h2>Precio Versus</h2>
            <%
            	
            	VSversus versus = new VSversus();
            	Precios precio = new Precios();
            	
            	precio = versus.VsBusqueda("https://www.vsgamers.es/product/tarjeta-grafica-asus-tuf-gtx-1650-gaming-p-4gb-gddr6");
            	
            	out.println("<h3><a href=" + precio.getURL() + ">" + precio.getNombre() + "</a>" + "<br>Precio: " + precio.getPrecio() + "<br>Estado: " + precio.getUsado() + "</h3>");
            %>
        </div>
    </div>
</body> 
</html>