package src;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AuthPage {
    private WebDriver driver;

    public AuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void LandHomePage() {
        driver.get("http://automationexercise.com");
    }

    public void ClickAuthPage() {
        LandHomePage();
        driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4)")).click();
    }

    private final By name = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=text]:nth-child(2)");
    private final By email = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)");
    private final By clickSignUp = By.cssSelector("#form > div > div > div:nth-child(3) > div > form > button");

    public void SignUp(AuthSignUp signup) {
        ClickAuthPage();
        driver.findElement(name).sendKeys(signup.getName());
        driver.findElement(email).sendKeys(signup.getEmail());
        driver.findElement(clickSignUp).click();
        SignUpDetails(signup);
    }

    private final By firstName = By.id("first_name");
    private final By lastName =  By.id("last_name");
    private final By phone = By.id("mobile_number");
    private final By password = By.id("password");
    private final By address1 = By.id("address1");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");

    private final By clickCreateAccount =  By.cssSelector("#form > div > div > div > div.login-form > form > button");

    private final By clickSignOut = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");

    public void SignUpDetails(AuthSignUp signup) {
        String fName = "abc";
        String lName = "def";
        String phn = "01789660011";
        String zCode = "325";
        String st = "state";
        String cty = "city";
        String adr = "123, address, address";
        String pass = "abc-def-123";

        signup.AuthSignUpDetails(pass, fName, lName, adr, st, cty, zCode, phn);
        driver.findElement(firstName).sendKeys(signup.getFirstName());
        driver.findElement(lastName).sendKeys(signup.getLastName());
        driver.findElement(phone).sendKeys(signup.getPhone());
        driver.findElement(password).sendKeys(signup.getPassword());
        driver.findElement(address1).sendKeys(signup.getAddress1());
        driver.findElement(state).sendKeys(signup.getState());
        driver.findElement(city).sendKeys(signup.getCity());
        driver.findElement(zipcode).sendKeys(signup.getZipCode());
        Select drpCountry = new Select(driver.findElement(By.name("country")));
        drpCountry.selectByVisibleText("India");
        driver.findElement(clickCreateAccount).click();
        String created = "ACCOUNT CREATED!";
        String expected = driver.findElement(By.cssSelector("#form > div > div > div > h2 > b")).getText();
        System.out.println(expected);
        if(created.equals(expected)){
            System.out.println("Account created successfully!");
        } else {
            System.out.println("Ops!");
        }
    }

    public void SignOut() {
        driver.findElement(clickSignOut).click();
    }

    private final By loginEmail = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)");
    private final By loginPass = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)");
    private final By clickLogin = By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > button");

    public void Login(AuthLogin login) {
        ClickAuthPage();
        driver.findElement(loginEmail).sendKeys(login.getEmail());
        driver.findElement(loginPass).sendKeys(login.getPassword());
        driver.findElement(clickLogin).click();
        String placed = "ORDER PLACED!";
        String expected = driver.findElement(By.cssSelector("#form > div > div > div > h2 > b")).getText();
        System.out.println(expected);
        if(placed.equals(expected)){
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Ops!");
        }
    }
}
