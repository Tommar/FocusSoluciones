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
@Table(name = "venta_cilindro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VentaCilindro.findAll", query = "SELECT v FROM VentaCilindro v"),
    @NamedQuery(name = "VentaCilindro.findByIdventa", query = "SELECT v FROM VentaCilindro v WHERE v.ventaCilindroPK.idventa = :idventa"),
    @NamedQuery(name = "VentaCilindro.findByIdcilindro", query = "SELECT v FROM VentaCilindro v WHERE v.ventaCilindroPK.idcilindro = :idcilindro"),
    @NamedQuery(name = "VentaCilindro.findByCantidad", query = "SELECT v FROM VentaCilindro v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "VentaCilindro.findByPrecio", query = "SELECT v FROM VentaCilindro v WHERE v.precio = :precio")})
public class VentaCilindro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentaCilindroPK ventaCilindroPK;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "precio")
    private Integer precio;
    @JoinColumn(name = "idventa", referencedColumnName = "idventa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venta venta;
    @JoinColumn(name = "idcilindro", referencedColumnName = "idcilindro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cilindro cilindro;

    public VentaCilindro() {
    }

    public VentaCilindro(VentaCilindroPK ventaCilindroPK) {
        this.ventaCilindroPK = ventaCilindroPK;
    }

    public VentaCilindro(int idventa, int idcilindro) {
        this.ventaCilindroPK = new VentaCilindroPK(idventa, idcilindro);
    }

    public VentaCilindroPK getVentaCilindroPK() {
        return ventaCilindroPK;
    }

    public void setVentaCilindroPK(VentaCilindroPK ventaCilindroPK) {
        this.ventaCilindroPK = ventaCilindroPK;
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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Cilindro getCilindro() {
        return cilindro;
    }

    public void setCilindro(Cilindro cilindro) {
        this.cilindro = cilindro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventaCilindroPK != null ? ventaCilindroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaCilindro)) {
            return false;
        }
        VentaCilindro other = (VentaCilindro) object;
        if ((this.ventaCilindroPK == null && other.ventaCilindroPK != null) || (this.ventaCilindroPK != null && !this.ventaCilindroPK.equals(other.ventaCilindroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.VentaCilindro[ ventaCilindroPK=" + ventaCilindroPK + " ]";
    }
    
}
