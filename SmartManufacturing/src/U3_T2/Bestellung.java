package U3_T2;

import java.util.ArrayList;

/**
 * Die Klasse Bestellung beinhaltet die bestellten Produkte
 *
 * @author Antonia Albani
 * @version 21.11.2021
 */
public class Bestellung
{
    // Die Liste bestellteProdukte enthält alle Produkte, welche  bestellt worden sind
    private ArrayList <Produkt> bestellteProdukte;
    // Die bestellBestaetigung gibt an, ob eine Bestellung bestätigt wurde oder nicht (boolean)
    private boolean bestellBestaetigung;
    // Die Beschaffungszeit gibt an, wie lange die Lieferzeit (in Tage) für die Produkte ist
    // -1 ist der Initialisierungswert
    private int beschaffungsZeit;
    // Jede Bestellung erhält eine Bestellnummer
    private int bestellungsNr;  
    // Anzahl der bestellten Stühle
    private int anzahlStuehle;  
    // Anzahl der bestellten Sofas
    private int anzahlSofas;

    private int lieferZeit;


    public ArrayList<Produkt> liefereBestellteProdukte(){
        return bestellteProdukte;
    }

    /**
     * Konstruktor für Klasse Bestellung.
     * Hier werden alle globalen Variablen initialisiert
     * 
     * @param bestellungsNr Zugeordnete Bestellnummer
     * @param stuehle Anzahl bestellter Stühle
     * @param sofas Anzahl bestellter Sofas 
     */
    public Bestellung(int bestellungsNr, int anzahlStuehle, int anzahlSofas)
    {
        int i;
        this.anzahlStuehle = anzahlStuehle;
        this.anzahlSofas = anzahlSofas;
        bestellteProdukte = new ArrayList();
        bestellBestaetigung = false;
        beschaffungsZeit = -1;    
        this.bestellungsNr = bestellungsNr;
                       
        for(i=0;i<=anzahlStuehle;i++)
        {
            stuhlHinzufuegen();
        }
 
        for(i=0;i<=anzahlSofas;i++)
        {
            sofaHinzufuegen();
        }
        
    }   
    
    /**
     * Mit dieser Methode wird ein Stuhl erstellt und zur Liste der Bestellten Produkte hinzugefügt 
     * 
     */    
    private void stuhlHinzufuegen()
    {
         Stuhl stuhl = new Stuhl();
         bestellteProdukte.add(stuhl);       
    }  

    /**
     * Mit dieser Methode wird ein Sofa erstellt und zur Liste der Bestellten Produkte hinzugefügt 
     * 
     */      
    private void sofaHinzufuegen()
    {
        Sofa sofa = new Sofa();
        bestellteProdukte.add(sofa);         
    }  
    
    
    /**
     * Mit dieser Methode wird eine Bestellung bestätigt 
     * 
     */
    public void bestellungBestaetigen()
    {
        bestellBestaetigung = true;
    }   
        
    /**
     * Mit dieser Methode wird der Zustand einer Bestellung abgefragt 
     * 
     * @return bestellBestaetigung Zustand der Bestellbestätigung
     */
    public boolean gibBestellBestaetigung()
    {
        return bestellBestaetigung;
    }       
    
    /**
     * Mit dieser Methode wird die Beschaffungszeit für die Bestellung gesetzt
     * 
     *
     * @param beschaffungszeit wird übergeben 
     */
    public void setzteBeschaffungsZeit(int beschaffungsZeit)
    {
        this.beschaffungsZeit = beschaffungsZeit;
    }   
    
    /**
     * Mit dieser Methode wird die Beschaffungszeit für die Bestellung ausgegeben 
     * 
     * @return beschaffungsZeit
     */
    public int gibBeschaffungsZeit()
    {
        return beschaffungsZeit;
    }   


    public int gibBestellungsNr()
    {
        return bestellungsNr;
    }   
    
    /**
     * Mit dieser Methode wird die Anzahl Stühle für die Bestellung ausgegeben 
     * 
     * 
     * @return anzahlStuehle wird retourniert
     */
    public int gibAnzahlStuehle()
    {
        return anzahlStuehle;
    }     
 
    /**
     * Mit dieser Methode wird die Anzahl Sofas für die Bestellung ausgegeben 
     * 
     * 
     * @return anzahlSofas wird retourniert
     */
    public int gibAnzahlSofas()
    {
        return anzahlSofas;
    }

    public int getLieferZeit() {
        return lieferZeit;
    }

    public void setLieferZeit(int lieferZeit) {
        this.lieferZeit = lieferZeit;
    }
}
