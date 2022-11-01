package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Atraccion;
import logica.Cliente;
import logica.Horario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-13T00:28:00")
@StaticMetamodel(Entrada.class)
public class Entrada_ { 

    public static volatile SingularAttribute<Entrada, Cliente> cli;
    public static volatile SingularAttribute<Entrada, String> diaAIr;
    public static volatile SingularAttribute<Entrada, Horario> hor;
    public static volatile SingularAttribute<Entrada, Long> idEntrada;
    public static volatile SingularAttribute<Entrada, Atraccion> atr;

}