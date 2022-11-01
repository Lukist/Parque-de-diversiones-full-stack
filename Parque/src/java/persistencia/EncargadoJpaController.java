/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Atraccion;
import logica.Encargado;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Lucas
 */
public class EncargadoJpaController implements Serializable {

    public EncargadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EncargadoJpaController() {
    this.emf = Persistence.createEntityManagerFactory("ParquePU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Encargado encargado) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Atraccion atr = encargado.getAtr();
            if (atr != null) {
                atr = em.getReference(atr.getClass(), atr.getIdAtraccion());
                encargado.setAtr(atr);
            }
            em.persist(encargado);
            if (atr != null) {
                atr.getListaEnc().add(encargado);
                atr = em.merge(atr);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Encargado encargado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Encargado persistentEncargado = em.find(Encargado.class, encargado.getIdEncargado());
            Atraccion atrOld = persistentEncargado.getAtr();
            Atraccion atrNew = encargado.getAtr();
            if (atrNew != null) {
                atrNew = em.getReference(atrNew.getClass(), atrNew.getIdAtraccion());
                encargado.setAtr(atrNew);
            }
            encargado = em.merge(encargado);
            if (atrOld != null && !atrOld.equals(atrNew)) {
                atrOld.getListaEnc().remove(encargado);
                atrOld = em.merge(atrOld);
            }
            if (atrNew != null && !atrNew.equals(atrOld)) {
                atrNew.getListaEnc().add(encargado);
                atrNew = em.merge(atrNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = encargado.getIdEncargado();
                if (findEncargado(id) == null) {
                    throw new NonexistentEntityException("The encargado with id " + id + " no longer exists.");
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
            Encargado encargado;
            try {
                encargado = em.getReference(Encargado.class, id);
                encargado.getIdEncargado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The encargado with id " + id + " no longer exists.", enfe);
            }
            Atraccion atr = encargado.getAtr();
            if (atr != null) {
                atr.getListaEnc().remove(encargado);
                atr = em.merge(atr);
            }
            em.remove(encargado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Encargado> findEncargadoEntities() {
        return findEncargadoEntities(true, -1, -1);
    }

    public List<Encargado> findEncargadoEntities(int maxResults, int firstResult) {
        return findEncargadoEntities(false, maxResults, firstResult);
    }

    private List<Encargado> findEncargadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Encargado.class));
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

    public Encargado findEncargado(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Encargado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEncargadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Encargado> rt = cq.from(Encargado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
