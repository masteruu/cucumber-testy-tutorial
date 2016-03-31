package org.fasttrackit.Forms;


import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;

public class FirstFormView extends WebLocator{

    public FirstFormView() {
        setTag("form");
        WebLocator legend = new WebLocator().setText("Form Title");
        setChildNodes(legend);

    }

    private WebLocator stopProcessContainer = new WebLocator(this).setElPath("/div[3]");
    private WebLocator enterContainer = new WebLocator(this).setElPath("/div[4]");

    public CheckBox stopProcessCheckbox = new CheckBox(stopProcessContainer);
    public CheckBox enterCheckbox = new CheckBox(enterContainer);


    public CheckBox labelEnter = new CheckBox(this).setElPath("/div[4]//input[@type='checkbox']");

    public WebLocator stopProcessLabel = new WebLocator(this).setTag("label").setText("Stop the process?", SearchType.TRIM);
    public WebLocator enterLabel = new WebLocator(this).setTag("label").setText("Label with Enter.", SearchType.TRIM, SearchType.CHILD_NODE);





    public static void main(String[] args) {
        FirstFormView formView = new FirstFormView();

        System.out.println(formView.stopProcessLabel.getSelector());
        WebLocator selectCalendar = new WebLocator(formView).setClasses("icon-calendar");

    }





}
