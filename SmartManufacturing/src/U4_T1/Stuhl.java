package U4_T1;

/**
 * Klasse Stuhl beinhaltet die spezifischen Informationen zum Stuhl
 *
 * @author Antonia Albani
 * @version 21.11.2021
 */
public class Stuhl extends Produkt
{
    // Diese Klassenvariablen beschreiben die Einheiten, die für die Herstellung 
    // jedes Stuhls gebraucht werden, deswegen werden sie nicht als Instanzvariablen
    // sondern als Klassenvariablen deklariert.
    private final static int holzeinheiten = 2;
    private final static int schrauben = 10;
    private final static int farbeinheiten =2;
    private final static int kartoneinheiten =1;
    
    // Für die Produktion eines Stuhles werden 22 Minuten gebraucht
    private final static int produktionszeit = 22; 
    
    /**
     * Konstruktor ruft den Konstruktor der Superklasse auf
     */
    
    public Stuhl() 
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
     * Mit dieser Methode wird die benötigte Produktionszeit ausgegeben
     * 
     * @return produktionszeit
     */       
    public static int gibBenoetigteProduktionszeit()
    {
        return produktionszeit;
    }       
   
}
