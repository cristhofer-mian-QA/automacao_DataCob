import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class A1_DatCob_CadastrarEmpresa_Filial {
	WebDriver driver;
	Variáveis_Login login;
	Variaveis_A1_Cadastrar_Empresa_Filial filial;
	_Page_Menu_Superior menu;
		
	@Before
	public void Iniciar_Sistema() throws InterruptedException {
		driver = new FirefoxDriver();
		login = new Variáveis_Login (driver);
		filial = new Variaveis_A1_Cadastrar_Empresa_Filial(driver);
		menu = new _Page_Menu_Superior (driver);
		
		login.login();		
		menu.clicarParametros();
		menu.clicarCadastrar();
		menu.clicarEmpresaFilial();	
		filial.esperarId("btnCriarFilial");
	}
	
	@After
	public void fecharSistema () {
		driver.quit();
	}
	
	@Test
	public void A_Criar_Empresa() throws InterruptedException {
		filial.clicarCriarEmpresa("btnCriarEmpresa");
		filial.inserirRazão("txtCriarRazao", filial.nomeEmpresa);
		filial.inserirNomeEmpresa("txtCriarNomeRes", filial.nomeResponsavel);
		filial.clicarBotãoConfirmar(".caixa_bottom > a:nth-child(2)");
		String mensagemConfirmação = filial.mensagemSucesso(".barra_top");
		filial.validarMensagem("Sucesso", mensagemConfirmação);
		filial.clicarBotãoOk(".caixa_bottom > a:nth-child(1)");
	}
	
	@Test
	public void B_Criar_Filial() throws InterruptedException { 
		filial.esperarXpath("//*[@id=\'gridEmpresa\']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
		filial.buscarEmpresaTabela (filial.nomeEmpresa);
		filial.clicarCriarEmpresaFilial ("btnCriarFilial");
		filial.selecionarComboEmpresa (filial.nomeResponsavel);
		filial.clicarCriarFilial ("btnNovaFilial");
		filial.esperarCssSelector (".barra_top > h1:nth-child(1)");
		filial.inserirDescriçãoFilial ("txtFilialDescricao", filial.nomeFilial);
		filial.clicarBotãoConfirmar (".caixa_bottom > a:nth-child(2)");
		filial.clicarBotãoOk(".caixa_bottom > a:nth-child(1)");
			Thread.sleep(3000);
		filial.selecionarComboFilial ("txtCriarIdFilial", filial.nomeFilial);
		filial.inserirNrPosto ("txtCriarNrPosto", filial.nrPosto);
		filial.inserirCNPJ ("txtCriarCnpj", filial.cnpj);
		filial.inserirEndereço ("txtCriarEndereco", filial.endereço);
		filial.inserirBairro ("txtCriarBairro", filial.bairro);
		filial.inserirCidade ("txtCriarCidade", filial.cidade);
		filial.inserirUF ("txtCriarUf", filial.uf);
		filial.inserirCEP ("txtCriarCep", filial.cep);
		filial.inserirDDD ("txtCriarDdd", filial.ddd);
		filial.inserirTelefone ("txtCriarFone", filial.telefone);
		filial.inserirEmail ("txtCriarEmail", filial.email);
		filial.inserirSerieReciboFisico("CriarserieReciboFisica", filial.serieFisica);
		filial.inserirNrReciboFisico ("CriarnrReciboFisica", filial.reciboFisica);
		filial.inserirSerieRecidoEletronico("CriarserieReciboEletronica", filial.serieEletronica);
		filial.inserirNrReciboEletronico ("CriarnrReciboEletronica", filial.reciboEletronica);
		filial.clicarBotãoConfirmar(".caixa_bottom > a:nth-child(2)");
		filial.esperarCssSelector(".barra_top > h1:nth-child(1)");
		String mensagemSucesso = filial.mensagemSucesso(".barra_top");
		filial.validarMensagem("Sucesso", mensagemSucesso);
		filial.clicarBotãoOk(".caixa_bottom > a:nth-child(1)");
	}
	
	@Test
	public void C_Criar_Filial_Errado() throws InterruptedException { 
			Thread.sleep(3000);
		filial.buscarEmpresaTabela (filial.nomeEmpresa);
		filial.clicarCriarEmpresaFilial ("btnCriarFilial");
		filial.selecionarComboEmpresa (filial.nomeResponsavel);
		filial.selecionarComboFilial ("txtCriarIdFilial", filial.nomeFilial);
		filial.inserirNrPosto ("txtCriarNrPosto", filial.nrPosto);
		filial.inserirEndereço ("txtCriarEndereco", filial.endereço);
		filial.inserirBairro ("txtCriarBairro", filial.bairro);
		filial.inserirCidade ("txtCriarCidade", filial.cidade);
		filial.inserirUF ("txtCriarUf", filial.uf);
		filial.inserirCEP ("txtCriarCep", filial.cep);
		filial.inserirDDD ("txtCriarDdd", filial.ddd);
		filial.inserirTelefone ("txtCriarFone", filial.telefone);
		filial.inserirEmail ("txtCriarEmail", filial.email);
		filial.clicarBotãoConfirmar(".caixa_bottom > a:nth-child(2)");
		filial.esperarCssSelector(".barra_top > h1:nth-child(1)");
		String mensagemErro = filial.mensagemSucesso(".barra_top");
		filial.validarMensagem("Alerta", mensagemErro);
		filial.clicarBotãoOk(".caixa_bottom > a:nth-child(1)");
		driver.quit();
	}	
}
