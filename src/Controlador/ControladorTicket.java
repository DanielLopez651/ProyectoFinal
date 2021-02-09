/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import modelo.Ticket;
import modelo.Vehiculo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.EntityManager;
import util.JPAutils;

/**
 *
 * @author user
 */
public class ControladorTicket extends Controlador<Ticket> {

    private double precioMinuto = 0.025;
    private double sub1;
    private String sal;
    private ControladorVehiculo controladorVehiculo;
    private ControladorEspacio controladorEspacio;

    public ControladorTicket(ControladorVehiculo controladorVehiculo, ControladorEspacio controladorEspacio) {

        this.controladorVehiculo = controladorVehiculo;
        this.controladorEspacio = controladorEspacio;
    }

    public double getPrecioMinuto() {
        return precioMinuto;
    }

    public void setPrecioMinuto(double precioMinuto) {
        this.precioMinuto = precioMinuto;
    }

    public void ingNuevTick(long num, String placa, String modelo, String marca) {
        Date in = new Date();
        Vehiculo veh = controladorVehiculo.buscVeh(placa);
        if (veh == null) {
            veh = controladorVehiculo.ingrVeh(placa, modelo, marca);
        }
        Ticket t = new Ticket();
        t.setId(num);
        t.setVehiculo(veh);
        t.setPagado(false);
        t.setValorAPagar(0);
        t.setFechaHoraIinicio(in + "");
        this.getLista().add(t);

    }

    public double getSub1() {
        return sub1;
    }

    public String getSal() {
        return sal;
    }

    public String showListT(int ind) {
        return this.getLista().get(ind).toString();
    }

    public int numListT() {
        return this.getLista().size();
    }

    public Ticket buscTick(long id) {
        EntityManager em = JPAutils.getEntityManager();
        try {
            return em.find(Ticket.class, id);
        } finally {
            em.close();
        }
    }

    public double pagar(int h, int m, int s, int num) throws Exception {
        Ticket tick = buscTick(num);
        if (tick != null) {
            if (!tick.isPagado()) {
                String d = tick.getFechaHoraIinicio();
                int h1 = Integer.parseInt(d.substring(11, 13));
                int m1 = Integer.parseInt(d.substring(14, 16));
                int s1 = Integer.parseInt(d.substring(17, 19));
                sub1 = (double) (m - m1) + ((double) (h - h1) * 016) + ((double) (s - s1) / 60);
                sal = h + ":" + m + ":" + s;
                return (sub1);
            } else {
                throw new Exception("Ya esta pagado");
            }
        } else {
            throw new Exception("No existe ese ticket");
        }
    }

    public void editTicket(long id, double val, String sal) {
        EntityManager em = JPAutils.getEntityManager();
        try {
            Ticket t = em.find(Ticket.class, id);
            t.setPagado(true);
            t.setValorAPagar(val);
            t.setFechaHoraSalida(sal);
        } finally {
            em.close();
        }

    }

    public double reporteDeIngresos() {
        double valor = 0;
        for (Ticket ticket : this.getLista()) {
            valor += ticket.getValorAPagar();
        }
        return controladorEspacio.report() + valor;
    }

    public Ticket factura(long id) {
        EntityManager em = JPAutils.getEntityManager();
        try {
            return em.find(Ticket.class, id);
        } finally {
            em.close();
        }

    }
}
