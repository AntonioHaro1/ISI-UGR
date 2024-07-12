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
public class Caracteristicas {
    String VelocidadGPU;
    String GPUTurbo;
    String MemoriaEfectiva;
    String MemoriaAnchoBanda;
    String Vram;
    String GDDR;
    String PuertosHDMI;
    String PuertosSalida;
    String TDP;
    String PCIE;
    String Anchura;
    String Altura;
    
    public void setVelocidadGPU(String n) {
		this.VelocidadGPU = n;
    }
	
    public void setGPUTurbo(String n) {
		this.GPUTurbo = n;
    }
	
    public void setMemoriaEfectiva(String n) {
		this.MemoriaEfectiva = n;
    }
	
    public void setMemoriaAnchoBanda(String n) {
		this.MemoriaAnchoBanda= n;
    }
        
    public void setVram(String n) {
		this.Vram= n;
    }
        
    public void setGDDR(String n){
            this.GDDR = n;
    }
    
    public void setPuertosHDMI(String n){
        this.PuertosHDMI = n;
    }
    
    public void setPuertosSalida(String n){
        this.PuertosSalida = n;
    }
    
    public void setTDP(String n){
        this.TDP = n;
    }
    
    public void setPCIE(String n){
        this.PCIE = n;
    }
    
    public void setAnchura(String n){
        this.Anchura = n;
    }
    
    public void setAltura(String n){
        this.Altura = n;
    }
    
    public String getVelocidadGPU() {
		return VelocidadGPU;
    }
	
    public String getGPUTurbo() {
		return GPUTurbo;
    }
	
    public String getMemoriaEfectiva() {
		return MemoriaEfectiva;
    }
	
    public String getMemoriaAnchoBanda() {
		return MemoriaAnchoBanda;
    }
        
    public String getVram() {
		return Vram;
    }
        
    public String getGDDR(){
            return GDDR;
    }
    
    public String getPuertosHDMI(){
        return PuertosHDMI;
    }
    
    public String getPuertosSalida(){
        return PuertosSalida;
    }
    
    public String getTDP(){
        return TDP;
    }
    
    public String getPCIE(){
        return PCIE;
    }
    
    public String getAnchura(){
        return Anchura;
    }
    
    public String getAltura(){
        return Altura;
    }
}
