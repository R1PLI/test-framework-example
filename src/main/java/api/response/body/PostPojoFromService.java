package api.response.body;

import api.beans.Post;

import static api.config.Specification.getSpec;
import static io.restassured.RestAssured.given;

//TODO: remove redundant class if there are no sense in it
@Deprecated
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

	public static Post postsResponseQuery(int postId, String url) {
		return getResponseQuery(postId, Post.class, url);
	}
}
