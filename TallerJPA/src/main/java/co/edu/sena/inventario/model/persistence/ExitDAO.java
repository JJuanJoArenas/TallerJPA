/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Exit;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class ExitDAO implements IExitDAO{

    @Override
    public void insert(Exit exit) throws Exception {
        try {
                EntityManagerHelper.getEntityManager().persist(exit);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(Exit exit) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().merge(exit);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Exit exit) throws Exception {
        try {
            EntityManagerHelper.getEntityManager().remove(exit);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Exit findById(Long id) throws Exception {
        try {
            return EntityManagerHelper.getEntityManager().find(Exit.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Exit> findAll() throws Exception {
        try {
                  Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Exit.findAll");
                return query.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
