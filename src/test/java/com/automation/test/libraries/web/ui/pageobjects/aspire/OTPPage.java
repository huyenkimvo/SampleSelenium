package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.Locators;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.List;

public class OTPPage extends BasePage {

  public OTPPage(WebDriver driver) {
    super(driver);
  }

  private final String OTP_XPATH = "//div[contains(@class, 'digit-input')]//div[contains(@class, 'cursor-pointer')]";
  private final String OTP_INPUT_FORM_XPATH = "//form[contains(@class, 'verify-otp-form')]";

  public List<WebElement> getTxtOTPList() {
    return findAllWebElementsByLocator(Locators.Xpath, OTP_XPATH);
  }

  public WebObject getOPTForm() { return findWebElement(OTP_INPUT_FORM_XPATH); }

  public void typeOTP(String OTP){
    WebDriver driver = super.getWebDriver();
    waitForElementVisible(getOPTForm());
    List<WebElement> OTPElements = getTxtOTPList();
    List<String> code = Arrays.asList(OTP.split(""));
    for (int i = 0; i < OTPElements.size(); i++) {
      Actions builder = new Actions(driver);
      builder.moveToElement(OTPElements.get(i)).click().sendKeys(code.get(i)).build().perform();
    }
  }
}