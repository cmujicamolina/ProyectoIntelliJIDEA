package pages;

import framework.PadrePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PadrePage {

    @FindBy(linkText = "Contact us")
    WebElement btnContactUs;

    public MainPage(WebDriver driver) throws InterruptedException{
        super(driver);
    }

    public void ingresarFormularioContactUs(){
        clickearElemento(btnContactUs);
    }
}
