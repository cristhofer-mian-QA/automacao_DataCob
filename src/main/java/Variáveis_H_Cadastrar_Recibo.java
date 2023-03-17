import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variáveis_H_Cadastrar_Recibo {
	WebDriver driver;
	public Variáveis_H_Cadastrar_Recibo (WebDriver driver) {
		this.driver = driver;
	}
	String descriçãoRecibo = "Recibo Automação";
	String baixaVencimento = "0";
	
	
	//---------------DSL recibo-------------//
	
	

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
		driver.findElement(By.id("inputPadrao")).sendKeys(descrição);
	}
	
	public void clicarCheckBoxVincendaDataCob () {
		WebElement NegociarVincendasDataCob = driver.findElement(By.id("parcelasVincendas"));
		if(NegociarVincendasDataCob.isSelected()) {
		} else {
			NegociarVincendasDataCob.click();
		}
	}
	
	public void clicarCheckBoxVincendaDataPact () {
		WebElement NegociarVincendasDataPact = driver.findElement(By.id("parcelasVincendasDataPact"));
		if(NegociarVincendasDataPact.isSelected()) {
		} else {
			NegociarVincendasDataPact.click();
		}
	}
	
	public void nãoMarcarRepasseObrigatório () {
		WebElement repasseObrigatorio = driver.findElement(By.id("bolRepasseObrigatorio"));
		if(repasseObrigatorio.isSelected()) {
			repasseObrigatorio.click();			
		}
	}
	
	public void inserirBaixaApósVencimento (String dias) {
		driver.findElement(By.id("bolDiasBaixaVenc")).sendKeys(dias);
	}
	
	public void clicarAçãoApósVencimento () throws InterruptedException {
		driver.findElement(By.id("Devolver_Inibir_Nenhum")).click();
		Thread.sleep(500);	
	}
	
	public void clicarSeleçãoParcelas () throws InterruptedException {
		driver.findElement(By.id("Selecao_Parcela_Livre")).click();
		Thread.sleep(500);
	}
	
	public void clicarOkXpath (String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clicarOkcss (String cssSelector) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep(1500);
	}
	
	public WebElement tabelaRecibo (String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	protected int linhaRecibo(String descriçãoRecibo, WebElement tabelaRecibo) {
		List<WebElement> linhasRecibo = tabelaRecibo.findElements(By.xpath("./tbody/tr/td[2]"));
		int numeroLinha = 0;
		for(int i = 0; i<=linhasRecibo.size(); i++) {
			if(linhasRecibo.get(i).getText().equals(descriçãoRecibo + " - Negocia Parcela Vincenda")) {
				numeroLinha = i+2;
				break;
			}
		}
		return numeroLinha;
	}
	
	
	//------------DSL vincular recibo------------//
	
	
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
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem , mensagemConfirmação);
		Thread.sleep(1100);
	}
	
	public WebElement tabelaRecibo () {
		WebElement tabelaRecibo = driver.findElement(By.xpath("//*[@id=\'gridRecibo\']/table/tbody/tr[2]/td/div/div/table"));
		return tabelaRecibo;
	}
	
	
	protected int numeroLinha(String descrição, WebElement tabelaRecibo) {
		List<WebElement> linhas = tabelaRecibo.findElements(By.xpath("./tbody/tr/td[2]"));
		int numLinha = 0;
		for (int i = 0; i<=linhas.size(); i++) {
			if (linhas.get(i).getText().equals(descrição + " - Negocia Parcela Vincenda")) {
				numLinha = i+2;
				break;
			}
		}
		return numLinha;
	}
	
	
	protected String validarVinculo(String nomeGrupo, String id) {
		List<WebElement> valida = driver.findElements(By.xpath("//*[@id=\"treeRecibo\"]/ul/li"));
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
