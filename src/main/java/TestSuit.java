

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static java.awt.SystemColor.text;
import static java.time.Duration.*;

public class TestSuit {
    protected static WebDriver driver;
    private static Calendar timestamp;
    WebDriverWait wait = new WebDriverWait(driver, ofSeconds(20));
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    public static void typeText(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    @BeforeMethod
        public static void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public static void closeBrowser() {
        driver.close();
    }

    @Test

    public static void userShouldBeAbleToRegister(Object expectedresult) {
        openBrowser();
        clickOnElement(By.className("ico-register"));
        typeText(By.id("FirstName"), "ABCD");
        typeText(By.id("LastName"), "dfgr");
        typeText(By.name("Email"), "TestEmail" + timestamp + "abc@gmail.com");
        typeText(By.id("Password"), "Test1234");
        typeText(By.id("ConfirmPassword"), "Test1234");
        clickOnElement(By.id("register-button"));
        String text = getTextFromElement(By.xpath("Your registration completed"));
        System.out.println(text);
        Assert.assertEquals(text, expectedresult, "Registration not done");


    }

    @Test
    public static void userShouldreferafriendproductsucess() {

        openBrowser();
        clickOnElement(By.className("ico-register"));
        typeText(By.id("FirstName"), "ABCD");
        typeText(By.id("LastName"), "dfgr");
        typeText(By.name("Email"), "emma@gmail.com");
        typeText(By.id("Password"), "emma1234");
        typeText(By.id("ConfirmPassword"), "emma1234");
        clickOnElement(By.id("register-button"));
        clickOnElement(By.className("ico-login"));
        typeText(By.id("Email"), "emma@gmail.com");
        typeText(By.id("Password"), "emma1234");
        clickOnElement(By.className("login-button"));
        clickOnElement(By.xpath("(//button[@class=button-2 product-box-add-to-cart-button])[3]"));
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@class=button-2 email-a-friend-wishlist-button")));
        clickOnElement(By.xpath("//span[@class=cart-label]"));
        clickOnElement(By.xpath("//button[@class=button-2 email-a-friend-wishlist-button]"));
        clickOnElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li"));
    }

    @Test
    public static void Vote() {

        clickOnElement(By.xpath("//label[@for=pollanswers-2]"));

        clickOnElement(By.xpath("//button[@class=\"button-2 vote-poll-button\"]"));
        WebDriverWait wait = new WebDriverWait(driver, ofSeconds(20));
        String a = String.valueOf(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id=\"block-poll-vote-error-1\"]"))));
        System.out.println(a);
        String actualResult = getTextFromElement(By.className("poll-total-votes"));
        System.out.println(actualResult);
        //Assert.assertEquals(text, expectedresult, "Registration not done");

    }

    @Test

    public static void addtoCartandEMailafriend() {
        openBrowser();
        clickOnElement(By.className("ico-register"));
        typeText(By.id("FirstName"), "ABCD");
        typeText(By.id("LastName"), "dfgr");
        typeText(By.name("Email"), "abc@gmail.com");
        typeText(By.id("Password"), "Test1234");
        typeText(By.id("ConfirmPassword"), "Test1234");
        clickOnElement(By.id("register-button"));
        clickOnElement(By.xpath("(//a[@href=\"/htc-one-m8-android-l-50-lollipop\"])[2]"));
        clickOnElement(By.xpath("//button[@class=\"button-2 email-a-friend-button\"]"));
       // String text = getTextFromElement(By.xpath("Your registration completed"));
        //System.out.println(text);
       // Assert.assertEquals(text, expectedresult, "Registration not done");


    }
        @Test

        public static void CompareClearlistXpathText () {

            clickOnElement(By.xpath("[button[@class='button-2 add-to-compare-list-button'])[3]"));
            //click on Add to compare list on $25 Virt2ual Gift card

            clickOnElement(By.xpath("(//a[@href=\"/compareproducts\"])[2]"));
           // String text = getTextFromElement(By.xpath("Your registration completed"));
           // System.out.println(text);
           // Assert.assertEquals(text, expectedresult, "Registration not done");



            //String name1 = driver.findElement(By.xpath("div/ta/html/body/div[6]/div[3]/div/div[2]/div/div[2]/ble/tbody/tr[3]/td[2]/a")).getText();
           // System.out.println("First Product is: " + name1);
           // String name2 = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[3]/a")).getText();
          //  System.out.println("Second Product is: " + name2);
          //  driver.findElement(By.className("clear-list")).
           // String message = driver.findElement(By.className("no-data")).getText();
            //System.out.println(message);
        }


    @Test
    public static void Productaddtocartandprint(){
    openBrowser();
    clickOnElement(By.xpath("(//a[@title='Show products in category Electronics'])[1]"));
    clickOnElement(By.xpath("(//a[@title='Show products in category Camera & photo'])[1]"));
       // String text = getTextFromElement(By.xpath("Your registration completed"));
     //   System.out.println(text);
     //   Assert.assertEquals(text, expectedresult, "Registration not done");



    }

@Test
public static void Registerusersucessfullyvote(){
    clickOnElement(By.xpath("//label[@for=pollanswers-2]"));

    clickOnElement(By.xpath("//button[@class=\"button-2 vote-poll-button\"]"));
    WebDriverWait wait = new WebDriverWait(driver, ofSeconds(20));
    String a = String.valueOf(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id=\"block-poll-vote-error-1\"]"))));
    System.out.println(a);
    String actualResult = getTextFromElement(By.className("poll-total-votes"));
    System.out.println(actualResult);


//
    }
}