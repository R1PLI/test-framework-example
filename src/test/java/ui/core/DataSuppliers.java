package ui.core;

import org.testng.annotations.DataProvider;

public class DataSuppliers {
	@DataProvider(name = "Search Queries")
	public static Object[][] queries() {
		return new Object[][] {
			{"Selenide", 10},
			{"Overwatch", 7},
			{"Motocars", 9}
		};
	}
}
