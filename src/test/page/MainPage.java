package src.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import src.test.base.BasePage;

public class MainPage extends BasePage {
    private final static String ONLINER_URL = "http://onliner.by/";
    @FindBy(xpath = "//span[@class = 'project-navigation__sign'][contains(text(),'Телевизоры')]")
    private WebElement tvMenu;

    public MainPage() {
        driver.get(ONLINER_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickTvCategory() {
        tvMenu.click();
    }
}
