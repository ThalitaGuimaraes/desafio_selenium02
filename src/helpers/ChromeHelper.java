package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeHelper {

	// método para abrir o navegador e acessar
	// uma página definida pelo caso de teste
	public static WebDriver create(String url) {

		System.setProperty("webdriver.chrome.driver", "C:\\testes\\chromedriver.exe");
		// abrindo o navegador e acessar a página de cadastro de usuários
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

		return driver;
	}
}
