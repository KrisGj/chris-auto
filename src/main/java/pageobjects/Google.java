package pageobjects;

import framework.Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Google extends Helpers {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@id='appbar']")
    private WebElement searchResultsPageHeader;

    public Google(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterAndSubmitSearch(String query) {
        this.waitForElementToAppear(searchField);
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);
        this.waitForElementToAppear(searchResultsPageHeader);
    }

    public void selectSearchResult(String resultTitle) {
        driver.findElement(By.xpath("//h3[contains(text(),\"" + resultTitle + "\")]")).click();
        this.waitForPageLoad();
    }
}