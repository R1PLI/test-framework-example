package ui;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.page.GmailMainPage;
import ui.page.SearchPage;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseTest {
	private SearchPage searchPage;
	private GmailMainPage gmailMainPage;

	@BeforeClass
	public void driverSetUp() {
		ChromeDriverManager.getInstance().setup();
		Configuration.browser = "chrome";
	}

	@Test
	public void baseOpenTest() {
		Configuration.baseUrl = "http://google.co.uk";
		new SearchPage().open()
			.search("Selenide")
			.verifySearchResult(10);
	}

	@Test
	public void fullTest() {
		Configuration.baseUrl = "https://gmail.com";
		assertThat(new GmailMainPage()
			.open()
			.clickSignInButton()
			.submitCreds("EpamFinalTask17", "tinker11")
			.getTextFromAreaLabel()
		).isEqualTo("Oleksandr Pochernin");
	}
}
