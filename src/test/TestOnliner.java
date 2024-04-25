package src.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import src.test.base.BasePage;
import src.test.base.BaseTest;
import src.test.page.MainPage;
import src.test.page.TvPage;

public class TestOnliner extends BaseTest {
    @Test
    public void checkTv(){
        MainPage mainPage = new MainPage();
        mainPage.clickTvCategory();
        TvPage tvPage = new TvPage();
        Assert.assertEquals(true, tvPage.method(),"На странице нет товаров TCL");
    }
}
