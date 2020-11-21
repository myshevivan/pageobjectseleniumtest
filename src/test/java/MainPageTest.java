import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\myshev\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void signInTest() {
        LoginPage loginPage = mainPage.clickSignInButton();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Заголовок не содержит ожидаемый заголовок!", "Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest() {
        SignUpPage signUpPage = mainPage.register("tEst13", "testerr", "sR2k2www212");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("Ошибка не соответствует ожиданиям!", "There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUsernameTest() {
        SignUpPage signUpPage = mainPage.register("", "testerr", "sR2k2www212");
        String error = signUpPage.getErrorUserName();
        Assert.assertEquals("Ошибка Username не соответствует ожиданиям!", "Username can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailTest() {
        SignUpPage signUpPage = mainPage.register("tEst13", "testerr", "sR2k2www212");
        String error = signUpPage.getErrorEmail();
        Assert.assertEquals("Ошибка Email не соответствует ожиданиям!", "Email is invalid or already taken", error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
