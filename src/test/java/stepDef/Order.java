package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import config.env_target;

public class Order extends env_target {

    Duration duration = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(driver, duration);

    @When("User add product to cart")
    public void user_add_product_to_cart() {
        driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
    }
    @And("User click cart button")
    public void user_click_cart_button() {
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a[contains(@class,'shopping_cart_link')]")).click();
    }
    @And("User click check out button")
    public void user_click_check_out_button() {
        driver.findElement(By.id("checkout")).click();
    }
    @Then("User is on check out page")
    public void user_is_on_check_out_page() {
        wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Checkout: Your Information')]"))
        ));
    }
    @When("User fill check out info")
    public void user_fill_check_out_info() {
        driver.findElement(By.id("first-name")).sendKeys("Test");
        driver.findElement(By.id("last-name")).sendKeys("Automation");
        driver.findElement(By.id("postal-code")).sendKeys("078901");
    }
    @And("User click continue button")
    public void user_click_continue_button() {
        driver.findElement(By.id("continue")).click();
    }
    @And("User overview and finish order")
    public void user_overview_and_finish_order() {
        driver.findElement(By.id("finish")).click();
    }
    @Then("User is on thank you order page")
    public void user_is_on_thank_you_order_page() {
        wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]"))
        ));
    }
}
