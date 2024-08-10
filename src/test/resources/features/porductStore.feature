Feature: Product - Store

  @Test
  Scenario: Validación del Precio de un Producto
    Given estoy en la página de la tienda Y me logueo con mi usuario "be6323787@gmail.com" y clave "24070140Ro"
    When navego a la categoria 'Clothes' y subcategoria 'Men'
    And agrego 2 unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agrege
    And valido en el popup que el monto total sea calculado correctamete
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito
