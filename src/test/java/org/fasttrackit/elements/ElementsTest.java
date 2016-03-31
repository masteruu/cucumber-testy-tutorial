package org.fasttrackit.elements;


import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.Forms.FirstFormView;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ElementsTest extends TestBase {




    @Test
    public void checkboxTest() {
        openPage();
        FirstFormView form = new FirstFormView();
        Utils.sleep(2000);
        form.enterCheckbox.click();
        form.stopProcessCheckbox.click();
        Utils.sleep(2000);
        form.stopProcessLabel.click();
        form.enterLabel.click();





    }



    private void openPage() {
        System.out.println("open login test");
        driver.get("file:///C:/Users/chior/Desktop/Testy/src/test/functional/app-demo/bootstrap/index.html");
    }


}