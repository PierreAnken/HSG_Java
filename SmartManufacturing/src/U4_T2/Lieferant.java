package U4_T2;

/**
 * Mit dieser Klasse wird die Lieferzeit des Lieferanten simuliert
 *
 * @author Antonia Albani
 * @version 23.11.2021
 */
public class Lieferant extends Thread
{

    private int waitTime = 5;
    private Lager lager;
 
    /**
     * Konstruktor
     */
    public Lieferant(Lager lager)
    {

        super();
        this.lager = lager;
        start();
        System.out.println("Lieferant: Neue Bestellung bekommen");

    }

    public void run() {

        while(waitTime > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            waitTime--;
            System.out.println("Lieferant: Lieferung im " + waitTime+"h");
        }

        lager.wareLiefern();
    }

}
