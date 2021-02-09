/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import util.JPAutils;

/**
 *
 * @author user
 */
public abstract class Controlador <E>{
       private List<E> lista;
       private Class<E> clase;
       private EntityManager em;

    public Controlador() {
        lista= new ArrayList();
        Type t=getClass().getGenericSuperclass();
        ParameterizedType pt =(ParameterizedType) t;
        clase=(Class) pt.getActualTypeArguments()[0];
       em=JPAutils.getEntityManager();
    }
    public Controlador(EntityManager em){
         lista= new ArrayList();
        Type t=getClass().getGenericSuperclass();
        ParameterizedType pt =(ParameterizedType) t;
        clase=(Class) pt.getActualTypeArguments()[0];
        this.em=em;
        
    }
    public void create(E obj){
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        lista.add(obj);
    }
    public boolean eliminar(E obj){
        em.getTransaction().begin();
        em.remove(em.merge(obj));
        em.getTransaction().commit();
        lista.remove(obj);
        return true;
    }

    public List<E> getLista() {
        return lista;
    }

    public void setLista(List<E> lista) {
        this.lista = lista;
    }

    public Class<E> getClase() {
        return clase;
    }

    public void setClase(Class<E> clase) {
        this.clase = clase;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
       
       
       
    
}
