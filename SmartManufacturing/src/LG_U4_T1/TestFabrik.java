package LG_U4_T1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TestFabrik.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TestFabrik
{
    /**
     * Default constructor for test class TestFabrik
     */
    public TestFabrik()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testProdukteBestellen()
    {
        Fabrik Aeki = new Fabrik();
        //Aeki.bestellungAufgeben(31000, 4);
        Aeki.bestellungAufgeben(1, 4); 
        Aeki.bestellungAufgeben(20, 10);   
        System.out.println();
        System.out.println("TestFabrik: Bestellungen ausgeben: ");
        Aeki.bestellungenAusgeben();
        System.out.println("TestFabrik: Ware nachbestellen: ");
        System.out.println();        
        Aeki.lagerAuffuellen();
    }
}

