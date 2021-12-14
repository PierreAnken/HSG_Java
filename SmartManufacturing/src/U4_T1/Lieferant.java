package U4_T1;

/**
 * Mit dieser Klasse wird die Lieferzeit des Lieferanten simuliert
 *
 * @author Antonia Albani
 * @version 23.11.2021
 */
public class Lieferant extends Thread
{

    private int waitTime = 48;
    private Lager lager;
 
    /**
     * Konstruktor
     */
    public Lieferant(Lager lager)
    {

        super();
        this.lager = lager;
        start();
        System.out.println("Lieferung gefragt!");

    }

    public void run() {

        while(waitTime > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            waitTime--;
            System.out.println("Wait time remaining:" + waitTime+"h");
        }

        lager.wareLiefern();
    }

}
