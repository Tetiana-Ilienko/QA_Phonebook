package com.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestBase {
    static WebDriver driver; // делаем переменную доступную для всех

   // @BeforeMethod
    @BeforeSuite //  используем, чтбы все тесты открывались о одном окне
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

    //@AfterMethod(enabled = true)// закрывается или нет сайт после запуска теста
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    public void type(By locator, String text) {// автоматически создали  метод (refactor -> extract method)
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) { // автоматически создали  метод (refactor -> extract method)
        driver.findElement(locator).click();// создали переменную (refactor -> introduces parameter)
    }

    public boolean isAlertAppears() {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            alert.accept();
            return true;
        }
    }
}
