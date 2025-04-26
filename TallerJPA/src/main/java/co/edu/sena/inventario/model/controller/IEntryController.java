/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.controller;

import co.edu.sena.inventario.model.Entry;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IEntryController {
     public void insert(Entry entry) throws Exception;
    public void update(Entry entry) throws Exception;
    public void delete(Long  idEntry) throws Exception;
    public List<Entry> findAll() throws Exception;
    public Entry findById(Long  idEntry) throws Exception;
}
