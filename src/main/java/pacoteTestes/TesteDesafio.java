package pacoteTestes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteDesafio {
    private WebDriver driver;
    private DSL dsl;
    private CampoTreinamentoPage page;

    @Before
    public void inicializa() {
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir")
                + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
        page = new CampoTreinamentoPage(driver);
    }

    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void deveRealizarCadastroComSucesso() {
        page.setNome("Mathews");
        page.setSobrenome("Evangelista");
        page.setSexoMasculino();
        page.setComidaPizza();
        page.setComidaVegetariano();
        page.setEscolaridade("Superior");
        page.setEsporte("Futebol");
        page.cadastrar();

        Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado"));
        Assert.assertTrue(page.obterNomeCadastro().endsWith("Mathews"));
        Assert.assertTrue(page.obterSobreomeCadastro().endsWith("Evangelista"));
        Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
        Assert.assertEquals("Esportes: Futebol", page.obterEsporteCadastro());
        Assert.assertEquals("Comida: Pizza Vegetariano", page.obterComidaCadastro());
        Assert.assertEquals("Escolaridade: superior", page.obterEscolaridadeCadastro());


//        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
//        Select combo = new Select(element);
//        combo.selectByVisibleText("Superior");
//        element = driver.findElement(By.id("elementosForm:esportes"));
//        combo = new Select(element);
//        combo.selectByVisibleText("Futebol");
//        combo.selectByVisibleText("Corrida");

//        new Select(driver.findElement(By.id("elementosForm:escolaridade")))
//                .selectByVisibleText("Superior");

//        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
//        Select combo = new Select(element);
//        // Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
//        combo.selectByVisibleText("Futebol");
//        combo.selectByVisibleText("Corrida");
//
//        driver.findElement(By.id("elementosForm:cadastrar")).click();

    }

    @Test
    public void desafiii() {
        page.setEsporte("Futebol", "Corrida");
    }

    @Test
    public void desafioValidarNomeObrigatorio() {
        page.cadastrar();
        Assert.assertEquals("Nome eh obrigatorio",
                dsl.alertaObterTextoEAceitar());

//        driver.findElement(By.id("elementosForm:cadastrar")).click();
//        Alert alerta = driver.switchTo().alert();
//        String msg = alerta.getText();
//        Assert.assertEquals(msg, "Nome eh obrigatorio");
//        alerta.accept();
    }

    @Test
    public void desafioValidarSobrenomeObrigatorio() {
        page.setNome("Matheos");
        page.cadastrar();
        Assert.assertEquals("Sobrenome eh obrigatorio",
                dsl.alertaObterTextoEAceitar());

//        driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheos");
//        driver.findElement(By.id("elementosForm:cadastrar")).click();
//        Alert alerta = driver.switchTo().alert();
//        String msg = alerta.getText();
//        alerta.accept();
    }


    @Test
    public void desafioValidarSexoObrigatorio() {
        page.setNome("Matheos");
        page.setSobrenome("Gostoso");
        page.cadastrar();
        Assert.assertEquals("Sexo eh obrigatorio",
                dsl.alertaObterTextoEAceitar());

//        driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheos");
//        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gostoso");
//
//        driver.findElement(By.id("elementosForm:cadastrar")).click();
//        Alert alerta = driver.switchTo().alert();
//        String msg = alerta.getText();
//        Assert.assertEquals(msg, "Sexo eh obrigatorio");
//        alerta.accept();
    }

    @Test
    public void desafioValidarVegetariano() {
        page.setNome("Matheos");
        page.setSobrenome("Gostoso");
        page.setSexoMasculino();
        page.setComidaVegetariano();
        page.setComidaCarne();
        page.cadastrar();
        Assert.assertEquals("Tem certeza que voce eh vegetariano?",
                dsl.alertaObterTextoEAceitar());

//        driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheos");
//        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gostoso");
//        driver.findElement(By.id("elementosForm:sexo:0")).click();
//
//        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
//        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
//
//        driver.findElement(By.id("elementosForm:cadastrar")).click();
//        Alert alerta = driver.switchTo().alert();
//        String msg = alerta.getText();
//        Assert.assertEquals(msg, "Tem certeza que voce eh vegetariano?");
//        alerta.accept();
    }

    @Test
    public void desafioValidarEsportista() {
        page.setNome("Matheos");
        page.setSobrenome("Gostoso");
        page.setSexoFeminino();
        page.setComidaVegetariano();
        page.setEsporte("Corrida", "O que eh esporte?");
        page.cadastrar();
        Assert.assertEquals("Voce faz esporte ou nao?",
                dsl.alertaObterTextoEAceitar());


//        driver.findElement(By.id("elementosForm:nome")).sendKeys("Matheos");
//        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Gostoso");
//        driver.findElement(By.id("elementosForm:sexo:0")).click();
//
//        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
//
//        Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
//        combo.selectByVisibleText("Corrida");
//        combo.selectByVisibleText("O que eh esporte?");
//
//        driver.findElement(By.id("elementosForm:cadastrar")).click();
//        Alert alerta = driver.switchTo().alert();
//        String msg = alerta.getText();
//        Assert.assertEquals(msg, "Voce faz esporte ou nao?");
//        alerta.accept();
//        driver.quit();
    }


}