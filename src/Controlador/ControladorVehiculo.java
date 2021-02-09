/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.Vehiculo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import util.JPAutils;

/**
 *
 * @author user
 */
public class ControladorVehiculo extends Controlador<Vehiculo> {

    private String err;

    public ControladorVehiculo() {

    }

    public Vehiculo ingrVeh(String placa, String modelo, String marca) {
        Vehiculo v = new Vehiculo();
        v.setId(placa);
        v.setModelo(modelo);
        v.setMarca(marca);
        this.getLista().add(v);
        return v;
    }

    public Vehiculo buscVeh(String id) {
        EntityManager em = JPAutils.getEntityManager();
        try {
            return em.find(Vehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public String showListV(int ind) {
        return this.getLista().get(ind).toString();
    }

    public int numListV() {
        return this.getLista().size();
    }

    public String getErr() {
        return err;
    }

    public boolean validarPlca(String plac) {
        plac = plac.replaceAll("-", "");
        plac = plac.replaceAll(" ", "");
        if ((plac.length() != 6)) {
            err = "Ingrese solo 6 caracteres";
            return false;
        } else {
            char x1 = plac.charAt(0), x2 = plac.charAt(1), x3 = plac.charAt(2);
            try {
                plac = plac.substring(3, 6);
                final int x = Integer.parseInt(plac);
            } catch (Exception e) {
                err = "Ingrese 3 numeros al final";
                return false;
            }
            if (!Character.isLetter(x1)) {
                err = "Ingrese 3 letras al inicio";
                return false;
            } else {
                if (!Character.isLetter(x2)) {
                    err = "Ingrese 3 letras al inicio";
                    return false;
                } else {
                    if (!Character.isLetter(x3)) {
                        err = "Ingrese 3 letras al inicio";
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public Vehiculo factura(String id) {
        EntityManager em = JPAutils.getEntityManager();
        try {
            return em.find(Vehiculo.class, id);
        } finally {
            em.close();
        }
    }
}
