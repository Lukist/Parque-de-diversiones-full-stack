package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Atraccion;
import logica.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-13T00:28:00")
@StaticMetamodel(Encargado.class)
public class Encargado_ { 

    public static volatile SingularAttribute<Encargado, Long> idEncargado;
    public static volatile SingularAttribute<Encargado, String> apellido;
    public static volatile SingularAttribute<Encargado, String> nombre;
    public static volatile SingularAttribute<Encargado, Usuario> user;
    public static volatile SingularAttribute<Encargado, Atraccion> atr;

}