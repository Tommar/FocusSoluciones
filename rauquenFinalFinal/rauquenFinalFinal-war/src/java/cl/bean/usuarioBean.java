
package cl.bean;

import cl.pojos.Usuario;
import cl.services.UsuarioFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;



@Named(value = "usuarioBean")
@RequestScoped
public class usuarioBean {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;
    private Usuario usuario;

    public usuarioBean() {
     usuario = new Usuario();
    }
    
    public List<Usuario> getUsuarios(){
    return usuarioFacade.findAll();
    }

    public void setUsuarioFacade(UsuarioFacadeLocal usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
    }

    public UsuarioFacadeLocal getUsuarioFacade() {
        return usuarioFacade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
