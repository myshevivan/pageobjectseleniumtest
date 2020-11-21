import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[@class=\"mb-4 mb-md-8 container-md\"]//h1");

    private By signUpButton = By.xpath("//button[@id=\"signup_button\"]");

    private By userNameField = By.xpath("//input[@id=\"user_login\"]");
    private By emailField = By.xpath("//input[@id=\"user_email\"]");
    private By passwordField = By.xpath("//input[@id=\"user_password\"]");

    private By userNameError = By.xpath("//input[@id=\"user_login\"]/parent::div/parent::dd/following-sibling::dd");
    private By emailError = By.xpath("//input[@id=\"user_email\"]/parent::dd/following-sibling::dd");
    private By passwordError = By.xpath("//input[@id=\"user_password\"]/parent::dd/following-sibling::dd");
    private By mainError = By.xpath("//*[@id=\"signup-form\"]/div");

    public SignUpPage typeUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password) {
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }

    public String getErrorUserName() {
        return driver.findElement(userNameError).getText();
    }

    public String getErrorPassword() {
        return driver.findElement(passwordError).getText();
    }

    public String getErrorEmail() {
        return driver.findElement(emailError).getText();
    }

    public String getMainErrorText(){
        return driver.findElement(mainError).getText();
    }
}
