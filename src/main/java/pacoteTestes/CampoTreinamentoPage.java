package pacoteTestes;

import org.openqa.selenium.WebDriver;

public class CampoTreinamentoPage {

    private final DSL dsl;

    public CampoTreinamentoPage(WebDriver driver) {
        dsl = new DSL(driver);
    }
    public void setNome(String nome) {
        dsl.escreve("elementosForm:nome", nome);
    }

    public void setSobrenome(String sobrenome) {
        dsl.escreve("elementosForm:sobrenome",sobrenome);
    }

    public void setSexoMasculino() {
        dsl.clickarRadioButton("elementosForm:sexo:0");
    }

    public void setSexoFeminino() {
        dsl.clickarRadioButton("elementosForm:sexo:1");
    }

    public void setComidaCarne(){
        dsl.clickarRadioButton("elementosForm:comidaFavorita:0");
    }

    public void setComidaPizza(){
        dsl.clickarRadioButton("elementosForm:comidaFavorita:2");
    }

    public void setComidaVegetariano(){
        dsl.clickarRadioButton("elementosForm:comidaFavorita:3");
    }

    public void setEscolaridade(String valor) {
        dsl.selecionarCombo("elementosForm:escolaridade", valor);
    }

    public void setEsporte(String... valores) {
        for (String valor : valores)
            dsl.selecionarCombo("elementosForm:esportes", valor);
    }


    public void cadastrar() {
        dsl.clicarBotao("elementosForm:cadastrar");
    }

    public String obterResultadoCadastro() {
        return dsl.obterTexto("resultado");
    }

    public String obterNomeCadastro() {
        return dsl.obterTexto("descNome");
    }

    public String obterSobreomeCadastro() {
        return dsl.obterTexto("descSobrenom");
    }

    public String obterSexoCadastro() {
        return dsl.obterTexto("descSexo");
    }

    public String obterComidaCadastro() {
        return dsl.obterTexto("descComida");
    }

    public String obterEscolaridadeCadastro() {
        return dsl.obterTexto("descEscolaridade");
    }

    public String obterEsporteCadastro() {
        return dsl.obterTexto("descEsportes");
    }


}
