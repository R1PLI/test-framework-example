package api.helper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UrlHelper {

	private String protocol;
	private String host;
	private String endpoint;

	public String urlBuilder() {
		return protocol + host + endpoint;
	}
}
