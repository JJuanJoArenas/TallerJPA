/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Entry;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Aprendiz
 */
public class EntryDAO implements IEntryDAO {

    @Override
    public void insert(Entry entry) throws Exception {
        try {
                EntityManagerHelper.getEntityManager().persist(entry);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(Entry entry) throws Exception {
        try {
                EntityManagerHelper.getEntityManager().merge(entry);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Entry entry) throws Exception {
        try {
                EntityManagerHelper.getEntityManager().remove(entry);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Entry findById(Long id) throws Exception {
        try {
                return EntityManagerHelper.getEntityManager().find(Entry.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Entry> findAll() throws Exception {
        try {
                  Query query = EntityManagerHelper.getEntityManager().createNamedQuery("Entry.findAll");
                return query.getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

}
