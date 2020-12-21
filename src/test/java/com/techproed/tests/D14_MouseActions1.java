package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class D14_MouseActions1 extends TestBase {

    //1- Yeni bir class olusturalim: D14_MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //3- Cizili alan uzerinde sag click yapalim
    //4- Alert'te cikan yazinin "You selected a context menu" oldugunu test edelim.
    //5- Tamam diyerek alert'I kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim

    @Test
    public void test() throws InterruptedException {
        //1- Yeni bir class olusturalim: D14_MouseActions1

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim

        //3-1.adim
        Actions actions=new Actions(driver);

        //3-2.adim
        WebElement cizgiliAlan=driver.findElement(By.id("hot-spot"));

        //3-3.adim(sonuna perform kesinlikle olmali)
        actions.contextClick(cizgiliAlan).perform();

        Thread.sleep(5000);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String alertYazisi= driver.switchTo().alert().getText();
        Assert.assertEquals(alertYazisi,"You selected a context menu");

        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim

        WebElement seleniumLinki=driver.findElement(By.linkText("Elemental Selenium"));
        actions.click(seleniumLinki).perform();
        String ilkSayfaHandle=driver.getWindowHandle();
        Set<String> tumhandleKumesi=driver.getWindowHandles();
        String ikinciSayfaHandle="";
        for (String w: tumhandleKumesi
        ) {
            if (!w.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=w;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        WebElement seleniumYazisiElementi=driver.findElement(By.tagName("h1"));
        Assert.assertEquals(seleniumYazisiElementi.getText(),"Elemental Selenium");




    }






}
