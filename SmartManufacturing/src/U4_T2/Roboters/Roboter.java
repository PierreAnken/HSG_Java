package U4_T2.Roboters;

import U4_T2.Produkt;

import java.util.LinkedList;

public abstract class Roboter extends Thread{

    protected LinkedList<Produkt> warteschlange;
    protected String name;
    protected int produktionsZeit;

    public Roboter(){
        warteschlange = new LinkedList<>();
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

    }

    public void run() {

        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //System.out.println("Roboter working");
        }

    }

}
