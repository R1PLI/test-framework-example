package api;

import api.beans.BodyAssert;
import api.beans.CommentAssert;
import api.helper.UrlHelper;
import api.mappers.IComment;
import api.mappers.IService;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;

import static api.response.body.PojoFromService.commentsResponseQuery;

public class CommentsTest {
	private static IComment iComment = ConfigFactory.create(IComment.class);
	private static IService iService = ConfigFactory.create(IService.class);
	private static UrlHelper url = new UrlHelper(iService.protocol(), iService.host(), iService.comments());

	@Test
	public void restAssuredCommentsBodyTest() {
		BodyAssert.assertThat(commentsResponseQuery(1, url.urlBuilder())
			.getBody()
		).hasSomeComment(iComment.bodyComment()
			.getSomeComment()
		);
	}

	@Test
	public void restAssuredCommentsPostTest() {
		CommentAssert.assertThat(
			commentsResponseQuery(1, url.urlBuilder())
		).hasPostComment(iComment.postComment());
	}
}
