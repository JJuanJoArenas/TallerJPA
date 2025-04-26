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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Aprendiz
 */
@Entity
@Table(name = "article")
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a"),
    @NamedQuery(name = "Article.findByIdArticle", query = "SELECT a FROM Article a WHERE a.idArticle = :idArticle"),
    @NamedQuery(name = "Article.findByName", query = "SELECT a FROM Article a WHERE a.name = :name"),
    @NamedQuery(name = "Article.findByQuantity", query = "SELECT a FROM Article a WHERE a.quantity = :quantity"),
    @NamedQuery(name = "Article.findByPhoto", query = "SELECT a FROM Article a WHERE a.photo = :photo"),
    @NamedQuery(name = "Article.findByTechnicalSheet", query = "SELECT a FROM Article a WHERE a.technicalSheet = :technicalSheet")})
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_article")
    private Long idArticle;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "photo")
    private String photo;
    @Column(name = "technical_sheet")
    private String technicalSheet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticle")
    private Collection<Entry> entryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArticle")
    private Collection<Exit> exitCollection;
    @JoinColumn(name = "id_category", referencedColumnName = "id_category")
    @ManyToOne 
    private Category idCategory;
    @JoinColumn(name = "id_presentation", referencedColumnName = "id_presentation")
    @ManyToOne 
    private Presentation idPresentation;
    @JoinColumn(name = "id_supplier", referencedColumnName = "id_unit")
    @ManyToOne 
    private Supplier idSupplier;

    public Article() {
    }

    public Article(Long idArticle) {
        this.idArticle = idArticle;
    }

    public Article(Long idArticle, String name, int quantity) {
        this.idArticle = idArticle;
        this.name = name;
        this.quantity = quantity;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTechnicalSheet() {
        return technicalSheet;
    }

    public void setTechnicalSheet(String technicalSheet) {
        this.technicalSheet = technicalSheet;
    }

    public Collection<Entry> getEntryCollection() {
        return entryCollection;
    }

    public void setEntryCollection(Collection<Entry> entryCollection) {
        this.entryCollection = entryCollection;
    }

    public Collection<Exit> getExitCollection() {
        return exitCollection;
    }

    public void setExitCollection(Collection<Exit> exitCollection) {
        this.exitCollection = exitCollection;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public Presentation getIdPresentation() {
        return idPresentation;
    }

    public void setIdPresentation(Presentation idPresentation) {
        this.idPresentation = idPresentation;
    }

    public Supplier getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Supplier idSupplier) {
        this.idSupplier = idSupplier;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticle != null ? idArticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idArticle == null && other.idArticle != null) || (this.idArticle != null && !this.idArticle.equals(other.idArticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.sena.inventario.model.Article[ idArticle=" + idArticle + " ]";
    }
    
}
