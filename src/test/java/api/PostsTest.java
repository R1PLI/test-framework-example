package api;

import api.beans.Post;
import api.beans.PostAssert;
import api.helper.UrlHelper;
import api.mappers.IPost;
import api.mappers.IService;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static api.response.body.PojoFromService.getStatusCodeAfterPostRequest;
import static api.response.body.PojoFromService.postsResponseQuery;
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
		int postId = 13;
		Post postRequest = new Post(postId, "post-test", "myself");

		Assertions.assertThat(
			getStatusCodeAfterPostRequest(url.urlBuilder(), postRequest)
				.statusCode()
		).isEqualTo(SC_CREATED);

		PostAssert.assertThat(
			postsResponseQuery(postId, url.urlBuilder())
		).hasId(postId).hasTitle("post-test").hasAuthor("myself");
	}
}
