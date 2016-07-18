/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.VentaFormaPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Local
public interface VentaFormaPagoFacadeLocal {

    void create(VentaFormaPago ventaFormaPago);

    void edit(VentaFormaPago ventaFormaPago);

    void remove(VentaFormaPago ventaFormaPago);

    VentaFormaPago find(Object id);

    List<VentaFormaPago> findAll();

    List<VentaFormaPago> findRange(int[] range);

    int count();
    
}
