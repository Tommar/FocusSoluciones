/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Entity
@Table(name = "venta_forma_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaFormaPago.findAll", query = "SELECT v FROM VentaFormaPago v"),
    @NamedQuery(name = "VentaFormaPago.findByIdventa", query = "SELECT v FROM VentaFormaPago v WHERE v.ventaFormaPagoPK.idventa = :idventa"),
    @NamedQuery(name = "VentaFormaPago.findByIdformaPago", query = "SELECT v FROM VentaFormaPago v WHERE v.ventaFormaPagoPK.idformaPago = :idformaPago"),
    @NamedQuery(name = "VentaFormaPago.findByValor", query = "SELECT v FROM VentaFormaPago v WHERE v.valor = :valor")})
public class VentaFormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentaFormaPagoPK ventaFormaPagoPK;
    @Column(name = "valor")
    private Integer valor;
    @JoinColumn(name = "idventa", referencedColumnName = "idventa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;
    @JoinColumn(name = "idforma_pago", referencedColumnName = "idforma_pago", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FormaPago formaPago;

    public VentaFormaPago() {
    }

    public VentaFormaPago(VentaFormaPagoPK ventaFormaPagoPK) {
        this.ventaFormaPagoPK = ventaFormaPagoPK;
    }

    public VentaFormaPago(int idventa, int idformaPago) {
        this.ventaFormaPagoPK = new VentaFormaPagoPK(idventa, idformaPago);
    }

    public VentaFormaPagoPK getVentaFormaPagoPK() {
        return ventaFormaPagoPK;
    }

    public void setVentaFormaPagoPK(VentaFormaPagoPK ventaFormaPagoPK) {
        this.ventaFormaPagoPK = ventaFormaPagoPK;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(FormaPago formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaFormaPagoPK != null ? ventaFormaPagoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaFormaPago)) {
            return false;
        }
        VentaFormaPago other = (VentaFormaPago) object;
        if ((this.ventaFormaPagoPK == null && other.ventaFormaPagoPK != null) || (this.ventaFormaPagoPK != null && !this.ventaFormaPagoPK.equals(other.ventaFormaPagoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.VentaFormaPago[ ventaFormaPagoPK=" + ventaFormaPagoPK + " ]";
    }
    
}
