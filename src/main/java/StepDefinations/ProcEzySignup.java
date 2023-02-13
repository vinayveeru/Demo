package StepDefinations;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
        Thread.sleep(5000);
        driver.findElement(By.id("mat-input-2")).sendKeys(BuyerEmail);
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-auth/div/app-sign-up/div/form/div[3]/button")).click();
    }
    @Then("navigate to yop mail and refresh")
    public void navigate_to_yop_mail_and_refresh() throws InterruptedException {
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(5000);
        driver.findElement(By.id("refresh")).click();
        Thread.sleep(2000);
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
        System.out.println("1");
    }
    @And("Enter OTP hit enter")
    public void enter_otp_hit_enter() {
        System.out.println("1");
    }
    @Then("fill details")
    public void fill_details() {
        System.out.println("1");
    }




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
