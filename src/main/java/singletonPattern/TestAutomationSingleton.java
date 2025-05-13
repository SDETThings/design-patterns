package singletonPattern;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class TestAutomationSingleton {
    private static volatile TestAutomationSingleton instance;
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    private TestAutomationSingleton(){    }
    public static TestAutomationSingleton getInstanceOfJavaSingletonClass(String browser){
        synchronized (TestAutomationSingleton.class) {
            if (instance == null) {
                instance = new TestAutomationSingleton();
            }
        }
        if(instance!=null){
            instance.initializeDriver(browser);
        }
        return instance;
    }
    public void initializeDriver(String browser){
        System.out.println("Browser used: "+browser);
        switch (browser.trim().toLowerCase()){
            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;
            case "edge": tlDriver.set(new EdgeDriver());
                break;
            default: tlDriver.set(new ChromeDriver());
        }
    }
    public WebDriver getDriver(){
       return tlDriver.get();
    }
    public static void quitDriver(){
        if(tlDriver.get()!=null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }

}
