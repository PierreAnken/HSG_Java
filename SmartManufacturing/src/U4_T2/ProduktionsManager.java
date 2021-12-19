package U4_T2;

import U4_T2.Produkte.Produkt;
import U4_T2.Roboters.*;

import java.awt.*;
import java.util.LinkedList;

public class ProduktionsManager extends Thread{

    private HolzbearbeitungsRoboter holzRoboter;
    private MontageRoboter montageRoboter;
    private LackierRoboter lackierRoboter;
    private VerpackungsRoboter verpackungsRoboter;
    private Fabrik meinFabrik;
    private Lager meinLager;
    private LinkedList<Bestellung> zuVerarbeitendeBestellungen;
    private LinkedList<Bestellung> bestellungenInProduktion;


    public ProduktionsManager(Fabrik fabrik, Lager lager){
        meinLager = lager;
        meinFabrik = fabrik;

        zuVerarbeitendeBestellungen = new LinkedList<>();
        bestellungenInProduktion = new LinkedList<>();

        holzRoboter = new HolzbearbeitungsRoboter(0);
        montageRoboter = new MontageRoboter(0);
        lackierRoboter = new LackierRoboter(0);
        verpackungsRoboter = new VerpackungsRoboter(0);

        this.start();
    }

    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung){
        System.out.println("ProduktionsManager: Neue Bestellung "+bestellung.gibBestellungsNr()+" zu verarbeiten.");
        zuVerarbeitendeBestellungen.add(bestellung);
    }

    public void run() {

        while(true){

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Did we finish the production of a Bestellung?
            for(Bestellung bestellung: bestellungenInProduktion){
                bestellung.CheckLieferungStatus();
                if(bestellung.gibAlleProdukteProduziert()){
                    bestellungenInProduktion.remove(bestellung);
                }
            }

            // Do we have product to produce?
            if(!bestellungenInProduktion.isEmpty()){
                Bestellung inProduction = bestellungenInProduktion.getFirst();
                for (Produkt product:inProduction.gibBestellteProdukte()) {
                    // If we have a product not allocated to a robot
                    if(product.aktuellerZustand() != Zustand.PRODUKTION){
                        Roboter firstRobot = product.naechsteProduktionsStation();
                        firstRobot.fuegeProduktHinzu(product);
                    }
                }
            }

            // Are the awaiting orders?
            if(zuVerarbeitendeBestellungen.isEmpty()){
                System.out.println("ProduktionsManager: Bestellung Liste ist leer!");
                continue;
            }

            // Check if we can produce the first order from the list (material available)
            Bestellung toProduce = zuVerarbeitendeBestellungen.getFirst();
            if(meinLager.gibBeschaffungsZeit(toProduce) == 2){
                System.out.println("ProduktionsManager: Nicht genügen Material ab Lager für Bestellung "+toProduce.gibBestellungsNr());

                meinFabrik.lagerAuffuellen();

                continue;
            }

            // Take raw material from lager
            System.out.println("ProduktionsManager: Produzieren geplant für BE "+toProduce.gibBestellungsNr());
            int[] grundMaterial = meinLager.gibBenotigtGrundMaterial(toProduce);
            int[] aktuellesBestand = meinLager.lagerBestand();
            meinLager.lagerAktualisieren(
                    new int[]{
                            aktuellesBestand[0]-grundMaterial[0],
                            aktuellesBestand[1]-grundMaterial[1],
                            aktuellesBestand[2]-grundMaterial[2],
                            aktuellesBestand[3]-grundMaterial[3],
                            aktuellesBestand[4]-grundMaterial[4],
                    }
            );
            // Setz die Bestellung in produktion
            bestellungenInProduktion.add(zuVerarbeitendeBestellungen.removeFirst());

            // Gibt den Roboter die Produkte zu Bauen
            for (Produkt product: toProduce.gibBestellteProdukte()) {
                holzRoboter.fuegeProduktHinzu(product);
                montageRoboter.fuegeProduktHinzu(product);
                lackierRoboter.fuegeProduktHinzu(product);
                verpackungsRoboter.fuegeProduktHinzu(product);

                product.zustandAendern(Zustand.PRODUKTION);
            }
        }

    }

}
