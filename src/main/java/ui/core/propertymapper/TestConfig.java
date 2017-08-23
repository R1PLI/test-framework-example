package ui.core.propertymapper;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources({
	"classpath:config.properties"
})
public interface TestConfig extends Config {
	@Key("gmail.url")
	String gmail();
	@Key("google.url")
	String google();
}
