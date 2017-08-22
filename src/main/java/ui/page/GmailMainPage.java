package ui.page;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import ui.core.IPage;

import static com.codeborne.selenide.Selenide.$;

public class GmailMainPage implements IPage {

	private static final By signInButton = Selectors.byText("Sign In");

	@Override
	public GmailMainPage open() {
		Selenide.open("/");
		return this;
	}

	public LoginPage clickSignInButton() {
		$(signInButton).click();
		return new LoginPage();
	}
}
