/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Article;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class ArticleDAO implements IArticleDAO{

    @Override
    public void insert(Article article) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(article);
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
