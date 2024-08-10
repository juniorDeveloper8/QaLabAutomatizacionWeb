package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PreciosStep {

    private WebDriver driver;

    public PreciosStep(WebDriver driver) {
        this.driver = driver;
    }

    private String cleanText(String text) {
        return text.replaceAll("[^\\p{Print}]", "").replaceAll("\\s+", " ").trim();
    }

    public void validarPrecios() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement confirmationPopup = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.confirmationPopup));
            System.out.println("Popup de confirmación visible.");
            WebElement totalInclTaxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.totalInclTax));
            String totalInclTaxText = cleanText(totalInclTaxElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            System.out.println("Total (impuestos incluidos): " + totalInclTaxText);
            String expectedTotal = "S/ 38.24";
            if (!totalInclTaxText.equals(expectedTotal)) {
                System.out.println("Error: Se esperaba un total (incl. impuestos) de \"" + expectedTotal + "\", pero se obtuvo: \"" + totalInclTaxText + "\"");
            }

            WebElement subtotalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.subtotalValue));
            String subtotalText = cleanText(subtotalElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            System.out.println("Subtotal: " + subtotalText);
            if (!subtotalText.equals(expectedTotal)) {
                System.out.println("Error: Se esperaba un subtotal de \"" + expectedTotal + "\", pero se obtuvo: \"" + subtotalText + "\"");
            }

            WebElement taxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CarritoPage.taxValue));
            String taxText = cleanText(taxElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            System.out.println("Impuestos: " + taxText);
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void finalizarCompra() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            WebElement finalizarCompraButton = wait.until(ExpectedConditions.elementToBeClickable(CarritoPage.finalizarCompraButton));

            finalizarCompraButton.click();

            System.out.println("Se hizo clic en el botón de finalizar compra.");
        } catch (Exception e) {
            System.out.println("Se ha producido un error al intentar finalizar la compra: " + e.getMessage());
        }
    }

}
