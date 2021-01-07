package pages;

import framework.PadrePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrincipalPage extends PadrePage {
    @FindBy(id = "search_query_top")
    WebElement lblSearch;

    @FindBy(name = "submit_search")
    WebElement btnSearch;


    @FindBy(xpath = "//option[contains(text(),'Price: Lowest first')]")
    WebElement ddlbSortby;

    public PrincipalPage(WebDriver driver) {
        super(driver);
    }

    public void busquedaItem(){
        wait.until(ExpectedConditions.visibilityOf(lblSearch));
        enviarTexto(lblSearch,"short");
        clickearElemento(btnSearch);
        wait.until(ExpectedConditions.visibilityOf(ddlbSortby));
        clickearElemento(ddlbSortby);
    };
}
