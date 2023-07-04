package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class GearTest extends Utility {
    //Opening and setting the browser
    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        //* Mouse Hover on Gear Menu
        Actions action = new Actions(driver);
        WebElement gearElement = getElement(By.xpath("//a[@id='ui-id-6']//span[text()='Gear']"));
        action.moveToElement(gearElement).build().perform();
        //  * Click on Bags
        WebElement bagElement = getElement(By.xpath("//span[contains(text(),'Bags')]"));
        action.moveToElement(bagElement).click().build().perform();
        //* Click on Product Name ‘Overnight Duffle’
        WebElement productElement = getElement(By.partialLinkText("Overnight Duff"));
        action.moveToElement(productElement).click().build().perform();
        //* Verify the text ‘Overnight Duffle’
        String actualBagName = gettextFromElement(By.xpath("//span[@data-ui-id]"));
        String expectedBagName = "Overnight Duffle";
        Assert.assertEquals("Bag name is not same", expectedBagName, actualBagName);
        //* Change Qty 3
        driver.findElement(By.id("qty")).clear();
        sendTextToElement(By.id("qty"), "3");

        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.id("product-addtocart-button"));
        // * Verify the text‘You added Overnight Duffle to your shopping cart.’
        String actualMessage = gettextFromElement(By.xpath("//div[@data-ui-id='message-success']"));
        String expectedMessage = "You added Overnight Duffle to your shopping cart.";
        Assert.assertEquals("Wrong message", actualMessage, expectedMessage);
        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.linkText("shopping cart"));
        //   * Verify the product name ‘Overnight Duffle’
        String productName = gettextFromElement(By.partialLinkText("Overnight Duff"));
        String expectedName = "Overnight Duffle";
        Assert.assertEquals("Wrong message", productName, expectedName);

        //* Verify the Qty is ‘3’
//       String quantity = gettextFromElement(By.xpath("//input[@class='input-text qty']']"));
//     System.out.println(quantity);
        //* Verify the product price ‘$135.00’
        String actualPrice=gettextFromElement(By.xpath("//span[@class='price-wrapper']/span[@class='price']"));
        System.out.println(actualPrice);
        // * Change Qty to ‘5
        driver.findElement(By.xpath("//input[@class='input-text qty']")).clear();
        sendTextToElement(By.xpath("//input[@class='input-text qty']"),"5");
        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[contains(text(),'Proceed to Checkout')]"));
        //* Verify the product price ‘$225.0

    }

    //Closing the browser
    @After
    public void tearDown() {
        //closeBrowser();
    }
}
