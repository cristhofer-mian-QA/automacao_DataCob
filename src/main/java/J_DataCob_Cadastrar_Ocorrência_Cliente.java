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
public class J_DataCob_Cadastrar_Ocorrência_Cliente {
	WebDriver driver;
	Variáveis_Login login;
	Variaveis_J_Cadastrar_Ocorrência_Cliente cliente;
	Variáveis_I_Cadastrar_Ocorrências_Sistema sistema;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;
	
	
	@Before
	public void iniciarSistema() throws InterruptedException {
			Thread.sleep(7000);		
		driver = new FirefoxDriver();
		login = new Variáveis_Login (driver);
		cliente = new Variaveis_J_Cadastrar_Ocorrência_Cliente(driver);
		sistema = new Variáveis_I_Cadastrar_Ocorrências_Sistema(driver);
		menu = new _Page_Menu_Superior (driver);
		subMenu = new _Page_Menu_Parametros (driver);
		
		login.login();
		menu.clicarParametros();
		menu.clicarOcorrências();
		menu.clicarCliente();
		cliente.esperarId("addTabela");
		Thread.sleep(1200);
	}
	
	
	@After
	public void fecharNavegador () {
		driver.quit();
	}
	
	
	@Test
	public void A_Inserir_Ocorrencia_Cliente_Retorno_Não_Altera_Status () throws InterruptedException {
		cliente.clicarAdicionarTabela("addTabela");
		cliente.esperarId("DESCRICAO_TABELA_OCORRENCIA");
		cliente.inserirNomeTabela("DESCRICAO_TABELA_OCORRENCIA", cliente.nomeTabelaOcorrencia);
		cliente.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		cliente.esperarCssSelector(".textoAlerta");
		String mensagem = cliente.mensagem(".textoAlerta");
		cliente.validarMensagem("Tabela \""+ cliente.nomeTabelaOcorrencia+"\" inserido com sucesso!", mensagem);
		cliente.clicarOkcss(".caixa_bottom > a:nth-child(1)");
			Thread.sleep(1500);
		WebElement tabOcorrencia = cliente.tabelaOcorrencia("//*[@id=\'gridTabelaOcorrencia\']/table/tbody/tr[2]/td/div/div/table");
		int linhaOcorrencia = cliente.idLinha(cliente.nomeTabelaOcorrencia, tabOcorrencia);
		WebElement linha = tabOcorrencia.findElement(By.xpath(".//tr[" + linhaOcorrencia + "]/td[1]"));
		linha.click();
			Thread.sleep(800);
		cliente.clicarAdicionarOcorrência("btnAdcionarOcorrencia");
		cliente.esperarId("COD_OCORRENCIA");
		cliente.inserirCodido("COD_OCORRENCIA", cliente.codOcorrenciaCliente);
		cliente.inserirDescrição("DESCRICAO", cliente.descOcorrenciaClienteNãoAlteraStatus);
		cliente.nãoEnviarCliente("ENVIAR_CLIENTE");
		cliente.checkBoxTodasFases("TFases");
		cliente.comboTipo("ComboTipo", "Data e Hora");
		cliente.inserirComplemento("DESCRICAO_COMPLEMENTO", cliente.complemento);
		cliente.comboValidarComplemento("validarComplemento-Unidade", "Não Validar");
		WebElement tabelaOcSistema = cliente.tabelaOcorrencia("//*[@id=\'gridTodasOcorrenciasSistema\']/table/tbody/tr[2]/td/div/div/table");
		int linhaOc = cliente.idLinhaOc(sistema.codigoRetorno, tabelaOcSistema);
		WebElement lnOcorrenciaSistema = tabelaOcSistema.findElement(By.xpath(".//tr[" + linhaOc + "]/td[1]"));
			Thread.sleep(800);
		lnOcorrenciaSistema.click();
		cliente.clicarConfirmar("btSalvarFormOcor");
		cliente.esperarCssSelector(".textoAlerta");
		String mensagemConfirm = cliente.mensagem(".textoAlerta");
		cliente.validarMensagem("Ocorrência Cliente inserida com sucesso", mensagemConfirm);
		cliente.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	
	@Test
	public void B_Inserir_Ocorrencia_Cliente_Retorno_Altera_Status () throws InterruptedException {
		cliente.esperarXPATH("//*[@id=\'gridTabelaOcorrencia\']/table/tbody/tr[2]/td/div/div/table");
		WebElement tabOcorrencia = cliente.tabelaOcorrencia("//*[@id=\'gridTabelaOcorrencia\']/table/tbody/tr[2]/td/div/div/table");
		int linhaOcorrencia = cliente.idLinha(cliente.nomeTabelaOcorrencia, tabOcorrencia);
		WebElement linha = tabOcorrencia.findElement(By.xpath(".//tr[" + linhaOcorrencia + "]/td[1]"));
		linha.click();
			Thread.sleep(800);
		cliente.clicarAdicionarOcorrência("btnAdcionarOcorrencia");
		cliente.esperarId("COD_OCORRENCIA");
		cliente.inserirCodido("COD_OCORRENCIA", cliente.codOcorrenciaClienteAlteraStatus);
		cliente.inserirDescrição("DESCRICAO", cliente.descOcorrenciaClienteAlteraStatus);
		cliente.nãoEnviarCliente("ENVIAR_CLIENTE");
		cliente.checkBoxTodasFases("TFases");
		cliente.comboTipo("ComboTipo", "Data e Hora");
		cliente.inserirComplemento("DESCRICAO_COMPLEMENTO", cliente.complemento);
		cliente.comboValidarComplemento("validarComplemento-Unidade", "Não Validar");
		WebElement tabelaOcSistema = cliente.tabelaOcorrencia("//*[@id=\'gridTodasOcorrenciasSistema\']/table/tbody/tr[2]/td/div/div/table");
		int linhaOc = cliente.idLinhaOc(sistema.codigoRetornoAlteraStatus, tabelaOcSistema);
		WebElement lnOcorrenciaSistema = tabelaOcSistema.findElement(By.xpath(".//tr[" + linhaOc + "]/td[1]"));
			Thread.sleep(800);
		lnOcorrenciaSistema.click();
		cliente.clicarConfirmar("btSalvarFormOcor");
		cliente.esperarCssSelector(".textoAlerta");
		String mensagemConfirm = cliente.mensagem(".textoAlerta");
		cliente.validarMensagem("Ocorrência Cliente inserida com sucesso", mensagemConfirm);
		cliente.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
}