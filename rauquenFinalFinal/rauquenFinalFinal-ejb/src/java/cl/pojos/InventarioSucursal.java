/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Entity
@Table(name = "inventario_sucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InventarioSucursal.findAll", query = "SELECT i FROM InventarioSucursal i"),
    @NamedQuery(name = "InventarioSucursal.findByIdInventario", query = "SELECT i FROM InventarioSucursal i WHERE i.idInventario = :idInventario"),
    @NamedQuery(name = "InventarioSucursal.findByTipo", query = "SELECT i FROM InventarioSucursal i WHERE i.tipo = :tipo"),
    @NamedQuery(name = "InventarioSucursal.findByCantidadActual", query = "SELECT i FROM InventarioSucursal i WHERE i.cantidadActual = :cantidadActual"),
    @NamedQuery(name = "InventarioSucursal.findByCantidadMax", query = "SELECT i FROM InventarioSucursal i WHERE i.cantidadMax = :cantidadMax"),
    @NamedQuery(name = "InventarioSucursal.findByCantidadMin", query = "SELECT i FROM InventarioSucursal i WHERE i.cantidadMin = :cantidadMin"),
    @NamedQuery(name = "InventarioSucursal.findByCapacidad", query = "SELECT i FROM InventarioSucursal i WHERE i.capacidad = :capacidad")})
public class InventarioSucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInventario")
    private Integer idInventario;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "cantidadActual")
    private Integer cantidadActual;
    @Column(name = "cantidadMax")
    private Integer cantidadMax;
    @Column(name = "cantidadMin")
    private Integer cantidadMin;
    @Column(name = "capacidad")
    private Integer capacidad;
    @JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal")
    @ManyToOne(optional = false)
    private Sucursal idsucursal;

    public InventarioSucursal() {
    }

    public InventarioSucursal(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Integer cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public Integer getCantidadMax() {
        return cantidadMax;
    }

    public void setCantidadMax(Integer cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public Integer getCantidadMin() {
        return cantidadMin;
    }

    public void setCantidadMin(Integer cantidadMin) {
        this.cantidadMin = cantidadMin;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Sucursal getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Sucursal idsucursal) {
        this.idsucursal = idsucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventario != null ? idInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioSucursal)) {
            return false;
        }
        InventarioSucursal other = (InventarioSucursal) object;
        if ((this.idInventario == null && other.idInventario != null) || (this.idInventario != null && !this.idInventario.equals(other.idInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.InventarioSucursal[ idInventario=" + idInventario + " ]";
    }
    
}
