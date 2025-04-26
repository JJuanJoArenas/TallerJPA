/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.controller;


import co.edu.sena.inventario.model.Presentation;
import java.util.List;

/**
 *
 * @author Grupo 6
 */
public interface IPresentationController {
    public void insert(Presentation presentation) throws Exception;
    public void update(Presentation presentation) throws Exception;
    public void delete(Long  idPresentation) throws Exception;
    public List<Presentation> findAll() throws Exception;
    public Presentation findById(Long  idPresentation) throws Exception;
}
