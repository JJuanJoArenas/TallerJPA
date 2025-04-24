/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.controller;

import co.edu.sena.inventario.model.Person;
import co.edu.sena.inventario.model.persistence.DAOFactory;
import co.edu.sena.inventario.model.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class PersonController implements  IPerson{

    @Override
    public void insert(Person person) throws Exception {
        if(person == null){
            throw new Exception("la persona es nula");
        }
        if("".equals(person.getPhone())){
              throw new Exception("el telefono es obligatorio");
        }
        if("".equals(person.getName())){
             throw new Exception("el nombre es obligatorio");
        }
        
        Person personExists = DAOFactory.getPersondao().findById(person.getDocument());
        if(personExists != null){
            throw new Exception("ya existe una persona con ese documento");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPersondao().insert(person);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Person person) throws Exception {
       if(person == null){
            throw new Exception("la persona es nula");
        }
        if("".equals(person.getPhone())){
              throw new Exception("el telefono es obligatorio");
        }
        if("".equals(person.getName())){
             throw new Exception("el nombre es obligatorio");
        }
        
        Person personExists = DAOFactory.getPersondao().findById(person.getDocument());
        if(personExists != null){
            throw new Exception("ya existe una persona con ese documento");
        }
        
        personExists.setPhone(person.getPhone());
        personExists.setName(person.getName());
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPersondao().update(person);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long document) throws Exception {
        if(document == 0){
             throw new Exception("el documento es obligatorio");
        }
        Person personExists = DAOFactory.getPersondao().findById(document);
        if(personExists != null){
            throw new Exception("la persona no existe");
        }
        EntityManagerHelper.beginTransaction();
        DAOFactory.getPersondao().delete(personExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Person> findAll() throws Exception {
        return DAOFactory.getPersondao().findAll();
    }

    @Override
    public Person findById(Long document) throws Exception {
          if(document == 0){
             throw new Exception("el documento es obligatorio");
        }
        Person personExists = DAOFactory.getPersondao().findById(document);
        if(personExists != null){
            throw new Exception("la persona no existe");
        }
        return  DAOFactory.getPersondao().findById(document);
    }
    
}
