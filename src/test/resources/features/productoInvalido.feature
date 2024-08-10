@AllTest

Feature: producto no valido

  @producto
  Scenario: Comprar producto inexistente
    Given estoy en la página de la tienda Y me logueo con mi usuario "be6323787@gmail.com" y clave "24070140Ro"
    When navego a la categoria 'Clothes' y subcategoria 'Men'
    And agrego algo 3
