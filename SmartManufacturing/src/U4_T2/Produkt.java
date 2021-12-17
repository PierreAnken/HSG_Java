package U4_T2;

import U4_T2.Roboters.Roboter;

import java.util.LinkedList;

/**
 * Klasse Produkt ist eine Superklasse für die Klassen Stuhl und Sofa
 *
 * @author Antonia Albani
 * @version 21.11.2021
 */
public abstract class Produkt
{
    /** Variable zustand gibt den Zustand des bestellten Produktes an
    * Mögliche Zustände: 
    * 1: Bestellt
    * 2: In Produktion 
    * 3: Bereit für Auslieferung 
    * 4: Ausgeliefert
    */
    private Zustand zustand;
    private LinkedList<Roboter> produktionsAblauf;

    /**
     * Konstruktor
     */
    public Produkt()
    {
        zustand = Zustand.BESTELLT;
    }

    public void setzteProduktionsAblauf(){
        produktionsAblauf = new LinkedList<>();
    }

    public void naechsteProduktionsStation(){

    }

    /**
     * Zustand des Produkts wird geändert
     *
     * @param  zustand : neuer Zustand des Produkt
     */
    public void zustandAendern(Zustand zustand)
    {
        this.zustand = zustand;
    }
    
     /**
     * Aktueller Zustand des Produkts wird ausgegeben
     *
     * @return zustand Zustand des Produkt wird ausgegeben
     */   
    
    
    public Zustand aktuellerZustand()
    {
        return zustand;
        
    }
    
}
