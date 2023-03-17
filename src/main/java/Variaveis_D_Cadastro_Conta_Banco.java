import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_D_Cadastro_Conta_Banco {

	
	WebDriver driver;
	public Variaveis_D_Cadastro_Conta_Banco (WebDriver driver) {
		this.driver = driver;
	}
	
	String banco = "237 - BRADESCO" ;
	String titular = "PH3A";
	String cnpj = "45.402.634/0001-09";
	String endereço = "Rua Cinquenta e Três, 219, Cajupiranga, Parnamirim, RN";
	String agencia = "1234";
	String digitoAgencia = "7";
	String conta = "1591591";
	String digitoConta = "9";
	String codCedente = "1234567";
	String digCedente = "1";
	String carteira = "01";
	String localPagamento = "Pagável em qualquer agencia Lotérica";
	String taxaBancaria = "0";
	String dcto ="DM";
	String nInicial = "01";
	String nFinal ="9999999";
	
	//---------------DSL conta-------------//
	
	public void esperarCssSelector (String cssSelector) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	}
	
	public void esperarId (String id) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public void selecionarBanco (String banco) {
		WebElement comboBanco = driver.findElement(By.id("comboBanco"));
		Select selecionarBanco = new Select(comboBanco);
		selecionarBanco.selectByVisibleText(banco);
	}
	
	public void clicarBotãoNovaConta () {
		driver.findElement(By.id("btn_Cadastrar")).sendKeys(Keys.ENTER);
	}
	
	public void nãoClicarBuscarInfCedente () {
		WebElement buscarInformações = driver.findElement(By.id("BuscarInformacoesCedenteCliente"));
		if(buscarInformações.isSelected()) {
			buscarInformações.click();
		}
	}
	
	public void inserirTitular (String titular) {
		driver.findElement(By.id("titular")).sendKeys(titular);
	}

	public void inserirCpfCnpj (String cpfCnpj) {
		driver.findElement(By.id("CpfCnpj")).sendKeys(cpfCnpj);
	}
	
	public void inserirEndereço (String endereço) {
		driver.findElement(By.id("EnderecoCedente")).sendKeys(endereço);
	}
	
	public void inserirAgencia (String agencia) {
		driver.findElement(By.id("agencia")).sendKeys(agencia);
	}
	
	public void inserirDigAgencia (String digAgencia) {
		driver.findElement(By.id("digitoAgencia")).sendKeys(digAgencia);
	}
	
	public void inserirConta (String conta) {
		driver.findElement(By.id("conta")).sendKeys(conta);
	}
	
	public void inserirDigConta (String digConta) {
		driver.findElement(By.id("digitoConta")).sendKeys(digConta);
	}
	
	public void inserirCodCedente (String codCedente) {
		driver.findElement(By.id("codCedente")).sendKeys(codCedente);
	}
	
	public void inserirDigCedente (String digCedente) {
		driver.findElement(By.id("digitoCedente")).sendKeys(digCedente);
	}
	
	public void inserirCarteira (String id, String carteira) {
		driver.findElement(By.id(id)).sendKeys(carteira);
	}
	
	public void inserirLocalPagBoleto (String local) {
		driver.findElement(By.id("locPagBoleto")).sendKeys(local);
	}
	
	public void inserirTaxaBancaria (String taxaBancaria) {
		driver.findElement(By.id("taxaBancaria")).sendKeys(taxaBancaria);
	}
	
	public void inserirEspDoc (String espDoc) {
		driver.findElement(By.id("espDcto")).sendKeys(espDoc);
	}
	
	public void limparCIP () {
		driver.findElement(By.id("cod_cip")).clear();
	}
	
	public void nãoClicarPFE () {
		WebElement PFE = driver.findElement(By.id("pfe"));
		if(PFE.isSelected()) {
			PFE.click();
		}
	}
	
	public void nãoClicarAceite () {
		WebElement PFE = driver.findElement(By.id("aceite"));
		if(PFE.isSelected()) {
			PFE.click();
		}
	}
	
	public void limparDiasCancBoleto () {
		driver.findElement(By.id("cancelBoleto")).clear();
	}
	
	public void limparConvênio () {
		driver.findElement(By.id("cod_convenio")).clear();
	}
	
	public void limparPix () {
		driver.findElement(By.id("dptPix")).clear();
	}
	
	public void selecionarCNAB (String CNAB) {
		WebElement cnab = driver.findElement(By.id("leiaute_cnab"));
		Select selecionarCNAB = new Select (cnab);
		selecionarCNAB.selectByVisibleText(CNAB);
	}
	
	public void nãoClicarRegistrarBoleto () {
		WebElement boletoRegistrado = driver.findElement(By.id("boletoRegistrado"));
		if(boletoRegistrado.isSelected()) {
			boletoRegistrado.click();
		}
	}
	
	public void nãoClicarDepIdentificado () {
		WebElement dptIdentificado = driver.findElement(By.id("dptIdentificado"));
		if(dptIdentificado.isSelected()) {
			dptIdentificado.click();
		}
	}
	
	public void clicarAlterarNrBoleto () {
		WebElement chkAlterarNumeroBoleto = driver.findElement(By.id("chkAlterarNumeroBoleto"));
		if(chkAlterarNumeroBoleto.isSelected()) {
		} else {
			chkAlterarNumeroBoleto.click();
		}
	}
	
	public void tipoNrBoleto (String tipo) {
		WebElement tipoNumeracaoBoleto = driver.findElement(By.id("tipoNumeracaoBoleto"));
		Select selecionartipoNumeraçãoBoleto = new Select (tipoNumeracaoBoleto);
		selecionartipoNumeraçãoBoleto.selectByVisibleText(tipo);
	}
	
	public void inserirNrInicial (String NrInicial) {
		driver.findElement(By.id("N_Inicial")).sendKeys(NrInicial);
	}
	
	public void inserirNrFinal (String NrFinal) {
		driver.findElement(By.id("N_Final")).sendKeys(NrFinal);
	}
	
	public void nãoClicarBoletoWebService () {
		WebElement boletoWebService = driver.findElement(By.id("boleto_webServic"));
		if(boletoWebService.isSelected()) {
			boletoWebService.click();
		}
	}
	
	public void nãoClicarEmitirBoleto () {
		WebElement emitirBoleto = driver.findElement(By.id("emitirBoleto"));
		if(emitirBoleto.isSelected()) {
			emitirBoleto.click();
		}
	}
	
	public void nãoClicarNossoNr () {
		WebElement isNossoNumero = driver.findElement(By.id("isNossoNumero"));
		if(isNossoNumero.isSelected()) {
			isNossoNumero.click();
		}
	}
	
	public void limparNossoNr () {
		driver.findElement(By.id("prefixoNossoNr")).clear();
	}
	
	public void limparCodEscritório () {
		driver.findElement(By.id("codEscritorio")).clear();
	}
	
	public void clicarConfirmar () {
		driver.findElement(By.id("btn_Confirmar")).click();
	}
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem , mensagemConfirmação);
		Thread.sleep (1900);
	}
	
	public void clicarOkcss (String cssSelector) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep(1500);
	}
	
	
	
	
	
	
	
}
