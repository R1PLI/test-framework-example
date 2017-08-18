package api;

import api.beans.PostAssert;
import api.helper.UrlHelper;
import api.mappers.IPost;
import api.mappers.IService;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static api.response.body.PojoFromService.postRequest;
import static api.response.body.PojoFromService.postsResponseQuery;

public class PostsTest {
	private static IPost iPost = ConfigFactory.create(IPost.class);
	private static IService iService = ConfigFactory.create(IService.class);
	private static UrlHelper url = new UrlHelper(iService.protocol(), iService.host(), iService.posts());
	//TODO: make json request prettier than hardcoded string
	private String jsonRequest = " {\n"+
		"        \"id\": 5,\n"+
		"        \"title\": \"post-test\",\n"+
		"        \"author\": \"myself\"\n"+
		"    }";

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
		postRequest(url.urlBuilder(), jsonRequest);
		PostAssert.assertThat(
			postsResponseQuery(5, url.urlBuilder())
		).hasId(5).hasTitle("post-test").hasAuthor("myself");
	}
}
