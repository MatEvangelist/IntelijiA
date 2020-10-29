package pacoteTestes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFramesEJanelas {

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
    public void deveInteragirComFrames() {
        dsl.entrarFrame("frame1");
        dsl.clicarBotao("frameButton");
        String msg = dsl.alertaObterTextoEAceitar();
        Assert.assertEquals("Frame OK!", msg);
        dsl.sairFrame();
        dsl.escreve("elementosForm:nome", msg);

        //driver.switchTo().frame("frame1");
        // muda o foco pra caixinha de mensagem (frame)
        //driver.findElement(By.id("frameButton")).click();

//        Alert alert = driver.switchTo().alert();
//        String msg = alert.getText();
//        Assert.assertEquals("Frame OK!", msg);
//        alert.accept();
//
//        driver.switchTo().defaultContent();
//        // traz o foco pra pagina denovo
//        driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
    }

    @Test
    public void deveInteragirComJanelas() {
        dsl.clicarBotao("buttonPopUpEasy");
        dsl.mudarJanela("Popup");
        dsl.escreve(By.tagName("textarea"), "Deu certo?");
        driver.close();
        dsl.mudarJanela("");
        dsl.escreve(By.tagName("textarea"), "e agora?");



//        // valor que indentifica a janela na função
//        driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
//        driver.close();
//        driver.switchTo().window("");
//        // como esse janela não é a primeira não tem
//        driver.findElement(By.tagName("textarea")).sendKeys("e agora?");
    }

    @Test
    public void deveInteragirComJanelasSemTitulo() {
        dsl.clicarBotao("buttonPopUpHard");
        dsl.mudarJanela((String)driver.getWindowHandles().toArray()[1]);
        dsl.escreve(By.tagName("textarea"), "Deu certo?");
        dsl.mudarJanela((String)driver.getWindowHandles().toArray()[0]);
        dsl.escreve(By.tagName("textarea"), "e agora?");

//        System.out.println(driver.getWindowHandle());
//        // pega o id da primeira janela
//        System.out.println(driver.getWindowHandles());
//        // pega o id de todas as janelas

//        driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
//        // joga os ids em um array e pega o segundo valor
//        driver.findElement(By.tagName("textarea")).sendKeys("Deu Certo?");
//
//        driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
//        driver.findElement(By.tagName("textarea")).sendKeys("E agora?");
    }

    @Test
    public void deveInterarirComFrameEscondido() {
        WebElement frame = driver.findElement(By.id("frame2"));
        dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
        dsl.entrarFrame("frame2");
        dsl.clickarRadioButton("frameButton");
        String msg = dsl.alertaObterTextoEAceitar();
        Assert.assertEquals("Frame OK!", msg);
    }
}
