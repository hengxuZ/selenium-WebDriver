package com.masteringselenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasicIT extends DriverBase {
    private ExpectedCondition<Boolean> pageTitleStartsWith(final String searchString){
        return driver -> driver.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
    };

    private void googleExampleThatSearchesFor(final String searchString) {
        WebDriver driver = DriverBase.getDriver();

        driver.get("https://www.baidu.com");

        WebElement searchField = driver.findElement(By.name("wd"));

        searchField.clear();

        searchField.sendKeys(searchString);

        System.out.println("page title is:"+driver.getTitle());

        searchField.submit();

        WebDriverWait wait = new WebDriverWait(driver,10,100);
        wait.until(pageTitleStartsWith(searchString));
        System.out.println("page title is " + driver.getTitle());

    }

    @Test
    public void baiduCheeseExample() {
        googleExampleThatSearchesFor("cheese");
    }
    @Test
    public void baiduchineseExample() {
        googleExampleThatSearchesFor("中文");
    }


}
