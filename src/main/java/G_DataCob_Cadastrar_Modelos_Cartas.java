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
public class G_DataCob_Cadastrar_Modelos_Cartas {	
	WebDriver driver;
	Variaveis_G_Cadastrar_Modelos_Cartas modelo;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;
	
	
	@Before
	public void iniciarSistema() throws InterruptedException {
			Thread.sleep(7000);		
		driver = new FirefoxDriver();
		modelo = new Variaveis_G_Cadastrar_Modelos_Cartas(driver);
		login = new Variáveis_Login (driver);
		menu = new _Page_Menu_Superior (driver);
		subMenu = new _Page_Menu_Parametros (driver);
		
		login.login();
	}
	
	
	@After
	public void fecharNavegador() {
		driver.quit();
	}
	
	
	@Test
	public void A_Cadastrar_Carta_Acordo() throws InterruptedException {
		menu.clicarParametros();
		menu.clicarModeloCarta();
		menu.clicarModeloAcordo();
		modelo.esperarId ("cb_tabelas");
		modelo.clicarNovoModelo("btnNovo");
		modelo.inserirCorpo("#cke_contents_TextEditor > iframe:nth-child(1)", modelo.corpo);
		modelo.clicarSalvar();
		modelo.esperarId("descCarta");
		modelo.inserirDescrição("#descCarta > input:nth-child(2)", modelo.descrição);
		modelo.inserirAssunto("#descAssunto > input:nth-child(2)", modelo.assunto);
		modelo.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		modelo.esperarCssSelector(".textoAlerta");
		String mensagemConfirmação = modelo.mensagem(".textoAlerta");
		modelo.validarMensagem("Inserido com sucesso!", mensagemConfirmação);
		modelo.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	
	@Test
	public void B_Cadastrar_Carta_Boleto() throws InterruptedException {
		menu.clicarParametros();
		menu.clicarModeloCarta();
		menu.clicarModeloBoleto();
		modelo.esperarId("listModelAdress_text_filter");
		modelo.inserirCorpo("#cke_contents_TextEditor > iframe:nth-child(1)", modelo.corpo);
		modelo.clicarSalvar();
		modelo.esperarCssSelector("#descCarta > input:nth-child(2)");
		modelo.inserirDescrição("#descCarta > input:nth-child(2)", modelo.descrição);
		modelo.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		modelo.esperarCssSelector(".textoAlerta");
		String mensagemConfirmação = modelo.mensagem(".textoAlerta");
		modelo.validarMensagem("Inserido com sucesso!", mensagemConfirmação);
		modelo.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	@Test
	public void C_Cadastrar_Carta_Word() throws InterruptedException {
		menu.clicarParametros();
		menu.clicarModeloCarta();
		menu.clicarModeloWord();
		modelo.esperarId("listModelAdress_text_filter");
		modelo.clicarNovoModelo("btnNovo");
		modelo.inserirCorpo("#cke_contents_TextEditor > iframe:nth-child(1)", modelo.corpo);
		modelo.clicarSalvar();
		modelo.esperarCssSelector("#descCarta > input:nth-child(2)");
		modelo.inserirDescrição("#descCarta > input:nth-child(2)", modelo.descrição);
		modelo.inserirAssunto("#descAssunto > input:nth-child(2)", modelo.assunto);
		modelo.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		modelo.esperarCssSelector(".textoAlerta");
		String mensagemConfirmação = modelo.mensagem(".textoAlerta");
		modelo.validarMensagem("Inserido com sucesso!", mensagemConfirmação);
		modelo.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	
	@Test
	public void D_Cadastrar_Boleto_Modelo() throws InterruptedException {
		menu.clicarParametros();
		menu.clicarModeloCarta();
		menu.clicarModeloBoleto();
		modelo.esperarId("listModelAdress_text_filter");
		modelo.clicarComboModelo("listModelAdress_text_filter");
		int numLinha = modelo.numeroLinha();	
		WebElement nomeLinha = modelo.buscarModelo(numLinha);
		String nomLinha = nomeLinha.getText();
			Thread.sleep(2000);
		
		menu.clicarParametros();
		menu.clicarVisualizarParâmetros();
		modelo.esperarCssSelector("h1.titulo");
		subMenu.clicarMenuOpções();
		subMenu.clicarSubMenuBoleto();
		subMenu.clicarSubMenuBoletoModelo();
		modelo.esperarId("btnCadastrar");
		modelo.clicarBotãoCadastrar("btnCadastrar");
		modelo.esperarId("txtDescricao");
		modelo.inserirDescriçãoId("txtDescricao", modelo.descParametro);
		modelo.selecionarModeloNegociação("modeloImpressao", nomLinha);
		modelo.selecionarModeloAcordoVista("modeloImpressaoAcordoAVista", nomLinha);
		modelo.selecionarModeloAcordoParcelado("modeloImpressaoAcordoParcelado", nomLinha);
		modelo.selecionarModeloBoletagem("modeloArquivo", nomLinha);
			Thread.sleep(2000);
		modelo.clicarOkcss(".caixa_bottom > a:nth-child(2)");
			Thread.sleep(3000);
		WebElement tabelaBoleto = modelo.tabelaModeloBoleto();
		int idlinha = modelo.idLinha(modelo.descParametro, tabelaBoleto);
		WebElement tabelaVerifica = tabelaBoleto.findElement(By.xpath(".//tr[" +  idlinha + "]/td[2]"));
		tabelaVerifica.click();
	}

	
	
	
	
	
}
