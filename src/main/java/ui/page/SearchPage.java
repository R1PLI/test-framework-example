package ui.page;


import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import ui.core.IPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage implements IPage {


	@Override
	public SearchPage open() {
		Selenide.open("/");
		return this;
	}

	public SearchPage search(String searchQuery) {
		$(By.name("q")).setValue(searchQuery).pressEnter();
		return this;
	}

	public void verifySearchResult(int criteria) {
		$$(".srg .g").shouldHaveSize(criteria);
	}
}
