package ui;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.core.BaseTest;
import ui.core.DataSuppliers;

public class GoogleSearchTest extends BaseTest {

	@BeforeClass
	public void config() {
		Configuration.baseUrl = config.google();
	}

	@Test(dataProvider = "Search Queries", dataProviderClass = DataSuppliers.class)
	public void baseOpenTest(String query, int results) {
		searchPage.open()
			.search(query)
			.verifySearchResult(results);
	}
}
