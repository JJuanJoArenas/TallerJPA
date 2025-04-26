/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.controller;

import co.edu.sena.inventario.model.Exit;
import co.edu.sena.inventario.model.persistence.DAOFactory;
import co.edu.sena.inventario.model.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class ExitController implements IExitController{

    @Override
    public void insert(Exit exit) throws Exception {
        if(exit == null){
            throw new Exception("la salida es nula");
        }
        if(exit.getIdExit() == 0){
            throw new Exception("el id es obligatorio");
        }
        if(exit.getDate() == null){
            throw new Exception("la fecha es obligatoria");
        }
        if(exit.getQuantity() < 1){
             throw new Exception("la cantidad es obligatoria");
        }
        if("".equals(exit.getObservations())){
             throw new Exception("la observacion es obligatoria");
        }
        
        if(exit.getIdArticle() == null){
            throw new Exception("el id del articulo es obligatorio");
        }
        if(exit.getDocument() == null){
            throw new Exception("el articulo es obligatorio");
        }
        if(exit.getIdUnit() == null){
            throw new Exception("la unidad es obligatoria");
        }
        
          //insertar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getExitdao().insert(exit);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Exit exit) throws Exception {
         if(exit == null){
            throw new Exception("la salida es nula");
        }
        if(exit.getIdExit() == 0){
            throw new Exception("el id es obligatorio");
        }
        if(exit.getDate() == null){
            throw new Exception("la fecha es obligatoria");
        }
        if(exit.getQuantity() < 1){
             throw new Exception("la cantidad es obligatoria");
        }
        if("".equals(exit.getObservations())){
             throw new Exception("la observacion es obligatoria");
        }
        
        if(exit.getIdArticle() == null){
            throw new Exception("el id del articulo es obligatorio");
        }
        if(exit.getDocument() == null){
            throw new Exception("el articulo es obligatorio");
        }
        if(exit.getIdUnit() == null){
            throw new Exception("la unidad es obligatoria");
        }
        
        Exit exitExists = DAOFactory.getExitdao().findById(exit.getIdExit());
        if(exitExists == null){
              throw new Exception("la salida no existe");
        }
        
        
          //update
          exitExists.setDate(exit.getDate());
          exitExists.setQuantity(exit.getQuantity());
          exitExists.setObservations(exit.getObservations());
          exitExists.setIdArticle(exit.getIdArticle());
          exitExists.setDocument(exit.getDocument());
          exitExists.setIdUnit(exit.getIdUnit());
          
        EntityManagerHelper.beginTransaction();
        DAOFactory.getExitdao().update(exitExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long idExit) throws Exception {
       if(idExit == 0){
           throw new Exception("el id es obligatorio");
       }
         Exit exitExists = DAOFactory.getExitdao().findById(idExit);
        if(exitExists == null){
              throw new Exception("la salida no existe");
        }
        //Eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getExitdao().delete(exitExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Exit> findAll() throws Exception {
      return DAOFactory.getExitdao().findAll();
    }

    @Override
    public Exit findById(Long idExit) throws Exception {
        if(idExit == 0){
           throw new Exception("el id es obligatorio");
       }
         Exit exitExists = DAOFactory.getExitdao().findById(idExit);
        if(exitExists == null){
              throw new Exception("la salida no existe");
        }
        return DAOFactory.getExitdao().findById(idExit);
    }
    
}
