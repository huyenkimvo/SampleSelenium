package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.WebDriver;

public class BusinessViewPage extends BasePage {

  public BusinessViewPage(WebDriver driver) {
    super(driver);
  }

  private final String CONTINUE_XPATH = "//button[normalize-space(.)='Continue']";
  public WebObject getBtnContinue() { return findWebElement(CONTINUE_XPATH); }

  public void clickContinueButton(){
    getBtnContinue().click();
  }
}