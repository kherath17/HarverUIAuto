package pages;

import common.commonSteps;
import common.fileReader;
import envSetup.driverSet;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class fileUploadPage {

    public String verifyUpload() throws AWTException, InterruptedException, IOException, ParseException {
        WebDriver driver = driverSet.driver;

        commonSteps comS = new commonSteps();
        fileReader read = new fileReader();
        comS.navUrl();

        driver.manage().window().maximize();
        driver.findElement(By.xpath(read.readData("landPageFileUp"))).click();
        Thread.sleep(5000);

        //Used actions class since normal click didn't work
        Actions at = new Actions(driver);
        at.click(driver.findElement(By.xpath(read.readData("fileupBtn")))).build().perform();

        Thread.sleep(5000);
        //Used to Copy the value of the path
        StringSelection sel=new StringSelection(read.readData("SampleFile"));
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);

        Thread.sleep(5000);

        //Keyboard functions covered from this class (CTRL+V)
        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(5000);

        driver.findElement(By.xpath(read.readData("uploadBtn"))).click();
        Thread.sleep(5000);
        String actual = driver.findElement(By.xpath(read.readData("actualText"))).getText();
        return actual;

    }
}
