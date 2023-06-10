package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PruebasUca {

    public WebDriver driver;

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.get("https://www.saucedemo.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void clickBuscarGoogle(){
        WebElement buscarBtn;
        buscarBtn = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b"));
        buscarBtn.click();

    }

    public void iniciarSesion(){
        WebElement loginBtn;
       loginBtn= driver.findElement(By.cssSelector("#login-button"));
       loginBtn.sendKeys("standard_user");
       loginBtn.sendKeys("secret_sauce");
       loginBtn.click();

    }

    public void anadirACarrito(){
        WebElement article1;
        WebElement article2;
        WebElement carrito;
        carrito = driver.findElement(By.cssSelector("#shopping_cart_container"));
        article1 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
        article2 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bike-light"));
    }

    public void removerArticulo(){
        WebElement article1;
        article1 = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack"));
    }

    public void  checkout(){
        WebElement checkout;
        WebElement continuarComprar;
        continuarComprar = driver.findElement(By.cssSelector("#continue"));
        checkout = driver.findElement(By.cssSelector("#checkout"));
    }
    @Test
    public void test(){
        setUp();
        iniciarSesion();
        anadirACarrito();
        removerArticulo();
        checkout();

       // driver.quit();
    }
}
