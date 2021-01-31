import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    WebDriver driver;

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public HoversPage hoveringOverAvatar(int id) {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath(String.format("//*[text()=\"name: user%s\"]/parent::div/parent::div", id)))).build().perform();
        return new HoversPage(driver);
    }

    public boolean getNameDisplayStatus(int id) {
        return driver.findElement(By.xpath(String.format("//*[text()=\"name: user%s\"]", id))).isDisplayed();
    }
}
