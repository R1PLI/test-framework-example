package api;

import beans.Post;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;

import static beans.PostAssert.assertThat;

public class BaseTest {
	@Test
	public void BasicTest() {
		IPost iPost = ConfigFactory.create(IPost.class);
		Post post = new Post();
		post.setId(iPost.id());
		assertThat(post).hasId(1L);
	}
}
