import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class I_DataCob_Cadastrar_Ocorrencias_Sistema {
	WebDriver driver;
	Variáveis_I_Cadastrar_Ocorrências_Sistema sistema;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	
	@Before
	public void iniciarSistema() throws InterruptedException {
		driver = new FirefoxDriver();
		Thread.sleep(7000);		
		sistema = new Variáveis_I_Cadastrar_Ocorrências_Sistema(driver);
		login = new Variáveis_Login (driver);
		menu = new _Page_Menu_Superior (driver);
		
		
		login.login();
		menu.clicarParametros();
		menu.clicarOcorrências();
		menu.clicarSistema();
		sistema.esperarCssSelector("#botoesAdicionarEditar > a:nth-child(1)");
	}
	
	
	@After
	public void fecharNavegador() {
		driver.quit();
	}
	
	
	@Test
	public void A_Adicionar_Ocorrência_Retorno_Sem_Alterar_Status_Contrato() throws InterruptedException {
		sistema.clicarAdicionarOcorrência();
		sistema.esperarId("DESCRICAO");
		sistema.inserirCodOcorrencia("COD_OCORRENCIA", sistema.codigoRetorno);
		sistema.inserirDescrição("DESCRICAO", sistema.descricaoRetorno);
		sistema.checkBoxMarcarCobrado("MARCA_COBRADO");
		sistema.checkBoxMarcarUltimoHistorico("MARCA_ULTIMO_HISTORICO");
		sistema.checkBoxOcorrenciaPositiva("OCORR_POSITIVA");
		sistema.checkBoxUtilizarAPI("OCORR_API");
		sistema.clicarObsPadrão("btnObservacaoPadrao");
		sistema.esperarId("txtObsPadrao");
		sistema.inserirObsPadrão("txtObsPadrao", sistema.observaçãoPadrão);
		sistema.clicarConfirmar("salvarMensagem");
			Thread.sleep(3000);
		sistema.clicarAgendarRetorno("ValorIntervalo-HoraCorrente-RadioButton");
		sistema.inserirDiasRetorno("ValorIntervalo-HoraCorrente-Text", sistema.dias);
		sistema.selecionarComboPeriodo("ValorIntervalo-HoraCorrente-Select", "Dia");
		sistema.clicarAgendamentoManual("ckAgendamentoManual");
		sistema.selecionarComboTipo("ComboTipo", sistema.tipoAgendamento);
		sistema.inserirDiasAlerta("diasAlerta", sistema.diasAlerta);
		sistema.selecionarComboPeriodoLimite("validarComplemento-Unidade", "Dias");
		sistema.inserirPeriodoLimite("validarComplemento-Intervalo", sistema.periodoLimite);
		sistema.inserirDescrição("DES_COMPLEMENTO", sistema.descriçãoComplemento);
		sistema.clicarCheckBoxEnviarCliente("ENVIAR_CLIENTE");
		sistema.clicarCheckBoxExibirOcorrencia("Exibir_Ocorrencias");
		sistema.clicarCheckBoxCPC("ckCPC");
		sistema.clicarTipoAtendimento("rdTipoAtendimentoAmbos");
		sistema.clicarCheckBoxVincTelefone("VINCULAR_TELEFONE");		
		sistema.clicarCheckBoxTodosGrupos("chkSelecionarTodosGruposUsuarios");
		sistema.clicarCheckBoxTodasFases("TFases");
			Thread.sleep(2000);
		sistema.clicarSalvar("btSalvarFormOcor");
		sistema.esperarCssSelector(".textoAlerta");
		String mensagemConfirm = sistema.mensagem(".textoAlerta");
		sistema.validarMensagem("Ocorrência Sistema \"inserida\" com sucesso.", mensagemConfirm);
		sistema.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}
	
	
	@Test
	public void B_Adicionar_Ocorrência_Retorno_Alterar_Status_Contrato() throws InterruptedException {
		sistema.clicarAdicionarOcorrência();
		sistema.esperarId("DESCRICAO");
		sistema.inserirCodOcorrencia("COD_OCORRENCIA", sistema.codigoRetornoAlteraStatus);
		sistema.inserirDescrição("DESCRICAO", sistema.descricaoRetornoAlteraStatus);
		sistema.checkBoxMarcarCobrado("MARCA_COBRADO");
		sistema.checkBoxMarcarUltimoHistorico("MARCA_ULTIMO_HISTORICO");
		sistema.checkBoxOcorrenciaPositiva("OCORR_POSITIVA");
		sistema.checkBoxUtilizarAPI("OCORR_API");
		sistema.clicarObsPadrão("btnObservacaoPadrao");
		sistema.esperarId("txtObsPadrao");
		sistema.inserirObsPadrão("txtObsPadrao", sistema.observaçãoPadrão);
		sistema.clicarConfirmar("salvarMensagem");
			Thread.sleep(3000);
		sistema.clicarAgendarRetorno("ValorIntervalo-HoraCorrente-RadioButton");
		sistema.inserirDiasRetorno("ValorIntervalo-HoraCorrente-Text", sistema.dias);
		sistema.selecionarComboPeriodo("ValorIntervalo-HoraCorrente-Select", "Dia");
		sistema.clicarAgendamentoManual("ckAgendamentoManual");
		sistema.selecionarComboTipo("ComboTipo", sistema.tipoAgendamento);
		sistema.inserirDiasAlerta("diasAlerta", sistema.diasAlerta);
		sistema.selecionarComboPeriodoLimite("validarComplemento-Unidade", "Dias");
		sistema.inserirPeriodoLimite("validarComplemento-Intervalo", sistema.periodoLimite);
		sistema.inserirDescrição("DES_COMPLEMENTO", sistema.descriçãoComplemento);
		sistema.clicarCheckBoxEnviarCliente("ENVIAR_CLIENTE");
		sistema.clicarCheckBoxExibirOcorrencia("Exibir_Ocorrencias");
		sistema.clicarCheckBoxCPC("ckCPC");
		sistema.clicarTipoAtendimento("rdTipoAtendimentoAmbos");
		sistema.clicarCheckBoxVincTelefone("VINCULAR_TELEFONE");
		
		WebElement tabStatus = sistema.tabelaStatus("//*[@id=\"gridStatusContrato\"]/table/tbody/tr[2]/td/div/div/table");
		int nrLinha = sistema.idLinha("Agendado", tabStatus);
		WebElement linhaStatus = tabStatus.findElement(By.xpath(".//tr[" + nrLinha + "]/td[1]"));
		linhaStatus.click();
		
		sistema.clicarCheckBoxTodosGrupos("chkSelecionarTodosGruposUsuarios");
		sistema.clicarCheckBoxTodasFases("TFases");
			Thread.sleep(2000);
		sistema.clicarSalvar("btSalvarFormOcor");
		sistema.esperarCssSelector(".textoAlerta");
		String mensagemConfirm = sistema.mensagem(".textoAlerta");
		sistema.validarMensagem("Ocorrência Sistema \"inserida\" com sucesso.", mensagemConfirm);
		sistema.clicarOkcss(".caixa_bottom > a:nth-child(1)");	
	}
}
