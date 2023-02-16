package StepDefinations;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.objectweb.asm.util.Printer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProcezySearch {

    WebDriver driver = null;
    @Given("open procezy website")
    public void open_procezy_website() {
        System.setProperty("webdriver.driver.chrome", "src/main/resources/drivers");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://training.promena.in");



    }
    @When("enter the valide user name and password")
    public void enater_the_valide_user_name_and_password() {
        //driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-sign-in/div/form/div[2]/div[1]/div/mat-form-field[1]/div/div[1]/div")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("admin@gmail.com");
        //driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("admin@gmail.com");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-sign-in/div/form/div[2]/div[1]/div/mat-form-field[2]/div/div[1]/div[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Password@123");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-sign-in/div/form/div[3]/button/span[1]")).click();

        // Write code here that turns the phrase above into concrete actions

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //throw new io.cucumber.java.PendingException();
    }
    @Then("click on product sku tab")
    public void click_on_product_sku_tab() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-header/mat-toolbar/mat-toolbar-row/div/div[1]/div/a[2]/span[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/div/a[4]/span[1]")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(10000);
        throw new io.cucumber.java.PendingException();
    }

    @And("select the filters")
    public void select_the_filters() {
        var SearchOption = "CABINET";
        driver.findElement(By.xpath("//*[@id=\"mat-select-value-3\"]")).click();


        var options = driver.findElements(By.tagName("mat-option"));

        for (var option: options) {
            if(option.getText().toLowerCase().replace(" ","").contains(SearchOption.toLowerCase().replace(" ","")))
            {
                option.click();
            }
        }



        throw new PendingException();
    }

    @Then("click on appaly button")
    public void click_on_appaly_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
