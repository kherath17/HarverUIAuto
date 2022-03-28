package pages;

import common.commonSteps;
import common.fileReader;
import envSetup.driverSet;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.IOException;

public class dropDownPage extends driverSet {

    public boolean verifyDropDown() throws IOException, ParseException {


        WebDriver driver = driverSet.driver;
        fileReader read = new fileReader();
        commonSteps comS = new commonSteps();
        comS.navUrl();

        driver.manage().window().maximize();
        driver.findElement(By.xpath(read.readData("landPageDropD"))).click();
        Select dp = new Select(driver.findElement(By.xpath(read.readData("dropDEle"))));
        dp.selectByIndex(2);
        if(driver.findElement(By.xpath(read.readData("selectedDropD"))).isDisplayed()){
            return true;
        }else
        return false;
    }
}
