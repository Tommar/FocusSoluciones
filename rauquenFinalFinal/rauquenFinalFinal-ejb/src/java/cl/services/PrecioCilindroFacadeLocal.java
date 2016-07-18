/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.PrecioCilindro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Local
public interface PrecioCilindroFacadeLocal {

    void create(PrecioCilindro precioCilindro);

    void edit(PrecioCilindro precioCilindro);

    void remove(PrecioCilindro precioCilindro);

    PrecioCilindro find(Object id);

    List<PrecioCilindro> findAll();

    List<PrecioCilindro> findRange(int[] range);

    int count();
    
}
