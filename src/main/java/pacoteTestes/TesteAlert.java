package pacoteTestes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAlert {

    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializa() {
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir")
                + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
    }

    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void deveInteragirComAlertSimples() {
        dsl.clicarBotao("alert");
        Assert.assertEquals("Alert Simples", dsl.alertaObterTexto());

        //driver.findElement(By.id("alert")).click();
        //Alert alert = driver.switchTo().alert();
        // muda o foco para o alerta na tela que n pode ser acessado
        // ja que ele abre "uma nova pagina"
        //String texto = alert.getText();
        //Assert.assertEquals("Alert Simples", texto);
        //alert.accept();
        //driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
        //driver.quit();
    }

    @Test
    public void deveInteragirComAlertSimples2() {
        dsl.clicarBotao("alert");
        String texto = dsl.alertaObterTextoEAceitar();
        Assert.assertEquals("Alert Simples", texto);

        dsl.escreve("elementosForm:nome", texto);
    }

    @Test
    public void deveInteragirComAlertConfirm() {
        dsl.clicarBotao("confirm");
        // Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceitar());
        Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceitar());
//        Assert.assertEquals("Confirmado", alert.getText());
//        alert.accept();

        dsl.clicarBotao("confirm");
        //driver.findElement(By.id("confirm")).click();
        //alert = driver.switchTo().alert();
        Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENegar());
        Assert.assertEquals("Negado", dsl.alertaObterTextoENegar());
//        Assert.assertEquals("Negado", alert.getText());
//        alert.dismiss();

    }

    @Test
    public void deveInteragirComAlertPrompt() {
        dsl.clicarBotao("prompt");
        Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
        dsl.alertaEscrever("123");
        Assert.assertEquals("Era 123?", dsl.alertaObterTextoEAceitar());
        Assert.assertEquals(":D", dsl.alertaObterTextoEAceitar());

        dsl.escreve(By.id("elementosForm:nome"), ":DDDDD");
//        alerta.sendKeys("123");
//        alerta.accept();
//        Assert.assertEquals("Era 123?", alerta.getText());
//        alerta.accept();
//        Assert.assertEquals(":D", alerta.getText());
//        alerta.accept();
    }

}
