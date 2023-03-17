import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_E_Cadastrar_Boleto_Envio {
	WebDriver driver;
	public Variaveis_E_Cadastrar_Boleto_Envio (WebDriver driver) {
		this.driver = driver;
	}
	
	String descrição = "Boleto Automação";
	
	//---------------DSL envio boleto-------------//

	public void esperarCssSelector (String cssSelector) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	}
	
	public void esperarId (String id) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public void esperarXPATH (String xpath) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void clicarBotãoCadastra () {
		driver.findElement(By.id("btnCadastrar")).click();
	}
	
	public void inserirDescrição (String descrição) {
		driver.findElement(By.id("desc_Conf")).sendKeys(descrição);
	}
	
	public void clicarImpressãoLocal () {
		WebElement habilitarImpressaoLocal = driver.findElement(By.id("L_Imprimir"));
		if(habilitarImpressaoLocal.isSelected()) {
		} else {
			habilitarImpressaoLocal.click();
		}
	}
	
	public void nãoClicarCartaBoleto () {
		WebElement exibirCartaBoleto = driver.findElement(By.id("UrlLinkExternoboleto"));
		if(exibirCartaBoleto.isSelected()) {
			exibirCartaBoleto.click();
		}
	}
	
	public void clicarEmailDesativado () {
		driver.findElement(By.id("E_Desativado")).click();
	}
	
	public void clicarSMSDesativado () {
		driver.findElement(By.id("S_Desativar")).click();
	}
	
	public void clicarDocumentoAPPDesativado () {
		driver.findElement(By.id("D_Desativar")).click();
	}
	
	public void clicarFaxDesativado () {
		driver.findElement(By.id("F_Desativado")).click();
	}
	
	public void clicarSalvar () {
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
	
	public WebElement tabelaBoleto (String descrição) throws InterruptedException { 
		WebElement tabelaBoleto = driver.findElement(By.xpath("//*[@id=\'gridBoleto\']/table/tbody/tr[2]/td/div/div/table"));
		int idLinha = numeroLinha(descrição ,tabelaBoleto);
		WebElement boletoSelecionado = tabelaBoleto.findElement(By.xpath(".//tr[" +  idLinha + "]/td[2]"));
			Thread.sleep(3000);
		boletoSelecionado.click();
		return boletoSelecionado;
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
	
	
	//------------DSL vincular envio boleto------------//

	
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
	
	protected String validarVinculo(String nomeGrupo, String id) {
		List<WebElement> valida = driver.findElements(By.xpath("//*[@id=\"treeBoleto\"]/ul/li"));
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
