import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_K_Cadastrar_Custas {
	WebDriver driver;
	public Variaveis_K_Cadastrar_Custas (WebDriver driver) {
		this.driver = driver;
	}
	
	String codCustaSistema = "14456";
	String descrição = "Motoboy";
	String valor = "20,00";
	String nomeTabela = "Tabela Aut";
	String codCustaCliente = "4456";

	
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
		Thread.sleep(600);
	}
	
	public void clicarOkXpath (String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clicarOkcss (String cssSelector) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep(1500);
	}
	
	public void clicarAdicionar (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void inserirCodCusta (String id, String codigo) {
		driver.findElement(By.id(id)).sendKeys(codigo);
	}
	
	public void inserirDescrição (String id, String descrição) throws InterruptedException {
		driver.findElement(By.id(id)).sendKeys(descrição);
		Thread.sleep(500);
	}
	
	public void selecionarCobrarDe (String id, String texto) throws InterruptedException {
		WebElement comboboxCobrarDe = driver.findElement(By.id(id));
		Select selecionarCobrarDe = new Select (comboboxCobrarDe);
		selecionarCobrarDe.selectByVisibleText(texto);
		Thread.sleep(500);
	}
	
	public void inserirValor (String id, String valor) throws InterruptedException {
		driver.findElement(By.id(id)).sendKeys(valor);
		Thread.sleep(500);
	}
	
	public void checkboxAtiva (String id) throws InterruptedException {
		WebElement ativa = driver.findElement(By.id(id));
		if (ativa.isSelected()) {
		} else {
			ativa.click();
		}
		Thread.sleep(600);
	}
	
	public void clicarConfirmarCss(String css) {
		driver.findElement(By.cssSelector(css)).click();
	}
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem , mensagemConfirmação);
		Thread.sleep(1000);
	}
	
	public void clicarAdicionarTabela(String id) {
		driver.findElement(By.id(id)).click();
	}
 	
	public void inserirNomeTabela (String id, String nomeTabela) throws InterruptedException {
		driver.findElement(By.id(id)).sendKeys(nomeTabela);
		Thread.sleep(600);
	}
	
	public WebElement tabelaCustas (String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	protected int idLinha(String nomeTabelaCusta, WebElement tabelaCustas) {
		List<WebElement> linhasTabela = tabelaCustas.findElements(By.xpath("./tbody/tr/td[3]"));
		int numeroLinha = 0;
		for(int i = 0; i <=linhasTabela.size(); i++) {
			if(linhasTabela.get(i).getText().equals(nomeTabelaCusta)) {
			numeroLinha = i+2;
			break;
			}
		}
		return numeroLinha;
	}
	
	protected int idLinhaCustas(String nomeTabelaCusta, WebElement tabelaCustas) {
		List<WebElement> linhasTabela = tabelaCustas.findElements(By.xpath("./tbody/tr/td[2]"));
		int numeroLinha = 0;
		for(int i = 0; i <=linhasTabela.size(); i++) {
			if(linhasTabela.get(i).getText().equals(nomeTabelaCusta)) {
			numeroLinha = i+2;
			break;
			}
		}
		return numeroLinha;
	}
	
	public void clicarAdicionarTipo (String id) throws InterruptedException {
		driver.findElement(By.id(id)).click();
		Thread.sleep(600);
	}
	
	public void selecionarCobrador (String id, String cobrador) {
		WebElement comboCobrador = driver.findElement(By.id(id));
		Select selecionarCobrador = new Select (comboCobrador);
		selecionarCobrador.selectByVisibleText(cobrador);
	}

	public void selecionarCusta (String id, String codigoSistema, String descrição) {
		WebElement comboCustas = driver.findElement(By.id(id));
		Select selecionarCusta = new Select (comboCustas);
		selecionarCusta.selectByVisibleText(codigoSistema + " - " + descrição);
	}	
	
	public void clicarGravarTipo (String id) throws InterruptedException {
		driver.findElement(By.id(id)).click();
		Thread.sleep(600);
	}

	
	/*----------------DSL vincular ocorrencia cliente --------------*/

	public void clicarBotãoVincular (String id ) throws InterruptedException {
		driver.findElement(By.id(id)).click();
		Thread.sleep(500);
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
		List<WebElement> valida = driver.findElements(By.xpath("//*[@id=\"treeDespesas\"]/ul/li"));
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
