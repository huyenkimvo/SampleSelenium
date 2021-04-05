package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonsPage extends BasePage {

  public CommonsPage(WebDriver driver) {
    super(driver);
  }

  private final String LOADING_XPATH = "//div[contains(@class, 'q-inner-loading')]";

  private WebObject getLoading() {
    return findWebElement(LOADING_XPATH);
  }

  public boolean waitForLoadingToDisappear() {
    try {
      driverWait.until(ExpectedConditions.invisibilityOf(getLoading().getWebElement()));
    } catch (TimeoutException e) {
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
    return true;
  }
}