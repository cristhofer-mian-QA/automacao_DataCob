import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class CC_DataCob_Vincular_Parametro_Acordo {
	WebDriver driver;
	Variaveis_1_Inserir_Financiado dsl;
	Variaveis_C_Parametros_Acordo acordo;
	Variaveis_A2_Cadastro_Grupo_Cliente_Fase GCF;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;
	
	
	@Before
	public void iniciarSistema() throws InterruptedException {
		Thread.sleep(3000);	
		driver = new FirefoxDriver();
		acordo = new Variaveis_C_Parametros_Acordo (driver);
		GCF = new Variaveis_A2_Cadastro_Grupo_Cliente_Fase (driver);
		login = new Variáveis_Login (driver);
		menu = new _Page_Menu_Superior (driver);
		subMenu = new _Page_Menu_Parametros (driver);
		
		login.login();
		menu.clicarParametros();
		menu.clicarVisualizarParâmetros();
		acordo.esperarId("cadastra");
		subMenu.clicarMenuOpções();
		subMenu.clicarSubMenuCálculo();
		subMenu.clicarSubMenuAcordo();
	}
	
	
	@After
	public void fecharNavegador() {
		driver.quit();
	}
	
	
	@Test
	public void A_vincular_Grupo() throws InterruptedException{
		acordo.esperarXpath("//*[@id=\"gridAcordo\"]/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		acordo.tabelaParâmetroAcordoCriado(acordo.descricao);
		acordo.clicarVincular();
		acordo.esperarId("idSelectIdGrupo");
		Thread.sleep(1500);
		acordo.selecionarGrupo(GCF.nomeGrupo);
		acordo.selecionarCliente(GCF.nomeResumido);
		acordo.clicarCheckBox();
		acordo.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		acordo.esperarCssSelector("#msgBoxContent > div > div.Window_MsgBox > div.content_MsgBox > div > p > strong");
		String mensagemConfirmação = acordo.mensagem(".textoAlerta");
		acordo.validarMensagem("Adicionado vinculo ao parametro - " + acordo.descricao +" : " + "\n    Grupo - " + GCF.nomeGrupo, mensagemConfirmação);
		acordo.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	@Test
	public void B_Não_vincular_Grupo() throws InterruptedException {
		acordo.esperarXpath("//*[@id=\"gridAcordo\"]/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		acordo.tabelaParâmetroAcordoCriado(acordo.descricao);
		acordo.clicarVincular();
		acordo.esperarId("idSelectIdGrupo");
		acordo.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		acordo.esperarCssSelector(".textoAlerta");		
		String mensagemErro = acordo.mensagem(".textoAlerta");
		acordo.validarMensagem("Selecione um grupo!", mensagemErro);
		acordo.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	@Test
	public void C_Validar_Vinculo() throws InterruptedException {
		acordo.esperarXpath("//*[@id=\'treeAcordo\']/ul/li[1]");
		
		WebElement tabela1 = acordo.tabelaAcordo();
		int idLinha1 = acordo.obterIndiceLinha(acordo.descricao, tabela1);
		
		WebElement descrição = tabela1.findElement(By.xpath(".//tr[" +  idLinha1 + "]/td[1]"));
		String id = descrição.getText();
			Thread.sleep(6000);

		String validar0 = acordo.validarVinculo(GCF.nomeGrupo, id);
		Assert.assertEquals("ok", validar0);
	}	
}
