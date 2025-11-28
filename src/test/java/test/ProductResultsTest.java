package test;

import java.util.HashMap;

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
        WebElement entryTitle = productsPage
                .getEntryTitleElement();

        Assert.assertTrue(entryTitle.isDisplayed());
        Assert.assertEquals(productResult.size(), 6);
    }

    @Test
    public void addProductWithHighestPriceToCartTest() {
        String userName = "standard_user";
        String password = "secret_sauce";
        Product productResult = new LoginPage(driver)
              .loginUser(userName, password)
              .getMaxProduct();

              System.out.println(productResult);

        Assert.assertEquals(productResult.getPrice(), "49.99");
        Assert.assertEquals(productResult.getName(), "Sauce Labs Fleece Jacket");

    }

}
