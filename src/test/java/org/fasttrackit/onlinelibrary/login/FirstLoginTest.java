package org.fasttrackit.onlinelibrary.login;


import com.sdl.selenium.web.utils.Utils;

import org.fasttrackit.exemple.ChangePasswordPage;
import org.fasttrackit.exemple.LoginPage;
import org.fasttrackit.exemple.NavigationBarPage;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FirstLoginTest extends TestBase {

    private LoginPage loginPage;
    private ChangePasswordPage changePasswordPage;
    private NavigationBarPage navigatorBarPage;

    public FirstLoginTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        changePasswordPage = PageFactory.initElements(driver, ChangePasswordPage.class);
        navigatorBarPage = PageFactory.initElements(driver, NavigationBarPage.class);
    }

    @Test
    public void validLoginTest() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");
        //doLogin("eu@fast.com", "eu.pass");


        try {
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        } catch (NoSuchElementException exception) {
            Assert.fail("Could not login.Logout button not found");


        }
    }

    @Test
    public void whenEnterInvalidPasswordIGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "wrong.pass");
        loginPage.assertThatErrorIs("Invalid user or password!");
    }

    @Test
    public void whenEnterOnlyEmailIGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "");
        loginPage.assertThatErrorIs("Please enter your password!");
    }

    @Test
    public void whenEnterOnlyPasswordIGetErrorMessage() {
        openLoginPage();
        loginPage.doLogin("", "some_pass");
        loginPage.assertThatErrorIs("Please enter your email!");
    }



    private void doLogin(String userName, String password) {

        loginPage.enterEmail(userName);


        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys(password);

        WebElement loginBtn = driver.findElement(By.className("btn"));
        loginBtn.click();
    }

    private void openLoginPage() {
        System.out.println("open login test");
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
    }


}