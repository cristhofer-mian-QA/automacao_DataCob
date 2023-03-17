import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class N_DataCob_Cadastrar_Fase_Processo {

	WebDriver driver;
	Variaveis_N_Cadastrar_Fase_Processo fase;
	Variáveis_Login login;
	Variaveis_A_Cadastrar_Fase fase_GCF;
	_Page_Menu_Superior menu;

	@Before
	public void iniciarSistema() throws InterruptedException {
		driver = new FirefoxDriver();
			Thread.sleep(7000);
		fase = new Variaveis_N_Cadastrar_Fase_Processo(driver);
		login = new Variáveis_Login(driver);
		fase_GCF = new Variaveis_A_Cadastrar_Fase (driver);
		menu = new _Page_Menu_Superior (driver);

		login.login();
		fase.esperarCssSelector(".itemParametros");
		menu.clicarParametros();
		menu.clicarJuridico();
		menu.clicarFaseProcesso();
		fase.esperarId("btnIncluir");
	}

	@After
	public void fecharNavegador() {
		driver.quit();
	}

	@Test
	public void A_Inserir_Fase_Encerra_Processo () throws InterruptedException {
		fase.clicarIncluir("btnIncluir");
		fase.esperarId("txtDescricao");
		fase.inserirDescrição("txtDescricao", fase.descFaseEncerraProcesso);
		fase.alterarFase("cboFaseContrato", fase_GCF.faseJU + " - " +fase_GCF.descFaseJU);
		fase.clicarEncerraProcesso("chkEncerraProcesso");
		fase.nãoClicarBloquearAcordo("cbBlockBoleto");
			Thread.sleep(500);
		fase.clicarConfirmar("btnConfirmar");
		fase.esperarCssSelector(".textoAlerta");
		String mensagemSucesso = fase.mensagem(".textoAlerta");
		fase.validarMensagem("Fase Processo incluída com sucesso.", mensagemSucesso);
		fase.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	
	@Test
	public void B_Inserir_Fase_Não_Encerra_Processo () throws InterruptedException {
		fase.clicarIncluir("btnIncluir");
		fase.esperarId("txtDescricao");
		fase.inserirDescrição("txtDescricao", fase.descFaseNãoEncerraProcesso);
		fase.alterarFase("cboFaseContrato", fase_GCF.faseJU + " - " +fase_GCF.descFaseJU);
		fase.nãoClicarEncerraProcesso("chkEncerraProcesso");
		fase.nãoClicarBloquearAcordo("cbBlockBoleto");
			Thread.sleep(500);
		fase.clicarConfirmar("btnConfirmar");
		fase.esperarCssSelector(".textoAlerta");
		String mensagemSucesso = fase.mensagem(".textoAlerta");
		fase.validarMensagem("Fase Processo incluída com sucesso.", mensagemSucesso);
		fase.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	
	@Test
	public void C_Inserir_Fase_Não_Encerra_Processo_Bloqueia_Acordo () throws InterruptedException {
		fase.clicarIncluir("btnIncluir");
		fase.esperarId("txtDescricao");
		fase.inserirDescrição("txtDescricao", fase.descFaseNãoEncProcCancelaAcordo);
		fase.alterarFase("cboFaseContrato", fase_GCF.faseJU + " - " +fase_GCF.descFaseJU);
		fase.nãoClicarEncerraProcesso("chkEncerraProcesso");
		fase.clicarBloquearAcordo("cbBlockBoleto");
			Thread.sleep(500);
		fase.clicarConfirmar("btnConfirmar");
		fase.esperarCssSelector(".textoAlerta");
		String mensagemSucesso = fase.mensagem(".textoAlerta");
		fase.validarMensagem("Fase Processo incluída com sucesso.", mensagemSucesso);
		fase.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	
	@Test //não encerra processo e não bloqueia acordo
	public void D_Inserir_Fase_Não_Altera_Fase () throws InterruptedException {
		fase.clicarIncluir("btnIncluir");
		fase.esperarId("txtDescricao");
		fase.inserirDescrição("txtDescricao", fase.descNãoAlteraFase);
		fase.alterarFase("cboFaseContrato","NÃO ALTERA");
		fase.nãoClicarEncerraProcesso("chkEncerraProcesso");
		fase.nãoClicarBloquearAcordo("cbBlockBoleto");
			Thread.sleep(500);
		fase.clicarConfirmar("btnConfirmar");
		fase.esperarCssSelector(".textoAlerta");
		String mensagemSucesso = fase.mensagem(".textoAlerta");
		fase.validarMensagem("Fase Processo incluída com sucesso.", mensagemSucesso);
		fase.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	
}
