import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_M_Cadastrar_Feriados {
	WebDriver driver;
	public Variaveis_M_Cadastrar_Feriados (WebDriver driver) {
		this.driver = driver;
	}
	
	String dataEstadual = "09/07/2023";
	String descriçãoFeriadoEstadual = "Revolução Constitucionalista";
	String estado = "SP";
	
	String dataMunicipal = "08/12/2022";
	String descriçãoFeriadoMunicipal = "Aniversário Mauá";
	String cepInicial = "09300000";
	String cepFinal = "09399999";
	
	//---------------DSL feriado-------------//

	
	
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

	public void clicarCadastrar (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void selecionarTipoFeriado (String id, String tipoFeriado) throws InterruptedException {
		WebElement tipo = driver.findElement(By.id(id));
		Select selecionarTipo = new Select (tipo);
		selecionarTipo.selectByVisibleText(tipoFeriado);
		Thread.sleep(500);
	}

	public void inserirData (String id, String data) {
		driver.findElement(By.id(id)).sendKeys(data);
	}

	public void selecionarEstado (String id, String estado) {
		WebElement comboEstado = driver.findElement(By.id(id));
		Select selecionarEstado = new Select (comboEstado);
		selecionarEstado.selectByVisibleText(estado);
	}

	public void nãoClicarFeriadoMovel (String id) {
		WebElement checkBox = driver.findElement(By.id(id));
		if (checkBox.isSelected()) {
			checkBox.click();
		}
	}

	public void nãoClicarAvisaCobrança (String id) {
		WebElement checkBox = driver.findElement(By.id(id));
		if (checkBox.isSelected()) {
			checkBox.click();
		}
	}

	public void inserirDescrição (String id, String descrição) {
		driver.findElement(By.id(id)).sendKeys(descrição);
	}

	public void clicarConfirmar (String css) {
		driver.findElement(By.cssSelector(css)).click();
	}
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem , mensagemConfirmação);
		Thread.sleep(1100);
	}

	public void inserirCepInicio (String id, String cepInicio) {
		driver.findElement(By.id(id)).sendKeys(cepInicio);
	}
	
	public void inserirCepFinal (String id, String cepFinal) {
		driver.findElement(By.id(id)).sendKeys(cepFinal);
	}
}
