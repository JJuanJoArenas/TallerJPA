/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Unit;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IUnitDAO {
      public void insert (Unit unit) throws Exception;
        public void update (Unit unit) throws Exception;
        public void delete (Unit unit) throws Exception;
        public Unit findById(Long id) throws Exception;
        public List<Unit> findAll() throws Exception;
}
