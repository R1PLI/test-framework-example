package api;

import api.beans.BodyAssert;
import api.beans.CommentAssert;
import api.helper.UrlHelper;
import api.mappers.IComment;
import api.mappers.IService;
import org.aeonbits.owner.ConfigFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import static api.response.body.CommentPojoFromService.commentResponseQuery;

public class CommentsTest {
	private static IComment iComment;
	private static IService iService;
	private static UrlHelper url;

	@BeforeClass
	public static void propInit() {
		iComment = ConfigFactory.create(IComment.class);
		iService = ConfigFactory.create(IService.class);

		url = new UrlHelper(
			iService.protocol(),
			iService.host(),
			iService.comments()
		);
	}

	@Test
	public void restAssuredCommentsBodyTest() {
		BodyAssert.assertThat(commentResponseQuery(1, url.urlBuilder())
			.getBody()
		).hasSomeComment(iComment.bodyComment()
			.getSomeComment()
		);
	}

	@Test
	public void restAssuredCommentsPostTest() {
		CommentAssert.assertThat(
			commentResponseQuery(1, url.urlBuilder())
		).hasPostComment(iComment.postComment());
	}
}
