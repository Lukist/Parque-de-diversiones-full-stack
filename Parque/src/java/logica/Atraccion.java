
package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Atraccion implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idAtraccion;
    private String nombreAtraccion;
    private int capacidadMaxima;
    private int capacidadMinima;
    private boolean mayoriaDeEdad;
    
    @OneToMany (mappedBy="atr")
    private List<Encargado> listaEnc;
    @OneToMany (mappedBy="atra")
    private List<Horario> listaHor;
    
    public Atraccion() {
    }

    public Atraccion(String nombreAtraccion, int capacidadMaxima, int capacidadMinima, boolean mayoriaDeEdad, List<Encargado> listaEnc, List<Horario> listaHor) {
        this.nombreAtraccion = nombreAtraccion;
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadMinima = capacidadMinima;
        this.mayoriaDeEdad = mayoriaDeEdad;
        this.listaEnc = listaEnc;
        this.listaHor = listaHor;
    }

    public List<Encargado> getListaEnc() {
        return listaEnc;
    }

    public void setListaEnc(List<Encargado> listaEnc) {
        this.listaEnc = listaEnc;
    }

    public List<Horario> getListaHor() {
        return listaHor;
    }

    public void setListaHor(List<Horario> listaHor) {
        this.listaHor = listaHor;
    }

    public long getIdAtraccion() {
        return idAtraccion;
    }

    public void setIdAtraccion(long idAtraccion) {
        this.idAtraccion = idAtraccion;
    }

    public String getNombreAtraccion() {
        return nombreAtraccion;
    }

    public void setNombreAtraccion(String nombreAtraccion) {
        this.nombreAtraccion = nombreAtraccion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCapacidadMinima() {
        return capacidadMinima;
    }

    public void setCapacidadMinima(int capacidadMinima) {
        this.capacidadMinima = capacidadMinima;
    }

    public boolean isMayoriaDeEdad() {
        return mayoriaDeEdad;
    }

    public void setMayoriaDeEdad(boolean mayoriaDeEdad) {
        this.mayoriaDeEdad = mayoriaDeEdad;
    }

    
    
}
