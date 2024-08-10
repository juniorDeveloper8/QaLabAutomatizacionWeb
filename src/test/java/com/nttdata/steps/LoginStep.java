package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginStep {

    private WebDriver driver;

    public LoginStep (WebDriver driver) {
        this.driver = driver;
    }

    public void UserName(String email) {
        WebElement userInputElement = driver.findElement(LoginPage.email);
        userInputElement.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginBtn));
    }

    public void Password(String clave) {
        this.driver.findElement(LoginPage.clave).sendKeys(clave);
    }

    public void singIn() {
        this.driver.findElement(LoginPage.loginBtn).click();
    }
}
