package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        // if login Link is not present
        if (!isElementPresent(By.cssSelector("[href='/login']"))){
            //Click on Sign Out button
            click(By.xpath("//button[.='Sign Out']"));
        }
    }
    @Test
    public void loginPositiveTest() {

        // click on Login Link
        click(By.cssSelector("[href='/login']"));
        //enter email
        type(By.name("email"), "tatya@gmail.com");
        //enter password
        type(By.name("password"), "77qazWsx$");
        //click on the Login button
        click(By.name("login"));
        //assert Sing Out is present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));

    }
    // один класс- проверка одной функции (один ассерт)

}
