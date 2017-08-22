package ui;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.core.BaseTest;

public class GoogleSearchTest extends BaseTest {

	@BeforeClass
	public void config() {
		Configuration.baseUrl = "http://google.co.uk";
	}

	@Test
	public void baseOpenTest() {
		searchPage.open()
			.search("Selenide")
			.verifySearchResult(10);
	}
}
