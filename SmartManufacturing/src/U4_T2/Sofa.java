package U4_T2;

/**
 * Klasse Sofa beinhaltet die spezifischen Informationen zum Sofa
 *
 * @author Antonia Albani
 * @version 21.11.2021
 */
public class Sofa extends Produkt
{
    // Diese Klassenvariablen beschreiben die Einheiten, die für die Herstellung 
    // jedes Sofas gebraucht werden, deswegen werden sie nicht als Instanzvariablen
    // sondern als Klassenvariablen deklariert.
    private final static int holzeinheiten = 4;
    private final static int schrauben = 5;
    private final static int kissen = 5;
    private final static int farbeinheiten = 1;
    private final static int kartoneinheiten = 5;
    // Für die Produktion eines SOfas werden 60 Minuten gebraucht
    private final static int produktionsZeit = 60;     
    
    
    /**
     * Konstruktor ruft den Konstruktor der Superklasse auf
     */
    
    public Sofa() 
    {
        super();
    }
    
    /**
     * Mit dieser Methode wird die benötigte Anzahl Holzeinheiten für die Produktion ausgegeben 
     * 
     * @return holzeinheiten
     */    
    
    public static int gibBenoetigteHolzeinheiten()
    {
        return holzeinheiten;
    }   
    
    /**
     * Mit dieser Methode wird die benötigte Anzahl Schrauben für die Produktion ausgegeben 
     * 
     * @return schrauben
     */     
    
    public static int gibBenoetigteSchrauben()
    {
        return schrauben;
    }   

     /**
     * Mit dieser Methode wird die benötigte Anzahl Farbeinheiten für die Produktion ausgegeben 
     * 
     * @return farbeinheiten
     */     
    
    public static int gibBenoetigteFarbeinheiten()
    {
        return farbeinheiten;
    }   
    
    /**
     * Mit dieser Methode wird die benötigte Anzahl Kartoneinheiten für die Produktion ausgegeben 
     * 
     * @return kartoneinheiten 
     */   
    
    public static int gibBenoetigteKartoneinheiten()
    {
        return kartoneinheiten;
    }       
    
    /**
     * Mit dieser Methode wird die benötigte Anzahl Kissen für die Produktion ausgegeben 
     * 
     * @return kissen
     */   
    
    public static int gibBenoetigteAnzahlKissen()
    {
        return kissen;
    }    
    
    
        /**
     * Mit dieser Methode wird die benötigte Produktionszeit ausgegeben
     * 
     */   
    
    public static int gibBenoetigteProduktionszeit()
    {
        return produktionsZeit;
    }     
    
    
}
