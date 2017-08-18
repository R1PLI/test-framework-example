package ui.page;

import org.openqa.selenium.By;
import ui.core.IPage;

import static com.codeborne.selenide.Selenide.$;

public class InboxPage implements IPage{
	@Override
	public InboxPage open() {
		return this;
	}

	private static final By ariaLabel = By.xpath("//*[@aria-label=\"Account Information\"]/div[1]/div[1]/div[1]");

	public String areaLabel() {
		$(By.xpath("//*[@id=\"gb\"]/div[1]/div[1]/div[2]/div[5]")).click();
		return $(ariaLabel).getText();
	}
}
