import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {
    static ChromeDriver driver;
    static WebDriverWait wait;
    @BeforeMethod
    public void testLoginIntoSpree(){
        System.setProperty("webdriver.chrome.driver", "/Users/lasyavadapalli/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        wait = new WebDriverWait(driver,30);
    }
    @Test
    public void testSuccessfulMessageOnValidLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
        WebElement login_icon = driver.findElement(By.linkText("Login"));
        login_icon.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spree_user_email")));
        WebElement email_textbox =driver.findElement(By.id("spree_user_email"));
        email_textbox.sendKeys("lasya@gmail.com");
        WebElement password_textbox =driver.findElement(By.id("spree_user_password"));
        password_textbox.click();
        password_textbox.sendKeys("asdfghjkl");
        WebElement login_button= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/form/p[2]/input"));
        login_button.click();


        boolean login_successful = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]")).isDisplayed();
        assertEquals(login_successful,true);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div/div/nav/ul/li[2]")));
        WebElement logout_icon= driver.findElement(By.xpath("/html/body/div[1]/header/div/div/nav/ul/li[2]"));
        logout_icon.click();
        driver.close();

    }
    @Test
    public void testErrorMessageOnInvalidLogin(){

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
        WebElement login_icon = driver.findElement(By.linkText("Login"));
        login_icon.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("spree_user_email")));
        WebElement email_textbox =driver.findElement(By.id("spree_user_email"));
        email_textbox.sendKeys("lasya@gmail.com");
        WebElement password_textbox =driver.findElement(By.id("spree_user_password"));
        password_textbox.click();
        password_textbox.sendKeys("aiksldjhdh");
        WebElement login_button= driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/form/p[2]/input"));
        login_button.click();

        boolean login_invalid = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]")).isDisplayed();
        assertEquals(login_invalid,true);

        driver.close();

    }
}

