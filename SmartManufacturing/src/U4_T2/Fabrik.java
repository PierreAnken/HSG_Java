package U4_T2;

import U4_T2.Produkte.Sofa;
import U4_T2.Produkte.Stuhl;

import java.util.ArrayList;

/**
 * Die Klasse Fabrik ist die Hauptklasse des Programms.
 * Hier befindet sich auch die main Methode zum Starten des Programms.
 *
 * @author Antonia Albani
 * @version 1.0
 */


public class Fabrik {
    // Die Liste bestellteProdukte enthält alle Produkte, welche bestellt worden sind
    private final ArrayList<Bestellung> bestellungen;
    private int bestellungsNr;
    private final Lager lager;
    private final ProduktionsManager produktionsManager;


    /**
     * Konstruktor der Klasse
     * Hier werden alle globale Variablen initialisiert
     * <p>
     * Die ArrayList soll alle in der Fabrik aufgegebenen Bestellungen abspeichern
     * Eine individuelle BestellNr. wird vergeben
     * Ein Lager wird angelegt
     */

    public Fabrik() {
        bestellungen = new ArrayList<>();
        bestellungsNr = 0;
        lager = new Lager();
        produktionsManager = new ProduktionsManager(this, lager);

    }

    /**
     * Mit dieser Methode kann eine Bestellung aufgegeben werden.
     * <p>
     * Die Beschaffungszeit und die Lieferzeit werden mit den Werten -1 initialisiert.+1
     * Es wird eine eindeutige Bestellnummer vergeben, dadurch dass eine Nummer einfach immer weiter hochgezählt wird.
     * Die Lieferzeit wird berechnet, indem die Anzahl zu produzierende Stühle x 22 Min. gerechnet wird. Dazu wird die Anzahl
     * zu produzierende Sofas x 60 Min. addiert. Das Gesamtergebnis wird durch 60 geteilt, um auf Stunden zu kommen und dies wiederum durch
     * 24 geteilt, um auf die Anzahl Tage zu kommen, die benötigt werden, um die Ware zu produzieren. Dazu wird noch ein Tag als Standardlieferzeit
     * hinzugerechnet und die Beschaffungszeit addiert.
     * Die Beschaffungszeit, Lieferzeit und die Bestellbestätigung werden in der Bestellung abgespeichert.
     * Die Bestellung wird in die Liste aller Bestellungen der Fabrik hinzugefügt.
     *
     * @param stuehle Anzahl bestellter Stühle
     * @param sofas   Anzahl bestellter Sofas
     */
    public void bestellungAufgeben(int stuehle, int sofas) {
        bestellungsNr = bestellungsNr + 1;
        Bestellung bestellung = new Bestellung(bestellungsNr, stuehle, sofas);
        int beschaffungsZeit = lager.gibBeschaffungsZeit(bestellung);

        if (beschaffungsZeit >= 0) {
            bestellung.setzteBeschaffungsZeit(beschaffungsZeit);
            float lieferzeit = (Stuhl.gibBenoetigteProduktionszeit() * stuehle + Sofa.gibBenoetigteProduktionszeit() * sofas) / (60 * 24) + beschaffungsZeit + 1;
            bestellung.setzeLieferZeit(lieferzeit);
            bestellung.bestellungBestaetigen();
            bestellungen.add(bestellung);
            produktionsManager.fuegeZuVerarbeitendeBestellungenHinzu(bestellung);

        } else {
            System.out.println("Bestellung "+bestellung.gibBestellungsNr()+" kann nicht bestätigt werden, unsere Lager sind zu klein!\n");
        }
    }


    /**
     * Mit dieser Methode wird das Lager angeordnet Material wieder nachzubestellen
     */

    public void lagerAuffuellen() {
        lager.lagerAuffuellen();
    }


    /**
     * Mit dieser Methode werden die Informationen zu allen Bestellungen ausgegeben
     */
    public void bestellungenAusgeben() {
        for (Bestellung bestellung : bestellungen) {
            System.out.println("Bestellnummer: " + bestellung.gibBestellungsNr());
            System.out.println("Anzahl Stühle: " + bestellung.gibAnzahlStuehle());
            System.out.println("Anzahl Sofas: " + bestellung.gibAnzahlSofas());
            System.out.println("Beschaffungszeit: " + bestellung.gibBeschaffungsZeit());
            System.out.println("Lieferzeit: " + bestellung.gibLieferZeit());
            System.out.println("Bestellbestätigung: " + bestellung.gibBestellBestaetigung());
            System.out.println();
            System.out.println();
        }
    }


    /**
     * Mit der main Methode wird das Programm gestartet
     */
    public static void main(String[] args) throws InterruptedException {

        Fabrik Aeki = new Fabrik();

        Thread.sleep(5000);

        Aeki.bestellungAufgeben(5, 10);

        Thread.sleep(5000);

        Aeki.bestellungAufgeben(2, 10);

        Thread.sleep(5000);

        Aeki.bestellungAufgeben(20, 25);

        Thread.sleep(5000);

        Aeki.bestellungAufgeben(5, 10);
    }
}
