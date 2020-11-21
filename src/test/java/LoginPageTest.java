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
        driver.get("https://github.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("", "");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Ошибка не соответствует ожиданиям!", "Incorrect username or password.", error);
    }

    @Test
    public void loginWithIncorrectCredsTest() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("test", "test");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Ошибка не соответствует ожиданиям!", "Incorrect username or password.", error);
    }

    @Test
    public void createAccTest() {
        SignUpPage signUpPage = loginPage.createAcc();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Заголовок не соответствует ожиданиям!", "Create your account", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


