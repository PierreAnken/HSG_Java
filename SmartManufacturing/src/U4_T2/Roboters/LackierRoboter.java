package U4_T2.Roboters;

import U4_T2.Produkte.Produkt;
import U4_T2.Produkte.Sofa;

public class LackierRoboter extends Roboter{
    public LackierRoboter() {
        super();
    }

    @Override
    int berechneProduktionsZeit(Produkt produkt) {
        // Sofa: Holzarbeit (30 Minuten) -> Spritzlackierung (5 Minuten) -> Montage (15 Minuten) -> Verpackung (10 Minutes)
        if(produkt.getClass() == Sofa.class){
            return 5;
        }
        // Stuhl: Holzarbeit (10 Minuten) -> Montage (5 Minuten) -> Spritzlackierung (2 Minuten) -> Verpackung (5 Minuten)
        else{
            return 2;
        }
    }
}
