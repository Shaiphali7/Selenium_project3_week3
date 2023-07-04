package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    //Opening and setting the browser

    @Before
    public void setUp() {
        openBrowser();
    }

    //Verify that products name displayed in alphabetical order
    @Test
    public void verifyTheSortByProductNameFilter() {
        //Initialization of Action object
        Actions action = new Actions(driver);
        //Mouse Hover on Women Menu
        WebElement womenHoverElement = getElement(By.xpath("//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'][1]"));
        action.moveToElement(womenHoverElement).build().perform();
        // Mouse Hover on Tops
        WebElement topHoverElement = getElement(By.xpath("//a[@id='ui-id-9']"));
        action.moveToElement(topHoverElement).build().perform();
        //Click on Jackets
        WebElement jacketSelect = getElement(By.xpath("//a[@id='ui-id-11']"));
        action.moveToElement(jacketSelect).click().build().perform();
        //Select Sort By filter “Product Name”
        WebElement dropDown = getElement(By.id("sorter"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Product Name");
/*
Verify the products name display in alphabetical order
 */
//Get the product in list form
        List<WebElement> productList = driver.findElements(By.xpath("//a[@class='product-item-link']"));
        System.out.println("Number of products are " + productList.size());
        //Declared two String list to compare the text
        List<String> productName=new ArrayList<>();
        List<String> sortedProductName=new ArrayList<>();
        for (WebElement list:productList) {
            productName.add(list.getText().toLowerCase());
            sortedProductName.add(list.getText().toLowerCase());
            System.out.println(list.getText());

        }
        Collections.sort(sortedProductName,Collections.reverseOrder());
        Assert.assertTrue(productName.equals(sortedProductName));


    }
    @Test
    public void verifyTheSortByPriceFilter()
    {
        Actions action = new Actions(driver);
        //Mouse Hover on Women Menu
        WebElement womenHoverElement = getElement(By.xpath("//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'][1]"));
        action.moveToElement(womenHoverElement).build().perform();
        // Mouse Hover on Tops
        WebElement topHoverElement = getElement(By.xpath("//a[@id='ui-id-9']"));
        action.moveToElement(topHoverElement).build().perform();
        //Click on Jackets
        WebElement jacketSelect = getElement(By.xpath("//a[@id='ui-id-11']"));
        action.moveToElement(jacketSelect).click().build().perform();
        //Select Sort By filter “Product Name”
        WebElement dropDown = getElement(By.id("sorter"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Price");
        //Verify the products price display in Low to High
    }


    //Closing the browser
    @After
    public void tearDown() {
        //closeBrowser();
    }
}
