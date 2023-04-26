package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class AmazonTest extends Utility {

    @Before
    public void setUp() {
        openBrowser("https://www.amazon.co.uk/");
    }

    @Test

    public void amazonTest() {
        // Click on accept cookies
        clickOnElement(By.id("sp-cc-accept"));
        // Find search bar and type text
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"), "Dell Laptop");
        // Click on search
        clickOnElement(By.id("nav-search-submit-button"));
        // Click on Dell check box
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));
        // Get the list of items and store in list
        List<WebElement> dellList = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//a/span[contains(text(),'Dell')]"));
        // Verify total number of items displayed
        verifyNumberFromElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']//a/span[contains(text(),'Dell')]"), 30);
        // Iterate the item list and print the product names
        for (WebElement d : dellList) {
            String printList = d.getText();
            System.out.println(printList);
        }
        // Find and click Dell Latitude 5430
        clickOnElement(By.xpath("//span[normalize-space()='Dell Latitude 5430 14.0 inch FHD Business Laptop, Intel Core i7-1265U, 16GB RAM, 256GB SSD, Windows 11 Pro, Grey']"));
        // Verify product text
        verifyTextDisplayed(By.xpath("//span[@id='productTitle']"), "Dell Latitude 5430 14.0 inch FHD Business Laptop, Intel Core i7-1265U, 16GB RAM, 256GB SSD, Windows 11 Pro, Grey");
    }

    //@After
    public void tearDown() {
        closeBrowser();
    }

}
