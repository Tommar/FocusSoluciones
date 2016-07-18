/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.VentaCilindro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Stateless
public class VentaCilindroFacade extends AbstractFacade<VentaCilindro> implements VentaCilindroFacadeLocal {

    @PersistenceContext(unitName = "rauquenFinalFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentaCilindroFacade() {
        super(VentaCilindro.class);
    }
    
}
