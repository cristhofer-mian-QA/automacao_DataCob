import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class F_DataCob_Cadastrar_Conta_Boleto {
	WebDriver driver;
	Variaveis_D_Cadastro_Conta_Banco banco;
	Variaveis_F_Cadastrar_Conta_Boleto contaBoleto;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;
			
	@Test
	public void A_Cadastrar_Boleto_Conta() throws InterruptedException {
			Thread.sleep(4000);		
		driver = new FirefoxDriver();
		login = new Variáveis_Login (driver);
		banco = new Variaveis_D_Cadastro_Conta_Banco (driver);
		contaBoleto = new Variaveis_F_Cadastrar_Conta_Boleto(driver);
		menu = new _Page_Menu_Superior (driver);
		subMenu = new _Page_Menu_Parametros (driver);
		
		login.login();
		menu.clicarParametros();
		menu.clicarVisualizarParâmetros();
		contaBoleto.esperarCssSelector("h1.titulo");
		subMenu.clicarMenuOpções();
		subMenu.clicarSubMenuBoleto();
		subMenu.clicarSubMenuConta();
			Thread.sleep(1000);
		contaBoleto.esperarId("btnCadastrar");

		contaBoleto.clicarBotãoCadastra();
		contaBoleto.esperarId("txt_Descricao");
		contaBoleto.inserirDescrição(contaBoleto.descrição);
			Thread.sleep(1000);
		contaBoleto.selecionarBanco(banco.banco);
		contaBoleto.selecionarConta(banco.conta, banco.titular);
		contaBoleto.nãoSelecionarRegistroAutomático("id_select_ws_Primario", "Selecione");
		
		contaBoleto.selecionarBanco(banco.banco);
		contaBoleto.selecionarConta(banco.conta, banco.titular);
		contaBoleto.nãoSelecionarRegistroAutomático("id_select_ws_Secundario", "Selecione");
		
		contaBoleto.selecionarBanco(banco.banco);
		contaBoleto.selecionarConta(banco.conta, banco.titular);
		contaBoleto.nãoSelecionarRegistroAutomático("id_select_ws_Remessa", "Selecione");
		contaBoleto.limparInstruçõesCNAB();
		
		contaBoleto.clicarBotãoConfirmar();
		contaBoleto.esperarCssSelector(".textoAlerta");
		String mensagemConfirmada = contaBoleto.mensagem(".textoAlerta");
		contaBoleto.validarMensagem("Configuração inserida com sucesso." , mensagemConfirmada);
		contaBoleto.clicarOkcss(".caixa_bottom > a:nth-child(1)");
		contaBoleto.esperarId("btnCadastrar");
		int idLinha = contaBoleto.numeroLinha(contaBoleto.descrição ,contaBoleto.tabelaContaBoleto());
		WebElement contaBoletoSelecionado = contaBoleto.tabelaContaBoleto().findElement(By.xpath(".//tr[" +  idLinha + "]/td[2]"));
			Thread.sleep(3000);
		contaBoletoSelecionado.click();
		driver.quit();
	}
}
