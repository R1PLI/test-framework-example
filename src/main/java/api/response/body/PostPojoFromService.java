package api.response.body;

import api.beans.Post;
import io.restassured.specification.RequestSpecification;

import static api.config.Specification.getSpec;
import static io.restassured.RestAssured.given;

public class PostPojoFromService {
	private static RequestSpecification postsReq = getSpec("http://localhost:3000/posts");

	private static <T> T responseQuery(int postId, Class<T> tClass) {
		return
			given()
				.spec(postsReq)
				.when()
				.get("/{id}", postId)
				.then()
				.extract()
				.response().as(tClass);
	}

	public static Post postResponseQuery(int postId) {
		return responseQuery(postId, Post.class);
	}
}
