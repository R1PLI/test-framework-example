package ui;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ui.core.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class GmailTest extends BaseTest {

	@BeforeClass
	public void config() {
		Configuration.baseUrl = "https://www.google.com/gmail/about";
	}

	@Test
	public void fullTest() {

		gmailMainPage.open()
			.clickSignInButton();

		assertThat(loginPage
			.submitCreds("EpamFinalTask17", "tinker11")
			.getTextFromAreaLabel()
		).isEqualTo("Oleksandr Pochernin");
	}
}
