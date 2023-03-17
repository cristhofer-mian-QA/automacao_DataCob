import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class L_DataCob_Cadastrar_Comarca_Forum_Vara {
	WebDriver driver;
	Variáveis_Login login;
	Variaveis_L_Cadastrar_Comarca_Forum_Vara comarca;
	_Page_Menu_Superior menu;

	@Test
	public void cadastrar_Comarca_Forum_Vara() throws InterruptedException {
		driver = new FirefoxDriver();
			Thread.sleep(7000);		
		login = new Variáveis_Login (driver);
		comarca = new Variaveis_L_Cadastrar_Comarca_Forum_Vara(driver);
		menu = new _Page_Menu_Superior (driver);
		
		login.login();
		menu.clicarParametros();
		menu.clicarJuridico();
		menu.clicarComarca();
		comarca.esperarId("btnIncluirComarca");
		comarca.clicarIncluir("btnIncluirComarca");
		comarca.esperarId("txtDescricaoComarca");
		comarca.selecionarEstado("txtUfComarca", "SP");
		comarca.inserirDescrição("txtDescricaoComarca", comarca.descriçãoComarca);
		comarca.clicarConfirmar(".caixa_bottom > a:nth-child(2)");
		comarca.esperarCssSelector(".textoAlerta");
		String mensagemConfirmação = comarca.mensagem(".textoAlerta");
		comarca.validarMensagem("Comarca cadastrada com sucesso.", mensagemConfirmação);
		comarca.clicarOkcss(".caixa_bottom > a:nth-child(1)");
			Thread.sleep(500);
		
		comarca.esperarXPATH("//*[@id=\'gridComarca\']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		WebElement tabela = comarca.tabela("//*[@id=\"gridComarca\"]/table/tbody/tr[2]/td/div/div/table");
		int idLinha = comarca.idLinha(comarca.descriçãoComarca, tabela);
		WebElement linhaComarca = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[2]"));
			Thread.sleep(500);
		linhaComarca.click();
			Thread.sleep(500);
		comarca.clicarIncluir("btnIncluirForum");
		comarca.esperarId("txtDescricaoForum");
		comarca.inserirDescrição("txtDescricaoForum", comarca.descriçãoForum);
		comarca.inserirCidade("txtCidadeForum", comarca.cidade);
		comarca.inserirBairro("txtBairroForum", comarca.bairro);
		comarca.inserirEndereço("txtEnderecoForum", comarca.endereço);
		comarca.inserirComplemento("txtComplementoForum", comarca.complemento);
		comarca.inserirCEP("txtCepForum", comarca.CEP);
		comarca.inserirDDD("txtDddForum", comarca.DDD);
		comarca.inserirTelefone("txtTelefoneForum", comarca.telefone);
		comarca.clicarConfirmar(".caixa_bottom > a:nth-child(2)");
		comarca.esperarCssSelector(".textoAlerta");
		mensagemConfirmação = comarca.mensagem(".textoAlerta");
		comarca.validarMensagem("Fórum cadastrado com sucesso.", mensagemConfirmação);
		comarca.clicarOkcss(".caixa_bottom > a:nth-child(1)");
			Thread.sleep(500);
		
		comarca.esperarXPATH("//*[@id=\'gridComarca\']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		tabela = comarca.tabela("//*[@id=\"gridComarca\"]/table/tbody/tr[2]/td/div/div/table");
		idLinha = comarca.idLinha(comarca.descriçãoComarca, tabela);
		linhaComarca = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[2]"));
			Thread.sleep(500);
		linhaComarca.click();
		comarca.esperarXPATH("//*[@id=\'gridForum\']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		WebElement tabelaForum = comarca.tabela("//*[@id=\"gridForum\"]/table/tbody/tr[2]/td/div/div/table");
		int idLinhaForum = comarca.idLinhaForum(comarca.descriçãoForum, tabelaForum);
		WebElement linhaForum = tabelaForum.findElement(By.xpath(".//tr[" + idLinhaForum + "]/td[1]"));
			Thread.sleep(500);
		linhaForum.click();
			Thread.sleep(500);
		comarca.clicarIncluir("btnIncluirVara");
		comarca.esperarId("cboForum");
		comarca.selecionarForum("cboForum", comarca.descriçãoForum);
		comarca.selecionarTipoVara("cboTipoVara", comarca.tipovara);
		comarca.inserirDescrição("txtDescricaoVara", comarca.descriçãoVara);
		comarca.clicarConfirmar(".caixa_bottom > a:nth-child(2)");
		comarca.esperarCssSelector(".textoAlerta");
		mensagemConfirmação = comarca.mensagem(".textoAlerta");
		comarca.validarMensagem("Vara cadastrada com sucesso.", mensagemConfirmação);
		comarca.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
}
