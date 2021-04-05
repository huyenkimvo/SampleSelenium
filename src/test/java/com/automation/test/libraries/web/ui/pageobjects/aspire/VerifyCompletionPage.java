package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.WebDriver;

public class VerifyCompletionPage extends BasePage {

  public VerifyCompletionPage(WebDriver driver) {
    super(driver);
  }

  private final String NO_BUSINESS_XPATH = "//div[./span[contains(text(), 'I don’t have a business yet')]]/following-sibling::button";
  private final String REGISTERED_BUSINESS_XPATH = "//div[contains(@class, 'no-business')]//span[contains(text(), 'registered business')]";
  public WebObject getBtnNoBusiness() { return findWebElement(NO_BUSINESS_XPATH); }
  public WebObject getInkRegisterBusiness() { return findWebElement(REGISTERED_BUSINESS_XPATH); }

  public void clickContinueNoBusinessButton(){
    getBtnNoBusiness().click();
  }
  public void clickRegisterBusinessLink(){
    getInkRegisterBusiness().click();
  }
}