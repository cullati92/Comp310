import java.util.Random;
import java.util.Scanner;


public class TrainRoute {

	private QueueInterface < Customer > line; //instance of queue
    private int numberOfArrivals;
    private int numberServed;
    private int totalTimeWaited;
    private int stations;
    private int startStation;
    private int terminalInterval = 5;
    private int trainCapacity = 55;
    private int d1 = 0;
    
    public TrainRoute ()  // constructor
    {
        line = new ArrayQueue<Customer>();
        reset ();
    }
    
  //simulates line waiting to be boarded using queue
    public void simulate (int duration, double arrivalProbability,int maxTransactionTime) 
    {
    	d1 = duration; //holds duration to whole program
    	Random rand = new Random();
    	startStation = rand.nextInt(10); //random number between 0-10
        int transactionTimeLeft = 0;
        for (int clock = 0 ; clock < duration ; clock++)
        {
            if (Math.random () < arrivalProbability)
            {
                numberOfArrivals++;
                int transactionTime = (int) (Math.random () * maxTransactionTime +      1);
                Customer nextArrival = new Customer(clock,transactionTime,numberOfArrivals, stations, startStation);
                line.enqueue (nextArrival); //randomizes new arrivals into queue
                /*System.out.println ("Customer " + numberOfArrivals
                        + " enters line at time " + clock
                        + ". Transaction time is " + transactionTime);*/
            } // end if
            if (transactionTimeLeft > 0)
                transactionTimeLeft--;
            else if (!line.isEmpty ())
            {
                Customer nextCustomer = line.dequeue (); //boards customer
                if(trainCapacity != numberServed){ //boards until train is full
                	numberServed++;
                }
                transactionTimeLeft = nextCustomer.getTransactionTime () - 1;
                int timeWaited = clock - nextCustomer.getArrivalTime ();
                totalTimeWaited = totalTimeWaited + timeWaited;
                
                /*System.out.println ("Customer " + nextCustomer.getCustomerNumber ()
                        + " begins service at time " + clock
                        + ". Time waited is " + timeWaited);*/
            } // end if
        } // end for
    }
    
    //clears queue and all data
    public final void reset ()
    {
        line.clear ();
        numberOfArrivals = 0;
        numberServed = 0;
        totalTimeWaited = 0;
        stations = 0;
        startStation = 0;
    }
    
    //displays all data for queue lines and station number
    public void displayResults ()
    {
        System.out.println ();
        System.out.println ("Passengers boarded = " + numberServed);
        System.out.println ("Total time waited = " + totalTimeWaited);
        double averageTimeWaited = ((double) totalTimeWaited) / numberServed;
        System.out.println ("Average time waited = " + averageTimeWaited);
        int leftInLine = numberOfArrivals - numberServed;
        System.out.println ("Number left in line = " + leftInLine + "\n");
       
    }
    
   
    //gets total time for train to run and number of stations
    //loops through train route until totam time ends
    public void trainStations()
    {
    	Scanner keyboard = new Scanner(System.in);
    	System.out.println("How long shall the train run for? ");
    	int totalTime = keyboard.nextInt();
    	System.out.println("Total Time: " + totalTime);
    	TrainRoute route = new TrainRoute();
    	System.out.print("How many number of stations would you like?: ");
    	int stations = keyboard.nextInt();
    	
    	System.out.println("Stations: " + stations);
    	while(totalTime >=0){
    		for(int i=1; i < stations+1;i++){
    			System.out.print("Station " + i + ": ");
    			route.simulate(100,.5,3);
    			route.displayResults();
    			totalTime = (totalTime - (d1 + terminalInterval));
    			route.reset();
    		}
    	}
    	if(totalTime <=0)
    		System.exit(0);
    	
    }
    
    //creates instance of train route and calls trainstations()
    public static void main(String args [])
    {
    	TrainRoute sequence = new TrainRoute();
    	sequence.trainStations();
    }
}
