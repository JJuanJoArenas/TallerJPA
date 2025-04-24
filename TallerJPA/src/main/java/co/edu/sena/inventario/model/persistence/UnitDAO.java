/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Unit;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class UnitDAO implements IUnitDAO{

    @Override
    public void insert(Unit unit) throws Exception {
        try {
             EntityManagerHelper.getEntityManager().persist(unit);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(Unit unit) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(unit);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Unit unit) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(unit);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Unit findById(Long id) throws Exception {
        try {
             return EntityManagerHelper.getEntityManager().find(Unit.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Unit> findAll() throws Exception {
        try {
            Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Unit.findAll");
                return query.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }
    
}
