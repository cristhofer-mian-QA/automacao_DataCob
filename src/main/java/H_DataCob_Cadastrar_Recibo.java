import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@FixMethodOrder (MethodSorters.NAME_ASCENDING)
public class H_DataCob_Cadastrar_Recibo {
	WebDriver driver;
	Variáveis_H_Cadastrar_Recibo recibo;
	Variáveis_Login login;
	_Page_Menu_Superior menu;
	_Page_Menu_Parametros subMenu;
	
	
	@Test
	public void A_Cadastrar_Recibo() throws InterruptedException {
			Thread.sleep(7000);		
		driver = new FirefoxDriver();
		recibo = new Variáveis_H_Cadastrar_Recibo(driver);
		login = new Variáveis_Login (driver);
		menu = new _Page_Menu_Superior (driver);
		subMenu = new _Page_Menu_Parametros (driver);

		login.login();
		menu.clicarParametros();
		menu.clicarVisualizarParâmetros();
		recibo.esperarCssSelector("h1.titulo");
		subMenu.clicarMenuOpções();
		subMenu.clicarSubMenuRecibo();
		recibo.esperarId("cadastra");
		recibo.clicarBotãoCadastra();
		recibo.esperarId("inputPadrao");
		recibo.inserirDescrição(recibo.descriçãoRecibo);
		recibo.clicarCheckBoxVincendaDataCob();
		recibo.clicarCheckBoxVincendaDataPact();
		recibo.nãoMarcarRepasseObrigatório();
		recibo.inserirBaixaApósVencimento(recibo.baixaVencimento);
		recibo.clicarAçãoApósVencimento();
		recibo.clicarSeleçãoParcelas();
		recibo.clicarOkcss(".caixa_bottom > a:nth-child(2)");
		recibo.esperarXPATH("//*[@id='gridRecibo']/table/tbody/tr[2]/td/div/div/table/tbody/tr[2]");
			Thread.sleep(2000);
		WebElement tabelaRecibo = recibo.tabelaRecibo("//*[@id='gridRecibo']/table/tbody/tr[2]/td/div/div/table");
		int numLinha = recibo.linhaRecibo( recibo.descriçãoRecibo,tabelaRecibo);
		WebElement linhaCorreta = tabelaRecibo.findElement(By.xpath(".//tr[" + numLinha + "]/td[2]"));
		linhaCorreta.click();
		
		driver.quit();
	}

	
}
