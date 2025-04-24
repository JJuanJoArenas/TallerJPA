/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.inventario.model.controller;

import co.edu.sena.inventario.model.Unit;
import co.edu.sena.inventario.model.persistence.DAOFactory;
import co.edu.sena.inventario.model.persistence.EntityManagerHelper;
import java.util.List;

/**
 *
 * @author 
 */
public class UnitController implements IUnit{

    @Override
    public void insert(Unit unit) throws Exception {
        if(unit == null){
            throw new Exception("La unidad es nula");
        }
        if ("".equals(unit.getName())) {
            throw new Exception("El nombre es obligatorio");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUnitdao().insert(unit);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(Unit unit) throws Exception {
         if(unit == null){
            throw new Exception("La unidad es nula");
        }
        if ("".equals(unit.getName())) {
            throw new Exception("El nombre es obligatorio");
        }
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUnitdao().update(unit);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Long idUnit) throws Exception {
         if(idUnit == null){
            throw new Exception("La unidad es nula");
        }
         Unit unitExists = DAOFactory.getUnitdao().findById(idUnit);
        if (unitExists == null) {
            throw new Exception("No existe la unidad");
        }
        EntityManagerHelper.beginTransaction();
        DAOFactory.getUnitdao().delete(unitExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<Unit> findAll() throws Exception {
         return DAOFactory.getUnitdao().findAll();
    }

    @Override
    public Unit findById(Long idUnit) throws Exception {
        if (idUnit == 0) {
            throw new Exception("El documento es obligatorio");
        }
        return DAOFactory.getUnitdao().findById(idUnit);
    }
    
}
