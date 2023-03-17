import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class A_DataCob_Cadastrar_Fase {

	WebDriver driver;
	Variaveis_A_Cadastrar_Fase fase;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	
	@Test
	public void Cadastrar_Fase_AM_JU () throws InterruptedException {
		driver = new FirefoxDriver();
		fase = new Variaveis_A_Cadastrar_Fase (driver);
		login = new Variáveis_Login (driver);
		menu = new _Page_Menu_Superior (driver);
		
		login.login();
		menu.clicarParametros();
		menu.clicarCadastrar();
		menu.clicarGrupoClienteFase();
		fase.esperarCssSelector("#abaFaseGeral > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)"); //Esperar "Fase" aparecer
		
		fase.clicarFase("#abaFaseGeral > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)");
		fase.esperarId("btnAdicionarFase");	
		fase.clicarAdicionarFase("btnAdicionarFase");
			Thread.sleep(500);
		fase.inserirCodFase("codFase", fase.faseAM);
		fase.inserirDescriçãoFase("descricaoFase", fase.descFaseAM);
		fase.inserirCorFase("corFase", fase.corFaseAM);
		fase.clicarBotãoConfirmar("btnConfirmaCadFase");
		
		String mensagemSucessoAM = fase.mensagemSucesso(".barra_top");
		fase.validarMensagem("Sucesso", mensagemSucessoAM);
		fase.clicarBotãoOk(".caixa_bottom > a:nth-child(1)");
		
		fase.esperarId("btnAdicionarFase");	
		fase.clicarAdicionarFase("btnAdicionarFase");
		fase.inserirCodFase("codFase", fase.faseJU);
		fase.inserirDescriçãoFase("descricaoFase", fase.descFaseJU);
		fase.inserirCorFase("corFase", fase.corFaseJU);
		fase.clicarBotãoConfirmar("btnConfirmaCadFase");
		
		String mensagemSucessoJU = fase.mensagemSucesso(".barra_top");
		fase.validarMensagem("Sucesso", mensagemSucessoJU);
		fase.clicarBotãoOk(".caixa_bottom > a:nth-child(1)");
		
		fase.esperarId("btnAdicionarFase");	
		fase.clicarAdicionarFase("btnAdicionarFase");
		fase.inserirCodFase("codFase", fase.fasePJ);
		fase.inserirDescriçãoFase("descricaoFase", fase.descFasePJ);
		fase.inserirCorFase("corFase", fase.corFasePJ);
		fase.clicarBotãoConfirmar("btnConfirmaCadFase");
		
		String mensagemSucessoPJ = fase.mensagemSucesso(".barra_top");
		fase.validarMensagem("Sucesso", mensagemSucessoPJ);
		fase.clicarBotãoOk(".caixa_bottom > a:nth-child(1)");
	
		fase.esperarId("btnAdicionarFase");	
		fase.clicarAdicionarFase("btnAdicionarFase");
		fase.inserirCodFase("codFase", fase.faseJU);
		fase.inserirDescriçãoFase("descricaoFase", fase.descFaseJU);
		fase.inserirCorFase("corFase", fase.corFaseJU);
		fase.clicarBotãoConfirmar("btnConfirmaCadFase");
		
		String mensagemErro = fase.mensagemSucesso(".barra_top");
		fase.validarMensagem("Alerta", mensagemErro);
		fase.clicarBotãoOk(".caixa_bottom > a:nth-child(1)");
		driver.quit();
	}
}
