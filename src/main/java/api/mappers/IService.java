package api.mappers;

import org.aeonbits.owner.Config;

public interface IService extends Config {
	@Key("protocol")
	String protocol();
	@Key("host")
	String host();
	@Key("comments.endpoint")
	String comments();
	@Key("posts.endpoint")
	String posts();
}
