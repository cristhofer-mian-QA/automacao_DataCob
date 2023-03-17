import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_N_Cadastrar_Fase_Processo {
	WebDriver driver;

	public Variaveis_N_Cadastrar_Fase_Processo(WebDriver driver) {
		this.driver = driver;
	}

	String descFaseEncerraProcesso = "Fase Encerra Processo";
	String descFaseNãoEncerraProcesso = "Fase Não Encerra Processo";
	String descFaseNãoEncProcCancelaAcordo = "Fase Bloqueia Acordo";
	String descNãoAlteraFase = "Não Altera Fase";

	

	// ---------------DSL andamento sistema-------------//

	public void esperarXPATH(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void esperarCssSelector(String cssSelector) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	}

	public void esperarId(String id) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		Thread.sleep(1000);
	}

	public void clicarOkXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void clicarOkcss(String cssSelector) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep(1500);
	}

	String mensagem(String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}

	public void validarMensagem(String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem, mensagemConfirmação);
		Thread.sleep(1100);
	}

	public void clicarIncluir(String id) throws InterruptedException {
		driver.findElement(By.id(id)).click();
		Thread.sleep(500);
	}

	public void inserirDescrição(String id, String descrição) {
		driver.findElement(By.id(id)).sendKeys(descrição);
	}

	public void alterarFase(String id, String fase) {
		WebElement comboFase = driver.findElement(By.id(id));
		Select selecionarFase = new Select(comboFase);
		selecionarFase.selectByVisibleText(fase);
	}

	public void clicarEncerraProcesso(String id) {
		WebElement flagEncerraProcesso = driver.findElement(By.id(id));
		if (flagEncerraProcesso.isSelected()) {
		} else {
			flagEncerraProcesso.click();
		}
	}

	public void nãoClicarEncerraProcesso(String id) {
		WebElement flagEncerraProcesso = driver.findElement(By.id(id));
		if (flagEncerraProcesso.isSelected()) {
			flagEncerraProcesso.click();
		}
	}

	public void nãoClicarBloquearAcordo(String id) {
		WebElement flagEncerraAcordo = driver.findElement(By.id(id));
		if (flagEncerraAcordo.isSelected()) {
			flagEncerraAcordo.click();
		}
	}

	public void clicarBloquearAcordo(String id) {
		WebElement flagEncerraAcordo = driver.findElement(By.id(id));
		if (flagEncerraAcordo.isSelected()) {
		}else {
			flagEncerraAcordo.click();
		}
	}
	
	public void clicarConfirmar(String id) {
		driver.findElement(By.id(id)).click();
	}
	
	
	
	
}
