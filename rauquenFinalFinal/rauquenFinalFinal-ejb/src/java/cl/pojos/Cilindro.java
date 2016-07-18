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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cilindro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cilindro.findAll", query = "SELECT c FROM Cilindro c"),
    @NamedQuery(name = "Cilindro.findByIdcilindro", query = "SELECT c FROM Cilindro c WHERE c.idcilindro = :idcilindro"),
    @NamedQuery(name = "Cilindro.findByTipo", query = "SELECT c FROM Cilindro c WHERE c.tipo = :tipo"),
    @NamedQuery(name = "Cilindro.findByCapacidad", query = "SELECT c FROM Cilindro c WHERE c.capacidad = :capacidad"),
    @NamedQuery(name = "Cilindro.findByStockMin", query = "SELECT c FROM Cilindro c WHERE c.stockMin = :stockMin"),
    @NamedQuery(name = "Cilindro.findByStockMax", query = "SELECT c FROM Cilindro c WHERE c.stockMax = :stockMax"),
    @NamedQuery(name = "Cilindro.findByStockActual", query = "SELECT c FROM Cilindro c WHERE c.stockActual = :stockActual")})
public class Cilindro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcilindro")
    private Integer idcilindro;
    @Size(max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "capacidad")
    private Integer capacidad;
    @Column(name = "stock_min")
    private Integer stockMin;
    @Column(name = "stock_max")
    private Integer stockMax;
    @Column(name = "stock_actual")
    private Integer stockActual;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cilindro")
    private List<VentaCilindro> ventaCilindroList;
    @JoinColumn(name = "idprecio_cilindro", referencedColumnName = "idprecio_cilindro")
    @ManyToOne
    private PrecioCilindro idprecioCilindro;

    public Cilindro() {
    }

    public Cilindro(Integer idcilindro) {
        this.idcilindro = idcilindro;
    }

    public Integer getIdcilindro() {
        return idcilindro;
    }

    public void setIdcilindro(Integer idcilindro) {
        this.idcilindro = idcilindro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getStockMin() {
        return stockMin;
    }

    public void setStockMin(Integer stockMin) {
        this.stockMin = stockMin;
    }

    public Integer getStockMax() {
        return stockMax;
    }

    public void setStockMax(Integer stockMax) {
        this.stockMax = stockMax;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    @XmlTransient
    public List<VentaCilindro> getVentaCilindroList() {
        return ventaCilindroList;
    }

    public void setVentaCilindroList(List<VentaCilindro> ventaCilindroList) {
        this.ventaCilindroList = ventaCilindroList;
    }

    public PrecioCilindro getIdprecioCilindro() {
        return idprecioCilindro;
    }

    public void setIdprecioCilindro(PrecioCilindro idprecioCilindro) {
        this.idprecioCilindro = idprecioCilindro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcilindro != null ? idcilindro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cilindro)) {
            return false;
        }
        Cilindro other = (Cilindro) object;
        if ((this.idcilindro == null && other.idcilindro != null) || (this.idcilindro != null && !this.idcilindro.equals(other.idcilindro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Cilindro[ idcilindro=" + idcilindro + " ]";
    }
    
}
