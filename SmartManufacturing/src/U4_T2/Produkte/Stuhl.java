package U4_T2.Produkte;

import U4_T2.Roboters.HolzbearbeitungsRoboter;
import U4_T2.Roboters.LackierRoboter;
import U4_T2.Roboters.MontageRoboter;
import U4_T2.Roboters.VerpackungsRoboter;

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

    @Override
    void setzteProduktionsAblauf() {
        // Stuhl: Holzarbeit (10 Minuten) -> Montage (5 Minuten) -> Spritzlackierung (2 Minuten) -> Verpackung (5 Minuten)
        produktionsAblauf.add(new HolzbearbeitungsRoboter(10));
        produktionsAblauf.add(new MontageRoboter(5));
        produktionsAblauf.add(new LackierRoboter(2));
        produktionsAblauf.add(new VerpackungsRoboter(5));
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
