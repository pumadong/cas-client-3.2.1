package cas.client.test.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigUtil {
	
	private @Value("${cas.server.url}")String casServerUrl;

	
	public String getCasServerUrl() {
		return casServerUrl;
	}

}
