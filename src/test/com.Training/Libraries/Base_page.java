package Libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Base_page implements Constants {
 public static WebDriver driver = null;
 public WebDriverWait wait;
 @Parameters("browsername")
@BeforeTest
    public static void driver_Setup(String browsername) throws InterruptedException {
    System.out.println("Browsername is :"+browsername);
     System.out.println("Thread id is : "+Thread.currentThread().getId());

    if(browsername.equalsIgnoreCase("chrome"))
    {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverWait Wait = new WebDriverWait(driver,15);
        driver.manage().window().maximize();

    }
    else if (browsername.equalsIgnoreCase("firefox"))
    {
        System.setProperty("webdriver.gecko.driver","./drivers/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebDriverWait Wait = new WebDriverWait(driver,15);
        driver.manage().window().maximize();

    }


}

@BeforeMethod
    public void beforeMethod()
{
    System.out.println("=======Before running test case=============");
}

@AfterMethod
    public void afterMethod()
{
    System.out.println("============After running Testcase==============");
}

@AfterTest
    public void teardown()
{
    driver.quit();
}




}
