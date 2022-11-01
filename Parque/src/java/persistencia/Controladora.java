
package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Atraccion;
import logica.Cliente;
import logica.Encargado;
import logica.Entrada;
import logica.Horario;
import logica.Usuario;
import persistencia.exceptions.NonexistentEntityException;


public class Controladora {
    UsuarioJpaController useJpa = new UsuarioJpaController();
    EncargadoJpaController encJpa = new EncargadoJpaController();
    AtraccionJpaController atrJpa = new AtraccionJpaController();
    HorarioJpaController horJpa = new HorarioJpaController();
    EntradaJpaController entJpa = new EntradaJpaController();
    ClienteJpaController cliJpa = new ClienteJpaController();
    
    public void crearUsuario(String nombre, String clave){
        Usuario user = new Usuario(nombre, clave);
        useJpa.create(user);
    }
 
    
    public void nuevoUsuario(String nombreUsuario, String clave,String nombre,String apellido ,String nombreAtraccion) {
        Usuario user = new Usuario(nombreUsuario, clave);
        
        useJpa.create(user);
        
        Atraccion atraccion = new Atraccion(); 

        List<Atraccion> listaAtraccion = atrJpa.findAtraccionEntities();
        for (Atraccion atr : listaAtraccion) {
            if (atr.getNombreAtraccion().equals(nombreAtraccion)) {
                atraccion = atr;    
            }
        }
        
        List<Encargado> listitaAtraccion = atraccion.getListaEnc();
        
        Encargado encargado = new Encargado(nombre, apellido, atraccion, user);
        
        encJpa.create(encargado);
        
        listitaAtraccion.add(encargado);
        
        atraccion.setListaEnc(listitaAtraccion);
        
        try {
            atrJpa.edit(atraccion);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void nuevoUsuarioAtraccion(String nombreUsuario, String clave,String nombre,String apellido ,String nombreAtraccion,int capacidadMaxima, int capacidadMinima, boolean mayoriaDeEdad ,String horaIda, String horaVuelta) {
        Usuario user = new Usuario(nombreUsuario, clave);
        
        useJpa.create(user);
        
        List<Encargado> listaEncargados = new ArrayList<Encargado>();
        List<Horario> listaHorarios = new ArrayList<Horario>();
        
        Atraccion atraccion = new Atraccion(nombreAtraccion, capacidadMaxima, capacidadMinima, mayoriaDeEdad, listaEncargados, listaHorarios);
        
        atrJpa.create(atraccion);
        
        Horario hora = new Horario(horaIda, horaVuelta, atraccion);
        
        horJpa.create(hora);
        
        listaHorarios.add(hora);
        
        atraccion.setListaHor(listaHorarios);
        
        try {
            atrJpa.edit(atraccion);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Encargado encargado = new Encargado(nombre, apellido, atraccion, user);
        
        encJpa.create(encargado);
        
        listaEncargados.add(encargado);
        
        atraccion.setListaEnc(listaEncargados);
        
        try {
            atrJpa.edit(atraccion);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void editarUsuario(Usuario user) {
        try {
            useJpa.edit(user);
        } catch (Exception exc) {
            System.out.println("No se pudo editar el contacto por " + exc.getMessage());
        }
    }
    
    public void borrarUsuario(long id) {
        try {
            useJpa.destroy(id);
        } catch (NonexistentEntityException exc) {
            System.out.println("No se pudo borrar el usuario porque: " + exc.getMessage());
        }
    }
    
    public Usuario encontrarUsusario(long id) {
        return useJpa.findUsuario(id);
    }
    
    public List<Usuario> encontrarUsuarios() {
        List<Usuario> lista = useJpa.findUsuarioEntities();
        
        return lista;
    }
    
    public void crearCarrera(Atraccion atr){
        atrJpa.create(atr);
    }
    
    public void crearHorario(String fin, String principio, Atraccion atraccion) {
        Horario horario = new Horario(principio, fin, atraccion);
        
        horJpa.create(horario);
    }
    
    public void editarAtraccion(Long id, String nombreAtraccion, int capacidadMaxima, int capacidadMinima, boolean mayoriaDeEdad) {
        Atraccion atraccion = atrJpa.findAtraccion(id);
        
        atraccion.setNombreAtraccion(nombreAtraccion);
        atraccion.setCapacidadMaxima(capacidadMaxima);
        atraccion.setCapacidadMinima(capacidadMinima);
        atraccion.setMayoriaDeEdad(mayoriaDeEdad);
        
        try {
            atrJpa.edit(atraccion);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agragarHorariosUnico(Horario nuevoHorario) {
        List<Atraccion> lista = atrJpa.findAtraccionEntities();
        Atraccion ultimo = lista.get(lista.size()-1);
        
        List<Horario> modificacion = ultimo.getListaHor();
        modificacion.add(nuevoHorario);
        
        
    }
    
    public void crearEncargado(Encargado encargado){
        encJpa.create(encargado);
    }
    
    public Atraccion encontrarAtraccion(long id) {
        Atraccion atraccion = atrJpa.findAtraccion(id);
        
        return atraccion;
    }
    
    public List<Atraccion> encontrarAtracciones() {
        List<Atraccion> lista = atrJpa.findAtraccionEntities();
        
        return lista;
    }
    
    
    public Usuario loginUsuario(String nombreUsuario, String clave) {
    
    Usuario usuario = null;
    
    try {
      
      List<Usuario> listaUsuario = this.useJpa.findUsuarioEntities();
      
      for (Usuario usr : listaUsuario) {
        
        if ((usr.getNombreUsuario().equals(nombreUsuario)) && (usr.getClave().equals(clave))) {
          usuario = usr;
          break;
          
        }
      }
    } catch (Exception exc) {
      
      System.out.println("Se produjo un error al ingresar a la aplicación: " + exc.getMessage());
      
    }
    return usuario;
  }
    
    public List<Horario> encontrarHorarios() {
        List<Horario> lista = horJpa.findHorarioEntities();
        
        return lista;
    }
    
    public Horario encontrarHorario(long id) {
        return horJpa.findHorario(id);
    }
    
    public void modificarHorario(long id, String horaPrincipio, String horaFin, long idAtraccion) {
        
        Horario nuevoHorario = horJpa.findHorario(id);
        
        Atraccion atraccion = atrJpa.findAtraccion(idAtraccion);
        

        
        if (nuevoHorario.getAtra() != null) {

            Atraccion atraccionVieja = atrJpa.findAtraccion(nuevoHorario.getAtra().getIdAtraccion());

            List<Horario> listaHorariosVieja = atraccionVieja.getListaHor();
            List<Horario> listaHorariosNueva = atraccion.getListaHor();

            listaHorariosVieja.remove(nuevoHorario);

            try {
                atrJpa.edit(atraccionVieja);
            } catch (Exception ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }

            nuevoHorario.setPrincipio(horaPrincipio);
            nuevoHorario.setFin(horaFin);
            nuevoHorario.setAtra(atraccion);

            try {
                horJpa.edit(nuevoHorario);
            } catch (Exception ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }


            listaHorariosNueva.add(nuevoHorario);

            atraccion.setListaHor(listaHorariosNueva);

            try {
                atrJpa.edit(atraccion);
            } catch (Exception ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        } else {
            
            List<Horario> listaHorariosNueva = atraccion.getListaHor();


            nuevoHorario.setPrincipio(horaPrincipio);
            nuevoHorario.setFin(horaFin);
            nuevoHorario.setAtra(atraccion);

            try {
                horJpa.edit(nuevoHorario);
            } catch (Exception ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }


            listaHorariosNueva.add(nuevoHorario);

            atraccion.setListaHor(listaHorariosNueva);

            try {
                atrJpa.edit(atraccion);
            } catch (Exception ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
    }
    
    public void eliminarHorario(long id) {
        Horario horario = horJpa.findHorario(id);
        
        Atraccion atraccion = horario.getAtra();
        
        List<Horario> listaHorarios = atraccion.getListaHor();
        
        listaHorarios.remove(horario);
        
        atraccion.setListaHor(listaHorarios);
        
        try {
            atrJpa.edit(atraccion);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            horJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarAtraccion(long id) {
        Atraccion atraccion = atrJpa.findAtraccion(id);
        
        Atraccion atr = null;
        
        List<Encargado> listaEncargados = atraccion.getListaEnc();
        
        for (Encargado encargado : listaEncargados) {
            encargado.setAtr(atr);
            try {
                encJpa.edit(encargado);
            } catch (Exception ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        List<Horario> listaHorarios = atraccion.getListaHor();
        
        for (Horario horario : listaHorarios) {
            horario.setAtra(atr);
            try {
                horJpa.edit(horario);
            } catch (Exception ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            atrJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void crearCliente(String nombre, String apellido) {
        List<Entrada> listaEntradas = new ArrayList<Entrada>(); 
        
        Cliente cliente = new Cliente(nombre, apellido, listaEntradas);
        
        cliJpa.create(cliente);
    }
    
    public Cliente encontrarCliente(long id) {
        return cliJpa.findCliente(id); 
    }

    public void venderEntrada(long idAtraccion, long idTarjeta, long idHorario,String dia) {
        Atraccion atraccion = atrJpa.findAtraccion(idAtraccion);
        Cliente cliente = cliJpa.findCliente(idTarjeta);
        Horario horario = horJpa.findHorario(idHorario);
        
        Entrada entrada = new Entrada(dia, horario, cliente, atraccion);
        
        entJpa.create(entrada);
        
        List<Entrada> listaEntradas = cliente.getListaEnt();
        
        listaEntradas.add(entrada);
        cliente.setListaEnt(listaEntradas);
        
        try {
            cliJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Entrada> encontrarEntradas() {
        return entJpa.findEntradaEntities();
    }
    
    public Encargado encontrarEncargado(long id) {
        return encJpa.findEncargado(id);
    }
    
    public List<Encargado> encontrarEncargados(){
        return encJpa.findEncargadoEntities();
    }

    public void modificarCuenta(long idUsuario, long idEncargado, String nombreUsuario, String clave, String nombre, String apellido, long atraccion) {
        Usuario user = useJpa.findUsuario(idUsuario);
        Encargado encargado = encJpa.findEncargado(idEncargado);
        Atraccion atraccionVieja = atrJpa.findAtraccion(encargado.getAtr().getIdAtraccion());
        Atraccion atraccionNueva = atrJpa.findAtraccion(atraccion);
        
        List<Encargado> listaEncargadosVieja = atraccionVieja.getListaEnc();
        List<Encargado> listaEncargadosNueva = atraccionNueva.getListaEnc();
        
        listaEncargadosVieja.remove(encargado);
        atraccionVieja.setListaEnc(listaEncargadosVieja);

            try {
                atrJpa.edit(atraccionVieja);
            } catch (Exception ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }

            encargado.setApellido(apellido);
            encargado.setNombre(nombre);
            encargado.setAtr(atraccionNueva);

            try {
                encJpa.edit(encargado);
            } catch (Exception ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }


            listaEncargadosNueva.add(encargado);

            atraccionNueva.setListaEnc(listaEncargadosNueva);

            try {
                atrJpa.edit(atraccionNueva);
            } catch (Exception ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            user.setClave(clave);
            user.setNombreUsuario(nombreUsuario);

            try {
                useJpa.edit(user);
            } catch (Exception ex) {
                Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
    }
    
    public List<Cliente> encontrarClientes() {
        return cliJpa.findClienteEntities();
    }

    public void editarCliente(long id, String nombre, String apellido) {
        Cliente cliente = cliJpa.findCliente(id);
        
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        
        try {
            cliJpa.edit(cliente);
        } catch (Exception ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarCliente(long id) {
        Cliente cliente = cliJpa.findCliente(id);
        
        try {
            cliJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    
    
}

