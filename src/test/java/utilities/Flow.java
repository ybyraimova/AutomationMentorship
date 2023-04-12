package utilities;

import org.openqa.selenium.interactions.Actions;

public class Flow {
    //create a static method wait that accepts integer milliseconds;
    //The method simply used T.s. with exception handled;
    //Flow.wait(500);

    //T.s. is risky if interruption happens.

    public static void wait(int ms){
        /*
        Flow utility class:
        The utility class that we created to control Automation flow such as scrolling the pages, pausing the program
        execution, etc.
         */
        try{
            Thread.sleep(ms);
        }catch (InterruptedException e){
            System.out.println("Interruption happened");
        }
    }

    //We can scroll down and up by creating object and then locating element. The easier approach is:
    public static void scrollDown(int deltaY){
        Actions action = new Actions(Driver.getDriver());
        action.scrollByAmount(0, deltaY).perform();
    }

    public static void scrollUp(int deltaY){
        Actions action = new Actions(Driver.getDriver());
        action.scrollByAmount(0, -deltaY).perform();
    }


}
