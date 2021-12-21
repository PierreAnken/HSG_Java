package U4_T2.Roboters;

import U4_T2.Produkte.Produkt;
import U4_T2.Zustand;

import java.util.LinkedList;

public abstract class Roboter extends Thread{

    protected LinkedList<Produkt> warteschlange;
    protected String name;
    protected int produktionsZeit;

    public Roboter(){
        warteschlange = new LinkedList<>();
        this.produktionsZeit = 0;
        this.start();
    }


    public synchronized void fuegeProduktHinzu(Produkt produkt){
        warteschlange.add(produkt);
    }

    abstract int berechneProduktionsZeit(Produkt produkt);

    public void setzProduktionsZeit(int zeit){
        produktionsZeit = zeit;
    }

    public String gibNamen(){
        return this.getClass().getSimpleName();
    }


    public void produziereProdukt(Produkt produkt){

        Roboter nextRobot = produkt.naechsteProduktionsStation();
        // pass it to next robot
        if(nextRobot != null){
            nextRobot.fuegeProduktHinzu(produkt);
            System.out.println("Produkt ausgegeben to Roboter"+nextRobot.gibNamen());
        }
        else{
            System.out.println("Produkt "+produkt.getClass().getSimpleName()+ " ist gebaut.");
            produkt.zustandAendern(Zustand.BEREIT_FUR_AUSLIEFERUNG);
        }
    }

    public void run() {

        while(true){

            // if we have something to build
            int produktionZeit = 60;
            if(!warteschlange.isEmpty() && produktionsZeit == 0){
                Produkt toProduce = warteschlange.removeFirst();
                produktionZeit = berechneProduktionsZeit(toProduce);
                System.out.println("Bearbeitung von "+toProduce.getClass().getSimpleName()+" von "+this.getClass().getSimpleName()+" "+produktionZeit+" min.");
                setzProduktionsZeit(produktionZeit);
                produziereProdukt(toProduce);

            }

            try {
                Thread.sleep(1000L *produktionZeit/60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            produktionsZeit = 0;

        }

    }

}
