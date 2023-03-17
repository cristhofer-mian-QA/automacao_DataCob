import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class E_DataCob_Cadastrar_Boleto_Envio {
	WebDriver driver;
	Variaveis_1_Inserir_Financiado dsl;
	Variaveis_E_Cadastrar_Boleto_Envio boleto;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;
	
	
	@Test
	public void A_Cadastrar_Envio_Boleto() throws InterruptedException {
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
		boleto.esperarId("btnCadastrar");
	
		boleto.clicarBotãoCadastra();
		boleto.esperarId("desc_Conf");
			Thread.sleep(1000);		
		boleto.inserirDescrição(boleto.descrição);
		boleto.clicarImpressãoLocal();
		boleto.nãoClicarCartaBoleto();
		boleto.clicarEmailDesativado();
		boleto.clicarSMSDesativado();
		boleto.clicarDocumentoAPPDesativado();
		boleto.clicarFaxDesativado();
		boleto.clicarSalvar();
		boleto.esperarCssSelector(".textoAlerta");
		String confirmacao = boleto.mensagem(".textoAlerta");
		boleto.validarMensagem("As configurações foram salvas com sucesso!", confirmacao);
		boleto.clicarOkcss(".caixa_bottom > a:nth-child(1)");
		boleto.esperarXPATH("//*[@id=\'gridBoleto\']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		boleto.tabelaBoleto(boleto.descrição);
		driver.quit();
	}
}
