package LG_U4_T1;

/**
 * Mit dieser Klasse wird die Lieferzeit des Lieferanten simuliert
 *
 * @author Antonia Albani
 * @version 23.11.2021
 */
public class Lieferant extends Thread
{
    private Lager lager;
 
    /**
     * Konstruktor
     */
    public Lieferant(Lager lager)
    {
        super();
        this.lager=lager;
    }
    
    public void run(){
        try{
            //Simulation der Wartezeit bei der Nachbestellung der Ware
            //Wartezeit = 2 Tage; Im Programm ist 1 Tag = 1 Sek.
            //Somit muss der Lieferant 48 Sek. oder 48'000 msec warten, 
            //bzw. der Thread muss 48'000 msec schlafen.
            Thread.sleep(48000);
            System.out.println("Lieferant: Ware wird versandt"); 
            lager.wareLiefern();
        }catch(InterruptedException ie){
            System.out.println("Lieferant: Thread Exception!");
        }
    }

}
