/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Entity
@Table(name = "camion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camion.findAll", query = "SELECT c FROM Camion c"),
    @NamedQuery(name = "Camion.findByIdcamion", query = "SELECT c FROM Camion c WHERE c.idcamion = :idcamion"),
    @NamedQuery(name = "Camion.findByKm", query = "SELECT c FROM Camion c WHERE c.km = :km")})
public class Camion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "idcamion")
    private String idcamion;
    @Column(name = "km")
    private Integer km;
    @JoinColumn(name = "idsucursal", referencedColumnName = "idsucursal")
    @ManyToOne
    private Sucursal idsucursal;
    @OneToMany(mappedBy = "idcamion")
    private List<Carga> cargaList;
    @OneToMany(mappedBy = "idcamion")
    private List<Descarga> descargaList;

    public Camion() {
    }

    public Camion(String idcamion) {
        this.idcamion = idcamion;
    }

    public String getIdcamion() {
        return idcamion;
    }

    public void setIdcamion(String idcamion) {
        this.idcamion = idcamion;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Sucursal getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(Sucursal idsucursal) {
        this.idsucursal = idsucursal;
    }

    @XmlTransient
    public List<Carga> getCargaList() {
        return cargaList;
    }

    public void setCargaList(List<Carga> cargaList) {
        this.cargaList = cargaList;
    }

    @XmlTransient
    public List<Descarga> getDescargaList() {
        return descargaList;
    }

    public void setDescargaList(List<Descarga> descargaList) {
        this.descargaList = descargaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcamion != null ? idcamion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camion)) {
            return false;
        }
        Camion other = (Camion) object;
        if ((this.idcamion == null && other.idcamion != null) || (this.idcamion != null && !this.idcamion.equals(other.idcamion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Camion[ idcamion=" + idcamion + " ]";
    }
    
}
