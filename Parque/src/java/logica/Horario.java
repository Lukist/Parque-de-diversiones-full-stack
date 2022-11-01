
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idHorario;
    private String principio;
    private String fin;
    @ManyToOne 
    private Atraccion atra;
    
    

    public Horario() {
    }

    public Horario(String principio, String fin, Atraccion atra) {
        this.principio = principio;
        this.fin = fin;
        this.atra = atra;
    }

    

    public long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(long idHorario) {
        this.idHorario = idHorario;
    }

    public String getPrincipio() {
        return principio;
    }

    public void setPrincipio(String principio) {
        this.principio = principio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public Atraccion getAtra() {
        return atra;
    }

    public void setAtra(Atraccion atra) {
        this.atra = atra;
    }

    
    
    
}
