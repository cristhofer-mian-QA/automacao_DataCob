import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class FF_Vincular_Cadastro_Conta_Boleto {
	WebDriver driver;
	Variaveis_D_Cadastro_Conta_Banco banco;
	Variaveis_F_Cadastrar_Conta_Boleto contaBoleto;
	Variaveis_A2_Cadastro_Grupo_Cliente_Fase GCF;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;
	
			
	@Test
	public void A_Vincular_Conta_Boleto() throws InterruptedException {
			Thread.sleep(7000);		
		driver = new FirefoxDriver();
		banco = new Variaveis_D_Cadastro_Conta_Banco (driver);
		GCF = new Variaveis_A2_Cadastro_Grupo_Cliente_Fase(driver);
		contaBoleto = new Variaveis_F_Cadastrar_Conta_Boleto(driver);
		login = new Variáveis_Login (driver);
		menu = new _Page_Menu_Superior (driver);
		subMenu = new _Page_Menu_Parametros (driver);

		login.login();
		menu.clicarParametros();
		menu.clicarVisualizarParâmetros();
		contaBoleto.esperarCssSelector("h1.titulo");
		subMenu.clicarMenuOpções();
		subMenu.clicarSubMenuBoleto();
		subMenu.clicarSubMenuConta();
		contaBoleto.esperarId("btnCadastrar");
	
		WebElement tabelaBoleto = contaBoleto.tabelaContaBoleto();
		int idLinha = contaBoleto.numeroLinha(contaBoleto.descrição ,tabelaBoleto);
		WebElement contaBoletoSelecionado = tabelaBoleto.findElement(By.xpath(".//tr[" +  idLinha + "]/td[2]"));
			Thread.sleep(1000);
		contaBoletoSelecionado.click();
			Thread.sleep(1000);
		contaBoleto.clicarVincular();
		contaBoleto.esperarId("idSelectIdGrupo");
			Thread.sleep(1000);
		
		contaBoleto.selecionarGrupo(GCF.nomeGrupo);
		contaBoleto.selecionarCliente(GCF.nomeResumido);
		contaBoleto.esperarCssSelector("#treeGeral > ul > li > a.myCheckbox");
		contaBoleto.clicarCheckBox();
		contaBoleto.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		contaBoleto.esperarCssSelector(".textoAlerta");
		String mensagemConfirmacao = contaBoleto.mensagem(".textoAlerta");
		contaBoleto.validarMensagem("Adicionado vinculo ao parametro - " + contaBoleto.descrição + " : \n    Grupo - " + GCF.nomeGrupo, mensagemConfirmacao);
		contaBoleto.clicarOkcss(".caixa_bottom > a:nth-child(1)");
		contaBoleto.validarVinculoBoleto(contaBoleto.descrição, GCF.nomeGrupo);
	}
}
