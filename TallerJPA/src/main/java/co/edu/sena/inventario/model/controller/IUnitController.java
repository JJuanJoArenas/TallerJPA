/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.controller;


import co.edu.sena.inventario.model.Unit;
import java.util.List;

/**
 *
 * @author Grupo 6
 */
public interface IUnitController {
     public void insert(Unit unit) throws Exception;
    public void update(Unit unit) throws Exception;
    public void delete(Long  idUnit) throws Exception;
    public List<Unit> findAll() throws Exception;
    public Unit findById(Long  idUnit) throws Exception;
}
