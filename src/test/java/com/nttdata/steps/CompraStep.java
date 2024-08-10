package com.nttdata.steps;

import com.nttdata.page.CarritoPage;
import com.nttdata.page.CompraPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompraStep {

    private WebDriver driver;

    public CompraStep(WebDriver driver) {
        this.driver = driver;
    }

    private String cleanText(String text) {
        return text.replaceAll("[^\\p{Print}]", "").replaceAll("\\s+", " ").trim();
    }

    public void validarPreciosFinales() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        try {
            WebElement totalExclTaxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CompraPage.totalExclTax));
            String totalExclTaxText = cleanText(totalExclTaxElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            System.out.println("Total (impuestos excluidos): " + totalExclTaxText);
            String expectedTotalExclTax = "S/ 38.24";
            if (!totalExclTaxText.equals(expectedTotalExclTax)) {
                System.out.println("Error: Se esperaba un total (excl. impuestos) de \"" + expectedTotalExclTax + "\", pero se obtuvo: \"" + totalExclTaxText + "\"");
            }

            WebElement totalInclTaxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CompraPage.totalInclTax));
            String totalInclTaxText = cleanText(totalInclTaxElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            System.out.println("Total (impuestos incluidos): " + totalInclTaxText);
            String expectedTotalInclTax = "S/ 38.24";
            if (!totalInclTaxText.equals(expectedTotalInclTax)) {
                System.out.println("Error: Se esperaba un total (incl. impuestos) de \"" + expectedTotalInclTax + "\", pero se obtuvo: \"" + totalInclTaxText + "\"");
            }

            WebElement taxElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CompraPage.taxValue));
            String taxText = cleanText(taxElement.getText()).replace("S/&nbsp;", "S/ ").trim();
            System.out.println("Impuestos: " + taxText);
            String expectedTax = "S/ 0.00";
            if (!taxText.equals(expectedTax)) {
                System.out.println("Error: Se esperaban impuestos de \"" + expectedTax + "\", pero se obtuvo: \"" + taxText + "\"");
            }

        } catch (Exception e) {
            System.out.println("Se ha producido un error al validar los precios finales: " + e.getMessage());
        }
    }


    public void validarTituloCarrito() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cartTitleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CompraPage.cartTitle));
            String cartTitleText = cleanText(cartTitleElement.getText());
            System.out.println("Título del carrito: " + cartTitleText);
            String expectedCartTitle = "CARRITO";

            Assertions.assertEquals(expectedCartTitle, cartTitleText);

            if (!cartTitleText.equals(expectedCartTitle)) {
                System.out.println("Error: Se esperaba el título \"" + expectedCartTitle + "\", pero se obtuvo: \"" + cartTitleText + "\"");
            }
        } catch (NoSuchWindowException e) {
            System.out.println("Error: La ventana del navegador se ha cerrado.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Se ha producido un error al validar el título del carrito: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
