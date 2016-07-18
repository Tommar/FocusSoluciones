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
@Table(name = "descarga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descarga.findAll", query = "SELECT d FROM Descarga d"),
    @NamedQuery(name = "Descarga.findByIddescarga", query = "SELECT d FROM Descarga d WHERE d.iddescarga = :iddescarga"),
    @NamedQuery(name = "Descarga.findByTipo", query = "SELECT d FROM Descarga d WHERE d.tipo = :tipo"),
    @NamedQuery(name = "Descarga.findByObservacion", query = "SELECT d FROM Descarga d WHERE d.observacion = :observacion"),
    @NamedQuery(name = "Descarga.findByCantidad", query = "SELECT d FROM Descarga d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Descarga.findByCapacidad", query = "SELECT d FROM Descarga d WHERE d.capacidad = :capacidad")})
public class Descarga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddescarga")
    private Integer iddescarga;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 45)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "capacidad")
    private Integer capacidad;
    @JoinColumn(name = "idcamion", referencedColumnName = "idcamion")
    @ManyToOne
    private Camion idcamion;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne
    private Estado idestado;

    public Descarga() {
    }

    public Descarga(Integer iddescarga) {
        this.iddescarga = iddescarga;
    }

    public Integer getIddescarga() {
        return iddescarga;
    }

    public void setIddescarga(Integer iddescarga) {
        this.iddescarga = iddescarga;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Camion getIdcamion() {
        return idcamion;
    }

    public void setIdcamion(Camion idcamion) {
        this.idcamion = idcamion;
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        this.idestado = idestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddescarga != null ? iddescarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descarga)) {
            return false;
        }
        Descarga other = (Descarga) object;
        if ((this.iddescarga == null && other.iddescarga != null) || (this.iddescarga != null && !this.iddescarga.equals(other.iddescarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Descarga[ iddescarga=" + iddescarga + " ]";
    }
    
}
