import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_O_Cadastrar_Andamento_Sistema {
	WebDriver driver;
	public Variaveis_O_Cadastrar_Andamento_Sistema (WebDriver driver) {
		this.driver = driver;
	}

	String cod_ocorrência = "123";
	String descrição = "Obriga_Anexo";
	String diasAlerta = "0";
		
	
	
	//---------------DSL andamento processo-------------//
	
	
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
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}

	public void validarMensagem (String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem, mensagemConfirmação);
		Thread.sleep(1100);
	}
	
	public void clicarAdicionarOcorrência (String css) throws InterruptedException {
		 driver.findElement(By.cssSelector(css)).click();
		 Thread.sleep(500);
	}
	
	public void inserirCodOcorrencia (String id, String codOcorrencia) {
		driver.findElement(By.id(id)).sendKeys(codOcorrencia);
	}
	
	public void marcarAPI (String id) {
		WebElement flagUtilizarAPI = driver.findElement(By.id(id));
		if(flagUtilizarAPI.isSelected()) {
		} else {
			flagUtilizarAPI.click();
		}
	}
	
	public void semComplemento (String id, int index) {
		WebElement comboTipo = driver.findElement(By.id(id));
		Select selecionarTipo = new Select (comboTipo);
		selecionarTipo.selectByIndex(index);
	}
	
	public void diasAlerta (String id, String diasAlerta) {
		driver.findElement(By.id(id)).sendKeys(diasAlerta);
	}
	
	public void nãoClicarEnviarCliente (String id) {
		WebElement enviarCliente = driver.findElement(By.id(id));
		if (enviarCliente.isSelected()) {
			enviarCliente.click();
		}
	}
	
	public void selecionarFaseProcesso (String id, String descriçãoFase) {
		WebElement comboFase = driver.findElement(By.id(id));
		Select selecionarFase = new Select (comboFase);
		selecionarFase.selectByVisibleText(descriçãoFase);
	}
	
	
}
