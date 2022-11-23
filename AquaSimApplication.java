import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/** Aquarium Lab Series: <br>    
 *      The AquaSimApplication class contains the main function that will add
 *      the user inputted number of fish and moves the fish the user inputted
 *      amount <br>
 *
 * Modifications: <br>
 *   23 March 2008,  Alyce Brady,  Created skeleton main that constructs and
 *                                 displays an empty aquarium.<br>
 *   13 January 2021, Kylah Davis, Modified add the user input amount of fish 
 *   and moves those fish the amount os steps the user inputs.
 *   If the amount of steps makes the fish hit a wall the fish 
 *   will change direction <br>
 *
 *  @author  Kylah Davis
 *  @version 19 January 2021 
 *  @see AquariumController
 **/
public class AquaSimApplication
{
    /**
     *  This is the main function.  It executes the program.
     *  @param    String args[] is never used
     **/
    public static void main(String args[])
    {
        System.out.println("Welcome to the aquarium simulation.");

        // CONSTRUCT OBJECTS NEEDED FOR THE AQUARIUM SIMULATION.

        // Construct the aquarium.  Specify its dimensions when creating it.
        Aquarium aqua;                 // create reference to an Aquarium ...
        aqua = new Aquarium(600, 480); // ... object that has now been created

        // Construct fish and add them to the aquarium.
        //      CODE MISSING HERE!
        Random gen = new Random();
        int randNum;
        AquaFish nemo = new AquaFish(aqua, Color.ORANGE);
        AquaFish dory = new AquaFish(aqua, Color.PINK);
        AquaFish gill = new AquaFish(aqua, Color.YELLOW);

        //ArrayList of fish
        ArrayList<AquaFish> SchoolFish;
        SchoolFish = new ArrayList<AquaFish>();

        // Construct a graphical user interface (GUI) to display and control
        // the simulation.  The user interface needs to know about the
        // aquarium, so we pass aqua to the user interface constructor.
        AquaSimGUI userInterface;              // create reference to GUI ...
        userInterface = new AquaSimGUI(aqua, true, true);  // ... and then GUI itself

        // Tell the user how to start the aquarium simulation.
        System.out.println("Press the Start button to start the simulation.");

        // Now wait for the user to press the start button.
        userInterface.waitForStart();

        // Draw the initial view of the aquarium and its contents.
        userInterface.showAquarium();

        int steps = userInterface.getNumberOfSteps();
        // RUN THE AQUARIUM SIMULATION.
        int numFish = userInterface.getNumberOfFish();
        
        
      

        for (int i = 0; i < numFish; i++)
        {
            // adds randomly colored fish to ArrayList
            randNum = gen.nextInt(25);
            if(randNum <= 8 )
            {
                //adds a pink fish to ArrayList
                SchoolFish.add(new AquaFish(aqua,Color.PINK));
            }
            else if (randNum < 12)
            {
                //adds magenta fish to ArrayList
                SchoolFish.add(new AquaFish(aqua, Color.MAGENTA));
            }
            else if (randNum < 17)
            {
                //adds yellow fish to ArrayList
                SchoolFish.add(new AquaFish(aqua, Color.YELLOW)); 
            }
            else if (randNum < 18)
            {
                //adds blue fish to ArrayList
                SchoolFish.add(new AquaFish(aqua, Color.BLUE)); 
            }
            else if (randNum < 20)
            {
                //adds green fish to ArrayList
                SchoolFish.add(new AquaFish(aqua, Color.GREEN)); 
            }
            else if (randNum < 21)
            {
                //adds red fish to ArrayList
                SchoolFish.add(new AquaFish(aqua, Color.RED)); 
            }
            else
            {   
                //adds orange fish to ArrayList
                SchoolFish.add(new AquaFish(aqua, Color.ORANGE));
            }
        }

        for( int i = 0; i < SchoolFish.size(); i++)
        {
            //add the fish to the aquarium 
            aqua.add(SchoolFish.get(i));
        }

        // Make the fish move.
        userInterface.showAquarium();
       // int fishSize = SchoolFish.size();

        for ( int i = 0; i < steps; i++ ) 
        {
            
            for( AquaFish fish: SchoolFish )
            {
                //if the the fish is at a wall change direction then move
                randNum = gen.nextInt(4);
                if(fish.atWall() || randNum == 3)
                {
                    fish.changeDir();
                    fish.moveForward();
                }
                // else just move
                else
                    fish.moveForward();
            }
            // redisplay aquarium
            userInterface.showAquarium();
        }


        // WRAP UP.

        // Remind user how to quit application.
        userInterface.println ("Close GUI display window to quit.");

    }//end main

}//end class
