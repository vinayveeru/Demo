package StepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class paginationsteps {
    WebDriver driver = null;

    @Given("I have given valid credentials")
    public void i_have_given_valid_credentials() {
        System.setProperty("webdriver.driver.chrome","src/main/resources/drivers/chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://training.promena.in");
         driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("admin@gmail.com");
         driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Password@123");
         driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-sign-in/div/form/div[3]/button")).click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @And("navigated to the productsku page")
    public void navigated_to_the_productsku_page() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-header/mat-toolbar/mat-toolbar-row/div/div[1]/div/a[2]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/div/a[4]")).click();
        Thread.sleep(10000);
        //driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/app-categories/mat-sidenav-container/mat-sidenav-content/div/mat-card/div[3]/mat-paginator/div/div/div[1]/mat-form-field")).click();

        // Write code here that turns the phrase above into concrete actions
       // throw new io.cucumber.java.PendingException();
    }
    @And("i give record to select")
    public void i_give_record_to_select() {
        String i = "10";

        driver.findElement(By.xpath("//*[@id=\"mat-select-8\"]")).click();

        List<WebElement> options = driver.findElements(By.tagName("mat-option"));
        for (WebElement option : options) {
            System.out.println(option);
            var abc = option.toString();
            if (option.getText().contains(i)) {
                System.out.println("Trying to select: " + i);
                option.click();
                break;
            }
        }
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("logout successfully")
    public void logout_successfully() {
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-header/mat-toolbar/mat-toolbar-row/div/div[2]/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-menu-panel-1\"]/div/div/div[3]/p[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-warning/div/mat-dialog-actions/button[1]")).click();

        //throw new io.cucumber.java.PendingException();
    }


}
