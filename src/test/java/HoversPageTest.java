import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HoversPageTest {

    private WebDriver driver;
    private HoversPage hoversPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\myshev\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/hovers");
        hoversPage = new HoversPage(driver);
    }

    //Задание 4
    @Test
    public void displayingUsernamesByHoveringOverAnAvatar() {
        HoversPage newHoversPage = hoversPage.hoveringOverAvatar(1);
        boolean status = newHoversPage.getNameDisplayStatus(1);
        Assert.assertTrue("Ошибка соответствия аватара1 и лейбла с именем юзера!", status);

        newHoversPage.hoveringOverAvatar(2);
        status = newHoversPage.getNameDisplayStatus(2);
        Assert.assertTrue("Ошибка соответствия аватара2 и лейбла с именем юзера!", status);

        newHoversPage.hoveringOverAvatar(3);
        status = newHoversPage.getNameDisplayStatus(3);
        Assert.assertTrue("Ошибка соответствия аватара3 и лейбла с именем юзера!", status);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
