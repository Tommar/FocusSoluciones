/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.pojos.Camion;
import cl.pojos.Vendedor;
import cl.pojos.Gastos;
import cl.services.CamionFacadeLocal;
import cl.services.GastosFacadeLocal;
import cl.services.VendedorFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Named(value = "gastoBean")
@ViewScoped
public class gastoBean implements Serializable {

    @EJB
    private CamionFacadeLocal camionFacade;

    @EJB
    private GastosFacadeLocal gastosFacade;

    @EJB
    private VendedorFacadeLocal vendedorFacade;

    
    
    public List<Camion> getCamions(){
    return camionFacade.findAll();}
    private String camionID;
    private int KM;
    
    public String addKM(){
    
    Camion C = camionFacade.find(camionID);
    int oldKM = C.getKm();
    oldKM+=KM;
    C.setKm(oldKM);
    camionFacade.edit(C);
    return "";
    }
    
    public String addGasto(){
    Gastos Gasto = new Gastos();
    Gasto.setDetalle(reason);
    Gasto.setTotal(multa);
    Vendedor V = vendedorFacade.find(vendID);
    Gasto.setIdvendedor(V);
    Gasto.setIdgastos(null);
    gastosFacade.create(Gasto);
    
    return"index";}
    private String reason;
    private int multa;
    private String vendID;
    private Vendedor Vend;
    public List<Vendedor> getVendedors(){
    return vendedorFacade.findAll();}
    /**
     * Creates a new instance of gastoBean
     */
    public gastoBean() {
        this.reason= new String();
        this.vendID=new String();
        this.Vend = new Vendedor();
        this.camionID = new String();
    }

    public String getReason() {
        return reason;
    }

    public String getCamionID() {
        return camionID;
    }

    public void setCamionID(String camionID) {
        this.camionID = camionID;
    }

    public int getKM() {
        return KM;
    }

    public void setKM(int KM) {
        this.KM = KM;
    }

    
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }

    public Vendedor getVend() {
        return Vend;
    }

    public void setVend(Vendedor Vend) {
        this.Vend = Vend;
    }

    public String getVendID() {
        return vendID;
    }

    public void setVendID(String vendID) {
        this.vendID = vendID;
    }
    
    
    
    
}
