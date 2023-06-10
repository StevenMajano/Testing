import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class pruebasUca {
    public WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //public void clickBuscarConGoogle(){
    //        WebElement buscarGooBtn;
    //        buscarGooBtn = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b"));
    //                buscarGooBtn.click();
    //                buscarGooBtn.sendKeys();
    //}


    public void IniciarSesion() {
        WebElement usario;
        usario = driver.findElement(By.cssSelector("#user-name"));
        usario.click();
        usario.sendKeys("standard_user");

        WebElement Contrasenia;
        Contrasenia = driver.findElement(By.cssSelector("#password"));
        Contrasenia.click();
        Contrasenia.sendKeys("secret_sauce");

        WebElement Iniciobtn;
        Iniciobtn = driver.findElement(By.cssSelector("#login-button"));
        Iniciobtn.click();
    }

    public void addCarrito() {
        WebElement Addbtn;
        Addbtn = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        Addbtn.click();
        Addbtn = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
        Addbtn.click();
    }

    public void outCarrito() {
        WebElement Outtbn;
        Outtbn = driver.findElement(By.cssSelector("#remove-sauce-labs-backpack"));
        Outtbn.click();
    }

    public void CarritoCheckOut() {
        WebElement compras;
        compras = driver.findElement(By.cssSelector("#shopping_cart_container > a"));
        compras.click();

        WebElement checkout;
        checkout = driver.findElement(By.cssSelector("#checkout"));
        checkout.click();
    }

    @Test
    public void test() {
        setUp();
        IniciarSesion();
        addCarrito();
        outCarrito();
        CarritoCheckOut();
    }
}