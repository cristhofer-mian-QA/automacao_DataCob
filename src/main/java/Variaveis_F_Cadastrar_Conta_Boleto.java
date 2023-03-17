import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_F_Cadastrar_Conta_Boleto {

	
	WebDriver driver;
	public Variaveis_F_Cadastrar_Conta_Boleto (WebDriver driver) {
		this.driver = driver;
	}
	
	String descrição = "Config Automação";
	
	//---------------DSL conta boleto-------------//

	public void esperarCssSelector (String cssSelector) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	}
		
	
	public void esperarId (String id) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		Thread.sleep(500);
	}
	
	public void esperarXPATH (String xpath) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void clicarBotãoCadastra () {
		driver.findElement(By.id("cadastra")).click();
	}
	
	public void inserirDescrição (String descrição) {
		driver.findElement(By.id("txt_Descricao")).sendKeys(descrição);
	}
	
	public void selecionarBanco ( String banco) throws InterruptedException {
		WebElement comboBanco = driver.findElement(By.id("cp_Banco"));
		Select selecionarBanco = new Select (comboBanco);
		selecionarBanco.selectByVisibleText(banco);
		Thread.sleep(2200);
	}
	
	public void selecionarConta (String conta, String titular) throws InterruptedException {
		WebElement comboConta = driver.findElement(By.id("cp_Conta"));
		Select selecionarConta = new Select (comboConta);
		selecionarConta.selectByVisibleText(conta + " " + titular);
		Thread.sleep(2200);
	}
	
	public void nãoSelecionarRegistroAutomático(String id, String texto) throws InterruptedException {
		WebElement registroAutomatico = driver.findElement(By.id(id));
		Select selecionarRegistroAutomatico = new Select (registroAutomatico);
		selecionarRegistroAutomatico.selectByVisibleText(texto);
		Thread.sleep(2200);
	}
	
	public void limparInstruçõesCNAB () throws InterruptedException {
		driver.findElement(By.id("txt_instrucao_01")).clear();
			Thread.sleep(500);
		driver.findElement(By.id("txt_instrucao_02")).clear();
	}
	
	public void clicarBotãoConfirmar () {
		driver.findElement(By.id("btn_Confirmar")).click();
	}
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem , mensagemConfirmação);
		Thread.sleep(1100);
	}
	
	public void clicarOkXpath (String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clicarOkcss (String cssSelector) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep(1500);
	}
	
	public WebElement tabelaContaBoleto () {
		WebElement tabelaBoleto = driver.findElement(By.xpath("//*[@id=\"gridBoletoConta\"]/table/tbody/tr[2]/td/div/div/table"));
		return tabelaBoleto;
	}
	
	protected int numeroLinha(String descrição, WebElement tabelaBoleto) {
		List<WebElement> linhas = tabelaBoleto.findElements(By.xpath("./tbody/tr/td[2]"));
		int numLinha = 0;
		for (int i = 0; i<=linhas.size(); i++) {
			if (linhas.get(i).getText().equals(descrição)) {
				numLinha = i+2;
				break;
			}
		}
		return numLinha;
	}
	
	
	//------------DSL vincular conta boleto------------//

	
	public void clicarVincular () {
		driver.findElement(By.id("chamaVincula")).click();
	}
	
	public void selecionarGrupo (String nomeGrupo) throws InterruptedException {
		WebElement comboGrupo = driver.findElement(By.id("idSelectIdGrupo"));
		Select selecionarGrupo = new Select (comboGrupo);
		selecionarGrupo.selectByVisibleText(nomeGrupo);
			Thread.sleep(1200);
	}
	
	public void selecionarCliente (String nomeResumido) throws InterruptedException {
		WebElement comboCliente = driver.findElement(By.id("idSelectIdCliente"));
		Select selecionarCliente = new Select (comboCliente);
		selecionarCliente.selectByVisibleText(nomeResumido);
			Thread.sleep(1200);
	}
	
	public void clicarCheckBox () {
		WebElement checkBox = driver.findElement (By.cssSelector("#treeGeral > ul > li > a.myCheckbox"));
		if (checkBox.isSelected()) {
		} else {
			checkBox.click();
		}
	}
	
	public void validarVinculoBoleto (String descrição, String nomeGrupo) throws InterruptedException {
		WebElement tabelaBoleto = driver.findElement(By.xpath("//*[@id=\"gridBoletoConta\"]/table/tbody/tr[2]/td/div/div/table"));
		int idLinha = numeroLinha(descrição ,tabelaBoleto);
		WebElement contaBoletoSelecionado = tabelaBoleto.findElement(By.xpath(".//tr[" +  idLinha + "]/td[1]"));
			Thread.sleep(6000);
		String id = contaBoletoSelecionado.getText();
			Thread.sleep(6000);
		String validar = validarVinculo (nomeGrupo, id);
		Assert.assertEquals("ok", validar);
	}
	
	protected String validarVinculo(String nomeGrupo, String id) {
		List<WebElement> valida = driver.findElements(By.xpath("//*[@id=\"treeBoletoConta\"]/ul/li"));
		String confirma = "";
		for (int i = 0; i<=valida.size(); i++) {
			if(valida.get(i).getText().equals(nomeGrupo + " - " + id)) {
				confirma = "ok";
				break;
			}
		}
		return confirma;
	}
}
