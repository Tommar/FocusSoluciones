/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.Camion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Stateless
public class CamionFacade extends AbstractFacade<Camion> implements CamionFacadeLocal {

    @PersistenceContext(unitName = "rauquenFinalFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CamionFacade() {
        super(Camion.class);
    }
    
}
