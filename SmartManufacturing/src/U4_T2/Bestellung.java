package U4_T2;

import U4_T2.Produkte.Produkt;
import U4_T2.Produkte.Sofa;
import U4_T2.Produkte.Stuhl;

import java.util.ArrayList;

/**
 * Die Klasse Bestellung beinhaltet die bestellten Produkte
 *
 * @author Antonia Albani
 * @version 21.11.2021
 */
public class Bestellung {
    // Die Liste bestellteProdukte enthält alle Produkte, welche  bestellt worden sind
    private final ArrayList<Produkt> bestellteProdukte;

    private Boolean alleProdukteProduziert;

    // Die bestellBestaetigung gibt an, ob eine Bestellung bestätigt wurde oder nicht (boolean)
    private boolean bestellBestaetigung;
    // Die lieferZeit gibt an, wie lange es dauert, bis die Ware rausgeschickt wird
    private float lieferZeit;
    // Die Beschaffungszeit gibt an, wie lange die Lieferzeit (in Tage) für die Produkte ist
    // -1 ist der Initialisierungswert
    private int beschaffungsZeit;
    // Jede Bestellung erhält eine Bestellnummer
    private int bestellungsNr;
    // Anzahl der bestellten Stühle
    private int anzahlStuehle;
    // Anzahl der bestellten Sofas
    private int anzahlSofas;
    // Stuhl
    private Stuhl stuhl;
    // Sofa
    private Sofa sofa;


    /**
     * Konstruktor für Klasse Bestellung.
     * Hier werden alle globalen Variablen initialisiert
     *
     * @param bestellungsNr Zugeordnete Bestellnummer
     * @param anzahlStuehle Anzahl bestellter Stühle
     * @param anzahlSofas   Anzahl bestellter Sofas
     */
    public Bestellung(int bestellungsNr, int anzahlStuehle, int anzahlSofas) {
        int i;
        this.anzahlStuehle = anzahlStuehle;
        this.anzahlSofas = anzahlSofas;
        bestellteProdukte = new ArrayList();
        bestellBestaetigung = false;
        lieferZeit = -1;
        beschaffungsZeit = -1;
        alleProdukteProduziert = false;
        this.bestellungsNr = bestellungsNr;

        for (i = 0; i < anzahlStuehle; i++) {
            stuhlHinzufuegen();
        }

        for (i = 0; i < anzahlSofas; i++) {
            sofaHinzufuegen();
        }

    }

    public void CheckLieferungStatus() {
        if (!alleProdukteProduziert) {
            int toProduce = 0;
            for (Produkt product : bestellteProdukte) {
                if (product.aktuellerZustand() != Zustand.BEREIT_FUR_AUSLIEFERUNG) {
                    toProduce++;
                }
            }
            if(toProduce == 0)
                setzeAlleProdukteProduziert();
            else
                System.out.println("Bestellung: B"+gibBestellungsNr()+" noch "+ toProduce+" produkte zu bauen.");
        }
    }

    public boolean gibAlleProdukteProduziert() {
        return alleProdukteProduziert;
    }

    public void setzeAlleProdukteProduziert() {
        alleProdukteProduziert = true;
    }

    /**
     * Mit dieser Methode wird ein Stuhl erstellt und zur Liste der bestellten Produkte hinzugefügt
     */
    private void stuhlHinzufuegen() {
        stuhl = new Stuhl();
        bestellteProdukte.add(stuhl);
    }

    /**
     * Mit dieser Methode wird ein Sofa erstellt und zur Liste der bestellten Produkte hinzugefügt
     */
    private void sofaHinzufuegen() {
        sofa = new Sofa();
        bestellteProdukte.add(sofa);
    }

    /**
     * Mit dieser Methode wird die Liste mit den bestellten Produkten zurückgeliefert
     *
     * @return Liste mit den bestellten Produkten
     */
    public ArrayList<Produkt> gibBestellteProdukte() {
        return bestellteProdukte;
    }

    /**
     * Mit dieser Methode wird eine Bestellung bestätigt
     */
    public void bestellungBestaetigen() {
        bestellBestaetigung = true;
    }

    /**
     * Mit dieser Methode wird der Zustand einer Bestellung abgefragt
     *
     * @return bestellBestaetigung Zustand der Bestellbestätigung
     */
    public boolean gibBestellBestaetigung() {
        return bestellBestaetigung;
    }

    /**
     * Mit dieser Methode wird die Beschaffungszeit für die Bestellung gesetzt
     *
     * @param beschaffungsZeit wird übergeben
     */
    public void setzteBeschaffungsZeit(int beschaffungsZeit) {
        this.beschaffungsZeit = beschaffungsZeit;
    }

    /**
     * Mit dieser Methode wird die Beschaffungszeit für die Bestellung ausgegeben
     *
     * @return beschaffungsZeit
     */
    public int gibBeschaffungsZeit() {
        return this.beschaffungsZeit;
    }


    /**
     * Mit dieser Methode wird die Lieferzeit für die Bestellung gesetzt
     *
     * @param lieferZeit wird übergeben und gesetzt
     */
    public void setzeLieferZeit(float lieferZeit) {
        this.lieferZeit = lieferZeit;
    }


    /**
     * Mit dieser Methode wird die Lieferzeit für die Bestellung ausgegeben
     *
     * @return lieferZeit wird zurückgegeben
     */
    public float gibLieferZeit() {
        return this.lieferZeit;
    }

    /**
     * Mit dieser Methode wird die Bestellnummer für die Bestellung ausgegeben
     * <p>
     * bestellungsNr wird retourniert
     */
    public int gibBestellungsNr() {
        return bestellungsNr;
    }

    /**
     * Mit dieser Methode wird die Anzahl Stühle für die Bestellung ausgegeben
     *
     * @return anzahlStuehle wird retourniert
     */
    public int gibAnzahlStuehle() {
        return anzahlStuehle;
    }

    /**
     * Mit dieser Methode wird die Anzahl Sofas für die Bestellung ausgegeben
     *
     * @return anzahlSofas wird retourniert
     */
    public int gibAnzahlSofas() {
        return anzahlSofas;
    }

}
