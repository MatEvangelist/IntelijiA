package pacoteTestes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {

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
    public void teste() {
        //WebDriver webDriver = new ChromeDriver();
        driver.get("http://www.google.com");
        // webDriver.manage().window().maximize();
                // .setSize(new Dimension(1200, 765));
                // .setPosition(new Point(0, 0));
        // System.out.println(webDriver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
        // Assert.assertNotEquals("Yahoo", webDriver.getTitle());
        driver.quit();
    }
}
