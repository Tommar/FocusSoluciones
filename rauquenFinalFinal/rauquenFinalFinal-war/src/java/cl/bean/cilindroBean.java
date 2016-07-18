
package cl.bean;

import cl.pojos.Cilindro;
import cl.pojos.PrecioCilindro;
import cl.services.CilindroFacadeLocal;
import cl.services.PrecioCilindroFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "cilindroBean")
@RequestScoped


public class cilindroBean {

    @EJB
    private PrecioCilindroFacadeLocal precioCilindroFacade;

    @EJB
    private CilindroFacadeLocal cilindroFacade;
   
    
    private Cilindro cilindro;
    private PrecioCilindro preciocilindro;
            private int newPrice;
    public cilindroBean() {
        cilindro = new Cilindro();
        preciocilindro= new PrecioCilindro();
        
        
    }
    public List<Cilindro> getCilindros(){
    return cilindroFacade.findAll();
    }

    public Cilindro getCilindro() {
        return cilindro;
    }

    public void setCilindro(Cilindro cilindro) {
        this.cilindro = cilindro;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public PrecioCilindro getPreciocilindro() {
        return preciocilindro;
    }

    public void setPreciocilindro(PrecioCilindro preciocilindro) {
        this.preciocilindro = preciocilindro;
    }
    
    
    
    public String actualizar(){
        
    return "index";
    }
    
}
