package ui.core.propertymapper;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.Sources;

@Sources({
	"classpath:userdata.properties"
})
public interface UserData extends Config {
	@Key("user.login")
	String login();
	@Key("user.valid.password")
	String password();
	@Key("user.name")
	String name();
}
