import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class A3_DataCob_CadastrarScore {
	WebDriver driver;
	Variaveis_A3_Cadastro_Score score;
	Variáveis_Login login;
	Variaveis_A2_Cadastro_Grupo_Cliente_Fase GCF;
	_Page_Menu_Superior menu;
	
	@Test
	public void cadastrarFaixasScore() throws InterruptedException {
		driver = new FirefoxDriver();
		score = new Variaveis_A3_Cadastro_Score (driver);
		login = new Variáveis_Login (driver);
		GCF = new Variaveis_A2_Cadastro_Grupo_Cliente_Fase (driver);
		menu = new _Page_Menu_Superior (driver);
		
		login.login();

		//-----------------------Faixa Vermelha-----------------------//
		
		menu.clicarParametros();
		menu.clicarCadastrar();
		menu.clicarGrupoClienteFase();
		
		score.esperarId("adcionarGrupo");
		score.clicarAbaFaixaScore();
		score.esperarId("btnAdicionarFaixa");
		
		score.clicarBotaoAdicinarScore();
		score.selecionarGrupo(GCF.nomeGrupo);
			Thread.sleep(1000);
		score.inserirDescriçãoFaixa(score.faixaVermelha);
		score.inserirFaixaDe(score.deAltoRisco);
		score.inserirFaixaAté(score.ateAltoRisco);
		score.inserirCor(score.corAltoRisco);
		score.clicarBotãoConfirar();
		score.esperarCssSelector(".barra_top");
		String mensagemSucesso = score.mensagem(".barra_top");
		score.validarMensagem("Sucesso", mensagemSucesso);
		score.clicarOk(".caixa_bottom > a:nth-child(1)");
			Thread.sleep(1000);
	
		//-----------------------Faixa Amarela-----------------------//
	
		score.clicarBotaoAdicinarScore();
		score.selecionarGrupo(GCF.nomeGrupo);
		score.inserirDescriçãoFaixa(score.faixaAmarela);
		score.inserirFaixaDe(score.deMedioRisco);
		score.inserirFaixaAté(score.ateMedioRisco);
		score.inserirCor(score.corMedioRisco);
		score.clicarBotãoConfirar();
		score.esperarCssSelector(".barra_top");
		String mensagemSucesso1 = score.mensagem(".barra_top");
		score.validarMensagem("Sucesso", mensagemSucesso1);
		score.clicarOk(".caixa_bottom > a:nth-child(1)");
			Thread.sleep(1000);
	
		//-----------------------Faixa Verde-----------------------//
	
		score.clicarBotaoAdicinarScore();
		score.selecionarGrupo(GCF.nomeGrupo);
		score.inserirDescriçãoFaixa(score.faixaVerde);
		score.inserirFaixaDe(score.deBaixoRisco);
		score.inserirFaixaAté(score.ateBaixoRisco);
		score.inserirCor(score.corBaixoRisco);
		score.clicarBotãoConfirar();
		score.esperarCssSelector(".barra_top");
		String mensagemSucesso2 = score.mensagem(".barra_top");
		score.validarMensagem("Sucesso", mensagemSucesso2);
		score.clicarOk(".caixa_bottom > a:nth-child(1)");
			Thread.sleep(1000);
			
		//-----------------------Faixa Repetida-----------------------//
	
		score.clicarBotaoAdicinarScore();
			Thread.sleep(1000);
		score.selecionarGrupo(GCF.nomeGrupo);
		score.inserirDescriçãoFaixa(score.faixaVerde);
		score.inserirFaixaDe(score.deBaixoRisco);
		score.inserirFaixaAté(score.ateBaixoRisco);
		score.inserirCor(score.corBaixoRisco);
		score.clicarBotãoConfirar();
		score.esperarCssSelector(".barra_top");
		String mensagemSucesso3 = score.mensagem(".barra_top");
		score.validarMensagem("Alerta", mensagemSucesso3);
		score.clicarOk(".caixa_bottom > a:nth-child(1)");
			Thread.sleep(1000);
		driver.quit();
	}
}
