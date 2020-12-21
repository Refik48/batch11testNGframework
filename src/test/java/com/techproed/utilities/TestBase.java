package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //default : package private: ayni package'dakiler ulasabilir
    // private : sadece o class'dan ulasilabilir
    // protected : ayni package ve childs
    // public : Herkes


    protected WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }



}
//default :package private:ayni packaagetekiler olusabilir
//private: sadece o classlardan olusabilir
//protected:ayni  package ve childs
//public: herkes
//baska classlardan olusturulan methodlara ulasmak iciin iki yol vardir
//ya obje olusturacaz ya da parent child iliskisi kuracaz
//parent child iliskisi kurmak icin extends yaptik test base parent,,TestBaseilk child
//public void test(){
//burada driver objesi olsaydi kullanirldi fakat olmadigi icin diger test base gitti ordan aldi
//yani parentten aldi
//proteceted yapmamizin sebebi,,, yazmasak default olur ve sadece utilities icindeki classlardan
//ulasabilirim. o yuzden protected yapiyorum ki diger packagelerden ulasabileyim
//public yaparsak bu sefer herkes erisir bu sefer icerigi degistirebilir