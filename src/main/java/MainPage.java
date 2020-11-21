import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.xpath("//a[@class= 'HeaderMenu-link no-underline mr-3']");
    private By signUpButton = By.xpath("//a[@class= 'HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1']");

    private By userNameField = By.xpath("//input[@id=\"user[login]\"]");
    private By emailField = By.xpath("//input[@id=\"user[email]\"]");
    private By passwordField = By.xpath("//input[@id=\"user[password]\"]");
    private By signUpFormButton = By.xpath("//form[@class='home-hero-signup text-gray-dark js-signup-form js-signup-form-submit']//button[text()=\"Sign up for GitHub\"]");

    public LoginPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpFormButton() {
        driver.findElement(signUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public MainPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public MainPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage register(String userName, String email, String password) {
        this.typeUserName(userName);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }
}
