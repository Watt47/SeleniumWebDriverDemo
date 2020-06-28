package su.wattsapp.seleniumwebdriverdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Vladimir on 6/28/2020.
 */

class PageYaRu {
    private WebDriver driver;
    WebElement input(){
        return driver.findElement(By.id("text"));
    }
    WebElement findBtn(){
        return driver.findElement(By.className("search2__button")).findElement(By.tagName("button"));
    }
    WebElement yandex(){
        return driver.findElement(By.xpath("//a[@title=\"Яндекс\"]"));
    }

    PageYaRu(WebDriver driver) {
        this.driver = driver;
    }

    void LaunchPage(){
        driver.get("http://" + "ya.ru");
    }
}
