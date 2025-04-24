/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "unit")
@NamedQueries({
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u"),
    @NamedQuery(name = "Unit.findByIdUnit", query = "SELECT u FROM Unit u WHERE u.idUnit = :idUnit"),
    @NamedQuery(name = "Unit.findByName", query = "SELECT u FROM Unit u WHERE u.name = :name")})
public class Unit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_unit")
    private Long idUnit;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnit")
    private Collection<Exit> exitCollection;

    public Unit() {
    }

    public Unit(Long idUnit) {
        this.idUnit = idUnit;
    }

    public Unit(Long idUnit, String name) {
        this.idUnit = idUnit;
        this.name = name;
    }

    public Long getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(Long idUnit) {
        this.idUnit = idUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Exit> getExitCollection() {
        return exitCollection;
    }

    public void setExitCollection(Collection<Exit> exitCollection) {
        this.exitCollection = exitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnit != null ? idUnit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.idUnit == null && other.idUnit != null) || (this.idUnit != null && !this.idUnit.equals(other.idUnit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.inventario.model.Unit[ idUnit=" + idUnit + " ]";
    }
    
}
