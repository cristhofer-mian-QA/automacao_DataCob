import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_A_Cadastrar_Fase {
	WebDriver driver;
	public Variaveis_A_Cadastrar_Fase (WebDriver driver) {
		this.driver = driver;
	}
	String faseAM = "AM";
	String descFaseAM = "AMIGAVEL";
	String corFaseAM = "3EAD46";
	
	String fasePJ= "PJ";
	String descFasePJ = "Pré-Jurídico";
	String corFasePJ = "FF9933";
	
	String faseJU = "JU";
	String descFaseJU = "JURIDICO";
	String corFaseJU = "FF0000";
	
	//------------------DSL Fase------------------//
	

	public void esperarCssSelector (String cssSelector) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	}
	
	public void clicarFase (String cssSelector) {
		driver.findElement(By.cssSelector(cssSelector)).click();
	}
	
	public void esperarId (String id) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public void clicarAdicionarFase (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void inserirCodFase (String id, String codFase) {
		driver.findElement(By.id(id)).sendKeys(codFase);
	}
	
	public void inserirDescriçãoFase (String id, String descFase) {
		driver.findElement(By.id(id)).sendKeys(descFase);
	}
	
	public void inserirCorFase (String id, String corFase) {
		driver.findElement(By.id(id)).sendKeys(corFase);
	}
	
	public void clicarBotãoConfirmar (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	 String mensagemSucesso (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	 
	 public void validarMensagem (String mensagem, String mensagemSucesso) {
		 Assert.assertEquals(mensagem, mensagemSucesso);
	 }
	 
	 public void clicarBotãoOk (String cssSelector) {
		 driver.findElement(By.cssSelector(cssSelector)).click();
	 }
	
}
