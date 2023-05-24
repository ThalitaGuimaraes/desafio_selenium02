package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import helpers.ScreenShotHelper;

public class CriarContaParaEmpresaTest {

	@Test
	public void testCriarContaParaEmpresaComSucesso() {

		// configurando o driver para executar o navegador do google chrome
		System.setProperty("webdriver.chrome.driver", "c:\\testes\\chromedriver.exe");

		// abrindo o google chrome
		WebDriver driver = new ChromeDriver();

		// acessando a página de cadastro da empresa
		driver.get("https://www.grocerycrud.com/v1.x/demo/bootstrap_theme");

		// colocando o navegador em 'tela cheia'
		driver.manage().window().maximize();

		// mudar o valor da combo Select version para "Bootstrap V4 Theme"
		driver.findElement(By.xpath("//*[@id=\"switch-version-select\"]")).click();

		// clicar no botão Add Customer
		driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a")).click();

		// preencher os campos do formulário:
		driver.findElement(By.xpath("//*[@id=\"field-customerName\"]")).sendKeys("Teste Sicredi");
		driver.findElement(By.xpath("//*[@id=\"field-contactLastName\"]")).sendKeys("Teste");
		driver.findElement(By.xpath("//*[@id=\"field-contactFirstName\"]")).sendKeys("seu nome");
		driver.findElement(By.xpath("//*[@id=\"field-phone\"]")).sendKeys("519999-9999");
		driver.findElement(By.xpath("//*[@id=\"field-addressLine1\"]")).sendKeys("Av Assis Brazil,3970");
		driver.findElement(By.xpath("//*[@id=\"field-addressLine2\"]")).sendKeys("Torre D");
		driver.findElement(By.xpath("//*[@id=\"field-city\"]")).sendKeys("Porto Alegre");
		driver.findElement(By.xpath("//*[@id=\"field-state\"]")).sendKeys("RS");
		driver.findElement(By.xpath("//*[@id=\"field-postalCode\"]")).sendKeys("91000-000");
		driver.findElement(By.xpath("//*[@id=\"field-country\"]")).sendKeys("Brasil");
		driver.findElement(By.xpath("/html/body")).sendKeys("Fixter");
		driver.findElement(By.xpath("//*[@id=\"field-creditLimit\"]")).sendKeys("200");

		// clicar no botão Save
		driver.findElement(By.xpath("//*[@id=\"form-button-save\"]/i")).click();

		// ler a mensagem exibida pelo sistema
		String mensagem = driver.findElement(By.xpath("/html/body")).getText();

		// gerar uma evidência de teste
		ScreenShotHelper.create(driver, "Evidência - Criar Conta.png");

		// comparando o conteúdo da mensagem
		assertEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list",
				mensagem);

		// fechando o navegador
		driver.close();
	}

}
