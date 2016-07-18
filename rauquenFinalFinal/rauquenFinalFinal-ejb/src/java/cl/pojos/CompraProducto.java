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
@Table(name = "compra_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompraProducto.findAll", query = "SELECT c FROM CompraProducto c"),
    @NamedQuery(name = "CompraProducto.findByIdcompra", query = "SELECT c FROM CompraProducto c WHERE c.compraProductoPK.idcompra = :idcompra"),
    @NamedQuery(name = "CompraProducto.findByIdproducto", query = "SELECT c FROM CompraProducto c WHERE c.compraProductoPK.idproducto = :idproducto"),
    @NamedQuery(name = "CompraProducto.findByCantidad", query = "SELECT c FROM CompraProducto c WHERE c.cantidad = :cantidad"),
    @NamedQuery(name = "CompraProducto.findByPrecio", query = "SELECT c FROM CompraProducto c WHERE c.precio = :precio")})
public class CompraProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompraProductoPK compraProductoPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio")
    private Integer precio;
    @JoinColumn(name = "idcompra", referencedColumnName = "idcompra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compra compra;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;

    public CompraProducto() {
    }

    public CompraProducto(CompraProductoPK compraProductoPK) {
        this.compraProductoPK = compraProductoPK;
    }

    public CompraProducto(int idcompra, int idproducto) {
        this.compraProductoPK = new CompraProductoPK(idcompra, idproducto);
    }

    public CompraProductoPK getCompraProductoPK() {
        return compraProductoPK;
    }

    public void setCompraProductoPK(CompraProductoPK compraProductoPK) {
        this.compraProductoPK = compraProductoPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraProductoPK != null ? compraProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraProducto)) {
            return false;
        }
        CompraProducto other = (CompraProducto) object;
        if ((this.compraProductoPK == null && other.compraProductoPK != null) || (this.compraProductoPK != null && !this.compraProductoPK.equals(other.compraProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.CompraProducto[ compraProductoPK=" + compraProductoPK + " ]";
    }
    
}
