package framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static Driver instance            = null;
    private ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
    //private ThreadLocal<String> sessionId    = new ThreadLocal<String>();
    private static final String arquitecturaOS      = System.getProperty("os.arch");

    public static Driver getInstance() {
        if ( instance == null ) {
            instance = new Driver();
        }

        return instance;

    }

    /**
     * @param navegador  es el nombre del navegador a instanciar
     * @param preferencias son las preferencias con las
     * @throws Exception
     */
    public final void setDriver(String navegador,
                                Map<String, Object>... preferencias)
            throws Exception {

        if(navegador.compareTo("firefox" ) == 0) {
            if(arquitecturaOS.contains("64")){
                WebDriverManager.firefoxdriver().arch64();
            }else{
                WebDriverManager.firefoxdriver().arch32();
            }
            WebDriverManager.firefoxdriver().setup();
            Driver.getInstance().getThreadDriver().set(new FirefoxDriver());

        }else {
            if(navegador.compareTo("chrome" ) == 0) {

                WebDriverManager.chromedriver().arch32();
                WebDriverManager.chromedriver().setup();
                Driver.getInstance().getThreadDriver().set(new ChromeDriver());

            }else {
                if(navegador.compareTo("iexplorer" ) == 0) {
                    if(arquitecturaOS.contains("64")){
                        WebDriverManager.iedriver().arch64();
                        WebDriverManager.iedriver().browserVersion("3.11.1");
                    }else{
                        WebDriverManager.iedriver().arch32();
                    }

                    WebDriverManager.iedriver().setup();
                    Driver.getInstance().getThreadDriver().set(new InternetExplorerDriver());

                }else {
                    if(navegador.compareTo("edge")==0) {

                        WebDriverManager.edgedriver().setup();
                        Driver.getInstance().getThreadDriver().set(new EdgeDriver());

                    }else {
                        if(navegador.compareTo("opera")==0) {
                            if(arquitecturaOS.contains("64")){
                                WebDriverManager.operadriver().arch64();
                            }else{
                                WebDriverManager.operadriver().arch32();
                            }
                            WebDriverManager.operadriver().setup();
                            OperaOptions options = new OperaOptions();
                            options.setBinary("C:\\Users\\Usuario\\AppData\\Local\\Programs\\Opera\\66.0.3515.44\\opera.exe");
                            Driver.getInstance().getThreadDriver().set(new OperaDriver(options));
                        }
                    }
                }
            }
        }

        // se puede setear un implicit wait si se desea y este es buena idea declaralo como atributo
        Driver.getInstance().getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //getDriver().manage().timeouts().pageLoadTimeout(20,TimeUnit.)
        Driver.getInstance().getDriver().manage().window().maximize();

    }


    /**
     * @return devuelve el driver del hilo correspondiente.
     */
    public WebDriver getDriver() {
        return webDriver.get();
    }
    public ThreadLocal<WebDriver> getThreadDriver(){
        return webDriver;
    }


    /**
     *  método que sirve para cerrar las ventanas del navegador.
     */

    public void closeDriver() {
        if (getDriver() != null){
            getDriver().quit();
        }

    }

}
