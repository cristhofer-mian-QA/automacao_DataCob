import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_A3_Cadastro_Score {
	WebDriver driver;
	public Variaveis_A3_Cadastro_Score (WebDriver driver) {
		this.driver = driver;
	}
	
	String faixaVermelha = "Alto risco";
	String deAltoRisco = "0,02";
	String ateAltoRisco = "333,00";
	String corAltoRisco = "FF4B4B";
	
	String faixaAmarela = "Médio Risco";
	String deMedioRisco = "33301";
	String ateMedioRisco = "70000";
	String corMedioRisco = "FF9933";
	
	String faixaVerde = "Baixo Risco";
	String deBaixoRisco = "70001";
	String ateBaixoRisco = "100000";
	String corBaixoRisco = "3EAD46";
	
	//-----------------------DSL score-----------------------//
	
	public void esperarId (String id) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		Thread.sleep(600);
	}
	
	public void clicarAbaFaixaScore () {
		driver.findElement(By.cssSelector("#abaFaseGeral > ul:nth-child(1) > li:nth-child(2)")).click(); 

	}

	public void esperarCssSelector (String cssSelector) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
		Thread.sleep(600);
	}
	
	public void clicarBotaoAdicinarScore () {
		driver.findElement(By.id("btnAdicionarFaixa")).click();
	}
	
	public void selecionarGrupo (String nomeGrupo) {
		WebElement grupo = driver.findElement(By.id("listGrupo")); 
		Select selecionarGrupo = new Select(grupo); 
		selecionarGrupo.selectByVisibleText(nomeGrupo); 
	}
	
	public void inserirDescriçãoFaixa (String descriçãoFaixa) {
		driver.findElement(By.id("descricaoGrupoFaixa")).sendKeys(descriçãoFaixa);
	}
	
	public void inserirFaixaDe (String faixaDe) {
		driver.findElement(By.id("faixaDe")).sendKeys(faixaDe);
	}
	
	public void inserirFaixaAté (String faixaAté) {
		driver.findElement(By.id("faixaAte")).sendKeys(faixaAté);
	}
	
	public void inserirCor (String cor) {
		driver.findElement(By.id("corFaixaScore")).sendKeys(cor);
	}
	
	public void clicarBotãoConfirar () {
		driver.findElement(By.id("btnConfirmaCadFaixa")).click();
	}

	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) {
		Assert.assertEquals(mensagem , mensagemConfirmação);
	}
	
	public void clicarOk (String cssSelector) {
		driver.findElement(By.cssSelector(cssSelector)).click();
	}
}
