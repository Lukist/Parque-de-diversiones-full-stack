package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Encargado;
import logica.Horario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-13T00:28:00")
@StaticMetamodel(Atraccion.class)
public class Atraccion_ { 

    public static volatile ListAttribute<Atraccion, Horario> listaHor;
    public static volatile SingularAttribute<Atraccion, Boolean> mayoriaDeEdad;
    public static volatile SingularAttribute<Atraccion, String> nombreAtraccion;
    public static volatile SingularAttribute<Atraccion, Integer> capacidadMaxima;
    public static volatile ListAttribute<Atraccion, Encargado> listaEnc;
    public static volatile SingularAttribute<Atraccion, Integer> capacidadMinima;
    public static volatile SingularAttribute<Atraccion, Long> idAtraccion;

}