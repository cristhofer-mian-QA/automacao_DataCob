import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class HH_Vincular_Cadastro_Recibo {
	WebDriver driver;
	Variáveis_H_Cadastrar_Recibo recibo;
	Variaveis_A2_Cadastro_Grupo_Cliente_Fase GCF;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;

	
	
	@Test
	public void A_Vincular_Configuração_Recibo() throws InterruptedException {
			Thread.sleep(7000);		
		driver = new FirefoxDriver();
		GCF = new Variaveis_A2_Cadastro_Grupo_Cliente_Fase(driver);
		recibo = new Variáveis_H_Cadastrar_Recibo(driver);
		login = new Variáveis_Login (driver);
		menu = new _Page_Menu_Superior (driver);
		subMenu = new _Page_Menu_Parametros (driver);

		
		login.login();
		menu.clicarParametros();
		menu.clicarVisualizarParâmetros();
		recibo.esperarCssSelector("h1.titulo");
		subMenu.clicarMenuOpções();
		subMenu.clicarSubMenuRecibo();
		recibo.esperarXPATH("//*[@id=\'gridRecibo\']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
	
		WebElement tabelaRecibo = recibo.tabelaRecibo("//*[@id='gridRecibo']/table/tbody/tr[2]/td/div/div/table");
		int numLinha = recibo.linhaRecibo( recibo.descriçãoRecibo,tabelaRecibo);
		WebElement linhaCorreta = tabelaRecibo.findElement(By.xpath(".//tr[" + numLinha + "]/td[2]"));
		linhaCorreta.click();	
			
		recibo.clicarVincular();
		recibo.esperarId("idSelectIdGrupo");
		recibo.selecionarGrupo("idSelectIdGrupo", GCF.nomeGrupo);
		recibo.selecionarCliente("idSelectIdCliente", GCF.nomeResumido);
		recibo.clicarCheckBox("#treeGeral > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)");
			Thread.sleep(2000);
		recibo.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		recibo.esperarCssSelector(".textoAlerta");
		String mensagemConfirm= recibo.mensagem(".textoAlerta");
		recibo.validarMensagem("Adicionado vinculo ao parametro - " + recibo.descriçãoRecibo + " : \n    Grupo - " + GCF.nomeGrupo, mensagemConfirm);
		recibo.clicarOkcss(".caixa_bottom > a:nth-child(1)");
		
		WebElement tabRecibo = recibo.tabelaRecibo();
		int idLinha = recibo.numeroLinha(recibo.descriçãoRecibo ,tabRecibo);
		
		WebElement descrição = tabRecibo.findElement(By.xpath(".//tr[" +  idLinha + "]/td[1]"));
		String id = descrição.getText();
			Thread.sleep(2000);
		String validar = recibo.validarVinculo(GCF.nomeGrupo, id);
		Assert.assertEquals("ok", validar);
		driver.quit();
	}
} 

