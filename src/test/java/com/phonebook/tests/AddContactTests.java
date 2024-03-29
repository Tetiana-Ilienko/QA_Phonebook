
package com.phonebook.tests;

import com.phonebook.fw.DataProviders;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class AddContactTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("tatya@gmail.com")
                .setPassword("77qazWsx$"));
        app.getUser().clickOnLoginButton();
    }



    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(
                new Contact()
                        .setName("Adam")
                        .setLastName("Schmidt")
                        .setPhone("1234567890")
                        .setEmail("adam@gm.com")
                        .setAddress("Berlin")
                        .setDescription("goalkeeper"));
        app.getContact().clickOnSaveButton();
        //assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreateByText("Adam"));


    }



    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();

    }




    @Test(dataProvider = "addContact",dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(String name, String lastname, String phone,
                                                       String email, String address, String desc) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm( new Contact()
                        .setName(name)
                        .setLastName(lastname)
                        .setPhone(phone)
                        .setEmail(email)
                        .setAddress(address)
                        .setDescription(desc));
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreateByText(name));
    }

    @BeforeMethod
    public void startLoggerBeforeTest(){
        logger.info("Add to:" );
    }



    @Test(dataProvider = "addContactFromCSV",dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProviderWithFile(Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        Assert.assertTrue(app.getContact().isContactCreateByText(contact.getName()));


    }





}
