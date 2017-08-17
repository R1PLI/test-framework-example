package api.response.body;

import api.beans.Post;

import static api.config.Specification.getSpec;
import static io.restassured.RestAssured.given;

public class PostPojoFromService {
	private static <T> T getResponseQuery(int postId, Class<T> tClass, String url) {
		return
			given()
				.spec(getSpec(url))
				.when()
				.get("/{id}", postId)
				.then()
				.extract()
				.response().as(tClass);
	}

	public static Post postResponseQuery(int postId, String url) {
		return getResponseQuery(postId, Post.class, url);
	}
}
