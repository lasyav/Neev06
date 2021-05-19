import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SearchTest {
    @Test
    public void testSearchSpree(){
        System.setProperty("webdriver.chrome.driver","/Users/lasyavadapalli/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://spree-vapasi.herokuapp.com/");
        WebElement search_textbox= driver.findElement(By.id("keywords"));
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("keywords")));
        search_textbox.click();
        search_textbox.sendKeys("shirt");
        WebElement search_button = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/nav/ul/li[2]/form/input[2]"));
        search_button.click();
        WebElement home_icon = driver.findElement(By.id("home-link"));
        home_icon.click();
        driver.quit();
    }
}
