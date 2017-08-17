package api.helper;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UrlHelper {

	private String protocol;
	private String host;
	private String endpoint;

	public void UrlHelper(String protocol, String host, String endpoint) {
		this.protocol = protocol;
		this.host = host;
		this.endpoint = endpoint;
	}

	public String urlBuilder() {
		return getProtocol() + getHost() + getEndpoint();
	}
}
