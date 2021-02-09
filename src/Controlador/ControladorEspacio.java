/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.EspacioParqueadero;
import modelo.Ticket;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import util.JPAutils;

/**
 *
 * @author user
 */
public class ControladorEspacio extends Controlador<EspacioParqueadero> {

    private ControladorVehiculo controladorVehiculo;

    public ControladorEspacio(ControladorVehiculo controladorVehiculo) {

        this.controladorVehiculo = controladorVehiculo;
//        String x="espacio";
//        for (int i = 1; i < 51; i++) {
//            this.getLista().add(new EspacioParqueadero(i, x+i, false, false, null  , 0));
//        }
//        try {
//            guardar();
//        } catch (IOException ex) {
//            Logger.getLogger(ControladorEspacio.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void arrendarEspacio(String id, int codE) {
        for (int i = 0; i < this.getLista().size(); i++) {
            if (this.getLista().get(i).getId() == codE) {
                this.getLista().get(i).setArrendado(true);
                this.getLista().get(i).setVehiculo(controladorVehiculo.buscVeh(id));
            }
        }
        

    }

    public boolean deuda(long placa) {
        EntityManager em = JPAutils.getEntityManager();
        try {
            EspacioParqueadero ep = em.find(EspacioParqueadero.class, placa);
            if (ep.isArrendado()) {

                return true;
            } else {
                return false;
            }
        } finally {
            em.close();
        }

    }

    public int espaciosDisponibles() {
        int conteo = 0;
        for (EspacioParqueadero espacioParqueadero : this.getLista()) {
            if (!espacioParqueadero.isArrendado()) {
                conteo++;
            }
        }
        return conteo;
    }

    public int espaciosTotales() {
        return this.getLista().size();
    }

    public EspacioParqueadero regresaEspacio(int i) {
        return this.getLista().get(i);
    }

    public void quitarArriendo(int codE) {
        for (int i = 0; i < this.getLista().size(); i++) {
            if (this.getLista().get(i).getId() == codE) {
                this.getLista().get(i).setArrendado(false);
                this.getLista().get(i).setVehiculo(null);

            }
        }

    }

    public void deuda(int codE) {
        for (int i = 0; i < this.getLista().size(); i++) {
            if (this.getLista().get(i).getId() == codE) {
                this.getLista().get(i).setDeuda(true);

            }
        }

    }

    public void quitarDeuda(int codE) {
        for (int i = 0; i < this.getLista().size(); i++) {
            if (this.getLista().get(i).getId() == codE) {
                this.getLista().get(i).setDeuda(false);

            }
        }

    }

    public double arrendar(String placa, int codE, String tipo, int valor) {
        double total = 0;
        for (int i = 0; i < this.getLista().size(); i++) {
            if (this.getLista().get(i).getId() == codE) {
                this.getLista().get(i).setArrendado(true);
                this.getLista().get(i).setVehiculo(controladorVehiculo.buscVeh(placa));
                switch (tipo) {
                    case "anual":
                        this.getLista().get(i).setValorArriendo(300 * valor);
                        total = 300 * valor;
                        break;
                    case "mensual":
                        this.getLista().get(i).setValorArriendo(150 * valor);
                        total = 150 * valor;
                        break;
                    case "semanal":
                        this.getLista().get(i).setValorArriendo(30 * valor);
                        total = 30 * valor;
                        break;

                }
            }
        }

        return total;
    }

    public double report() {
        double xd = 0;
        for (EspacioParqueadero espacioParqueadero : this.getLista()) {
            xd += espacioParqueadero.getValorArriendo();
        }
        return xd;
    }

}
