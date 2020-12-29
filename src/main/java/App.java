import java.util.concurrent.atomic.AtomicInteger;
import concurrency.Race;
import concurrency.Hare;
import concurrency.Tortoise;

public class App {
	public static void main(String[] args) throws Exception {

        tortoiseAndHareRace();

    }


	public static void tortoiseAndHareRace() throws Exception {
		
		 /*
	     * race -----------------------------------------------------------|
	     *        \--tortoise------------------------------------WAKE UP!--/
	     *        \--hare-------------------------NAP----------------------/
	     */
	    AtomicInteger stepCounter = new AtomicInteger();
	    Race race = new Race();
	    Tortoise tortoise = new Tortoise(race, stepCounter);
	    Hare hare = new Hare(race, stepCounter);
	
	    hare.start(); // starts the hare thread
	    tortoise.start(); // starts the tortoise thread
	
	    hare.join(); //joins the main thread
	    tortoise.join(); //joins the main thread
	
	    // how do we know the race is finished?
	    System.out.println("RACE FINISHED");
		
	}
	
	
	public static void manyThreadExample() throws Exception {
	
	    Thread.sleep(5000);
	    for (int a = 0; a < 200; a++) {
	
	        Thread bwmThread = new Thread() {
	            @Override
	            public void run() {
	                for (int i = 0; i < 100; i++) {
	                    try {
	                        sleep(500L);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                    System.out.println("BMW " + i);
	                }
	            }
	        };
	
	        Thread audiThread = new Thread() {
	            @Override
	            public void run() {
	                for (int i = 0; i < 100; i++) {
	                    try {
	                        sleep(5L);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                    System.out.println("AUDI " + i);
	                }
	            }
	        };
	        bwmThread.start();
	        audiThread.start();
	    }
	}
	
	public static void tryCatchExample() {
        String amIANumber = "BLA-12";
        try {
            System.out.println(
                    Integer.valueOf(amIANumber)
            );
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Oops something is wrong");
        } finally {
            System.out.println("All done");
        }
    }
}


