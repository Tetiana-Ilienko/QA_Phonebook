package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // пишем метод, который проверит все страницы (вместо локатора используем переменную)
    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }

    @AfterMethod(enabled = false)// закрывается или нет сайт после запуска теста
    public void tearDown(){
        driver.quit();
    }
}
