package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
  public RegisterPage(WebDriver driver) {
    super(driver);
  }


  private final String FULLNAME_XPATH = "//input[@name = 'full_name']";
  private final String EMAIL_XPATH = "//input[@name = 'email']";
  private final String PHONE_XPATH = "//input[@name = 'phone']";
  private final String COUNTRY_XPATH = "//div[@name = 'phone']//div[@role = 'img']";
  private final String APPOINTED_DIRECTOR_XPATH = "//div[@aria-label='Appointed director']//*[name()='svg']";
  private final String POLICY_XPATH = "//div[contains(@data-cy, 'register-person-privacy')]//*[name()='svg']";
  private final String CONTINUE_XPATH = "//button[normalize-space(.)='Continue']";

  public WebObject getTxtFullName() { return findWebElement(FULLNAME_XPATH); }
  public WebObject getTxtEmail() { return findWebElement(EMAIL_XPATH); }
  public WebObject getTxtPhone() { return findWebElement(PHONE_XPATH); }
  public WebObject getImgCountry() { return findWebElement(COUNTRY_XPATH); }
  public WebObject getRadAppointedDirector() { return findWebElement(APPOINTED_DIRECTOR_XPATH); }
  public WebObject getChkPolicyAgreement() { return findWebElement(POLICY_XPATH); }
  public WebObject getBtnContinue() { return findWebElement(CONTINUE_XPATH); }


  public void typeFullName(String fullName){
    getTxtFullName().sendKeys(fullName, false);
  }
  public void typeEmail(String email){
    getTxtEmail().sendKeys(email, false);
  }
  public void typePhone(String phone){
    waitForElementVisible(getImgCountry());
    getTxtPhone().sendKeys(phone, false);

  }
  public void clickAppointedDirectorRad() {
    getRadAppointedDirector().click();
  }
  public void clickPolicyAgreementChk() {
    getChkPolicyAgreement().click();
  }
  public void clickContinueBtn() {
    getBtnContinue().click();
    waitForElementInVisible(getBtnContinue());
  }


}
