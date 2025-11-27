package pages;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import model.Product;

public class ProductsPage {

    Product product;

    @FindBy(xpath="//span[text()='Products']")
    protected WebElement entryTitleElement;

    @FindAll({
        @FindBy(xpath="//div[@class='inventory_list']//div[@class='inventory_item_name ']"),
        @FindBy(xpath="text()")
    })
    private List<WebElement> productElementListAll;
    
    @FindBy(xpath=(".inventory_list .inventory_item_name "))
    private List<WebElement> productNameElementList; 
    
    @FindBy(xpath=("//div[@class='inventory_list']//div[@class='inventory_item_price']"))
    private List<WebElement> productPriceElementList;

    @FindBy(xpath="//button[text()='Add to cart']")
    private List<WebElement> productButtonElementList;



    protected WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEntryTitleElement() {
        return entryTitleElement;
    }

    public HashMap<Integer,Product> getProductList () {
        
        List<String> productNameList;
        productNameList=productNameElementList.stream().map(el -> el.getText()).collect(Collectors.toList());

        List<String> productPriceList;
        productPriceList = productPriceElementList.stream().map(el -> el.getText().replace("$", "")).collect(Collectors.toList());

        HashMap<Integer,Product> Products = new HashMap<>();

        for (int i=0; i < productNameList.size(); i++) {
            Products.put(i, new Product(productNameList.get(i), productPriceList.get(i), productButtonElementList.get(i)));
        }
        return Products;

    }

   

    




}
