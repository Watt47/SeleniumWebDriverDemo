package su.wattsapp.seleniumwebdriverdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Vladimir on 6/28/2020.
 */

class PageYandexRu {
    private WebDriver driver;
    WebElement inputField(){
        return driver.findElement(By.className("input__box")).findElement(By.tagName("input"));
    }

    WebElement foundResult(){
        return driver.findElement(By.className("serp-adv__found"));
    }

    PageYandexRu(WebDriver driver) {
        this.driver = driver;
    }

    void LaunchPage(){
        driver.get("http://" + "yandex.ru");
    }
}
