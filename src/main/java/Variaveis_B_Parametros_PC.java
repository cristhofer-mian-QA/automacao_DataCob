import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variaveis_B_Parametros_PC {

		WebDriver driver;
		public Variaveis_B_Parametros_PC (WebDriver driver) {
			this.driver = driver;
		}
		
		String descricao = "automação2";
		String descricaoNenhum = "nenhum";
		String descricaoAtualizacao= "atualização";
		String descricaoQuitacao= "quitação";
		String dataInicio = "15/01/2022";
		String dataFinal = "15/10/2999";
		String vencimentoMínimo = "0";
		String vencimentoMáximo = "15";
		
		String de0 = "0";
		String ate10 = "10";
		String PMT = "1";
		String descontoPrincipal = "3";
		String descontoPrincipalVincenda = "5";
		String juros = "5";
		String diasIsentosJuros = "3";
		String descontoJuros = "20"; 
		String multa = "3";
		String diasIsentosMulta = "3";
		String descontoMulta = "20"; 
		String comissaoPermanencia = "2"; 
		String diasIsentoComissao = "3";
		String descontoComissao = "30"; 
		String honorarioVencida = "5";
		String diasIsentoHonorario = "3";
		String honorarioVincenda = "1";
		String minima = "20";
		String atrasoMínimoParcelas = "0";
		
		String de11 = "11";
		String ate30 = "30";
		String PMT2 = "1";
		String descontoPrincipal2 = "3";
		String descontoPrincipalVincenda2 = "5";
		String juros2 = "5";
		String diasIsentosJuros2 = "3";
		String descontoJuros2 = "20"; 
		String multa2 = "3";
		String diasIsentosMulta2 = "3";
		String descontoMulta2 = "20"; 
		String comissaoPermanencia2 = "2"; 
		String diasIsentoComissao2 = "3";
		String descontoComissao2 = "30"; 
		String honorarioVencida2 = "5";
		String diasIsentoHonorario2 = "3";
		String honorarioVincenda2 = "1";
		String minima2 = "20";
		String atrasoMínimoParcelas2 = "0";
		
		String de31 = "31";
		String ate99999999 = "99999999";
		String PMT3 = "1";
		String descontoPrincipal3 = "3";
		String descontoPrincipalVincenda3 = "5";
		String juros3 = "5";
		String diasIsentosJuros3 = "3";
		String descontoJuros3 = "20"; 
		String multa3 = "3";
		String diasIsentosMulta3 = "3";
		String descontoMulta3 = "20"; 
		String comissaoPermanencia3 = "2"; 
		String diasIsentoComissao3 = "3";
		String descontoComissao3 = "30"; 
		String honorarioVencida3 = "5";
		String diasIsentoHonorario3 = "3";
		String honorarioVincenda3 = "1";
		String minima3 = "20";
		String atrasoMínimoParcelas3 = "0";
		
	//------------DSL calculo pc------------//
		
		public void esperarCssSelector (String cssSelector) {
			WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
		}

		public void esperarId (String id) {
			WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		}

		public void esperarXpath (String xpath) throws InterruptedException {
			WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			Thread.sleep(600);
		}
		
		public void clicarBotãoCadastrar (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void inserirDescrição (String id, String descrição) {
			driver.findElement(By.id(id)).sendKeys(descrição);
		}
		
		public void clicarMaiorDesconto (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void clicarQuitaçãoPAdrão (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void clicarOK (String cssSelector) {
			driver.findElement(By.cssSelector(cssSelector)).sendKeys(Keys.ENTER);
		}
		
		public void tabelaCalculoPC (String descrição) throws InterruptedException { 
			WebElement tabela = driver.findElement(By.xpath("//*[@id=\'gridCalculo\']/table/tbody/tr[2]/td/div/div/table"));
			int idLinha = obterIndiceLinha(descrição, tabela);
			WebElement celula = tabela.findElement(By.xpath(".//tr[" + idLinha + "]/td[1]"));
				Thread.sleep(1000);
			celula.click();	
		}
		
		protected int obterIndiceLinha (String descricao, WebElement tabela) {
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

		public void clicarBotãoParâmetroCálculoPC (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void clicarAbaTipoCálculo (String cssSelector) {
			driver.findElement(By.cssSelector(cssSelector)).click();
		}
		
		public void clicarBotãoAdicionar (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void clicarBoletagem (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void clicarTipoCálculo (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void clicarDataPact (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void clicarApi (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void selecionarAtualizaçãoPrincipal (String id, int index) {
			WebElement comboIndice = driver.findElement(By.id(id));
			Select selecionarIndice = new Select(comboIndice);
			selecionarIndice.selectByIndex(index);
		}
		
		public void inserirDiasAtualizaçãoPrincipal (String id, String dias) {
			WebElement dia = driver.findElement(By.id(id));
			dia.clear();
			dia.sendKeys(dias);
		}
		
		public void selecionarConversãoParaReal (String id, int index) {
			WebElement comboConversãoParaReal = driver.findElement(By.id(id));
			Select selecionarConversãoParaReal = new Select(comboConversãoParaReal);
			selecionarConversãoParaReal.selectByIndex(index);
		}
		
		public void selecionarMoeda (String id, String textoVisivel) {
			WebElement comboMoeda = driver.findElement(By.id(id));
			Select selecionarMoeda = new Select(comboMoeda);
			selecionarMoeda.selectByVisibleText(textoVisivel);
		}
		
		public void clicarVencimento (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void selecionarQuitaçãoNenhum (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void selecionarQuitaçãoAtualização (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void selecionarQuitaçãoQuitação (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void clicarAtivo () {
			WebElement ativo = driver.findElement(By.id("status"));
			if(ativo.isSelected()) {
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
		
		public void nãoClicarReterComissão () {
			WebElement ReterComissão = driver.findElement(By.id("retemComissao"));
			if(ReterComissão.isSelected()) {
				ReterComissão.click();	
			}
		}
		
		public void nãoClicarReterHonorário () {
			WebElement ReterHonorário = driver.findElement(By.id("retemHonorario"));
			if(ReterHonorário.isSelected()) {
			}
		}
		
		public void inserirDiasMínimos (String id, String mínimos) {
			WebElement diasMinimos = driver.findElement(By.id(id));
			diasMinimos.clear();
			diasMinimos.sendKeys(mínimos);
		}
		
		public void inserirDiasMáximos (String id, String máximos) {
			WebElement diasMáximos = driver.findElement(By.id(id));
			diasMáximos.clear();
			diasMáximos.sendKeys(máximos);		}
				
		public void clicarOkID (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		String mensagem (String cssSelector) {
			return driver.findElement(By.cssSelector(cssSelector)).getText();
		}
		
		public void validarMensagem (String mensagem, String mensagemConfirmação) {
			Assert.assertEquals(mensagem , mensagemConfirmação);
		}
		
		public void clicarAbaFaixasDeCálculo (String xpath) {
			driver.findElement(By.xpath(xpath)).click();
		}
		
		public void pesquisarDescrição (String idBarraPesquisa, String idBotãoProcurar, String descrição) throws InterruptedException {
			driver.findElement(By.id(idBarraPesquisa)).sendKeys(descrição);
			driver.findElement(By.id(idBotãoProcurar)).click();
				Thread.sleep(2000);
		}
		
		public void clicarPrimeiroItemTabela (String xpath) {
			driver.findElement(By.xpath(xpath)).click();			
		}
		
		public void clicarOkXpath (String xpath) {
			driver.findElement(By.xpath(xpath)).click();
		}
		
		public void diasDe (String id, String de) {
			driver.findElement(By.id(id)).sendKeys(de);
		}
		
		public void diasAte (String id, String ate) {
			driver.findElement(By.id(id)).sendKeys(ate);
		}
		
		public void inserirPMT (String id, String PMT) {
			driver.findElement(By.id(id)).sendKeys(PMT);
		}
		
		public void inserirFaseAtualização (String id) {
			driver.findElement(By.id(id)).clear();
		}
		
		public void clicarNãoUtilizarDeságio (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void inserirDescontoPrincipal (String id, String descontoPrincipal) {
			driver.findElement(By.id(id)).sendKeys(descontoPrincipal);
		}
		
		public void clicarDescontoPrincipal (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void inserirDescontoPrincipalVincenda (String id, String descontoPrincipalVincenda) {
			driver.findElement(By.id(id)).sendKeys(descontoPrincipalVincenda);
		}
		
		public void desmarcarDescCustas (String id) {
			WebElement descCustas = driver.findElement(By.id(id));
			if(descCustas.isSelected()) {
				descCustas.click();
			}
		}
		
		public void desmarcarDefFaixaRisco (String id) {
			WebElement descDefFaixaRisco = driver.findElement(By.id(id));
			if(descDefFaixaRisco.isSelected()) {
				descDefFaixaRisco.click();
			}
		}
		
		public void clicarJurosMensal (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void desmarcarUsarTaxaContrato (String id) {
			WebElement usarTaxaContrato = driver.findElement(By.id(id));
			if(usarTaxaContrato.isSelected()) {
				usarTaxaContrato.click();
			}
		}
		
		public void inserirJuros (String id, String juros) {
			driver.findElement(By.id(id)).sendKeys(juros);
		}
		
		public void inserirDiasIsentosJuros (String id, String diasJuros) {
			driver.findElement(By.id(id)).sendKeys(diasJuros);
		}
		
		public void inserirDescontosJuros (String id, String desconto) {
			driver.findElement(By.id(id)).sendKeys(desconto);
		}
		
		public void clicarLinear (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void inserirAtrasoMinimoParcelas (String id, String diasAtraso) {
			driver.findElement(By.id(id)).sendKeys(diasAtraso);
		}
		
		public void selecionarJurosSobrePrincipal (String id, String texto) {
			WebElement comboJuros = driver.findElement(By.id(id));
			Select selecionarJuros = new Select(comboJuros);
			selecionarJuros.selectByVisibleText(texto);
		}
		
		public void inserirMulta (String id, String texto) {
			driver.findElement(By.id(id)).sendKeys(texto);
		}
		
		public void inserirDiasIsentosMulta (String id, String diasMulta) {
			driver.findElement(By.id(id)).sendKeys(diasMulta);
		}
		
		public void inserirDescontosMulta (String id, String desconto) {
			driver.findElement(By.id(id)).sendKeys(desconto);
		}
		
		public void selecionarMultaSobrePrincipal (String id, String texto) {
			WebElement comboMulta = driver.findElement(By.id(id));
			Select selecionarMulta = new Select(comboMulta);
			selecionarMulta.selectByVisibleText(texto);
		}
		
		public void clicarComissãoMensalParmanencia (String id) {
			driver.findElement(By.id(id)).click();
		}
		
		public void inserirComissãoPermanencia (String id, String comissãoPermanencia) {
			driver.findElement(By.id(id)).sendKeys(comissãoPermanencia);
		}
		
		public void inserirDiasIsentosComissão (String id, String diasComissão) {
			driver.findElement(By.id(id)).sendKeys(diasComissão);
		}
		
		public void inserirDescontoComissão (String id, String desconto) {
			driver.findElement(By.id(id)).sendKeys(desconto);
		}
		
		public void selecionarComissãoSobrePrincipal (String id, String texto) {
			WebElement comboComissão = driver.findElement(By.id(id));
			Select selecionarComissão = new Select(comboComissão);
			selecionarComissão.selectByVisibleText(texto);
		}
		
		public void inserirHonoráriosVencidas (String id, String porcento) {
			driver.findElement(By.id(id)).sendKeys(porcento);
		}
		
		public void inserirDiasIsentosHonorários (String id, String diasHonorários) {
			driver.findElement(By.id(id)).sendKeys(diasHonorários);
		}
		
		public void inserirHonoráriosVincendas (String id, String porcento) {
			driver.findElement(By.id(id)).sendKeys(porcento);
		}
		
		public void inserirMínimaHonorário (String id, String mínima) {
			driver.findElement(By.id(id)).sendKeys(mínima);
		}
		
	
	//------------DSL vincular calculo pc------------//
		
		public void clicarBotãoVincular () {
			driver.findElement(By.id("chamaVincula")).click();
		}
		
		public void selecionarGrupo (String id, String nomeGrupo) {
			WebElement grupo = driver.findElement(By.id(id));
			Select selecionarGrupo = new Select (grupo);
			selecionarGrupo.selectByVisibleText(nomeGrupo);
		}
		
		public void selecionarTodosClientesClientes (String id, String nomeCliente) {
			WebElement clientes = driver.findElement(By.id(id));
			Select selecionarClientes = new Select (clientes);
			selecionarClientes.selectByVisibleText(nomeCliente);
		}
		
		public WebElement tabelaPC () {
			return driver.findElement(By.xpath("//*[@id=\"gridCalculo\"]/table/tbody/tr[2]/td/div/div/table"));
		}
		
		public String descriçãoTabelaPC (WebElement tabela, int idLinha) {
			String descrição = tabela.findElement(By.xpath(".//tr[" +  idLinha + "]/td[1]")).getText();
			return descrição;
		}
		
		public String validarVinculo(String nomeGrupo, String id) {
			List<WebElement> valida = driver.findElements(By.xpath("//*[@id=\"treeCalculo\"]/ul/li"));
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
