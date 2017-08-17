package api;

import api.beans.BodyAssert;
import api.beans.CommentAssert;
import api.beans.PostAssert;
import api.mappers.IComment;
import api.mappers.IPost;
import org.aeonbits.owner.ConfigFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import static api.response.body.CommentPojoFromService.commentResponseQuery;
import static api.response.body.PostPojoFromService.postResponseQuery;

public class BaseTest {

	private static IPost iPost;
	private static IComment iComment;

	@BeforeClass
	public static void propInit() {
		iPost = ConfigFactory.create(IPost.class);
		iComment = ConfigFactory.create(IComment.class);
	}

	@Test
	public void restAssuredPassedTest() {
		PostAssert.assertThat(
			postResponseQuery(1)
		).hasTitle(iPost.title());
	}

	@Test
	public void restAssuredFailedTest() {
		PostAssert.assertThat(
			postResponseQuery(1)
		).hasTitle(iPost.title() + "s");
	}

	@Test
	public void restAssuredValidTest() {
		PostAssert.assertThat(
			postResponseQuery(2)
		).hasTitle(iPost.title() + "s");
	}

	@Test
	public void restAssuredCommentsBodyTest() {
		BodyAssert.assertThat(commentResponseQuery(1)
			.getBody()
		).hasSomeComment(iComment.bodyComment()
			.getSomeComment()
		);
	}

	@Test
	public void restAssuredCommentsPostTest() {
		CommentAssert.assertThat(
			commentResponseQuery(1)
		).hasPostComment(iComment.postComment());
	}
}
