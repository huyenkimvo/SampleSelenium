package com.automation.test.libraries.web.ui.pageobjects.aspire;

import com.automation.framework.core.web.ui.object.BasePage;
import com.automation.framework.core.web.ui.object.Locators;
import com.automation.framework.core.web.ui.object.WebObject;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Date;

import java.util.List;

public class PersonDetailsPage extends BasePage {

  public PersonDetailsPage(WebDriver driver) {
    super(driver);
  }

  private final String IDENTIFY_CARD_XPATH = "//div[contains(@label, 'Identity Card Number')]//input";
  private final String BIRTHDAY_XPATH = "//div[contains(@label, 'Date of Birth')]//input";
  private final String YEAR_MONTH_XPATH = "//div[@id='fc_push_frame']/following-sibling::div//button[.//span[contains(text(), '%s')]]";
  private final String YEAR_OPTION_XPATH = "//div[contains(@class, 'years-item')]//button[.//span[contains(text(), '%s')]]";
  private final String YEAR_LEFT_XPATH = "//div[4]//button[.//i[contains(@class, 'fa-chevron-left')]]";
  private final String MONTH_OPTION_XPATH = "//div[contains(@class, 'months-item')]/button[.//span[contains(text(), '%s')]]";
  private final String DATE_OPTION_XPATH = "//div[contains(@class, 'q-date__calendar-item--in')]/button[.//span[contains(text(), '%s')]]";

  private final String NATIONALITY_XPATH = "//input[contains(@url, 'countries/all')]";
  private final String NATIONALITY_OPTION_XPATH = "//div[starts-with(@id, 'qvs')]//div[contains(@class, 'item__label')]";
  private final String GENDER_XPATH = "//input[@data-cy = 'kyc-gender']";
  private final String GENDER_OPTION_XPATH = "//div[starts-with(@id, 'qvs')]//div[contains(text(), '%s')]";
  private final String PRODUCT_OPTION_XPATH = "//div[./div[contains(text(), '%s')]]/following-sibling::div//*[name()='svg']";
  private final String PRODUCT_XPATH = "//div[@url = 'options']";
  private final String SUBMIT_XPATH = "//button[normalize-space() = 'Submit']";

  public WebObject getTxtIdentifyCardNumber() { return findWebElement(IDENTIFY_CARD_XPATH); }
  public WebObject getTxtDateOfBirth() { return findWebElement(BIRTHDAY_XPATH); }
  public WebObject getLnkYear(String year) { return findWebElement(String.format(YEAR_MONTH_XPATH, year)); }
  public WebObject getYearOption(String year) { return findWebElement(String.format(YEAR_OPTION_XPATH, year)); }
  public WebObject getMonthOption(String month) { return findWebElement(String.format(MONTH_OPTION_XPATH, month)); }
  public WebObject getDateOption(String date) { return findWebElement(String.format(DATE_OPTION_XPATH, date)); }
  public WebObject getLnkMonth(String month) { return findWebElement(String.format(YEAR_MONTH_XPATH, month)); }
  public WebObject getBtnYearLeft() { return findWebElement(YEAR_LEFT_XPATH); }
  public WebObject getTxtNationality() { return findWebElement(NATIONALITY_XPATH); }
  public WebObject getNationalityOption() { return findWebElement(NATIONALITY_OPTION_XPATH); }
  public WebObject getTxtGender() { return findWebElement(GENDER_XPATH); }
  public WebObject getGender(String gender) { return findWebElement(String.format(GENDER_OPTION_XPATH, gender)); }
  public WebObject getProductOption(String product) { return findWebElement(String.format(PRODUCT_OPTION_XPATH, product)); }
  public WebObject getProducts() { return findWebElement(PRODUCT_XPATH); }
  public WebObject getBtnSubmit() { return findWebElement(SUBMIT_XPATH); }

  public List<WebElement> getBtnYearList(String year) {
    return findAllWebElementsByLocator(Locators.Xpath, String.format(YEAR_OPTION_XPATH, year));
  }

  public void typeIdentifyCardNumber(String IDNumber){
    getTxtIdentifyCardNumber().sendKeys(IDNumber, false);
  }
  public void selectDateOfBith(String date, String month, String year) {
    Date now = new Date();
    int currentYear = now.getYear();
    int currentMonth = now.getMonth();
    System.out.println(currentYear);
    System.out.println(currentMonth);
    getTxtDateOfBirth().click();
    super.driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[contains(@class, 'q-body--prevent-scroll')]")));
    int yearLoop = 2021 - Integer.parseInt(year);
    System.out.println(yearLoop);
    for(int i = 0; i < yearLoop; i++){
      getBtnYearLeft().click();
    }
    getLnkMonth("April").click();
    getMonthOption(month).click();
    getDateOption(date).click();
  }
  public void searchAndChooseNationality(String nationality){
    getTxtNationality().sendKeys(nationality, false);
    getNationalityOption().click();
  }

  public void selectGender(String gender){
    getTxtGender().click();
    waitForElementVisible(getGender(gender));
    getGender(gender).click();
  }

  public void selectInterestedProduct(String product){
    getProducts().click();
    waitForElementVisible(getProductOption(product));
    getProductOption(product).click();
  }

  public void clickSubmitButton(){
    getBtnSubmit().click();
//    waitForElementInVisible(getBtnSubmit());
  }

}