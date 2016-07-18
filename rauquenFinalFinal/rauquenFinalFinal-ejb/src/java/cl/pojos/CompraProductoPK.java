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
public class CompraProductoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idcompra")
    private int idcompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idproducto")
    private int idproducto;

    public CompraProductoPK() {
    }

    public CompraProductoPK(int idcompra, int idproducto) {
        this.idcompra = idcompra;
        this.idproducto = idproducto;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcompra;
        hash += (int) idproducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraProductoPK)) {
            return false;
        }
        CompraProductoPK other = (CompraProductoPK) object;
        if (this.idcompra != other.idcompra) {
            return false;
        }
        if (this.idproducto != other.idproducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.CompraProductoPK[ idcompra=" + idcompra + ", idproducto=" + idproducto + " ]";
    }
    
}
