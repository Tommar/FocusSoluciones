/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Entity
@Table(name = "precio_cilindro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrecioCilindro.findAll", query = "SELECT p FROM PrecioCilindro p"),
    @NamedQuery(name = "PrecioCilindro.findByIdprecioCilindro", query = "SELECT p FROM PrecioCilindro p WHERE p.idprecioCilindro = :idprecioCilindro"),
    @NamedQuery(name = "PrecioCilindro.findByPrecio", query = "SELECT p FROM PrecioCilindro p WHERE p.precio = :precio"),
    @NamedQuery(name = "PrecioCilindro.findByFecha", query = "SELECT p FROM PrecioCilindro p WHERE p.fecha = :fecha")})
public class PrecioCilindro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idprecio_cilindro")
    private Integer idprecioCilindro;
    @Column(name = "precio")
    private Integer precio;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(mappedBy = "idprecioCilindro")
    private List<Cilindro> cilindroList;

    public PrecioCilindro() {
    }

    public PrecioCilindro(Integer idprecioCilindro) {
        this.idprecioCilindro = idprecioCilindro;
    }

    public Integer getIdprecioCilindro() {
        return idprecioCilindro;
    }

    public void setIdprecioCilindro(Integer idprecioCilindro) {
        this.idprecioCilindro = idprecioCilindro;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<Cilindro> getCilindroList() {
        return cilindroList;
    }

    public void setCilindroList(List<Cilindro> cilindroList) {
        this.cilindroList = cilindroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprecioCilindro != null ? idprecioCilindro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrecioCilindro)) {
            return false;
        }
        PrecioCilindro other = (PrecioCilindro) object;
        if ((this.idprecioCilindro == null && other.idprecioCilindro != null) || (this.idprecioCilindro != null && !this.idprecioCilindro.equals(other.idprecioCilindro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.PrecioCilindro[ idprecioCilindro=" + idprecioCilindro + " ]";
    }
    
}
