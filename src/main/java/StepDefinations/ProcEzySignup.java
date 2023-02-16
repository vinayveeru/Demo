package StepDefinations;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class ProcEzySignup {

    String BuyerEmail = "";
    String OTP = "";
    WebDriver driver = null;
    ArrayList<String> tabs = null;

    @Given("Browser is opened")
    public void browser_is_opened() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @And("navigate to yopmail")
    public void navigate_to_yopmail() {
        driver.navigate().to("https://yopmail.com/");
    }
    @When("enater random string and get mail id")
    public void enater_random_string_and_get_mail_id() throws InterruptedException {
        driver.findElement(By.id("login")).sendKeys(getSaltString());
        driver.findElement(By.xpath("//*[@id=\"refreshbut\"]/button")).click();
        BuyerEmail = (driver.findElement(By.xpath("//*[@id=\"webmail\"]/div[1]/div/main/div[1]/div/div[1]"))).getText();

    }
    @And("open new tab")
    public void open_new_tab() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        tabs = new ArrayList<String>(driver.getWindowHandles());

    }
    @Then("User Is navigated to procezy")
    public void user_is_navigated_to_procezy() {
        driver.switchTo().window(tabs.get(1));
        driver.get("http://training.promena.in/");
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-sign-in/div/form/div[3]/p[2]/a[1]")).click();
    }
    @And("enter mail id hit sign up")
    public void enter_mail_id_hit_sign_up() throws InterruptedException {
        //Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("mat-input-2")).sendKeys(BuyerEmail);
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-auth/div/app-sign-up/div/form/div[3]/button")).click();
    }
    @Then("navigate to yop mail and refresh")
    public void navigate_to_yop_mail_and_refresh() throws InterruptedException {
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(10000);
        driver.findElement(By.id("refresh")).click();
        Thread.sleep(10000);
        System.out.println("1");
    }
    @And("get otp and store in a variable")
    public void get_otp_and_store_in_a_variable() {
        var newdri = driver;
        newdri.switchTo().frame(2);
        OTP = newdri.findElement(By.xpath("//*[@id=\"mail\"]/div/table/tbody/tr/td/table[3]/tbody/tr/td/table/tbody/tr/td/table[2]/tbody/tr/td/div/p")).getText();
    }
    @Then("navigate to ProcEzy")
    public void navigate_to_proc_ezy() {
        driver.switchTo().window(tabs.get(1));
        for(var i = 0;i < OTP.length();i++)
        {
            driver.findElement(By.xpath("//*[@id=\"mat-input-"+(i+3)+"\"]")).sendKeys(String.valueOf(OTP.charAt(i)));
        }
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-input-dialog/div/mat-dialog-content/div/button")).click();
        //System.out.println("1");
    }
    @And("Enter OTP hit enter")
    public void enter_otp_hit_enter() throws InterruptedException {
        System.out.println("1");
        //Thread.sleep(10000);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    @Then("fill details")
    public void fill_details() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"mat-input-9\"]")).sendKeys("anz buyer");
        Thread.sleep(10000);

        var SearchOption = "Hardware Reseller";
        driver.findElement(By.xpath("//*[@id=\"mat-select-8\"]")).click();


        var options = driver.findElements(By.tagName("mat-option"));


        for (var option: options) {
            if(option.getText().toLowerCase().replace(" ","").contains(SearchOption.toLowerCase().replace(" ","")))
            {
                option.click();
            }
        }
       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(10000);


        driver.findElement(By.xpath("//*[@id=\"mat-input-10\"]")).sendKeys("bagalore");
        driver.findElement(By.xpath("//*[@id=\"mat-input-11\"]")).sendKeys("2nd stage,banashankari");
        driver.findElement(By.xpath("//*[@id=\"mat-input-12\"]")).sendKeys("kathriguppea");
        driver.findElement(By.xpath("//*[@id=\"mat-input-11\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"mat-checkbox-1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-select-0\"]")).click();
        var SearchOption1 = "Karnataka [KR]";
         options = driver.findElements(By.tagName("mat-option"));
        for (var option: options) {
            if(option.getText().toLowerCase().replace(" ","").contains(SearchOption1.toLowerCase().replace(" ","")))
            {
                option.click();
                break;
            }
        }
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"mat-select-2\"]")).click();
        var SearchOption2 = "Kolar";
        options = driver.findElements(By.tagName("mat-option"));
        for (var option: options) {
            if(option.getText().toLowerCase().replace(" ","").contains(SearchOption2.toLowerCase().replace(" ","")))
            {
                option.click();
                break;
            }
        }

        driver.findElement(By.xpath("//*[@id=\"mat-input-14\"]")).sendKeys("563125");


        driver.findElement(By.xpath("//*[@id=\"mat-input-20\"]")).sendKeys("BPDPV9887S");
        driver.findElement(By.xpath("//*[@id=\"mat-input-21\"]")).sendKeys("24AAACK4175D1Z4");
        Thread.sleep(10000);
        //driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div/div[3]/div[1]")).isSelected();
        driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div/div[3]/div[1]/mat-card/div/input")).sendKeys("E:\\sample.pdf");

        driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div/div[3]/div[2]/mat-card/div/input")).sendKeys("E:\\sample.pdf");
        //driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div/div[3]/div[2]/mat-card/div/input")).sendKeys("C:\\Users\\kumar\\Pictures\\Screenshots\\Screenshot_20230122_061916.png");
        driver.findElement(By.xpath("//*[@id=\"cdk-step-content-0-0\"]/form/div/div[4]/button")).click();


    }//*[@id="cdk-step-content-0-0"]/form/div/div[3]/div[1]/mat-card





    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}
