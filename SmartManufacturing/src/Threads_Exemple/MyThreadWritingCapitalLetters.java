package Threads_Exemple;

public class MyThreadWritingCapitalLetters extends Thread {
    
    private String comment;
 
    public MyThreadWritingCapitalLetters (){
        super();
        comment="NO NUMBER RECEIVED YET!";
        
    }
    
    public String setComment(int comment){
        this.comment="FOLLOWING NUMBER RECEIVED: "+ comment;
        return "COMMENT SET FOR THREAD "+this.getName();       
    }
    
    public void output(String s) {
        System.out.println(this.getName() + ": " + s + " "+comment);
    }

    public void sleep() {
        output("I WILL SLEEP NOW...");
        try{
            Thread.sleep(1000);
        }   
        catch (InterruptedException ie){
            ie.printStackTrace();
        } 
        output("I WOKE UP...");

    }

    public void run() {
        int i;
        for(i=0;i<9;i++){
            output("I’M RUNNING NOW...");
            sleep();
        }
         output("PROGRAM FINISHED...!");
    } // end of run()
    
 
} // end of class MyThread