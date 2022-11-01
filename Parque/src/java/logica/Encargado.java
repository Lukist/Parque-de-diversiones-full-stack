
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Encargado implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idEncargado;
    private String nombre;
    private String apellido;
    
    @ManyToOne
    private Atraccion atr;
    @OneToOne
    private Usuario user;

    public Encargado() {
    }

    public Encargado(String nombre, String apellido, Atraccion atr, Usuario user) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.atr = atr;
        this.user = user;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    

    public Atraccion getAtr() {
        return atr;
    }

    public void setAtr(Atraccion atr) {
        this.atr = atr;
    }

    

    public long getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(long idEncargado) {
        this.idEncargado = idEncargado;
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
