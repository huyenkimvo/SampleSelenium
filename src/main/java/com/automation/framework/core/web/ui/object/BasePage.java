package com.automation.framework.core.web.ui.object;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

enum SearchBy {
  ID,
  XPath,
  Name
}

public class BasePage {
  private final int DEFAULT_TIMEOUT = 60;
  private static final Logger LOGGER = Logger.getLogger(BasePage.class);

  private WebDriver driver;
  protected WebDriverWait driverWait;
  protected SoftAssert softAssert;

  private Locators locator;
  private String locatorValue;
  private String title;
  private PageType pageType;

  public BasePage(WebDriver driver){
    this.driver = driver;
    driverWait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    this.softAssert = new SoftAssert();
  }

  public WebDriver getWebDriver() {
    return driver;
  }

  public WebObject findWebElement(String locatorValue) {
    SearchBy searchType = SearchBy.ID;
    String searchStr = locatorValue;
    WebObject findObject = null;

    if (locatorValue.startsWith("//") || locatorValue.indexOf("//") > -1) {
      searchType = SearchBy.XPath;
    } else {
      int idx = locatorValue.indexOf('=');

      if (idx > 0) {
        String locatorHead = locatorValue.substring(0, idx);
        SearchBy lookingUpSearchBy = null;

        for (SearchBy s : SearchBy.values()) {
          if (s.name().equalsIgnoreCase(locatorHead)) {
            lookingUpSearchBy = s;
            break;
          }
        }

        if (lookingUpSearchBy == null) {
          throw new NullPointerException("SearchBy header text not found");
        }

        searchType = lookingUpSearchBy;
        searchStr = locatorValue.substring(idx + 1);
      }
    }
    try {
      switch (searchType) {
        case ID:
          findObject = new WebObject(driver.findElement(new By.ById(searchStr)));
          break;
        case XPath:
          findObject = new WebObject(driver.findElement(new By.ByXPath(searchStr)));
          break;
        case Name:
          findObject = new WebObject(driver.findElement(new By.ByName(searchStr)));
          break;
        default:
          break;
      }
    } catch (StaleElementReferenceException ex) {
      LOGGER.error(ex.getMessage());
    }

    return findObject;
  }

  public void navigateToURL(String sURL) {
    driver.navigate().to(sURL);
  }

  public void checkPageTitle(String title){
    this.softAssert.assertEquals(driver.getTitle().toString(), title);
  }

  public void verifyPageTitle(String title){
    Assert.assertEquals(driver.getTitle().toString(), title);
  }

  private boolean waitForPageDisplayed() {
    boolean isElementFound = this.isElementByLocatorExisted(this.locator, this.locatorValue);
    if (isElementFound) {
      LOGGER.info("You are now on " + this.title + " page");
    } else {
      LOGGER.warn("You are NOT on " + this.title + " page. Next steps may break your test!!!");
    }
    return isElementFound;
  }

  public void waitForElementVisible(WebObject element){
    this.driverWait.until(ExpectedConditions.visibilityOf(element.getWebElement()));
  }

  public void waitForElementToBeClickable(WebObject element){
    this.driverWait.until(ExpectedConditions.elementToBeClickable(element.getWebElement()));
  }

  public boolean waitForElementInVisible(WebObject element){
    try {
      driverWait.until(ExpectedConditions.invisibilityOf(element.getWebElement()));
    } catch (TimeoutException e) {
      return false;
    } catch (NoSuchElementException e) {
      return true;
    }
    return true;
  }

  public boolean isElementByLocatorExisted(Locators locator, String locatorValue) {
    try {
      this.findElementByLocator(locator, locatorValue);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  // Define a search criteria of finding an element by a specific locator
  private WebObject findElementByLocator(Locators locator, String locatorValue) {
    WebElement element = null;
    switch (locator) {
      case Id:
        element = driver.findElement(By.id(locatorValue));
        break;

      case Name:
        element = driver.findElement(By.name(locatorValue));
        break;

      case ClassName:
        element = driver.findElement(By.className(locatorValue));
        break;

      case Css:
        element = driver.findElement(By.cssSelector(locatorValue));
        break;

      case Xpath:
        element = driver.findElement(By.xpath(locatorValue));
        break;

      default:
    }
    if(element == null){
      String log = String.format("Unable to find element with locator '%s' and value '%s'", locator, locatorValue);
      throw new NoSuchElementException(log);
    }
    this.driverWait.until(ExpectedConditions.visibilityOf(element));
    return new WebObject(element);
  }

  public List<WebElement> findAllWebElementsByLocator(Locators locator, String locatorValue) {
    List<WebElement> elements = null;
    switch (locator) {
      case Id:
        elements = driver.findElements(By.id(locatorValue));
        break;

      case Name:
        elements = driver.findElements(By.name(locatorValue));
        break;

      case ClassName:
        elements = driver.findElements(By.className(locatorValue));
        break;

      case Css:
        elements = driver.findElements(By.cssSelector(locatorValue));
        break;

      case Xpath:
//        this.driverWait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(locatorValue))));
        elements = driver.findElements(By.xpath(locatorValue));
        break;

      default:
    }
    if(elements == null){
      String log = String.format("Unable to find element with locator '%s' and value '%s'", locator, locatorValue);
      throw new NoSuchElementException(log);
    }
    this.driverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    return elements;
  }
}