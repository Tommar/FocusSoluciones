/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.Cilindro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Local
public interface CilindroFacadeLocal {

    void create(Cilindro cilindro);

    void edit(Cilindro cilindro);

    void remove(Cilindro cilindro);

    Cilindro find(Object id);

    List<Cilindro> findAll();

    List<Cilindro> findRange(int[] range);

    int count();
    
}
