package api.mappers;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
	"classpath:data/posts.properties"
})
public interface IPost extends Config{
	@Key("post.id")
	int id();
	@Key("title")
	String title();
	@Key("author")
	String author();
}
