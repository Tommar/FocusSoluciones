/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.Gastos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Stateless
public class GastosFacade extends AbstractFacade<Gastos> implements GastosFacadeLocal {

    @PersistenceContext(unitName = "rauquenFinalFinal-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GastosFacade() {
        super(Gastos.class);
    }
    
}
