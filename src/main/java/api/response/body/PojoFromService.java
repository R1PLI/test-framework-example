package api.response.body;

import api.beans.Comment;
import api.beans.Post;
import io.restassured.response.ExtractableResponse;

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

	public static <T> ExtractableResponse getResponseEntityFromPostRequest(String url, T pojo) {
		return
			given()
				.spec(getSpec(url))
				.body(pojo)
				.when()
				.post()
				.then()
				.extract();
	}

	public static Post postsResponseQuery(int postId, String url) {
		return getResponseQuery(postId, Post.class, url);
	}

	public static Comment commentsResponseQuery(int postId, String url) {
		return getResponseQuery(postId, Comment.class, url);
	}
}
