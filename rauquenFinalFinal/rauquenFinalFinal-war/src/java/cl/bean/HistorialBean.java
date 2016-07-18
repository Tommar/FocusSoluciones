/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.services.ClienteFacadeLocal;
import cl.services.UsuarioFacadeLocal;
import cl.services.VendedorFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Named(value = "historialBean")
@SessionScoped
public class HistorialBean implements Serializable {
 @EJB
    private VendedorFacadeLocal vendedorFacade;

    @EJB
    private ClienteFacadeLocal clienteFacade;

    @EJB
    private UsuarioFacadeLocal usuarioFacade;


    /**
     * Creates a new instance of HistorialBean
     */
    public HistorialBean() {
    }
    
    
}
