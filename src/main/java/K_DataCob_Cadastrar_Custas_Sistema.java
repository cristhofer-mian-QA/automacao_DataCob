import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class K_DataCob_Cadastrar_Custas_Sistema {
	
	WebDriver driver;
	Variáveis_Login login;
	Variaveis_K_Cadastrar_Custas custas;
	_Page_Menu_Superior menu;

	@Before
	public void iniciarSistema() throws InterruptedException {
			Thread.sleep(7000);		
		driver = new FirefoxDriver();
		login = new Variáveis_Login (driver);
		custas = new Variaveis_K_Cadastrar_Custas(driver);
		menu = new _Page_Menu_Superior (driver);
		
		login.login();
		custas.esperarCssSelector(".itemParametros > a:nth-child(1)");
		menu.clicarParametros();
		menu.clicarTipoCustas();
	}
	
	
	//@After
	public void fecharNavegador () {
		driver.quit();
	}
	
	@Test
	public void A_Adicionar_Custa_Sistema_Motoboy () throws InterruptedException {
		menu.clicarCustasSistema();
		custas.esperarXPATH("//*[@id=\'gridDespesaSistema\']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
			Thread.sleep(500);
		custas.clicarAdicionar("btnAdicionarDespesa");
		custas.esperarId("txtCodDespesa");
		custas.inserirCodCusta("txtCodDespesa", custas.codCustaSistema);
		custas.inserirDescrição("txtDescricaoDespesa", custas.descrição);
		custas.selecionarCobrarDe("cboTipoCobrador", "Financiado");
		custas.inserirValor("txtValorDespesa", custas.valor);
		custas.checkboxAtiva("status_despesa");
		custas.clicarConfirmarCss(".caixa_bottom > a:nth-child(2)");
		custas.esperarCssSelector(".textoAlerta");
		String mensagemConfirm = custas.mensagem(".textoAlerta");
		custas.validarMensagem("Tipo de Custa cadastrada com sucesso.", mensagemConfirm);
		custas.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	@Test
	public void B_Adicionar_Custa_Cliente_Motoboy () throws InterruptedException {
		menu.clicarCustasCliente();
		custas.esperarId("btnCadastrarTabela");
		custas.clicarAdicionarTabela("btnCadastrarTabela");
		custas.esperarId("txtNomeTabela");
		custas.inserirNomeTabela("txtNomeTabela", custas.nomeTabela);
		custas.clicarOkcss("#msgBoxContent > div > div.caixa_bottom > a.btnPadrao.btnVerde");
		custas.esperarCssSelector(".textoAlerta");
		String mensagemSucesso = custas.mensagem(".textoAlerta");
		custas.validarMensagem("Tabela cadastrada com sucesso.", mensagemSucesso);
		custas.clicarOkcss(".caixa_bottom > a:nth-child(1)");
		custas.esperarXPATH("//*[@id=\'gridTabelaDespesa\']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		WebElement tabelaDespesa = custas.tabelaCustas("//*[@id=\'gridTabelaDespesa\']/table/tbody/tr[2]/td/div/div/table");
		int linhaTabela = custas.idLinha(custas.nomeTabela, tabelaDespesa);
		WebElement linhaTab = tabelaDespesa.findElement(By.xpath(".//tr[" + linhaTabela + "]/td[3]"));
			Thread.sleep(800);
		linhaTab.click();
		custas.esperarId("btnCadastrarDespesaCliente");
		custas.clicarAdicionarTipo("btnCadastrarDespesaCliente");
		custas.esperarId("txtCodDespesa");
		custas.inserirCodCusta("txtCodDespesa", custas.codCustaCliente);
		custas.inserirDescrição("txtDescricao", custas.descrição);
		custas.selecionarCobrador("cboCobrador", "Financiado");
		custas.selecionarCusta("cboDespesaSistema", custas.codCustaSistema, custas.descrição);
		custas.inserirValor("txtValor", custas.valor);
		custas.checkboxAtiva("status_despesa");
		custas.clicarGravarTipo("btnGravarDespesa");
		custas.esperarCssSelector(".textoAlerta");
		mensagemSucesso = custas.mensagem(".textoAlerta");
		custas.validarMensagem("Despesa cadastrada com sucesso.", mensagemSucesso);
		custas.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
}
