package su.wattsapp.seleniumwebdriverdemo;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.UUID;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private WebDriver driver;
    private PageYaRu uiYa;
    private PageYandexRu uiYandex;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\QA\\83\\chromedriver.exe");
    }

    @Before
    public void launchDriver() {
        driver = new ChromeDriver();
        uiYa = new PageYaRu(driver);
        uiYandex = new PageYandexRu(driver);
    }

    @After
    public void quit() {
        driver.quit();
    }

    @Test
    public void wattTest() throws Exception{
        String uuid = UUID.randomUUID().toString();

        uiYa.LaunchPage();
        uiYa.input().sendKeys(uuid);
        uiYa.findBtn().click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("Яндекс: наш"));
        Assert.assertTrue(driver.getTitle().startsWith(uuid + " — Яндекс: наш"));
        Assert.assertEquals("Search field is wrong", uuid, uiYandex.inputField().getAttribute("value"));
        Assert.assertTrue("Found message is wrong",
                uiYandex.foundResult().getText().startsWith("Нашл") && uiYandex.foundResult().getText().endsWith(" результатов"));
    }

    @Test
    public void bottomLink() throws Exception {
        uiYa.LaunchPage();
        uiYa.yandex().click();
        Assert.assertEquals("https://yandex.ru/", driver.getCurrentUrl());
    }
}