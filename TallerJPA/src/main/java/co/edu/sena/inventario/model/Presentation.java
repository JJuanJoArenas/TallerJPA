/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "presentation")
@NamedQueries({
    @NamedQuery(name = "Presentation.findAll", query = "SELECT p FROM Presentation p"),
    @NamedQuery(name = "Presentation.findByIdPresentation", query = "SELECT p FROM Presentation p WHERE p.idPresentation = :idPresentation"),
    @NamedQuery(name = "Presentation.findByDescription", query = "SELECT p FROM Presentation p WHERE p.description = :description")})
public class Presentation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_presentation")
    private Long idPresentation;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "idPresentation")
    private Collection<Article> articleCollection;

    public Presentation() {
    }

    public Presentation(Long idPresentation) {
        this.idPresentation = idPresentation;
    }

    public Presentation(Long idPresentation, String description) {
        this.idPresentation = idPresentation;
        this.description = description;
    }

    public Long getIdPresentation() {
        return idPresentation;
    }

    public void setIdPresentation(Long idPresentation) {
        this.idPresentation = idPresentation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresentation != null ? idPresentation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presentation)) {
            return false;
        }
        Presentation other = (Presentation) object;
        if ((this.idPresentation == null && other.idPresentation != null) || (this.idPresentation != null && !this.idPresentation.equals(other.idPresentation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.inventario.model.Presentation[ idPresentation=" + idPresentation + " ]";
    }
    
}
