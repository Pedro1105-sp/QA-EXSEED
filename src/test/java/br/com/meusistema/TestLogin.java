package br.com.meusistema;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestLogin {

    @Test
    public void testLogin() {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\pedro.candido\\Desktop\\PEDRO\\CONFIGURACOES\\chromedriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://blazedemo.com/login");

        WebElement textoEmail = driver.findElement(By.id("email"));

        textoEmail.sendKeys("asgaleote@gmail.com");

        WebElement textoSenha = driver.findElement(By.id("password"));

        textoSenha.sendKeys("asenha1");

        List<WebElement> ListaBotoes = driver.findElements(By.tagName("button"));

        for (WebElement botao : ListaBotoes){
            if (botao.getAttribute("type").equals("submit")){
                botao.submit();
            }
        }

        String urlPostLoginSucesso = driver.getCurrentUrl();

        Assertions.assertEquals("https://blazedemo.com/home", urlPostLoginSucesso);


    }

}
