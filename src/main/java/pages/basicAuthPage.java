package pages;

import common.commonSteps;
import common.fileReader;
import envSetup.driverSet;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class basicAuthPage extends commonSteps {

    public String verifyAuth() throws IOException, ParseException {
        WebDriver driver = driverSet.driver;
        fileReader read = new fileReader();
        commonSteps comS = new commonSteps();
        comS.navUrl();

        driver.manage().window().maximize();
        driver.findElement(By.xpath(read.readData("landPagebasicAuth"))).click();

        //passing the URL with the username and password since alert popups were not able to be captured
        String URL = "https://" + read.readData("username") + ":" + read.readData("password") + "@" + "the-internet.herokuapp.com/basic_auth";
        driver.get(URL);

        String actual = driver.findElement(By.xpath("//*[contains(text(),'Congratulations!')]")).getText();
        return actual;

    }
}


