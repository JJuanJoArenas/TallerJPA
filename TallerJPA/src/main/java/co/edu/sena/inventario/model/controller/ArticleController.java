/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.controller;

import co.edu.sena.inventario.model.Article;
import co.edu.sena.inventario.model.persistence.DAOFactory;
import co.edu.sena.inventario.model.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Grupo 6
 */
public class ArticleController implements IArticleController{

    @Override
    public void insert(Article article) throws Exception {
        if(article == null){
            throw new Exception("el articulo es nulo");
        }
        if(article.getIdArticle() == 0){
            throw new Exception("el id del articulo es obligatorio");
        }
        if("".equals(article.getName())){
             throw new Exception("el nombre del articulo es obligatorio");
        }
        if(article.getQuantity() == 0){
              throw new Exception("la cantidad del articulo es obligatoria");
        }
        if("".equals(article.getTechnicalSheet())){
            throw new Exception("la ficha tecnica del articulo es obligatoria");
        }
        // Fk
        if(article.getIdPresentation() == null){
            throw new Exception("el id de la presentacion es obligatorio");
        }
        if(article.getIdCategory() == null){
            throw new Exception("el id de la categoria es obligatorio");
        }
        if(article.getIdSupplier() == null){
            throw new Exception("el id del empleado es obligatorio");
        }
        
        //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getArticledao().insert(article);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Article article) throws Exception {
         if(article == null){
            throw new Exception("el articulo es nulo");
        }
        if(article.getIdArticle() == 0){
            throw new Exception("el id del articulo es obligatorio");
        }
        if("".equals(article.getName())){
             throw new Exception("el nombre del articulo es obligatorio");
        }
        if(article.getQuantity() == 0){
              throw new Exception("la cantidad del articulo es obligatoria");
        }
       
        // Fk
        if(article.getIdPresentation() == null){
            throw new Exception("el id de la presentacion es obligatorio");
        }
        if(article.getIdCategory() == null){
            throw new Exception("el id de la categoria es obligatorio");
        }
       
        // consultar si el articulo existe en la base de datos 
        Article articleExists = DAOFactory.getArticledao().findById(article.getIdArticle());
        if(articleExists == null){
            throw new Exception("el articulo no existe ");
        }
        
        // Merge
        articleExists.setName(article.getName());
        articleExists.setQuantity(article.getQuantity());
        articleExists.setTechnicalSheet(article.getTechnicalSheet());
        articleExists.setIdPresentation(article.getIdPresentation());
        articleExists.setIdCategory(article.getIdCategory());
        articleExists.setIdSupplier(article.getIdSupplier());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getArticledao().update(articleExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public void delete(Long idArticle) throws Exception {
     if (idArticle == 0) {
        throw new Exception("El ID del artículo es obligatorio.");
    }

    // Consultar si el artículo existe en la base de datos
    Article articleExists = DAOFactory.getArticledao().findById(idArticle);
    if (articleExists == null) {
        throw new Exception("El artículo no existe.");
    }

    // Eliminar el artículo
    EntityManagerHelper.beginTransaction();
    DAOFactory.getArticledao().delete(articleExists);
    EntityManagerHelper.commit();
    EntityManagerHelper.closeEntityManager();

    }

    @Override
    public List<Article> findAll() throws Exception {
      return DAOFactory.getArticledao().findAll();
    }

    @Override
    public Article findById(Long idArticle) throws Exception {
         if(idArticle == 0){
         throw new Exception("el id del articulo es obligatorio");  
           }
     
      Article articleExists = DAOFactory.getArticledao().findById(idArticle);
        if(articleExists == null){
            throw new Exception("el articulo no existe ");
        }
        return DAOFactory.getArticledao().findById(idArticle);
    }
    
}
