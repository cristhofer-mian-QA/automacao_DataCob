import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_A1_Cadastrar_Empresa_Filial {
	WebDriver driver;
	public Variaveis_A1_Cadastrar_Empresa_Filial (WebDriver driver) {
		this.driver = driver;
	}
	String nomeEmpresa = "PH3A";
	String nomeResponsavel = "Cris";
	String nomeFilial = "Automação";
	String nrPosto = "01";
	String cnpj = "84.454.021/0001-77";
	String endereço = "Rua Cora Coralina";
	String bairro = "Recanto";
	String cidade = "Rio das Ostras";
	String uf = "RJ";
	String cep = "28890-510";
	String ddd = "21";
	String telefone = "997959982"; 
	String email = "teste.teste@teste.com";
	String serieFisica = "01";
	String reciboFisica = "00000001";
	String serieEletronica = "01";
	String reciboEletronica = "00000001";
	
	
	//---------------------DSL empresa filial---------------------//
	

	
	
	
	public void esperarId (String id) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	
	public void esperarXpath (String xpath) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void clicarCriarEmpresa (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void inserirRazão (String id, String razão) {
		driver.findElement(By.id(id)).sendKeys(razão);
	}
	
	public void inserirNomeEmpresa (String id, String nomeEmpresa) {
		driver.findElement(By.id(id)).sendKeys(nomeEmpresa);
	}
	
	public void clicarBotãoConfirmar (String cssSelector) {
		driver.findElement(By.cssSelector(cssSelector)).click();
	}
	
	String mensagemSucesso (String cssSelector) { 
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) {
		Assert.assertEquals(mensagem , mensagemConfirmação);
	}
	
	public void clicarBotãoOk(String cssSelector) {
		driver.findElement(By.cssSelector(cssSelector)).click();
	}
	
	public void buscarEmpresaTabela (String nomeEmpresa) {
		WebElement tabela = driver.findElement(By.xpath("//*[@id=\"gridEmpresa\"]/table/tbody/tr[2]/td/div/div/table"));
		int idLinha = obterIndiceLinha(nomeEmpresa, tabela);
		tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[1]")).click();
	}
	
	protected int obterIndiceLinha(String nomeEmpresa, WebElement tabela) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[1]"));
		int idLinha = 0;
		for (int i = 0; i <= linhas.size(); i++) {
			if (linhas.get(i).getText().equals(nomeEmpresa)) {
				idLinha = i+2;
				break;
			}
		}
		return idLinha;
	}

	public void clicarCriarEmpresaFilial (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void selecionarComboEmpresa (String nomeResponsavel) {
		WebElement comboEmpresa = driver.findElement(By.id("txtCriarIdEmpresa"));
		Select selecionarEmpresa = new Select(comboEmpresa);
		selecionarEmpresa.selectByVisibleText(nomeResponsavel);
	}
	
	public void clicarCriarFilial (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void esperarCssSelector (String cssSelector) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	}
	
	public void inserirDescriçãoFilial (String id, String nomeFilial) {
		driver.findElement(By.id(id)).sendKeys(nomeFilial);
	}
	
	public void clicarBotãoConfirmar() {
		driver.findElement(By.cssSelector(".caixa_bottom > a:nth-child(2)")).click();
	}
	
	public void selecionarComboFilial (String id, String nomeFilial) {
		WebElement comboFilial = driver.findElement(By.id(id));
		Select selecionarFilial = new Select (comboFilial);
		selecionarFilial.selectByVisibleText(nomeFilial);
	}
	
	public void inserirNrPosto (String id, String nrPosto) {
		driver.findElement(By.id(id)).sendKeys(nrPosto);
	}
	
	public void inserirCNPJ (String id, String nrPosto) {
		driver.findElement(By.id(id)).sendKeys(cnpj);
	}
	
	public void inserirEndereço (String id, String endereço) {
		driver.findElement(By.id(id)).sendKeys(endereço);
	}
	
	public void inserirBairro (String id, String bairro) {
		driver.findElement(By.id(id)).sendKeys(bairro);
	}
	
	public void inserirCidade (String id, String cidade) {
		driver.findElement(By.id(id)).sendKeys(cidade);
	}

	public void inserirUF (String id, String uf) {
		driver.findElement(By.id(id)).sendKeys(uf);
	}

	public void inserirCEP (String id, String cpf) {
		driver.findElement(By.id(id)).sendKeys(cpf);
	}
	
	public void inserirDDD (String id, String ddd) {
		driver.findElement(By.id(id)).sendKeys(ddd);
	}

	public void inserirTelefone (String id, String telefone) {
		driver.findElement(By.id(id)).sendKeys(telefone);
	}
	
	public void inserirEmail (String id, String email) {
		driver.findElement(By.id(id)).sendKeys(email);
	}
	
	public void inserirSerieReciboFisico (String id, String serieFisico) {
		driver.findElement(By.id(id)).sendKeys(serieFisico);
	}
	
	public void inserirNrReciboFisico (String id, String nrFisico) {
		driver.findElement(By.id(id)).sendKeys(nrFisico);
	}
	
	public void inserirSerieRecidoEletronico (String id, String serieEletronico) {
		driver.findElement(By.id(id)).sendKeys(serieEletronico);
	}
	
	public void inserirNrReciboEletronico (String id, String nrEletronico) {
		driver.findElement(By.id(id)).sendKeys(nrEletronico);
	}
	
	
	
	
	
	
	
	
	
}
