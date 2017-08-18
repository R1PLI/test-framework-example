package ui;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.page.GmailMainPage;
import ui.page.SearchPage;

import static org.assertj.core.api.Assertions.assertThat;


public class BaseTest {
	private SearchPage searchPage;
	private GmailMainPage gmailMainPage;

	@BeforeMethod
	public void setUp() {

		searchPage = new SearchPage();
		gmailMainPage = new GmailMainPage();
	}


	@Test
	public void baseOpenTest() {
		Configuration.baseUrl = "http://google.co.uk";
		searchPage.open()
			.search("Selenide")
			.verifySearchResult(10);
	}

	@Test
	public void fullTest() {
		Configuration.baseUrl = "http://accounts.google.com";
		assertThat(gmailMainPage.open()
			.submitCreds("EpamFinalTask17", "tinker11")
			.areaLabel()
		).isEqualTo("Oleksandr Pochernin");
	}
}
