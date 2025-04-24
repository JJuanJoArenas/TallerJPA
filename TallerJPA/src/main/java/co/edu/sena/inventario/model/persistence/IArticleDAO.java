/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Article;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IArticleDAO {
        public void insert (Article article) throws Exception;
        public void update (Article article) throws Exception;
        public void delete (Article article) throws Exception;
        public Article findById(Long id) throws Exception;
        public List<Article> findAll() throws Exception;
}
