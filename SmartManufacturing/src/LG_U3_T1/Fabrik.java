package LG_U3_T1;

import java.util.ArrayList;

/**
 * Die Klasse Fabrik ist die Hauptklasse des Programms.
 * Hier befindet sich auch die main Methode zum Starten des Programms.
 *
 * @author Antonia Albani
 * @version 1.0
 */


public class Fabrik
{
    // Die Liste bestellteProdukte enthält alle Produkte, welche  bestellt worden sind
    private ArrayList <Bestellung> bestellungen;
    private int bestellungsNr;

    /**
     * Konstruktor der Klasse
     * Hier werden alle globale Variablen initialisiert
     */
    
    public Fabrik()
    {
        bestellungen = new ArrayList();
        bestellungsNr = 0;
      
    }
    
     /**
     * Mit dieser Methode wird eine Bestellung aufgegeben 
     * 
     */
    public void bestellungAufgeben(int stuehle, int sofas)
    {
        bestellungsNr = bestellungsNr+1;
        Bestellung bestellung = new Bestellung(bestellungsNr, stuehle, sofas);
        bestellungen.add(bestellung);
    }     
 
     /**
     * Mit dieser Methode werden alle Bestellungen ausgegeben 
     * 
     */
    public void bestellungenAusgeben()
    {   
        for(Bestellung bestellung : bestellungen) {
            System.out.println("Bestellnummer: " + bestellung.gibBestellungsNr());
            System.out.println("Anzahl Stühle: " + bestellung.gibAnzahlStuehle());
            System.out.println("Anzahl Sofas: " + bestellung.gibAnzahlSofas());
            System.out.println("Beschaffungszeit: " + bestellung.gibBeschaffungsZeit());
            System.out.println("Bestellbestätigung: " + bestellung.gibBestellBestaetigung());
            System.out.println(); 
            System.out.println();
    	}  	
    }  
    

    
    /**
     * Mit der main Methode wird das Programm gestartet
     * 
     */    
    public static void main(String[] args) {
        System.out.println("Aeki Fabrik wird gestartet");
        Fabrik fabrik = new Fabrik();
    }
}
