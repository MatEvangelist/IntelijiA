package pacoteTestes;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TesteCampoTreinamento {
    private WebDriver driver;
    private DSL dsl;

    //todo teste executará esse comando antes
    @Before
    public void inicializa() {
        driver = new ChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir")
                + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
    }

    // todo teste executará esse comando depois
    @After
    public void finaliza() {
        driver.quit();
    }

    @Test
    public void testeTextField() {
        dsl.escreve("elementosForm:nome", "Teste de Escrita");
        Assert.assertEquals("Teste de Escrita com erro",
                dsl.obterValorCampo("elementosForm:nome"));

//        driver.findElement(By.id("elementosForm:nome"))
//                .sendKeys("Teste de Escrita");
//        Assert.assertEquals("Teste de Escrita com erro",
//                driver.findElement(By.id("elementosForm:nome"))
//                        .getAttribute("value"));
    }

    @Test
    public void deveInteragirComTesteArea() {
        dsl.escreve("elementosForm:sugestoes", "Teste");
        Assert.assertEquals("Teste",
                dsl.obterValorCampo("elementosForm:sugestoes"));

        // driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste");
//        driver.findElement(By.tagName("textarea")).sendKeys("Teste");
//        Assert.assertEquals("Teste",
//                driver.findElement(By.id("elementosForm:sugestoes"))
//                        .getAttribute("value"));
    }

    @Test
    public void deveInteragirComRadioButton() {
        dsl.clickarRadioButton("elementosForm:sexo:0");
        Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
    }


    @Test
    public void deveInteragirComCheckbox() {
        dsl.clickarCheck("elementosForm:comidaFavorita:2");
        Assert.assertTrue(dsl.isCheckboxMarcado("elementosForm:comidaFavorita:2"));
    }

    @Test
    public void deveInteragirComCombo() {
//        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
//        Select combo = new Select(element);
//        //combo.selectByIndex(2); (começa do 0)
//        //combo.selectByValue("superior"); (value = xxx)
//        combo.selectByVisibleText("2o grau completo");//<option> xxx </option>

        dsl.selecionarCombo("elementosForm:escolaridade","2o grau completo");
        Assert.assertEquals("2o grau completo",
                dsl.obterValorDoCombo("elementosForm:escolaridade"));
    }

    @Test
    public void deveVerificarValoresCombo() {
        Assert.assertEquals(8,
                dsl.obterQtdeOpcoes("elementosForm:escolaridade"));

//        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
//        Select combo = new Select(element);
//        List<WebElement> options = combo.getOptions();
//        Assert.assertEquals(8, options.size());
//
//        boolean encontrou = false;
//        for (WebElement option : options) {
//            if (option.getText().equals("Mestrado")) {
//                encontrou = true;
//                break;
//            }
//        }
//        Assert.assertTrue(encontrou);
    }

    @Test
    public void deveVerificarValoresComboMultiplo() {
        dsl.selecionarCombo("elementosForm:esportes", "Natacao");
        dsl.selecionarCombo("elementosForm:esportes", "Corrida");
        dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
        Assert.assertEquals(3,
                dsl.obterQtdeSelecionadosCombo("elementosForm:esportes"));

        Assert.assertTrue(dsl.verificarOpcaoSelecCombo("elementosForm:esportes",
                "Corrida"));

        Assert.assertFalse(dsl.verificarOpcaoSelecCombo("elementosForm:esportes",
                "Futebol"));

        Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:esportes",
                "Futebol"));


        dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
        Assert.assertEquals(2,
                dsl.obterQtdeSelecionadosCombo("elementosForm:esportes"));

        System.out.println(dsl.obterValoresComboSelecionados("elementosForm:esportes"));
    }

    @Test
    public void deveInteragirComBotoes() {
        dsl.clicarBotao("buttonSimple");

        WebElement botao = driver.findElement(By.id("buttonSimple"));
        Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
    }

    @Test
    @Ignore
    public void deveInteragirComLinksIgnorado() {
        driver.findElement(By.linkText("Voltar")).click();
        //Assert.fail();
    }


    @Test
    public void deveInteragirComLinks() {
        dsl.clicarLink("Voltar");

        driver.findElement(By.linkText("Voltar")).click();
        Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
    }

    @Test
    public void deveBuscarTextos() {
        // System.out.println(driver.findElement(By.tagName("body")).getText());

//        Assert.assertTrue(driver.findElement(By.tagName("body"))
//                .getText().contains("Campo de Treinamento"));
//        pega todos os textos presentes na página

        Assert.assertEquals("Campo de Treinamento",
                dsl.obterTexto(By.tagName("h3")));

//        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
//                driver.findElement(By.tagName("span")).getText());
//        pega a primeira ocorrência da classe na pagina, tentar especificar

        Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
               dsl.obterTexto(By.className("facilAchar")));
    }

    @Test
    public void testeFieldDuplo() {
        dsl.escreve("elementosForm:nome", "Mathews");
        Assert.assertEquals("Mathews", dsl.obterValorCampo("elementosForm:nome"));

        dsl.escreve("elementosForm:nome", "Evangelista");
        Assert.assertEquals("Evangelista", dsl.obterValorCampo("elementosForm:nome"));
    }

    @Test
    public void testJavascript() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("alert('Testando js via selenium')");
        js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via js'");
        js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");

        WebElement element = driver.findElement(By.id("elementosForm:nome"));
        js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");


    }


}