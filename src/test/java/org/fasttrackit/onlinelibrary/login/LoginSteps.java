package org.fasttrackit.onlinelibrary.login;


import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;

import org.apache.xpath.SourceTree;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LoginSteps extends TestBase {

    @Test
    public void validLoginTest() {
        driver.get("https://rawgit.com/sdl/Testy/master/src/test/functional/app-demo/login.html");
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("eu@fast.com");

        WebElement passField = driver.findElement(By.name("password"));
        passField.sendKeys("eu.pass");

        WebElement loginBtn = driver.findElement(By.className("btn"));
        loginBtn.click();

        WebElement prefButton = driver.findElement(By.xpath("//nav//button"));
        prefButton.click();

        try {
            Thread.sleep(300);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        WebElement oldpass = driver.findElement(By.xpath("//div[@id='preferences-win']//input[@name='password']"));
        oldpass.sendKeys("eu.pass");

        WebElement newpass = driver.findElement(By.xpath("//input[@name='newPassword']"));
        newpass.sendKeys("eu.pass2");

        WebElement reppass = driver.findElement(By.xpath("//input[@name='newPasswordRepeat']"));
        reppass.sendKeys("eu.pass2");

        WebElement save = driver.findElement(By.cssSelector("#preferences-win button.btn-warning"));
        save.click();

        WebElement status = driver.findElement(By.cssSelector(".status-msg"));
        assertThat(status.getText(), is ("Your password has been successfully changed."));

    }




}