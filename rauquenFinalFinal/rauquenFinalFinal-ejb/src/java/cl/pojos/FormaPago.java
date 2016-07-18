/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Entity
@Table(name = "forma_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaPago.findAll", query = "SELECT f FROM FormaPago f"),
    @NamedQuery(name = "FormaPago.findByIdformaPago", query = "SELECT f FROM FormaPago f WHERE f.idformaPago = :idformaPago"),
    @NamedQuery(name = "FormaPago.findByDetalle", query = "SELECT f FROM FormaPago f WHERE f.detalle = :detalle")})
public class FormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idforma_pago")
    private Integer idformaPago;
    @Size(max = 45)
    @Column(name = "detalle")
    private String detalle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPago")
    private List<VentaFormaPago> ventaFormaPagoList;

    public FormaPago() {
    }

    public FormaPago(Integer idformaPago) {
        this.idformaPago = idformaPago;
    }

    public Integer getIdformaPago() {
        return idformaPago;
    }

    public void setIdformaPago(Integer idformaPago) {
        this.idformaPago = idformaPago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @XmlTransient
    public List<VentaFormaPago> getVentaFormaPagoList() {
        return ventaFormaPagoList;
    }

    public void setVentaFormaPagoList(List<VentaFormaPago> ventaFormaPagoList) {
        this.ventaFormaPagoList = ventaFormaPagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idformaPago != null ? idformaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.idformaPago == null && other.idformaPago != null) || (this.idformaPago != null && !this.idformaPago.equals(other.idformaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.FormaPago[ idformaPago=" + idformaPago + " ]";
    }
    
}
