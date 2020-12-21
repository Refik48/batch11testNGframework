package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class GlbSignUpPage {

    GlbSignUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


}
