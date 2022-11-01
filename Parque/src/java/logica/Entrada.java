
package logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Entrada implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long idEntrada;
    private String diaAIr;
    @OneToOne
    private Horario hor;
    @ManyToOne
    private Cliente cli;
    @OneToOne
    private Atraccion atr;

    public Entrada() {
    }

    public Entrada(String diaAIr, Horario hor, Cliente cli, Atraccion atr) {
        this.diaAIr = diaAIr;
        this.hor = hor;
        this.cli = cli;
        this.atr = atr;
    }

    public Atraccion getAtr() {
        return atr;
    }

    public void setAtr(Atraccion atr) {
        this.atr = atr;
    }

    
    public Horario getHor() {
        return hor;
    }

    public void setHor(Horario hor) {
        this.hor = hor;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }


    public long getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(long idEntrada) {
        this.idEntrada = idEntrada;
    }

    

    public String getDiaAIr() {
        return diaAIr;
    }

    public void setDiaAIr(String diaAIr) {
        this.diaAIr = diaAIr;
    }

    
    
    
}
