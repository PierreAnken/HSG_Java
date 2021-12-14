package Threads_Exemple;

public class TestThreads extends Thread{

    
    public void run (){ 
        System.out.println("Run method of TestThread started!");        
    }
      
    public static void main(String[] args) {
        Thread test=new TestThreads();
        test.start();
        
        MyThreadWritingCapitalLetters writingCapital = new MyThreadWritingCapitalLetters();
        writingCapital.start();
        System.out.println(writingCapital.getName() + ": THREAD HAS BEEN STARTED ...");
        
        MyThreadWritingSmallLetters writingSmall = new MyThreadWritingSmallLetters();
        writingSmall.start();
        System.out.println(writingSmall.getName() + ": thread has been started ...");      

        int i;
        for (i=0;i<10;i++){
            System.out.println(test.getName()+" " + writingCapital.setComment(i));
            try{
                Thread.sleep(1000);
            }   
            catch (InterruptedException ie){
                System.out.println("Thread Exception");
                ie.printStackTrace();
            }
            System.out.println(test.getName()+" " + writingSmall.setComment(i));
        }
         
        System.out.println("Main program finished ...");

    } // end of main()
} // end of class MyThread