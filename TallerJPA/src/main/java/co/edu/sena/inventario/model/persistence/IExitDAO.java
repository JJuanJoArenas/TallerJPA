/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.inventario.model.persistence;

import co.edu.sena.inventario.model.Exit;
import java.util.List;

/**
 *
 * @author Aprendiz
 */
public interface IExitDAO {
      public void insert (Exit exit) throws Exception;
        public void update (Exit exit) throws Exception;
        public void delete (Exit exit) throws Exception;
        public Exit findById(Long id) throws Exception;
        public List<Exit> findAll() throws Exception;
}
