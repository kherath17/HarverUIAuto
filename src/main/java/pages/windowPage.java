package pages;

import common.commonSteps;
import common.fileReader;
import envSetup.driverSet;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class windowPage {

    WebDriver driver = driverSet.driver;
    String parentWindow;
    public String verifyWindow() throws IOException, ParseException {

        commonSteps comS = new commonSteps();
        fileReader read = new fileReader();
        comS.navUrl();

        driver.findElement(By.xpath(read.readData("landPageWindows"))).click();
        parentWindow = driver.getWindowHandle();
        driver.findElement(By.xpath(read.readData("newWindow"))).click();

        Set<String> s = driver.getWindowHandles();

        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {

            String child_window = I1.next();
            driver.switchTo().window(child_window);

        }
        String actual = driver.getTitle();
        return actual;
    }

    public String switchBack(){
        driver.switchTo().window(parentWindow);
        String actual = driver.getTitle();
        return actual;
    }
}
