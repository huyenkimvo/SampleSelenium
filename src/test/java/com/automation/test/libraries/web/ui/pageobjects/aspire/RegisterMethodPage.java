package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.WebDriver;

public class RegisterMethodPage extends BasePage {

  public RegisterMethodPage(WebDriver driver) {
    super(driver);
  }

  private final String STANDARD_REGISTRATION_XPATH = "//div[contains(text(), 'Standard Registration')]/following-sibling::button";
  public WebObject getBtnGetStartedStandard() { return findWebElement(STANDARD_REGISTRATION_XPATH); }

  public void clickGetStartedStandardButton(){
    getBtnGetStartedStandard().click();
  }
}