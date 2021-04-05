package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.nio.file.Paths;

public class IdentifyDetailsPage extends BasePage {

  public IdentifyDetailsPage(WebDriver driver) {
    super(driver);
  }

  private final String BEGIN_VERIFICATION_XPATH = "//button[.//span[contains(text(), 'Begin Verification')]]";
  private final String UPLOAD_KTP_XPATH = "//span[contains(text(),'Upload KTP')]/input";
  private final String SELFIE_XPATH = "//button[.//span[contains(text(),'Take a selfie')]]//input";
  private final String IMAGE_XPATH = "//div[contains(@class, 'q-list')]";
  private final String CONTINUE_XPATH = "//button[normalize-space(.)='Continue']";

  public WebObject getBtnBeginVerification() { return findWebElement(BEGIN_VERIFICATION_XPATH); }
  public WebObject getBtnUpload() { return findWebElement(UPLOAD_KTP_XPATH); }
  public WebObject getBtnSelfie() { return findWebElement(SELFIE_XPATH); }
  public WebObject getLblImage() { return findWebElement(IMAGE_XPATH); }
  public WebObject getBtnContinue() { return findWebElement(CONTINUE_XPATH); }

  public void uploadIDAndSelfieImages(){
    getBtnBeginVerification().click();
    uploadIDImage();
    getBtnContinue().click();
    uploadSelfieImage();
    getBtnContinue().click();
  }

  public void uploadIDImage(){
    uploadFile(getBtnUpload());
  }

  private void uploadFile(WebObject element){
    Path currentPath = Paths.get(System.getProperty("user.dir"));
    Path filePath = Paths.get(currentPath.toString(), "TestData", "IdentifyImage", "identify.png");
    element.getWebElement().sendKeys(filePath.toString());
    waitForElementVisible(getLblImage());
  }

  public void uploadSelfieImage(){
    uploadFile(getBtnSelfie());
  }

}