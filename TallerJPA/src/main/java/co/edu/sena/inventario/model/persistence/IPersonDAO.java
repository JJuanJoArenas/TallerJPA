/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Person;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IPersonDAO {
      public void insert (Person person) throws Exception;
        public void update (Person person) throws Exception;
        public void delete (Person person) throws Exception;
        public Person findById(Long document) throws Exception;
        public List<Person> findAll() throws Exception;
}
