package pacoteTestes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteDesafio2 {

    private WebDriver driver;

    @Before
    public void inicializa() {
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir")
                + "/src/main/resources/componentes.html");
    }

    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void desafioValidarNomeObrigatorio() {
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alerta = driver.switchTo().alert();
        String msg = alerta.getText();
        Assert.assertEquals(msg, "Nome eh obrigatorio");
        alerta.accept();
        driver.quit();
    }

    @Test
    public void desafioValidarSobrenomeObrigatorio() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheos");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alerta = driver.switchTo().alert();
        String msg = alerta.getText();
        Assert.assertEquals(msg, "Sobrenome eh obrigatorio");
        alerta.accept();
        driver.quit();

    }


    @Test
    public void desafioValidarSexoObrigatorio() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheos");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gostoso");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alerta = driver.switchTo().alert();
        String msg = alerta.getText();
        Assert.assertEquals(msg, "Sexo eh obrigatorio");
        alerta.accept();
        driver.quit();
    }

    @Test
    public void desafioValidarVegetariano() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheos");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gostoso");
        driver.findElement(By.id("elementosForm:sexo:0")).click();

        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alerta = driver.switchTo().alert();
        String msg = alerta.getText();
        Assert.assertEquals(msg, "Tem certeza que voce eh vegetariano?");
        alerta.accept();
        driver.quit();
    }

    @Test
    public void desafioValidarEsportista() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheos");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gostoso");
        driver.findElement(By.id("elementosForm:sexo:0")).click();

        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();

        Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("O que eh esporte?");

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alerta = driver.switchTo().alert();
        String msg = alerta.getText();
        Assert.assertEquals(msg, "Voce faz esporte ou nao?");
        alerta.accept();
        driver.quit();
    }
}
