package api;

import api.beans.PostAssert;
import api.helper.UrlHelper;
import api.mappers.IPost;
import api.mappers.IService;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;

import static api.response.body.PostPojoFromService.postResponseQuery;

public class PostsTest {
	private static IPost iPost;
	private static IService iService;
	private static UrlHelper url;


	@BeforeClass
	public static void propInit() {
		iPost = ConfigFactory.create(IPost.class);
		iService = ConfigFactory.create(IService.class);

		url = new UrlHelper(
			iService.protocol(),
			iService.host(),
			iService.posts()
		);
	}

	@Test
	public void restAssuredPositivePostsTest() {
		PostAssert.assertThat(
			postResponseQuery(1, url.urlBuilder())
		).hasTitle(iPost.title());
	}

	@Test
	public void restAssuredNegativePostsTest() {
		Assertions.assertThat(
			postResponseQuery(2, url.urlBuilder())
			.getTitle()
		).isNotEqualTo(iPost.title());
	}
}
