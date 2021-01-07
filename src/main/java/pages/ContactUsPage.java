package pages;

import framework.PadrePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage extends PadrePage {
    /*@FindBy(linkText = "Contact us")
    WebElement btnContactUs;
    */

    @FindBy(className = "page-subheading")
    WebElement lblHeader;

    //Drop Down
    @FindBy(xpath = "//select[@id='id_contact']/option[text()='Customer service']")
    WebElement optWebmasterSH;

    //Casilla texto
    @FindBy(id = "email")
    WebElement txtEmail;

    //Casilla texto
    @FindBy(id = "id_order")
    WebElement txtOrderReference;

    @FindBy(id = "fileUpload")
    WebElement inputSubirArchivo;

    @FindBy(id = "message")
    WebElement txtMessage;

    @FindBy(id = "submitMessage")
    WebElement btnSend;

    @FindBy(className = "alert-success")
    WebElement messageAlertSuccess;

    public ContactUsPage(WebDriver driver) throws InterruptedException {
        super(driver);
    }

    public String llenarFormulario(){
        String mensaje ="";
        //clickearElemento();

        wait.until(ExpectedConditions.visibilityOf(lblHeader));
        clickearElemento(optWebmasterSH);
        enviarTexto(txtEmail,"aprendiendoselenium@gmail.com");
        enviarTexto(txtOrderReference,"12345678-2020");
        enviarTexto(txtMessage, "Mensaje de prueba");
        String ruta = System.getProperty("user.dir") + "\\src\\main\\resources\\Prueba.txt";
        enviarTexto(inputSubirArchivo, ruta);
        clickearElemento(btnSend);

        mensaje =  obtenerTextoElemento(messageAlertSuccess);

        return mensaje;

    }

}
