package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import config.env_target;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login extends env_target{

    Duration duration = Duration.ofSeconds(10);
    WebDriverWait wait = new WebDriverWait(driver, duration);

    @Given("User is on sauce demo login page")
    public void user_is_on_sauce_demo_login_page() {
        wait.until(ExpectedConditions.or(
            ExpectedConditions.visibilityOfElementLocated(By.className("login_logo"))
        ));
    }

    @When("^User fill (.*) and (.*)$")
    public void user_fill_username(String username, String password) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("User click login button")
    public void user_click_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("^User verify login (.*)$")
    public void user_verify_login_result(String result) {
        if (result == "Passed"){
            wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title'][contains(text(),'Products')]"))
            ));
        } else if (result == "Failed") {
            wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error'][contains(text(),'Username and password do not match')]"))
            ));
        }
    }
}
