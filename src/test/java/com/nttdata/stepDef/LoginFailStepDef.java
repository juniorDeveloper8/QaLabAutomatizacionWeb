package com.nttdata.stepDef;

import com.nttdata.steps.LoginFail;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class LoginFailStepDef {

    private WebDriver driver;


    @Given("estoy en la página ingreso con usuario {string} y clave {string}")
    public void estoyEnLaPáginaIngresoConUsuarioYClave(String usuario, String clave) {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion");

        LoginFail loginFail = new LoginFail(driver);
        loginFail.UserName(usuario);
        loginFail.Password(clave);
        loginFail.singIn();
        screenShot();
    }
}
