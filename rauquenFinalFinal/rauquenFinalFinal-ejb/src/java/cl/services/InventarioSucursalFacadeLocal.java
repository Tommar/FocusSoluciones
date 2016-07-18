/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.InventarioSucursal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Local
public interface InventarioSucursalFacadeLocal {

    void create(InventarioSucursal inventarioSucursal);

    void edit(InventarioSucursal inventarioSucursal);

    void remove(InventarioSucursal inventarioSucursal);

    InventarioSucursal find(Object id);

    List<InventarioSucursal> findAll();

    List<InventarioSucursal> findRange(int[] range);

    int count();
    
}
