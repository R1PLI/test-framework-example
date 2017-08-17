package api.mappers;

import api.beans.Body;
import org.aeonbits.owner.Config;

@Config.Sources({
	"classpath:data/comments.properties"
})
public interface IComment extends Config {
	@Key("post.id")
	int id();
	@Key("body.comment")
	Body bodyComment();
	@Key("post.comment")
	String postComment();
}
