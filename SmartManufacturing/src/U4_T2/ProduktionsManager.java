package U4_T2;

import U4_T2.Produkte.Produkt;
import U4_T2.Roboters.*;

import java.awt.*;
import java.util.LinkedList;

public class ProduktionsManager extends Thread{

    public static HolzbearbeitungsRoboter holzRoboter;
    public static MontageRoboter montageRoboter;
    public static LackierRoboter lackierRoboter;
    public static VerpackungsRoboter verpackungsRoboter;
    private Fabrik meinFabrik;
    private Lager meinLager;
    private LinkedList<Bestellung> zuVerarbeitendeBestellungen;
    private LinkedList<Bestellung> bestellungenInProduktion;


    public ProduktionsManager(Fabrik fabrik, Lager lager){
        meinLager = lager;
        meinFabrik = fabrik;

        zuVerarbeitendeBestellungen = new LinkedList<>();
        bestellungenInProduktion = new LinkedList<>();

        holzRoboter = new HolzbearbeitungsRoboter();
        montageRoboter = new MontageRoboter();
        lackierRoboter = new LackierRoboter();
        verpackungsRoboter = new VerpackungsRoboter();

        this.start();
    }

    public void fuegeZuVerarbeitendeBestellungenHinzu(Bestellung bestellung){
        System.out.println("ProduktionsManager: Neue Bestellung "+bestellung.gibBestellungsNr()+" zu verarbeiten.");
        zuVerarbeitendeBestellungen.add(bestellung);
    }

    public synchronized LinkedList<Bestellung> getBestellungenInProduktion() {
        return bestellungenInProduktion;
    }


    public void run() {

        while(true){

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Did we finish the production of a Bestellung?
            for(Bestellung bestellung: getBestellungenInProduktion()){
                bestellung.CheckLieferungStatus();
                if(bestellung.gibAlleProdukteProduziert()){
                    getBestellungenInProduktion().remove(bestellung);
                    System.out.println("Bestellung "+bestellung.gibBestellungsNr()+" bereits für Lieferung.");
                    break;
                }
            }

            // Do we have product to produce?
            if(!getBestellungenInProduktion().isEmpty()){
                Bestellung inProduction = getBestellungenInProduktion().getFirst();
                for (Produkt product:inProduction.gibBestellteProdukte()) {
                    // If we have a product not allocated to a robot
                    if(product.aktuellerZustand() != Zustand.PRODUKTION){
                        Roboter firstRobot = product.naechsteProduktionsStation();
                        if(firstRobot != null){
                            firstRobot.fuegeProduktHinzu(product);
                            product.zustandAendern(Zustand.PRODUKTION);
                        }
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
            System.out.println("ProduktionsManager: Produzieren geplant für BE "+toProduce.gibBestellungsNr());
            getBestellungenInProduktion().add(zuVerarbeitendeBestellungen.removeFirst());


        }

    }

}
