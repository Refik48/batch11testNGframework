package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class D14_KeyboardActions2 extends TestBase {
    //2- https://www.facebook.com sayfasina gidelim
    //3- Kullanici adi : Mehmet , sifre : 12345 degerlerini girip login tusuna basalim
    //4- basarili login olmadigini test edin


    @Test
    public void test() throws InterruptedException {
        //2- https://www.facebook.com sayfasina gidelim
        driver.get("https://www.facebook.com");

        //3- Kullanici adi : Mehmet , sifre : 12345 degerlerini girip login tusuna basalim

        Actions actions=new Actions(driver);
        WebElement userName=driver.findElement(By.id("email"));
        actions.click(userName)
                .sendKeys("mehmet")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(5000);
        //4- basarili login olmadigini test edin




    }
}
