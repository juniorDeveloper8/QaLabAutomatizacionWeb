@AllTest
Feature: Product - Store

  @LoginFail
  Scenario: Inicio de sesion invalido
    Given estoy en la página ingreso con usuario "failtest@gmail.com" y clave "asdfsadfasdf"