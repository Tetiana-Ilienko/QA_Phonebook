package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!isHomeComponentPresent()){
            clickOnHomeLink();
        }
    }


    @Test
    public void isHomeComponentPresentTest(){ // тестовый метод, вызывающий метод, проверяющий длинну компонента
      //  System.out.println("Home Component is " + isHomeComponentPresent()); - такой способ используется только при отладке

        Assert.assertTrue(isHomeComponentPresent()); // тест упадет, если элемент не найден
        /** Все тесты должны заканчиваться Assert*/

    }


}
