/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.pojos.Venta;
import cl.pojos.Cilindro;
import cl.pojos.Cliente;
import cl.pojos.FormaPago;
import cl.pojos.PrecioCilindro;
import cl.pojos.Usuario;
import cl.pojos.Vendedor;
import cl.pojos.VentaCilindro;
import cl.pojos.VentaCilindroPK;
import cl.pojos.VentaFormaPago;
import cl.pojos.VentaFormaPagoPK;
import cl.services.CilindroFacadeLocal;
import cl.services.ClienteFacadeLocal;
import cl.services.FormaPagoFacadeLocal;
import cl.services.PrecioCilindroFacadeLocal;
import cl.services.UsuarioFacadeLocal;
import cl.services.VendedorFacadeLocal;
import cl.services.VentaCilindroFacadeLocal;
import cl.services.VentaFacadeLocal;
import cl.services.VentaFormaPagoFacadeLocal;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author THOMASSEAMUSWARD
 */
@Named(value = "ventaBean")
@ViewScoped
public class VentaBean implements Serializable {

    @EJB
    private VendedorFacadeLocal vendedorFacade;

    @EJB
    private ClienteFacadeLocal clienteFacade;

    @EJB
    private UsuarioFacadeLocal usuarioFacade;

    @EJB
    private FormaPagoFacadeLocal formaPagoFacade;

    @EJB
    private VentaFormaPagoFacadeLocal ventaFormaPagoFacade;

    @EJB
    private VentaFacadeLocal ventaFacade;

    @EJB
    private VentaCilindroFacadeLocal ventaCilindroFacade;

    @EJB
    private CilindroFacadeLocal cilindroFacade;

    @EJB
    private PrecioCilindroFacadeLocal precioCilindroFacade;
    private FormaPago FP;
    private VentaFormaPago VFP;
private Vendedor Vendedor;
    private Cliente Cliente;
    private String ClienteID;
private int totalDes;
private String vendedorID;
private int pagoMonto;
private int sumaPagos;
        private List<Integer> PagoMontos;
    private List<Cilindro> tempCilindros;
    private List<Integer> cantidades;
    public List<Vendedor> getVendedors(){
    return vendedorFacade.findAll();
    }
    private List<FormaPago> PagoFList;
        private List<Integer> totals;
    private int cilindroID;
    private int cilindrocantidade;
private Usuario Usuario;
    public List<Cilindro> getCilindros(){
    return cilindroFacade.findAll();
    }
    
    public List<Cliente> getClientes() {

        return clienteFacade.findAll();

    }

    private int total;

private int formaPagoInt;

    public int getFormaPagoInt() {
        return formaPagoInt;
    }

    public void setFormaPagoInt(int formaPagoInt) {
        this.formaPagoInt = formaPagoInt;
    }

     public void setResto(){
         
         
         if(totalDes>(sumaPagos)){
    pagoMonto=totalDes-sumaPagos;
         }
        
    }


public List<FormaPago>getFormaPago(){
return formaPagoFacade.findAll();
}
    
    public List<PrecioCilindro> getprecios() {
        return precioCilindroFacade.findAll();
    }

    public void onClienteSelect() {

        Cliente = clienteFacade.find(ClienteID);

    }
    
    public void onVendedorSelect(){
    
    Vendedor = vendedorFacade.find(vendedorID);
    
    }
    

    public void onCilindroAdd() {

        tempCilindros.add(cilindroFacade.find(cilindroID));
        int cant = cilindrocantidade;
       boolean addedCil = cantidades.add(cant);
       
        int precio = cilindroFacade.find(cilindroID).getIdprecioCilindro().getPrecio();
        int subtotal = cilindrocantidade * precio;
     boolean addedT =   totals.add(subtotal);
     
        total = 0;
        for (Integer t : totals) {

            total += t;

        }
        if(Cliente.getPorcentajeDescuento()>0){
        totalDes = ((total*100)-(total*Cliente.getPorcentajeDescuento()))/100;
        }
        
        else totalDes=total;
        

    }
    
    public void onPagoAdd(){
        
        if(pagoMonto>0){
        
        if(totalDes>=(sumaPagos+pagoMonto)){
        
           
        
    FP=formaPagoFacade.find(formaPagoInt);
        PagoFList.add(FP);
        PagoMontos.add(pagoMonto);
        sumaPagos=0;
        for (Integer PM : PagoMontos) {
            sumaPagos+=PM;
        }
        }
        else{setResto();}}
        
    }
    
    public String cancelVenta(){
    return "";
    }

    public String doVenta() {

        Venta newVenta = new Venta();

        Date dt = new Date();
        newVenta.setFecha(dt);
        
        
        newVenta.setEstado("Iniciado");
        newVenta.setTotal(totalDes);
        newVenta.setIdusuario(Usuario);
        newVenta.setIdcliente(Cliente);
        newVenta.setIdvendedor(Vendedor);
        newVenta.setDescuento(Cliente.getPorcentajeDescuento());
        List<Venta> v1= ventaFacade.findAll();
        int v1length =v1.size();
        
        int id =  v1length+1;
               
                        
        newVenta.setIdventa(null);
        ventaFacade.create(newVenta);
        
    
        
        for (Cilindro cili : tempCilindros) {
            int index = tempCilindros.indexOf(cili);
            VentaCilindro VC = new VentaCilindro();
            VC.setCantidad(cantidades.get(index));
            VC.setCilindro(cili);
            VC.setPrecio(totals.get(index));
            VC.setVenta(newVenta);
           VentaCilindroPK VCPK = new VentaCilindroPK(id, cili.getIdcilindro());
           VC.setVentaCilindroPK(VCPK);
            ventaCilindroFacade.create(VC);
        }
        
        for (FormaPago FP : PagoFList) {
            int index = PagoFList.indexOf(FP);
            VentaFormaPago VFP = new VentaFormaPago();
            VFP.setFormaPago(FP);
            VFP.setValor(PagoMontos.get(index));
            VFP.setVenta(newVenta);
            VentaFormaPagoPK VFPPK= new VentaFormaPagoPK(id, FP.getIdformaPago());
            VFP.setVentaFormaPagoPK(VFPPK);
            ventaFormaPagoFacade.create(VFP);
        }

return "venta.xhtml";
    }

    /**
     * Creates a new instance of VentaBean
     */
    public VentaBean() {

        this.Cliente = new Cliente();
        this.ClienteID = new String();
        this.Vendedor=new Vendedor();
        this.tempCilindros = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        this.totals = new ArrayList<>();
        this.PagoMontos=new ArrayList<>();
        this.PagoFList=new ArrayList<>();
        this.usuId=new String();
        this.Usuario=new Usuario();
        this.vendedorID=new String();
       
        
        
        
    }
private String usuId;

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

 public void onUsuSelect(){
    
    Usuario=usuarioFacade.find(usuId);
    }
    
    public List<Usuario> getUsuarios(){
    
    return usuarioFacade.findAll();
    
    }

    public List<FormaPago> getPagoFList() {
        return PagoFList;
    }

    public void setPagoFList(List<FormaPago> PagoFList) {
        this.PagoFList = PagoFList;
    }
    
    
    
    
    public List<Integer> getTotals() {
        return totals;
    }

    public void setTotals(List<Integer> totals) {
        this.totals = totals;
    }

    public double getTotalDes() {
        return totalDes;
    }

    public void setTotalDes(int totalDes) {
        this.totalDes = totalDes;
    }

    public FormaPago getFP() {
        return FP;
    }

    public void setFP(FormaPago FP) {
        this.FP = FP;
    }

    public VentaFormaPago getVFP() {
        return VFP;
    }

    public void setVFP(VentaFormaPago VFP) {
        this.VFP = VFP;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    
    
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public int getCilindrocantidade() {
        return cilindrocantidade;
    }

    public void setCilindrocantidade(int cilindrocantidade) {
        this.cilindrocantidade = cilindrocantidade;
    }

    public int getCilindroID() {
        return cilindroID;
    }

    public void setCilindroID(int cilindroID) {
        this.cilindroID = cilindroID;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }

    public String getClienteID() {
        return ClienteID;
    }

    public void setClienteID(String ClienteID) {
        this.ClienteID = ClienteID;
    }

    public List<Cilindro> getTempCilindros() {
        return tempCilindros;
    }

    public void setTempCilindros(List<Cilindro> tempCilindros) {
        this.tempCilindros = tempCilindros;
    }

    public Vendedor getVendedor() {
        return Vendedor;
    }

    public void setVendedor(Vendedor Vendedor) {
        this.Vendedor = Vendedor;
    }

    public String getVendedorID() {
        return vendedorID;
    }

    public void setVendedorID(String vendedorID) {
        this.vendedorID = vendedorID;
    }

    public int getPagoMonto() {
        return pagoMonto;
    }

    public void setPagoMonto(int pagoMonto) {
        this.pagoMonto = pagoMonto;
    }

    public List<Integer> getPagoMontos() {
        return PagoMontos;
    }

    public void setPagoMontos(List<Integer> PagoMontos) {
        this.PagoMontos = PagoMontos;
    }

    public int getSumaPagos() {
        return sumaPagos;
    }

    public void setSumaPagos(int sumaPagos) {
        this.sumaPagos = sumaPagos;
    }

    
    
    
}
