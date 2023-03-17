import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variáveis_I_Cadastrar_Ocorrências_Sistema {
	WebDriver driver;
	public Variáveis_I_Cadastrar_Ocorrências_Sistema (WebDriver driver) {
		this.driver = driver;
	}
	String codigoRetorno = "8171";
	String codigoRetornoAlteraStatus = "8412";
	String descricaoRetorno = "retorno";
	String descricaoRetornoAlteraStatus = "retorno altera status";
	String observaçãoPadrão = "Esta observação foi inserida através do teste automático";
	String dias = "5";
	String tipoAgendamento = "Data e Hora";
	String diasAlerta = "5";
	String periodoLimite = "10";
	String descriçãoComplemento = "Digite a dt e a hr";
	
	
	//---------------DSL ocorrencia sistema-------------//
	
	
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

	public void clicarAdicionarOcorrência () {
		driver.findElement(By.cssSelector("#botoesAdicionarEditar > a:nth-child(1)")).click();
	}
	
	public void inserirCodOcorrencia (String cssSelector, String codDescrição) {
		driver.findElement(By.id(cssSelector)).sendKeys(codDescrição);
	}
	
	public void inserirDescrição (String id, String descrição) {
		driver.findElement(By.id(id)).sendKeys(descrição);
	}
	
	public void checkBoxMarcarCobrado (String id) {
		WebElement marcarCobrado = driver.findElement(By.id(id));
		if(marcarCobrado.isSelected()) {
		} else {
			marcarCobrado.click();
		}
	}
	
	public void checkBoxMarcarUltimoHistorico (String id) {
		WebElement marcarUltimoHistorico = driver.findElement(By.id(id));
		if(marcarUltimoHistorico.isSelected()) {
		} else {
			marcarUltimoHistorico.click();
		}
	}
	
	public void checkBoxOcorrenciaPositiva (String id) {
		WebElement marcarOcorrênciaPositiva = driver.findElement(By.id(id));
		if(marcarOcorrênciaPositiva.isSelected()) {
		} else {
			marcarOcorrênciaPositiva.click();
		}
	}

	public void checkBoxUtilizarAPI (String id) {
		WebElement marcarUtiizarAPI = driver.findElement(By.id(id));
		if(marcarUtiizarAPI.isSelected()) {
		} else {
			marcarUtiizarAPI.click();
		}
	}
	
	public void clicarObsPadrão (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void inserirObsPadrão (String id, String texto) throws InterruptedException {
		WebElement campoTexto = driver.findElement(By.id(id));
		campoTexto.clear();
		Thread.sleep(1000);
		campoTexto.sendKeys(texto);
		Thread.sleep(1000);
	}
	
	public void clicarConfirmar (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarAgendarRetorno (String id) throws InterruptedException {
		driver.findElement(By.id(id)).click();
		Thread.sleep(1000);
	}
	
	public void inserirDiasRetorno (String id, String dias) {
		driver.findElement(By.id(id)).sendKeys(dias);
	}
	
	public void selecionarComboPeriodo (String id, String periodo) {
		WebElement comboDia = driver.findElement(By.id(id));
		Select selecionarDia = new Select(comboDia);
		selecionarDia.selectByVisibleText(periodo);
	}
	
	public void clicarAgendamentoManual (String id) {
		WebElement agendamentoManual = driver.findElement(By.id(id));
		if(agendamentoManual.isSelected()) {
		} else {
			agendamentoManual.click();
		}
	}
	
	public void selecionarComboTipo (String id, String tipo) {
		WebElement comboTipo = driver.findElement(By.id(id));
		Select selecionarTipo = new Select(comboTipo);
		selecionarTipo.selectByVisibleText(tipo);
	}
	
	public void inserirDiasAlerta (String id, String dias) {
		driver.findElement(By.id(id)).sendKeys(dias);
	}
	
	public void selecionarComboPeriodoLimite (String id, String periodo) {
		WebElement comboPeriodoLimite = driver.findElement(By.id(id));
		Select selecionarPeriodoLimite = new Select (comboPeriodoLimite);
		selecionarPeriodoLimite.selectByVisibleText(periodo);
	}
	
	public void inserirPeriodoLimite (String id, String periodoLimite) {
		driver.findElement(By.id(id)).sendKeys(periodoLimite);

	}
	
	public void clicarCheckBoxEnviarCliente (String id) {
		WebElement enviarCliente = driver.findElement(By.id(id));
		if(enviarCliente.isSelected()) {
		} else {
			enviarCliente.click();
		}
	}
	
	public void clicarCheckBoxExibirOcorrencia (String id) {
		WebElement exibirOperador = driver.findElement(By.id(id));
		if(exibirOperador.isSelected()) {
		} else {
			exibirOperador.click();
		}
	}

	public void clicarCheckBoxCPC (String id) {
		WebElement ocorrenciaCPC = driver.findElement(By.id(id));
		if(ocorrenciaCPC.isSelected()) {
		} else {
			ocorrenciaCPC.click();
		}
	}
	
	public void clicarTipoAtendimento (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarCheckBoxVincTelefone (String id) {
		WebElement vincularTelefone = driver.findElement(By.id(id));
		if(vincularTelefone.isSelected()) {
		} else {
			vincularTelefone.click();
		}
	}
	
	public void clicarCheckBoxTodosGrupos (String id) {
		WebElement selecionarTodosGrupos = driver.findElement(By.id(id));
		if(selecionarTodosGrupos.isSelected()) {
		} else {
			selecionarTodosGrupos.click();
		}
	}
	
	public void clicarCheckBoxTodasFases (String id) {
		WebElement selecionarTodasfases = driver.findElement(By.id(id));
		if(selecionarTodasfases.isSelected()) {
		} else {
			selecionarTodasfases.click();
		}
	}
	
	public void clicarSalvar (String id) {
		driver	.findElement(By.id(id)).click();

	}
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem , mensagemConfirmação);
		Thread.sleep(1100);
	}
	
	public WebElement tabelaStatus (String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	protected int idLinha(String status, WebElement tabelaStatus) {
		List<WebElement> linhasTabela = tabelaStatus.findElements(By.xpath("./tbody/tr/td[3]"));
		int numeroLinha = 0;
		for(int i = 0; i <=linhasTabela.size(); i++) {
			if(linhasTabela.get(i).getText().equals(status)) {
			numeroLinha = i+2;
			break;
			}
		}
		return numeroLinha;
	}
}
