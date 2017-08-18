package api.response.body;

import api.beans.Comment;
import api.beans.Post;

import static api.config.Specification.getSpec;
import static io.restassured.RestAssured.given;

public class PojoFromService {
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

	public static void postRequest(String url, String jsonBody) {
		given()
			.spec(getSpec(url))
			.body(jsonBody)
		.when()
			.post();
	}

	public static Post postsResponseQuery(int postId, String url) {
		return getResponseQuery(postId, Post.class, url);
	}

	public static Comment commentsResponseQuery(int postId, String url) {
		return getResponseQuery(postId, Comment.class, url);
	}
}
