/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author user
 */
@Entity
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String fechaHoraIinicio;
    @Column
    private String FechaHoraSalida;
    @Column
    private double valorAPagar;
    @Column
    private boolean pagado;
     @ManyToOne
    @JoinColumn(name="fk_vehiculo")
     private Vehiculo vehiculo;

    public Ticket() {
    }

    public Ticket(Long id, String fechaHoraIinicio, String FechaHoraSalida, double valorAPagar, boolean pagado) {
        this.id = id;
        this.fechaHoraIinicio = fechaHoraIinicio;
        this.FechaHoraSalida = FechaHoraSalida;
        this.valorAPagar = valorAPagar;
        this.pagado = pagado;
    }

    public String getFechaHoraIinicio() {
        return fechaHoraIinicio;
    }

    public void setFechaHoraIinicio(String fechaHoraIinicio) {
        this.fechaHoraIinicio = fechaHoraIinicio;
    }

    public String getFechaHoraSalida() {
        return FechaHoraSalida;
    }

    public void setFechaHoraSalida(String FechaHoraSalida) {
        this.FechaHoraSalida = FechaHoraSalida;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
     

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", fechaHoraIinicio=" + fechaHoraIinicio + ", FechaHoraSalida=" + FechaHoraSalida + ", valorAPagar=" + valorAPagar + ", pagado=" + pagado + '}';
    }

   
    
}
