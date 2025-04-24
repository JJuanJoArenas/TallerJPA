/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Supplier;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class SupplierDAO implements ISupplierDAO{

    @Override
    public void insert(Supplier supplier) throws Exception {
        try {
               EntityManagerHelper.getEntityManager().persist(supplier);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(Supplier supplier) throws Exception {
        try {
             EntityManagerHelper.getEntityManager().merge(supplier);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Supplier supplier) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(supplier);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Supplier findById(Long id) throws Exception {
        try {
             return EntityManagerHelper.getEntityManager().find(Supplier.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Supplier> findAll() throws Exception {
        try {
                Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Supplier.findAll");
                return query.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
