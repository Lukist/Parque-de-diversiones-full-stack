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
import logica.Entrada;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Cliente;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Lucas
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ClienteJpaController() {
    this.emf = Persistence.createEntityManagerFactory("ParquePU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getListaEnt() == null) {
            cliente.setListaEnt(new ArrayList<Entrada>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Entrada> attachedListaEnt = new ArrayList<Entrada>();
            for (Entrada listaEntEntradaToAttach : cliente.getListaEnt()) {
                listaEntEntradaToAttach = em.getReference(listaEntEntradaToAttach.getClass(), listaEntEntradaToAttach.getIdEntrada());
                attachedListaEnt.add(listaEntEntradaToAttach);
            }
            cliente.setListaEnt(attachedListaEnt);
            em.persist(cliente);
            for (Entrada listaEntEntrada : cliente.getListaEnt()) {
                Cliente oldCliOfListaEntEntrada = listaEntEntrada.getCli();
                listaEntEntrada.setCli(cliente);
                listaEntEntrada = em.merge(listaEntEntrada);
                if (oldCliOfListaEntEntrada != null) {
                    oldCliOfListaEntEntrada.getListaEnt().remove(listaEntEntrada);
                    oldCliOfListaEntEntrada = em.merge(oldCliOfListaEntEntrada);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdTarjeta());
            List<Entrada> listaEntOld = persistentCliente.getListaEnt();
            List<Entrada> listaEntNew = cliente.getListaEnt();
            List<Entrada> attachedListaEntNew = new ArrayList<Entrada>();
            for (Entrada listaEntNewEntradaToAttach : listaEntNew) {
                listaEntNewEntradaToAttach = em.getReference(listaEntNewEntradaToAttach.getClass(), listaEntNewEntradaToAttach.getIdEntrada());
                attachedListaEntNew.add(listaEntNewEntradaToAttach);
            }
            listaEntNew = attachedListaEntNew;
            cliente.setListaEnt(listaEntNew);
            cliente = em.merge(cliente);
            for (Entrada listaEntOldEntrada : listaEntOld) {
                if (!listaEntNew.contains(listaEntOldEntrada)) {
                    listaEntOldEntrada.setCli(null);
                    listaEntOldEntrada = em.merge(listaEntOldEntrada);
                }
            }
            for (Entrada listaEntNewEntrada : listaEntNew) {
                if (!listaEntOld.contains(listaEntNewEntrada)) {
                    Cliente oldCliOfListaEntNewEntrada = listaEntNewEntrada.getCli();
                    listaEntNewEntrada.setCli(cliente);
                    listaEntNewEntrada = em.merge(listaEntNewEntrada);
                    if (oldCliOfListaEntNewEntrada != null && !oldCliOfListaEntNewEntrada.equals(cliente)) {
                        oldCliOfListaEntNewEntrada.getListaEnt().remove(listaEntNewEntrada);
                        oldCliOfListaEntNewEntrada = em.merge(oldCliOfListaEntNewEntrada);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = cliente.getIdTarjeta();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdTarjeta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<Entrada> listaEnt = cliente.getListaEnt();
            for (Entrada listaEntEntrada : listaEnt) {
                listaEntEntrada.setCli(null);
                listaEntEntrada = em.merge(listaEntEntrada);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
