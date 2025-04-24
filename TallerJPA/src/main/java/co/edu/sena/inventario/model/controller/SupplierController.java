/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.controller;

import co.edu.sena.inventario.model.Supplier;
import co.edu.sena.inventario.model.persistence.DAOFactory;
import co.edu.sena.inventario.model.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public class SupplierController implements ISupplier{

    @Override
    public void insert(Supplier supplier) throws Exception {
        if (supplier == null){
            throw  new Exception("El proveedor es nulo");
        }
        
        if(supplier.getIdUnit() == 0) {
            throw new Exception("El id es obligatorio");
        }
        
        if("".equals(supplier.getName())){
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(supplier.getPhone())){
            throw new Exception("El telefono es obligatorio");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getSupplierdao().insert(supplier);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Supplier supplier) throws Exception {
        if(supplier == null){
            throw new Exception("El proveedor es nulo");
        }
        
        if(supplier.getIdUnit() == 0){
            throw new Exception("El id es obligatorio");
        }
        
        if("".equals(supplier.getName())){
            throw new Exception("El nombre es obligatorio");
        }
        
        if("".equals(supplier.getPhone())){
            throw new Exception("El telefono es obligatorio");
        }
        Supplier supplierExists = DAOFactory.getSupplierdao().findById(supplier.getIdUnit());
        if (supplierExists == null) {
            throw new Exception("No existe el proveedor");
        }
       
        supplierExists.setName(supplier.getName());
        supplierExists.setPhone(supplier.getPhone());
     
        EntityManagerHelper.beginTransaction();
        DAOFactory.getSupplierdao().update(supplierExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long idUnit) throws Exception {
         if (idUnit == 0) {
            throw new Exception("El id es obligatorio");
        }
        Supplier supplierExists = DAOFactory.getSupplierdao().findById(idUnit);
        if (supplierExists == null) {
            throw new Exception("No existe el empleado");
        }

        //eliminar
        EntityManagerHelper.beginTransaction();
        DAOFactory.getSupplierdao().delete(supplierExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Supplier> findAll() throws Exception {
        return DAOFactory.getSupplierdao().findAll();
    }

    @Override
    public Supplier findById(Long idUnit) throws Exception {
         if (idUnit == 0) {
            throw new Exception("El documento es obligatorio");
        }
        return DAOFactory.getSupplierdao().findById(idUnit);
    }
    
}
