package pom;

import Libraries.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;

public class loginPo implements Constants {

    public WebDriver driver;
    public WebDriverWait wait;

    public loginPo(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement username;
    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement password;
    @FindBy(xpath = "//button[@id='submit_login']")
    private WebElement submitbutton;
    @FindBy(xpath = "//li//a[@id='header_shopname']")
    private WebElement shopvisiblelink;
    @FindBy(xpath ="//a//span[contains(text(),'Marketplace')]")
    private WebElement marketplace;
    @FindBy(xpath = "//li//a[contains(text(),'Sellers')]")
    private WebElement sellerlink;
    @FindBy(xpath = "//p//strong[text()='There is one error.']")
    private WebElement Invalidmessage;


    public void signIn(String email, String pass) throws InterruptedException {
        driver.get(url);
        wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(username));
        System.out.println("This is title of the page : "+driver.getTitle());
        System.out.println("Current url of the page : "+driver.getCurrentUrl());
        username.clear();
        password.clear();
        Thread.sleep(1000);
        username.sendKeys(email);
        password.sendKeys(pass);
        submitbutton.click();
        Thread.sleep(3000);
     //   wait.until(ExpectedConditions.visibilityOf(shopvisiblelink)).isDisplayed();

      //  if(Invalidmessage.size()>0)
        try {
            if (Invalidmessage.isDisplayed()) {
                System.out.println("Invalid Creadentials : The username or password is wrong.");
                Assert.fail();
            }
        }
        catch (Exception e)
        {
            System.out.println("Inside catch");
            wait.until(ExpectedConditions.visibilityOf(shopvisiblelink)).isDisplayed();
            System.out.println("Logined Inn Successfully ");
        }

      /*  Actions action = new Actions(driver);
        action.moveToElement(marketplace).build().perform();
        marketplace.click();
        action.moveToElement(sellerlink).build().perform();
        sellerlink.click();
        System.out.println("Done task completed");*/
        }
    }




