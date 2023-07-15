package src;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void LandHomePage() {
        driver.get("http://automationexercise.com");
    }

    private final By clickProductPage = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a");

    public void ClickProductPage() {
        LandHomePage();
        driver.findElement(clickProductPage).click();
    }

    private final By searchProduct = By.id("search_product");
    private final By clickSearchProductButton = By.xpath("//*[@id=\"submit_search\"]");
    private final By itemSelect = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/p");
    private final By clickItemToCart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a");
    private final By clickContinueButton = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[1]/div/div/div[3]/button");

    public void AddProductToCart() {
        ClickProductPage();
        // Search `Blue Top for adding to cart`
        String searchItem1 = "Blue Top";
        driver.findElement(searchProduct).clear();
        driver.findElement(searchProduct).sendKeys(searchItem1);
        driver.findElement(clickSearchProductButton).click();

        // Verify product found
        String item = driver.findElement(itemSelect).getText();
        System.out.println(item);
        if (Objects.equals(item, searchItem1)) {
            driver.findElement(clickItemToCart).click();
        } else {
            System.out.println("no item found");
            return;
        }
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(clickContinueButton)).click();
    }

    private final By clickCartPage = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");

    public void ClickCartPage() {
        LandHomePage();
        driver.findElement(clickCartPage).click();
    }

    private final By clickProceedToCheckout = By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");
    private final By clickPlaceOrder = By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");

    private final By nameOnCard = By.name("name_on_card");
    private final By cardNumber = By.name("card_number");
    private final By cvc = By.name("cvc");
    private final By expiryMonth = By.name("expiry_month");
    private final By expiryYear = By.name("expiry_year");

    private final By clickPayAndConfirmOrder = By.xpath("//*[@id=\"submit\"]");

    public void PlaceOrder(Card card) {
        ClickCartPage();
        driver.findElement(clickProceedToCheckout).click();
        driver.findElement(clickPlaceOrder).click();

        // card info
        driver.findElement(nameOnCard).sendKeys(card.getNameOnCard());
        driver.findElement(cardNumber).sendKeys(card.getCardNumber());
        driver.findElement(cvc).sendKeys(card.getCardCVC());
        driver.findElement(expiryMonth).sendKeys(card.getExpInMM());
        driver.findElement(expiryYear).sendKeys(card.getExpInYY());

        driver.findElement(clickPayAndConfirmOrder).click();
    }
}
