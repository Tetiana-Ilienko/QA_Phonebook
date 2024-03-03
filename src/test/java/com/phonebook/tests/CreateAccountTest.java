package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    // для того, чтобы тесты не падали , их нужно сделать независимыми друг от друга.
    //Для каждого теста нужно написать BeforeMethod? проверяющий необходимые условия

    @BeforeMethod
    public void ensurePrecondition(){
        // if login Link is not present
        if (!isElementPresent(By.cssSelector("[href='/login']"))){
            //Click on Sign Out button
            click(By.xpath("//button[.='Sign Out']"));
        }
    }




    /**
     * тест регистрации проводиться один раз
     */
//    @Test
//    public void createNewAccountPositiveTest(){
//
//        // click on Login Link
//        driver.findElement(By.cssSelector("[href='/login']")).click();
//        //enter email
//        driver.findElement(By.name("email")).click();
//        driver.findElement(By.name("email")).clear();
//        driver.findElement(By.name("email")).sendKeys("tatya@gmail.com");
//        //enter password
//        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("password")).clear();
//        driver.findElement(By.name("password")).sendKeys("77qazWsx$");
//        //click on the Registration
//        driver.findElement(By.name("registration")).click();
//        //assert Sign Out button is present
//        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
//    }
    @Test
    public void createExistedAccountNegativeTest() {

        // click on Login Link
//        driver.findElement(By.cssSelector("[href='/login']")).click();
        click(By.cssSelector("[href='/login']"));


        //enter email // автоматически создали из трех строк метод type  (refactor -> extract method)
//        click(By.name("email"));
//        driver.findElement(By.name("email")).clear();
//        driver.findElement(By.name("email")).sendKeys("tatya@gmail.com");
        type(By.name("email"), "tatya@gmail.com");
        // так как он универсальный - перенесли его в базовый клас ( refactor -> pull members up

        //enter password
        type(By.name("password"), "77qazWsx$");// автоматически создали  метод (refactor -> extract method)

        //click on the Registration
        click(By.name("registration"));

        //assert Sign Out button is present
        Assert.assertTrue(isAlertAppears());
    }


}
