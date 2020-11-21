import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\myshev\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join");
        signUpPage = new SignUpPage(driver);
    }

    @Test
    public void signUpWithShortPassTest() {
        SignUpPage newSignUpPage = signUpPage.typePassword("ewq");
        String error = newSignUpPage.getErrorPassword();
        Assert.assertEquals("Ошибка не соответствует ожиданиям!",
                "Password is too short (minimum is 8 characters), needs at least 1 number, and is in a list of passwords commonly used on other websites", error);
    }

    @Test
    public void signUpReservedUsernameTest() {
        SignUpPage newSignUpPage = signUpPage.typeUserName("username");
        String error = newSignUpPage.getErrorUserName();
        Assert.assertEquals("Ошибка не соответствует ожиданиям!", "Username 'username' is unavailable.", error);
    }

    @Test
    public void signUpTakenUsernameTest() {
        SignUpPage newSignUpPage = signUpPage.typeUserName("user");
        String error = newSignUpPage.getErrorUserName();
        Assert.assertEquals("Ошибка не соответствует ожиданиям!", "Username user is not available.", error);
    }

    @Test
    public void getHeadingTest() {
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Заголовок не соответствует ожиданиям!", "Create your account", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}