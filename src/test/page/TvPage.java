package src.test.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import src.test.base.BasePage;

import java.util.List;

public class TvPage extends BasePage {
    public void TvCategory() {
        PageFactory.initElements(driver, this);
    }

    public Boolean method() {

        Actions actions = new Actions(driver);

        WebElement middleElement = driver.findElement(By.xpath("//div[contains(text(),'Магазины')]"));
        actions.moveToElement(middleElement).perform();

        WebElement elementFilter = driver.findElement(By.xpath("//label[@class='catalog-form__checkbox-label']//div[contains(text(),'TCL')]"));
        elementFilter.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='catalog-interaction__state catalog-interaction__state_initial catalog-interaction__state_disabled catalog-interaction__state_animated']")));

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='catalog-form__offers-part catalog-form__offers-part_data']"));

        int itemsListLength = products.size();
        for (int i = 0; i < itemsListLength - 1; i++) {
            if (!((RemoteWebElement) products.get(i)).findElementByTagName("a").getText().contains("TCL")) {
                return false;
            }
        }
        return true;
    }
}
