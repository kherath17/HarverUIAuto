import envSetup.driverSet;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import java.awt.*;
import java.io.IOException;

public class TestFlow {

    driverSet driverIn = new driverSet();
    @BeforeClass
    public void start(){
        driverIn.setUp();
    }


    @Test(priority = 1,testName = "Verification of DropDown")
    public void verifyDropDown() throws IOException, ParseException {
        dropDownPage dropd = new dropDownPage();
        Assert.assertEquals(dropd.verifyDropDown(),true);
    }


    @Test(priority = 2,testName = "Verification of Authentication")
    public void verifyAuth() throws IOException, ParseException {
        basicAuthPage auth = new basicAuthPage();
        Assert.assertEquals(auth.verifyAuth(),"Congratulations! You must have the proper credentials.");
    }


    @Test(priority=3,testName = "Verification of File Upload")
    public void verifyFileUp() throws InterruptedException, AWTException, IOException, ParseException {
        fileUploadPage up = new fileUploadPage();
        Assert.assertEquals(up.verifyUpload(),"File Uploaded!");
    }


    @Test(priority=4,testName = "Verification of Switching iFrames")
    public void verifyFrames() throws InterruptedException, IOException, ParseException {
        framesPage frame = new framesPage();
        Assert.assertEquals(frame.VerifyFrames(),"Gapstars to the Moon");
    }


    @Test(priority = 5,testName = "Verify Switching Window Tabs")
    public void verifyWindow() throws IOException, ParseException {
        windowPage window = new windowPage();
        Assert.assertEquals(window.verifyWindow(),"New Window");
        window.switchBack();
        Assert.assertEquals(window.switchBack(),"The Internet");
    }

    @AfterClass
    public void driverQuit(){
        driverIn.tearDown();
    }
}
