package com.automation.framework.core.web.ui.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebObject {
    private WebElement webElement;

    public WebElement getWebElement() {
        return webElement;
    }

    public WebObject(WebElement webElement) {
        this.webElement = webElement;
    }

    public String getText() {
        String text = webElement.getText().trim();
        return text;
    }

    public String getValue() {
        return webElement.getAttribute("value");
    }

    public void click() {
        webElement.click();
    }

    public void sendKeys(String inputText, boolean submit) {
        webElement.clear();

        webElement.sendKeys(inputText);

        if (submit) {
            webElement.submit();
        }
    }

    public void selectOptionByString(String inputText){
        new Select(webElement).selectByVisibleText(inputText);
    }
}
