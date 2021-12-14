package U4_T1;

/**
 * Klasse Lager implementiert die Funktianalität eines Lagers, in welchem die notwendigen
 * Materialien für die Produktion gelagert ist
 *
 * @author Antonia Albani
 * @version 22.11.2021
 */
public class Lager
{
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


    /**
     * Konstruktor der Klasse Lager
     */
    public Lager()
    {

    }

    
     /**
     * Methode gibBeschaffungsZeit liefert die Beschaffungszeit in Tagen:
     * 0 Tage, wenn alle Materialien vorhanden sind und 
     * 2 Tage, wenn diese nachbestellt werden müssen
     *
     *
     * @return Beschaffungszeit in Tagen
     */   
    
    public int gibBeschaffungsZeit(Bestellung kundenBestellung){
        int benoetigtesHolz = 0;
        int benoetigteSchrauben = 0;
        int benoetigteFarbe = 0;
        int benoetigterKarton = 0;
        int benoetigteKissen = 0;
        
        for(Produkt produkt : kundenBestellung.liefereBestellteProdukte()){
            if(produkt instanceof Stuhl){
                benoetigtesHolz = benoetigtesHolz + Stuhl.gibBenoetigteHolzeinheiten();
                benoetigteSchrauben = benoetigteSchrauben + Stuhl.gibBenoetigteSchrauben();
                benoetigteFarbe = benoetigteFarbe + Stuhl.gibBenoetigteFarbeinheiten();
                benoetigterKarton = benoetigterKarton + Stuhl.gibBenoetigteKartoneinheiten();
     
            }else if(produkt instanceof Sofa){
                benoetigtesHolz = benoetigtesHolz + Sofa.gibBenoetigteHolzeinheiten();
                benoetigteSchrauben = benoetigteSchrauben + Sofa.gibBenoetigteSchrauben();
                benoetigteFarbe = benoetigteFarbe + Sofa.gibBenoetigteFarbeinheiten();
                benoetigterKarton = benoetigterKarton + Sofa.gibBenoetigteKartoneinheiten();
                benoetigteKissen = Sofa.gibBenoetigteAnzahlKissen();
            }
        }        
        if(vorhandeneHolzeinheiten >= benoetigtesHolz && vorhandeneSchrauben >= benoetigteSchrauben &&  
            vorhandeneKissen >= benoetigteKissen && vorhandeneFarbeinheiten >= benoetigteFarbe && 
            vorhandeneKartoneinheiten >= benoetigterKarton){
                return 0;             
            }else{ 
                return 2;   
        }
    }

    
    /**
     * Methode lagerAuffuellen bestellt alle notwendigen Materialien nach, so dass das Lager wieder voll ist.
     * 
     */  
    
    public void lagerAuffuellen(){
        new Lieferant(this);
    }

    public void wareLiefern(){
        System.out.println("Lager würde ausgefüllt");
        vorhandeneHolzeinheiten=maxHolzeinheiten;
        vorhandeneSchrauben=maxSchrauben;
        vorhandeneFarbeinheiten=maxFarbeinheiten;
        vorhandeneKartoneinheiten=maxKartoneinheiten;
        vorhandeneKissen=maxKissen;
        lagerBestandAusgeben();
    }

    
     /**
     * Methode lagerAuffuellen bestellt alle notwendigen Materialien nach, so dass das Lager wieder voll ist.
     * 
     */    
    
    public void lagerBestandAusgeben(){
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
