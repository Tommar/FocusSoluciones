/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.CompraProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Local
public interface CompraProductoFacadeLocal {

    void create(CompraProducto compraProducto);

    void edit(CompraProducto compraProducto);

    void remove(CompraProducto compraProducto);

    CompraProducto find(Object id);

    List<CompraProducto> findAll();

    List<CompraProducto> findRange(int[] range);

    int count();
    
}
