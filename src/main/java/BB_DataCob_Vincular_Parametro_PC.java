import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class BB_DataCob_Vincular_Parametro_PC {

	WebDriver driver;
	Variaveis_B_Parametros_PC variaveis;
	Variaveis_A2_Cadastro_Grupo_Cliente_Fase GCF;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;
	
	@Before
	public void iniciarSistema() throws InterruptedException {
		Thread.sleep(3000);	
		driver = new FirefoxDriver();
		variaveis = new Variaveis_B_Parametros_PC (driver);
		GCF = new Variaveis_A2_Cadastro_Grupo_Cliente_Fase (driver);
		login = new Variáveis_Login (driver);
		menu = new _Page_Menu_Superior (driver);
		subMenu = new _Page_Menu_Parametros (driver);
		
		login.login();
		menu.clicarParametros();
		menu.clicarVisualizarParâmetros();
		
		variaveis.esperarCssSelector("h1.titulo");
		
		subMenu.clicarMenuOpções();
		subMenu.clicarSubMenuCálculo();
		subMenu.clicarSubMenuCálculoPC();
	}
	
	
	@After
	public void fecharNavegador() {
		driver.quit();
	}
	
	@Test
	public void A_vincular_Grupo() throws InterruptedException {
		variaveis.esperarId("cadastra");
		variaveis.tabelaCalculoPC(variaveis.descricao);
		variaveis.clicarBotãoVincular();
		variaveis.esperarId("idSelectIdGrupo");
			Thread.sleep(1200);
		variaveis.selecionarGrupo("idSelectIdGrupo", GCF.nomeGrupo);
		variaveis.selecionarTodosClientesClientes("idSelectIdCliente", "Todos");
			Thread.sleep(1200);
		variaveis.clicarOkXpath("//*[@id=\'msgBoxContent\']/div/div[2]/a[2]");
		variaveis.esperarCssSelector(".textoAlerta");
		String mensagemSucesso = variaveis.mensagem(".textoAlerta");
		variaveis.validarMensagem("Adicionado vinculo ao parametro - " + variaveis.descricao +" : " + "\n    Grupo - " + GCF.nomeGrupo, mensagemSucesso);
		variaveis.clicarOkXpath("//*[@id=\"msgBoxContent\"]/div/div[2]/a");
	}
	
	@Test
	public void B_Não_vincular_Grupo() throws InterruptedException {
		variaveis.esperarId("cadastra");
		variaveis.tabelaCalculoPC(variaveis.descricao);
		variaveis.clicarBotãoVincular();
			Thread.sleep(1200);
		variaveis.clicarOkXpath("//*[@id=\"msgBoxContent\"]/div/div[2]/a[2]");
		variaveis.esperarCssSelector(".textoAlerta");
		String mensagemErro = variaveis.mensagem(".textoAlerta");
		variaveis.validarMensagem("Selecione um grupo!", mensagemErro);
		variaveis.clicarOkXpath("//*[@id=\'msgBoxContent\']/div/div[2]/a");
	}
	
	@Test
	public void C_Validar_Vinculo() throws InterruptedException { 
		variaveis.esperarXpath("//*[@id=\'gridCalculo\']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		int idLinha = variaveis.obterIndiceLinha(variaveis.descricao, variaveis.tabelaPC());
		String id = variaveis.descriçãoTabelaPC(variaveis.tabelaPC(), idLinha);
		variaveis.esperarXpath("//*[@id=\"treeCalculo\"]/ul/li[1]");
		String validar = variaveis.validarVinculo(GCF.nomeGrupo, id);
		Assert.assertEquals("ok", validar);
	}
}
