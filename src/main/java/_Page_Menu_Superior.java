import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class _Page_Menu_Superior {
		WebDriver driver;
		public _Page_Menu_Superior (WebDriver driver) {
			this.driver = driver;
		}
		
		public void clicarParametros () {
			driver.findElement(By.cssSelector(".itemParametros > a:nth-child(1)")).click();
		}
		
		public void clicarCadastrar () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(1) > a:nth-child(1)")).click();
		}
		
		public void clicarGrupoClienteFase () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(1) > ul:nth-child(2) > li:nth-child(8) > a:nth-child(1)")).click();
		}
		
		public void clicarEmpresaFilial () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a:nth-child(1)")).click();
		}
		
		public void clicarVisualizarParâmetros () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(11)")).click();
		}
		
		public void clicarSubmenuConta () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(2)")).click();
		}
		
		public void clicarModeloCarta () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(5)")).click();
		}
		
		public void clicarModeloAcordo () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(5) > ul:nth-child(2) > li:nth-child(1)")).click();
		}
		
		public void clicarModeloBoleto () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(5) > ul:nth-child(2) > li:nth-child(2)")).click();
		}
		
		public void clicarModeloWord () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(5) > ul:nth-child(2) > li:nth-child(3)")).click();
		}
		
		public void clicarOcorrências () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(7)")).click();
		}
		
		public void clicarSistema () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(7) > ul:nth-child(2) > li:nth-child(2)")).click();
		}
		
		public void clicarCliente () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(7) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();
		}
		
		
		public void clicarTipoCustas () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(10) > a:nth-child(1)")).click();
		}
	
		public void clicarCustasSistema () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(10) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")).click();
		}
		
		public void clicarCustasCliente () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(10) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)")).click();
		}
		
		public void clicarJuridico () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(4) > a:nth-child(1)")).click();
		}
		
		public void clicarComarca () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(4) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)")).click();
		}
		
		public void clicarFeriado () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(3) > a:nth-child(1)")).click();
		}
		

		public void clicarFaseProcesso() {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(4) > ul:nth-child(2) > li:nth-child(6) > a:nth-child(1)")).click();
		}

		public void clicarProcessoAndamento () {
			driver.findElement(By.cssSelector("#submenu_extracoes > li:nth-child(4) > ul:nth-child(2) > li:nth-child(2)")).click();
		}
		
		public void clicarOperações () throws InterruptedException {
			driver.findElement(By.cssSelector("#menu_movimenta > ul > li.itemOperacoes > a")).click();
			Thread.sleep(500);
		}
		
		public void clicarAtendimento () {
			driver.findElement(By.cssSelector("#submenu_operacoes > li:nth-child(3)")).click();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
