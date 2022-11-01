
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
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idTarjeta;
    private String nombre;
    private String apellido;
    
    @OneToMany (mappedBy="cli")
    private List<Entrada> listaEnt;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, List<Entrada> listaEnt) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaEnt = listaEnt;
    }

    

    public List<Entrada> getListaEnt() {
        return listaEnt;
    }

    public void setListaEnt(List<Entrada> listaEnt) {
        this.listaEnt = listaEnt;
    }

    
    
    public long getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(long idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    
    
}
