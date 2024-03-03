package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("tatya@gmail.com")
                .setPassword("77qazWsx$"));
        clickOnLoginButton();
        //assert Sing Out is present
        Assert.assertTrue(isSignOutButtonPresent());

    }

    @Test
    public void loginNegativeWithoutEmail() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setPassword("77qazWsx$"));
        clickOnLoginButton();
        //assert Sing Out is present
        Assert.assertTrue(isAlertAppears());

    }


}
