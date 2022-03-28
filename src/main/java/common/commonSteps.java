package common;

import envSetup.driverSet;
import org.openqa.selenium.WebDriver;

public class commonSteps {
    String landUrl ="https://the-internet.herokuapp.com/";

    public void navUrl(){
        WebDriver driver = driverSet.driver;
        driver.get(landUrl);
    }
}
