package api.response.body;

import api.beans.Comment;

import static api.config.Specification.getSpec;
import static io.restassured.RestAssured.given;

//TODO: remove redundant class if there are no sense in it
@Deprecated
public class CommentPojoFromService {
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

	public static Comment commentResponseQuery(int postId, String url) {
		return getResponseQuery(postId, Comment.class, url);
	}
}
