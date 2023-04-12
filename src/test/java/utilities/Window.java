package utilities;

import java.util.Set;

public class Window {
    private static String mainWindowId;
    //window handling:

    /*
    How do you handle multiple window in Selenium?
    -Selenium can handle but can't focus on all of them simultaneously.
    -Every single window has window ID. That is how selenium focuses on one window by Window ID.
     1. Switching to the second window: loop and check if window ID is not equal to main;
     2. Switching to any window when have more than 2: we use title and keep switching until we find the requested title;
     3. How to switch back to main window: switch to main window that we have stored
     */
    public static void switchToSecondWindow(){
        /*
        Window utility class:
        The clsss that we created to work with multiple windows in Selenium. It includes methods like switching to
        second window, switching to any window if there are many, and switching to main page;
         */
         mainWindowId = Driver.getDriver().getWindowHandle();
        Set<String> allWindowIds = Driver.getDriver().getWindowHandles();
        if(allWindowIds.size() < 2){
            System.out.println("There is just one window!");
        }else{
            for(String id: allWindowIds){
                if(!id.equals(mainWindowId)){
                    Driver.getDriver().switchTo().window(id);
                }
            }

        }
    }

    public static void switchToMainWindow(){
        if(mainWindowId != null)
        Driver.getDriver().switchTo().window(mainWindowId);
    }
    public static void switchToWindow(String titleGiven){
         mainWindowId = Driver.getDriver().getWindowHandle();
        Set <String> allWindowIds = Driver.getDriver().getWindowHandles();
        if(allWindowIds.size() > 2){
            for(String id: allWindowIds){
                Driver.getDriver().switchTo().window(id);
                String title = Driver.getDriver().getTitle();
                if(titleGiven.equals(title)){
                    Driver.getDriver().switchTo().window(id);
                    break;
                }
            }
        }else{
            System.out.println("There is just one window found");
        }
    }
}
