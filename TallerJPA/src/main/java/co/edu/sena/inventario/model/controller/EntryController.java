/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.controller;

import co.edu.sena.inventario.model.Entry;
import co.edu.sena.inventario.model.persistence.DAOFactory;
import co.edu.sena.inventario.model.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class EntryController implements IEntry {

    @Override
    public void insert(Entry entry) throws Exception {
      if(entry == null){
          throw new Exception("la entrada es nula");
      }
      if(entry.getIdEntry() == 0){
           throw new Exception("el id es obligatorio");
      }
      if("".equals(entry.getSenaCode())){
            throw new Exception("el codigo sena  es obligatorio");
      }
      if(entry.getDate() == null){
            throw new Exception("la fecha es obligatoria");
      }
      if(entry.getExpirationDate() == null){
          throw new Exception("la fecha de expiracion es obligatoria");
      }
      if(entry.getQuantity() < 1){
           throw new Exception("la cantidad debe ser positiva");
      }
      if("".equals(entry.getObservations())){
            throw new Exception("la observacion es obligatoria");
      }
      //FK
      if(entry.getIdArticle() == null){
          throw new Exception("el id del articulo es obligatorio");
      }
      
      EntityManagerHelper.beginTransaction();
        DAOFactory.getEntrydao().insert(entry);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Entry entry) throws Exception {
       if(entry == null){
          throw new Exception("la entrada es nula");
      }
      if(entry.getIdEntry() == 0){
           throw new Exception("el id es obligatorio");
      }
      if("".equals(entry.getSenaCode())){
            throw new Exception("el codigo sena  es obligatorio");
      }
      if(entry.getDate() == null){
            throw new Exception("la fecha es obligatoria");
      }
      if(entry.getExpirationDate() == null){
          throw new Exception("la fecha de expiracion es obligatoria");
      }
      if(entry.getQuantity() == 0){
           throw new Exception("la cantidad es obligatoria");
      }
      if("".equals(entry.getObservations())){
            throw new Exception("la observacion es obligatoria");
      }
      //FK
      if(entry.getIdArticle() == null){
          throw new Exception("el id del articulo es obligatorio");
      }
      
       Entry entryExists = DAOFactory.getEntrydao().findById(entry.getIdEntry());
       if(entryExists == null){
             throw new Exception("la entrada no existe");
       }
      entryExists.setSenaCode(entry.getSenaCode());
      entryExists.setDate(entry.getDate());
      entryExists.setExpirationDate(entry.getExpirationDate());
      entryExists.setQuantity((int)entry.getQuantity());
      entryExists.setObservations(entry.getObservations());
      entryExists.setIdArticle(entry.getIdArticle());
      
      EntityManagerHelper.beginTransaction();
        DAOFactory.getEntrydao().update(entry);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long idEntry) throws Exception {
      if(idEntry == 0){
          throw new Exception("el id de la entrada no existe");
      }
      Entry entryExists = DAOFactory.getEntrydao().findById(idEntry);
       if(entryExists == null){
             throw new Exception("la entrada no existe");
       }
       EntityManagerHelper.beginTransaction();
        DAOFactory.getEntrydao().delete(entryExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Entry> findAll() throws Exception {
     return DAOFactory.getEntrydao().findAll();
    }

    @Override
    public Entry findById(Long idEntry) throws Exception {
         if(idEntry == 0){
          throw new Exception("el id de la entrada no existe");
      }
      Entry entryExists = DAOFactory.getEntrydao().findById(idEntry);
       if(entryExists == null){
             throw new Exception("la entrada no existe");
       }
      return DAOFactory.getEntrydao().findById(idEntry);
    }
    
}
