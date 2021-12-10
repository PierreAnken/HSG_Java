package U3_T2;


public class Lager {

    private final int maxHolzeinheiten = 1000;
    private final int maxSchrauben = 5000;
    private final int maxFarbeeinheiten = 1000;
    private final int maxKartoneinheiten = 1000;
    private final int maxKissen = 100;

    private int vorhandeneHolzeinheiten = 0;
    private int vorhandenSchrauben = 0;
    private int vorhandeneFarbeeinheiten = 0;
    private int vorhandeneKartoneinheiten = 0;
    private int vorhandeneKissen = 0;

    private Lieferant lieferant;

    public Lager() {
        lieferant = new Lieferant();
    }

    public int gibBeschaffungsZeit(Bestellung kundenBestellung) {

        int schraubenBenoetigt = 0;
        int holzBenoetigt = 0;
        int farbenBenoetigt = 0;
        int kartonBenoetigt = 0;
        int kissenBenoetigt = 0;

        int stuhle = kundenBestellung.gibAnzahlStuehle();
        int sofas = kundenBestellung.gibAnzahlSofas();

        for (Produkt produkt : kundenBestellung.liefereBestellteProdukte()) {

            if (produkt instanceof Stuhl) {
                schraubenBenoetigt += Stuhl.gibBenoetigteSchrauben();
                holzBenoetigt += Stuhl.gibBenoetigteHolzeinheiten();
                farbenBenoetigt += Stuhl.gibBenoetigteFarbeinheiten();
                kartonBenoetigt += Stuhl.gibBenoetigteKartoneinheiten();

            } else if (produkt instanceof Sofa) {
                schraubenBenoetigt += Sofa.gibBenoetigteSchrauben();
                holzBenoetigt += Sofa.gibBenoetigteHolzeinheiten();
                farbenBenoetigt += Sofa.gibBenoetigteFarbeinheiten();
                kartonBenoetigt += Sofa.gibBenoetigteKartoneinheiten();
                kissenBenoetigt += Sofa.gibBenoetigteAnzahlKissen();
            }
        }

        if (schraubenBenoetigt > vorhandenSchrauben) {
            return 2;
        }

        if (holzBenoetigt > vorhandeneHolzeinheiten) {
            return 2;
        }

        if (farbenBenoetigt > vorhandeneFarbeeinheiten) {
            return 2;
        }

        if (kartonBenoetigt > vorhandeneKartoneinheiten) {
            return 2;
        }

        if (kissenBenoetigt > vorhandeneKissen) {
            return 2;
        }

        return 0;
    }

    public void lagerBestandAusgeben() {
        System.out.println(
                "vorhandeneHolzeinheiten:" + vorhandeneHolzeinheiten + "\n"
                        + "vorhandenSchrauben:" + vorhandenSchrauben + "\n"
                        + "vorhandeneFarbeeinheiten:" + vorhandeneFarbeeinheiten + "\n"
                        + "vorhandeneKartoneinheiten:" + vorhandeneKartoneinheiten + "\n"
                        + "vorhandeneKissen:" + vorhandeneKissen
        );
    }

    public void lagerAuffuellen() {

        int holzEinheiten = maxHolzeinheiten - vorhandeneHolzeinheiten;
        int schrauben = maxSchrauben - vorhandenSchrauben;
        int farbEinheiten = maxFarbeeinheiten - vorhandeneFarbeeinheiten;
        int kartonEinheiten = maxKartoneinheiten - vorhandeneKartoneinheiten;
        int kissen = maxKissen - vorhandeneKissen;

        boolean erfolgt = lieferant.wareBestellen(
                holzEinheiten,
                schrauben,
                farbEinheiten,
                kartonEinheiten,
                kissen
        );

        if (erfolgt) {
            vorhandeneHolzeinheiten += holzEinheiten;
            vorhandenSchrauben += schrauben;
            vorhandeneFarbeeinheiten += farbEinheiten;
            vorhandeneKartoneinheiten += kartonEinheiten;
            vorhandeneKissen += kissen;
        }

    }

}


