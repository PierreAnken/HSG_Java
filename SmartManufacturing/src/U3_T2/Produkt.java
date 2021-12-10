package U3_T2;

/**
 * Klasse Produkt ist eine Superklasse für die Klassen Stuhl und Sofa
 *
 * @author Antonia Albani
 * @version 21.11.2021
 */
public class Produkt
{
    /** Variable zustand gibt den Zustand des bestellten Produktes an
    * Mögliche Zustände: 
    * 1: Bestellt
    * 2: In Produktion 
    * 3: Bereit für Auslieferung 
    * 4: Ausgeliefert
    */
    private int zustand;
    

    /**
     * Konstruktor
     */
    public Produkt()
    {
        zustand = 1;
        
    }

    /**
     * Zustand des Produkts wird geändert
     *
     * @param  zustand : neuer Zustand des Produkt
     */
    public void zustandAendern(int zustand)
    {
        this.zustand = zustand;
        
    }
    
     /**
     * Aktueller Zustand des Produkts wird ausgegeben
     *
     * @return zustand Zustand des Produkt wird ausgegeben
     */   
    
    
    public int aktuellerZustand()
    {
        return zustand;
        
    }

}
