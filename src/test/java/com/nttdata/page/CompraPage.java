package com.nttdata.page;

import org.openqa.selenium.By;

public class CompraPage {

    public static By totalExclTax = By.cssSelector(".cart-summary-line .label:contains('Total (impuestos excl.)') + .value");
    public static By totalInclTax = By.cssSelector(".cart-summary-line.cart-total .value");
    public static By taxValue = By.cssSelector(".cart-summary-line .value.sub");

    //titulo del carrito
    public static By cartTitle = By.cssSelector(".card.cart-container .h1");
}
