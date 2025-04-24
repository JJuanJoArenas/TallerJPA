/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Category;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class CategoryDAO implements ICategoryDAO{

    @Override
    public void insert(Category category) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().persist(category);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(Category category) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(category);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Category category) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(category);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Category findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Category.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Category> findAll() throws Exception {
        try {
              Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Category.findAll");
                return query.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
