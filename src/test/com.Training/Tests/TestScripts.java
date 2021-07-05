package Tests;

import Libraries.Base_page;
import Libraries.Constants;
import Libraries.DataProviderCLass;
import Libraries.ExcelManipulations;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.seleniumhq.jetty9.util.thread.ThreadPool;
import org.testng.Assert;
import org.testng.annotations.Test;
import pom.loginPo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestScripts extends Base_page implements Constants {

    @Test(priority = 1,dataProvider = "Login_credential",dataProviderClass = DataProviderCLass.class,description = "Login process with valid and invalid values")
    public void Login(String username, String Password) throws IOException {
       try{
           loginPo loginpageobject = new loginPo(driver);
           System.out.println("Username  : "+username+" Password : "+Password);
           loginpageobject.signIn(username,Password);
       }
       catch (Exception e)
       {
           System.out.println(e.getMessage());
           System.out.println(e.getCause());
           e.printStackTrace();
           Assert.fail("=================Invalid Login Credentials==================");
       } }

    @Test(threadPoolSize = 3,invocationCount = 6,timeOut = 1000)
    public void testone()
    {
        System.out.println("WIth Thread pool");
        System.out.println("Iam inside testone method"+Thread.currentThread().getId());
    }
    @Test()
    public void testwo()
    {
        System.out.println("Iam inside testtwo method"+Thread.currentThread().getId());
    }
    @Test()
    public void testthree()
    {
        System.out.println("Iam inside testthree method"+Thread.currentThread().getId());
    }
    @Test()
    public void testfour()
    {
        System.out.println("Iam inside testfour method"+Thread.currentThread().getId());
    }
    @Test()
    public void testfive()
    {
        System.out.println("Iam inside testfive method"+Thread.currentThread().getId());
    }
    @Test()
    public void testsix()
    {
        System.out.println("Iam inside testsix method"+Thread.currentThread().getId());
    }
    @Test()
    public void testsevenlast()
    {
        System.out.println("Iam inside test seven method"+Thread.currentThread().getId());
    }
    @Test()
    public void eight()
    {
        System.out.println("Iam inside test eight method"+Thread.currentThread().getId());
    }
    @Test()
    public void nine()
    {
        System.out.println("Iam inside test nine method"+Thread.currentThread().getId());  // for checking pull request.
    }



}
