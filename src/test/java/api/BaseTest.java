package api;

import api.mappers.IPost;
import api.beans.Post;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;

import static api.beans.PostAssert.assertThat;

public class BaseTest {
	@Test
	public void BasicTest() {
		IPost iPost = ConfigFactory.create(IPost.class);
		Post post = new Post();
		post.setId(iPost.id());
		assertThat(post).hasId(1);
	}

	@Test
	public void restAssuredTest() {
		
	}
}
