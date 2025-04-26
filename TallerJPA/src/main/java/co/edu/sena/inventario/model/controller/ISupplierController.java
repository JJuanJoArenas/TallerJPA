/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.controller;


import co.edu.sena.inventario.model.Supplier;
import java.util.List;

/**
 *
 * @autho Grupo 6
 */
public interface ISupplierController {
    public void insert(Supplier supplier) throws Exception;
    public void update(Supplier supplier) throws Exception;
    public void delete(Long  idUnit) throws Exception;
    public List<Supplier> findAll() throws Exception;
    public Supplier findById(Long  idUnit) throws Exception;
}
