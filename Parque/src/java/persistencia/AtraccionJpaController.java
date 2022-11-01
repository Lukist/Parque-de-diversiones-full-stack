/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Encargado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Atraccion;
import logica.Horario;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Lucas
 */
public class AtraccionJpaController implements Serializable {

    public AtraccionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public AtraccionJpaController() {
    this.emf = Persistence.createEntityManagerFactory("ParquePU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Atraccion atraccion) {
        if (atraccion.getListaEnc() == null) {
            atraccion.setListaEnc(new ArrayList<Encargado>());
        }
        if (atraccion.getListaHor() == null) {
            atraccion.setListaHor(new ArrayList<Horario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Encargado> attachedListaEnc = new ArrayList<Encargado>();
            for (Encargado listaEncEncargadoToAttach : atraccion.getListaEnc()) {
                listaEncEncargadoToAttach = em.getReference(listaEncEncargadoToAttach.getClass(), listaEncEncargadoToAttach.getIdEncargado());
                attachedListaEnc.add(listaEncEncargadoToAttach);
            }
            atraccion.setListaEnc(attachedListaEnc);
            List<Horario> attachedListaHor = new ArrayList<Horario>();
            for (Horario listaHorHorarioToAttach : atraccion.getListaHor()) {
                listaHorHorarioToAttach = em.getReference(listaHorHorarioToAttach.getClass(), listaHorHorarioToAttach.getIdHorario());
                attachedListaHor.add(listaHorHorarioToAttach);
            }
            atraccion.setListaHor(attachedListaHor);
            em.persist(atraccion);
            for (Encargado listaEncEncargado : atraccion.getListaEnc()) {
                Atraccion oldAtrOfListaEncEncargado = listaEncEncargado.getAtr();
                listaEncEncargado.setAtr(atraccion);
                listaEncEncargado = em.merge(listaEncEncargado);
                if (oldAtrOfListaEncEncargado != null) {
                    oldAtrOfListaEncEncargado.getListaEnc().remove(listaEncEncargado);
                    oldAtrOfListaEncEncargado = em.merge(oldAtrOfListaEncEncargado);
                }
            }
            for (Horario listaHorHorario : atraccion.getListaHor()) {
                Atraccion oldAtraOfListaHorHorario = listaHorHorario.getAtra();
                listaHorHorario.setAtra(atraccion);
                listaHorHorario = em.merge(listaHorHorario);
                if (oldAtraOfListaHorHorario != null) {
                    oldAtraOfListaHorHorario.getListaHor().remove(listaHorHorario);
                    oldAtraOfListaHorHorario = em.merge(oldAtraOfListaHorHorario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Atraccion atraccion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Atraccion persistentAtraccion = em.find(Atraccion.class, atraccion.getIdAtraccion());
            List<Encargado> listaEncOld = persistentAtraccion.getListaEnc();
            List<Encargado> listaEncNew = atraccion.getListaEnc();
            List<Horario> listaHorOld = persistentAtraccion.getListaHor();
            List<Horario> listaHorNew = atraccion.getListaHor();
            List<Encargado> attachedListaEncNew = new ArrayList<Encargado>();
            for (Encargado listaEncNewEncargadoToAttach : listaEncNew) {
                listaEncNewEncargadoToAttach = em.getReference(listaEncNewEncargadoToAttach.getClass(), listaEncNewEncargadoToAttach.getIdEncargado());
                attachedListaEncNew.add(listaEncNewEncargadoToAttach);
            }
            listaEncNew = attachedListaEncNew;
            atraccion.setListaEnc(listaEncNew);
            List<Horario> attachedListaHorNew = new ArrayList<Horario>();
            for (Horario listaHorNewHorarioToAttach : listaHorNew) {
                listaHorNewHorarioToAttach = em.getReference(listaHorNewHorarioToAttach.getClass(), listaHorNewHorarioToAttach.getIdHorario());
                attachedListaHorNew.add(listaHorNewHorarioToAttach);
            }
            listaHorNew = attachedListaHorNew;
            atraccion.setListaHor(listaHorNew);
            atraccion = em.merge(atraccion);
            for (Encargado listaEncOldEncargado : listaEncOld) {
                if (!listaEncNew.contains(listaEncOldEncargado)) {
                    listaEncOldEncargado.setAtr(null);
                    listaEncOldEncargado = em.merge(listaEncOldEncargado);
                }
            }
            for (Encargado listaEncNewEncargado : listaEncNew) {
                if (!listaEncOld.contains(listaEncNewEncargado)) {
                    Atraccion oldAtrOfListaEncNewEncargado = listaEncNewEncargado.getAtr();
                    listaEncNewEncargado.setAtr(atraccion);
                    listaEncNewEncargado = em.merge(listaEncNewEncargado);
                    if (oldAtrOfListaEncNewEncargado != null && !oldAtrOfListaEncNewEncargado.equals(atraccion)) {
                        oldAtrOfListaEncNewEncargado.getListaEnc().remove(listaEncNewEncargado);
                        oldAtrOfListaEncNewEncargado = em.merge(oldAtrOfListaEncNewEncargado);
                    }
                }
            }
            for (Horario listaHorOldHorario : listaHorOld) {
                if (!listaHorNew.contains(listaHorOldHorario)) {
                    listaHorOldHorario.setAtra(null);
                    listaHorOldHorario = em.merge(listaHorOldHorario);
                }
            }
            for (Horario listaHorNewHorario : listaHorNew) {
                if (!listaHorOld.contains(listaHorNewHorario)) {
                    Atraccion oldAtraOfListaHorNewHorario = listaHorNewHorario.getAtra();
                    listaHorNewHorario.setAtra(atraccion);
                    listaHorNewHorario = em.merge(listaHorNewHorario);
                    if (oldAtraOfListaHorNewHorario != null && !oldAtraOfListaHorNewHorario.equals(atraccion)) {
                        oldAtraOfListaHorNewHorario.getListaHor().remove(listaHorNewHorario);
                        oldAtraOfListaHorNewHorario = em.merge(oldAtraOfListaHorNewHorario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = atraccion.getIdAtraccion();
                if (findAtraccion(id) == null) {
                    throw new NonexistentEntityException("The atraccion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Atraccion atraccion;
            try {
                atraccion = em.getReference(Atraccion.class, id);
                atraccion.getIdAtraccion();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The atraccion with id " + id + " no longer exists.", enfe);
            }
            List<Encargado> listaEnc = atraccion.getListaEnc();
            for (Encargado listaEncEncargado : listaEnc) {
                listaEncEncargado.setAtr(null);
                listaEncEncargado = em.merge(listaEncEncargado);
            }
            List<Horario> listaHor = atraccion.getListaHor();
            for (Horario listaHorHorario : listaHor) {
                listaHorHorario.setAtra(null);
                listaHorHorario = em.merge(listaHorHorario);
            }
            em.remove(atraccion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Atraccion> findAtraccionEntities() {
        return findAtraccionEntities(true, -1, -1);
    }

    public List<Atraccion> findAtraccionEntities(int maxResults, int firstResult) {
        return findAtraccionEntities(false, maxResults, firstResult);
    }

    private List<Atraccion> findAtraccionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Atraccion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Atraccion findAtraccion(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Atraccion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAtraccionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Atraccion> rt = cq.from(Atraccion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
