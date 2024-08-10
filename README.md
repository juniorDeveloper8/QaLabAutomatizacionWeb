# En DriverManage si usan Chorme tienen que cambiar el drive esta configurado para Brave

- Esto hay q cambiar para q funcione en Chorme 
```
  @Before(order = 0)
    public void setUp(){
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        // Configura las opciones para usar Brave

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe"); // Ruta del ejecutable de Brave

        // Inicializa el WebDriver con las opciones
        driver = new ChromeDriver(options);
        driver.manage();
    }
```
- por esto para q funcione
```
 @Before(order = 0)
    public void setUp(){
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
```