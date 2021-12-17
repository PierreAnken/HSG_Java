package U4_T2;

import U4_T2.Roboters.HolzbearbeitungsRoboter;
import U4_T2.Roboters.LackierRoboter;
import U4_T2.Roboters.MontageRoboter;
import U4_T2.Roboters.VerpackungsRoboter;

import java.util.LinkedList;

public class ProduktionsManager extends Thread{

    HolzbearbeitungsRoboter holzRoboter;
    MontageRoboter montageRoboter;
    LackierRoboter lackierRoboter;
    VerpackungsRoboter verpackungsRoboter;
    Fabrik meinFabrik;
    Lager meinLager;
    LinkedList<Bestellung> zuVerarbeitendeBestellungen;
    LinkedList<Bestellung> bestellungenInProduktion;


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

    public void run() {

        while(true){

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            // Are the awaiting orders?
            if(zuVerarbeitendeBestellungen.isEmpty()){
                System.out.println("ProduktionsManager: Bestellung Liste ist leer!");
                continue;
            }

            // Check if we can produce the first order from the list (material available)
            Bestellung toProduce = zuVerarbeitendeBestellungen.getFirst();
            if(meinLager.gibBeschaffungsZeit(toProduce) > 0){
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

        }

    }

}
