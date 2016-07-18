/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;
import cl.pojos.CompraProductoPK;
import cl.pojos.Cilindro;
import cl.pojos.Compra;
import cl.pojos.CompraProducto;
import cl.pojos.Producto;
import cl.pojos.Proveedor;
import cl.pojos.Usuario;
import cl.services.CilindroFacadeLocal;
import cl.services.CompraFacadeLocal;
import cl.services.CompraProductoFacadeLocal;
import cl.services.ProductoFacadeLocal;
import cl.services.ProveedorFacadeLocal;
import cl.services.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;

import javax.faces.view.ViewScoped;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Named(value = "compraBean")
@ViewScoped
public class compraBean implements Serializable {

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    
    
    @EJB
    private CompraProductoFacadeLocal compraProductoFacade;

    @EJB
    private ProductoFacadeLocal productoFacade;

    private List<Compra> tempCompras;

    public List<Compra> getTempCompras() {
        return tempCompras;
    }

    public void setTempCompras(List<Compra> tempCompras) {
        this.tempCompras = tempCompras;
    }

    /**
     * Creates a new instance of compraBean
     */
    public compraBean() {
        this.Proveedor = new Proveedor();
        this.chosenProvedor = new Proveedor();
        this.Producto=new Producto();
        this.usuarioID=new String();
        this.guia=new String();
        this.usuario=new Usuario();
        this.Compra = new Compra();
        this.cilindro = new Cilindro();
        this.compraProducto = new CompraProducto();
        this.tempProducto = new Producto();
        this.productoList = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.tempCompras = new ArrayList<>();
        this.totals= new ArrayList<>();
        
    }

    
    
    
    
    @EJB
    private CilindroFacadeLocal cilindroFacade;
    private CompraProducto compraProducto;
    private int productoID;
    private Producto tempProducto;
    private Usuario usuario;
    @EJB
    private ProveedorFacadeLocal proveedorFacade;

    @EJB
    private CompraFacadeLocal compraFacade;

    private String provID;
    private String usuarioID;
public List<Usuario> getUsuarios(){
return usuarioFacade.findAll();
}
     public void onUsuSelect(){
    
    usuario=usuarioFacade.find(usuarioID);
    }
    
    public String getUsuarioID() {
        return usuarioID;
    }
    

    public void setUsuarioID(String usuarioID) {
        this.usuarioID = usuarioID;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    public String getProvID() {
        return provID;
    }
    
    public void selectProducto(){
    Producto= productoFacade.find(productoID);
    }
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    private List<Integer> totals;
    
   
    
    public void addProducto(){
    Producto = productoFacade.find(productoID);
        
        productoList.add(Producto);
        
        int cant = cantidad;
       boolean addedCil = cantidades.add(cant);
       int p =Producto.getPrecio();
       int subtotal= p*cant ;
     boolean addedT =   totals.add(subtotal);
     
        total = 0;
        for (Integer t : totals) {

            total += t;

        }
     
        
    
    }
    
      private String guia;

    public Producto getProducto() {
        return Producto;
    }

    public void setProducto(Producto Producto) {
        this.Producto = Producto;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }
      
    
    private Date date3;
    
     public Date getDate3() {
        return date3;
    }
 
    public void setDate3(Date date3) {
        this.date3 = date3;
    }
    
     public String cancelCompra(){
    return "";
    }
     public String doCompra() {

        Compra newCompra = new Compra();

       
        newCompra.setFecha(date3);
        
          newCompra.setTotal(total);
        newCompra.setIdproveedor(Proveedor);
        newCompra.setIdusuario(usuario);
      newCompra.setCompraProductoList(null);
    
        List<Compra> v1= compraFacade.findAll();
        int v1length =v1.size();
        
        int id =  v1length+1;
               
                        
        newCompra.setIdcompra(id);
       compraFacade.create(newCompra);
       
       
         for (Producto p : productoList) {
             
         CompraProducto    cp=new CompraProducto();
             cp.setCompra(compraFacade.find(id));
             cp.setPrecio(p.getPrecio());
             CompraProductoPK CPK = new CompraProductoPK(id, p.getIdproducto());
             cp.setCompraProductoPK(CPK);
             int index = productoList.indexOf(p);
             cp.setCantidad(cantidades.get(index));
             compraProductoFacade.create(cp);
         }
       

return "";
    }

    public List<Integer> getTotals() {
        return totals;
    }

    public void setTotals(List<Integer> totals) {
        this.totals = totals;
    }
    

    public List<Producto> getProductos() {
        return productoFacade.findAll();    }

    private int total;

   private Producto Producto;

    public List<Proveedor> getProveedors() {
        return proveedorFacade.findAll();
    }

    private List<Integer> cantidades;
    private Proveedor chosenProvedor;
    private Proveedor Proveedor;
    private Compra Compra;
    private Cilindro cilindro;
    private List<CompraProducto> compraProductos;
    private List<Producto> productoList;

    public Proveedor getProveedor() {
        return Proveedor;
    }

    public void setProveedor(Proveedor Provedor) {
        this.Proveedor = Provedor;
    }

    public Compra getCompra() {
        return Compra;
    }

    public Proveedor getChosenProvedor() {
        return chosenProvedor;
    }

    public void setChosenProvedor(Proveedor chosenProvedor) {
        this.chosenProvedor = chosenProvedor;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getProductoID() {
        return productoID;
    }

    

    public void setProductoID(int productoID) {
        this.productoID = productoID;
    }

    public List<Cilindro> getCilindros() {
        return cilindroFacade.findAll();
    }

    public void setCompra(Compra Compra) {
        this.Compra = Compra;
    }

    public CompraProducto getCompraProducto() {
        return compraProducto;
    }

    public void setCompraProducto(CompraProducto compraProducto) {
        this.compraProducto = compraProducto;
    }

    public Producto getTempProducto() {
        return tempProducto;
    }

    public void setTempProducto(Producto tempProducto) {
        this.tempProducto = tempProducto;
    }

    public Cilindro getCilindro() {
        return cilindro;
    }

    public void setCilindro(Cilindro cilindro) {
        this.cilindro = cilindro;
    }

    private int cilindroID;

    public int getCilindroID() {
        return cilindroID;
    }

    public void setCilindroID(int cilindroID) {
        this.cilindroID = cilindroID;
    }

    public void setProvID(String provID) {
        this.provID = provID;
    }

    public void onProveedorSelect() {

        chosenProvedor = proveedorFacade.find(provID);

    }

   

    public List<Producto> getProductoList() {
        return productoList;
    }

    public List<CompraProducto> getCompraProductos() {
        return compraProductos;
    }

    public void setCompraProductos(List<CompraProducto> compraProductos) {
        this.compraProductos = compraProductos;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

}
