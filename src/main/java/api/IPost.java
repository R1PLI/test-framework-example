package api;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
	"classpath:posts.properties"
})
public interface IPost extends Config{
	@Key("post.id")
	long id();
	@Key("title")
	String title();
	@Key("author")
	String author();
}
