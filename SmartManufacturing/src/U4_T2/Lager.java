package U4_T2;

/**
 * Klasse Lager implementiert die Funktianalität eines Lagers, in welchem die notwendigen
 * Materialien für die Produktion gelagert ist
 *
 * @author Antonia Albani
 * @version 22.11.2021
 */
public class Lager {
    //Gibt  
    private final static int maxHolzeinheiten = 1000;
    private final static int maxSchrauben = 50000;
    private final static int maxFarbeinheiten = 1000;
    private final static int maxKartoneinheiten = 1000;
    private final static int maxKissen = 100;


    private int vorhandeneHolzeinheiten = 0;
    private int vorhandeneSchrauben = 0;
    private int vorhandeneFarbeinheiten = 0;
    private int vorhandeneKartoneinheiten = 0;
    private int vorhandeneKissen = 0;

    Lieferant lieferant;

    /**
     * Methode gibBeschaffungsZeit liefert die Beschaffungszeit in Tagen:
     * 0 Tage, wenn alle Materialien vorhanden sind und
     * 2 Tage, wenn diese nachbestellt werden müssen
     *
     * @return Beschaffungszeit in Tagen
     */

    public int gibBeschaffungsZeit(Bestellung kundenBestellung) {

        int[] grundMaterial = gibBenotigtGrundMaterial(kundenBestellung);

        if (
                grundMaterial[0] <= vorhandeneHolzeinheiten
                        && grundMaterial[1] <= vorhandeneSchrauben
                        && grundMaterial[2] <= vorhandeneFarbeinheiten
                        && grundMaterial[3] <= vorhandeneKartoneinheiten
                        && grundMaterial[4] <= vorhandeneKissen
        ) {
            return 0;
        } else {
            return 2;
        }
    }

    public void lagerAktualisieren(int[] newStock){
        // [Holz] - [Schrauben] - [Farben] - [Karton] - [Kissen]
        vorhandeneHolzeinheiten = newStock[0];
        vorhandeneSchrauben = newStock[1];
        vorhandeneFarbeinheiten = newStock[2];
        vorhandeneKartoneinheiten = newStock[3];
        vorhandeneKissen = newStock[4];
    }

    public int[] lagerBestand(){
        // [Holz] - [Schrauben] - [Farben] - [Karton] - [Kissen]
        return new int[]{
                vorhandeneHolzeinheiten,
                vorhandeneSchrauben ,
                vorhandeneFarbeinheiten,
                vorhandeneKartoneinheiten,
                vorhandeneKissen
        };

    }

    public int[] gibBenotigtGrundMaterial(Bestellung kundenBestellung) {

        // [Holz] - [Schrauben] - [Farben] - [Karton] - [Kissen]
        int[] grundMaterial = new int[]{0, 0, 0, 0, 0};

        for (Produkt produkt : kundenBestellung.liefereBestellteProdukte()) {
            if (produkt instanceof Stuhl) {
                grundMaterial[0] += Stuhl.gibBenoetigteHolzeinheiten();
                grundMaterial[1] += Stuhl.gibBenoetigteSchrauben();
                grundMaterial[2] += Stuhl.gibBenoetigteFarbeinheiten();
                grundMaterial[3] += Stuhl.gibBenoetigteKartoneinheiten();

            } else if (produkt instanceof Sofa) {
                grundMaterial[0] += Sofa.gibBenoetigteHolzeinheiten();
                grundMaterial[1] += Sofa.gibBenoetigteSchrauben();
                grundMaterial[2] += Sofa.gibBenoetigteFarbeinheiten();
                grundMaterial[3] += Sofa.gibBenoetigteKartoneinheiten();
                grundMaterial[4] += Sofa.gibBenoetigteAnzahlKissen();
            }
        }
        return grundMaterial;
    }

    /**
     * Methode lagerAuffuellen bestellt alle notwendigen Materialien nach, so dass das Lager wieder voll ist.
     */

    public void lagerAuffuellen() {
        if(lieferant == null)
            lieferant = new Lieferant(this);
    }

    public void wareLiefern() {
        System.out.println("Lager würde ausgefüllt");
        vorhandeneHolzeinheiten = maxHolzeinheiten;
        vorhandeneSchrauben = maxSchrauben;
        vorhandeneFarbeinheiten = maxFarbeinheiten;
        vorhandeneKartoneinheiten = maxKartoneinheiten;
        vorhandeneKissen = maxKissen;

        lieferant = null;
    }


    /**
     * Methode lagerAuffuellen bestellt alle notwendigen Materialien nach, so dass das Lager wieder voll ist.
     */

    public void lagerBestandAusgeben() {
        System.out.println("\nLagerbestand: ");
        System.out.println("Vorhandene Holzeinheiten: " + vorhandeneHolzeinheiten);
        System.out.println("Vorhandene Schrauben: " + vorhandeneSchrauben);
        System.out.println("Vorhandene Farbe: " + vorhandeneFarbeinheiten);
        System.out.println("Vorhandene Kartoneinheiten: " + vorhandeneKartoneinheiten);
        System.out.println("Vorhandene Kissen: " + vorhandeneKissen);
        System.out.println();
        System.out.println();
    }

}
