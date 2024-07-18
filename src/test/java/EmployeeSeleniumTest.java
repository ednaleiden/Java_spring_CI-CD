import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmployeeSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Configurar el sistema para utilizar el controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "D:\\proyectosJAVA\\PROYECTOS\\facture project\\facture-project\\src\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/employee/");
    }

    @AfterEach
    public void tearDown() {
        // Cerrar el navegador al finalizar cada prueba
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Verificar lista de empleados")
    public void testGetAllEmployees() {
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assertions.assertTrue(bodyText.contains("Jenny"), "No se encontró el nombre 'Jenny' en la lista de empleados.");
    }

    @Test
    @DisplayName("Verificar empleado por ID")
    public void testGetEmployeeById() {
        driver.get("http://localhost:8080/employee/1");
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assertions.assertTrue(bodyText.contains("Jenny"), "No se encontró el nombre 'Jenny' en la página del empleado con ID 1.");
    }
}
