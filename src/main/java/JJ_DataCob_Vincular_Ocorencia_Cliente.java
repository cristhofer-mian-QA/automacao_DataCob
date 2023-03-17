import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class JJ_DataCob_Vincular_Ocorencia_Cliente {
	WebDriver driver;
	Variáveis_Login login;
	Variaveis_J_Cadastrar_Ocorrência_Cliente cliente;
	Variáveis_I_Cadastrar_Ocorrências_Sistema sistema;
	Variaveis_A2_Cadastro_Grupo_Cliente_Fase GCF;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;
	
	
	@Test
	public void A_Vincular_Ocorrencia_Cliente() throws InterruptedException {
			Thread.sleep(7000);		
		driver = new FirefoxDriver();
		login = new Variáveis_Login (driver);
		cliente = new Variaveis_J_Cadastrar_Ocorrência_Cliente(driver);
		sistema = new Variáveis_I_Cadastrar_Ocorrências_Sistema(driver);
		GCF = new Variaveis_A2_Cadastro_Grupo_Cliente_Fase (driver);
		menu = new _Page_Menu_Superior (driver);
		subMenu = new _Page_Menu_Parametros (driver);
		
		login.login();
		menu.clicarParametros();
		menu.clicarVisualizarParâmetros();
		cliente.esperarXPATH("/html/body/div[5]/div[3]/div[1]/div[1]/div[2]/table/tbody/tr[2]/td/div/div/table");
		subMenu.clicarMenuOpções();
		subMenu.clicarSubMenuOcorrencia();
		subMenu.clicarSubMenuHistórico();
		cliente.esperarXPATH("//*[@id=\"gridOcorrencia\"]/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		
		WebElement tabelaOcorrencia = cliente.tabelaOc("//*[@id=\"gridOcorrencia\"]/table/tbody/tr[2]/td/div/div/table");
		int numLinha = cliente.linhaOc(cliente.nomeTabelaOcorrencia,tabelaOcorrencia);
		WebElement linhaCorreta = tabelaOcorrencia.findElement(By.xpath(".//tr[" + numLinha + "]/td[2]"));
		linhaCorreta.click();	
		
		cliente.clicarVincular();
		cliente.esperarId("idSelectIdGrupo");
		cliente.selecionarGrupo("idSelectIdGrupo", GCF.nomeGrupo);
		cliente.selecionarCliente("idSelectIdCliente", GCF.nomeResumido);
		cliente.clicarCheckBox("#treeGeral > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)");
			Thread.sleep(2000);
		cliente.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		cliente.esperarCssSelector(".textoAlerta");
		String mensagemConfirm= cliente.mensagem(".textoAlerta");
		cliente.validarMensagem("Adicionado vinculo ao parametro - " + cliente.nomeTabelaOcorrencia + " : \n    Grupo - " + GCF.nomeGrupo, mensagemConfirm);
		cliente.clicarOkcss(".caixa_bottom > a:nth-child(1)");
		cliente.esperarXPATH("//*[@id=\"treeOcorrencia\"]/ul/li");
		
		WebElement tabOco = cliente.tabelaOc("//*[@id='gridOcorrencia']/table/tbody/tr[2]/td/div/div/table");
		int idLinha = cliente.idLinhaOc(cliente.nomeTabelaOcorrencia ,tabOco);
		
		WebElement descrição = tabOco.findElement(By.xpath(".//tr[" +  idLinha + "]/td[1]"));
		String id = descrição.getText();
			Thread.sleep(2000);
		String validar = cliente.validarVinculo(GCF.nomeGrupo, id);
		Assert.assertEquals("ok", validar);
			Thread.sleep(1000);
		driver.quit();
	}
}