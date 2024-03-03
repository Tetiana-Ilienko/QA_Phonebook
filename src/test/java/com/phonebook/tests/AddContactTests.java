
package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("tatya@gmail.com")
                .setPassword("77qazWsx$"));
        clickOnLoginButton();
    }



    @Test
    public void addContactPositiveTest() {
        clickOnAddLink();
        fillContactForm(
                new Contact()
                        .setName("Adam")
                        .setLastName("Schmidt")
                        .setPhone("1234567890")
                        .setEmail("adam@gm.com")
                        .setAddress("Berlin")
                        .setDescription("goalkeeper"));
        clickOnSaveButton();
        //assert Contact is added by text
        Assert.assertTrue(isContactCreateByText("Adam"));


    }

    @AfterMethod
    public void postCondition() {
        removeContact();

    }


}
