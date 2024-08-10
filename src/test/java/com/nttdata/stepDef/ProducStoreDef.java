package com.nttdata.stepDef;

import com.nttdata.steps.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProducStoreDef {

    private WebDriver driver;

    private ClothesStep clothesStep(WebDriver driver) {
        return new ClothesStep(driver);
    }

    private CarritoStep carritoStep(WebDriver driver) {
        return new CarritoStep(driver);
    }

    private PreciosStep preciosStep(WebDriver driver) {
        return new PreciosStep(driver);
    }

    private CompraStep compraStep(WebDriver driver) {
        return new CompraStep(driver);
    }

    @Given("estoy en la página de la tienda Y me logueo con mi usuario {string} y clave {string}")
    public void estoyEnLaPáginaDeLaTiendaYMeLogueoConMiUsuarioYClave(String usuario, String clave) {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion");

        LoginStep loginStep = new LoginStep(driver);
        loginStep.UserName(usuario);
        loginStep.Password(clave);
        loginStep.singIn();
        screenShot();
    }

    @When("navego a la categoria 'Clothes' y subcategoria 'Men'")
    public void navegoALaCategoriaClothesYSubcategoriaMen() {
        ClothesStep clothesStep = new ClothesStep(driver);

        clothesStep.navigateToMenCategory();
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        CarritoStep carritoStep = new CarritoStep(driver);

        carritoStep.selectProduct();
        carritoStep.increaseQuantity(cantidad - 1);
        carritoStep.addToCart();
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agrege")
    public void validoEnElPopupLaConfirmaciónDelProductoAgrege() {
        CarritoStep carritoStep = new CarritoStep(driver);
        carritoStep.validateConfirmationPopup("Producto añadido correctamente a su carrito de compra");
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamete")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamete() {
        PreciosStep preciosStep = new PreciosStep(driver);
        preciosStep.validarPrecios();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        PreciosStep preciosStep = new PreciosStep(driver);
        preciosStep.finalizarCompra();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        CompraStep compraStep = new CompraStep(driver);
        compraStep.validarTituloCarrito();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        CompraStep compraStep = new CompraStep(driver);
        compraStep.validarPreciosFinales();
        screenShot();
    }

    @And("agrego algo {int}")
    public void agregoalgo(int cantidad) {
        CarritoStep carritoStep = new CarritoStep(driver);
        carritoStep.selectProduct();
        carritoStep.increaseQuantity(cantidad - 7);
        carritoStep.addToCart();
        screenShot();
    }
}
