package api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Specification {
	public static RequestSpecification getSpec(String uri) {
		return new RequestSpecBuilder()
			.setContentType(ContentType.JSON)
			.setBaseUri(uri)
			.build();
	}
}
