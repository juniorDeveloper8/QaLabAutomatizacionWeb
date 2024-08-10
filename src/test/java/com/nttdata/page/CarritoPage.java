package com.nttdata.page;

import org.openqa.selenium.By;

public class CarritoPage {

    public static By firstProductThumbnail = By.cssSelector(".js-product .thumbnail-top a");
    public static By quantityInput = By.id("quantity_wanted");
    public static By addToCartButton = By.cssSelector("button[data-button-action='add-to-cart']");

    //popup
    public static By confirmationPopup = By.id("blockcart-modal");
    public static By confirmationMessage = By.cssSelector("#blockcart-modal .modal-header .modal-title");

    // Precios
    public static By cartProductsCount = By.cssSelector(".cart-products-count");
    public static By subtotalValue = By.cssSelector(".subtotal.value");
    public static By totalExclTax = By.cssSelector("p:contains('Total (impuestos excluidos)') + span");
    public static By totalInclTax = By.cssSelector(".product-total .value");
    public static By taxValue = By.cssSelector(".product-tax .value");

    //bnt compra

    public static By finalizarCompraButton = By.xpath("//a[contains(text(), 'Finalizar compra')]");

}

