/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.Carga;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Local
public interface CargaFacadeLocal {

    void create(Carga carga);

    void edit(Carga carga);

    void remove(Carga carga);

    Carga find(Object id);

    List<Carga> findAll();

    List<Carga> findRange(int[] range);

    int count();
    
}
