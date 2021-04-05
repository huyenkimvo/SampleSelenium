package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.datadriven.utils.GenerateDataUtils;
import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.WebObject;
import com.automation.test.libraries.web.ui.model.RegisterModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BusinessDetailsPage extends BasePage {

  public BusinessDetailsPage(WebDriver driver) {
    super(driver);
  }

  private final String BUSINESS_NAME_XPATH = "//input[@data-cy='register-business-name']";
  private final String ENTITY_TYPE_CATEGORY_XPATH = "//div[@data-cy='register-business-registration-type']//i";
  private final String ENTITY_TYPE_XPATH = "//div[@data-cy='register-business-sub-registration-type']//i";
  private final String REGISTRATION_NUMBER_XPATH = "//input[@data-cy='register-business-registration-number']";
  private final String LIVE_WEBSITE_XPATH = "//input[@data-cy='register-business-registration-website-url']";
  private final String INDUSTRY_XPATH = "//div[@data-cy='register-business-industry']//i";
  private final String SUB_INDUSTRY_XPATH = "//div[@data-cy='register-business-sub-industry']//i";
  private final String OPTION_XPATH = "//div[starts-with(@id, 'qvs')]//div[contains(text(), '%s')]";
  private final String SUBMIT_XPATH = "//button[normalize-space() = 'Submit']";
  private final String ERROR_MESSAGE_XPATH = "//img[@src='img/common/error.svg']/following-sibling::div";

  public WebObject getTxtBusiness() { return findWebElement(BUSINESS_NAME_XPATH); }
  public WebObject getCboEntityCategogy() { return findWebElement(ENTITY_TYPE_CATEGORY_XPATH); }
  public WebObject getCboEntityType() { return findWebElement(ENTITY_TYPE_XPATH); }
  public WebObject getTxtRegistrationNumber() { return findWebElement(REGISTRATION_NUMBER_XPATH); }
  public WebObject getTxtLiveWebsite() { return findWebElement(LIVE_WEBSITE_XPATH); }
  public WebObject getCboIndustry() { return findWebElement(INDUSTRY_XPATH); }
  public WebObject getCboSubIndustry() { return findWebElement(SUB_INDUSTRY_XPATH); }
  public WebObject getBtnSubmit() { return findWebElement(SUBMIT_XPATH); }
  public WebObject getMsgError() { return findWebElement(ERROR_MESSAGE_XPATH); }
  public WebObject getOption(String option) { return findWebElement(String.format(OPTION_XPATH, option)); }

  public void typeBusinessDetails(String generatedBusinessName, RegisterModel registerModel, String generatedRegistrationNumber){
    typeBusinessName(generatedBusinessName);
    selectEntityCategory(registerModel.getEntityCateGory());
    selectEntityType(registerModel.getEntityType());
    typeRegistrationNumber(generatedRegistrationNumber);
    typeLiveWebsite(registerModel.getLiveWebsite());
    selectIndustry(registerModel.getIndustry());
    selectSubIndustry(registerModel.getSubIndustry());
    clickSubmitButton();
  }

  public void typeBusinessName(String businessName){
    getTxtBusiness().sendKeys(businessName, false);
  }

  public void selectEntityCategory(String entityCategory){
    getCboEntityCategogy().click();
    waitForElementVisible(getOption(entityCategory));
    getOption(entityCategory).click();
  }

  public void typeRegistrationNumber(String registrationNumber){
    getTxtRegistrationNumber().sendKeys(registrationNumber, false);
  }

  public void selectEntityType(String entityType){
    getCboEntityType().click();
    waitForElementVisible(getOption(entityType));
    getOption(entityType).click();
  }

  public void typeLiveWebsite(String website){
    getTxtLiveWebsite().sendKeys(website, false);
  }

  public void selectIndustry(String industry){
    getCboIndustry().click();
    waitForElementVisible(getOption(industry));
    getOption(industry).click();
  }

  public void selectSubIndustry(String subIndustry){
    getCboSubIndustry().click();
    waitForElementVisible(getOption(subIndustry));
    getOption(subIndustry).click();
  }
  public void clickSubmitButton(){
    getBtnSubmit().click();
    waitForElementInVisible(getBtnSubmit());
  }
  public void verifyErrorMessageDisPlayed(String message){
    Assert.assertEquals(getMsgError().getText(),message);
  }

}