import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class O_DataCob_Cadastrar_Andamento_Sistema {

	WebDriver driver;
	Variaveis_O_Cadastrar_Andamento_Sistema andamento;
	Variáveis_Login login;
	Variaveis_N_Cadastrar_Fase_Processo fase_processo;
	_Page_Menu_Superior menu;

	@Before
	public void iniciarSistema() throws InterruptedException {
		driver = new FirefoxDriver();
			Thread.sleep(7000);
		andamento = new Variaveis_O_Cadastrar_Andamento_Sistema(driver);
		login = new Variáveis_Login(driver);
		fase_processo = new Variaveis_N_Cadastrar_Fase_Processo (driver);
		menu = new _Page_Menu_Superior (driver);

		login.login();
		andamento.esperarCssSelector(".itemParametros");
		menu.clicarParametros();
		menu.clicarJuridico();
		menu.clicarProcessoAndamento();
		andamento.esperarCssSelector("#botoesAdicionarEditar > a:nth-child(1)");
		andamento.esperarXPATH("//*[@id=\'gridOcorrenciaSistema\']/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/table/tbody/tr[2]");
	}

	//@After
	public void fecharNavegador() {
		driver.quit();
	}
	
	
	@Test
	public void A_Inserir_Andamento_Obriga_Anexo () throws InterruptedException {
		andamento.clicarAdicionarOcorrência("#botoesAdicionarEditar > a:nth-child(1)");
		andamento.esperarId("COD_OCORRENCIA");
		andamento.inserirCodOcorrencia("COD_OCORRENCIA", andamento.cod_ocorrência);
		andamento.marcarAPI("OCORR_API");
		andamento.semComplemento("ComboTipo", 0);
		andamento.diasAlerta("diasAlerta", andamento.diasAlerta);
		andamento.nãoClicarEnviarCliente("ENVIAR_CLIENTE");
		andamento.selecionarFaseProcesso("cboFaseProcesso", fase_processo.);
		
		
		
		
		
	}
	
	
	
}
