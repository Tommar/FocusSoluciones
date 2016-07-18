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
@Table(name = "gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gastos.findAll", query = "SELECT g FROM Gastos g"),
    @NamedQuery(name = "Gastos.findByIdgastos", query = "SELECT g FROM Gastos g WHERE g.idgastos = :idgastos"),
    @NamedQuery(name = "Gastos.findByDetalle", query = "SELECT g FROM Gastos g WHERE g.detalle = :detalle"),
    @NamedQuery(name = "Gastos.findByTotal", query = "SELECT g FROM Gastos g WHERE g.total = :total")})
public class Gastos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgastos")
    private Integer idgastos;
    @Size(max = 45)
    @Column(name = "detalle")
    private String detalle;
    @Column(name = "total")
    private Integer total;
    @JoinColumn(name = "idvendedor", referencedColumnName = "idvendedor")
    @ManyToOne
    private Vendedor idvendedor;

    public Gastos() {
    }

    public Gastos(Integer idgastos) {
        this.idgastos = idgastos;
    }

    public Integer getIdgastos() {
        return idgastos;
    }

    public void setIdgastos(Integer idgastos) {
        this.idgastos = idgastos;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Vendedor getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(Vendedor idvendedor) {
        this.idvendedor = idvendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgastos != null ? idgastos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gastos)) {
            return false;
        }
        Gastos other = (Gastos) object;
        if ((this.idgastos == null && other.idgastos != null) || (this.idgastos != null && !this.idgastos.equals(other.idgastos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Gastos[ idgastos=" + idgastos + " ]";
    }
    
}
