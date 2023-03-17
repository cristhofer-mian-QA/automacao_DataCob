import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EE_DataCob_Vincular_Envio_Boleto {

	WebDriver driver;
	Variaveis_1_Inserir_Financiado dsl;
	Variaveis_E_Cadastrar_Boleto_Envio boleto;
	Variaveis_A2_Cadastro_Grupo_Cliente_Fase GCF;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;

	@Test
	public void A_Vincular_Envio_Boleto() throws InterruptedException {
		Thread.sleep(7000);		
	GCF = new Variaveis_A2_Cadastro_Grupo_Cliente_Fase (driver);
	Thread.sleep(7000);		
	driver = new FirefoxDriver();
	login = new Variáveis_Login (driver);
	boleto = new Variaveis_E_Cadastrar_Boleto_Envio (driver);
	menu = new _Page_Menu_Superior (driver);
	subMenu = new _Page_Menu_Parametros (driver);
	
	login.login();
	menu.clicarParametros();
	menu.clicarVisualizarParâmetros();
	boleto.esperarCssSelector("h1.titulo");
	subMenu.clicarMenuOpções();
	subMenu.clicarSubMenuBoleto();
	subMenu.clicarSubMenuEnvio();
	boleto.esperarXPATH("//*[@id='gridBoleto']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
	
	boleto.tabelaBoleto(boleto.descrição);
	boleto.clicarVincular();
	boleto.esperarId("idSelectIdGrupo");
		Thread.sleep(1000);
	boleto.selecionarGrupo(GCF.nomeGrupo);
	boleto.selecionarCliente(GCF.nomeResumido);
	boleto.esperarCssSelector("#treeGeral > ul > li > a.myCheckbox");
	boleto.clicarCheckBox();
	boleto.clicarOkcss("#msgBoxContent > div > div.caixa_bottom > a.btnPadrao.btnVerde");
	boleto.esperarCssSelector(".textoAlerta");
	String mensagemConfirmacao = boleto.mensagem(".textoAlerta");
	boleto.validarMensagem("Adicionado vinculo ao parametro - " + boleto.descrição + " : \n    Grupo - " + GCF.nomeGrupo, mensagemConfirmacao);
	boleto.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	
	WebElement tabela1 = driver.findElement(By.xpath("//*[@id=\"gridBoleto\"]/table/tbody/tr[2]/td/div/div/table"));
	int idLinha1 = boleto.numeroLinha(boleto.descrição, tabela1);

	WebElement descrição = tabela1.findElement(By.xpath(".//tr[" + idLinha1 + "]/td[1]"));
	String id = descrição.getText();
	Thread.sleep(3000);

	String validar = boleto.validarVinculo(GCF.nomeGrupo, id);
	Assert.assertEquals("ok", validar);
	
	driver.quit();
	}
	
}
