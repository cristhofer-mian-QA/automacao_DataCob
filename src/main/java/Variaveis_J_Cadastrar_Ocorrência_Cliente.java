import java.time.Duration;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_J_Cadastrar_Ocorrência_Cliente {

	WebDriver driver;
	public Variaveis_J_Cadastrar_Ocorrência_Cliente (WebDriver driver) {
		this.driver = driver;
	}
	
	String nomeTabelaOcorrencia = "tabelaAutomação";
	String codOcorrenciaCliente = "04445";
	String codOcorrenciaClienteAlteraStatus = "1242";
	String descOcorrenciaClienteAlteraStatus = "Retornar - alterar status";
	String descOcorrenciaClienteNãoAlteraStatus = "Retornar - sem alterar status";
	String tipo = "Data e Hora";
	String complemento = "Insira dt e hora";
	
	
	//---------------DSL ocorrencia cliente-------------//

		
	
	public void esperarXPATH (String xpath) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void esperarCssSelector (String cssSelector) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	}
	
	public void esperarId (String id) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		Thread.sleep(1000);
	}
	
	public void clicarOkXpath (String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clicarOkcss (String cssSelector) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep(1500);
	}

	public void clicarAdicionarTabela (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void inserirNomeTabela (String id, String nomeTabela) throws InterruptedException {
		driver.findElement(By.id(id)).sendKeys(nomeTabela);
		Thread.sleep(500);
	}
	
	public WebElement tabelaOcorrencia (String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	protected int idLinha(String nomeTabelaOcorrencia, WebElement tabelaOcorrencia) {
		List<WebElement> linhasTabela = tabelaOcorrencia.findElements(By.xpath("./tbody/tr/td[3]"));
		int numeroLinha = 0;
		for(int i = 0; i <=linhasTabela.size(); i++) {
			if(linhasTabela.get(i).getText().equals(nomeTabelaOcorrencia)) {
			numeroLinha = i+2;
			break;
			}
		}
		return numeroLinha;
	}
	
	public void clicarAdicionarOcorrência (String id) throws InterruptedException {
		driver.findElement(By.id(id)).click();
		Thread.sleep(500);
	}
	
	public void inserirCodido (String id, String codigo) throws InterruptedException {
		driver.findElement(By.id(id)).sendKeys(codigo);
		Thread.sleep(500);
	}
	
	public void inserirDescrição (String id, String descrição) throws InterruptedException {
		driver.findElement(By.id(id)).sendKeys(descrição);
		Thread.sleep(500);
	}
	
	public void nãoEnviarCliente (String id) {
		WebElement enviarCliente = driver.findElement(By.id(id));
		if(enviarCliente.isSelected()) {
			enviarCliente.click();
		}
	}
	
	public void checkBoxTodasFases (String id) {
		WebElement checkBox = driver.findElement(By.id(id));
		if (checkBox.isSelected()) {
		} else {
			checkBox.click();
		}
	}
	
	public void comboTipo (String id, String tipo) throws InterruptedException {
		WebElement comboTipo = driver.findElement(By.id(id));
		Select selecionarTipo = new Select (comboTipo);
		selecionarTipo.selectByVisibleText(tipo);
		Thread.sleep(600);
	}
	
	public void inserirComplemento (String id, String descrição) {
		driver.findElement(By.id(id)).sendKeys(descrição);
	}
	
	public void comboValidarComplemento (String id, String complemento) throws InterruptedException {
		WebElement comboComplemento = driver.findElement(By.id(id));
		Select selecionarComplemento = new Select (comboComplemento);
		selecionarComplemento.selectByVisibleText(complemento);
		Thread.sleep(600);
	}
	
	public WebElement tabelaOcorrenciaSistema (String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	protected int idLinhaOc(String nomeTabelaOcorrencia, WebElement tabelaOcorrencia) {
		List<WebElement> linhasTabela = tabelaOcorrencia.findElements(By.xpath("./tbody/tr/td[2]"));
		int numeroLinha = 0;
		for(int i = 0; i <=linhasTabela.size(); i++) {
			if(linhasTabela.get(i).getText().equals(nomeTabelaOcorrencia)) {
			numeroLinha = i+2;
			break;
			}
		}
		return numeroLinha;
	}
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem , mensagemConfirmação);
		Thread.sleep(1100);
	}
	
	public void clicarConfirmar (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	
	/*----------------DSL vincular ocorrencia cliente --------------*/
	
	
	
	
	public WebElement tabelaOc (String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	protected int linhaOc(String descriçãoOC, WebElement tabelaOC) {
		List<WebElement> linhasRecibo = tabelaOC.findElements(By.xpath("./tbody/tr/td[2]"));
		int numeroLinha = 0;
		for(int i = 0; i<=linhasRecibo.size(); i++) {
			if(linhasRecibo.get(i).getText().equals(descriçãoOC)) {
				numeroLinha = i+2;
				break;
			}
		}
		return numeroLinha;
	}
	
	public void clicarVincular () {
		driver.findElement(By.id("chamaVincula")).click();
	}
	
	public void selecionarGrupo (String id, String nomeGrupo) throws InterruptedException {
		WebElement comboGrupo = driver.findElement(By.id(id));
		Select selecionarGrupo = new Select (comboGrupo);
		selecionarGrupo.selectByVisibleText(nomeGrupo);
			Thread.sleep(1200);
	}
	
	public void selecionarCliente (String id, String nomeResumido) throws InterruptedException {
		WebElement comboCliente = driver.findElement(By.id(id));
		Select selecionarCliente = new Select (comboCliente);
		selecionarCliente.selectByVisibleText(nomeResumido);
			Thread.sleep(1200);
	}
	
	public void clicarCheckBox (String cssSelector) {
		WebElement checkBox = driver.findElement (By.cssSelector(cssSelector));
		if (checkBox.isSelected()) {
		} else {
			checkBox.click();
		}
	}
	
	protected String validarVinculo(String nomeGrupo, String id) {
		List<WebElement> valida = driver.findElements(By.xpath("//*[@id=\'treeOcorrencia\']/ul/li"));
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
