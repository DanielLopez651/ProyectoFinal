/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import modelo.Usuario;
import util.JPAutils;

/**
 *
 * @author user
 */
public class ControladorUsuario extends Controlador<Usuario> {

    private boolean log;

    public ControladorUsuario() {

    }

    public boolean log(long id) {

        EntityManager em = JPAutils.getEntityManager();
        try {
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                return true;
            } else {
                return false;
            }
        } finally {
            em.close();
        }

    }

    public void setLog(boolean log) {
        this.log = log;
    }

    public Usuario factura(long id) {
        EntityManager em = JPAutils.getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

}
