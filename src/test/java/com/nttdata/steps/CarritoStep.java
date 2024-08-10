package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CarritoStep {

    private WebDriver driver;

    public CarritoStep(WebDriver driver) {
        this.driver = driver;
    }

    public void selectProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.elementToBeClickable(CarritoPage.firstProductThumbnail));
        productElement.click();
    }

    public void increaseQuantity(int times) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = 0; i < times; i++) {
            WebElement incrementButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".touchspin-up")));
            incrementButton.click();
        }
    }


    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(CarritoPage.addToCartButton));
        addToCartButton.click();
    }

    public void validateConfirmationPopup(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.confirmationPopup));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.confirmationMessage));

        String actualMessage = messageElement.getText().trim();
        System.out.println("Texto del mensaje en el modal: " + actualMessage);

        String cleanedMessage = actualMessage.replaceAll("[^\\p{Print}]", "").trim();
        String cleanedExpectedMessage = expectedMessage.replaceAll("[^\\p{Print}]", "").trim();

        if (!cleanedMessage.equals(cleanedExpectedMessage)) {
            throw new AssertionError("Expected message: \"" + cleanedExpectedMessage + "\" but got: \"" + cleanedMessage + "\"");
        }
    }

}
