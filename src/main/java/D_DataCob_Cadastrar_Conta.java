import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class D_DataCob_Cadastrar_Conta {
	WebDriver driver;
	Variaveis_1_Inserir_Financiado dsl;
	Variaveis_D_Cadastro_Conta_Banco banco;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
			
	@Before
	public void iniciarSistema() throws InterruptedException {
		Thread.sleep(7000);
		driver = new FirefoxDriver();
		banco = new Variaveis_D_Cadastro_Conta_Banco (driver);
		login = new Variáveis_Login (driver);
		menu = new _Page_Menu_Superior (driver);
		
		login.login();
		menu.clicarParametros();
		menu.clicarSubmenuConta();
	}
	
	@After
	public void fecharSistema () {
		driver.quit();
	}
	
	@Test
	public void A_Cadastrar_Conta_Banco_Bradesco() throws InterruptedException {
			Thread.sleep(3000);
		banco.esperarId("comboBanco");
		banco.selecionarBanco(banco.banco);
			Thread.sleep(2000);
		banco.clicarBotãoNovaConta();
			Thread.sleep(2000);
		banco.nãoClicarBuscarInfCedente();
		banco.inserirTitular(banco.titular);
		banco.inserirCpfCnpj(banco.cnpj);
		banco.inserirEndereço(banco.endereço);
		banco.inserirAgencia(banco.agencia);
		banco.inserirDigAgencia(banco.digitoAgencia);
		banco.inserirConta(banco.conta);
		banco.inserirDigConta(banco.digitoConta);
		banco.inserirCodCedente(banco.codCedente);
		banco.inserirDigCedente(banco.digCedente);
		banco.inserirCarteira("carteira", banco.carteira);
		banco.inserirLocalPagBoleto(banco.localPagamento);
		banco.inserirTaxaBancaria(banco.taxaBancaria);
		banco.inserirEspDoc(banco.dcto);
		banco.inserirCarteira("usoBanco", banco.carteira);
		banco.limparCIP();
		banco.nãoClicarPFE();
		banco.nãoClicarAceite();
		banco.limparDiasCancBoleto();
		banco.limparConvênio();
		banco.limparPix();
		banco.selecionarCNAB("400");
		banco.nãoClicarRegistrarBoleto();
		banco.nãoClicarDepIdentificado();
		banco.clicarAlterarNrBoleto();
		banco.tipoNrBoleto("Sequencial");
		banco.inserirNrInicial(banco.nInicial);
		banco.inserirNrFinal(banco.nFinal);
		banco.nãoClicarBoletoWebService();
		banco.nãoClicarEmitirBoleto();
		banco.nãoClicarNossoNr();
		banco.limparNossoNr();
		banco.limparCodEscritório();
		banco.clicarConfirmar();
		banco.esperarCssSelector(".textoAlerta");
		String mensagemSucesso = banco.mensagem(".textoAlerta");
		banco.validarMensagem ("As informações da conta foram registradas com sucesso!", mensagemSucesso);
		banco.clicarOkcss(".caixa_bottom > a:nth-child(1)");
	}

	
	@Test
	public void B_Cadastrar_Conta_Banco_Bradesco_Dados_Incorretos() throws InterruptedException {
			Thread.sleep(3000);
		banco.selecionarBanco(banco.banco);
			Thread.sleep(2000);
		banco.clicarBotãoNovaConta();
			Thread.sleep(2000);
		banco.nãoClicarBuscarInfCedente();
		banco.inserirTitular(banco.titular);
		banco.inserirCpfCnpj(banco.cnpj);
		banco.inserirEndereço(banco.endereço);
		banco.inserirAgencia("123456");
		banco.inserirDigAgencia(banco.digitoAgencia);
		banco.inserirConta(banco.conta);
		banco.inserirDigConta( banco.digitoConta);
		banco.inserirCodCedente(banco.codCedente);
		banco.inserirDigCedente(banco.digCedente);
		banco.inserirCarteira("carteira", banco.carteira);
		banco.inserirLocalPagBoleto(banco.localPagamento);
		banco.inserirTaxaBancaria(banco.taxaBancaria);
		banco.inserirEspDoc(banco.dcto);
		banco.inserirCarteira("usoBanco", banco.carteira);
		banco.limparCIP();
		banco.nãoClicarPFE();
		banco.nãoClicarAceite();
		banco.limparDiasCancBoleto();
		banco.limparConvênio();
		banco.limparPix();
		banco.selecionarCNAB("400");
		banco.nãoClicarRegistrarBoleto();
		banco.nãoClicarDepIdentificado();
		banco.clicarAlterarNrBoleto();
		banco.tipoNrBoleto("Sequencial");
		banco.inserirNrInicial(banco.nInicial);
		banco.inserirNrFinal(banco.nFinal);
		banco.nãoClicarBoletoWebService();
		banco.nãoClicarEmitirBoleto();
		banco.nãoClicarNossoNr();
		banco.limparNossoNr();
		banco.limparCodEscritório();
		banco.clicarConfirmar();
		banco.esperarCssSelector(".textoAlerta");
		String mensagemErro = banco.mensagem(".textoAlerta");
		banco.validarMensagem("A Agência deve possuir no máximo 4 dígitos.", mensagemErro);
		banco.clicarOkcss(".caixa_bottom > a:nth-child(1)");	
	}	
	
	
	@Test
	public void D_Cadastrar_Conta_Banco_Bradesco_Dados_Faltando() throws InterruptedException {
			Thread.sleep(3000);
		banco.selecionarBanco(banco.banco);
			Thread.sleep(2000);
		banco.clicarBotãoNovaConta();
			Thread.sleep(2000);
		banco.nãoClicarBuscarInfCedente();
		banco.inserirTitular("");
		banco.inserirCpfCnpj(banco.cnpj);
		banco.inserirEndereço(banco.endereço);
		banco.inserirAgencia("");
		banco.inserirDigAgencia(banco.digitoAgencia);
		banco.inserirConta(banco.conta);
		banco.inserirDigConta(banco.digitoConta);
		banco.inserirCodCedente(banco.codCedente);
		banco.inserirDigCedente(banco.digCedente);
		banco.inserirCarteira("carteira", banco.carteira);
		banco.inserirLocalPagBoleto(banco.localPagamento);
		banco.inserirTaxaBancaria(banco.taxaBancaria);
		banco.inserirEspDoc(banco.dcto);
		banco.inserirCarteira("usoBanco", banco.carteira);
		banco.limparCIP();
		banco.nãoClicarPFE();
		banco.nãoClicarAceite();
		banco.limparDiasCancBoleto();
		banco.limparConvênio();
		banco.limparPix();
		banco.selecionarCNAB("400");
		banco.nãoClicarRegistrarBoleto();
		banco.nãoClicarDepIdentificado();
		banco.clicarAlterarNrBoleto();
		banco.tipoNrBoleto("Sequencial");
		banco.inserirNrInicial(banco.nInicial);
		banco.inserirNrFinal(banco.nFinal);
		banco.nãoClicarBoletoWebService();
		banco.nãoClicarEmitirBoleto();
		banco.nãoClicarNossoNr();
		banco.limparNossoNr();
		banco.limparCodEscritório();
		banco.clicarConfirmar();
		banco.esperarCssSelector(".textoAlerta");
		String mensagemErro = banco.mensagem(".textoAlerta");
		banco.validarMensagem("Preencha os campos destacados.", mensagemErro);
		banco.clicarOkcss(".caixa_bottom > a:nth-child(1)");		
	}	
}
