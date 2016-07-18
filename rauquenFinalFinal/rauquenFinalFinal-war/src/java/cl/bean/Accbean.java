/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.pojos.Usuario;
import cl.services.UsuarioFacadeLocal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @author THOMASSEAMUSWARD
 */
@Named(value = "accbean")
@RequestScoped
public class Accbean {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    /**
     * Creates a new instance of Accbean
     */
    
    
    
    private String idUsuario;
    private String clave;
    
    private HttpServletRequest request;
    
    
    public Accbean() {
        
        request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
      
    }
    
    
      public String acceder(){
      Usuario User = new Usuario();
              User = usuarioFacade.find(idUsuario);
       String msg;
      if(User!=null){
   msg ="";
          if(User.getPass().equals(clave)){
          request.getSession().setAttribute("user", User);
      

	

       try {
           FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/rauquenFinalFinal-war/faces/menu.xhtml");
       } catch (IOException ex) {
           
       }


          return "menu";
          }else{
          
          msg="Clave Incorecto";
          }
      
      }else{
      msg="Usuario no Existe";
              }
      
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
          return"index";
      }
    
      public String cerrarSession(){
          request.getSession().invalidate();
          
      return"index";}



    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }


      
      
      
      
      
}
