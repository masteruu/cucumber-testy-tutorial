package org.fasttrackit.exemple;


import com.sdl.selenium.web.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationBarPage {
    @FindBy(how = How.XPATH, using = "//nav//button")
    private WebElement Preferences;

    public void PreferencesLink() {
        Preferences.click();
        Utils.sleep(1000);

    }

}
