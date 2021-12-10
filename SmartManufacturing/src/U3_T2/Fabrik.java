package U3_T2;

import java.util.ArrayList;

/**
 * Die Klasse Fabrik ist die Hauptklasse des Programms.
 * Hier befindet sich auch die main Methode zum Starten des Programms.
 *
 * @author Antonia Albani
 * @version 1.0
 */


public class Fabrik {
    // Die Liste bestellteProdukte enthält alle Produkte, welche  bestellt worden sind
    private ArrayList<Bestellung> bestellungen;
    private int bestellungsNr;
    private Lager lager;

    /**
     * Konstruktor der Klasse
     * Hier werden alle globale Variablen initialisiert
     */

    public Fabrik() {
        lager = new Lager();
        bestellungen = new ArrayList();
        bestellungsNr = 0;
    }

    private float computeProductionTime(Bestellung bestellung) {
        float productionTime = 0;
        productionTime += bestellung.gibAnzahlStuehle() * Stuhl.gibBenoetigteProduktionszeit() / (60.0 * 24.0);
        productionTime += bestellung.gibAnzahlSofas() * Sofa.gibBenoetigteProduktionszeit() / (60.0 * 24.0);
        return productionTime;
    }


    /**
     * Mit dieser Methode wird eine Bestellung aufgegeben
     */
    public void bestellungAufgeben(int stuehle, int sofas) {
        bestellungsNr = bestellungsNr + 1;
        Bestellung bestellung = new Bestellung(bestellungsNr, stuehle, sofas);

        int beschaffungsZeit = lager.gibBeschaffungsZeit(bestellung);
        float productionTime = computeProductionTime(bestellung);
        float lieferzeit = beschaffungsZeit + productionTime;

        int totalTime = (int)Math.ceil(lieferzeit + 1);

        bestellung.setzteBeschaffungsZeit(beschaffungsZeit);
        bestellung.setLieferZeit(totalTime);

        bestellungen.add(bestellung);
    }

    /**
     * Mit dieser Methode werden alle Bestellungen ausgegeben
     */
    public void bestellungenAusgeben() {
        for (Bestellung bestellung : bestellungen) {
            System.out.println("Bestellnummer: " + bestellung.gibBestellungsNr());
            System.out.println("Anzahl Stühle: " + bestellung.gibAnzahlStuehle());
            System.out.println("Anzahl Sofas: " + bestellung.gibAnzahlSofas());
            System.out.println("Beschaffungszeit: " + bestellung.gibBeschaffungsZeit());
            System.out.println("Bestellbestätigung: " + bestellung.gibBestellBestaetigung());
            System.out.println("Lieferzeit: " + bestellung.getLieferZeit());
            System.out.println();
            System.out.println();
        }
    }

    public void lagerAuffuellen(){
        lager.lagerAuffuellen();
    }


    /**
     * Mit der main Methode wird das Programm gestartet
     */
    public static void main(String[] args) {
        System.out.println("Aeki Fabrik wird gestartet");
        Fabrik Aeki = new Fabrik();
        Aeki.bestellungAufgeben(3, 4);
        Aeki.bestellungenAusgeben();

        Aeki.lagerAuffuellen();

        Aeki.bestellungAufgeben(2, 7);
        Aeki.bestellungenAusgeben();
    }
}
