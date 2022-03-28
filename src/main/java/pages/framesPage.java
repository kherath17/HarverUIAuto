package pages;

import common.commonSteps;
import common.fileReader;
import envSetup.driverSet;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class framesPage {

    public String VerifyFrames() throws InterruptedException, IOException, ParseException {
        WebDriver driver = driverSet.driver;

        commonSteps comS = new commonSteps();
        fileReader read = new fileReader();
        comS.navUrl();

        driver.manage().window().maximize();
        driver.findElement(By.xpath(read.readData("landPageFrames"))).click();

        driver.findElement(By.xpath(read.readData("landPageIframes"))).click();
        driver.switchTo().frame(read.readData("iFrameId"));
        Thread.sleep(5000);
        driver.findElement(By.xpath(read.readData("textAreaIfr"))).clear();
        driver.findElement(By.xpath(read.readData("textAreaIfr"))).sendKeys(read.readData("inputText"));
        Thread.sleep(5000);
        String actual = driver.findElement(By.xpath(read.readData("textAreaIfr"))).getText();
        return actual;
    }
}
