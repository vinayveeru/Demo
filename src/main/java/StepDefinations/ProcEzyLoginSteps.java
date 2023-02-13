package StepDefinations;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ProcEzyLoginSteps {

    WebDriver driver = null;

    @Given("Browser is open")
    public void browser_is_open() {
        System.out.println("1");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();


        driver.manage().window().maximize();

    }

    @And("user is in Browser")
    public void user_is_in_browser() {
        driver.navigate().to("http://training.promena.in");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]")).sendKeys("admin@gmail.com");

        System.out.println("1");
    }

    @When("User Enters UserName and Password")
    public void user_enters_user_name_and_password() {
        driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]")).sendKeys("Password@123");
        System.out.println("1");
    }

    @And("hits login")
    public void hits_login() {
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-sign-in/div/form/div[3]/button")).sendKeys(Keys.ENTER);
        System.out.println("1");
    }

    @Then("User Is navigated to Dashboard")
    public void user_is_navigated_to_dashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/app-header/mat-toolbar/mat-toolbar-row/div/div[1]/div/a[2]")).click();


        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/app-categories/mat-sidenav-container/mat-sidenav-content/div/mat-card/div[1]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).sendKeys("new boat 3");
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/app-categories/mat-sidenav-container/mat-sidenav/div/div[2]/button")).click();
        Thread.sleep(3000);
        //create manufactures

        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/div/a[2]")).click();
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/app-manufacture/mat-sidenav-container/mat-sidenav-content/div/mat-card/div[1]/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-input-4\"]")).sendKeys("new boat 3");
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/app-manufacture/mat-sidenav-container/mat-sidenav/div/div[2]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/div/a[1]")).click();
        //}
        //create model
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/div/a[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/app-models/mat-sidenav-container/mat-sidenav-content/div/mat-card/div[1]/div/button")).click();
        Thread.sleep(3000);
        String text = "binocld";
        driver.findElement(By.xpath("//*[@id=\"mat-input-10\"]")).sendKeys("b");

        List<WebElement> options = driver.findElements(By.tagName("mat-option"));
        for (WebElement option : options) {
            System.out.println(option);
            var abc = option.getText();
            if (option.getText().contains(text)) {
                System.out.println("Trying to select: " + text);
                option.click();
                break;
            }
        }

        text = "AMD";
        driver.findElement(By.xpath("//*[@id=\"mat-input-11\"]")).sendKeys("am");
        options = driver.findElements(By.tagName("mat-option"));

        for (WebElement option : options) {
            if (option.getText().contains(text)) {
                option.click();
                break;
            }
        }


        driver.findElement(By.xpath("//*[@id=\"mat-input-8\"]")).sendKeys("tribal HDD");
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/app-models/mat-sidenav-container/mat-sidenav/div/div[2]/button")).click();
        Thread.sleep(3000);


        // create product sku

        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/div/a[4]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/app-manage-products-sku/div/app-products-list/mat-sidenav-container/mat-sidenav-content/div/mat-card/div[1]/div/a")).click();
        Thread.sleep(3000);
        text = "cabinet";
        driver.findElement(By.xpath("//*[@id=\"mat-input-13\"]")).sendKeys("ca");

        options = driver.findElements(By.tagName("mat-option"));
        for (WebElement option : options) {
            System.out.println(option);
            var abc = option.getText();
            if (option.getText().toLowerCase().contains(text.toLowerCase())) {
                System.out.println("Trying to select: " + text);
                option.click();
                break;

            }
        }
        text = "asus";
        driver.findElement(By.xpath("//*[@id=\"mat-input-14\"]")).sendKeys("as");
        options = driver.findElements(By.tagName("mat-option"));

        for (WebElement option : options) {
            if (option.getText().toLowerCase().contains(text.toLowerCase())) {
                option.click();
                break;
            }
        }
        text = "ROG Gaming";
        driver.findElement(By.xpath("//*[@id=\"mat-input-15\"]")).sendKeys("ro");

        options = driver.findElements(By.tagName("mat-option"));
        for (WebElement option : options) {
            System.out.println(option);
            var abc = option.getText();
            if (option.getText().toLowerCase().contains(text.toLowerCase())) {
                System.out.println("Trying to select: " + text);
                option.click();
                break;

            }
        }
        driver.findElement(By.xpath("//*[@id=\"mat-input-16\"]")).sendKeys("ROG Gaming c8");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"mat-input-17\"]")).sendKeys("brand new gaming c3");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"mat-input-18\"]")).sendKeys("ROG Gamingc2 pro1");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"mat-input-19\"]")).sendKeys("20000");
        Thread.sleep(4000);
        text = "GST018";
        driver.findElement(By.xpath("//*[@id=\"mat-input-20\"]")).sendKeys("gs");

        options = driver.findElements(By.tagName("mat-option"));
        for (WebElement option : options) {
            System.out.println(option);
            var abc = option.getText();
            if (option.getText().toLowerCase().contains(text.toLowerCase())) {
                System.out.println("Trying to select: " + text);
                option.click();
                break;


            }
        }
        text = "India";
        driver.findElement(By.xpath("//*[@id=\"mat-input-21\"]")).sendKeys("in");

        options = driver.findElements(By.tagName("mat-option"));
        for (WebElement option : options) {
            System.out.println(option);
            var abc = option.getText();
            if (option.getText().toLowerCase().contains(text.toLowerCase())) {
                System.out.println("Trying to select: " + text);
                option.click();
                break;

            }
        }
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/app-manage-products-sku/div/app-add-products/mat-card/div[2]/app-details/form/div[10]/button")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/app-root/mat-sidenav-container/mat-sidenav-content/div/div/app-admin/app-master-products/div/app-manage-products-sku/div/app-add-products/mat-card/div[2]/app-media/div/div[2]/div/button")).click();


    }
}
