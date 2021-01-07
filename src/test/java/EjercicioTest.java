import framework.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.MainPage;
import org.assertj.core.api.Assertions;
import pages.PrincipalPage;

public class EjercicioTest {

    @BeforeMethod
    public void setUp() throws Exception {
        Driver.getInstance().setDriver("chrome");
        Driver.getInstance().getDriver().get("http://automationpractice.com/index.php");
    }

    @Test
    public void llenarCuestionario() throws InterruptedException{
        WebDriver driver            = Driver.getInstance().getDriver();
        MainPage mainPage           = new MainPage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        mainPage.ingresarFormularioContactUs();
        String mensaje = contactUsPage.llenarFormulario();
        Assertions.assertThat(mensaje).isEqualTo("Your message has been successfully sent to our team.");

        /*PrincipalPage principalPage = new PrincipalPage(driver);
        principalPage.busquedaItem();*/

        

    }

    @AfterMethod
    public void tearDown(){
        Driver.getInstance().closeDriver();
    }
}
