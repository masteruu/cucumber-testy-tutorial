package org.fasttrackit.onlinelibrary.login;


import org.fasttrackit.example.ChangePasswordView;
import org.fasttrackit.exemple.LoginPage;
import org.fasttrackit.exemple.NavigationBarPage;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ChangePasswordTest extends TestBase {

    private LoginPage loginPage;
    private ChangePasswordView changePasswordPage = new ChangePasswordView();
    private NavigationBarPage navigatorBarPage;

    public ChangePasswordTest() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);

        navigatorBarPage = PageFactory.initElements(driver, NavigationBarPage.class);
    }


    @Test
    public void successChangePassword() {
        openLoginPage();
        loginPage.doLogin("eu@fast.com", "eu.pass");

        navigatorBarPage.PreferencesLink();
        changePasswordPage.changePassword("eu.pass", "eu.pass2", "eu.pass2");

        String statusElementText = changePasswordPage.getStatusMessage();
        String statusMessage = changePasswordPage.getStatusMessage();
        assertThat(statusElementText, is("Your password has been successfully changed."));

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