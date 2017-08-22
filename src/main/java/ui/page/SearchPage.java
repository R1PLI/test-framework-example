package ui.page;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import ui.core.IPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage implements IPage {

	private static final By searchField = By.name("q");
	private static final By results = By.cssSelector(".srg .g");

	@Override
	public SearchPage open() {
		Selenide.open("/");
		return this;
	}

	public SearchPage search(String searchQuery) {
		$(searchField).setValue(searchQuery).pressEnter();
		return this;
	}

	public void verifySearchResult(int criteria) {
		$$(results).shouldHaveSize(criteria);
	}
}
