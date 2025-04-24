/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.controller;


import co.edu.sena.inventario.model.Person;
import java.util.List;

/**
 *
 * @author Grupo 6
 */
public interface IPerson {
    public void insert(Person person) throws Exception;
    public void update(Person person) throws Exception;
    public void delete(Long  document) throws Exception;
    public List<Person> findAll() throws Exception;
    public Person findById(Long  document) throws Exception;
}
