package org.analogweb.com.github.snowgooseyk.ahmo;

import java.util.List;

import org.analogweb.Headers;
import org.analogweb.MutableRequestContext;
import org.analogweb.RequestPath;
import org.analogweb.core.AbstractApplicationProcessor;

/**
 * @author snowgooseyk
 */
public class HttpMethodOverride extends AbstractApplicationProcessor {

	private static final String X_HTTP_METHOD_OVERRIDE = "X-Http-Method-Override";

	@Override
	public Object preMatching(MutableRequestContext request, RequestPath path) {
		Headers headers;
		if (request.getRequestMethod().equalsIgnoreCase("POST")
				&& (headers = request.getRequestHeaders())
						.contains(X_HTTP_METHOD_OVERRIDE)) {
			List<String> override = headers.getValues(X_HTTP_METHOD_OVERRIDE);
			if (override.isEmpty() == false) {
				request.setRequestMethod(override.get(0));
			}
		}
		return super.preMatching(request, path);
	}

}
