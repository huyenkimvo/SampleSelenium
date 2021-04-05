package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
  public LoginPage(WebDriver driver) {
    super(driver);
  }
  private final String REGISTER_XPATH = "//a[normalize-space(.)='Register']";
  public WebObject getLnkRegister() { return findWebElement(REGISTER_XPATH); }
  public void clickRegisterLink() {
    getLnkRegister().click();
  }
}
