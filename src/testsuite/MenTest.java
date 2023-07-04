package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class MenTest extends Utility {
    //Opening and setting the browser
    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        //Mouse Hover on Men Menu
        //Initialization of Action object
        Actions action = new Actions(driver);
        WebElement menHoverElement = getElement(By.xpath("//a[@id='ui-id-5']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'][1]"));
        action.moveToElement(menHoverElement).build().perform();
        //Mouse Hover on Bottoms
        WebElement bottomElement = getElement(By.xpath("//a[@id='ui-id-18']"));
        action.moveToElement(bottomElement).build().perform();
        // Click on Pants
        WebElement pantElement = getElement(By.xpath("//a[@id='ui-id-23']"));
        action.moveToElement(pantElement).click().build().perform();
        // Mouse Hover on product name Cronus Yoga Pant’ and click on size 32.
        WebElement productElement1 = getElement(By.xpath("//a[@class='product-item-link'][contains(text(),'Cronus Yoga Pant')]"));
        action.moveToElement(productElement1).build().perform();
        WebElement size = getElement(By.xpath("//div[@option-id='175']"));
        action.moveToElement(size).click().build().perform();
        //Mouse Hover on product name Cronus Yoga Pant’ and click on colour Black.
        WebElement colour = getElement(By.xpath("//div[@id='option-label-color-93-item-49']"));
        action.moveToElement(colour).click().build().perform();
        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button.
        WebElement addToCart = getElement(By.xpath("//span[text()='Add to Cart']"));
        action.moveToElement(addToCart).click().build().perform();
        //Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String actualMessage = gettextFromElement(By.xpath("//div[@data-ui-id]"));
        System.out.println(actualMessage);
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        Assert.assertEquals("Wrong message displayed", actualMessage, expectedMessage);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.linkText("shopping cart"));
        // Verify the text ‘Shopping Cart.’
        String clickMessage = gettextFromElement(By.xpath("//span[text()='Shopping Cart']"));
        String expectedClickMessage = "Shopping Cart";
        Assert.assertEquals("Not the same message", expectedClickMessage, clickMessage);
        //* Verify the product name ‘Cronus Yoga Pant’
        String productName = gettextFromElement(By.xpath("//strong[@class='product-item-name']/a"));
        String expectedProductName="Cronus Yoga Pant";
        Assert.assertEquals("Product name is not same",expectedProductName,productName);
        //* Verify the product size ‘32’
        String actualSize=gettextFromElement(By.xpath("//dd[text()=32]"));
        String expectedSize="32";
        Assert.assertEquals("Size is not same",actualSize,expectedSize);
        //* Verify the product colour ‘Black’
        String actualColour=gettextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        String expectedColour="Black";
        Assert.assertEquals("Not same colour",actualColour,expectedColour);

    }

    //Closing the browser
    @After
    public void tearDown() {
        //closeBrowser();
    }
}
