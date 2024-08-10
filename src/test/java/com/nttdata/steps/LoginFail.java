package com.nttdata.steps;

import com.nttdata.page.LoginfailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginFail {
    private WebDriver driver;

    public LoginFail (WebDriver driver) {
        this.driver = driver;
    }

    private String cleanText(String text) {
        return text.replaceAll("[^\\p{Print}]", "").replaceAll("\\s+", " ").trim();
    }

    public void UserName(String email) {
        WebElement userInputElement = driver.findElement(LoginfailPage.email);
        userInputElement.sendKeys(email);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginfailPage.loginBtn));
    }

    public void Password(String clave) {
        this.driver.findElement(LoginfailPage.clave).sendKeys(clave);
    }

    public void singIn() {
        this.driver.findElement(LoginfailPage.loginBtn).click();
    }
}
