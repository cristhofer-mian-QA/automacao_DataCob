import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class M_DataCob_Cadastrar_Feriado {
	WebDriver driver;
	Variáveis_Login login;
	Variaveis_M_Cadastrar_Feriados feriado;
	_Page_Menu_Superior menu;

	@Test
	public void cadastrar_Feriado() throws InterruptedException {
		driver = new FirefoxDriver();
			Thread.sleep(7000);		
		login = new Variáveis_Login (driver);
		feriado = new Variaveis_M_Cadastrar_Feriados(driver);
		menu = new _Page_Menu_Superior (driver);
		
		login.login();
		feriado.esperarCssSelector(".itemParametros");
		menu.clicarParametros();
		menu.clicarFeriado();
		feriado.esperarId("novoFeriado");
		feriado.clicarCadastrar("novoFeriado");
		feriado.esperarId("tp_feriado");
		feriado.selecionarTipoFeriado("tp_feriado", "Estadual");
		feriado.inserirData("dia_feriado", feriado.dataEstadual);
		feriado.esperarId("est_feriado");
		feriado.selecionarEstado("est_feriado", feriado.estado);
		feriado.nãoClicarFeriadoMovel("feriado_m");
		feriado.nãoClicarAvisaCobrança("avisa_c");
		feriado.inserirDescrição("desc_feriado", feriado.descriçãoFeriadoEstadual);
		feriado.clicarConfirmar(".caixa_bottom > a:nth-child(2)");
		feriado.esperarCssSelector(".textoAlerta");
		String mensagemConfirmação = feriado.mensagem(".textoAlerta");
		feriado.validarMensagem("O feriado " + feriado.dataEstadual + " foi inserido com sucesso.", mensagemConfirmação);
		feriado.clicarOkcss(".caixa_bottom > a:nth-child(1)");
		
		feriado.esperarId("novoFeriado");
		feriado.clicarCadastrar("novoFeriado");
		feriado.clicarCadastrar("desc_feriado");
		feriado.esperarId("tp_feriado");
		feriado.selecionarTipoFeriado("tp_feriado", "Municipal");
		feriado.inserirData("dia_feriado", feriado.dataMunicipal);
		feriado.esperarId("cepInicial");
		feriado.inserirCepInicio("cepInicial", feriado.cepInicial);
		feriado.inserirCepFinal("cepFinal", feriado.cepFinal);
		feriado.nãoClicarFeriadoMovel("feriado_m");
		feriado.nãoClicarAvisaCobrança("avisa_c");
		feriado.inserirDescrição("desc_feriado", feriado.descriçãoFeriadoMunicipal);
		feriado.clicarConfirmar(".caixa_bottom > a:nth-child(2)");
		feriado.esperarCssSelector(".textoAlerta");
		mensagemConfirmação = feriado.mensagem(".textoAlerta");
		feriado.validarMensagem("O feriado " + feriado.dataMunicipal + " foi inserido com sucesso.", mensagemConfirmação);
		feriado.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
}
