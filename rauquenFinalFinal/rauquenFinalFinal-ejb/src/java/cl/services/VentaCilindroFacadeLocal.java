/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.VentaCilindro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Local
public interface VentaCilindroFacadeLocal {

    void create(VentaCilindro ventaCilindro);

    void edit(VentaCilindro ventaCilindro);

    void remove(VentaCilindro ventaCilindro);

    VentaCilindro find(Object id);

    List<VentaCilindro> findAll();

    List<VentaCilindro> findRange(int[] range);

    int count();
    
}
