package LG_U4_T1;

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
    
    
    private int vorhandeneHolzeinheiten;
    private int vorhandeneSchrauben;
    private int vorhandeneFarbeinheiten;
    private int vorhandeneKartoneinheiten;
    private int vorhandeneKissen;  
    
    private Lieferant lieferant;  
    
    
    /**
     * Konstruktor der Klasse Lager
     */
    public Lager()
    {
        // alle globalen Variablen werden instanziert
        vorhandeneHolzeinheiten = maxHolzeinheiten;
        vorhandeneSchrauben = maxSchrauben;
        vorhandeneFarbeinheiten = maxFarbeinheiten;
        vorhandeneKartoneinheiten = maxKartoneinheiten;
        vorhandeneKissen = maxKissen;
        lieferant = null;
    }

    
     /**
     * Methode gibBeschaffungsZeit liefert die Beschaffungszeit in Tagen:
     * 0 Tage, wenn alle Materialien vorhanden sind und 
     * 2 Tage, wenn diese nachbestellt werden müssen
     *
     * @param Bestellung  eine Kundenbestellung mit allen bestellten Produkten im Array of Produkt
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
     * Methode wareLiefern ermöglicht es dem Lieferanten die Ware zu liefern.
     * Die vorhandenen Produkte werden wieder auf die maximale Anzahl Produkte gesetzt
     * 
     */    
    
    public void wareLiefern(){
        vorhandeneHolzeinheiten=maxHolzeinheiten;
        vorhandeneSchrauben=maxSchrauben;
        vorhandeneFarbeinheiten=maxFarbeinheiten;
        vorhandeneKartoneinheiten=maxKartoneinheiten;
        vorhandeneKissen=maxKissen;
        System.out.println("Lager: Ware wurde geliefert! ");   
        lagerBestandAusgeben();
    }
    
    
    
    /**
     * Methode lagerAuffuellen bestellt alle notwendigen Materialien nach, so dass das Lager wieder voll ist.
     * 
     */  
    
    public void lagerAuffuellen(){
        lieferant = new Lieferant(this);
        System.out.println("Lager: Ware wurde nachbestellt! ");
        lieferant.start();
    }
    
     /**
     * Methode lagerAuffuellen bestellt alle notwendigen Materialien nach, so dass das Lager wieder voll ist.
     * 
     */    
    
    public void lagerBestandAusgeben(){
            System.out.println("*********************************************");   
            System.out.println("Lager: Lagerbestand: ");
            System.out.println("Vorhandene Holzeinheiten: " + vorhandeneHolzeinheiten);
            System.out.println("Vorhandene Schrauben: " + vorhandeneSchrauben);
            System.out.println("Vorhandene Farbe: " + vorhandeneFarbeinheiten);
            System.out.println("Vorhandene Kartoneinheiten: " + vorhandeneKartoneinheiten);
            System.out.println("Vorhandene Kissen: " + vorhandeneKissen);   
            System.out.println("*********************************************"); 
            System.out.println(); 
    }
    
}
