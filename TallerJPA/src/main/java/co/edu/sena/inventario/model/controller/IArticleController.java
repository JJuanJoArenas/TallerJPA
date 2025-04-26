/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.controller;

import co.edu.sena.inventario.model.Article;
import java.util.List;

/**
 *
 * @author Grupo 6
 */
public interface IArticleController {
    public void insert(Article article) throws Exception;
    public void update(Article article) throws Exception;
    public void delete(Long  idArticle) throws Exception;
    public List<Article> findAll() throws Exception;
    public Article findById(Long  idArticle) throws Exception;
    
}
