package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.WebDriver;

public class InformationNeededPage extends BasePage {

  public InformationNeededPage(WebDriver driver) {
    super(driver);
  }

  private final String GET_STARTED_XPATH = "//button[.//span[contains(text(), 'Get Started')]]";
  public WebObject getBtnGetStarted() { return findWebElement(GET_STARTED_XPATH); }

  public void clickGetStartedButton(){
    getBtnGetStarted().click();
  }
}