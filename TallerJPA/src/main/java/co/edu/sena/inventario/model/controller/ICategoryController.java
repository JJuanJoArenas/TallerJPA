/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.controller;

import co.edu.sena.inventario.model.Category;
import java.util.List;

/**
 *
 * @author Grupo 6
 */
public interface ICategoryController {
     public void insert(Category category) throws Exception;
    public void update(Category category) throws Exception;
    public void delete(Long  idCategory) throws Exception;
    public List<Category> findAll() throws Exception;
    public Category findById(Long  idCategory) throws Exception;
}
