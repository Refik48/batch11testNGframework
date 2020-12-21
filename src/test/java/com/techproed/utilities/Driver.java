package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    // Singleton class : object olusturulmasi kontrol altina alinan (genelde izin verilmeyen) classdir.
    // bunun icin baska classlarda Driver clasindan obje uretmem9izi saglayan default constructor'i
    // gorunur sekilde yazip access modifier'i private yapariz


    private Driver(){

    }

    static private WebDriver driver;

    static public WebDriver getDriver(){

        if (driver==null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver=new FirefoxDriver();
                        break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver=new SafariDriver();
                    break;


            }
        }



        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

     static public void closeDriver(){

        if(driver !=null){
            driver.close();
            driver=null;

        }
     }

}
