import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variáveis_Login {
WebDriver driver;
	
	public Variáveis_Login (WebDriver driver) {
		this.driver = driver;
	}
	
	String usuario = "cristhofer.mian@ph3a.com.br";
	String senha = "piratafast152";
	
	public void login () {
		driver.get("https://homologacao3.datacob.com.br/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".dadosLogin > input:nth-child(4)")).sendKeys(usuario);
		driver.findElement(By.cssSelector(".dadosLogin > input:nth-child(8)")).sendKeys(senha);
		driver.findElement(By.id("link")).click();
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#headerDetalhePagina > div > h1.titulo")));
	}
}
