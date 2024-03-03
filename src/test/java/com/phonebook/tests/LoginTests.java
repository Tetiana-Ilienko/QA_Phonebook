package com.phonebook.tests;

import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("tatya@gmail.com")
                .setPassword("77qazWsx$"));
        app.getUser().clickOnLoginButton();
        //assert Sing Out is present
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }

    @Test
    public void loginNegativeWithoutEmail() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setPassword("77qazWsx$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isAlertAppears());

    }


}
