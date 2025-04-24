/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.controller;


import co.edu.sena.inventario.model.Exit;
import java.util.List;

/**
 *
 * @author Grupo 6
 */
public interface IExit {
     public void insert(Exit exit) throws Exception;
    public void update(Exit exit) throws Exception;
    public void delete(Long  idExit) throws Exception;
    public List<Exit> findAll() throws Exception;
    public Exit findById(Long  idExit) throws Exception;
}
