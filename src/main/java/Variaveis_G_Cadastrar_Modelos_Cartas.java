import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_G_Cadastrar_Modelos_Cartas {

	WebDriver driver;
	public Variaveis_G_Cadastrar_Modelos_Cartas (WebDriver driver) {
		this.driver = driver;
	}
	String corpo = " Teste automação \n Modelo Acordo \n Teste Automação ";
	String descrição = "Modelo Automação";
	String assunto = "Modelo carta automação";
	String descParametro = "Parâmetro automação";

	//---------------DSL modelo carta-------------//
	
	
	
	
	
	
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
		Thread.sleep(500);
	}
	
	public void clicarOkXpath (String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clicarOkcss (String cssSelector) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep(1500);
	}

	public void clicarNovoModelo (String id) throws InterruptedException {
		driver.findElement(By.id(id)).click();	
		Thread.sleep(1000);
	} 
	
	public void inserirCorpo (String cssSelector, String corpo) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).sendKeys(corpo);
		Thread.sleep(1200);
	}
	
	public void clicarSalvar () {
		driver.findElement(By.id("salvar")).click();
	}
	
	public void inserirDescrição (String cssSelector, String descrição) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).sendKeys(descrição);
		Thread.sleep(1000);
	}

	public void inserirDescriçãoId (String id, String descrição) throws InterruptedException {
		driver.findElement(By.id(id)).sendKeys(descrição);
		Thread.sleep(1000);
	}
	
	public void inserirAssunto (String cssSelector, String assunto) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).sendKeys(assunto);
		Thread.sleep(1000);
	}
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem , mensagemConfirmação);
		Thread.sleep(1100);
	}
	
	public void clicarComboModelo (String id) throws InterruptedException {
		driver.findElement(By.id(id)).click();
		Thread.sleep(1000);
	}
	
	protected int numeroLinha() {
		List<WebElement> comboModelo = driver.findElements(By.xpath("//*[@id=\"listModelAdress_ul_filter\"]/li"));
		int nLinha = 0;
		for (int i = 0; i<=comboModelo.size(); i++) {
			if ( i == comboModelo.size()) {
				nLinha = i;
			}
		}
		return nLinha;
	}
	
	public WebElement buscarModelo (int numLinha) {
		return driver.findElement(By.xpath("//*[@id=\'listModelAdress_ul_filter\']/li[" + numLinha + "]"));
	}

	
	public void selecionarModeloNegociação (String id, String texto) {
		WebElement modeloNegociação = driver.findElement(By.id(id));
		Select selecionarModeloNegociação = new Select (modeloNegociação);
		selecionarModeloNegociação.selectByVisibleText(texto);
	}
	
	public void selecionarModeloAcordoVista (String id, String texto) {
		WebElement modeloAcordoVista = driver.findElement(By.id(id));
		Select selecionarModeloAcordoVista = new Select (modeloAcordoVista);
		selecionarModeloAcordoVista.selectByVisibleText(texto);
	}

	public void selecionarModeloAcordoParcelado (String id, String texto) {
		WebElement modeloAcordoParcelado = driver.findElement(By.id(id));
		Select selecionarModeloAcordoParcelado = new Select (modeloAcordoParcelado);
		selecionarModeloAcordoParcelado.selectByVisibleText(texto);
	}

	public void selecionarModeloBoletagem (String id, String texto) {
		WebElement modeloBoletagem = driver.findElement(By.id(id));
		Select selecionarModeloBoletagem = new Select (modeloBoletagem);
		selecionarModeloBoletagem.selectByVisibleText(texto);
	}
	
	public WebElement tabelaModeloBoleto () {
	return driver.findElement(By.xpath("//*[@id=\"gridBoletoModelo\"]/table/tbody/tr[2]/td/div/div/table"));
	}
	
	protected int idLinha(String parametro, WebElement tabelaBoleto) {
		List<WebElement> linhasTabela = tabelaBoleto.findElements(By.xpath("./tbody/tr/td[2]"));
		int numeroLinha = 0;
		for(int i = 0; i <=linhasTabela.size(); i++) {
			if(linhasTabela.get(i).getText().equals(parametro)) {
			numeroLinha = i+2;
			break;
			}
		}
		return numeroLinha;
	}
	
	public void clicarBotãoCadastrar (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	
	//------------DSL vincular Modelo Boleto------------//

	
	public void clicarVincular () throws InterruptedException {
		driver.findElement(By.id("chamaVincula")).click();
		Thread.sleep(500);
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
	
	public void clicarCheckBox () throws InterruptedException {
		WebElement checkBox = driver.findElement (By.cssSelector("#treeGeral > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)"));
		if (checkBox.isSelected()) {
		} else {
			checkBox.click();
		}
		Thread.sleep(1000);
	}

	
	
	
	
	
}
