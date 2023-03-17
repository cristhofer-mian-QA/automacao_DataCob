import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_A2_Cadastro_Grupo_Cliente_Fase {
	WebDriver driver;
	public Variaveis_A2_Cadastro_Grupo_Cliente_Fase (WebDriver driver) {
		this.driver = driver;
	}
	
	String nomeGrupo = "Automação1";
	String nomeResumido = "Automação_Cliente";
	String razaoSocial = "Automação ltda1";
	String cpfCnpj = "73491547000100";
	String endereço = "Rua teste";
	String numero = "159";
	String complemento = "Empresa teste";
	String bairro = "Bairro teste";
	String cidade = "São Paulo";
	String cep = "15625000";
	String ddd = "11";
	String telefone = "955866654";
	String email = "teste@teste.com";
	
	//-----------------DSL grupo/cliente/fase-----------------//
	
	
	
	
	
	public void esperarId (String id) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

	public void clicarAdicionarGrupo (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void esperarCssSelector (String cssSelector) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	}
	
	public void inserirDescrição (String id, String nomeGrupo) {
		driver.findElement(By.id(id)).sendKeys(nomeGrupo);
	}
	
	public void selecionarComboRotina (String id, String textoVisivel) {
		WebElement comboRotina = driver.findElement(By.id(id));
		Select selecionarRotina = new Select(comboRotina);
		selecionarRotina.selectByVisibleText(textoVisivel);
	}
	
	public void selecionarComboAgrupamento (String id, String textoVisivel) {
		WebElement comboAgrupamento = driver.findElement(By.id("listModoAgrupamento"));
		Select selecionarAgrupamento = new Select(comboAgrupamento);
		selecionarAgrupamento.selectByVisibleText("Padrão da Recepção");
	}
	
	public void selecionarAgrupamentoDataPact (String id, String textoVisivel) {
		WebElement comboAgrupamentoDataPact = driver.findElement(By.id("listModoAgrupamentoDataPact"));
		Select selecionarAgrupamentoDataPact = new Select(comboAgrupamentoDataPact);
		selecionarAgrupamentoDataPact.selectByVisibleText("Por Financiado");
	}
	
	public void selecionarAgrupamentoMailling (String id, String textoVisivel) {
		WebElement comboAgrupamentoMailing = driver.findElement(By.id("listModoAgrupamentoMailing"));
		Select selecionarAgrupamentoMailing = new Select(comboAgrupamentoMailing);
		selecionarAgrupamentoMailing.selectByVisibleText("Por Contrato");
	}
	
	public void selecionarComboMarcaçãoFeriado (String id, String textoVisivel) {
		WebElement comboMarcaçãoFeriado = driver.findElement(By.id("idMarcacaoFeriado"));
		Select selecionarMarcaçãoFeriado = new Select(comboMarcaçãoFeriado);
		selecionarMarcaçãoFeriado.selectByVisibleText("Não marcar");
	}
	
	public void clicarCapitalizarNomeFinanciado (String id) {
		WebElement capitalizar = driver.findElement(By.id(id));
		if (capitalizar.isSelected()) {
		}
		else {
			capitalizar.click();
		}
	}
	
	public void clicarAtualizarEndereçoPrincipal (String id) {
		WebElement endereço = driver.findElement(By.id(id));
		if (endereço.isSelected()) {
		}
		else {
			endereço.click();
		}
	}
	
	public void clicarAtualizarEmailPrincipal (String id) {
		WebElement email = driver.findElement(By.id(id));
		if (email.isSelected()) {
		}
		else {
			email.click();
		}
	}

	public void clicarOk (String cssSelector) {
		driver.findElement(By.cssSelector(cssSelector)).click();
	}
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) {
		Assert.assertEquals(mensagem , mensagemConfirmação);
	}
	
	public void buscarGrupo (String nomeGrupo){
		WebElement tabela = driver.findElement(By.xpath("//*[@id=\"gridGrupo\"]/table/tbody/tr[2]/td/div/div/table"));	
	int idLinha = selecionarLinha(nomeGrupo, tabela);
	tabela.findElement(By.xpath("./tbody/tr[" + idLinha + "]/td[2]")).click();
	}
		
	public void buscarCliente (String nomeCliente){
		WebElement tabela = driver.findElement(By.xpath("//*[@id=\"gridCliente\"]/table/tbody/tr[2]/td/div/div/table"));	
	int idLinha = selecionarLinha(nomeCliente, tabela);
	tabela.findElement(By.xpath("./tbody/tr[" + idLinha + "]/td[1]")).click();
	}
	
	public void buscarFaseAM (String codFase, String nomeFase){
		WebElement tabelaFase1 = driver.findElement(By.xpath("//*[@id=\"gridFaseEmpresa\"]/table/tbody/tr[2]/td/div/div/table"));	
	int idLinha2 = selecionarLinhaAM(codFase ,nomeFase, tabelaFase1);
	tabelaFase1.findElement(By.xpath("./tbody/tr[" + idLinha2 + "]/td[2]")).click();
	}
	
	protected int selecionarLinhaAM(String codFase, String nomeFase , WebElement tabelaFase1) {
		List<WebElement> linhasAM = tabelaFase1.findElements(By.xpath("./tbody/tr/td[2]"));
		int idLinhaAM = 0;
		for (int i = 0; i<=linhasAM.size(); i++) {
			if(linhasAM.get(i).getText().equals(codFase + " - " + nomeFase)) {
				idLinhaAM = i + 2;
				break;
			}
		}
		return idLinhaAM;
	}
	
	public void buscarFaseJU (String codFaseJU, String nomeFaseJU){
		WebElement tabelaFase2 = driver.findElement(By.xpath("//*[@id=\"gridFaseEmpresa\"]/table/tbody/tr[2]/td/div/div/table"));	
	int idLinha3 = selecionarLinhaJU(codFaseJU ,nomeFaseJU, tabelaFase2);
	tabelaFase2.findElement(By.xpath("./tbody/tr[" + idLinha3 + "]/td[2]")).click();
	}
	
	protected int selecionarLinhaJU(String codFaseJU, String nomeFaseJU , WebElement tabelaFase2) {
		List<WebElement> linhasJU = tabelaFase2.findElements(By.xpath("./tbody/tr/td[2]"));
		int idLinhaJU = 0;
		for (int i = 0; i<=linhasJU.size(); i++) {
			if(linhasJU.get(i).getText().equals(codFaseJU + " - " + nomeFaseJU)) {
				idLinhaJU = i + 2;
				break;
			}
		}
		return idLinhaJU;
	}
	
	protected int selecionarLinha(String texto , WebElement tabela) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td[2]"));
		int idLinha = 0;
		for (int i = 0; i<=linhas.size(); i++) {
			if(linhas.get(i).getText().equals(texto)) {
				idLinha = i + 2;
				break;
			}
		}
		return idLinha;
	}
	
	public void buscarFilial (String nomeFilial){
		WebElement tabelaFilial = driver.findElement(By.xpath("//*[@id=\'gridFaseFilial\']/table/tbody/tr[2]/td/div/div/table"));	
	int idLinhaFilial = selecionarFilial(nomeFilial, tabelaFilial);
	tabelaFilial.findElement(By.xpath("./tbody/tr[" + idLinhaFilial + "]/td[1]")).click();
	}
	
	
	protected int selecionarFilial(String nomeFilial , WebElement tabelaFilial) {
		List<WebElement> linhasFilial = tabelaFilial.findElements(By.xpath("./tbody/tr/td[2]"));
		int idLinhaFilial = 0;
		for (int i = 0; i<=linhasFilial.size(); i++) {
			if(linhasFilial.get(i).getText().equals(nomeFilial)) {
				idLinhaFilial = i + 2;
				break;
			}
		}
		return idLinhaFilial;
	}

	public void clicarAdicionarCliente (String id) {
		driver.findElement(By.id(id)).click();
	} 
	
	public void selecionarComboGrupo (String id, String nomeGrupo) {
		WebElement comboGrupo = driver.findElement(By.id("cbGrupo"));
		Select selecionarGrupo = new Select (comboGrupo);
		selecionarGrupo.selectByVisibleText(nomeGrupo);
	}
	
	public void inserirNomeResumido (String id, String nomeResumido) {
		driver.findElement(By.id(id)).sendKeys(nomeResumido);
	}
	
	public void inserirRazãoSocial (String id, String razãoSocial) {
		driver.findElement(By.id(id)).sendKeys(razãoSocial);
	}
	
	public void inserirCNPJ (String id, String cnpj) {
		driver.findElement(By.id(id)).sendKeys(cnpj);
	}
	
	public void limparInscriçãoEstadual (String id) {
		driver.findElement(By.id(id)).clear();
	} 
	
	public void clicarNegociarAcordo (String id) {
		WebElement negociarPorAcordo = driver.findElement(By.id(id));
		if (negociarPorAcordo.isSelected()) {
		}
		else {
			negociarPorAcordo.click();
		}
	}
	
	public void clicarBotãoAtivo (String id) {
		WebElement ativo = driver.findElement(By.id(id));
		if (ativo.isSelected()) {
		}
		else {
			ativo.click();
		}
	}
	
	public void selecionarTipoProduto (String id) {
		WebElement comboTipoProduto = driver.findElement(By.id(id));
		Select selecionarTipoProduto = new Select (comboTipoProduto);
		selecionarTipoProduto.selectByVisibleText("Selecionar");
	}
	
	public void inserirEndereço (String id,String endereço) {
		driver.findElement(By.id(id)).sendKeys(endereço);
	}
	
	public void inserirNumero (String id, String numero) {
		driver.findElement(By.id(id)).sendKeys (numero);
	}
	
	public void inserirComplemento (String id, String complemento) {
		driver.findElement(By.id(id)).sendKeys(complemento);
	}
	
	public void inserirBairro (String id, String bairro) {
		driver.findElement(By.id(id)).sendKeys(bairro);
	}
	
	public void inserirCidade (String id, String cidade) {
		driver.findElement(By.id(id)).sendKeys(cidade);
	}
	
	public void inserirCEP (String id, String cep) {
		driver.findElement(By.id(id)).sendKeys(cep);
	}
	
	public void inserirDDD (String id, String ddd) {
		driver.findElement(By.id(id)).sendKeys(ddd);
	}
	
	public void inserirTelefone (String id, String telefone) {
		driver.findElement(By.id(id)).sendKeys(telefone);
	}
	
	public void limparRamal (String id) {
		driver.findElement(By.id(id)).clear();
	}
	
	public void inserirEmail (String id, String email) {
		driver.findElement(By.id(id)).sendKeys(email);
	}
	
	public void selecionarUF (String id) {
		WebElement comboUF = driver.findElement(By.id(id));
		Select selecionarUF = new Select (comboUF);
		selecionarUF.selectByVisibleText("SP");
	}
	
	public void clicarBotãoConfirmar (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarVincularFase (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void esperarXPATH (String xpath) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void clicarBotãoConfirmarCSS (String css) {
		driver.findElement(By.cssSelector(css)).click();
	}
	
	
}
