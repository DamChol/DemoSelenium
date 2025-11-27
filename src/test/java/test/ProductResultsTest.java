package test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import model.Product;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductResultsTest extends BaseTest {

    @Test
    public void noOfProductsTest() {

        
        String userName = "standard_user";
        String password = "secret_sauce";
        HashMap<Integer,Product> productResult = new LoginPage(driver)
                                        .loginUser(userName, password)
                                        .getProductList();
        // System.out.println("Products listed: /n");
        // for (Product elem : productResult.values()) {
        //     System.out.printf("Product name: %s, Price: %s ;%n", elem.getName(), elem.getPrice());
        // }

        ProductsPage productsPage = new ProductsPage(driver);
        WebElement entryTitle = productsPage.getEntryTitleElement();

        Assert.assertTrue(entryTitle.isDisplayed());
        Assert.assertEquals(productResult.size(), 6);
    }

    @Test
    public void addProductWithHighestPriceToCart() {
        String userName = "standard_user";
        String password = "secret_sauce";
        HashMap<Integer,Product> productResult = new LoginPage(driver)
                                        .loginUser(userName, password)
                                        .getProductList();


        Double maxPriceProduct = productResult.entrySet().stream()
        .mapToDouble(entry -> Double.parseDouble(entry.getValue().getPrice())).max().getAsDouble();

        java.util.Optional<Entry<Integer,Product>> maxProduct = productResult.entrySet().stream().filter(el -> el.getValue().getPrice().contentEquals(String.valueOf(maxPriceProduct))).findFirst();
        
        if (maxProduct.isPresent()) {
            Map.Entry<Integer, Product> entry = maxProduct.get();
            Product znalezionyProdukt = entry.getValue(); 
            System.out.println("Znaleziono produkt: " + znalezionyProdukt);
            znalezionyProdukt.getButtonWebElement().click();
        } else {
            System.out.println("Nie znaleziono produktu o podanych kryteriach.");
        }
        
            
    }



}
