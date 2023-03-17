
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class GG_Vincular_Modelo_Carta_Boleto {
	WebDriver driver;
	Variaveis_G_Cadastrar_Modelos_Cartas modelo;
	Variaveis_A2_Cadastro_Grupo_Cliente_Fase GCF;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;
	
	
			
	@Test
	public void A_Vincular_Modelo_Boleto() throws InterruptedException {
			Thread.sleep(7000);		
		driver = new FirefoxDriver();
		modelo = new Variaveis_G_Cadastrar_Modelos_Cartas (driver);
		GCF = new Variaveis_A2_Cadastro_Grupo_Cliente_Fase(driver);
		login = new Variáveis_Login (driver);
		menu = new _Page_Menu_Superior (driver);
		subMenu = new _Page_Menu_Parametros (driver);

		login.login();
		menu.clicarParametros();
		menu.clicarVisualizarParâmetros();
		modelo.esperarCssSelector("h1.titulo");
		subMenu.clicarMenuOpções();
		subMenu.clicarSubMenuBoleto();
		subMenu.clicarSubMenuBoletoModelo();
		modelo.esperarId("btnCadastrar");
		
		WebElement tabelaBoleto = modelo.tabelaModeloBoleto();
		int idlinha = modelo.idLinha(modelo.descParametro, tabelaBoleto);
		WebElement tabelaVerifica = tabelaBoleto.findElement(By.xpath(".//tr[" +  idlinha + "]/td[2]"));
		tabelaVerifica.click();
		
		modelo.clicarVincular();
		modelo.esperarId("idSelectIdGrupo");
		modelo.selecionarGrupo(GCF.nomeGrupo);
		modelo.selecionarCliente(GCF.nomeResumido);
		modelo.esperarCssSelector("#treeGeral > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)");
		modelo.clicarCheckBox();
		modelo.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		modelo.esperarCssSelector(".textoAlerta");
		String mensagemConfirm = modelo.mensagem(".textoAlerta");
		modelo.validarMensagem("Adicionado vinculo ao parametro - " + modelo.descParametro + " : \n    Grupo - " + GCF.nomeGrupo, mensagemConfirm);
		modelo.clicarOkcss(".caixa_bottom > a:nth-child(1)");
		driver.quit();
	}
}
