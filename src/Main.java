package src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // get chrome driver
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeVersion\\chromedriver_win32\\chromedriver.exe");

        // use for ad blockers
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\ChromeVersion\\chromedriver_win32\\extension_5_8_0_0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);

        // get chrome driver
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new ChromeDriver(options);

        // signup
        String name = "abc-def-10";
        String email = "abc-def-10@gmail.com";
        String password = "abc-def-123";
        AuthSignUp signUp = new AuthSignUp(name, email);
        AuthPage authPage = new AuthPage(driver);
        authPage.SignUp(signUp);

        // sign-out
        authPage.SignOut();

        // login
        AuthLogin login = new AuthLogin(email, password);
        authPage.Login(login);

        // Add product to cart and purchase
        CartPage cart = new CartPage(driver);
        cart.AddProductToCart();
        System.out.println("Add product to cart successfully done");

        // place order
        String noCard = "abc def";
        String cNumber = "1232432412323123";
        String cVc = "123";
        String expMonth = "6";
        String expYear = "2024";
        Card card = new Card(noCard, cNumber, cVc, expMonth, expYear);
        cart.PlaceOrder(card);

        // close driver
//        driver.close();
    }
}