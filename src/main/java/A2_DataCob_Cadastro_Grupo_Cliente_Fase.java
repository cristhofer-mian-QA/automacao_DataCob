import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class A2_DataCob_Cadastro_Grupo_Cliente_Fase {

	
	WebDriver driver;
	Variaveis_A2_Cadastro_Grupo_Cliente_Fase GCF;
	Variáveis_Login login;
	Variaveis_A_Cadastrar_Fase fase;
	Variaveis_A1_Cadastrar_Empresa_Filial filial;
	_Page_Menu_Superior menu;
	
		
	@Test
	public void cadastrarGrupo() throws InterruptedException {
		driver = new FirefoxDriver();
		GCF = new Variaveis_A2_Cadastro_Grupo_Cliente_Fase (driver);
		login = new Variáveis_Login (driver);
		fase = new Variaveis_A_Cadastrar_Fase (driver);
		filial = new Variaveis_A1_Cadastrar_Empresa_Filial (driver);
		menu = new _Page_Menu_Superior (driver);
		
		login.login();
		menu.clicarParametros();
		menu.clicarCadastrar();
		menu.clicarGrupoClienteFase();
		GCF.esperarId("adcionarGrupo");
		
		GCF.clicarAdicionarGrupo("adcionarGrupo");
		GCF.esperarId("descricaoGrupo");
		GCF.inserirDescrição("descricaoGrupo", GCF.nomeGrupo);
		GCF.selecionarComboRotina("listRotSis", "PADRAO");
		GCF.selecionarComboAgrupamento("listModoAgrupamento", "Padrão da Recepção");
		GCF.selecionarAgrupamentoDataPact("listModoAgrupamentoDataPact", "Por Financiado");
		GCF.selecionarAgrupamentoMailling("listModoAgrupamentoMailing", "Por Contrato");
		GCF.selecionarComboMarcaçãoFeriado("idMarcacaoFeriado", "Não marcar");		
		GCF.clicarCapitalizarNomeFinanciado("chkCapitalizarNomeFinanciado");
		GCF.clicarAtualizarEndereçoPrincipal("chkAtualizarEnderecoCarta");
		GCF.clicarAtualizarEmailPrincipal("chkAtualizarEmailCarta");
		GCF.clicarOk(".caixa_bottom > a:nth-child(2)");
		GCF.esperarCssSelector(".barra_top > h1:nth-child(1)");
		String mensagemSucesso = GCF.mensagem(".barra_top > h1:nth-child(1)");
		GCF.validarMensagem("Sucesso", mensagemSucesso);
		GCF.clicarOk(".caixa_bottom > a:nth-child(1)");
			Thread.sleep(7000);
		
		//-------------------------cadastrar cliente-------------------------//
			
		GCF.buscarGrupo(GCF.nomeGrupo);
		GCF.clicarAdicionarCliente("adcionarCliente");
		GCF.esperarId("confirmaCliente");
		GCF.selecionarComboGrupo ("adcionarCliente", GCF.nomeGrupo);
		GCF.inserirNomeResumido("nomeResumido", GCF.nomeResumido);
		GCF.inserirRazãoSocial("razaoSocial", GCF.razaoSocial);
		GCF.inserirCNPJ("cpfCnpj", mensagemSucesso);
		GCF.limparInscriçãoEstadual("iEst");
		GCF.selecionarTipoProduto("tipoProduto");
		GCF.inserirNumero("numero", GCF.numero);
		GCF.inserirComplemento("complemento",GCF.complemento);
		GCF.inserirBairro("bairro", GCF.bairro);
		GCF.inserirCidade("cidade", GCF.cidade);
		GCF.inserirCEP("cep", GCF.cep);
		GCF.selecionarUF("uf");
		GCF.inserirDDD("ddd", GCF.ddd);
		GCF.inserirTelefone("telefone", GCF.telefone);
		GCF.limparRamal("ramal");
		GCF.inserirEmail("emailCliente", GCF.email);
		GCF.clicarNegociarAcordo("negociarPorAcordo");
		GCF.clicarBotãoAtivo("ativo");
		GCF.clicarBotãoConfirmar("confirmaCliente");
		GCF.esperarCssSelector(".textoAlerta");
		String mensagemSucesso2 = GCF.mensagem(".textoAlerta");
		GCF.validarMensagem("Cliente cadastrado com sucesso", mensagemSucesso2);
		GCF.clicarOk(".caixa_bottom > a:nth-child(1)");
			Thread.sleep(7000);
		
		//-------------------------vincular fase e filial-------------------------//
		
		GCF.buscarGrupo(GCF.nomeGrupo);
			Thread.sleep(1000);
		GCF.buscarCliente(GCF.razaoSocial);
		GCF.clicarVincularFase("editarFase");
		GCF.esperarXPATH("//*[@id=\'gridFaseEmpresa\']/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/div");
		GCF.buscarFaseAM(fase.faseAM, fase.descFaseAM);
		GCF.buscarFaseJU(fase.faseJU, fase.descFaseJU);
		GCF.buscarFilial(filial.nomeFilial);
		GCF.clicarBotãoConfirmarCSS(".caixa_bottom > a:nth-child(2)");
		GCF.esperarCssSelector(".barra_top > h1:nth-child(1)");
		String mensagemCadastroSucesso = GCF.mensagem(".barra_top > h1:nth-child(1)");
		GCF.validarMensagem("Sucesso", mensagemCadastroSucesso);
		GCF.clicarOk(".caixa_bottom > a:nth-child(1)");
			Thread.sleep(2000);
		
		//-------------------------vincular fase sem filial-------------------------//			
			
		GCF.buscarGrupo(GCF.nomeGrupo);
			Thread.sleep(1000);
		GCF.buscarCliente(GCF.razaoSocial);
		GCF.clicarVincularFase("editarFase");
		GCF.esperarXPATH("//*[@id=\'gridFaseEmpresa\']/table/tbody/tr[1]/td/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/div");
		GCF.buscarFaseAM(fase.faseAM, fase.descFaseAM);
		GCF.buscarFaseJU(fase.faseJU, fase.descFaseJU);
		GCF.buscarFilial(filial.nomeFilial);
		GCF.clicarBotãoConfirmarCSS(".caixa_bottom > a:nth-child(2)");
		GCF.esperarCssSelector(".barra_top");
		String mensagemCadastroErro = GCF.mensagem(".barra_top");
		GCF.validarMensagem("Atenção", mensagemCadastroErro);
		GCF.clicarOk(".caixa_bottom > a:nth-child(1)");
		driver.quit();
	}
}
