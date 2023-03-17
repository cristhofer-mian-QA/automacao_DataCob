import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_L_Cadastrar_Comarca_Forum_Vara {
	WebDriver driver;
	public Variaveis_L_Cadastrar_Comarca_Forum_Vara (WebDriver driver) {
		this.driver = driver;
	}
	
	String descriçãoComarca = "Comarca Automação";
	String descriçãoForum = "Forum automação";
	String descriçãoVara = "Vara Automação";
	String cidade = "São Paulo";
	String bairro = "Morumbi";
	String endereço = "Rua da automação";
	String complemento = "2° andar";
	String CEP = "15655000";
	String DDD = "11";
	String telefone = "997778555";
	String tipovara = "CÍVEL";
	
	
	//---------------DSL comarca/fórum/vara-------------//

	
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

	public void clicarIncluir (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void selecionarEstado (String id, String estado) {
		WebElement comboEstado = driver.findElement(By.id(id));
		Select selecionarEstado = new Select (comboEstado);
		selecionarEstado.selectByVisibleText(estado);
	}
	
	public void inserirDescrição (String id, String descrição) throws InterruptedException {
		driver.findElement(By.id(id)).sendKeys(descrição);
		Thread.sleep(500);
	}
	
	public void clicarConfirmar (String css) throws InterruptedException {
		driver.findElement(By.cssSelector(css)).click();
		Thread.sleep(500);
	}
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem , mensagemConfirmação);
		Thread.sleep(1100);
	}
	
	public WebElement tabela (String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	protected int idLinha(String descrição, WebElement tabela) {
		List<WebElement> linhasTabela = tabela.findElements(By.xpath("./tbody/tr/td[2]"));
		int numeroLinha = 0;
		for(int i = 0; i <=linhasTabela.size(); i++) {
			if(linhasTabela.get(i).getText().equals(descrição)) {
			numeroLinha = i+2;
			break;
			}
		}
		return numeroLinha;
	}
	
	protected int idLinhaForum(String descrição, WebElement tabela) {
		List<WebElement> linhasTabela = tabela.findElements(By.xpath("./tbody/tr/td[1]"));
		int numeroLinha = 0;
		for(int i = 0; i <=linhasTabela.size(); i++) {
			if(linhasTabela.get(i).getText().equals(descrição)) {
			numeroLinha = i+2;
			break;
			}
		}
		return numeroLinha;
	}
	
	public void inserirCidade (String id, String cidade) {
		driver.findElement(By.id(id)).sendKeys(cidade);
	}
	
	public void inserirBairro (String id, String Bairro) {
		driver.findElement(By.id(id)).sendKeys(Bairro);
	}
	
	public void inserirEndereço (String id, String Endereço) {
		driver.findElement(By.id(id)).sendKeys(Endereço);
	}
	
	public void inserirComplemento (String id, String Complemento) {
		driver.findElement(By.id(id)).sendKeys(Complemento);
	}
	
	public void inserirCEP (String id, String CEP) {
		driver.findElement(By.id(id)).sendKeys(CEP);
	}
	
	public void inserirDDD (String id, String DDD) {
		driver.findElement(By.id(id)).sendKeys(DDD);
	}
	
	public void inserirTelefone (String id, String Telefone) throws InterruptedException {
		driver.findElement(By.id(id)).sendKeys(Telefone);
		Thread.sleep(500);
	}
	
	public void selecionarForum (String id, String forum) throws InterruptedException {
		WebElement comboForum = driver.findElement(By.id(id));
		Select selecionarForum = new Select (comboForum);
		selecionarForum.selectByVisibleText(forum);
		Thread.sleep(500);
	}
	
	public void selecionarTipoVara (String id,String tipoVara) throws InterruptedException {
		WebElement comboTipoVara = driver.findElement(By.id(id));
		Select selecionarTipoVara = new Select (comboTipoVara);
		selecionarTipoVara.selectByVisibleText(tipoVara);
		Thread.sleep(500);
	}
	
	
	
}
