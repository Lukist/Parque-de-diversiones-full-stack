package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Atraccion;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-13T00:28:00")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, Long> idHorario;
    public static volatile SingularAttribute<Horario, String> principio;
    public static volatile SingularAttribute<Horario, String> fin;
    public static volatile SingularAttribute<Horario, Atraccion> atra;

}