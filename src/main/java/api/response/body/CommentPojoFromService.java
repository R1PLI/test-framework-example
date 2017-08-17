package api.response.body;

import api.beans.Comment;
import io.restassured.specification.RequestSpecification;

import static api.config.Specification.getSpec;
import static io.restassured.RestAssured.given;

public class CommentPojoFromService {
	private static RequestSpecification commentsReq = getSpec("http://localhost:3000/comments");

	private static <T> T responseQuery(int postId, Class<T> tClass) {
		return
			given()
				.spec(commentsReq)
				.when()
				.get("/{id}", postId)
				.then()
				.extract()
				.response().as(tClass);
	}

	public static Comment commentResponseQuery(int postId) {
		return responseQuery(postId, Comment.class);
	}
}
