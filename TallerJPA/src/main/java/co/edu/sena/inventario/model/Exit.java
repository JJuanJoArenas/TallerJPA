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
@Table(name = "`exit´")
@NamedQueries({
    @NamedQuery(name = "Exit.findAll", query = "SELECT e FROM Exit e"),
    @NamedQuery(name = "Exit.findByIdExit", query = "SELECT e FROM Exit e WHERE e.idExit = :idExit"),
    @NamedQuery(name = "Exit.findByDate", query = "SELECT e FROM Exit e WHERE e.date = :date"),
    @NamedQuery(name = "Exit.findByQuantity", query = "SELECT e FROM Exit e WHERE e.quantity = :quantity")})
     @NamedQuery(name = "Exit.findByIdArticle", query = "SELECT e FROM Exit e WHERE e.idArticle = :idArticle")
public class Exit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_exit")
    private Long idExit;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Lob
    @Column(name = "observations")
    private String observations;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article")
    @ManyToOne(optional = false)
    private Article idArticle;
    @JoinColumn(name = "document", referencedColumnName = "document")
    @ManyToOne(optional = false)
    private Person document;
    @JoinColumn(name = "id_unit", referencedColumnName = "id_unit")
    @ManyToOne(optional = false)
    private Unit idUnit;

    public Exit() {
    }

    public Exit(Long idExit) {
        this.idExit = idExit;
    }

    public Exit(Long idExit, Date date, int quantity) {
        this.idExit = idExit;
        this.date = date;
        this.quantity = quantity;
    }

    public Long getIdExit() {
        return idExit;
    }

    public void setIdExit(Long idExit) {
        this.idExit = idExit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Person getDocument() {
        return document;
    }

    public void setDocument(Person document) {
        this.document = document;
    }

    public Unit getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(Unit idUnit) {
        this.idUnit = idUnit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idExit != null ? idExit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exit)) {
            return false;
        }
        Exit other = (Exit) object;
        if ((this.idExit == null && other.idExit != null) || (this.idExit != null && !this.idExit.equals(other.idExit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.inventario.model.Exit[ idExit=" + idExit + " ]";
    }

}
