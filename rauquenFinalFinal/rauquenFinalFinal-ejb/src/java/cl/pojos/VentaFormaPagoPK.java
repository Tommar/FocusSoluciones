/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Embeddable
public class VentaFormaPagoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idventa")
    private int idventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idforma_pago")
    private int idformaPago;

    public VentaFormaPagoPK() {
    }

    public VentaFormaPagoPK(int idventa, int idformaPago) {
        this.idventa = idventa;
        this.idformaPago = idformaPago;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdformaPago() {
        return idformaPago;
    }

    public void setIdformaPago(int idformaPago) {
        this.idformaPago = idformaPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idventa;
        hash += (int) idformaPago;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaFormaPagoPK)) {
            return false;
        }
        VentaFormaPagoPK other = (VentaFormaPagoPK) object;
        if (this.idventa != other.idventa) {
            return false;
        }
        if (this.idformaPago != other.idformaPago) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.VentaFormaPagoPK[ idventa=" + idventa + ", idformaPago=" + idformaPago + " ]";
    }
    
}
