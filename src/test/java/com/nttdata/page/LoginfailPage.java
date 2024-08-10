package com.nttdata.page;

import org.openqa.selenium.By;

public class LoginfailPage {

    public static By email = By.id("field-email");
    public static By clave = By.id("field-password");
    public static By loginBtn = By.id("submit-login");

    // Selector para el mensaje de error
    public static By errorMessage = By.cssSelector(".help-block .alert.alert-danger");
}
