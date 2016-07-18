
package cl.bean;

import cl.pojos.PrecioCilindro;
import cl.services.PrecioCilindroFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "precioBean")
@RequestScoped
public class precioBean {

    @EJB
    private PrecioCilindroFacadeLocal precioCilindroFacade;

    private PrecioCilindro precio;
   
    public precioBean() {
        precio= new PrecioCilindro();
    }
    
    public List<PrecioCilindro> getPrecioClindros(){
    return precioCilindroFacade.findAll();
    }

    public PrecioCilindro getPrecio() {
        return precio;
    }

    public void setPrecio(PrecioCilindro precio) {
        this.precio = precio;
    }
    
    
    private int cilinder;
    private int precioInt;

    public int getCilinder() {
        return cilinder;
    }

    public void setCilinder(int cilinder) {
        this.cilinder = cilinder;
    }

    public int getPrecioInt() {
        return precioInt;
    }

    public void setPrecio(int precioInt) {
        this.precioInt = precioInt;
    }
    
    
    
    public void actualizar(){
    
    PrecioCilindro p1 = precioCilindroFacade.find(cilinder);
    p1.setPrecio(precioInt);
    precioCilindroFacade.edit(p1);
    }
    
}
