/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "entry")
@NamedQueries({
    @NamedQuery(name = "Entry.findAll", query = "SELECT e FROM Entry e"),
    @NamedQuery(name = "Entry.findByIdEntry", query = "SELECT e FROM Entry e WHERE e.idEntry = :idEntry"),
    @NamedQuery(name = "Entry.findBySenaCode", query = "SELECT e FROM Entry e WHERE e.senaCode = :senaCode"),
    @NamedQuery(name = "Entry.findByDate", query = "SELECT e FROM Entry e WHERE e.date = :date"),
    @NamedQuery(name = "Entry.findByExpirationDate", query = "SELECT e FROM Entry e WHERE e.expirationDate = :expirationDate"),
    @NamedQuery(name = "Entry.findByQuantity", query = "SELECT e FROM Entry e WHERE e.quantity = :quantity")})
public class Entry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_entry")
    private Long idEntry;
    @Column(name = "sena_code")
    private String senaCode;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Lob
    @Column(name = "observations")
    private String observations;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article")
    @ManyToOne(optional = false)
    private Article idArticle;

    public Entry() {
    }

    public Entry(Long idEntry) {
        this.idEntry = idEntry;
    }

    public Entry(Long idEntry, Date date, int quantity) {
        this.idEntry = idEntry;
        this.date = date;
        this.quantity = quantity;
    }

    public Long getIdEntry() {
        return idEntry;
    }

    public void setIdEntry(Long idEntry) {
        this.idEntry = idEntry;
    }

    public String getSenaCode() {
        return senaCode;
    }

    public void setSenaCode(String senaCode) {
        this.senaCode = senaCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntry != null ? idEntry.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entry)) {
            return false;
        }
        Entry other = (Entry) object;
        if ((this.idEntry == null && other.idEntry != null) || (this.idEntry != null && !this.idEntry.equals(other.idEntry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.inventario.model.Entry[ idEntry=" + idEntry + " ]";
    }
    
}
