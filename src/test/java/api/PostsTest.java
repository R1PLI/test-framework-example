package api;

import api.beans.Post;
import api.beans.PostAssert;
import api.helper.UrlHelper;
import api.mappers.IPost;
import api.mappers.IService;
import com.google.common.truth.Truth;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static api.response.body.PojoFromService.getStatusCodeAfterPostRequest;
import static api.response.body.PojoFromService.postsResponseQuery;
import static java.util.Arrays.asList;
import static org.apache.http.HttpStatus.*;

public class PostsTest {
	private static IPost iPost = ConfigFactory.create(IPost.class);
	private static IService iService = ConfigFactory.create(IService.class);
	private static UrlHelper url = new UrlHelper(iService.protocol(), iService.host(), iService.posts());

	@Test
	public void restAssuredPositivePostsTest() {
		PostAssert.assertThat(
			postsResponseQuery(1, url.urlBuilder())
		).hasTitle(iPost.title());
	}

	@Test
	public void restAssuredNegativePostsTest() {
		Assertions.assertThat(
			postsResponseQuery(2, url.urlBuilder())
				.getTitle()
		).isNotEqualTo(iPost.title());
	}

	@Test
	public void postRequestTest() {
		int postId = 15;
		Post postRequest = new Post(postId, "post-test", "myself");

		Assertions.assertThat(
			getStatusCodeAfterPostRequest(url.urlBuilder(), postRequest)
				.statusCode()
		).isEqualTo(SC_CREATED);

		PostAssert.assertThat(
			postsResponseQuery(postId, url.urlBuilder())
		).hasId(postId).hasTitle("post-test").hasAuthor("myself");
	}

	@Test
	public void postRequestUsingTruthsIsAnyMethodTest() {
		int postId = 16;
		Post postRequest = new Post(postId, "post-test", "myself");

		Truth.assertThat(
			getStatusCodeAfterPostRequest(url.urlBuilder(), postRequest)
				.statusCode()
		).isAnyOf(SC_CREATED, SC_OK);

		PostAssert.assertThat(
			postsResponseQuery(postId, url.urlBuilder())
		).hasId(postId).hasTitle("post-test").hasAuthor("myself");
	}

	@Test
	public void postRequestUsingTruthsIsInTest() {
		int postId = 17;
		Post postRequest = new Post(postId, "post-test", "myself");

		Truth.assertThat(
			getStatusCodeAfterPostRequest(url.urlBuilder(), postRequest)
				.statusCode()
		).isIn(asList(SC_OK, SC_CREATED, SC_ACCEPTED));

		PostAssert.assertThat(
			postsResponseQuery(postId, url.urlBuilder())
		).hasId(postId).hasTitle("post-test").hasAuthor("myself");
	}
}
