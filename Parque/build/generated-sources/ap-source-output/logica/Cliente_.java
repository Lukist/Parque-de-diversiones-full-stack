package logica;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Entrada;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-13T00:28:00")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, Long> idTarjeta;
    public static volatile ListAttribute<Cliente, Entrada> listaEnt;
    public static volatile SingularAttribute<Cliente, String> apellido;
    public static volatile SingularAttribute<Cliente, String> nombre;

}