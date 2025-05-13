package singletonPatternTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import singletonPattern.TestAutomationSingleton;

public class TestAutomationSingletonTest {
    private WebDriver driver;
    @BeforeMethod()
    @Parameters("browser")
    public void WebdriverInitialization(String browser){
        driver = TestAutomationSingleton.getInstanceOfJavaSingletonClass(browser).getDriver();
    }
    @Test()
    public void launchGoogle()  {
        driver.get("http://google.com");
        System.out.println("title: "+ driver.getTitle());
    }
    @Test()
    public void launchYahoo() {
        driver.get("http://linkedin.com");
        System.out.println("title: "+ driver.getTitle());
    }
    @Test()
    public void launchFacebook() {
        driver.get("http://facebook.com");
        System.out.println("title: "+ driver.getTitle());
    }
    @AfterMethod()
    public void tearDown(){
        TestAutomationSingleton.quitDriver();
    }
}
