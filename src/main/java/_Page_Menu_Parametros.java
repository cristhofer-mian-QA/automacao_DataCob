import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class _Page_Menu_Parametros {
	WebDriver driver;
	public _Page_Menu_Parametros (WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void clicarMenuOpções () {
		driver.findElement(By.id("menuOpcoes")).click();
	}
	
	public void clicarSubMenuCálculo () {
		driver.findElement(By.cssSelector("#menuOpcoes > li:nth-child(1)")).click();
	}
	
	public void clicarSubMenuCálculoPC () {
		driver.findElement(By.id("target0")).click();
	}

	public void clicarSubMenuAcordo () {
		driver.findElement(By.id("target5")).click();
	}
	
	public void clicarSubMenuBoleto () {
		driver.findElement(By.cssSelector("#menuOpcoes > li:nth-child(2) > span:nth-child(1)")).click();
	}
	
	public void clicarSubMenuEnvio () throws InterruptedException {
		driver.findElement(By.id("1")).click();
		Thread.sleep(1000);
	}
	
	public void clicarSubMenuConta () {
		driver.findElement(By.id("2")).click();
	}
	
	public void clicarSubMenuBoleto (String cssSelector) {
		driver.findElement(By.cssSelector(cssSelector)).click();
	}
	
	public void clicarSubMenuBoletoModelo () {
		driver.findElement(By.id("3")).click();
	}
	
	public void clicarSubMenuRecibo () {
		driver.findElement(By.id("7")).click();
	}
	
	public void clicarSubMenuOcorrencia () {
		driver.findElement(By.cssSelector("#menuOpcoes > li:nth-child(5) > span:nth-child(1)")).click();
	}
	
	public void clicarSubMenuHistórico () {
		driver.findElement(By.id("10")).click();
	}
	

	public void clicarSubMenuDespesas () {
		driver.findElement(By.id("18")).click();
	}
	
	
	
	
	
	
	
	
	
}
