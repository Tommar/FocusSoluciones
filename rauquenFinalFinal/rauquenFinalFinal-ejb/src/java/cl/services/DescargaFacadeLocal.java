/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.Descarga;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Local
public interface DescargaFacadeLocal {

    void create(Descarga descarga);

    void edit(Descarga descarga);

    void remove(Descarga descarga);

    Descarga find(Object id);

    List<Descarga> findAll();

    List<Descarga> findRange(int[] range);

    int count();
    
}
