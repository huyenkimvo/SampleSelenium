package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OnboardingPage extends BasePage {

  public OnboardingPage(WebDriver driver) {
    super(driver);
  }

  private final String MESSAGE_CONTENT_XPATH = "//div[contains(@class,'aspire-cta-screen__content')]/p";
  private final String MESSAGE_TITLE_XPATH = "//div[contains(@class,'aspire-cta-screen__title')]";
  private final String MESSAGE_SUB_TITLE_XPATH = "//div[contains(@class,'aspire-cta-screen__subtitle')]";
  private final String CONTINUE_XPATH = "//button[normalize-space(.)='Continue']";



  public WebObject getLblContentMessage() {
    return findWebElement(MESSAGE_CONTENT_XPATH);
  }
  public WebObject getLblTitleMessage() {
    return findWebElement(MESSAGE_TITLE_XPATH);
  }
  public WebObject getLblSubTitleMessage() {
    return findWebElement(MESSAGE_SUB_TITLE_XPATH);
  }
  public WebObject getBtnContinue() {
    return findWebElement(CONTINUE_XPATH);
  }

  public void clickContinueButton(){
    getBtnContinue().click();
  }
  public void verifyTitleMessageDisplayedCorrectly(String titleMessage){
    Assert.assertEquals(getLblTitleMessage().getText(),titleMessage);
  }
  public void verifySubTitleMessageDisplayedCorrectly(String subTitleMessage){
    Assert.assertEquals(getLblSubTitleMessage().getText(),subTitleMessage);
  }
  public void verifyContentMessageDisplayedCorrectly(String contentMessage){
    Assert.assertEquals(getLblContentMessage().getText(),contentMessage);
  }
}