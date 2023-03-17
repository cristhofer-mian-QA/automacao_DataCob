import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_C_Parametros_Acordo {

	WebDriver driver;
	public Variaveis_C_Parametros_Acordo (WebDriver driver) {
		this.driver = driver;
	}
	
	String descricao = "Ultimo_teste";
	String descricaoSemRenegociação = "Automação sem Renegociação";
	String descricaoRenegociação = "Automação com Renegociação";
	String dataInicio = "15012000";
	String dataFim = "31122999";
	String diasStandby = "0";
	String diasGraça = "6";
	String jurosAtraso = "500";
	String valorPrestacaoMinima = "2000";
	String cancelarAcordo1parcela = "0";
	String cancelarAcordo2parcela = "0";
	String reenvioBoleto1parcela = "0";
	String reenvioBoleto2parcela = "0";

	//------------------------//
	String diasDe0 = "0";
	String diasAte30 = "30";
	String comissãoAVista = "2";
	String descontoCorreção = "65";
	String descontoPrincipal = "5";
	//-------------------------//
	String diasDe31 = "31";
	String diasAte60 = "60";
	String comissãoAVista1 = "2";
	String descontoCorreção1 = "65";
	String descontoPrincipal1 = "5";
	//------------------------//
	String diasDe61 = "61";
	String diasAte90 = "90";
	String comissãoAVista2 = "2";
	String descontoCorreção2 = "65";
	String descontoPrincipal2 = "5";
	//------------------------//
	String diasDe91 = "91";
	String diasAte9999999 = "9999999";
	String comissãoAVista3 = "2";
	String descontoCorreção3 = "65";
	String descontoPrincipal3 = "5";
	
	//------Acordo a prazo-----//
	String parcelaDe0 = "0";
	String parcelaAte3 = "3";
	String parcelamento1 = "200";
	String entradaMinima1 = "5000";
	String comissaoPrazo1 = "500";
	String porcEntradaMin1 = "1000";	
	String descPrincipalP1 = "3";
	String descCorrecaoP1 = "50";

	String parcelaDe4 = "4";
	String parcelaAte6 = "6";
	String parcelamento2 = "300";
	String entradaMinima2 = "6000";
	String comissaoPrazo2 = "600";
	String porcEntradaMin2 = "1200";	
	String descPrincipalP2 = "2";
	String descCorrecaoP2 = "40";
	
	String parcelaDe7 = "7";
	String parcelaAte9 = "9";
	String parcelamento3 = "400";
	String entradaMinima3 = "7000";
	String comissaoPrazo3 = "700";
	String porcEntradaMin3 = "1400";	
	String descPrincipalP3 = "1";
	String descCorrecaoP3 = "30";
	
	String parcelaDe10 = "10";
	String parcelaAte12 = "12";
	String parcelamento4 = "500";
	String entradaMinima4 = "8000";
	String comissaoPrazo4 = "800";
	String porcEntradaMin4 = "1600";	
	String descPrincipalP4 = "0";
	String descCorrecaoP4 = "20";
	
	
	//---------------DSL parametro acordo-------------//
	

	public void esperarCssSelector (String cssSelector) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
	}
	
	public void esperarId (String id) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}

	public void esperarXpath (String xpath) {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void clicarBotãoCadastra (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void inserirDescrição (String id, String descrição) {
		driver.findElement(By.id(id)).sendKeys(descrição);
	}
	
	public void clicarBaixaProporcional (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void desmarcarIgnorarCancelamentoAcordoAutomatico (String id) throws InterruptedException {
		WebElement checkbox = driver.findElement(By.id(id));
		if (checkbox.isSelected()) {
			checkbox.click();
		}
		Thread.sleep(2000);
	}
	
	public void clicarOkXpath (String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clicarOkcss (String cssSelector) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep(1500);
	}
	
	public void tabelaParâmetroAcordoCriado (String descrição) throws InterruptedException {
		WebElement tabela = driver.findElement(By.xpath("//*[@id=\"gridAcordo\"]/table/tbody/tr[2]/td/div/div/table"));
		int idLinha = obterIndiceLinha(descrição, tabela);
		WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[2]"));
			Thread.sleep(3000);
		celula.click();
			Thread.sleep(1000);
	}
	
	protected int obterIndiceLinha(String descricao, WebElement tabela) {
		List<WebElement>linhas = tabela.findElements(By.xpath("./tbody/tr/td[2]"));
		int idLinha = 0;
		for(int i = 0; i<= linhas.size(); i++) {
			if(linhas.get(i).getText().equals(descricao)) {
				idLinha = i+2;
				break;
			}
		}
		return idLinha;
	}
	
	public void clicarBotãoParâmetroAcordo () {
		driver.findElement(By.id("modificaNome")).click();
	}
	
	public void clicarAbaTipo(String cssSelector) throws InterruptedException {
		driver.findElement(By.cssSelector(cssSelector)).click();
		Thread.sleep (1200);
	}
	
	public void clicarBotãoInserir (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarFlagAtivo (String id) {
		WebElement ativo = driver.findElement(By.id(id));
		if (ativo.isSelected()) {
		} else {
			ativo.click();
		}
	}
	
	public void inserirDataInicio (String id, String dataInicio) {
		driver.findElement(By.id(id)).sendKeys(dataInicio);
	}
	
	public void inserirDataFim (String id, String dataFim) {
		driver.findElement(By.id(id)).sendKeys(dataFim);
	}
	
	public void clicarNormal (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarBoletagem (String id) {
		WebElement boletagem = driver.findElement(By.id(id));
		if (boletagem.isSelected()) {
		} else {
			boletagem.click();
		}
	}
	
	public void clicarAPI (String id) {
		WebElement API = driver.findElement(By.id(id));
		if (API.isSelected()) {
		} else {
			API.click();
		}
	}
	
	public void clicarDataPact (String id) {
		WebElement DataPact = driver.findElement(By.id(id));
		if (DataPact.isSelected()) {
		} else {
			DataPact.click();
		}
	}
	
	public void clicarWebService (String id) {
		WebElement WebService = driver.findElement(By.id(id));
		if (WebService.isSelected()) {
		} else {
			WebService.click();
		}
	}
	
	public void clicarCobrarJurosAtraso (String id) {
		WebElement jurosAtraso = driver.findElement(By.id(id));
		if (jurosAtraso.isSelected()) {
		} else {
			jurosAtraso.click();
		}
	}
	
	public void nãoClicarRenegociação (String id) {
		WebElement renegociação = driver.findElement(By.id(id));
		if (renegociação.isSelected()) {
			renegociação.click();
		}
	}
	
	public void clicarRenegociação (String id) {
		WebElement renegociação = driver.findElement(By.id(id));
		if (renegociação.isSelected()) {
		} else {
			renegociação.click();
		}
	}
	
	public void nãoClicarConfirmarDadosCadastrais (String id) {
		WebElement dadosCadastrais = driver.findElement(By.id(id));
		if (dadosCadastrais.isSelected()) {
			dadosCadastrais.click();
		}
	}
	
	public void clicarLinear (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void inserirDiasGraçaAtraso (String id, String dias) {
		driver.findElement(By.id(id)).sendKeys(dias);
	}
	
	public void inserirJurosAtraso (String id, String juros) {
		driver.findElement(By.id(id)).sendKeys(juros);
	} 
	
	public void inserirStandbyAcordo (String id, String standby) {
		driver.findElement(By.id(id)).sendKeys(standby);

	}
	
	public void inserirCancelamentoAcordo1Parcela (String id, String diasCancelar) {
		driver.findElement(By.id(id)).sendKeys(diasCancelar);
	}
	
	public void inserirCancelamentoAcordo2Parcela (String id, String diasCancelar) {
		driver.findElement(By.id(id)).sendKeys(diasCancelar);
	}
	
	public void nãoClicarNãoCancelar2Parcela (String id) {
		WebElement cancelar2Parcela = driver.findElement(By.id(id));
		if (cancelar2Parcela.isSelected()) {
			cancelar2Parcela.click();
		}
	}
	
	public void inserirReenvioBoleto1Parcela (String id, String diasCancelar) {
		driver.findElement(By.id(id)).sendKeys(diasCancelar);
	}
	
	public void inserirReenvioBoleto2Parcela (String id, String diasCancelar) {
		driver.findElement(By.id(id)).sendKeys(diasCancelar);
	}
	
	public void inserirValorPrestaçãoMínima (String id, String valorMínimo) {
		driver.findElement(By.id(id)).sendKeys(valorMínimo);
	}
	
	public void limparCódigoPolítica (String id) {
		driver.findElement(By.id(id)).clear();
	}
	
	public void clicarMaisAntiga (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarEnquadramentoVencimento (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarVencimentoDiaUtil (String id) {
		WebElement diaUtil = driver.findElement(By.id(id));
		if (diaUtil.isSelected()) {
		} else {
			diaUtil.click();
		}
	}
	
	public void clicarEntradaMaior (String id) {
		WebElement entradaMaior = driver.findElement(By.id(id));
		if (entradaMaior.isSelected()) {
		} else {
			entradaMaior.click();
		}
	}
	
	public void nãoClicarEntradaIgualParcela (String id) {
		WebElement entradaIgualParcela = driver.findElement(By.id(id));
		if (entradaIgualParcela.isSelected()) {
			entradaIgualParcela.click();
		}
	}
	
	public void nãoClicarProjerar1Parcela (String id) {
		WebElement projetar1Parcela = driver.findElement(By.id(id));
		if (projetar1Parcela.isSelected()) {
			projetar1Parcela.click();
		}
	}
	
	public void nãoClicarLiquidaAcordo (String id) {
		WebElement liquidaAcordo = driver.findElement(By.id(id));
		if (liquidaAcordo.isSelected()) {
			liquidaAcordo.click();
		}
	}
	
	public void nãoClicarAcordoForaAlçada (String id) {
		WebElement acordoForaAlçada = driver.findElement(By.id(id));
		if (acordoForaAlçada.isSelected()) {
			acordoForaAlçada.click();
		}
	}
	
	public void nãoClicarNegociaçãoForaAlçada (String id) {
		WebElement negociaForaAlçada = driver.findElement(By.id(id));
		if (negociaForaAlçada.isSelected()) {
			negociaForaAlçada.click();
		}
	}
	
	public void nãoClicarProrrogação (String id) {

		WebElement atualizaDataProrrogação = driver.findElement(By.id(id));
		if (atualizaDataProrrogação.isSelected()) {
			atualizaDataProrrogação.click();
		}
	}
	
	public void clicarIgnorarDescontoPC (String id) {
		WebElement ignoraCalculoPC = driver.findElement(By.id(id));
		if (ignoraCalculoPC.isSelected()) {
		} else {
			ignoraCalculoPC.click();
		}
	}
	
	public void clicarHonorário1Parcela (String id) {
		WebElement honorarioPrimeiraParcela = driver.findElement(By.id(id));
		if (honorarioPrimeiraParcela.isSelected()) {
		} else {
			honorarioPrimeiraParcela.click();
		}
	}
	
	public void selecionarTermoAcordo (String id, String texto) {
		WebElement comboTermoAcordo = driver.findElement(By.id(id));
		Select selecionarTermoAcordo = new Select (comboTermoAcordo);
		selecionarTermoAcordo.selectByVisibleText(texto);
	}
	
	public void selecionarTermoDataPact (String id, String texto) {
		WebElement comboTermoDataPact = driver.findElement(By.id(id));
		Select selecionarTermoDataPact = new Select (comboTermoDataPact);
		selecionarTermoDataPact.selectByVisibleText(texto);
	}
	
	public void clicarSalvar (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	String mensagem (String cssSelector) {
		return driver.findElement(By.cssSelector(cssSelector)).getText();
	}
	
	public void validarMensagem (String mensagem, String mensagemConfirmação) throws InterruptedException {
		Assert.assertEquals(mensagem , mensagemConfirmação);
		Thread.sleep (1900);
	}
	
	public void tabelaParâmetrosAcordo (String descrição) throws InterruptedException {
		WebElement tabela1 = driver.findElement(By.xpath("//*[@id=\"gridTipo\"]/table/tbody/tr[2]/td/div/div/table"));
		int idLinha1 = obterIndiceLinhaParametros(descrição, tabela1) ;
		WebElement celula1 = driver.findElement(By.xpath(".//tr[" + idLinha1 + "]/td[6]"));
			Thread.sleep(3000);
		celula1.click();
	}
	
	protected int obterIndiceLinhaParametros(String descrição, WebElement tabela1) {
		List<WebElement>linhas1 = tabela1.findElements(By.xpath("./tbody/tr/td[6]"));
		int idLinha1 = 0;
		for(int i = 0; i<= linhas1.size(); i++) {
			if(linhas1.get(i).getText().equals(descrição)) {
				idLinha1 = i+2;
				break;
			}
		}
		return idLinha1;
	}

	public void clicarAVista (String xpath) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(1500);
	}
	
	public void inserirDiasDe (String id, String dia) {
		driver.findElement(By.id(id)).sendKeys(dia);
	}
	
	public void inserirDiasAte (String id, String dia) {
		driver.findElement(By.id(id)).sendKeys(dia);
	}
	
	public void inserirComissão (String id, String comissão) {
		driver.findElement(By.id(id)).sendKeys(comissão);
	}
	
	public void inserirDescontoComissão (String id, String desconto) {
		driver.findElement(By.id(id)).sendKeys(desconto);
	}
	
	public void inserirDescontoPrincipal (String id, String desconto) {
		driver.findElement(By.id(id)).sendKeys(desconto);
	}
	
	public void nãoMarcarAcordoPendente (String id) {
		WebElement acordoPendente = driver.findElement(By.id(id));
		if (acordoPendente.isSelected()) {
			acordoPendente.click();
		}
	}
	
	public void nãoMarcarValorMínimo (String id) {
		WebElement acordoPendente = driver.findElement(By.id(id));
		if (acordoPendente.isSelected()) {
			acordoPendente.click();
		}
	}
	
	public void limparCodFaixa (String id) {
		driver.findElement(By.id(id)).clear();
	}
	
	public void clicarOkID (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarAPrazo (String xpath) throws InterruptedException {
		driver.findElement(By.xpath(xpath)).click();
		Thread.sleep(1500);
	}
	
	public void clicarVisualizar (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void clicarInserirFaixa (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void inserirFaixaDe (String id,String diasDe) {
		driver.findElement(By.id(id)).sendKeys(diasDe);
	}
	
	public void inserirFaixaAte (String id,String diasAte) {
		driver.findElement(By.id(id)).sendKeys(diasAte);
	}
	
	public void clicarConfirmar (String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void tabelaFaixasAtraso (String diasDe) throws InterruptedException {
		WebElement faixaAtraso = driver.findElement(By.xpath("//*[@id=\"gridFaixaPrazo\"]/table/tbody/tr[2]/td/div/div/table"));
		int idLinha0 =  idLinhaFaixa(diasDe ,faixaAtraso);
		WebElement faixa = faixaAtraso.findElement(By.xpath(".//tr[" +  idLinha0 + "]/td[1]"));
			Thread.sleep(3000);
		faixa.click();
			Thread.sleep(2000);
	}
	
	protected int idLinhaFaixa(String diasDe, WebElement faixaAtraso) {
		List<WebElement> linhasFaixa = faixaAtraso.findElements(By.xpath("./tbody/tr/td[1]"));
		int idLinha1 = 0;
		for (int i = 0; i<=linhasFaixa.size(); i++ ) {
			if (linhasFaixa.get(i).getText().equals(diasDe)) {
				idLinha1 = i + 2;
				break;
			}
		}
		return idLinha1;
	}
	
	public void clicarInserirConfigParcelamento (String id) {
		driver.findElement(By.id(id)).click();
	}
	
	public void inserirParcelaDe (String id, String parcelaDe) {
		driver.findElement(By.id(id)).sendKeys(parcelaDe);
	}
	
	public void inserirParcelaAte (String id, String parcelaAte) {
		driver.findElement(By.id(id)).sendKeys(parcelaAte);
	}
	
	public void inserirPorcentoParcelamento (String id, String porcento) throws InterruptedException {
		WebElement porcParcelamento = driver.findElement(By.id(id));
		porcParcelamento.clear();
			Thread.sleep (1000);
		porcParcelamento.sendKeys(porcento);
			Thread.sleep (1000);

	}
	
	public void inserirEntradaMinima (String id, String entradaMinima) {
		driver.findElement(By.id(id)).sendKeys(entradaMinima);
	}
	
	public void inserirPorcentoEntMinima (String id, String porcEntradaMin) {
		driver.findElement(By.id(id)).sendKeys(porcEntradaMin);
	}
	
	public void inserirPorcentoComissão (String id, String porcComissão) {
		driver.findElement(By.id(id)).sendKeys(porcComissão);
	}
	
	public void inserirPorcentoDescPrincipal (String id, String descontoPrincipal) throws InterruptedException {
		WebElement descontoPrincipal1 = driver.findElement(By.id(id));
		descontoPrincipal1.clear();
		descontoPrincipal1.sendKeys(descontoPrincipal);
		Thread.sleep(1000);
	}
	
	public void  inserirPorcentoDescCorreção (String id, String porcentoDescCorreção) {
		driver.findElement(By.id(id)).sendKeys(porcentoDescCorreção);
	}
	
	public void nãoClicarAcordoPendente (String id) {
		WebElement definirAcordoPendente = driver.findElement(By.id(id));
		if(definirAcordoPendente.isSelected()) {
			definirAcordoPendente.click();
		} 
	}
	
	//------------DSL vincular calculo Acordo------------//

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
		WebElement checkBox = driver.findElement (By.cssSelector("#treeGeral > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)"));
		if (checkBox.isSelected()) {
		} else {
			checkBox.click();
		}
	}
	
	public WebElement tabelaAcordo() {
		return driver.findElement(By.xpath("//*[@id=\"gridAcordo\"]/table/tbody/tr[2]/td/div/div/table"));
	}
	
	protected String validarVinculo(String nomeGrupo, String id) {
		List<WebElement> valida = driver.findElements(By.xpath("//*[@id=\"treeAcordo\"]/ul/li"));
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