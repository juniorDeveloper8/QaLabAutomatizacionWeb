package com.nttdata.steps;

import com.nttdata.page.ClothesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClothesStep {
    private WebDriver driver;

    public ClothesStep(WebDriver driver) {
        this.driver = driver;
    }

    public void clickClothes() {
        WebElement clothesElement = driver.findElement(ClothesPage.clothesLink);
        clothesElement.click();
    }

    public void navigateToMenCategory() {
        clickClothes();

        WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClothesPage.categoryMenuContainer));

        WebElement menElement = driver.findElement(ClothesPage.menLink);
        menElement.click();
    }
}
