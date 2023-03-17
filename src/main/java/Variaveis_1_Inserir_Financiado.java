import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v102.indexeddb.model.Key;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Return;

public class Variaveis_1_Inserir_Financiado {
	WebDriver driver;
	
	public Variaveis_1_Inserir_Financiado (WebDriver driver) {
		this.driver = driver;
	}
	
	//--------------Física--------------//
	String nome = "Felipe Araújo Melo";
	String dataNascimento = "17/02/1989";
	String score = "759";
	String cpf = "265.478.759-11";
	String conjuge = "Rebeca Fernanda Ribeiro";
	String mãe = "Odete Gonzaga Lima";
	String pai = "Alziro Paulo Gonzaga";
	String RG = "10.816.975-3";
	String dataEmissão = "15/12/2020";
	String emissor = "SSP";
	String cpfInvalido = "99985";
	
	//--------------Jurídica--------------//
	String nomeJuridico = "Caio Henrique Martins";
	String dataNascimentoJuridico = "27/05/1989";
	String scoreJuridico = "989";
	String CNPJ = "98.677.637/0001-11";
	String conjugeJuridico = "Taliandra Fernanda Ribeiro";
	String mãeJuridico = "Tereza Gonzaga Lima";
	String paiJuridico = "Roberto Paulo Gonzaga";
	String RGJuridico = "10.816.975-3";
	String CNPJInvalido = "99985";
	
	
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
	
	public void clicarNovoFinanciado () {
		driver.findElement(By.id("buttonNovoFinanciado")).click();
	}
	
	public void inserirNome (String nome) {
		driver.findElement(By.id("nome")).sendKeys(nome);
	}
	
	public void inserirDataNascimento (String data) {
		driver.findElement(By.id("dtNascimento")).sendKeys(data);
	}
	
	public void limparEnriquecimento () {
		WebElement dataEnriquecimento = driver.findElement(By.id("dtEnrichment"));
		dataEnriquecimento.clear();
	}
	
	public void selecionarSexo (String id) throws InterruptedException {
		WebElement sexo = driver.findElement(By.id(id));
		if (sexo.isSelected()) {
		} else {
			sexo.click();
		}
		Thread.sleep(500);
	}
	
	public void selecionarGrupo (String nomeGrupo) {
		WebElement grupo = driver.findElement(By.id("listGrupo"));
		Select selecionarGrupo = new Select (grupo);
		selecionarGrupo.selectByVisibleText(nomeGrupo);
	}
	
	public void selecionarCliente (String nomeCliente) {
		WebElement grupo = driver.findElement(By.id("listCliente"));
		Select selecionarGrupo = new Select (grupo);
		selecionarGrupo.selectByVisibleText(nomeCliente);
	}
	
	public void inserirScore (String score) {
		driver.findElement(By.id("scoreSerasa")).sendKeys(score);
	}
	
	public void escolherEstadoCivil(String estadoCivil) {
		WebElement ComboGrupo = driver.findElement(By.id("estCivil"));
		Select selecionar = new Select(ComboGrupo);
		selecionar.selectByVisibleText(estadoCivil);
	 }
	
	public void inserirRG (String rg) {
		driver.findElement(By.id("rg")).sendKeys(rg);
	 }
	 
	public void inserirDtEmissão (String emissão) {
		driver.findElement(By.id("dtEmissRG")).sendKeys(emissão);
	}
	 
	public void inserirEmissor (String emissor) {
		 driver.findElement(By.id("orgaoEmissRG")).sendKeys(emissor);
	}
	 
	public void selecionarUF (String uf) {
		WebElement UF = driver.findElement(By.id("ufEmissRG"));
		Select selecionarUF = new Select (UF);
		selecionarUF.selectByVisibleText(uf);
	} 
	 
	public void inserirCPF_CNPJ (String cpf_Cnpj) throws InterruptedException {
		WebElement cpf_cnpj =  driver.findElement(By.id("cpf"));
		cpf_cnpj.clear();
		Thread.sleep(200);
		cpf_cnpj.sendKeys(cpf_Cnpj);
	 }
	
	public void tipoPessoa (String id) {
		WebElement comboPessoa = driver.findElement(By.id(id));
		if (comboPessoa.isSelected()) {
		} else {
			comboPessoa.click();
		}
	}
	 
	public void inserirConjuge (String conjuge) {
			driver.findElement(By.id("conjuge")).sendKeys(conjuge);
		}
	
	public void inserirMãe (String mãe) {
			driver.findElement(By.id("mae")).sendKeys(mãe);
		}
		
	public void inserirPai (String pai) {
			driver.findElement(By.id("pai")).sendKeys(pai);
		}
		
	String mensagem(String cssSelector) {
			return driver.findElement(By.cssSelector(cssSelector)).getText();
		}

	public void validarMensagem(String mensagem, String mensagemConfirmação) throws InterruptedException {
		 Assert.assertEquals(mensagem, mensagemConfirmação);
		 Thread.sleep(1100);
	 }
	 
	public void clicarConfirmar () {
		driver.findElement(By.cssSelector("#buttonsForm > a:nth-child(2)")).click();
	}
	 
	 
	 
	 
	
	
	public void dataAtual () {
		Date data = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		String data1 = formatador.format(data);
	}
	
	
	
	/*public void gerarNomeAleatorio() {
		//gerar um NOME aleatório 
		 ChromeDriver nome_site = new ChromeDriver();
		 nome_site.get("https://fossbytes.com/tools/random-name-generator");
		 nome_site.manage().window().maximize();
		 JavascriptExecutor js1 = (JavascriptExecutor) nome_site;
		 js1.executeScript("window.scrollBy(0,7000)");
		 nome_site.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 nome_site.findElement(By.id("totalNames")).sendKeys("1");
		 nome_site.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 WebElement comboLinguagem = nome_site.findElement(By.id("language"));
		 Select selecionar = new Select(comboLinguagem);
		 selecionar.selectByIndex(4);
		 nome_site.findElement(By.id("male")).click();
		 nome_site.findElement(By.cssSelector("body > div > div.container-lg.content-container > div > div.main-tool > div.row > div > div > form > div:nth-child(4) > div > button")).click();
		 nome_site.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		 WebElement NOME = nome_site.findElement(By.cssSelector("body > div.container-fluid.f-base-container > div.container-lg.content-container > div > div.main-tool > div.row > div > div.card > div.card-body > ul"));
		 String nome = NOME.getAttribute("value");
		 nome_site.close();
		 WebElement colarNOME = driver.findElement(By.id("nome"));
		 colarNOME.clear();
		 colarNOME.sendKeys(nome); 
	 }*/
	
 public void escreverElementosNome(String nome_campo, String texto) {
	 driver.findElement(By.name(nome_campo)).sendKeys(texto);
 }
 
 public void escreverElementosId(String id_campo, String texto) {
	 driver.findElement(By.id(id_campo)).sendKeys(texto);
 }
 
 public void clicarRadioButton (String Id_campo) {
	 driver.findElement(By.id(Id_campo)).click();
 }
 
 public void selecionarCombo (String id, String valor) {
		WebElement element = driver.findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
 }
 
 public void escolherGrupoCadastroFInanciado(String valor) {
	 WebElement ComboGrupo = driver.findElement(By.id(""));
	 Select selecionar = new Select(ComboGrupo);
	 selecionar.selectByValue(valor);
 }
 

 
 public void escolherClienteCadastroFInanciado(String valor) {
	 WebElement ComboCliente = driver.findElement(By.id("listCliente"));
	 Select selecionar = new Select(ComboCliente);
	 selecionar.selectByValue(valor);
 }
 
 
 public void teclaEnter (String identificador) {
	 WebElement confirmar = driver.findElement(By.cssSelector("#buttonsForm > a.btnPadrao.btnVerde"));
	 Actions action = new Actions (driver);
	 action.moveToElement(confirmar)
	 	.sendKeys(Keys.ENTER)
	 	.perform();
 }
 
 public void clicarBotaoPorId(String id) {
	 driver.findElement(By.id(id)).click();
 }
 
}
