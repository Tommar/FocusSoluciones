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
@Table(name = "carga")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carga.findAll", query = "SELECT c FROM Carga c"),
    @NamedQuery(name = "Carga.findByIdcarga", query = "SELECT c FROM Carga c WHERE c.idcarga = :idcarga"),
    @NamedQuery(name = "Carga.findByTipo", query = "SELECT c FROM Carga c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Carga.findByCantidad", query = "SELECT c FROM Carga c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "Carga.findByCapacidad", query = "SELECT c FROM Carga c WHERE c.capacidad = :capacidad")})
public class Carga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcarga")
    private Integer idcarga;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "capacidad")
    private Integer capacidad;
    @JoinColumn(name = "idcamion", referencedColumnName = "idcamion")
    @ManyToOne
    private Camion idcamion;

    public Carga() {
    }

    public Carga(Integer idcarga) {
        this.idcarga = idcarga;
    }

    public Integer getIdcarga() {
        return idcarga;
    }

    public void setIdcarga(Integer idcarga) {
        this.idcarga = idcarga;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcarga != null ? idcarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carga)) {
            return false;
        }
        Carga other = (Carga) object;
        if ((this.idcarga == null && other.idcarga != null) || (this.idcarga != null && !this.idcarga.equals(other.idcarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Carga[ idcarga=" + idcarga + " ]";
    }
    
}
