/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.controller;

import co.edu.sena.inventario.model.Category;
import co.edu.sena.inventario.model.persistence.DAOFactory;
import co.edu.sena.inventario.model.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class CategoryController implements ICategoryController{

    @Override
    public void insert(Category category) throws Exception {
       if(category == null){
            throw new Exception("la categoria es nula");
        }
        if(category.getIdCategory() == 0){
            throw new Exception("el id de la categoria es obligatorio");
        }
        if("".equals(category.getName())){
             throw new Exception("el nombre de la categoria es obligatorio");
        }
        if("".equals(category.getDescription())){
              throw new Exception("la descripcion de la categoria es obligatoria");
        }
        
           //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategorydao().insert(category);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Category category) throws Exception {
      if(category == null){
            throw new Exception("la categoria es nula");
        }
        if(category.getIdCategory() == 0){
            throw new Exception("el id de la categoria es obligatorio");
        }
        if("".equals(category.getName())){
             throw new Exception("el nombre de la categoria es obligatorio");
        }
        if("".equals(category.getDescription())){
              throw new Exception("la descripcion de la categoria es obligatoria");
        }
        
           //insertar
           
           Category categoryExists = DAOFactory.getCategorydao().findById(category.getIdCategory());
           if(categoryExists == null){
                throw new Exception("la categoria no existe");
           }
           categoryExists.setIdCategory(category.getIdCategory());
           categoryExists.setName(category.getName());
           categoryExists.setDescription(category.getDescription());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getCategorydao().update(category);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long idCategory) throws Exception {
        if(idCategory == 0){
            throw new Exception("el id de la cetgoria es obligatoria");
        }
        
          Category categoryExists = DAOFactory.getCategorydao().findById(idCategory);
           if(categoryExists == null){
                throw new Exception("la categoria no existe");
           }
           
            EntityManagerHelper.beginTransaction();
        DAOFactory.getCategorydao().delete(categoryExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Category> findAll() throws Exception {
        return DAOFactory.getCategorydao().findAll();
    }

    @Override
    public Category findById(Long idCategory) throws Exception {
        if(idCategory == 0){
             throw new Exception("la categoria no existe");
        }
        return DAOFactory.getCategorydao().findById(idCategory);
    }
    
}
