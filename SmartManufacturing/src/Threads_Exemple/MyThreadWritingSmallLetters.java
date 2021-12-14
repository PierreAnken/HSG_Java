package Threads_Exemple;

public class MyThreadWritingSmallLetters extends Thread {
    
    public String comment;
    
    public MyThreadWritingSmallLetters (){
        super();
        comment="No number received yet!";  
    }
    
    public String setComment(int comment){
        this.comment="Following number received: "+ comment;
        return "Comment set for thread "+this.getName();
    }
    
    public void output(String s) {
        System.out.println(this.getName() + ": " + s + " "+ comment);
    }

    public void sleep() {
        output("I will sleep now...");
        try{
            Thread.sleep(5000);
        }   
        catch (InterruptedException ie){
            ie.printStackTrace();
        } 
        output("I woke up...");

    }

    public void run() {
        int i;
        for(i=0;i<5;i++){
            output("I’m running now...");
            sleep();
        }
        output("Program finished...!");
    } // end of run()
    
} // end of class MyThread