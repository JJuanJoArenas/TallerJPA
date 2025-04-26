/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.controller;

import co.edu.sena.inventario.model.Presentation;
import co.edu.sena.inventario.model.persistence.DAOFactory;
import co.edu.sena.inventario.model.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class PresentationController implements IPresentationController{

    @Override
    public void insert(Presentation presentation) throws Exception {
        if(presentation == null){
            throw new Exception("La presentacion es nula");
        }
        
        if("".equals(presentation.getDescription())){
            throw  new Exception("La descripción es obligatoria");
        }
        
         EntityManagerHelper.beginTransaction();
        DAOFactory.getPresentationdao().insert(presentation);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Presentation presentation) throws Exception {
        if(presentation == null){
            throw new Exception("La presentacion es nula");
        }
        if("".equals(presentation.getDescription())){
            throw  new  Exception("La descripción es obligatoria");
        }
          Presentation presentationExists = DAOFactory.getPresentationdao().findById(presentation.getIdPresentation());
        if (presentationExists == null) {
            throw new Exception("El tipo de presentación no existe");
        }
        
         EntityManagerHelper.beginTransaction();
        DAOFactory.getPresentationdao().update(presentation);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    
    }

    @Override
    public void delete(Long idPresentation) throws Exception {
        if (idPresentation == 0) {
            throw new Exception("El id es obligatorio");
        }
        
        Presentation presentationExists = DAOFactory.getPresentationdao().findById(idPresentation);
        if(presentationExists == null){
            throw new Exception("La presentacion no existe");
        }
        
       EntityManagerHelper.beginTransaction();
        DAOFactory.getPresentationdao().delete(presentationExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        
    }

    @Override
    public List<Presentation> findAll() throws Exception {
        return DAOFactory.getPresentationdao().findAll();
    }

    @Override
    public Presentation findById(Long idPresentation) throws Exception {
         if (idPresentation == 0) {
            throw new Exception("El id es obligatorio");
        }
        return DAOFactory.getPresentationdao().findById(idPresentation);
    }

    
    
}
