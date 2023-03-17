import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class DataCob_InserirFianciado {
	WebDriver driver;
	WebDriver cpf_site;
	WebDriver cnpj_site;
	Variaveis_1_Inserir_Financiado financiado;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	Variaveis_A2_Cadastro_Grupo_Cliente_Fase GCF;

	String cpf;
	String dataAtual = "2022.31.08";

	@Before
	public void iniciarSistema() throws InterruptedException {
		driver = new FirefoxDriver();
		Thread.sleep(7000);
		financiado = new Variaveis_1_Inserir_Financiado(driver);
		login = new Variáveis_Login(driver);
		menu = new _Page_Menu_Superior(driver);
		GCF = new Variaveis_A2_Cadastro_Grupo_Cliente_Fase(driver);

		login.login();
		financiado.esperarCssSelector("h1.titulo");
	}

	// @After
	public void fecharNavegador() {
		driver.quit();
	}

	@Test
	public void A_Cadastrar_Financiado_Manual_Físico() throws InterruptedException {
		menu.clicarOperações();
		menu.clicarAtendimento();
		financiado.esperarId("buttonNovoFinanciado");
		financiado.clicarNovoFinanciado();
		financiado.esperarId("nome");
		financiado.inserirNome(financiado.nome);
		financiado.inserirDataNascimento(financiado.dataNascimento);
		financiado.limparEnriquecimento();
		financiado.selecionarSexo("masculino");
		financiado.selecionarGrupo(GCF.nomeGrupo);
		financiado.selecionarCliente(GCF.nomeResumido);
		financiado.inserirScore(financiado.score);
		financiado.escolherEstadoCivil("Casado");
		financiado.inserirRG(financiado.RG);
		financiado.inserirDtEmissão(financiado.dataEmissão);
		financiado.inserirEmissor(financiado.emissor);
		financiado.selecionarUF("SP");
		financiado.inserirCPF_CNPJ(financiado.cpf);
		financiado.tipoPessoa("fisico");
		financiado.inserirConjuge(financiado.conjuge);
		financiado.inserirMãe(financiado.mãe);
		financiado.inserirPai(financiado.pai);
		Thread.sleep(1000);
		financiado.clicarConfirmar();
		financiado.esperarCssSelector(".textoAlerta");
		String mensagemConfirm = financiado.mensagem(".textoAlerta");
		financiado.validarMensagem("Financiado inserido com sucesso.", mensagemConfirm);
		financiado.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}

	@Test
	public void B_Cadastrar_Financiado_Manual_CPF_Existente() throws InterruptedException {
		menu.clicarOperações();
		menu.clicarAtendimento();
		financiado.esperarId("buttonNovoFinanciado");
		financiado.clicarNovoFinanciado();
		financiado.esperarId("nome");
		financiado.esperarCssSelector("h1.titulo");
		financiado.inserirNome(financiado.nome);
		financiado.inserirDataNascimento(financiado.dataNascimento);
		financiado.limparEnriquecimento();
		financiado.selecionarSexo("masculino");
		financiado.selecionarGrupo(GCF.nomeGrupo);
		financiado.selecionarCliente(GCF.nomeResumido);
		financiado.inserirScore(financiado.score);
		financiado.escolherEstadoCivil("Casado");
		financiado.inserirRG(financiado.RG);
		financiado.inserirDtEmissão(financiado.dataEmissão);
		financiado.inserirEmissor(financiado.emissor);
		financiado.selecionarUF("SP");
		financiado.inserirCPF_CNPJ(financiado.cpf);
		financiado.tipoPessoa("fisico");
		financiado.inserirConjuge(financiado.conjuge);
		financiado.inserirMãe(financiado.mãe);
		financiado.inserirPai(financiado.pai);
		Thread.sleep(1000);
		financiado.clicarConfirmar();
		String mensagemErro = financiado.mensagem(".textoAlerta");
		financiado.validarMensagem("Já existe cadastrado um financiado com este mesmo CPF/CNPJ para o grupo selecionado", mensagemErro);
		financiado.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}

	@Test
	public void C_Cadastrar_Financiado_Manual_CPF_Invalido() throws InterruptedException {
		menu.clicarOperações();
		menu.clicarAtendimento();
		financiado.esperarId("buttonNovoFinanciado");
		financiado.clicarNovoFinanciado();
		financiado.esperarId("nome");
		financiado.esperarCssSelector("h1.titulo");
		financiado.inserirNome(financiado.nome);
		financiado.inserirDataNascimento(financiado.dataNascimento);
		financiado.limparEnriquecimento();
		financiado.selecionarSexo("masculino");
		financiado.selecionarGrupo(GCF.nomeGrupo);
		financiado.selecionarCliente(GCF.nomeResumido);
		financiado.inserirScore(financiado.score);
		financiado.escolherEstadoCivil("Casado");
		financiado.inserirRG(financiado.RG);
		financiado.inserirDtEmissão(financiado.dataEmissão);
		financiado.inserirEmissor(financiado.emissor);
		financiado.selecionarUF("SP");
		financiado.inserirCPF_CNPJ(financiado.cpfInvalido);
		financiado.tipoPessoa("fisico");
		financiado.inserirConjuge(financiado.conjuge);
		financiado.inserirMãe(financiado.mãe);
		financiado.inserirPai(financiado.pai);
		Thread.sleep(1000);
		financiado.clicarConfirmar();
		String mensagemErro = financiado.mensagem(".textoAlerta");
		financiado.validarMensagem("CPF/CNPJ:  " + financiado.cpfInvalido + " inválido!", mensagemErro);
		financiado.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}

	@Test
	public void D_Cadastrar_Financiado_Manual_Jurídico() throws InterruptedException {
		menu.clicarOperações();
		menu.clicarAtendimento();
		financiado.esperarId("buttonNovoFinanciado");
		financiado.clicarNovoFinanciado();
		financiado.esperarId("nome");
		financiado.inserirNome(financiado.nomeJuridico);
		financiado.inserirDataNascimento(financiado.dataNascimentoJuridico);
		financiado.limparEnriquecimento();
		financiado.selecionarSexo("masculino");
		financiado.selecionarGrupo(GCF.nomeGrupo);
		financiado.selecionarCliente(GCF.nomeResumido);
		financiado.inserirScore(financiado.scoreJuridico);
		financiado.escolherEstadoCivil("Casado");
		financiado.inserirRG(financiado.RGJuridico);
		financiado.inserirDtEmissão(financiado.dataEmissão);
		financiado.inserirEmissor(financiado.emissor);
		financiado.selecionarUF("SP");
		financiado.inserirCPF_CNPJ(financiado.CNPJ);
		financiado.tipoPessoa("fisico");
		financiado.inserirConjuge(financiado.conjugeJuridico);
		financiado.inserirMãe(financiado.mãeJuridico);
		financiado.inserirPai(financiado.paiJuridico);
		Thread.sleep(1000);
		financiado.clicarConfirmar();
		financiado.esperarCssSelector(".textoAlerta");
		String mensagemConfirm = financiado.mensagem(".textoAlerta");
		financiado.validarMensagem("Financiado inserido com sucesso.", mensagemConfirm);
		financiado.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}

	@Test
	public void E_Cadastrar_Financiado_Manual_CNPJ_Invalido() throws InterruptedException {
		menu.clicarOperações();
		menu.clicarAtendimento();
		financiado.esperarId("buttonNovoFinanciado");
		financiado.clicarNovoFinanciado();
		financiado.esperarId("nome");
		financiado.inserirNome(financiado.nomeJuridico);
		financiado.inserirDataNascimento(financiado.dataNascimentoJuridico);
		financiado.limparEnriquecimento();
		financiado.selecionarSexo("masculino");
		financiado.selecionarGrupo(GCF.nomeGrupo);
		financiado.selecionarCliente(GCF.nomeResumido);
		financiado.inserirScore(financiado.scoreJuridico);
		financiado.escolherEstadoCivil("Casado");
		financiado.inserirRG(financiado.RGJuridico);
		financiado.inserirDtEmissão(financiado.dataEmissão);
		financiado.inserirEmissor(financiado.emissor);
		financiado.selecionarUF("SP");
		financiado.inserirCPF_CNPJ(financiado.CNPJInvalido);
		financiado.tipoPessoa("fisico");
		financiado.inserirConjuge(financiado.conjugeJuridico);
		financiado.inserirMãe(financiado.mãeJuridico);
		financiado.inserirPai(financiado.paiJuridico);
		Thread.sleep(1000);
		financiado.clicarConfirmar();
		financiado.esperarCssSelector(".textoAlerta");
		String mensagemErro = financiado.mensagem(".textoAlerta");
		financiado.validarMensagem("CPF/CNPJ:  " + financiado.CNPJInvalido + " inválido!", mensagemErro);
		financiado.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}

	// @Test //incompleto
	public void cadastroFinanciadoViaCargaPadrão() throws InterruptedException {
		driver.findElement(By.cssSelector(".itemRecepcoes > a:nth-child(1)")).click();
		driver.findElement(By.cssSelector("#submenu_recepcoes > li:nth-child(2)")).click();
		Thread.sleep(1000);
		WebElement comboRotina = driver.findElement(By.id("selRotina"));
		Select selecionarRotina = new Select(comboRotina);
		selecionarRotina.selectByVisibleText("PADRÃO");
		Thread.sleep(1000);
		WebElement comboRecepção = driver.findElement(By.id("selRecepcao"));
		Select selecionarRecepção = new Select(comboRecepção);
		selecionarRecepção.selectByVisibleText("Recepção de Contratos");
		Thread.sleep(1000);
		WebElement comboGrupo = driver.findElement(By.id("selGrupo"));
		Select selecionarGrupo = new Select(comboGrupo);
		selecionarGrupo.selectByVisibleText("Cristhofer");
		// driver.findElement(By.id("selGrupo")).sendKeys("Cristhofer");
		Thread.sleep(3000);
		driver.findElement(By.id("file"))
				.sendKeys("C:\\Users\\cristhofer.mian.PH3A\\Desktop\\Teste_Basico\\Cadastro_financiado2.xls");
		Thread.sleep(3000);
		driver.findElement(By.id("btnProcessar")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".caixa_bottom > a:nth-child(1) > span:nth-child(2)")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(600));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.cssSelector("#recep_111 > span:nth-child(2) > a:nth-child(2)")));

		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[7]/div[3]/div[3]/div/div[1]/span[2]/a")).click();

		WebElement comboLog = driver.findElement(By.id("cbLogRecepcao"));
		Select selecionarLog = new Select(comboLog);
		selecionarLog.selectByVisibleText(dataAtual + " - Resumo");

		driver.findElement(By.id("btnLogVisualizar")).click();
		// falta estratégia para visualizar log
	}
}
