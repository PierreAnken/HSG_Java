package U4_T2.Roboters;

import U4_T2.Produkte.Produkt;
import U4_T2.Zustand;

import java.util.LinkedList;

public abstract class Roboter extends Thread{

    protected LinkedList<Produkt> warteschlange;
    protected String name;
    protected int produktionsZeit;

    public Roboter(int produktionsZeit){
        warteschlange = new LinkedList<>();
        this.produktionsZeit = produktionsZeit;
        this.start();
    }


    public void fuegeProduktHinzu(Produkt produkt){
        warteschlange.add(produkt);
    }

    public void setzteProduktionsZeit(int zeit){

    }

    public String gibNamen(){
        return "";
    }


    public void produziereProdukt(Produkt produkt){

        Roboter nextRobot = produkt.naechsteProduktionsStation();
        // pass it to next robot
        if(nextRobot != null){
            nextRobot.fuegeProduktHinzu(produkt);
            System.out.println("Produkt ausgegeben to Roboter"+nextRobot.getName());
        }
        else{
            System.out.println("Produkt "+produkt.getClass()+ " is gebaut.");
            produkt.zustandAendern(Zustand.BEREIT_FUR_AUSLIEFERUNG);
        }
    }

    public void run() {

        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // if we have something to build
            if(!warteschlange.isEmpty()){
                Produkt toProduce = warteschlange.removeFirst();
                produziereProdukt(toProduce);
            }

        }

    }

}
