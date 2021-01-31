import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\myshev\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    //Задание 1
    @Test
    public void loginWithCorrectUsernameAndPassword() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("tomsmith", "SuperSecretPassword!");
        String heading = newLoginPage.getHeadingText();
        Assert.assertTrue("Заголовок не соответствует ожиданиям! ФР: " + heading , heading.contains("You logged into a secure area!"));
    }

    //Задание 2
    @Test
    public void loginWithWrongUsername() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("err", "SuperSecretPassword!");
        String heading = newLoginPage.getHeadingText();
        Assert.assertTrue("Заголовок не соответствует ожиданиям! ФР: " + heading , heading.contains("Your username is invalid!"));
    }

    //Задание 3
    @Test
    public void loginWithWrongPassword() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("tomsmith", "err!");
        String heading = newLoginPage.getHeadingText();
        Assert.assertTrue("Заголовок не соответствует ожиданиям! ФР: " + heading , heading.contains("Your password is invalid!"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


