package com.automation.test.testcases.demo.web.ui.aspire;

import com.automation.framework.core.datadriven.utils.DataProviderClass;
import com.automation.framework.core.datadriven.utils.GenerateDataUtils;
import com.automation.framework.core.datadriven.utils.JSONFileHelper;
import com.automation.framework.core.web.ui.object.BaseTest;
import com.automation.test.libraries.web.ui.model.RegisterModel;
import com.automation.test.libraries.web.ui.pageobjects.aspire.*;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {
  private static final Logger LOGGER = Logger.getLogger(SignUpTest.class);

  @Test(dataProvider = "CreateData", dataProviderClass = DataProviderClass.class)
  public void VerifyRegisterSuccessfully(Object dataJson){
    RegisterModel registerModel = JSONFileHelper.convertJsonElementToModelObject(dataJson,RegisterModel.class);
    LoginPage loginPage = new LoginPage(driver);
    RegisterPage registerPage = new RegisterPage(driver);
    CommonsPage commonsPage = new CommonsPage(driver);
    OTPPage OTPPage = new OTPPage(driver);
    PhoneVerificationPage phoneVerificationPage = new PhoneVerificationPage(driver);
    VerifyCompletionPage verifiedCompletionPage = new  VerifyCompletionPage(driver);
    RegisterMethodPage registerMethodPage = new RegisterMethodPage(driver);
    InformationNeededPage informationNeededPage = new InformationNeededPage(driver);
    BusinessViewPage businessViewPage = new BusinessViewPage(driver);
    PersonDetailsPage personDetailsPage = new PersonDetailsPage(driver);
    BusinessDetailsPage businessDetailsPage = new BusinessDetailsPage(driver);
    IdentifyViewPage identifyViewPage = new IdentifyViewPage(driver);
    IdentifyDetailsPage identifyDetailsPage = new IdentifyDetailsPage(driver);
    OnboardingPage onboardingPage = new OnboardingPage(driver);
    String generatedFullName = GenerateDataUtils.getTimeStamp();
    String generatedEmail = GenerateDataUtils.getTimeStamp() + registerModel.getEmailDomain();
    loginPage.navigateToURL(registerModel.getBaseUrl());
    commonsPage.waitForLoadingToDisappear();
    loginPage.checkPageTitle("Login to Aspire | Aspire");
    loginPage.clickRegisterLink();
    loginPage.checkPageTitle("Let's get started | Aspire");
    registerPage.typeFullName(generatedFullName);
    registerPage.typeEmail(generatedEmail);
    String generatedPhone = GenerateDataUtils.getTimeStampWithTenDigits();
    registerPage.typePhone(generatedPhone);
    registerPage.clickAppointedDirectorRad();
    registerPage.clickPolicyAgreementChk();
    registerPage.clickContinueBtn();
    commonsPage.waitForLoadingToDisappear();
    OTPPage.typeOTP(registerModel.getPhoneOTP());
    commonsPage.waitForLoadingToDisappear();
    phoneVerificationPage.verifySuccessfulMessageDisPlayed("You have successfully verified your mobile number. You’re on to a great start!");
    phoneVerificationPage.clickContinueButton();
    verifiedCompletionPage.clickContinueNoBusinessButton();
    commonsPage.waitForLoadingToDisappear();
    verifiedCompletionPage.clickRegisterBusinessLink();
    registerMethodPage.clickGetStartedStandardButton();
    informationNeededPage.clickGetStartedButton();
    personDetailsPage.typeIdentifyCardNumber(GenerateDataUtils.getTimeStamp());
    personDetailsPage.selectDateOfBith(registerModel.getBirthDate(), registerModel.getBirthMonth(), registerModel.getBirthYear());
    personDetailsPage.searchAndChooseNationality(registerModel.getNationality());
    personDetailsPage.selectGender(registerModel.getGender());
    personDetailsPage.selectInterestedProduct(registerModel.getInterestedProduct());
    personDetailsPage.clickSubmitButton();
    commonsPage.waitForLoadingToDisappear();
    OTPPage.typeOTP(registerModel.getEmailOTP());
    businessViewPage.clickContinueButton();
    String generatedBusinessName = GenerateDataUtils.getTimeStamp();
    businessDetailsPage.typeBusinessName(generatedBusinessName);
    businessDetailsPage.selectEntityCategory(registerModel.getEntityCateGory());
    businessDetailsPage.selectEntityType(registerModel.getEntityType());
    String generatedRegistrationNumber = GenerateDataUtils.getTimeStampWithTenDigits().replaceAll("[0-9]$","z");
    businessDetailsPage.typeRegistrationNumber(generatedRegistrationNumber);
    businessDetailsPage.typeLiveWebsite(registerModel.getLiveWebsite());
    businessDetailsPage.selectIndustry(registerModel.getIndustry());
    businessDetailsPage.selectSubIndustry(registerModel.getSubIndustry());
    businessDetailsPage.clickSubmitButton();
    identifyViewPage.clickGetStartedButton();
    identifyDetailsPage.clickBeginVerificationButton();
    identifyDetailsPage.uploadIDImage();
    identifyDetailsPage.clickContinueButton();
    identifyDetailsPage.uploadSelfieImage();
    identifyDetailsPage.clickContinueButton();
    onboardingPage.verifyTitleMessageDisplayedCorrectly("You are amazing and you know it");
    onboardingPage.verifyContentMessageDisplayedCorrectly("You have successfully completed the KYC processs and we have received your documents.");
    onboardingPage.clickContinueButton();
    onboardingPage.verifyTitleMessageDisplayedCorrectly("We are on it!");
    onboardingPage.verifySubTitleMessageDisplayedCorrectly("We have received your KYC documents.");
    onboardingPage.verifyContentMessageDisplayedCorrectly("Please sit back, relax and listen to some Beethoven while our team reviews them. We shall get back to you within 24 hours.");
  }
}

