package pacoteTestes;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DSL {
    private final WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    /************ Text Field e Text Area ************/

    public void escreve(By by, String texto) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }

    public void escreve(String id_campo, String texto) {
        driver.findElement(By.id(id_campo)).clear();
        driver.findElement(By.id(id_campo)).sendKeys(texto);
    }


    public String obterValorCampo(String id_campo) {
        return driver.findElement(By.id(id_campo)).getAttribute("value");
    }

    /************ Radio e Check ************/

    public void clickarRadioButton(String id) {
        driver.findElement(By.id(id)).click();
    }

    public boolean isRadioMarcado(String id) {
        return driver.findElement(By.id(id)).isSelected();
    }

    public void clickarCheck(String id) {
        driver.findElement(By.id(id)).click();
    }

    public boolean isCheckboxMarcado(String id) {
        return driver.findElement(By.id(id)).isSelected();
    }

    /************ Combo ************/

    public void selecionarCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void deselecionarCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }

    public String obterValorDoCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public List<String> obterValoresComboSelecionados(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();

        List<String> valoresNome = new ArrayList<>();
        for (WebElement opcoes : allSelectedOptions) {
            valoresNome.add(opcoes.getText());
        }
        return valoresNome;
    }

    public int obterQtdeOpcoes(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public int obterQtdeSelecionadosCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();

        return allSelectedOptions.size();
    }


    public boolean verificarOpcaoSelecCombo(String id, String opcao) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getAllSelectedOptions();
        for (WebElement opcoes : options) {
            if (opcoes.getText().equals(opcao)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarOpcaoCombo(String id, String opcao) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for (WebElement opcoes : options) {
            if (opcoes.getText().equals(opcao)) {
                return true;
            }
        }
        return false;
    }

    /************ Botao ************/

    public void clicarBotao(String id) {
        driver.findElement(By.id(id)).click();
    }

    /************ Link ************/

    public void clicarLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    /************ Texto ************/

    public String obterTexto(By by) {
        return driver.findElement(by).getText();
    }

    public String obterTexto(String id) {
        return obterTexto(By.id(id));
    }

    /************ Alerta ************/

    public String alertaObterTexto() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public String alertaObterTextoEAceitar() {
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;

    }

    public String alertaObterTextoENegar() {
        Alert alert = driver.switchTo().alert();
        String texto = alert.getText();
        alert.dismiss();
        return texto;
    }

    public void alertaEscrever(String texto) {
        Alert alerta = driver.switchTo().alert();
        alerta.sendKeys(texto);
        alerta.accept();
    }

    /************ Frames e Janelas ************/

    public void entrarFrame(String id) {
        driver.switchTo().frame(id);
    }

    public void sairFrame() {
        driver.switchTo().defaultContent();
    }

    public void mudarJanela(String id) {
        driver.switchTo().window(id);
    }


    /************ JS ************/

    public Object executarJS(String cmd, Object... param) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(cmd, param);
    }

}