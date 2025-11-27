package model;

import org.openqa.selenium.WebElement;

public class Product {

    private String name;
    private String price;
    private WebElement buttonWebElement;

    public Product(String name, String price, WebElement buttonWebElement) {
        this.name = name;
        this.price = price;
        this.buttonWebElement = buttonWebElement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public WebElement getButtonWebElement() {
        return buttonWebElement;
    }

    public void setButtonWebElement(WebElement buttonWebElement) {
        this.buttonWebElement = buttonWebElement;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", buttonWebElement=" + buttonWebElement + "]";
    }


    

    

    

}
