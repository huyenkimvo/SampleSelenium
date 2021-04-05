package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PhoneVerificationPage extends BasePage {
  public PhoneVerificationPage(WebDriver driver) {
    super(driver);
  }
  private final String CONTINUE_XPATH = "//button[normalize-space(.)='Continue']";
  private final String MESSAGE_SUCESS_XPATH = "//div[contains(text(), 'Wohoo')]/following-sibling::div/p";
  public WebObject getLblMessage() { return findWebElement(MESSAGE_SUCESS_XPATH); }
  public WebObject getBtnContinue() { return findWebElement(CONTINUE_XPATH); }

  public void verifySuccessfulMessageDisPlayed(String message){
    Assert.assertEquals(getLblMessage().getText(),message);
  }

  public void clickContinueButton(){
    waitForElementVisible(getBtnContinue());
    getBtnContinue().click();
  }
}
