import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class kk_Vincular_Custas_Cliente {
	WebDriver driver;
	Variáveis_Login login;
	Variaveis_K_Cadastrar_Custas custas;
	Variaveis_A2_Cadastro_Grupo_Cliente_Fase GCF;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;
	
	//@Test
	public void A_Vincular_Tabela_Despesas() throws InterruptedException {
		driver = new FirefoxDriver();
			Thread.sleep(7000);		
		login = new Variáveis_Login (driver);
		custas = new Variaveis_K_Cadastrar_Custas(driver);
		GCF = new Variaveis_A2_Cadastro_Grupo_Cliente_Fase (driver);
		menu = new _Page_Menu_Superior (driver);
		subMenu = new _Page_Menu_Parametros (driver);
		
		login.login();
		menu.clicarParametros();
		menu.clicarVisualizarParâmetros();
		custas.esperarXPATH("//*[@id=\'gridCalculo\']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		subMenu.clicarMenuOpções();
		subMenu.clicarSubMenuDespesas();
		custas.esperarXPATH("//*[@id=\'gridDespesas\']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		WebElement tabelaDespesas = custas.tabelaCustas("//*[@id=\'gridDespesas\']/table/tbody/tr[2]/td/div/div/table");
		int numLinha = custas.idLinhaCustas(custas.nomeTabela, tabelaDespesas);
		WebElement linhaCustas = tabelaDespesas.findElement(By.xpath(".//tr[" + numLinha + "]/td[2]"));
			Thread.sleep(600);
		linhaCustas.click();
		custas.clicarBotãoVincular("chamaVincula");
		custas.esperarId("idSelectIdGrupo");
		custas.selecionarGrupo("idSelectIdGrupo", GCF.nomeGrupo);
		custas.selecionarCliente("idSelectIdCliente", GCF.nomeResumido);
		custas.clicarCheckBox("#treeGeral > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)");
			Thread.sleep(2000);
		custas.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		custas.esperarCssSelector(".textoAlerta");
		String mensagemSucesso = custas.mensagem(".textoAlerta");
		custas.validarMensagem("Adicionado vinculo ao parametro - "+ custas.nomeTabela + " : \n    Grupo - " + GCF.nomeGrupo, mensagemSucesso);
		custas.clicarOkcss(".caixa_bottom > a:nth-child(1)");
		
		WebElement tabCusta = custas.tabelaCustas("//*[@id=\'gridDespesas\']/table/tbody/tr[2]/td/div/div/table");
		int idLinha = custas.idLinhaCustas(custas.nomeTabela ,tabCusta);
		WebElement descrição = tabCusta.findElement(By.xpath(".//tr[" +  idLinha + "]/td[1]"));
		String id = descrição.getText();
			Thread.sleep(2000);
		String validar = custas.validarVinculo(GCF.nomeGrupo, id);
		Assert.assertEquals("ok", validar);
			Thread.sleep(1000);
		driver.quit();
	}
}
