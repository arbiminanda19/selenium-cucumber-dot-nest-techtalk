package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import config.env_target;

public class Hooks extends env_target{

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void afterTest(){
        driver.quit();
    }

}
