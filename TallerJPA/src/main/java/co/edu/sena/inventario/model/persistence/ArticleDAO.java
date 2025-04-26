/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Article;
import co.edu.sena.inventario.model.Category;
import co.edu.sena.inventario.model.Presentation;
import co.edu.sena.inventario.model.Supplier;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class ArticleDAO implements IArticleDAO{

    @Override
    public void insert(Article article) throws Exception {
       try {
        EntityManager em = EntityManagerHelper.getEntityManager();
        
        // Buscar las entidades relacionadas si no son null
        if (article.getIdCategory() != null && article.getIdCategory().getIdCategory() != null) {
            Category managedCategory = em.find(Category.class, article.getIdCategory().getIdCategory());
            article.setIdCategory(managedCategory);
        }
        
        if (article.getIdPresentation() != null && article.getIdPresentation().getIdPresentation() != null) {
            Presentation managedPresentation = em.find(Presentation.class, article.getIdPresentation().getIdPresentation());
            article.setIdPresentation(managedPresentation);
        }
        
        if (article.getIdSupplier() != null && article.getIdSupplier().getIdUnit()!= null) {
            Supplier managedSupplier = em.find(Supplier.class, article.getIdSupplier().getIdUnit());
            article.setIdSupplier(managedSupplier);
        }
        
        // Ahora sí puedes persistir
        em.persist(article);
    } catch (Exception e) {
        throw e;
    }
    }

    @Override
    public void update(Article article) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(article);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Article article) throws Exception {
        try {
             EntityManagerHelper.getEntityManager().remove(article);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Article findById(Long id) throws Exception {
        try {
             return EntityManagerHelper.getEntityManager().find(Article.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Article> findAll() throws Exception {
        try {
             Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Article.findAll");
                return query.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
