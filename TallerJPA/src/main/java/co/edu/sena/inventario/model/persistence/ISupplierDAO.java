/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Supplier;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface ISupplierDAO {
      public void insert (Supplier supplier) throws Exception;
        public void update (Supplier supplier) throws Exception;
        public void delete (Supplier supplier) throws Exception;
        public Supplier findById(Long id) throws Exception;
        public List<Supplier> findAll() throws Exception;
}
