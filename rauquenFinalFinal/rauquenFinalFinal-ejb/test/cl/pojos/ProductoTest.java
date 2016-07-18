/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author THOMASSEAMUSWARD
 */
public class ProductoTest {
    
    public ProductoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdproducto method, of class Producto.
     */
    @Test
    public void testGetIdproducto() {
        System.out.println("getIdproducto");
        Producto instance = new Producto();
        Integer expResult = null;
        Integer result = instance.getIdproducto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdproducto method, of class Producto.
     */
    @Test
    public void testSetIdproducto() {
        System.out.println("setIdproducto");
        Integer idproducto = null;
        Producto instance = new Producto();
        instance.setIdproducto(idproducto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCapacidad method, of class Producto.
     */
    @Test
    public void testGetCapacidad() {
        System.out.println("getCapacidad");
        Producto instance = new Producto();
        Integer expResult = null;
        Integer result = instance.getCapacidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCapacidad method, of class Producto.
     */
    @Test
    public void testSetCapacidad() {
        System.out.println("setCapacidad");
        Integer capacidad = null;
        Producto instance = new Producto();
        instance.setCapacidad(capacidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class Producto.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        Producto instance = new Producto();
        String expResult = "";
        String result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipo method, of class Producto.
     */
    @Test
    public void testSetTipo() {
        System.out.println("setTipo");
        String tipo = "";
        Producto instance = new Producto();
        instance.setTipo(tipo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompraProductoList method, of class Producto.
     */
    @Test
    public void testGetCompraProductoList() {
        System.out.println("getCompraProductoList");
        Producto instance = new Producto();
        List<CompraProducto> expResult = null;
        List<CompraProducto> result = instance.getCompraProductoList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCompraProductoList method, of class Producto.
     */
    @Test
    public void testSetCompraProductoList() {
        System.out.println("setCompraProductoList");
        List<CompraProducto> compraProductoList = null;
        Producto instance = new Producto();
        instance.setCompraProductoList(compraProductoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Producto.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Producto instance = new Producto();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Producto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Producto instance = new Producto();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Producto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Producto instance = new Producto();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
