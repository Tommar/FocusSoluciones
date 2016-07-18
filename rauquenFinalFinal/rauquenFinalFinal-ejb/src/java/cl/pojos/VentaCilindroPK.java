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
public class VentaCilindroPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idventa")
    private int idventa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcilindro")
    private int idcilindro;

    public VentaCilindroPK() {
    }

    public VentaCilindroPK(int idventa, int idcilindro) {
        this.idventa = idventa;
        this.idcilindro = idcilindro;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getIdcilindro() {
        return idcilindro;
    }

    public void setIdcilindro(int idcilindro) {
        this.idcilindro = idcilindro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idventa;
        hash += (int) idcilindro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaCilindroPK)) {
            return false;
        }
        VentaCilindroPK other = (VentaCilindroPK) object;
        if (this.idventa != other.idventa) {
            return false;
        }
        if (this.idcilindro != other.idcilindro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.VentaCilindroPK[ idventa=" + idventa + ", idcilindro=" + idcilindro + " ]";
    }
    
}
