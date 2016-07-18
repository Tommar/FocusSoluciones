
package cl.bean;

import cl.pojos.Cliente;
import cl.services.ClienteFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


@Named(value = "clienteBean")
@RequestScoped
public class clienteBean {

    @EJB
    private ClienteFacadeLocal clienteFacade;
    private Cliente cliente;
    
    public clienteBean() {
        cliente = new Cliente();
    }
    
   public List<Cliente> getClientes(){
   return clienteFacade.findAll();
   }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
   public String actualizar(){
   return "index";
   }
   public String eliminar(){
   return "index";
   }
}
