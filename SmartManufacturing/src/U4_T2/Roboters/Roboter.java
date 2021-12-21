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
            System.out.println(this.getClass().getSimpleName()+": Produkt ausgegeben to Roboter"+nextRobot.gibNamen());
        }
        else{
            System.out.println(this.getClass().getSimpleName()+": Produkt "+produkt.getClass().getSimpleName()+ " ist gebaut.");
            produkt.zustandAendern(Zustand.BEREIT_FUR_AUSLIEFERUNG);
        }
    }

    public void run() {

        String lastProduktType = "";

        while(true){

            // if we have something to build
            int produktionZeit = 60;

            if(!warteschlange.isEmpty() && produktionsZeit == 0){
                Produkt toProduce = warteschlange.removeFirst();
                produktionZeit = berechneProduktionsZeit(toProduce);
                System.out.println(this.getClass().getSimpleName()+": Bearbeitung von "+toProduce.getClass().getSimpleName()+" "+produktionZeit+" min.");
                setzProduktionsZeit(produktionZeit);
                produziereProdukt(toProduce);

                // if we change produkt type
                if(!lastProduktType.equals(toProduce.getClass().toString())){
                    try {
                        System.out.println(this.getClass().getSimpleName()+": Umstellung zu "+toProduce.getClass().getSimpleName()+" 1 Std warten...");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lastProduktType = toProduce.getClass().toString();
                }
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
